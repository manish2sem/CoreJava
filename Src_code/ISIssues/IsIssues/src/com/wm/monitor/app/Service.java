package com.wm.monitor.app;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;

import com.wm.app.b2b.server.User;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.monitor.common.app.Permissions;
import com.wm.monitor.common.util.Debug;
import com.wm.monitor.common.util.MonitorException;
import com.wm.monitor.common.util.MonitorUtil;
import com.wm.monitor.common.util.PkgUtil;
import com.wm.monitor.db.BasicList;
import com.wm.monitor.db.Constants;
import com.wm.monitor.db.ServiceAccess;
import com.wm.monitor.db.TableConstants;
import com.wm.monitor.db.querygeneration.Column;
import com.wm.monitor.db.querygeneration.CriteriaSet;
import com.wm.monitor.db.querygeneration.Criterion;
import com.wm.monitor.db.querygeneration.DateTime;
import com.wm.monitor.db.querygeneration.Function;
import com.wm.monitor.db.querygeneration.InList;
import com.wm.monitor.db.querygeneration.PSParameter;
import com.wm.monitor.db.querygeneration.Query;
import com.wm.monitor.db.querygeneration.Range;
import com.wm.util.Table;
import com.wm.util.Values;

public class Service implements Constants, TableConstants
{
	
    public static final int FLDNM_COL = 0;

    public static final int FLDTP_COL = 1;

    public static final int COMP_COL = 2;

    public static final int VAL_COL = 3;
	
	private static ServiceAccess _sa = null;
	static { _sa = new ServiceAccess(); }

	/**
	 *	Service retrieves the activity log data for a service.  Uses the cid passed in to build the context stack and
	 *	retrieve the related entry in the wmserviceactivitylog table.
	 **/
	public static BasicList getActivityLogStack (String contextID)
        throws MonitorException
	{
		try {
            return _sa.getActivityLogStack(contextID);
		} catch (Exception e) {
			throw new MonitorException(e);
		}
	}

	/**
	 * Checks to see whether or not a service is logged in the WMSERVICE table.
	 * @param contextID
	 * @return
	 * @throws MonitorException
	 */
	public static boolean exists(String contextID) throws MonitorException {
	    try {
	        boolean exists = _sa.svcExists(contextID);
	        return exists;
	    } catch(SQLException e) {
	        throw new MonitorException(e);
	    }
	}
    /**
	 * Service retrieves the service instances meeting the criteria specified
	 * in the custom query page.
	 **/
	public static BasicList getList (String query)
			throws MonitorException
	{
		try {
			String user = com.wm.app.b2b.server.Service.getUser().getName();
			BasicList bl = _sa.getList(query);
			bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
			return bl;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}
	/**
	 * Service retrieves the service instances meeting the criteria specified
	 * in the custom query page.
	 **/
	public static BasicList getList (String rootContextID,
	                                 String parentContextID,
	                                 String contextID,
	                                 String customContextID,
	                                 String svcName, boolean svcNameExact,
	                                 String svrID, boolean svrIDExact,
	                                 String username,
	                                 String predefRange,
	                                 Long afterTime, Long beforeTime,
	                                 int [] status, int maxRows, boolean isAnd)
			throws MonitorException
	{
		try {
			String user = com.wm.app.b2b.server.Service.getUser().getName();
			BasicList bl = _sa.getList(rootContextID, parentContextID, contextID, customContextID,
			        svcName, svcNameExact, svrID, svrIDExact, username,
			        predefRange, afterTime, beforeTime, status, maxRows, isAnd);
			bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
			return bl;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}
    /**
	 * Service retrieves the SQL meeting the criteria specified
	 * in the custom query page.
	 **/
	public static String generateListSQL (String rootContextID,
	                                 String parentContextID,
	                                 String contextID,
	                                 String customContextID,
	                                 String svcName, boolean svcNameExact,
	                                 String svrID, boolean svrIDExact,
	                                 String username,
	                                 String predefRange,
	                                 Long afterTime, Long beforeTime,
	                                 int [] status, int maxRows, boolean isAnd)
			throws MonitorException
	{
		try {
			String query = _sa.generateListSQL(rootContextID, parentContextID, contextID, customContextID,
			        svcName, svcNameExact, svrID, svrIDExact, username,
			        predefRange, afterTime, beforeTime, status, maxRows, isAnd);

			return query;
		} catch (Exception e) {
			throw new MonitorException(e);
		}
	}

    // gets a list of services for the ws app in Portal
    public static BasicList getWsList (String keyword, String serviceName, String serverId,
                                       int[] status,
                                       String range, Long fromTime, Long toTime, boolean filterOnLast,
                                       String username,
                                       String rootContextId, String parentContextId, String contextId, String cuctomContextId,
                                       com.wm.util.Table customData,
                                       boolean rootLevelOnly, int maxRows, boolean isAnd, String fullmessage )
            throws MonitorException
    {
        try {
            String user = com.wm.app.b2b.server.Service.getUser().getName();
            BasicList bl = _sa.getWsList(keyword, serviceName, serverId, status,
                                         range, fromTime, toTime, filterOnLast, username,
                                         rootContextId, parentContextId, contextId, cuctomContextId, customData, 
                                         rootLevelOnly, maxRows, isAnd, fullmessage);
            if (bl == null) {
                return new BasicList();
            }
            bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
            return bl;
        } catch (SQLException e) {
            throw new MonitorException(e);
        }
    }
    
	public static int getWsListCount(String keyword, String serviceName,
			String serverId, int[] status, String range, Long fromTime,
			Long toTime, boolean filterOnLast, String username,
			String rootContextId, String parentContextId, String contextId,
			String cuctomContextId, com.wm.util.Table customData,
			boolean rootLevelOnly, boolean isAnd, String fullmessage)
			throws MonitorException {

		try {
			int count = _sa.getWsListCount(keyword, serviceName, serverId,
					status, range, fromTime, toTime, filterOnLast, username,
					rootContextId, parentContextId, contextId, cuctomContextId,
					customData, rootLevelOnly, isAnd, fullmessage);

			return count;

		} catch (SQLException e) {
			throw new MonitorException(e);
		}

	}
    
    /**
     * Retrieves an list and allows custom fields to be queries on too.
     * 
     * @return
     * @throws MonitorException
     */
	public static BasicList getListCustom ( User user, Locale locale,
											String rootContextID,
								            String parentContextID,
								            String contextID,
								            String customContextID,
								            String svcName, boolean svcNameExact,
								            String svrID, boolean svrIDExact,
								            String username,
								            String predefRange,
								            Long afterTime, Long beforeTime,
								            int [] status, 
								            String[][] customTable,
								            int maxRows, boolean isAnd) throws MonitorException {
		  //wmn-5574-allow predefined range queries for custom searches
		if ((predefRange != null) && (predefRange.length() != 0)) {
			Range range = MonitorUtil.createDateRangeString(predefRange);
            afterTime = (Long) ((range.getBegin()).getValue());
            beforeTime = (Long) ((range.getEnd()).getValue());
        }
        BasicList bl = null;
	    try {        
	        CriteriaSet cs = new CriteriaSet();
	        if (!isAnd)
	            cs.setOperator(CriteriaSet.OR_OP);
	        
	        Query q = new Query(ServiceAccess.SVC_SELECT_COLS);
			q.setQueryDistinct();
			q.addWhereCriterion(ServiceAccess.SVC_CURRENT_STATUS);
			
			if ((rootContextID != null) && (rootContextID.length() > 0))
				cs.addCriterion(SVC_COL_RCID, Criterion.EQ, rootContextID.trim());
			if ((parentContextID != null) && (parentContextID.length() > 0))
				cs.addCriterion(SVC_COL_PCID, Criterion.EQ, parentContextID.trim());
			if ((contextID != null) && (contextID.length() > 0))
				cs.addCriterion(SVC_COL_CID, Criterion.EQ, contextID.trim());
	        if ((customContextID != null) && (customContextID.length() > 0))
	            cs.addCriterion(SVC_COL_CCID, Criterion.EQ, customContextID.trim());
			if ((username != null) && (username.length() > 0))
	        	cs.addCriterion(new Function("UPPER", SVC_COL_USRID), Criterion.LIKE, (username.trim()).toUpperCase());
	
			if ((svcName != null) && (svcName.length() != 0))
			{
				if (svcNameExact)
					cs.addCriterion(SVC_COL_SVCNM, Criterion.EQ, svcName.trim());
				else
					cs.addCriterion(new Function("UPPER", SVC_COL_SVCNM), Criterion.LIKE, "%" + (svcName.trim()).toUpperCase() + "%");
			}
	
			if ((svrID != null) && (svrID.length() != 0))
			{
				if (svrIDExact)
					cs.addCriterion(SVC_COL_SVRID, Criterion.EQ, svrID.trim());
				else
					cs.addCriterion(new Function("UPPER", SVC_COL_SVRID), Criterion.LIKE, "%" + (svrID.trim()).toUpperCase() + "%");
			}
	
			//if ((predefRange != null) && (predefRange.length() != 0))
			//{
				//cs.addCriterion(SVC_COL_AUDTIME, Criterion.BETW, MonitorUtil.createDateRangeString(predefRange));
			//}
			
	        CriteriaSet dateCS = new CriteriaSet();
			if (afterTime.longValue() > 0)
				//dateCS.addCriterion(SVC_COL_AUDTIME, Criterion.GTEQ, afterTime);
				dateCS.addCriterion(SVC_COL_AUDTIME, Criterion.GTEQ, new PSParameter());
			if (beforeTime.longValue() > 0)
				//dateCS.addCriterion(SVC_COL_AUDTIME, Criterion.LTEQ, beforeTime);
				dateCS.addCriterion(SVC_COL_AUDTIME, Criterion.LTEQ, new PSParameter());
	
	        if(dateCS.getCriteriaSize() > 0)
	            cs.addCriteria(dateCS);
	
			if (status != null && status.length > 0)  {
	            InList il = MonitorUtil.createInList(status);
	            if(!il.isEmpty())
	                cs.addCriterion(SVC_COL_STATUS, Criterion.IN, il);
	        }
			
			boolean custTableAdded = false;
	        if(customTable != null && customTable.length > 0) {
	        	CriteriaSet csFilter = new CriteriaSet();
	        	csFilter.setOperator(CriteriaSet.OR_OP);
	        	
	            int j = 0;
	            for(int i = 0; i < customTable.length; i++) {
	                CriteriaSet cs2 = new CriteriaSet();
	                String[] row = customTable[i];
	                String fieldAlias = row[FLDNM_COL];
	                String fieldType = row[FLDTP_COL];
	                String operator = row[COMP_COL];
	                String value = row[VAL_COL];
	                if(j > 0 && isAnd) {
	                    q.addFromTable(TBL_SVCDATA);
	                }
	                if(j == 0) {
	                    q.addFromTable(TBL_SVCDATA);
	                }
					custTableAdded = true;
					
	                j++;
	                cs2.addCriterion(SVCDATA_COL_FLDALIAS, Criterion.EQ, fieldAlias);
	                Column colFldType = null;
	
	                if(value == null) value = "";
	                if(fieldType == null) fieldType = "";
	                if(operator == null) operator = "";
	
	                value = value.trim();
	                if(fieldType.equals("String")){
	                    if(operator.equals("Contains")) {
	                        cs2.addCriterion(new Function("UPPER", SVCDATA_COL_STRVAL), Criterion.LIKE, "%" + value.toUpperCase() + "%");
	                    }
	                    if(operator.equals("=")) {
	                        cs2.addCriterion(SVCDATA_COL_STRVAL, Criterion.EQ, value);
	                    }
	                    if(operator.equals("NotContains")) {
	                        cs2.addCriterion(new Function("UPPER", SVCDATA_COL_STRVAL), Criterion.NOTLIKE, "%" + value.toUpperCase() + "%");
	                    }
	                }else if(fieldType.equals("Date")){
	                    if (value.indexOf(' ') == -1) {
	                        if (operator.equals("=")) {
	                            cs2.addCriterion(SVCDATA_COL_DATEVAL, Criterion.BETW, new Range(value));
	                        } else if (operator.equals("!=")) {
	                            cs2.addCriterion(SVCDATA_COL_DATEVAL, Criterion.NOTBETW, new Range(value));
	                        } else {
	                            cs2.addCriterion(SVCDATA_COL_DATEVAL, operator, new DateTime(value));
	                        }
	                    }
	                }else if(fieldType.equals("Number")){
	                    cs2.addCriterion(SVCDATA_COL_NUMVAL, operator, new Float(value));
	                }
	                if(cs2.getCriteriaSize( )> 0)
	                	csFilter.addCriteria(cs2);
	            }
	            if(csFilter.getCriteriaSize( )> 0)
	            	cs.addCriteria(csFilter);
	        }
			
	        if(custTableAdded) {
	            q.addWhereCriterion(SVC_COL_CID, Criterion.EQ, SVCDATA_COL_CID);
	        }
	        
	        if(cs.getCriteriaSize() > 0)
	            q.addWhereCriteria(cs);
			q.addOrderByColumn(SVC_COL_AUDTIME, SORT_DESC);		
			
	        if (cs.getCriteriaSize() > 0)
	            q.addWhereCriteria(cs);
	        Debug.logDebugPlus(4, 43, Debug.MON, q.toString());
	        bl = _sa.getList(q.toString(), maxRows, locale); // integer for max rows
	        bl.filter(COLNM_PROCKEY, Permissions.getFilterSetting(user, MDLFLTR_KEY));
	        Debug.logDebugPlus(4, 129, Debug.MON, bl);
	        
	    } catch (SQLException e) {
            Debug.logError(28, Debug.MON, e.toString());
            Debug.logDebugPlus(4, 28, Debug.MON, Debug.stackTraceToString(e));
            throw new MonitorException(e, PkgUtil.msg(28, e.toString()));
        }
        
        return bl;
    }
    
	/**
	 * Gets the details about a specific service, including current status.
	 * Does not include pipeline or info on whether or not service is
	 * truly resubmittable (flag in BasicList only tells us if the service
	 * is top level, also need to know if the service is currently running
	 * or not, and whether or not a pipeline has actually been stored).
	 * @param contextID context ID for the service for which details are
	 * requested.
	 * @return Table containing service details.
	 * @throws MonitorException
	 */
	public static com.wm.util.Table getDetails (String contextID)
			throws MonitorException
	{
		try {
			BasicList det = _sa.getDetailsByContextId(contextID);
			String user = com.wm.app.b2b.server.Service.getUser().getName();
			det.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
			if (det.getRowCount() > 0)
				return makeDtls(det, contextID);
			else return null;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}

    public static IData getWsDetails(String contextId) throws MonitorException
    {
        IData out = null;
        IDataCursor c = null;
        try {
            BasicList det = _sa.getDetails(contextId);
            String user = com.wm.app.b2b.server.Service.getUser().getName();
            det.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
            if (det.getRowCount() > 0)
            {
                // we will only show one set of details - if more than one status is logged at the same time,
                // we will only show the one with the highest status code
                det.first();
                Object[] row = det.getRow();
                out = MonitorUtil.convertBasicListRowToIData(det, row, out);

                c = out.getCursor();
                String cid = (String) row[det.getIndex(COLNM_CID)];
                BasicList children = getChildNames(cid);
                if (children.getRowCount() > 0)
                {
                    com.wm.util.Table t = new com.wm.util.Table(children.getFields());
                    while (children.next())
                        t.addRow(children.getRow());
                    c.insertAfter("children", t);
                }

                String rcid = (String) row[det.getIndex(COLNM_RCID)];
                BasicList root = getServiceName(rcid);
                if (root.getRowCount() > 0)
                {
                    root.first();
                    IData data = MonitorUtil.convertBasicListRowToIData(root, null);
                    c.insertAfter("root", data);
                }

                String pcid = (String) row[det.getIndex(COLNM_PCID)];
                BasicList parent = getServiceName(pcid);
                if (parent.getRowCount() > 0)
                {
                    parent.first();
                    IData data = MonitorUtil.convertBasicListRowToIData(parent, null);
                    c.insertAfter("parent", data);
                }
                
                String apcid = (String) row[det.getIndex(COLNM_APCID)];
                BasicList aParent = getServiceName(apcid);
                if (aParent.getRowCount() > 0)
                {
                	aParent.first();
                    IData data = MonitorUtil.convertBasicListRowToIData(aParent, null);
                    c.insertAfter("auditparent", data);
                }
                c.destroy();
            }
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MonitorException(e);
        } finally {
            if (c != null)
                c.destroy();
        }
        return out;
    }

    /**
     * Retrieves the control actions taken for an instance.
     * 
     * @param contextId
     * @param locale
     * @return
     * @throws MonitorException
     */
    public static final Table getWSServiceCustomData(String contextId, Locale locale) throws MonitorException {
        try {
            BasicList bl = _sa.getWSCustomData(contextId, locale);
            Debug.logDebugPlus(4, 96, Debug.MON, contextId, bl);
            Table customData = null;
            if (bl != null && bl.getRowCount() != 0) {
                String[] cols = { "contextId", "serverId", "messageId", "fieldName", "fieldValue", "time", "inputField" };
                customData = new Table(cols);
                while (bl.next()) {
                    Object[] row = bl.getRow();
                    Values v = new Values();
                    v.put("contextId", (String) row[bl.getIndex(COLNM_CID)]);
                    v.put("serverId", (String) row[bl.getIndex(COLNM_SVRID)]);
                    v.put("messageId", (String) row[bl.getIndex(COLNM_MSGID)]);
                    v.put("fieldName", (String) row[bl.getIndex(COLNM_FLDALIAS)]);
                    String strval = (String) row[bl.getIndex(COLNM_STRVAL)];
                    Float numval = (Float) row[bl.getIndex(COLNM_NUMVAL)];
                    String dateval = (String) row[bl.getIndex(COLNM_DATEVAL)];

                    if (strval != null && !strval.equals("")) {
                        v.put("fieldValue", strval);
                    } else if (dateval != null) {
                        v.put("fieldValue", dateval.toString());
                    } else {
                        v.put("fieldValue", numval.toString());
                    }
                    v.put("time", (Long) row[bl.getIndex(COLNM_AUDTIME)]);
                    v.put("inputField", (Integer) row[bl.getIndex(COLNM_INPUTFIELD)]);
                    customData.addRow(v);
                }
                return customData;
            }
        } catch (Exception e) {
            Debug.logError(47, Debug.MON, e.toString());
            Debug.logDebugPlus(4, 47, Debug.MON, Debug.stackTraceToString(e));
            throw new MonitorException(e, PkgUtil.msg(47, e.toString()));
        }
        return null;
    }
    
    public static BasicList getServiceName(String contextId) throws MonitorException
    {
        try {
            BasicList bl = _sa.getServiceName(contextId);
            String user = com.wm.app.b2b.server.Service.getUser().getName();
            bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
            return bl;
        } catch (SQLException e) {
            throw new MonitorException(e);
        }
    }

    public static BasicList getChildNames(String contextId) throws MonitorException
    {
        try {
            BasicList bl = _sa.getChildNames(contextId);
            String user = com.wm.app.b2b.server.Service.getUser().getName();
            bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
            return bl;
        } catch (SQLException e) {
            throw new MonitorException(e);
        }
    }

	/**
	 * This method gets details of services that have the same parentcontextid.
	 * @param parentContextID parentContextID
	 * @return BasicList containing the details of the child services
	 * @throws MonitorException
	 */
	// This method is used by process instances to get the details for the
	// service run by a step.  It needs only one service back, but that should
	// work because only one service can ever be run by a step at one time.
	public static com.wm.util.Table getChildDetails (String parentContextID)
			throws MonitorException
	{
		try {
			BasicList children =_sa.getChildren(parentContextID);
			com.wm.util.Table details = null;
			if (children.getRowCount() > 0)
			{
				//children.first();
				String cid = null;
				// for each child, get the details and accumulate a list
				while (children.next())
				{
					cid = (String)(children.getRow())[children.getIndex(COLNM_CID)];
					BasicList det = _sa.getDetails(cid);
					String user = com.wm.app.b2b.server.Service.getUser().getName();
					det.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
					if (det.getRowCount() > 0)
					{
						com.wm.util.Table detail = makeDtls(det, cid);
						if (details == null)
							details = detail;
						else
							details.addRow(detail.getRow(0));
					}
				}
			}
			//else return null;
			return details;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}

	private static com.wm.util.Table makeDtls (BasicList details, String contextID)
			throws SQLException, MonitorException
	{
		com.wm.util.Table t = null;
		// this gets the associated IDs from the WMSERVICEASSOC table
		BasicList associd = _sa.getExternalID(contextID);

		// activations that are started from docs published from IS are not logged in
		// WMSERVICEASSOC table.  have to assume that an actid of wm6ABC is associated
		// with a context id of ABC.  check here to see if such an activation exists,
		// if so, make association
		boolean isAssoc = false;
		String actid = "wm6" + contextID;
		//if (Activation.exists(actid))
		//	isAssoc = true;

		// add the associated id field to the end of the details
		int numflds = details.getFieldCount();
		String[] detcols = details.getFields();
		String[] cols = new String[numflds + 1];
		for (int i = 0; i < numflds; i++) cols[i] = detcols[i];
		cols[numflds] = COLNM_EXTID;
		t = new com.wm.util.Table(cols);

		// put the related activation ids into a string list
		String[] associds = null;
		if (associd.getRowCount() > 0 || isAssoc)
		{
			if (isAssoc)
				associds = new String[associd.getRowCount() + 1];
			else
				associds = new String[associd.getRowCount()];
			int idx = 0;
			if (isAssoc)
			{
				associds[0] = actid;
				idx++;
			}
			while (associd.next())
			{
				associds[idx] = (String)((associd.getRow())[associd.getIndex(COLNM_EXTID)]);
				idx++;
			}
		}
		// set back just in case - this bl might have been used before being passed
		details.beforeFirst();
		while (details.next())
		{
			Object[] detrow = details.getRow();
			Object[] row = new Object[numflds + 1];
			for (int i = 0; i < numflds; i++) row[i] = detrow[i];
			row[numflds] = associds;
			t.addRow(row);
		}
		// ideally would return a BasicList here, to be consistent with
		// the rest of the methods, but in order to add in the association
		// id, have to transform to a table.  could transform back to a
		// BasicList, but then the service calling this method would just
		// transform it back to a table.  that seemed stupid.
		return t;
	}

	/* Gets the logged history for a specific service, e.g. the start and end
	 * logs, as well as resubmit statuses
	 * @param contextID context ID of requested service
	 * @return BasicList containing status history
	 * @throws MonitorException
	 */
	public static BasicList getHistory (String contextID)
			throws MonitorException
	{
		try {
			String user = com.wm.app.b2b.server.Service.getUser().getName();
			BasicList bl = _sa.getHistory(contextID);
			bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
			return bl;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}

	/**
	 * Gets a list of services whose parent context IDs are in a specified list.
	 * @param CIDList list of parent context IDs
	 * @return list of services
	 * @throws MonitorException
	 */
	public BasicList getServicefromCIDList(InList CIDList)
	        throws MonitorException
	{
		try {
			String user = com.wm.app.b2b.server.Service.getUser().getName();
			BasicList bl = _sa.getServicefromCIDList(CIDList);
			bl.filter(COLNM_SVCNM, Permissions.getFilterSetting(user, SVCFLTR_KEY));
			return bl;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}

    /**
     * Gets the most recent logged input pipeline for a specific service.
     * @param contextID context ID of the service
     * @return IData containing the input pipeline for the service
     * @throws MonitorException
     */
    public static IData getPipeline (String contextID)
            throws MonitorException
    {
        try {
            byte[] pipe = _sa.getPipeline(contextID);
            return MonitorUtil.convertByteArrayToIData(pipe);
        } catch (SQLException e) {
            throw new MonitorException(e);
        }
    }

	/**
	 * Gets the most recent logged system data for a specific service.
	 * @param contextID context ID of the service
	 * @return IData containing the system data logged for the service
	 * @throws MonitorException
	 */
	public static IData getSystemData (String contextID)
			throws MonitorException
	{
		try {
			byte[] sd = _sa.getSystemData(contextID);
			return MonitorUtil.convertByteArrayToIData(sd);
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}

	/**
	 * isResubmittable depends on 2 things: is the service top-level and has 
	 * the pipeline been logged.  If either of these
	 * things is not true, the service cannot be resubmitted.
	 * @param contextID context ID for the service
	 * @return boolean indicating if the service is resubmittable
	 * @throws MonitorException
	 */
	public static boolean isResubmittable (String contextID)
			throws MonitorException
	{
		try {
			boolean resubmittable = false;
			// the resubmittable field in WMSERVICE tells us 2 things: is
			// the service top-level, and does it have pipeline logged.
			// if both are true, entry is logged as resubmittable.  note:
			// only input pipelines are ever logged, regardless of the status
			// of the log entry (e.g. if audit logging is set to only log
			// on error and completion, so you don't get a start row, the
			// pipeline that is logged at completion is the input pipeline
			// for the service, not the pipeline at completion).  this is
			// because input pipelines are the only thing that can be used
			// for resubmission.

			// this gets the resubmittable flag.  we need a separate call because if the
			// service is resubmittable, the resubmit flag is only set to true on the row
			// with the pipeline.  in most cases, this is the start status row, not the
			// current status row.
			int flag = _sa.getResubmitFlag(contextID);
			if (flag == 1)
			{
				// KLY - don't check current status any more, it doesn't matter
				// this gets the current status, so we can determine if the service is stopped
				//BasicList bl = _sa.getDetails(contextID);
				//if (bl.getRowCount() > 0)
				//{
					//bl.first();
					//int status = ((Integer)(bl.getRow())[bl.getIndex(COLNM_STATUS)]).intValue();
					//if ((status == STAT_ENDED) || (status == STAT_FAILED) ||
					        //(status == STAT_RETRIES_EXC) || (status == STAT_RESUBMITTED))
						resubmittable = true;
				//}
			}
			return resubmittable;
		} catch (SQLException e) {
			throw new MonitorException(e);
		}
	}

	// this is used to get a distinct list of all the service names in the db
	// used by access pages for permission setting.
    public static Vector getAllServiceNames (boolean filter, String entityType, String entityName)
            throws MonitorException
    {
        try {
            BasicList bl = _sa.getAllServiceNames();
            if (filter)
                bl.filter(COLNM_SVCNM, Permissions.getFilterAllowance(entityType, entityName, SVCFLTR_KEY));
            Vector v = new Vector();
            while (bl.next()) v.add((bl.getRow())[0]);
            return v;
        } catch (SQLException e) {
            //Debug.logCritical(252, Debug.MON, e.toString());
            throw new MonitorException(e);
        }
    }

    // this method is specifically for getting a list of distinct service names
    // for the webservice ws.monitor.service.getServiceNames to be used by DLS
	public static String[] getServiceNames()
	        throws MonitorException
	{
		try {
			BasicList bl = _sa.getAllServiceNames();
            int i = 0;
            String[] s = new String[bl.getRowCount()];
			while (bl.next())
            {
                s[i] = (String) (bl.getRow())[0];
                i++;
            }
			return s;
		} catch (SQLException e) {
			//Debug.logCritical(252, Debug.MON, e.toString());
			throw new MonitorException(e);
		}
	}
	
    /**
     * Retrieves the custom data for an instance.
     * 
     * @param contextID
     * @param fieldName - denotes the fieldName to filter by
     * @param sortBy - sort column
     * @param sort - sort order (asc or desc)
     * @return
     * @throws MonitorException
     */
    public static final Table getCustomData(String contextID, String fieldName, String sortBy, String sort) throws MonitorException {
        try {
    		BasicList bl = _sa.getCustomData(contextID, fieldName, sortBy, sort);
    		
            // create columns for the formatted table
			String[] cols = { COLNM_CID, COLNM_SVRID, COLNM_MSGID, COLNM_FLDNM, COLNM_STRVAL, COLNM_NUMVAL, COLNM_DATEVAL};
            
            Debug.logDebugPlus(4, 94, Debug.MON, bl);
            
            Table t = new Table(cols);
            if (bl != null) {
                while (bl.next()) {
                    Object[] row = bl.getRow(); // retrieve each field from the row
                    String cid = (String) row[bl.getIndex(COLNM_CID)];
                    String srvId = (String) row[bl.getIndex(COLNM_SVRID)];
                    String msgId = (String) row[bl.getIndex(COLNM_MSGID)];
                    String fldName = (String) row[bl.getIndex(COLNM_FLDALIAS)];
                    String strgval = (String) row[bl.getIndex(COLNM_STRVAL)];
                    Float numval = (Float) row[bl.getIndex(COLNM_NUMVAL)];
                    String numvalString = "0.0"; 
                    if(numval != null) {
                        numvalString = numval.toString();
                    }
                    String dateval = (String) row[bl.getIndex(COLNM_DATEVAL)];
                    String[] tr = new String[cols.length]; // create an array that will be filled in from retrieved fields

                    tr[0] = cid;
                    tr[1] = srvId;
                    tr[2] = msgId; 
                    tr[3] = fldName;
                    tr[4] = strgval;
                    tr[5] = numvalString;
                    tr[6] = dateval;
                    t.addRow(tr);
                }
            }
            return t;
        } catch (Exception e) {
            Debug.logError(8, Debug.MON, e.toString());
            Debug.logDebugPlus(4, 8, Debug.MON, Debug.stackTraceToString(e));
            throw new MonitorException(e, PkgUtil.msg(8, e.toString()));
        }
    }
}
