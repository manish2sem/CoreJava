package pub.monitor;

// -----( B2B Java Code Template v1.2
// -----( CREATED: Wed Apr 10 17:21:54 PDT 2002
// -----( ON-HOST: taipei

import java.util.Date;

import com.wm.app.b2b.server.InvokeState;
import com.wm.app.b2b.server.ServiceException;
import com.wm.app.b2b.server.Session;
import com.wm.data.IData;
import com.wm.data.ValuesEmulator;
import com.wm.monitor.app.Control;
import com.wm.monitor.app.Error;
import com.wm.monitor.app.Service;
import com.wm.monitor.common.app.Permissions;
import com.wm.monitor.common.util.Debug;
import com.wm.monitor.common.util.MonitorException;
import com.wm.monitor.common.util.MonitorUtil;
import com.wm.monitor.common.util.PkgUtil;
import com.wm.monitor.db.BasicList;
import com.wm.monitor.db.Constants;
import com.wm.monitor.permission.QueryAttributes;
import com.wm.util.Table;

// --- <<B2B-START-IMPORTS>> ---
// --- <<B2B-END-IMPORTS>> ---

public final class service implements Constants
{
	// ---( internal utility methods )---

	final static service _instance = new service();

	static service _newInstance() { return new service(); }

	static service _cast(Object o) { return (service)o; }

	// ---( server methods )---

	// This method displays the details of a service, showing the most recent status
	// for this particular service based on context id.  The data for this entry is
	// stored in the session object. It also determines whether or not this service can
	// be resubmitted. This is done by calling the method isResubmittable(String cid)
	// on ServiceAccess. Once it is determined that the service is resubmittable,
	// the pipeline is stored in the session object and the resubmit flag is set
	// to true.

	public static final void getDetails (IData pipeline)
        throws ServiceException
	{
		try {
			String contextID = MonitorUtil.getRequiredParam(pipeline, "contextID");
			Table t = Service.getDetails(contextID);
            IData pipe = Service.getPipeline(contextID);
            if(pipe == null) {
                ValuesEmulator.put(pipeline, "pipeNull", "true");
            } else {
                ValuesEmulator.put(pipeline, "pipeNull", "false");
            }
			ValuesEmulator.put(pipeline, "details", t);
		} catch (Exception e) {
			Debug.logError(211, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getDetails");
		}
	}

	public static final void isResubmittable (IData pipeline)
        throws ServiceException
	{
		try {
			String contextID = MonitorUtil.getRequiredParam(pipeline, "contextID");

			boolean r = Service.isResubmittable(contextID);
			ValuesEmulator.put(pipeline, "resubmittable", new Boolean(r).toString());
		} catch (Exception e) {
			Debug.logError(212, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "isResubmittable");
		}
	}

	public static final void exists (IData pipeline)
        throws ServiceException
	{
		try {
			String contextID = MonitorUtil.getRequiredParam(pipeline, "contextID");
			boolean exists = Service.exists(contextID);
			ValuesEmulator.put(pipeline, "exists", new Boolean(exists).toString());
		} catch (Exception e) {
			Debug.logError(225, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "exists");
		}
	}

	/** Service retrieves the basic service detail for the process step status page based on the cid passed in queried against
	 *  the parentcontextid entry in the wmservice table.
	 **/
	public static final void getChildDetails (IData pipeline)
        throws ServiceException
	{
		try {
			String pcid = MonitorUtil.getRequiredParam(pipeline, "contextID");

			Table t = Service.getChildDetails(pcid);
			MonitorUtil.storeInPipe("details", t, pipeline);
		} catch (Exception e) {
			Debug.logError(213, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getChildDetails");
		}
	}

	/**
	 *	Service retrieves the activity log data for a service.  Uses the cid passed in to build the context stack and
	 *	retrieve the related entry in the wmserviceactivitylog table.
	 **/
	public static final void getActivityLogs(IData pipeline)
        throws ServiceException
	{
		try {
			String contextID = MonitorUtil.getRequiredParam(pipeline, "contextID");

			Table t = null;
			BasicList bl = Service.getActivityLogStack(contextID);
			if (bl != null && bl.getRowCount() > 0)
			{
				t = new Table(bl.getFields());
				while (bl.next()) t.addRow(bl.getRow());
			}
			ValuesEmulator.put(pipeline, "activityLogs", t);
		} catch (Exception e) {
			Debug.logError(211, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getActivityLogs");
		}
	}

	/**
	 *	Services retrieves the errors for a service based on the errors logged
	 * against the service's cid.
	 **/
	public static final void getErrors(IData pipeline)
        throws ServiceException
	{
		try {
			String cid = MonitorUtil.getRequiredParam(pipeline, "contextID");
			Table t = null;
			BasicList bl = Error.getByContextID(cid);
			if (bl.getRowCount() > 0)
			{
				t = new Table(bl.getFields());
				while (bl.next()) { t.addRow(bl.getRow()); }
			}
			ValuesEmulator.put(pipeline, "errors", t);
		} catch (Exception e) {
			Debug.logError(211, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getErrors");
		}
	}

	public static final void getPipeline(IData pipeline)
	        throws ServiceException
	{
		try {
			String cid = MonitorUtil.getRequiredParam(pipeline, "contextID");
			IData pipe = Service.getPipeline(cid);
			ValuesEmulator.put(pipeline, "inputPipeline", pipe);
		} catch (Exception e) {
			Debug.logError(211, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getPipeline");
		}
	}

	/**
	 *	Service retrieves the control actions such as resubmit taken against a service.
	 **/
	public static final void getActions(IData pipeline)
		throws ServiceException
	{
		try {
			String cid = MonitorUtil.getRequiredParam(pipeline, "contextID");
			Table t = null;
			BasicList bl = Control.getServiceActions(cid);
			if (bl.getRowCount() > 0)
			{
				t = new Table(bl.getFields());
				while(bl.next()) { t.addRow(bl.getRow()); }
			}
			ValuesEmulator.put(pipeline, "actions", t);
		} catch (Exception e) {
			Debug.logError(211, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getActions");
		}
	}

	/**
	 *	Service shosw the history for a particular cid.
	 **/
	public static final void getHistory (IData pipeline)
        throws ServiceException
	{
		try {
			String cid = MonitorUtil.getRequiredParam(pipeline, "contextID");
			Table t = null;
			BasicList bl = Service.getHistory(cid);
			if (bl.getRowCount() > 0)
			{
				t = new Table(bl.getFields());
				while (bl.next())  t.addRow(bl.getRow());
			}
			ValuesEmulator.put(pipeline, "history", t);
		} catch (Exception e) {
			Debug.logError(214, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getHistory");
		}
	}

	/**
	 *	Service retrieves the service instances meeting the criteria
	 * specified in the custom query page.
	 **/
	public static final void getList (IData pipeline)
        throws ServiceException
	{
		//ndf checked into perforce
		    // [i] field:0:optional serviceName
            // [i] field:0:optional serviceNameExact {"FALSE", "TRUE"}
            // [i] field:0:optional serverID
            // [i] field:0:optional serverIDExact {"FALSE", "TRUE"}
            // [i] field:0:optional contextID
            // [i] field:0:optional parentContextID
            // [i] field:0:optional rootContextID
        	// [i] field:0:optional customContextID
            // [i] field:0:optional username
            // [i] field:0:optional status  {"Started", "Completed", "Failed", "Resubmitted", "Retried", "Activity"}
            // [i] field:1:optional statusSet
            // [i] field:0:optional range {"Today", "Yesterday", "In the last 7 days", "Last week", "This week", "Last month", "This month", "Year to date"}
            // [i] object:0:optional fromDate
            // [i] object:0:optional toDate
	        // [i] field:0:optional fieldName
	        // [i] field:0:optional fieldType {"String", "Number", "Date"}
	        // [i] field:0:optional comparator {"=", "Contains", "Not Contains", "!=", "<", ">", "<=", ">="}
	        // [i] field:0:optional value
            // [i] field:0:optional maxRows
            // [i] field:0:optional isAnd {"TRUE", "FALSE"}
			// [i] field:0:optional sortColumn 
			// [i] field:0:optional sortAscending {"true", "false"}
            // [o] record:1:required services

		try {
                //System.out.println("%%%%%%%%%%%%%%%"+pipeline.toString());
                String serviceName = ValuesEmulator.getString(pipeline, "serviceName");
                String sne = ValuesEmulator.getString(pipeline, "serviceNameExact");
                boolean serviceNameExact = ((sne != null && sne.equalsIgnoreCase("true")) ? true : false);
                String serverID = ValuesEmulator.getString(pipeline, "serverID");
                String sie = ValuesEmulator.getString(pipeline, "serverIDExact");
                boolean serverIDExact = ((sie != null && sie.equalsIgnoreCase("true")) ? true : false);
                String rcid = ValuesEmulator.getString(pipeline, "rootContextID");
                String pcid = ValuesEmulator.getString(pipeline, "parentContextID");
                String cid = ValuesEmulator.getString(pipeline, "contextID");
                String ccid = ValuesEmulator.getString(pipeline, "customContextID");
                String username = ValuesEmulator.getString(pipeline, "username");
                String [] svcStatusList = ValuesEmulator.getStringArray(pipeline, "statusSet");
                int [] svcStatusSet = null;
                if (svcStatusList == null || (svcStatusList != null && svcStatusList.length == 0))
                {
                    String status = ValuesEmulator.getString(pipeline, "status");
                    svcStatusSet = MonitorUtil.convertServiceStatus(new String [] {status});
                } else {
                    svcStatusSet = MonitorUtil.convertServiceStatus(svcStatusList);
                }
                String selectRange = ValuesEmulator.getString(pipeline, "range");
                Date fromDate = (Date) ValuesEmulator.get(pipeline, "fromDate");
                Date toDate = (Date) ValuesEmulator.get(pipeline, "toDate");
                
                int maxRows = ValuesEmulator.getInt(pipeline, "maxRows", 0);
                String ia = ValuesEmulator.getString(pipeline, "isAnd");
                boolean isAnd = ((ia == null) || (ia != null && ia.equalsIgnoreCase("true")) ? true : false);
                Table t = null;
                BasicList bl = Service.getList(rcid, pcid, cid, ccid,
                        serviceName, serviceNameExact, serverID, serverIDExact,
                        username, selectRange,
                        (fromDate == null ? new Long(0) : new Long(fromDate.getTime())),
                        (toDate == null ? new Long(0) : new Long(toDate.getTime())),
                        svcStatusSet, maxRows, isAnd);
                if (bl.getRowCount() > 0)
                {
                    String sortCol = ValuesEmulator.getString(pipeline, "sortColumn");
                    if (sortCol != null && sortCol.length() > 0)
                    {
					// Fix for WMN-3804
                    if (sortCol.equals("AUDITTIMESTAMP")) {
	                    sortCol = "LASTTIME";
	                 }
                        String sa = ValuesEmulator.getString(pipeline, "sortAscending");
                        boolean sortAsc = ((sa != null && sa.equalsIgnoreCase("true")) ? true : false);
                        bl.sort(sortCol, sortAsc);
                    }
                    t = new Table(bl.getFields());
                    while (bl.next()) t.addRow(bl.getRow());
                }
                if(t==null)t=new Table();
                ValuesEmulator.put(pipeline, "services", t.getItems());
            } catch (Exception e) {
                Debug.logError(217, Debug.MON, e.toString());
                MonitorUtil.rethrow(e, CLASS, "getList");
            }
	}
	
	
	public static final void getListCustomData(IData pipeline) throws ServiceException
	{
			//ndf checked into perforce
		    // [i] field:0:optional serviceName
	        // [i] field:0:optional serviceNameExact {"FALSE", "TRUE"}
	        // [i] field:0:optional serverID
	        // [i] field:0:optional serverIDExact {"FALSE", "TRUE"}
	        // [i] field:0:optional contextID
	        // [i] field:0:optional parentContextID
	        // [i] field:0:optional rootContextID
	    	// [i] field:0:optional customContextID
	        // [i] field:0:optional username
	        // [i] field:0:optional status  {"Started", "Completed", "Failed", "Resubmitted", "Retried", "Activity"}
	        // [i] field:1:optional statusSet
	        // [i] field:0:optional range {"Today", "Yesterday", "In the last 7 days", "Last week", "This week", "Last month", "This month", "Year to date"}
	        // [i] object:0:optional fromDate
	        // [i] object:0:optional toDate
        	// [i] field:2:optional customTable
	        // [i] field:0:optional maxRows
	        // [i] field:0:optional isAnd {"TRUE", "FALSE"}
			// [i] field:0:optional sortColumn 
			// [i] field:0:optional sortAscending {"true", "false"}
	        // [o] record:1:required services
	
		try {
	            //System.out.println("%%%%%%%%%%%%%%%"+pipeline.toString());
		        Session session = InvokeState.getCurrentSession();
		        BasicList bl = null;
	            String serviceName = ValuesEmulator.getString(pipeline, "serviceName");
	            String sne = ValuesEmulator.getString(pipeline, "serviceNameExact");
	            boolean serviceNameExact = ((sne != null && sne.equalsIgnoreCase("true")) ? true : false);
	            String serverID = ValuesEmulator.getString(pipeline, "serverID");
	            String sie = ValuesEmulator.getString(pipeline, "serverIDExact");
	            boolean serverIDExact = ((sie != null && sie.equalsIgnoreCase("true")) ? true : false);
	            String rcid = ValuesEmulator.getString(pipeline, "rootContextID");
	            String pcid = ValuesEmulator.getString(pipeline, "parentContextID");
	            String cid = ValuesEmulator.getString(pipeline, "contextID");
	            String ccid = ValuesEmulator.getString(pipeline, "customContextID");
	            String username = ValuesEmulator.getString(pipeline, "username");
	            String [] svcStatusList = ValuesEmulator.getStringArray(pipeline, "statusSet");
	            int [] svcStatusSet = null;
	            if (svcStatusList == null || (svcStatusList != null && svcStatusList.length == 0))
	            {
	                String status = ValuesEmulator.getString(pipeline, "status");
	                svcStatusSet = MonitorUtil.convertServiceStatus(new String [] {status});
	            } else {
	                svcStatusSet = MonitorUtil.convertServiceStatus(svcStatusList);
	            }
	            String selectRange = ValuesEmulator.getString(pipeline, "range");
	            Date fromDate = (Date) ValuesEmulator.get(pipeline, "fromDate");
	            Date toDate = (Date) ValuesEmulator.get(pipeline, "toDate");
	            
	            int maxRows = ValuesEmulator.getInt(pipeline, "maxRows", 0);
	            String ia = ValuesEmulator.getString(pipeline, "isAnd");
	            boolean isAnd = ((ia == null) || (ia != null && ia.equalsIgnoreCase("false")) ? false : true);
	            
	            String fieldName = ValuesEmulator.getString(pipeline, "fieldName");
	            String fieldType = ValuesEmulator.getString(pipeline, "fieldType");
	            String comparator = ValuesEmulator.getString(pipeline, "comparator");
	            String value = ValuesEmulator.getString(pipeline, "value");
	            
	            if(fieldName != null  && fieldType != null && comparator != null && value != null) {
	                String [][] customTable = new String [1][CUSTOM_TABLE_WIDTH];
	                customTable[0][0] = fieldName;
	                customTable[0][1] = fieldType;
	                customTable[0][2] = comparator;
	                customTable[0][3] = value;
	                bl = Service.getListCustom(com.wm.app.b2b.server.Service.getUser(), session.getLocale(),
	                		rcid, pcid, cid, ccid,
	                        serviceName, serviceNameExact, serverID, serverIDExact,
	                        username, selectRange,
	                        (fromDate == null ? new Long(0) : new Long(fromDate.getTime())),
	                        (toDate == null ? new Long(0) : new Long(toDate.getTime())),
	                        svcStatusSet, customTable, maxRows, isAnd);
	                
	            } else {
	                bl = Service.getList(rcid, pcid, cid, ccid,
	                        serviceName, serviceNameExact, serverID, serverIDExact,
	                        username, selectRange,
	                        (fromDate == null ? new Long(0) : new Long(fromDate.getTime())),
	                        (toDate == null ? new Long(0) : new Long(toDate.getTime())),
	                        svcStatusSet, maxRows, isAnd);
	            }
	            String sortBy = (String)ValuesEmulator.get(pipeline, "sortColumn");
	            String sortOrder = (String)ValuesEmulator.get(pipeline, "sortAscending");
	            if(bl != null && sortBy != null && !sortBy.equals("") && sortOrder != null && !sortOrder.equals("")){
	                if(sortOrder.equals("true"))
	                    bl.sort(sortBy, true);
	                else
	                    bl.sort(sortBy, false);
	            }
	            Table t =  null;
	            if(bl != null && bl.getRowCount() > 0) {
	                t = new Table(bl.getFields());
	                while(bl.next()) {
	                    t.addRow(bl.getRow());
	                }
	            }
	            ValuesEmulator.put(pipeline, "services", t);
	        } catch(Exception e) {
	            Debug.logError(28, Debug.MON, e.toString());
			    String message = PkgUtil.msg(28, e.toString());
	            ValuesEmulator.put(pipeline, "message", message);
	            MonitorUtil.rethrow(e, CLASS, "getListCustomData");
	        }
	}
	
	public static final void getListCustomDataSet(IData pipeline) throws ServiceException
	{
			//ndf checked into perforce
		    // [i] field:0:optional serviceName
	        // [i] field:0:optional serviceNameExact {"FALSE", "TRUE"}
	        // [i] field:0:optional serverID
	        // [i] field:0:optional serverIDExact {"FALSE", "TRUE"}
	        // [i] field:0:optional contextID
	        // [i] field:0:optional parentContextID
	        // [i] field:0:optional rootContextID
	    	// [i] field:0:optional customContextID
	        // [i] field:0:optional username
	        // [i] field:0:optional status  {"Started", "Completed", "Failed", "Resubmitted", "Retried", "Activity"}
	        // [i] field:1:optional statusSet
	        // [i] field:0:optional range {"Today", "Yesterday", "In the last 7 days", "Last week", "This week", "Last month", "This month", "Year to date"}
	        // [i] object:0:optional fromDate
	        // [i] object:0:optional toDate
	        // [i] field:0:optional maxRows
	        // [i] field:0:optional isAnd {"TRUE", "FALSE"}
			// [i] field:0:optional sortColumn 
			// [i] field:0:optional sortAscending {"true", "false"}
	        // [o] record:1:required services
	
		try {
	            //System.out.println("%%%%%%%%%%%%%%%"+pipeline.toString());
		        Session session = InvokeState.getCurrentSession();
		        BasicList bl = null;
	            String serviceName = ValuesEmulator.getString(pipeline, "serviceName");
	            String sne = ValuesEmulator.getString(pipeline, "serviceNameExact");
	            boolean serviceNameExact = ((sne != null && sne.equalsIgnoreCase("true")) ? true : false);
	            String serverID = ValuesEmulator.getString(pipeline, "serverID");
	            String sie = ValuesEmulator.getString(pipeline, "serverIDExact");
	            boolean serverIDExact = ((sie != null && sie.equalsIgnoreCase("true")) ? true : false);
	            String rcid = ValuesEmulator.getString(pipeline, "rootContextID");
	            String pcid = ValuesEmulator.getString(pipeline, "parentContextID");
	            String cid = ValuesEmulator.getString(pipeline, "contextID");
	            String ccid = ValuesEmulator.getString(pipeline, "customContextID");
	            String username = ValuesEmulator.getString(pipeline, "username");
	            String [] svcStatusList = ValuesEmulator.getStringArray(pipeline, "statusSet");
	            int [] svcStatusSet = null;
	            if (svcStatusList == null || (svcStatusList != null && svcStatusList.length == 0))
	            {
	                String status = ValuesEmulator.getString(pipeline, "status");
	                svcStatusSet = MonitorUtil.convertServiceStatus(new String [] {status});
	            } else {
	                svcStatusSet = MonitorUtil.convertServiceStatus(svcStatusList);
	            }
	            String selectRange = ValuesEmulator.getString(pipeline, "range");
	            Date fromDate = (Date) ValuesEmulator.get(pipeline, "fromDate");
	            Date toDate = (Date) ValuesEmulator.get(pipeline, "toDate");
	            
	            int maxRows = ValuesEmulator.getInt(pipeline, "maxRows", 0);
	            String ia = ValuesEmulator.getString(pipeline, "isAnd");
	            boolean isAnd = ((ia == null) || (ia != null && ia.equalsIgnoreCase("false")) ? false : true);
	            
	            String [][] customTable = (String [][])ValuesEmulator.get(pipeline, "customTable");
	            if(customTable != null && customTable.length > 0 && customTable[0].length == CUSTOM_TABLE_WIDTH) {
	                bl = Service.getListCustom(com.wm.app.b2b.server.Service.getUser(), session.getLocale(),
	                		rcid, pcid, cid, ccid,
	                        serviceName, serviceNameExact, serverID, serverIDExact,
	                        username, selectRange,
	                        (fromDate == null ? new Long(0) : new Long(fromDate.getTime())),
	                        (toDate == null ? new Long(0) : new Long(toDate.getTime())),
	                        svcStatusSet, customTable, maxRows, isAnd);
	                
	            } else {
	                bl = Service.getList(rcid, pcid, cid, ccid,
	                        serviceName, serviceNameExact, serverID, serverIDExact,
	                        username, selectRange,
	                        (fromDate == null ? new Long(0) : new Long(fromDate.getTime())),
	                        (toDate == null ? new Long(0) : new Long(toDate.getTime())),
	                        svcStatusSet, maxRows, isAnd);
	            }
	            String sortBy = (String)ValuesEmulator.get(pipeline, "sortColumn");
	            String sortOrder = (String)ValuesEmulator.get(pipeline, "sortAscending");
	            if(bl != null && sortBy != null && !sortBy.equals("") && sortOrder != null && !sortOrder.equals("")){
	                if(sortOrder.equals("true"))
	                    bl.sort(sortBy, true);
	                else
	                    bl.sort(sortBy, false);
	            }
	            Table t =  null;
	            if(bl != null && bl.getRowCount() > 0) {
	                t = new Table(bl.getFields());
	                while(bl.next()) {
	                    t.addRow(bl.getRow());
	                }
	            }
	            ValuesEmulator.put(pipeline, "services", t);
	        } catch(Exception e) {
	            Debug.logError(28, Debug.MON, e.toString());
			    String message = PkgUtil.msg(28, e.toString());
	            ValuesEmulator.put(pipeline, "message", message);
	            MonitorUtil.rethrow(e, CLASS, "getListCustomDataSet");
	        }
	}
	
    /**
	 *	Service retrieves a list of services by loading a saved custom query.
	 **/
	public static final void getListByQueryName (IData pipeline)
        throws ServiceException
	{
		try {
            Table t = null;
            ValuesEmulator.put(pipeline, "queryType", QueryAttributes.SVC_QUERIES);
            com.wm.app.b2b.server.Service.doInvoke("wm.monitor.customQuery", "loadQueryByName", pipeline);
            //determine object type
            //ifkeyvalue, call getInstanceList with valueSet
            IData data = (IData)ValuesEmulator.get(pipeline, "inputFields");

            if(data != null) {
                String status = ValuesEmulator.getString(data, "status");
                //System.out.println("status is: " + status);
                if(MonitorUtil.charCheck(status, "_")) {
                    String [] statusSet = MonitorUtil.createArray(status, "_");
                    ValuesEmulator.put(data, "statusSet", statusSet);
                }  else {
                    ValuesEmulator.put(data, "statusSet", new String [] {status});
                }
                //System.out.println("$$$$$$$$$$$$$data is: " + data);
                getList(data);
                t = (Table)ValuesEmulator.get(data, "services");
                ValuesEmulator.remove(data, "services");
            } else {
            //if string, call getList with string and put bl into table and put into pipeline
                String select = ValuesEmulator.getString(pipeline, "selectClause");
                String where = ValuesEmulator.getString(pipeline, "whereClause");
                if(select != null && where != null) {
                    BasicList bl = Service.getList(select+where);
                    t =  null;
                    if(bl.getRowCount() > 0) {
                        t = new Table(bl.getFields());
                        while(bl.next()) {
                            t.addRow(bl.getRow());
                        }
                    }
                }
            }
            ValuesEmulator.put(pipeline, "services", t);
		} catch (Exception e) {
			Debug.logError(217, Debug.MON, e.toString());
			MonitorUtil.rethrow(e, CLASS, "getListByQueryName");
		}
	}
    /**
     * Retrieves a query list for processes
     * @throws MonitorException
     */
    public static final void getQueryList (IData pipeline)
        throws MonitorException
	{
        try {
            boolean display = ValuesEmulator.getBoolean(pipeline, "display");
            com.wm.util.Table t = QueryAttributes.getQueryList(com.wm.app.b2b.server.Service.getUser().getName(),
                    QueryAttributes.SVC_QUERIES, display);
            ValuesEmulator.put(pipeline, "queryList", t);
        } catch(Exception e) {
            Debug.logError(844, Debug.MON, e.toString());
            ValuesEmulator.put(pipeline, "message", PkgUtil.msg(844, e.toString()));
            MonitorUtil.rethrow(e, CLASS, "getQueryList");
        }
    }
    
    /**
     * Retrieves custom data for a service.
     * @param contextID
     * @param fieldName
     * @param sortBy
     * @param sortOrder
     * @throws ServiceException
     * @return customData
     * @return message
     */
    public static final void getCustomData(IData pipeline) throws ServiceException {

		// [i] field:0:required contextID
		// [i] field:0:optional fieldName
		// [i] field:0:optional sortBy {SERVERID, MSGID, FIELDNAME, FIELDALIAS, STRINGVALUE, NUMBERVALUE, DATEVALUE}
		// [i] field:0:optional sortOrder {0,1}
		// [o] record:1:required customData
        // [o] field:0:optional message

        try {
            String id = MonitorUtil.getRequiredParam(pipeline, "contextID");
            String fieldName = (String)ValuesEmulator.get(pipeline, "fieldName");
            String sort = (String)ValuesEmulator.get(pipeline, "sortBy");
            String sortOrder = (String)ValuesEmulator.get(pipeline, "sortOrder");
            if(Permissions.getBooleanSetting(com.wm.app.b2b.server.Service.getUser().getName(), Permissions.VIEWCUSTDATA_KEY)) {
                Table t = Service.getCustomData(id, fieldName, sort, sortOrder);
                ValuesEmulator.put(pipeline, "customData", t);
            }
		 } catch(Exception e) {
		 	Debug.logError(55, Debug.MON, e);
            ValuesEmulator.put(pipeline, "message", PkgUtil.msg(55, e.toString()));
            MonitorUtil.rethrow(e, CLASS, "getCustomData");
		 }
    }
    
	private static final String CLASS = "pub.monitor.service";
    public static final int CUSTOM_TABLE_WIDTH = 4;
}
