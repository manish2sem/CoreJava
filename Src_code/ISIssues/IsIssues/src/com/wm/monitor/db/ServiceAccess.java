package com.wm.monitor.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

import com.wm.monitor.common.util.Debug;
import com.wm.monitor.common.util.MonitorUtil;
import com.wm.monitor.db.querygeneration.Column;
import com.wm.monitor.db.querygeneration.CriteriaSet;
import com.wm.monitor.db.querygeneration.Criterion;
import com.wm.monitor.db.querygeneration.DateTime;
import com.wm.monitor.db.querygeneration.Function;
import com.wm.monitor.db.querygeneration.InList;
import com.wm.monitor.db.querygeneration.PSParameter;
import com.wm.monitor.db.querygeneration.Query;
import com.wm.monitor.db.querygeneration.Range;
import com.wm.monitor.db.querygeneration.Table;
import com.wm.util.Values;

public class ServiceAccess extends SingleAccess implements Constants,
		TableConstants {
	public ServiceAccess() {
		super(SVC_AUD);
		initialize();
	}

	private void initialize() {
		Object[] array = { SVC_COL_RCID, SVC_COL_PCID, SVC_COL_CID,
				SVC_COL_AUDTIME, SVC_COL_AUDSTRING, SVC_COL_USRID,
				SVC_COL_RESUBMIT, SVC_COL_DURATION, SVC_COL_SVCNM,
				SVC_COL_STATUS, SVC_COL_STATDECD, SVC_COL_ERRMSG,
				// SVC_COL_PIPE,
				// SVC_COL_SYSDATA,
				SVC_COL_SVRID, SVC_COL_CCID, SVC_COL_APCID };
		SVC_SELECT_COLS = new Vector<Object>(Arrays.asList(array));

		SVC_RECENT_ENTRY = new Criterion(SVC_COL_AUDTIME, Criterion.GTEQ,
				new PSParameter());

		Table tbl1 = new Table(TBLNM_SVC_MINMAX);
		Column col1 = new Column(tbl1, COLNM_LASTTIME);
		Column col2 = new Column(tbl1, COLNM_CID);
		Query qry1 = new Query();
		qry1.addSelectColumn(col1);
		qry1.addFromTable(tbl1);
		qry1.addWhereCriterion(SVC_COL_CID, Criterion.EQ, col2);
		SVC_CURRENT_STATUS = new Criterion(SVC_COL_AUDTIME, Criterion.IN, qry1);

		// WMSERVICECUSTOMFLDS
		Object[] spd_array = { SVCDATA_COL_CID, SVCDATA_COL_SVRID,
				SVCDATA_COL_MSGID, SVCDATA_COL_FLDNM, SVCDATA_COL_FLDALIAS,
				SVCDATA_COL_STRVAL, SVCDATA_COL_NUMVAL, SVCDATA_COL_DATEVAL,
				SVCDATA_COL_AUDTIME, SVCDATA_COL_INPUTFIELD };

		CUSTSVC_SELECT_COLS = new Vector(Arrays.asList(spd_array));
	}

	/*----------------------------
	 * WMSERVICE
	 *--------------------------*/
	// list of standard columns to select from the service table
	public static Vector<Object> SVC_SELECT_COLS = null;
	// gets only entries within the past 14 days
	public static Criterion SVC_RECENT_ENTRY = null;
	// gets the most current audittimestamp for each context id
	public static Criterion SVC_CURRENT_STATUS = null;

	// =====================================================
	// method to see if service is resubmittable based on status
	// =====================================================

	private static String _sResubmitFlag = null;
	private static ListInfo _liResubmitFlag = null;
	private Long minDt = new Long(0);
	private Long maxDt = new Long(0);

	// return true if status of service is complete, failed, or resubmitted
	// (any stopped status), false if service is still running
	public int getResubmitFlag(String contextId) throws SQLException {
		if (_sResubmitFlag == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_RESUBMIT);
			q.addSelectColumn(SVC_COL_PIPE);
			// this part of the query doesn't work in Sybase because Sybase is a
			// backwards db
			// that doesn't let you do IS NULL or IS NOT NULL on IMAGE
			// datatypes, only LIKE.
			// q.addWhereCriterion(SVC_COL_PIPE, Criterion.NOTIS, new
			// Function("NULL"));
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);
			_sResubmitFlag = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getResubmitFlag");
			ps = new ISPreparedStatement(_ds, _sResubmitFlag);
			ps.clearParameters();
			ps.setString(1, contextId);

			BasicList bl = getList(ps, _liResubmitFlag, true);
			if (_liResubmitFlag == null)
				_liResubmitFlag = bl.getListInfo();
			int flag = 0;
			if (bl.getRowCount() > 0) {
				boolean nopipe = true;
				bl.beforeFirst();
				while (nopipe && bl.next()) {
					Object[] row = bl.getRow();
					byte[] pipe = (byte[]) row[bl.getIndex(COLNM_PIPE)];
					if (pipe != null) {
						nopipe = false;
						flag = ((Integer) row[bl.getIndex(COLNM_RESUBMIT)])
								.intValue();
					}
				}
			}
			return flag;
		} catch (SQLException e) {
			// Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	// =====================================================
	// method to see if a service with this id exists in db
	// =====================================================

	private static String _sSvcExists = null;
	private static ListInfo _liSvcExists = null;

	public boolean svcExists(String contextId) throws SQLException {
		if (_sSvcExists == null) {
			Query q = new Query();
			q.setQueryDistinct();
			q.addSelectColumn(SVC_COL_CID);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			_sSvcExists = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "svcExists");
			ps = new ISPreparedStatement(_ds, _sSvcExists);
			ps.clearParameters();
			ps.setString(1, contextId);

			BasicList bl = getList(ps, _liSvcExists);
			if (_liSvcExists == null) {
				_liSvcExists = bl.getListInfo();
			}
			if (bl.getRowCount() > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	// =====================================================
	// method to get services from list of cids (compare to pcid)
	// =====================================================

	/**
	 * Gets a list of services whose parent context IDs are in a specified list.
	 * 
	 * @param CIDList
	 *            list of parent context IDs
	 * @return list of services
	 * @throws SQLException
	 */
	public BasicList getServicefromCIDList(InList CIDList) throws SQLException {
		Query q = new Query(SVC_SELECT_COLS);
		q.addWhereCriterion(SVC_CURRENT_STATUS);
		q.addWhereCriterion(SVC_COL_PCID, Criterion.IN, CIDList);
		q.addOrderByColumn(SVC_COL_AUDTIME, Constants.SORT_DESC);

		Debug.logDebugPlus(4, 201, Debug.DB, "getServicefromCIDList");
		BasicList bl = getList(q.toString());

		return bl;
	}

	/*
	 *  For WMN-2373. Get instance services based on root context ID. This will return 
	 *  the same service record more than once if you resubmit the process
	 *  or step for a particular instance. 
	 */
	public BasicList getServicefromRCIDList(InList RCIDList) throws SQLException {
		Query q = new Query(SVC_SELECT_COLS);
		
		q.addWhereCriterion(SVC_CURRENT_STATUS);
		q.addWhereCriterion(SVC_COL_RCID, Criterion.IN, RCIDList);
		
		Query qry1 = new Query();		
		Table tbl1 = new Table(TBLNM_SVC);
		Column col1 = new Column(tbl1, COLNM_STATUS);	
		Column col2 = new Column(tbl1, COLNM_CID);
		qry1.addSelectFunction("MAX", col1);
		qry1.addFromTable(tbl1);		
		qry1.addWhereCriterion(SVC_COL_CID, Criterion.EQ, col2);
		q.addWhereCriterion(SVC_COL_STATUS, Criterion.IN, qry1);
		q.addOrderByColumn(SVC_COL_AUDTIME, Constants.SORT_DESC);

		Debug.logDebugPlus(4, 201, Debug.DB, "getServicefromRCIDList");
		BasicList bl = getList(q.toString());

		return bl;
	}
	
	
	/*
	 * private static String _sRecentStatus = null; private static ListInfo
	 * _liRecentStatus = null;
	 * 
	 * public BasicList getRecentStatus(Integer statusCode) throws SQLException
	 * { return getRecentStatus(statusCode.intValue()); } public BasicList
	 * getRecentStatus(int statusCode) throws SQLException { if (_sRecentStatus
	 * == null) { Query q = new Query(SVC_SELECT_COLS);
	 * q.addWhereCriterion(SVC_CURRENT_STATUS);
	 * q.addWhereCriterion(SVC_RECENT_ENTRY);
	 * q.addWhereCriterion(SVC_COL_STATUS, Criterion.EQ, new PSParameter());
	 * Debug.logDebugPlus(4, 200, Debug.DB); Debug.logDebugPlus(4, 201,
	 * Debug.DB, q.toString()); Debug.logDebugPlus(4, 202, Debug.DB);
	 * _sRecentStatus = q.toString(); } PreparedStatement ps = null; try { ps =
	 * new ISPreparedStatement(_ds, _sRecentStatus); ps.clearParameters();
	 * ps.setLong(1, DbUtil.getBeginRecent()); ps.setInt(2, statusCode);
	 * 
	 * BasicList bl = getList(ps, _liRecentStatus); if (_liRecentStatus == null)
	 * _liRecentStatus = bl.getListInfo(); return bl; } catch (SQLException e) {
	 * Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e)); throw e;
	 * } finally { if (ps != null) ps.close(); } }
	 */
	// =====================================================
	// method to get pipeline from the most recent started entry for this CID
	// used by getDetails service
	// =====================================================
	private static String _sGetPipeline = null;

	// private static ListInfo _liGetPipeline = null;

	/**
	 * Gets the most recent pipeline logged for a specified service
	 * 
	 * @param contextID
	 *            context ID of the service for which pipeline data is
	 *            requested.
	 * @return byte[] containing the pipeline
	 * @throws SQLException
	 */
	public byte[] getPipeline(String contextID) throws SQLException {
		if (_sGetPipeline == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_PIPE);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			// this part of the query doesn't work in Sybase because Sybase is a
			// backwards db
			// that doesn't let you do IS NULL or IS NOT NULL on IMAGE
			// datatypes, only LIKE.
			// q.addWhereCriterion(SVC_COL_PIPE, Criterion.NOTIS, new
			// Function("NULL"));
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);

			/*
			 * Table tbl1 = new Table(TBLNM_SVC); Column col1 = new Column(tbl1,
			 * COLNM_AUDTIME); Column col2 = new Column(tbl1, COLNM_CID); Column
			 * col3 = new Column(tbl1, COLNM_PIPE); Query qry1 = new Query();
			 * qry1.addSelectFunction("MAX", col1); qry1.addFromTable(tbl1);
			 * qry1.addWhereCriterion(SVC_COL_CID, Criterion.EQ, col2);
			 * qry1.addWhereCriterion(col3, Criterion.NOTIS, new
			 * Function("NULL"));
			 * 
			 * q.addWhereCriterion(SVC_COL_AUDTIME, Criterion.EQ, qry1);
			 */
			_sGetPipeline = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getPipeline");
			ps = new ISPreparedStatement(_ds, _sGetPipeline);
			ps.clearParameters();
			ps.setString(1, contextID);

			return getBytes(ps);
			/*
			 * BasicList bl = getList(ps, _liGetPipeline); if (_liGetPipeline ==
			 * null) _liGetPipeline = bl.getListInfo(); return bl;
			 */} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private static String _sGetSystemData = null;

	// private static ListInfo _liGetSystemData = null;

	/**
	 * Gets the most recent pipeline logged for a specified service
	 * 
	 * @param contextID
	 *            context ID of the service for which pipeline data is
	 *            requested.
	 * @return byte[] containing the pipeline
	 * @throws SQLException
	 */
	public byte[] getSystemData(String contextID) throws SQLException {
		if (_sGetSystemData == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_SYSDATA);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			// this part of the query doesn't work in Sybase because Sybase is a
			// backwards db
			// that doesn't let you do IS NULL or IS NOT NULL on IMAGE
			// datatypes, only LIKE.
			// q.addWhereCriterion(SVC_COL_SYSDATA, Criterion.NOTIS, new
			// Function("NULL"));
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);

			/*
			 * Table tbl1 = new Table(TBLNM_SVC); Column col1 = new Column(tbl1,
			 * COLNM_AUDTIME); Column col2 = new Column(tbl1, COLNM_CID); Column
			 * col3 = new Column(tbl1, COLNM_SYSDATA); Query qry1 = new Query();
			 * qry1.addSelectFunction("MAX", col1); qry1.addFromTable(tbl1);
			 * qry1.addWhereCriterion(SVC_COL_CID, Criterion.EQ, col2);
			 * qry1.addWhereCriterion(col3, Criterion.NOTIS, new
			 * Function("NULL"));
			 * 
			 * q.addWhereCriterion(SVC_COL_AUDTIME, Criterion.EQ, qry1);
			 */
			_sGetSystemData = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getSystemData");
			ps = new ISPreparedStatement(_ds, _sGetSystemData);
			ps.clearParameters();
			ps.setString(1, contextID);

			return getBytes(ps);
			/*
			 * BasicList bl = getList(ps, _liGetSystemData); if
			 * (_liGetSystemData == null) _liGetSystemData = bl.getListInfo();
			 * return bl;
			 */} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	// =====================================================
	// method to get activation id in association table
	// =====================================================

	private static String _sExternalID = null;
	private static ListInfo _liExternalID = null;

	/**
	 * Get external ID associated with a context ID from the WMSERVICEASSOC
	 * table.
	 * 
	 * @param contextId
	 *            ID to get associated ID for
	 * @return BasicList containing context ID and associated external ID
	 * @throws SQLException
	 */
	public BasicList getExternalID(String contextId) throws SQLException {
		if (_sExternalID == null) {
			Query q = new Query();
			q.setQueryDistinct();
			q.addSelectColumn(SVCASSOC_COL_CID);
			q.addSelectColumn(SVCASSOC_COL_EXTID); // this is the activation id
													// for 4x services
			q.addWhereCriterion(SVCASSOC_COL_CID, Criterion.EQ,
					new PSParameter());
			q.addOrderByColumn(SVCASSOC_COL_EXTID, SORT_ASC);

			_sExternalID = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getExternalID");
			ps = new ISPreparedStatement(_ds, _sExternalID);
			ps.clearParameters();
			ps.setString(1, contextId);

			BasicList bl = getList(ps, _liExternalID);
			if (_liExternalID == null)
				_liExternalID = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	/*
	 * private static String _sActivityLogs = null; private static ListInfo
	 * _liActivityLogs = null;
	 * 
	 * public BasicList getActivityLogs(String contextId) throws SQLException {
	 * if (_sActivityLogs == null) { Query q = new Query();
	 * q.addSelectColumn(ACTLOG_COL_ENTRYTYPE);
	 * q.addSelectColumn(ACTLOG_COL_FULLMSG);
	 * q.addSelectColumn(ACTLOG_COL_BRIEFMSG);
	 * q.addSelectColumn(ACTLOG_COL_USR); q.addSelectColumn(ACTLOG_COL_SVRID);
	 * q.addSelectColumn(ACTLOG_COL_AUDTIME);
	 * q.addSelectColumn(ACTLOG_COL_AUDSTRING);
	 * q.addSelectColumn(ACTLOG_COL_CID); q.addWhereCriterion(ACTLOG_COL_CID,
	 * Criterion.EQ, new PSParameter()); q.addOrderByColumn(ACTLOG_COL_AUDTIME,
	 * Constants.SORT_DESC);
	 * 
	 * _sActivityLogs = q.toString(); } PreparedStatement ps = null; try {
	 * Debug.logDebugPlus(4, 201, Debug.DB, "getActivityLogs"); ps = new
	 * ISPreparedStatement(_ds, _sActivityLogs); ps.clearParameters();
	 * ps.setString(1, contextId);
	 * 
	 * BasicList bl = getList(ps, _liActivityLogs); if (_liActivityLogs == null)
	 * _liActivityLogs = bl.getListInfo(); return bl; } catch (SQLException e) {
	 * Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e)); throw e;
	 * } finally { if (ps != null) ps.close(); } }
	 */
	/*
	 * private static String _sActivityLogByPCID = null; private static ListInfo
	 * _liActivityLogByPCID = null;
	 * 
	 * public BasicList getActivityLogByPCID(String contextId) throws
	 * SQLException { if (_sActivityLogByPCID == null) { Query q = new Query();
	 * q.addSelectColumn(ACTLOG_COL_ENTRYTYPE);
	 * q.addSelectColumn(ACTLOG_COL_FULLMSG);
	 * q.addSelectColumn(ACTLOG_COL_BRIEFMSG);
	 * q.addSelectColumn(ACTLOG_COL_USR); q.addSelectColumn(ACTLOG_COL_SVRID);
	 * q.addSelectColumn(ACTLOG_COL_AUDTIME);
	 * q.addSelectColumn(ACTLOG_COL_AUDSTRING);
	 * q.addSelectColumn(ACTLOG_COL_CID); q.addWhereCriterion(ACTLOG_COL_PCID,
	 * Criterion.EQ, new PSParameter()); q.addOrderByColumn(ACTLOG_COL_AUDTIME,
	 * Constants.SORT_DESC);
	 * 
	 * _sActivityLogByPCID = q.toString(); } PreparedStatement ps = null; try {
	 * Debug.logDebugPlus(4, 201, Debug.DB, "getActivityLogByPCID"); ps = new
	 * ISPreparedStatement(_ds, _sActivityLogByPCID); ps.clearParameters();
	 * ps.setString(1, contextId);
	 * 
	 * BasicList bl = getList(ps, _liActivityLogByPCID); if
	 * (_liActivityLogByPCID == null) _liActivityLogByPCID = bl.getListInfo();
	 * return bl; } catch (SQLException e) { Debug.logDebugPlus(2, 0, Debug.DB,
	 * Debug.stackTraceToString(e)); throw e; } finally { if (ps != null)
	 * ps.close(); } }
	 */// =====================================================
	// method to get services in db by CID
	// used by getDetails service
	// =====================================================
	private static String _sDetails = null;
	private static ListInfo _liDetails = null;

	/**
	 * Gets details for a particular service
	 * 
	 * @param contextID
	 *            context ID of the service to get details for
	 * @return BasicList containing info about the service
	 * @throws SQLException
	 */
	public BasicList getDetails(String contextID) throws SQLException {
		if (_sDetails == null) {
			Query q = new Query(SVC_SELECT_COLS);
			q.addWhereCriterion(SVC_CURRENT_STATUS);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);

			_sDetails = q.toString();
		}
		PreparedStatement ps = null;

		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getDetails");
			ps = new ISPreparedStatement(_ds, _sDetails);
			ps.clearParameters();
			ps.setString(1, contextID);

			BasicList bl = getList(ps, _liDetails);
			if (_liDetails == null)
				_liDetails = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}
	
	private static String _sDetailsByContextId = null;
	private static ListInfo _liDetailsByContextId = null;
	
	public BasicList getDetailsByContextId(String contextID)
			throws SQLException {
		if (_sDetailsByContextId == null) {
			Table tbl1 = new Table(TBLNM_SVC);
			Column col1 = new Column(tbl1, COLNM_AUDTIME);
			Column col2 = new Column(tbl1, COLNM_CID);
			Query qry1 = new Query();
			qry1.addSelectFunction("MAX", col1);
			qry1.addFromTable(tbl1);
			qry1.addWhereCriterion(SVC_COL_CID, Criterion.EQ, col2);
			Criterion SVC_CURRENT_STATUS = new Criterion(SVC_COL_AUDTIME,
					Criterion.IN, qry1);

			Query q = new Query(SVC_SELECT_COLS);
			q.addWhereCriterion(SVC_CURRENT_STATUS);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(SVC_COL_STATUS, SORT_DESC);

			_sDetailsByContextId = q.toString();
		}
		PreparedStatement ps = null;

		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getDetails");
			ps = new ISPreparedStatement(_ds, _sDetailsByContextId);
			ps.clearParameters();
			ps.setString(1, contextID);

			BasicList bl = getList(ps, _liDetailsByContextId);
			if (_liDetailsByContextId == null)
				_liDetailsByContextId = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}
	
	
	public static Vector CUSTSVC_SELECT_COLS = null;

	private static String _sWSServiceCustomData = null;
	private static ListInfo _liWSServiceCustomData = null;

	public BasicList getWSCustomData(String contextId, Locale locale)
			throws SQLException {
		if (_sWSServiceCustomData == null) {
			Query q = new Query(CUSTSVC_SELECT_COLS);
			q.setQueryDistinct();
			q.addWhereCriterion(SVCDATA_COL_CID, Criterion.EQ,
					new PSParameter());
			q.addOrderByColumn(SVCDATA_COL_AUDTIME, Constants.SORT_DESC);
			Debug.logDebugPlus(4, 313, Debug.DB, q.toString());
			_sWSServiceCustomData = q.toString();
		}

		PreparedStatement ps = null;
		try {
			ps = new ISPreparedStatement(_ds, _sWSServiceCustomData);
			ps.clearParameters();
			ps.setString(1, contextId);

			BasicList bl = getList(ps, _liWSServiceCustomData, locale);
			if (_liWSServiceCustomData == null)
				_liWSServiceCustomData = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	public BasicList getByContextId(String contextID, Locale locale)
			throws SQLException {
		return getDetails(contextID);
	}

	// andrea calls this
	private static String _sDetailsByParentCID = null;
	private static ListInfo _liDetailsByParentCID = null;

	public BasicList getDetailsByParentCID(String contextID)
			throws SQLException {
		if (_sDetailsByParentCID == null) {
			Query q = new Query(SVC_SELECT_COLS);
			q.addWhereCriterion(SVC_CURRENT_STATUS);
			q.addWhereCriterion(SVC_COL_PCID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);

			_sDetailsByParentCID = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getDetailsByParentCID");
			ps = new ISPreparedStatement(_ds, _sDetailsByParentCID);
			ps.clearParameters();
			ps.setString(1, contextID);

			BasicList bl = getList(ps, _liDetailsByParentCID);
			if (_liDetailsByParentCID == null)
				_liDetailsByParentCID = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private static String _sChildren = null;
	private static ListInfo _liChildren = null;

	public BasicList getChildren(String contextID) throws SQLException {
		if (_sChildren == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_RCID);
			q.addSelectColumn(SVC_COL_PCID);
			q.addSelectColumn(SVC_COL_CID);
			q.addWhereCriterion(SVC_COL_PCID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);

			_sChildren = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getChildren");
			ps = new ISPreparedStatement(_ds, _sChildren);
			ps.clearParameters();
			ps.setString(1, contextID);

			BasicList bl = getList(ps, _liChildren);
			if (_liChildren == null)
				_liChildren = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	// =====================================================
	// method to get services in db by CID and show all entries
	// used by getDetailsAll service
	// =====================================================

	private static String _sHistory = null;
	private static ListInfo _liHistory = null;

	/**
	 * Gets all rows for a service, not just the most recent status
	 * 
	 * @param contextID
	 *            contextID for desired service
	 * @return BasicList containing service history details
	 * @throws SQLException
	 */
	public BasicList getHistory(String contextID) throws SQLException {
		if (_sHistory == null) {
			Query q = new Query(SVC_SELECT_COLS);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);

			_sHistory = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getHistory");
			ps = new ISPreparedStatement(_ds, _sHistory);
			ps.clearParameters();
			ps.setString(1, contextID);

			BasicList bl = getList(ps, _liHistory,true);
			if (_liHistory == null)
				_liHistory = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	// =====================================================
	// method to get services in db by CID, status and time
	// =====================================================

	/*
	 * private static String _sGetHistoricalEntry = null; private static
	 * ListInfo _liGetHistoricalEntry = null;
	 * 
	 * public BasicList getHistoricalEntry(String contextId, int status, Long
	 * time, Locale locale) throws SQLException { if (_sGetHistoricalEntry ==
	 * null) { Query q = new Query(SVC_SELECT_COLS);
	 * q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
	 * q.addWhereCriterion(SVC_COL_STATUS, Criterion.EQ, new PSParameter());
	 * q.addWhereCriterion(SVC_COL_AUDTIME, Criterion.EQ, new PSParameter());
	 * 
	 * _sGetHistoricalEntry = q.toString(); } PreparedStatement ps = null; try {
	 * Debug.logDebugPlus(4, 201, Debug.DB, "getHistoricalEntry"); ps = new
	 * ISPreparedStatement(_ds, _sGetHistoricalEntry); ps.clearParameters();
	 * ps.setString(1, contextId); ps.setInt(2, status); ps.setLong(3,
	 * time.longValue());
	 * 
	 * BasicList bl = getList(ps, _liGetHistoricalEntry, locale); if
	 * (_liGetHistoricalEntry == null) _liGetHistoricalEntry = bl.getListInfo();
	 * return bl; } catch (SQLException e) { Debug.logDebugPlus(2, 0, Debug.DB,
	 * Debug.stackTraceToString(e)); throw e; } finally { if (ps != null)
	 * ps.close(); } }
	 */
	/*
	 * private static PreparedStatement _psByParentContextId = null; private
	 * static ListInfo _liByParentContextId = null;
	 * 
	 * public BasicList getByParentContextId(String parentContextId) throws
	 * SQLException { if (_psByParentContextId == null) { Query q = new
	 * Query(SVC_SELECT_COLS); q.addWhereCriterion(SVC_CURRENT_STATUS);
	 * q.addWhereCriterion(SVC_COL_PCID, Criterion.EQ, new PSParameter());
	 * Debug.logDebugPlus(200, Debug.DB); Debug.logDebugPlus(201, Debug.DB,
	 * q.toString()); Debug.logDebugPlus(202, Debug.DB); _psByParentContextId =
	 * _conn.prepareStatement(q.toString()); }
	 * _psByParentContextId.clearParameters(); _psByParentContextId.setString(1,
	 * parentContextId);
	 * 
	 * BasicList bl = getList(_psByParentContextId, _liByParentContextId);
	 * 
	 * if (_liByParentContextId == null) _liByParentContextId =
	 * bl.getListInfo();
	 * 
	 * return bl; }
	 */
	/*
	 * private static PreparedStatement _psByRootContextId = null; private
	 * static ListInfo _liByRootContextId = null;
	 * 
	 * public BasicList getByRootContextId(String rootContextId) throws
	 * SQLException { if (_psByRootContextId == null) { Query q = new
	 * Query(SVC_SELECT_COLS); q.addWhereCriterion(SVC_CURRENT_STATUS);
	 * q.addWhereCriterion(SVC_COL_RCID, Criterion.EQ, new PSParameter());
	 * Debug.logDebugPlus(200, Debug.DB); Debug.logDebugPlus(201, Debug.DB,
	 * q.toString()); Debug.logDebugPlus(202, Debug.DB); _psByRootContextId =
	 * _conn.prepareStatement(q.toString()); }
	 * _psByRootContextId.clearParameters(); _psByRootContextId.setString(1,
	 * rootContextId);
	 * 
	 * BasicList bl = getList(_psByRootContextId, _liByRootContextId);
	 * 
	 * if (_liByRootContextId == null) _liByRootContextId = bl.getListInfo();
	 * 
	 * return bl; }
	 */
	/*
	 * private static PreparedStatement _psStatistics = null; private static
	 * ListInfo _liStatistics = null;
	 * 
	 * public BasicList getStatistics() throws SQLException { if (_psStatistics
	 * == null) { Function f = new Function("COUNT", SVC_COL_STATUS,
	 * COLNM_COUNT); Object[] array = { SVC_COL_SVCNM, SVC_COL_STATUS,
	 * SVC_COL_STATDECD, f }; Query q = new Query(new
	 * Vector(Arrays.asList(array))); q.addWhereCriterion(SVC_CURRENT_STATUS);
	 * q.addGroupByColumn(SVC_COL_SVCNM); q.addGroupByColumn(SVC_COL_STATUS);
	 * Debug.logDebugPlus(200, Debug.DB); Debug.logDebugPlus(201, Debug.DB,
	 * q.toString()); Debug.logDebugPlus(202, Debug.DB); _psStatistics =
	 * _conn.prepareStatement(q.toString()); } BasicList bl =
	 * getList(_psStatistics, _liStatistics);
	 * 
	 * if (_liStatistics == null) _liStatistics = bl.getListInfo();
	 * 
	 * return bl; }
	 */
	// =====================================================
	// method to retrieve the errors in WmError for a particular
	// process step based on the specified cid
	// =====================================================
	private static String _sError = null;
	private static ListInfo _liError = null;

	/**
	 * Gets any errors associated with the specified context ID.
	 * 
	 * @param contextID
	 * @return
	 * @throws SQLException
	 */
	public BasicList getError(String contextID) throws SQLException {
		if (_sError == null) {
			Query q = new Query();
			q.addSelectColumn(ERR_COL_AUDSTRING);
			q.addSelectColumn(ERR_COL_SVRID);
			q.addSelectColumn(ERR_COL_ERRSTACK);
			q.addWhereCriterion(ERR_COL_CID, Criterion.EQ, new PSParameter());
			q.addOrderByColumn(ERR_COL_AUDTIME, Constants.SORT_DESC);

			_sError = q.toString();
		}
		PreparedStatement ps = null;
		try {
			Debug.logDebugPlus(4, 201, Debug.DB, "getError");
			ps = new ISPreparedStatement(_ds, _sError);
			ps.clearParameters();
			ps.setString(1, contextID);

			BasicList bl = getList(ps, _liError, true);
			if (_liError == null)
				_liError = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private static String _sStepActLog = null;
	private static ListInfo _liStepActLog = null;

	public BasicList getStepActLog(String uuid) throws SQLException {
		if (_sStepActLog == null) {
			Query q = new Query();
			q.setQueryDistinct();
			q.addSelectColumn(ACTLOG_COL_PCID);
			q.addSelectColumn(ACTLOG_COL_CID);
			q.addSelectColumn(ACTLOG_COL_PROCSTEPCID);
			q.addSelectColumn(new Column(TBL_ACTLOG, COLNM_PROCSTEPCID,
					COLNM_STEPLABEL));
			q.addSelectColumn(ACTLOG_COL_ENTRYTYPE);
			q.addSelectColumn(ACTLOG_COL_FULLMSG);
			q.addSelectColumn(ACTLOG_COL_BRIEFMSG);
			q.addSelectColumn(ACTLOG_COL_SVRID);
			q.addSelectColumn(ACTLOG_COL_USR);
			q.addSelectColumn(ACTLOG_COL_AUDTIME);
			q.addSelectColumn(ACTLOG_COL_AUDSTRING);
			q.addWhereCriterion(ACTLOG_COL_PROCSTEPCID, Criterion.EQ,
					new PSParameter());
			Debug.logDebugPlus(4, 200, Debug.DB);
			Debug.logDebugPlus(4, 201, Debug.DB, q.toString());
			Debug.logDebugPlus(4, 202, Debug.DB);
			_sStepActLog = q.toString();
		}
		PreparedStatement ps = null;
		try {
			ps = new ISPreparedStatement(_ds, _sStepActLog);
			ps.clearParameters();
			ps.setString(1, uuid);

			BasicList bl = getList(ps, _liStepActLog);
			if (_liStepActLog == null)
				_liStepActLog = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	/**
	 * Gets a list of services based on various parameters.
	 * 
	 * @param rootContextID
	 *            root context ID to search on. If null, not used as a
	 *            criterion.
	 * @param parentContextID
	 *            parent context ID to search on. If null, not used as a
	 *            criterion.
	 * @param contextID
	 *            context ID to search on. If null, not used as a criterion.
	 * @param svcName
	 *            service name to search on. If null, not used as a criterion.
	 *            Used in conjunction with svcNameExact.
	 * @param svcNameExact
	 *            if true, do an exact match on svcName. Otherwise, search for
	 *            any service name that has svcName as a substring. This is not
	 *            a pattern matching search, it searches only for substrings.
	 * @param svrID
	 *            server ID to search on. If null, not used as a criterion. Used
	 *            in conjunction with svrIDExact.
	 * @param svrIDExact
	 *            if true, do an exact match on svrID. Otherwise, search for any
	 *            server ID that has svrID as a substring. This is not a pattern
	 *            matching search, it searches only for substrings.
	 * @param predefRange
	 *            identifies a predefined range of times to search on, e.g.
	 *            Today.
	 * @param afterTime
	 *            search for services logged after this time. If 0, not used as
	 *            a criterion.
	 * @param beforeTime
	 *            search for services logged before this time. If 0, not used as
	 *            a criterion.
	 * @param status
	 *            status to search on. If 0, not used as a criterion.
	 * @param maxRows
	 *            maximum rows to return.
	 * @return BasicList that contains info about all services that meet the
	 *         specified criteria.
	 * @throws SQLException
	 */

	private static String _sGetList = null;
	private static ListInfo _liGetList = null;

	public BasicList getList(String rootContextID, String parentContextID,
			String contextID, String customContextID, String svcName,
			boolean svcNameExact, String svrID, boolean svrIDExact,
			String username, String predefRange, Long afterTime,
			Long beforeTime, int[] status, int maxRows, boolean isAnd)
			throws SQLException {
		if ((predefRange != null) && (predefRange.length() != 0)) {
			Range range = MonitorUtil.createDateRangeString(predefRange);
			afterTime = (Long) ((range.getBegin()).getValue());
			beforeTime = (Long) ((range.getEnd()).getValue());
		}

		String query = generateListSQL(rootContextID, parentContextID,
				contextID, customContextID, svcName, svcNameExact, svrID,
				svrIDExact, username, predefRange, afterTime, beforeTime,
				status, maxRows, isAnd);

		PreparedStatement ps = null;
		try {
			int paramCount = 1;
			_sGetList = query.toString();

			ps = new ISPreparedStatement(_ds, _sGetList);
			ps.clearParameters();

			if (afterTime.longValue() > 0)
				ps.setTimestamp(paramCount++, new Timestamp(MonitorUtil.getLocalTime(afterTime)));

			if (beforeTime.longValue() > 0)
				ps.setTimestamp(paramCount++, new Timestamp(MonitorUtil.getLocalTime(beforeTime)));

			BasicList bl = getList(ps, _liGetList, maxRows);
			if (_liGetList == null)
				_liGetList = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}

		// return getList(query, maxRows);
	}

	public String generateListSQL(String rootContextID, String parentContextID,
			String contextID, String customContextID, String svcName,
			boolean svcNameExact, String svrID, boolean svrIDExact,
			String username, String predefRange, Long afterTime,
			Long beforeTime, int[] status, int maxRows, boolean isAnd) {
		Query q = new Query();
		q.setQueryDistinct();
		q.addSelectColumn(SVC_COL_RCID);
		q.addSelectColumn(SVC_COL_PCID);
		q.addSelectColumn(SVC_COL_CID);
		q.addSelectColumn(SVC_COL_SVCNM);
		q.addSelectColumn(SVC_COL_SVRID);
		q.addSelectColumn(SVC_COL_USRID);
		q.addSelectColumn(SVC_MINMAX_FIRSTSTATUS);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_FIRSTSTATUS,
				COLNM_FIRSTSTATDECD));
		q.addSelectColumn(SVC_MINMAX_FIRSTTIME);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_FIRSTTIME,
				COLNM_FIRSTTIMESTRING));
		q.addSelectColumn(SVC_MINMAX_LASTSTATUS);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_LASTSTATUS,
				COLNM_LASTSTATDECD));
		q.addSelectColumn(SVC_MINMAX_LASTTIME);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_LASTTIME,
				COLNM_LASTTIMESTRING));
		q.addSelectColumn(SVC_MINMAX_DURATION);
		q.addSelectColumn(SVC_COL_CID);		

		q.addWhereCriterion(SVC_MINMAX_COL_CID, Criterion.EQ, SVC_COL_CID);
		q.addWhereCriterion(SVC_COL_AUDTIME, Criterion.EQ, SVC_MINMAX_LASTTIME);
		CriteriaSet cs = new CriteriaSet();
		if (!isAnd)
			cs.setOperator(CriteriaSet.OR_OP);

		if ((rootContextID != null) && (rootContextID.length() > 0))
			cs.addCriterion(SVC_COL_RCID, Criterion.EQ, rootContextID.trim());
		if ((parentContextID != null) && (parentContextID.length() > 0))
			cs.addCriterion(SVC_COL_PCID, Criterion.EQ, parentContextID.trim());
		if ((contextID != null) && (contextID.length() > 0))
			cs.addCriterion(SVC_COL_CID, Criterion.EQ, contextID.trim());
		if ((customContextID != null) && (customContextID.length() > 0))
			cs.addCriterion(SVC_COL_CCID, Criterion.EQ, customContextID.trim());
		if ((username != null) && (username.length() > 0))
			cs.addCriterion(new Function("UPPER", SVC_COL_USRID),
					Criterion.LIKE, (username.trim()).toUpperCase());

		if ((svcName != null) && (svcName.length() != 0)) {
			if (svcNameExact)
				cs.addCriterion(SVC_COL_SVCNM, Criterion.EQ, svcName.trim());
			else
				cs.addCriterion(new Function("UPPER", SVC_COL_SVCNM),
						Criterion.LIKE, "%" + (svcName.trim()).toUpperCase()
								+ "%");
		}

		if ((svrID != null) && (svrID.length() != 0)) {
			if (svrIDExact)
				cs.addCriterion(SVC_COL_SVRID, Criterion.EQ, svrID.trim());
			else
				cs.addCriterion(new Function("UPPER", SVC_COL_SVRID),
						Criterion.LIKE, "%" + (svrID.trim()).toUpperCase()
								+ "%");
		}

		// if ((predefRange != null) && (predefRange.length() != 0))
		// {
		// cs.addCriterion(SVC_COL_AUDTIME, Criterion.BETW,
		// MonitorUtil.createDateRangeString(predefRange));
		// }

		CriteriaSet dateCS = new CriteriaSet();
		if (afterTime.longValue() > 0)
			// dateCS.addCriterion(SVC_COL_AUDTIME, Criterion.GTEQ, afterTime);
			dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.GTEQ,
					new PSParameter());
		if (beforeTime.longValue() > 0)
			// dateCS.addCriterion(SVC_COL_AUDTIME, Criterion.LTEQ, beforeTime);
			dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.LTEQ,
					new PSParameter());

		if (dateCS.getCriteriaSize() > 0)
			cs.addCriteria(dateCS);

		if (status != null && status.length > 0) {
			InList il = MonitorUtil.createInList(status);
			if (!il.isEmpty())
				cs.addCriterion(SVC_MINMAX_LASTSTATUS, Criterion.IN, il);
		}

		if (cs.getCriteriaSize() > 0)
			q.addWhereCriteria(cs);
		q.addOrderByColumn(SVC_MINMAX_LASTTIME, SORT_DESC);
		
		return q.toString();
	}

	static Table t1 = TBL_SVC;
	static Table t2 = new Table(TBLNM_SVC);
	static Table t3 = new Table(TBLNM_SVC);
	static Table tblFirst = new Table(TBLNM_SVC);
	static Table tblLast = new Table(TBLNM_SVC);
	static Table tblSpan = new Table(TBLNM_SVC);
	static Query queryFirst = null;
	static Query queryLast = null;
	static Query querySpan = null;
	static Query queryMin = null;
	static Query queryMax = null;
	static Column t2_COL_AUDTIME = new Column(t2, COLNM_AUDTIME);

	public static java.util.Date fromString(String source, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
	    return sdf.parse(source, new ParsePosition(0));
	}
	private static String _sGetWSList = null;
	private static ListInfo _liGetWSList = null;

	public BasicList getWsList(String keyword, String serviceName,
			String serverId, int[] status, String range, Long fromDate,
			Long toDate, boolean filterOnLast, String username,
			String rootContextId, String parentContextId, String contextId,
			String customContextId, com.wm.util.Table customData,
			boolean rootLevelOnly, int maxRows, boolean isAnd,
			String fullmessage) throws SQLException {

		if (queryMin == null) {
			queryMin = new Query();
			queryMin.addSelectFunction("MIN", new Column(tblFirst,
					COLNM_AUDTIME));
			queryMin.addFromTable(tblFirst);

			queryMax = new Query();
			queryMax.addSelectFunction("MAX",
					new Column(tblLast, COLNM_AUDTIME));
			queryMax.addFromTable(tblLast);

		}

		Query q = new Query();
		q.setQueryDistinct();
		q.addSelectColumn(SVC_COL_RCID);
		q.addSelectColumn(SVC_COL_PCID);
		q.addSelectColumn(SVC_COL_CID);
		q.addSelectColumn(SVC_COL_SVCNM);
		q.addSelectColumn(SVC_COL_SVRID);
		q.addSelectColumn(SVC_COL_USRID);
		q.addSelectColumn(SVC_MINMAX_FIRSTSTATUS);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_FIRSTSTATUS,
				COLNM_FIRSTSTATDECD));
		q.addSelectColumn(SVC_MINMAX_FIRSTTIME);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_FIRSTTIME,
				COLNM_FIRSTTIMESTRING));
		q.addSelectColumn(SVC_MINMAX_LASTSTATUS);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_LASTSTATUS,
				COLNM_LASTSTATDECD));
		q.addSelectColumn(SVC_MINMAX_LASTTIME);
		q.addSelectColumn(new Column(TBL_SVC_MINMAX, COLNM_LASTTIME,
				COLNM_LASTTIMESTRING));
		q.addSelectColumn(SVC_MINMAX_DURATION);
		q.addSelectColumn(SVC_COL_CCID);		

		q.addWhereCriterion(SVC_MINMAX_COL_CID, Criterion.EQ, SVC_COL_CID);
		q.addWhereCriterion(SVC_COL_AUDTIME, Criterion.EQ, SVC_MINMAX_LASTTIME);

		if (rootLevelOnly)
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, SVC_COL_RCID);

		CriteriaSet cs = new CriteriaSet();
		if (!isAnd)
			cs.setOperator(CriteriaSet.OR_OP);

		if ((keyword != null) && (keyword.length() != 0)) {
			CriteriaSet kw = new CriteriaSet();
			kw.setOperator(CriteriaSet.OR_OP);

			Collection<String> keywds = MonitorUtil.parseKeywordField(keyword);
			Iterator iter = keywds.iterator();
			while (iter.hasNext()) {
				String keywdphrase = (String) iter.next();
				kw.addCriterion(new Function("UPPER", SVC_COL_SVCNM),
						Criterion.LIKE, keywdphrase.toUpperCase());
				kw.addCriterion(new Function("UPPER", SVC_COL_CID),
						Criterion.LIKE, keywdphrase.toUpperCase());
				kw.addCriterion(new Function("UPPER", SVC_COL_CCID),
						Criterion.LIKE, keywdphrase.toUpperCase());
			}
			cs.addCriteria(kw);
		}

		if ((rootContextId != null) && (rootContextId.length() > 0))
			cs.addCriterion(SVC_COL_RCID, Criterion.EQ, rootContextId.trim());
		if ((parentContextId != null) && (parentContextId.length() > 0))
			cs.addCriterion(SVC_COL_PCID, Criterion.EQ, parentContextId.trim());
		//wmn-5515-search on both contextid or custom contextid fields
		if ((contextId != null) && (contextId.length() > 0)){
			CriteriaSet kw = new CriteriaSet();
			kw.setOperator(CriteriaSet.OR_OP);

			kw.addCriterion(SVC_COL_CID, Criterion.EQ, contextId.trim());
		
			if ((customContextId != null) && (customContextId.length() > 0))
				kw.addCriterion(SVC_COL_CCID, Criterion.EQ, customContextId.trim());
			else
				kw.addCriterion(SVC_COL_CCID, Criterion.EQ, contextId.trim());
			
			cs.addCriteria(kw);
		}
		if ((customContextId != null) && (customContextId.length() > 0))
			cs.addCriterion(SVC_COL_CCID, Criterion.EQ, customContextId.trim());

		if ((fullmessage != null) && (fullmessage.length() > 0)) {
			q.addSelectColumn(ACTLOG_COL_FULLMSG);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, ACTLOG_COL_CID);
			cs.addCriterion(new Function("UPPER", ACTLOG_COL_FULLMSG),
					Criterion.LIKE, "%" + (fullmessage.trim()).toUpperCase()
							+ "%");
		}

		if ((username != null) && (username.length() > 0))
			cs
					.addCriterion(new Function("UPPER", SVC_COL_USRID),
							Criterion.LIKE, "%"
									+ (username.trim()).toUpperCase() + "%");

		if ((serviceName != null) && (serviceName.length() != 0))
			cs.addCriterion(new Function("UPPER", SVC_COL_SVCNM),
					Criterion.LIKE, "%" + (serviceName.trim()).toUpperCase()
							+ "%");

		if ((serverId != null) && (serverId.length() != 0))
			cs
					.addCriterion(new Function("UPPER", SVC_COL_SVRID),
							Criterion.LIKE, "%"
									+ (serverId.trim()).toUpperCase() + "%");

		CriteriaSet dateCS = new CriteriaSet();
		if (!filterOnLast) // means search on start time
		{
			if ((range != null) && (range.trim().length() != 0)) {
				if (range.toUpperCase().equals(MonitorUtil.TIME_ALL)) {
					fromDate = new Long(0);
					toDate = new Long(0);
				} else {
					// cs.addCriterion(SVC_COL_AUDTIME, Criterion.BETW,
					// MonitorUtil.createDateRangeString(range));
					Range rangedt = MonitorUtil.createDateRangeString(range);
					fromDate = (Long) rangedt.getBegin().getValue();
					toDate = (Long) rangedt.getEnd().getValue();
				}
			} else {
				if ((!(toDate != null && toDate.longValue() > 0))
						|| (!(fromDate != null && fromDate.longValue() > 0)))
					// minDt = new
					// Long(((Number)getValue(queryMin.toString())).longValue());
					minDt = new Long(
							((Timestamp) getValue(queryMin.toString()))
									.getTime());
				    maxDt = new Long(
						((Timestamp) getValue(queryMax.toString()))
								.getTime());
				    
				if (!(toDate != null && toDate.longValue() > 0)) {
					toDate = maxDt;
				}
				if (!(fromDate != null && fromDate.longValue() > 0)) {
					if (minDt.longValue() > 0)
						fromDate = new Long(minDt.longValue()
								- (24 * 60 * 60 * 1000));
				}
				if (fromDate.longValue() >= 9999999999999L) { // WMN-1856: Fetch
																// All records
					fromDate = new Long(0);
					toDate = new Long(0);
				}
			}
			if (fromDate.longValue() > 0)
				// dateCS.addCriterion(SVC_MINMAX_FIRSTTIME, Criterion.GTEQ,
				// fromDate);
				dateCS.addCriterion(SVC_MINMAX_FIRSTTIME, Criterion.GTEQ,
						new PSParameter());
			if (toDate.longValue() > 0)
				// dateCS.addCriterion(SVC_MINMAX_FIRSTTIME, Criterion.LTEQ,
				// toDate);
				dateCS.addCriterion(SVC_MINMAX_FIRSTTIME, Criterion.LTEQ,
						new PSParameter());

			if (dateCS.getCriteriaSize() > 0)
				cs.addCriteria(dateCS);
		} else { // default to searching on last updated time
			if ((range != null) && (range.trim().length() != 0)) {
				if (range.toUpperCase().equals(MonitorUtil.TIME_ALL)) {
					fromDate = new Long(0);
					toDate = new Long(0);
				} else {
					// cs.addCriterion(SVC_COL_AUDTIME, Criterion.BETW,
					// MonitorUtil.createDateRangeString(range));
					Range rangedt = MonitorUtil.createDateRangeString(range);
					fromDate = (Long) rangedt.getBegin().getValue();
					toDate = (Long) rangedt.getEnd().getValue();
				}
			} else {
				if ((!(toDate != null && toDate.longValue() > 0))
						|| (!(fromDate != null && fromDate.longValue() > 0))) {
					Object obj = getValue(queryMax.toString());
					if (obj == null) {
						return null;
					}
					// maxDt = new
					// Long(((Number)getValue(queryMax.toString())).longValue());
					maxDt = new Long(
							((Timestamp) getValue(queryMax.toString()))
									.getTime());
					minDt = new Long(
							((Timestamp) getValue(queryMin.toString()))
									.getTime());
				}
				if (!(toDate != null && toDate.longValue() > 0)) {
					toDate = maxDt;
				}
				if (!(fromDate != null && fromDate.longValue() > 0)) {
					if (minDt.longValue() > 0)
						fromDate = new Long(minDt.longValue()
								- (24 * 60 * 60 * 1000));
				}
				if(fromDate.longValue() >= 9999999999999L) { //WMN-1856/WMN-1756: Fetch All records
					fromDate = new Long(0);
					toDate = new Long(0);
				}
			}

			if (fromDate.longValue() > 0)
				// dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.GTEQ,
				// fromDate);
				dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.GTEQ,
						new PSParameter());
			if (toDate.longValue() > 0)
				// dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.LTEQ,
				// toDate);
				dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.LTEQ,
						new PSParameter());

			if (dateCS.getCriteriaSize() > 0)
				cs.addCriteria(dateCS);
		}

		boolean custTableAdded = false;
		if (customData != null && customData.getRowCount() > 0) {
			CriteriaSet csFilter = new CriteriaSet();
			csFilter.setOperator(CriteriaSet.OR_OP);
			if(customData.getRowCount() > 0)
				q.addFromTable(TBL_SVCDATA);
			
			Query sq = null ;
			for (int i = 0; i < customData.getRowCount(); i++) {
				CriteriaSet cs2 = new CriteriaSet();
				Values row = customData.getRow(i);
				String fieldAlias = (String) row.getValue("fieldName");
				String fieldType = (String) row.getValue("fieldType");
				String operator = (String) row.getValue("fieldOp");
				String value = (String) row.getValue("value");
				
				Column svcdataColFldalias = SVCDATA_COL_FLDALIAS;
				Column svcdataColStrval = SVCDATA_COL_STRVAL;
				Column svcdataColDateval = SVCDATA_COL_DATEVAL;
				Column svcdataColNumval = SVCDATA_COL_NUMVAL;
				
				custTableAdded = true;
				Query sq1 = new Query();
				if(isAnd){
					sq1.addFromTable(TBL_SVCDATA_4AND);
					sq1.addWhereCriterion(new Criterion(SVCDATA_COL_CID, Criterion.EQ, SVCDATA_COL_CID_4AND));
					svcdataColFldalias = SVCDATA_COL_FLDALIAS_4AND;
					svcdataColStrval = SVCDATA_COL_STRVAL_4AND;
					svcdataColDateval = SVCDATA_COL_DATEVAL_4AND;
					svcdataColNumval = SVCDATA_COL_NUMVAL_4AND;
				}
				
				
				cs2.addCriterion(new Function("UPPER", svcdataColFldalias),Criterion.EQ, fieldAlias.toUpperCase());

				if (value == null)
					value = "";
				if (fieldType == null)
					fieldType = "";
				if (operator == null)
					operator = "";

				value = value.trim();
				
				CriteriaSet cs3 = new CriteriaSet();
				cs3.setOperator(CriteriaSet.OR_OP);
				if(operator.equals("Contains")) {
					cs3.addCriterion(new Function("UPPER",
							svcdataColStrval), Criterion.LIKE, "%"
							+ value.toUpperCase() + "%");
				}
				else if(operator.equals("NotContains")) {
					cs3.addCriterion(new Function("UPPER",
							svcdataColStrval), Criterion.NOTLIKE, "%"
							+ value.toUpperCase() + "%");
				} else if (operator.equals("=")) {
					cs3.addCriterion(svcdataColStrval, Criterion.EQ,
							value);
					try {
						cs3.addCriterion(svcdataColNumval, Criterion.EQ,
							new Float(value));
					} catch (NumberFormatException e) {
						
					}
					java.util.Date d = null;
					try {
						d = fromString(value, "yyyy-MM-dd HH:mm:ss");
						if(d != null) {
							cs3.addCriterion(svcdataColDateval,
							Criterion.BETW, new Range(value));
						} else {
							try {
								d = fromString(value, "yyyy-MM-dd");
							} catch (ParseException pe) {}
							if(d != null) {
								cs3.addCriterion(svcdataColDateval,
								Criterion.BETW, new Range(value));
							} 
						}
					} catch (ParseException e) {
						try {
							d = fromString(value, "yyyy-MM-dd");
						} catch (ParseException pe) {}
						if(d != null) {
							cs3.addCriterion(svcdataColDateval,
							Criterion.BETW, new Range(value));
						} 
					}
				} else if (operator.equals("!=")) {
					cs3.addCriterion(svcdataColStrval, Criterion.EQ,
							value);
					try {
						cs3.addCriterion(svcdataColNumval, operator,
							new Float(value));
					} catch (NumberFormatException e) {}
					try {
						cs3.addCriterion(svcdataColNumval, Criterion.EQ,
							new Float(value));
					} catch (NumberFormatException e) {}
					java.util.Date d = null;
					try {
						d = fromString(value, "yyyy-MM-dd HH:mm:ss");
						if(d != null) {
							cs3.addCriterion(svcdataColDateval,
							Criterion.NOTBETW, new Range(value));
						} else {
							try {
								d = fromString(value, "yyyy-MM-dd");
							} catch (ParseException pe) {}
							if(d != null) {
								cs3.addCriterion(svcdataColDateval,
								Criterion.NOTBETW, new Range(value));
							} 
						}
					} catch (ParseException e) {
						try {
							d = fromString(value, "yyyy-MM-dd");
						} catch (ParseException pe) {}
						if(d != null) {
							cs3.addCriterion(svcdataColDateval,
							Criterion.NOTBETW, new Range(value));
						} 
					}
				} else  {
					cs3.addCriterion(svcdataColStrval, operator,
							value);
					try {
						cs3.addCriterion(svcdataColNumval, operator,
							new Float(value));
					} catch (NumberFormatException e) {}
				}
				/*if (fieldType.equals("String")) {
					if (operator.equals("Contains")) {
						cs2.addCriterion(new Function("UPPER",
								svcdataColStrval), Criterion.LIKE, "%"
								+ value.toUpperCase() + "%");
					}
					if (operator.equals("=")) {
						cs2.addCriterion(svcdataColStrval, Criterion.EQ,
								value);
					}
					if (operator.equals("NotContains")) {
						cs2.addCriterion(new Function("UPPER",
								svcdataColStrval), Criterion.NOTLIKE, "%"
								+ value.toUpperCase() + "%");
					}
				} else if (fieldType.equals("Date")) {
					if (value.indexOf(' ') == -1) {
						if (operator.equals("=")) {
							cs2.addCriterion(svcdataColDateval,
									Criterion.BETW, new Range(value));
						} else if (operator.equals("!=")) {
							cs2.addCriterion(svcdataColDateval,
									Criterion.NOTBETW, new Range(value));
						} else {
							cs2.addCriterion(svcdataColDateval, operator,
									new DateTime(value));
						}
					}
				} else if (fieldType.equals("Number")) {
					cs2.addCriterion(svcdataColNumval, operator, new Float(
							value));
				}*/
				cs2.addCriteria(cs3);
				if(isAnd){
					sq1.addWhereCriteria(cs2);
					if(sq == null && i==0){
						sq = sq1;
					}else{
						Criterion cri = new Criterion(null, Criterion.EXIST, sq1);
						sq.addWhereCriterion(cri);
					}

				}else{

					if ( cs2.getCriteriaSize() > 0) {
						csFilter.addCriteria(cs2);
					} 
				}
			}
			if(isAnd){
				Criterion cri = new Criterion(null, Criterion.EXIST, sq);
				csFilter.addCriterion(cri);
			}
			if (csFilter.getCriteriaSize() > 0)
				cs.addCriteria(csFilter);
		}

		if (custTableAdded) {
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, SVCDATA_COL_CID);
		}

		if (status != null && status.length > 0) {
			InList il = MonitorUtil.createInList(status);
			if (!il.isEmpty())
				cs.addCriterion(SVC_MINMAX_LASTSTATUS, Criterion.IN, il);
		}

		if (cs.getCriteriaSize() > 0)
			q.addWhereCriteria(cs);

		// rwellman 20060314: Fix for 1-11DTYH to sort results before clipping
		// for max results
		if (!filterOnLast) // means search on start time
		{
			q.addOrderByColumn(SVC_MINMAX_FIRSTTIME, SORT_ASC);
		} else {
			q.addOrderByColumn(SVC_MINMAX_LASTTIME, SORT_DESC);
		}

		PreparedStatement ps = null;
		try {
			int paramCount = 1;
			_sGetWSList = q.toString();
			ps = new ISPreparedStatement(_ds, _sGetWSList);
			ps.clearParameters();

			if (fromDate.longValue() > 0)
				ps.setTimestamp(paramCount++, new Timestamp(fromDate));

			if (toDate.longValue() > 0)
				ps.setTimestamp(paramCount++, new Timestamp(toDate));

			BasicList bl = getList(ps, _liGetWSList, maxRows);
			if (_liGetWSList == null)
				_liGetWSList = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}

		// return getList(q.toString(), maxRows);
	}
	
	public int getWsListCount(String keyword, String serviceName,
			String serverId, int[] status, String range, Long fromDate,
			Long toDate, boolean filterOnLast, String username,
			String rootContextId, String parentContextId, String contextId,
			String customContextId, com.wm.util.Table customData,
			boolean rootLevelOnly, boolean isAnd, String fullmessage)
			throws SQLException {

		if (queryMin == null) {
			queryMin = new Query();
			queryMin.addSelectFunction("MIN", new Column(tblFirst,
					COLNM_AUDTIME));
			queryMin.addFromTable(tblFirst);

			queryMax = new Query();
			queryMax.addSelectFunction("MAX",
					new Column(tblLast, COLNM_AUDTIME));
			queryMax.addFromTable(tblLast);

		}

		Query q = new Query();
		q.addSelectFunction(new Function("COUNT", SVC_COL_CID, true));
		q.addFromTable(TBL_SVC);
		q.addFromTable(TBL_SVC_MINMAX);

		q.addWhereCriterion(SVC_MINMAX_COL_CID, Criterion.EQ, SVC_COL_CID);
		q.addWhereCriterion(SVC_COL_AUDTIME, Criterion.EQ, SVC_MINMAX_LASTTIME);

		CriteriaSet cs = new CriteriaSet();
		if (!isAnd)
			cs.setOperator(CriteriaSet.OR_OP);

		if ((keyword != null) && (keyword.length() != 0)) {
			CriteriaSet kw = new CriteriaSet();
			kw.setOperator(CriteriaSet.OR_OP);

			Collection<String> keywds = MonitorUtil.parseKeywordField(keyword);
			Iterator iter = keywds.iterator();
			while (iter.hasNext()) {
				String keywdphrase = (String) iter.next();
				kw.addCriterion(new Function("UPPER", SVC_COL_SVCNM),
						Criterion.LIKE, keywdphrase.toUpperCase());
				kw.addCriterion(new Function("UPPER", SVC_COL_CID),
						Criterion.LIKE, keywdphrase.toUpperCase());
				kw.addCriterion(new Function("UPPER", SVC_COL_CCID),
						Criterion.LIKE, keywdphrase.toUpperCase());
			}
			cs.addCriteria(kw);
		}

		if ((rootContextId != null) && (rootContextId.length() > 0))
			cs.addCriterion(SVC_COL_RCID, Criterion.EQ, rootContextId.trim());
		if ((parentContextId != null) && (parentContextId.length() > 0))
			cs.addCriterion(SVC_COL_PCID, Criterion.EQ, parentContextId.trim());
		if ((contextId != null) && (contextId.length() > 0))
			cs.addCriterion(SVC_COL_CID, Criterion.EQ, contextId.trim());
		if ((customContextId != null) && (customContextId.length() > 0))
			cs.addCriterion(SVC_COL_CCID, Criterion.EQ, customContextId.trim());

		if ((fullmessage != null) && (fullmessage.length() > 0)) {
			q.addSelectColumn(ACTLOG_COL_FULLMSG);
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, ACTLOG_COL_CID);
			cs.addCriterion(new Function("UPPER", ACTLOG_COL_FULLMSG),
					Criterion.LIKE, "%" + (fullmessage.trim()).toUpperCase()
							+ "%");
		}

		if ((username != null) && (username.length() > 0))
			cs.addCriterion(new Function("UPPER", SVC_COL_USRID),
					Criterion.LIKE, "%" + (username.trim()).toUpperCase() + "%");

		if ((serviceName != null) && (serviceName.length() != 0))
			cs.addCriterion(new Function("UPPER", SVC_COL_SVCNM),
					Criterion.LIKE, "%" + (serviceName.trim()).toUpperCase()
							+ "%");

		if ((serverId != null) && (serverId.length() != 0))
			cs.addCriterion(new Function("UPPER", SVC_COL_SVRID),
					Criterion.LIKE, "%" + (serverId.trim()).toUpperCase() + "%");

		CriteriaSet dateCS = new CriteriaSet();
		if (!filterOnLast) // means search on start time
		{
			if ((range != null) && (range.trim().length() != 0)) {
				if (range.toUpperCase().equals(MonitorUtil.TIME_ALL)) {
					fromDate = new Long(0);
					toDate = new Long(0);
				} else {
					Range rangedt = MonitorUtil.createDateRangeString(range);
					fromDate = (Long) rangedt.getBegin().getValue();
					toDate = (Long) rangedt.getEnd().getValue();
				}
			} else {
				if ((!(toDate != null && toDate.longValue() > 0))
						|| (!(fromDate != null && fromDate.longValue() > 0)))
					minDt = new Long(
							((Timestamp) getValue(queryMin.toString()))
									.getTime());
				maxDt = new Long(
						((Timestamp) getValue(queryMax.toString())).getTime());

				if (!(toDate != null && toDate.longValue() > 0)) {
					toDate = maxDt;
				}
				if (!(fromDate != null && fromDate.longValue() > 0)) {
					if (minDt.longValue() > 0)
						fromDate = new Long(minDt.longValue()
								- (24 * 60 * 60 * 1000));
				}
				if (fromDate.longValue() >= 9999999999999L) { // WMN-1856: Fetch
																// All records
					fromDate = new Long(0);
					toDate = new Long(0);
				}
			}
			if (fromDate.longValue() > 0)

				dateCS.addCriterion(SVC_MINMAX_FIRSTTIME, Criterion.GTEQ,
						new PSParameter());
			if (toDate.longValue() > 0)

				dateCS.addCriterion(SVC_MINMAX_FIRSTTIME, Criterion.LTEQ,
						new PSParameter());

			if (dateCS.getCriteriaSize() > 0)
				cs.addCriteria(dateCS);
		} else { // default to searching on last updated time
			if ((range != null) && (range.trim().length() != 0)) {
				if (range.toUpperCase().equals(MonitorUtil.TIME_ALL)) {
					fromDate = new Long(0);
					toDate = new Long(0);
				} else {

					Range rangedt = MonitorUtil.createDateRangeString(range);
					fromDate = (Long) rangedt.getBegin().getValue();
					toDate = (Long) rangedt.getEnd().getValue();
				}
			} else {
				if ((!(toDate != null && toDate.longValue() > 0))
						|| (!(fromDate != null && fromDate.longValue() > 0))) {
					Object obj = getValue(queryMax.toString());
					// if max date is null, table is empty
					if (obj == null) {
						return 0;
					}

					minDt = new Long(
							((Timestamp) getValue(queryMin.toString()))
									.getTime());
					maxDt = new Long(
							((Timestamp) getValue(queryMax.toString()))
									.getTime());

					if (!(toDate != null && toDate.longValue() > 0)) {
						toDate = maxDt;
					}
					if (!(fromDate != null && fromDate.longValue() > 0)) {
						if (minDt.longValue() > 0)
							fromDate = new Long(minDt.longValue()
									- (24 * 60 * 60 * 1000));
					}
					if (fromDate.longValue() >= 9999999999999L) { // WMN-1856:
																	// Fetch
																	// All
																	// records
						fromDate = new Long(0);
						toDate = new Long(0);
					}
				}
			}

			if (fromDate.longValue() > 0)

				dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.GTEQ,
						new PSParameter());
			if (toDate.longValue() > 0)

				dateCS.addCriterion(SVC_MINMAX_LASTTIME, Criterion.LTEQ,
						new PSParameter());

			if (dateCS.getCriteriaSize() > 0)
				cs.addCriteria(dateCS);
		}

		boolean custTableAdded = false;
		if (customData != null && customData.getRowCount() > 0) {
			CriteriaSet csFilter = new CriteriaSet();
			csFilter.setOperator(CriteriaSet.OR_OP);
			if (customData.getRowCount() > 0)
				q.addFromTable(TBL_SVCDATA);

			Query sq = null;
			for (int i = 0; i < customData.getRowCount(); i++) {
				CriteriaSet cs2 = new CriteriaSet();
				Values row = customData.getRow(i);
				String fieldAlias = (String) row.getValue("fieldName");
				String fieldType = (String) row.getValue("fieldType");
				String operator = (String) row.getValue("fieldOp");
				String value = (String) row.getValue("value");

				Column svcdataColFldalias = SVCDATA_COL_FLDALIAS;
				Column svcdataColStrval = SVCDATA_COL_STRVAL;
				Column svcdataColDateval = SVCDATA_COL_DATEVAL;
				Column svcdataColNumval = SVCDATA_COL_NUMVAL;

				custTableAdded = true;
				Query sq1 = new Query();
				if (isAnd) {
					sq1.addFromTable(TBL_SVCDATA_4AND);
					sq1.addWhereCriterion(new Criterion(SVCDATA_COL_CID,
							Criterion.EQ, SVCDATA_COL_CID_4AND));
					svcdataColFldalias = SVCDATA_COL_FLDALIAS_4AND;
					svcdataColStrval = SVCDATA_COL_STRVAL_4AND;
					svcdataColDateval = SVCDATA_COL_DATEVAL_4AND;
					svcdataColNumval = SVCDATA_COL_NUMVAL_4AND;
				}

				cs2.addCriterion(new Function("UPPER", svcdataColFldalias),
						Criterion.EQ, fieldAlias.toUpperCase());

				if (value == null)
					value = "";
				if (fieldType == null)
					fieldType = "";
				if (operator == null)
					operator = "";

				value = value.trim();
				if (fieldType.equals("String")) {
					if (operator.equals("Contains")) {
						cs2.addCriterion(
								new Function("UPPER", svcdataColStrval),
								Criterion.LIKE, "%" + value.toUpperCase() + "%");
					}
					if (operator.equals("=")) {
						cs2.addCriterion(svcdataColStrval, Criterion.EQ, value);
					}
					if (operator.equals("NotContains")) {
						cs2.addCriterion(
								new Function("UPPER", svcdataColStrval),
								Criterion.NOTLIKE, "%" + value.toUpperCase()
										+ "%");
					}
				} else if (fieldType.equals("Date")) {
					if (value.indexOf(' ') == -1) {
						if (operator.equals("=")) {
							cs2.addCriterion(svcdataColDateval, Criterion.BETW,
									new Range(value));
						} else if (operator.equals("!=")) {
							cs2.addCriterion(svcdataColDateval,
									Criterion.NOTBETW, new Range(value));
						} else {
							cs2.addCriterion(svcdataColDateval, operator,
									new DateTime(value));
						}
					}
				} else if (fieldType.equals("Number")) {
					cs2.addCriterion(svcdataColNumval, operator, new Float(
							value));
				}
				if (isAnd) {
					sq1.addWhereCriteria(cs2);
					if (sq == null && i == 0) {
						sq = sq1;
					} else {
						Criterion cri = new Criterion(null, Criterion.EXIST,
								sq1);
						sq.addWhereCriterion(cri);
					}

				} else {

					if (cs2.getCriteriaSize() > 0) {
						csFilter.addCriteria(cs2);
					}
				}
			}
			if (isAnd) {
				Criterion cri = new Criterion(null, Criterion.EXIST, sq);
				csFilter.addCriterion(cri);
			}
			if (csFilter.getCriteriaSize() > 0)
				cs.addCriteria(csFilter);
		}

		if (custTableAdded) {
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, SVCDATA_COL_CID);
		}

		if (status != null && status.length > 0) {
			InList il = MonitorUtil.createInList(status);
			if (!il.isEmpty())
				cs.addCriterion(SVC_MINMAX_LASTSTATUS, Criterion.IN, il);
		}

		if (cs.getCriteriaSize() > 0)
			q.addWhereCriteria(cs);

		PreparedStatement ps = null;
		try {
			int paramCount = 1;
			_sGetWSList = q.toString();
			ps = new ISPreparedStatement(_ds, _sGetWSList);
			ps.clearParameters();

			if (fromDate.longValue() > 0)
				ps.setTimestamp(paramCount++, new Timestamp(fromDate));

			if (toDate.longValue() > 0)
				ps.setTimestamp(paramCount++, new Timestamp(toDate));

			int totalItems = getCount(ps);
			return totalItems;

		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}

	}

	private static String _sAllServiceNames = null;
	private static ListInfo _liAllServiceNames = null;

	/**
	 * Gets a list of all distinct service names. Used by permissions pages.
	 * 
	 * @return BasicList containing a list of all distinct service names in the
	 *         database.
	 * @throws SQLException
	 */
	public BasicList getAllServiceNames() throws SQLException {
		if (_sAllServiceNames == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_SVCNM);
			q.addOrderByColumn(SVC_COL_SVCNM, SORT_ASC);
			q.setQueryDistinct();

			_sAllServiceNames = q.toString();
		}
		PreparedStatement ps = null;
		try {
			ps = new ISPreparedStatement(_ds, _sAllServiceNames);
			BasicList bl = getList(ps, _liAllServiceNames);
			if (_liAllServiceNames == null)
				_liAllServiceNames = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private static String _srcid = null;
	private static ListInfo _lircid = null;

	public BasicList getRootContextID(String cid) throws SQLException {
		if (_srcid == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_RCID);
			q.setQueryDistinct();
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			_srcid = q.toString();
		}
		PreparedStatement ps = null;
		try {
			ps = new ISPreparedStatement(_ds, _srcid);
			ps.clearParameters();
			ps.setString(1, cid);
			BasicList bl = getList(ps, _lircid);
			if (_lircid == null)
				_lircid = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private static String _sSvcNm = null;
	private static ListInfo _liSvcNm = null;

	public BasicList getServiceName(String cid) throws SQLException {
		if (_sSvcNm == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_CID);
			q.addSelectColumn(SVC_COL_SVCNM);
			q.setQueryDistinct();
			q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, new PSParameter());
			_sSvcNm = q.toString();
		}
		PreparedStatement ps = null;
		try {
			ps = new ISPreparedStatement(_ds, _sSvcNm);
			ps.clearParameters();
			ps.setString(1, cid);
			BasicList bl = getList(ps, _liSvcNm);
			if (_liSvcNm == null)
				_liSvcNm = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private static String _sChildNames = null;
	private static ListInfo _liChildNames = null;

	public BasicList getChildNames(String cid) throws SQLException {
		if (_sChildNames == null) {
			Query q = new Query();
			q.addSelectColumn(SVC_COL_CID);
			q.addSelectColumn(SVC_COL_SVCNM);
			q.setQueryDistinct();
			q.addWhereCriterion(SVC_COL_PCID, Criterion.EQ, new PSParameter());
			_sChildNames = q.toString();
		}
		PreparedStatement ps = null;
		try {
			ps = new ISPreparedStatement(_ds, _sChildNames);
			ps.clearParameters();
			ps.setString(1, cid);
			BasicList bl = getList(ps, _liChildNames);
			if (_liChildNames == null)
				_liChildNames = bl.getListInfo();
			return bl;
		} catch (SQLException e) {
			Debug.logDebugPlus(2, 0, Debug.DB, Debug.stackTraceToString(e));
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	/**
	 * Service retrieves the activity log data for a service. Uses the cid
	 * passed in to build the context stack and retrieve the related entry in
	 * the wmserviceactivitylog table.
	 **/
	public BasicList getActivityLogStack(String contextID) throws SQLException {
		try {
			// build the query that will now join the serviceactivitylog entries
			// with the rebuilt stack in wmcontextstack
			Query q = new Query();
			q.setQueryDistinct();
			q.addSelectColumn(ACTLOG_COL_RCID);
			q.addSelectColumn(ACTLOG_COL_PCID);
			q.addSelectColumn(ACTLOG_COL_CID);
			q.addSelectColumn(ACTLOG_COL_ENTRYTYPE);
			q.addSelectColumn(ACTLOG_COL_FULLMSG);
			q.addSelectColumn(ACTLOG_COL_BRIEFMSG);
			q.addSelectColumn(ACTLOG_COL_SVRID);
			q.addSelectColumn(ACTLOG_COL_USR);
			q.addSelectColumn(ACTLOG_COL_AUDTIME);
			q.addSelectColumn(ACTLOG_COL_AUDSTRING);
			q.addWhereCriterion(ACTLOG_COL_CID, Criterion.EQ, contextID); // put
																			// the
																			// rootcontextid
																			// here
			q.addOrderByColumn(ACTLOG_COL_AUDTIME, SORT_DESC);

			// execute the query and retrieve the basic list
			BasicList bl = getList(q.toString(),true);
			return bl;
		} catch (SQLException e) {
			Debug.logError(226, Debug.MON, e.toString());
			Debug.logError(226, Debug.MON, Debug.stackTraceToString(e));
			throw e;
		}
	}

	/**
	 * Service retrieves the activity log data related to a step. Uses the cid
	 * to rebuild the context stack for that step and retrieves the related
	 * activity messages for the step.
	 **/
	/*
	 * public BasicList getActLogDataStep (String contextID, String uuid) throws
	 * SQLException { try { int level = 0; int rc = 1;
	 * 
	 * ValuesEmulator.put(pipe, "uuid", uuid); //put this in the pipeline so
	 * that if this service is called //from getActLogForProcess we can
	 * backtrack to the stepname //for the table UI //do the initial insert into
	 * the stack table with the step cid to start the stack //insert into
	 * wmcontextid values (uuid, cid, level) values (uniqueid, 0, step context
	 * id) String insert = "INSERT INTO " + TBLNM_CONSTACK + " (" + COLNM_QID
	 * +", " + COLNM_LVL +", " + COLNM_CID +")" +
	 * " values ('"+uuid+"', 0, '"+contextID+"')";
	 * //System.out.println("initial insert is: " + insert);
	 * Debug.logDebugPlus(4, 10, Debug.MON, insert);
	 * 
	 * //execute the insert int rows = execUpdate(insert);
	 * //System.out.println("rows inserted: " + rows);
	 * //System.out.println("rc is: " + rc); //insert into our table, nextInsert
	 * is a recursive call that does a select to get all related //inserts to be
	 * done based on the parentcontextid in wmservice = contextid inserted into
	 * wmcontextstack //nextInsert returns the number of rows just inserted. As
	 * long as something is inserted, we need to query //to find the next item
	 * in the stack. If no rows are returned, we break out of the while loop
	 * since //the stack has been completely built while(rc > 0) { rc =
	 * nextInsert(uuid, ++level); //System.out.println("rc is: " + rc); }
	 * //build the select union statement
	 * 
	 * Query q = new Query(); q.setQueryDistinct();
	 * q.addSelectColumn(ACTLOG_COL_PCID); q.addSelectColumn(ACTLOG_COL_CID);
	 * q.addSelectColumn(ACTLOG_COL_ENTRYTYPE);
	 * q.addSelectColumn(ACTLOG_COL_FULLMSG);
	 * q.addSelectColumn(ACTLOG_COL_BRIEFMSG);
	 * q.addSelectColumn(ACTLOG_COL_SVRID); q.addSelectColumn(ACTLOG_COL_USR);
	 * q.addSelectColumn(ACTLOG_COL_AUDTIME);
	 * q.addSelectColumn(ACTLOG_COL_AUDSTRING);
	 * q.addSelectColumn(CONSTACK_COL_QID); q.addFromTable(TBL_CONSTACK);
	 * q.addWhereCriterion(ACTLOG_COL_CID, Criterion.EQ, CONSTACK_COL_CID);
	 * q.addWhereCriterion(CONSTACK_COL_QID, Criterion.EQ, uuid);
	 * 
	 * //System.out.println("\n q is: " + q.toString());
	 * 
	 * Debug.logDebugPlus(4, 10, Debug.MON, q.toString());
	 * 
	 * //execute the query and get back a basic list
	 * 
	 * BasicList bl = getList(q.toString());
	 * 
	 * //put the items in the basic list into a table in case this is going
	 * directly to the step status page if(bl != null) {
	 * bl.sort(Constants.COLNM_AUDTIME, false); com.wm.util.Table t = new
	 * com.wm.util.Table(bl.getFields()); while(bl.next()) {
	 * t.addRow(bl.getRow()); Debug.logDebugPlus(4, 80, Debug.MON); }
	 * MonitorUtil.storeInPipe("actlogdata", t, pipe); bl.beforeFirst(); //store
	 * the table in the pipeline and reset the basic list to the beginning, in
	 * the case that //this is for the process page }
	 * 
	 * //System.out.println("bl from query is: " + bl); //put the basic list
	 * into the pipeline ValuesEmulator.put(pipe, "bl", bl); //delete all
	 * associated entries in wmcontextstack temp table String delete =
	 * "DELETE FROM " + TBLNM_CONSTACK + " WHERE " + COLNM_QID + "='"+uuid+"'";
	 * Debug.logDebugPlus(4, 10, Debug.MON, delete);
	 * 
	 * rows = execUpdate(delete); //System.out.println("deleted rows: " + rows);
	 * } catch(SQLException e) { Debug.logError(226, Debug.MON, e.toString());
	 * e.printStackTrace(System.out); throw e; } }
	 */
	/**
	 * Method uses a recursive insert statement to create the context stack.
	 * UUID (QID) is a unique context id assigned to each instance of a starting
	 * context. LVL keeps track of the distinct level in the tree.
	 **/
	public int nextInsert(String uuid, int lvl) throws SQLException {
		String insert = "INSERT INTO " + TBLNM_CONSTACK + " (" + COLNM_QID
				+ ", " + COLNM_LVL + ", " + COLNM_CID + ") ";
		insert += "SELECT DISTINCT '" + uuid + "', " + lvl + ", " + COLNM_CID
				+ " FROM WMSERVICE ";
		insert += "WHERE " + COLNM_PCID + " IN (SELECT " + COLNM_CID + " FROM "
				+ TBLNM_CONSTACK + " WHERE " + COLNM_QID + "='" + uuid
				+ "' AND " + COLNM_LVL + "=" + (lvl - 1) + ")";
		Debug.logDebugPlus(4, 10, Debug.MON, insert);
		// System.out.println("in nextInsert insert sql is: " + insert);
		/*
		 * insert into wmcontextstack (QID, LVL, CONTEXTID) select distinct
		 * '123', 2, CONTEXTID from WMSERVICE where PARENTCONTEXTID IN (select
		 * CONTEXTID from WMCONTEXTSTACK where QID = '123' and LVL = 1)
		 */

		return execUpdate(insert);
	}

	/*
	 * public static void main (String[] args) { try { ServiceAccess sa = new
	 * ServiceAccess(); System.out.println("RECENT DONE:\n" +
	 * sa.getRecentStatus(2).toString()); System.out.println();
	 * System.out.println("RECENT FAILED:\n" +
	 * sa.getRecentStatus(3).toString()); System.out.println(); //sop } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */
	public void setMaxDt(Long obj) {
		maxDt = obj;
	}

	public void setMinDt(Long obj) {
		minDt = obj;
	}

	/*----------------------------------
	 * WMSERVICECUSTOMFLDS
	 *----------------------------------*/

	/** Returns the custom service data for the specified instance id **/

	public BasicList getCustomData(String contextID, String fieldName,
			String sortby, String sort) throws SQLException {
		Query q = new Query(CUSTSVC_SELECT_COLS);
		q.setQueryDistinct();
		q.addWhereCriterion(SVCDATA_COL_CID, Criterion.EQ, contextID);
		if (fieldName != null && !fieldName.equals("")) {
			q.addWhereCriterion(SVCDATA_COL_FLDNM, Criterion.EQ, fieldName);
		}
		if (sortby != null && !sortby.equals("")) {
			int s = 0;
			if (sort != null) {
				s = Integer.parseInt(sort);
			}
			q.addOrderByColumn(TBL_SVCDATA, sortby, s);
		}
		q.addOrderByColumn(SVCDATA_COL_AUDTIME, Constants.SORT_DESC);
		Debug.logDebugPlus(4, 314, Debug.DB, q.toString());
		BasicList bl = getList(q.toString());
		return bl;
	}
}
