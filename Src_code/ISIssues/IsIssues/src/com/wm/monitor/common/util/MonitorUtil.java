/*
 * $Id: //bpodepot/optimize/gungan/src/portlets/mywebmethods/businessmonitoring/wm_bam_instance_list/src/com/webmethods/bpo/portlet/wm_bam_instance_list/PortalProcessInstance.java#4 $
 * $DateTime: 2005/11/14 16:45:53 $
 * $Revision: #4 $
 *
 * Copyright 2003-2005 webMethods, Inc. All rights reserved.
 * Copyright 2003-2005 webMethods, Inc. Tous droits reserves.
 */
package com.wm.monitor.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

import com.webmethods.sc.WmSecureString;
import com.wm.app.audit.AuditException;
import com.wm.app.audit.IAuditRuntime;
import com.wm.app.b2b.server.AuditLogManager;
import com.wm.app.b2b.server.Server;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
import com.wm.app.b2b.server.Session;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.data.ValuesEmulator;
import com.wm.monitor.db.BasicList;
import com.wm.monitor.db.Constants;
import com.wm.monitor.db.DbUtil;
import com.wm.monitor.db.ProcessAccess;
import com.wm.monitor.db.querygeneration.Column;
import com.wm.monitor.db.querygeneration.CriteriaSet;
import com.wm.monitor.db.querygeneration.Criterion;
import com.wm.monitor.db.querygeneration.DateTime;
import com.wm.monitor.db.querygeneration.Field;
import com.wm.monitor.db.querygeneration.InList;
import com.wm.monitor.db.querygeneration.PSParameter;
import com.wm.monitor.db.querygeneration.Query;
import com.wm.monitor.db.querygeneration.QueryGenerationException;
import com.wm.monitor.db.querygeneration.Range;
import com.wm.security.OutboundPasswordStore;
import com.wm.util.Table;
import com.wm.util.Values;
import com.wm.util.coder.IDataBinCoder;
import com.wm.util.coder.InvalidDatatypeException;

/**
 * @version $Revision: #4 $ $DateTime: 2005/11/14 16:45:53 $
 */
public class MonitorUtil {

	// relative date values
	public final static String TIME_TODAY = "Today";
	public final static String TIME_YESTERDAY = "Yesterday";
	public final static String TIME_LAST_7_DAYS = "In the last 7 days";
	public final static String TIME_LAST_WEEK = "Last week";
	public final static String TIME_THIS_WEEK = "This week";
	public final static String TIME_LAST_MONTH = "Last month";
	public final static String TIME_THIS_MONTH = "This month";
	public final static String TIME_YEAR_TO_DATE = "Year to date";
	public static String INVALIDCHAR = null;
	public final static String TIME_ALL = "ALL";

	final static String ARRAY_DELIM = "!"; // yes, this is wierd. # and % got
											// stripped out by the UI, so those
											// don't work.

	// makes a BasicList based on a table. it is assumed that the table is
	// correctly formatted (i.e. the columns names and the values in the
	// columns correspond regarding type).
	// if there are no column names defined in the table, this method will
	// throw a runtime exception. a BasicList can't be created without
	// column names.
	public static BasicList getBasicList(com.wm.util.Table t) {
		return getBasicList(t, Locale.getDefault());
	}

	public static BasicList getBasicList(com.wm.util.Table t, Locale loc) {
		if (t.getColumnNames() == null)
			throw new RuntimeException(
					"Table columns are not defined.  It cannot be transformed into a valid BasicList.");
		BasicList bl = new BasicList(t.getColumnNames(), t.rows, loc);
		return bl;
	}

	private static Properties propMonitor = null;

	public static boolean initMonitorProperties(Properties prop) {
		boolean result = true;
//		if (propMonitor == null)
			propMonitor = prop;
//		else
			// monitor properties should only be set once, on startup
//			result = false;

		return result;
	}

	/**
	 * Sets the property value associated with a property key in the Monitor
	 * property list and saves the new property/value in the Monitor config
	 * file. Creates a new pair if the key didn't exist before.
	 * 
	 * @param key
	 *            the key to be added to or updated in the property list
	 * @param value
	 *            the value corresponding to the key
	 * @return the previous value of the key, or null if it didn't have one
	 */
	public static boolean setMonitorProperty(String key, String value) {
		boolean result = false;
		try {
			// update the config file
			File cnf = new File(Server.getResources().getPackageConfigDir(
					"WmMonitor"), "monitor.cnf");
			FileOutputStream fos = new FileOutputStream(cnf);
			propMonitor.setProperty(key, value);
			propMonitor.store(fos, "Monitor configuration settings");
			fos.close();
			result = true;
		} catch (FileNotFoundException fnfe) {
			// monitor config file could not be found or created or is read-only
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			// write to config file failed
			ioe.printStackTrace();
		}
		return result;
	}

	/**
	 * Gets the property with the specified key from the Monitor property list.
	 * 
	 * @param key
	 *            key for requested property
	 * @return the value for the specified key. null if the property is not
	 *         found or the property file doesn't exist.
	 */
	public static String getMonitorProperty(String key) {
		return (propMonitor == null ? null : propMonitor.getProperty(key));
	}

	public static void storeInPipe(String key, com.wm.util.Table t,
			IData pipeline) {
		IDataCursor pc = pipeline.getCursor();
		pc.last();
		if (t != null && t.getRowCount() > 0) {
			pc.insertAfter(key, t);
		}
		pc.destroy();
	}

	public static com.wm.util.Table convertBasicListToTable(BasicList bl) {
		Table t = null;
		if (bl.getRowCount() > 0) {
			t = new Table(bl.getFields());
			while (bl.next()) {
				t.addRow(bl.getRow());
			}
		}
		return t;
	}

	public static com.wm.util.Table convertBasicListToTable(BasicList bl,
			String[] cols) {
		Table t = null;
		if (bl.getRowCount() > 0) {
			t = new Table(cols);
			while (bl.next()) {
				t.addRow(bl.getRow());
			}
		}
		return t;
	}

	// this method takes whatever is the current row and puts all the values
	// into an IData.
	// if no IData is passed in, this method creates one.
	// if the BasicList is not currently pointing at a row, this method will
	// either return null (if the current index
	// is past the end of the list) or probably throw an exception (if the index
	// is negative).
	public static IData convertBasicListRowToIData(BasicList bl, IData i) {
		Object[] row = bl.getRow();
		return convertBasicListRowToIData(bl, row, i);
	}

	// this method does the same thing, but allows the user to supply the row.
	public static IData convertBasicListRowToIData(BasicList bl, Object[] row,
			IData i) {
		if (i == null)
			i = IDataFactory.create();
		String[] fields = bl.getFields();
		IDataCursor c = i.getCursor();
		for (int x = 0; x < bl.getFieldCount(); x++)
			c.insertAfter(fields[x], row[x]);
		c.destroy();
		return i;
	}

	public static void storeInPipeAndSession(String key, Object o,
			IData pipeline) {
		IDataCursor pc = pipeline.getCursor();
		pc.last();
		Session _session = Service.getSession();
		if (o != null) {
			pc.insertAfter(key, o);
			_session.putClean(key, o);
		}
		if (o == null) {
			_session.putClean(key, null);
		}
		pc.destroy();
	}

	public static void storeInPipeAndSession(String key, com.wm.util.Table t,
			IData pipeline) {
		IDataCursor pc = pipeline.getCursor();
		pc.last();
		Session _session = Service.getSession();
		if (t != null && t.getRowCount() > 0) {
			pc.insertAfter(key, t);
			_session.putClean(key, t);
		}
		if (t == null || (t != null && t.getRowCount() == 0)) {
			_session.putClean(key, null);
		}
		pc.destroy();
	}

	public static void storeInPipeAndSession(String key, String val,
			IData pipeline) {
		IDataCursor pc = pipeline.getCursor();
		pc.first();
		pc.insertAfter(key, val);
		Session _session = Service.getSession();
		_session.putClean(key, val);

		pc.destroy();
	}

	// why does ValuesEmulator not have these methods? I don't know.
	public static long getLong(IData pipeline, String key) {
		return getLong(pipeline, key, -1);
	}

	public static long getLong(IData pipeline, String key, long def) {
		long ret = def;
		Object o = ValuesEmulator.get(pipeline, key);
		if (o != null) {
			try {
				ret = Long.parseLong(o.toString());
			} catch (Exception exception) {
			} // just return default if it's an invalid value
		}
		return ret;
	}

	// convert byte[] to IData and put in the session object
	public static void convertByteArrayToIData(byte[] blob, String key) {
		if (blob != null) {
			IDataBinCoder coder = new IDataBinCoder();
			try {
				IData servicePipeline = (IData) coder
						.decode(new ByteArrayInputStream(blob));
				// put pipeline in session
				Session _session = Service.getSession();
				_session.putClean(key, servicePipeline);
				_session.remove("IDataEditOut");
				_session.remove("GlobalDataOut");
			} catch (IOException e) {
				Debug.logCritical(215, Debug.MON, e.toString());
			}
		} else {
			Debug.logCritical(203, Debug.MON);
		}
	}

	// convert byte[] to IData
	public static IData convertByteArrayToIData(byte[] blob) {
		IData d = null;
		if (blob != null) {
			IDataBinCoder coder = new IDataBinCoder();
			try {
				d = (IData) coder.decode(new ByteArrayInputStream(blob));
			} catch (IOException e) {
				Debug.logCritical(215, Debug.MON, e.toString());
			}
		} else {
			Debug.logCritical(203, Debug.MON);
		}
		return d;
	}

	/**
	 * transform a Map into an IData.
	 * 
	 * @param i
	 *            IData to which the Map should be added. If null, create and
	 *            return a new IData.
	 * @param m
	 *            the Map to transform.
	 * @return the IData object which was passed in, or a new IData if no IData
	 *         was passed in.
	 */
	public static IData convertMapToIData(IData i, Map m) {
		if (i == null)
			i = IDataFactory.create();
		IDataCursor c = i.getCursor();
		for (Iterator iter = m.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			Object value = m.get(key);

			if (value instanceof Map)
				c.insertAfter(key, convertMapToIData(null, (Map) value));
			else if (value instanceof Map[])
				c.insertAfter(key, convertMapArrayToIDataArray((Map[]) value));
			else
				c.insertAfter(key, m.get(key));
		}
		c.destroy();
		return i;
	}

	public static IData[] convertMapArrayToIDataArray(Map[] m) {
		IData[] i = new IData[m.length];
		for (int y = 0; y < m.length; y++)
			i[y] = convertMapToIData(null, m[y]);
		return i;
	}

	public static Map<String,Object> convertIDataToMap(IData i) {
		Map<String,Object> m = new HashMap<String,Object>();
		if (i != null) {
			String key = null;
			Object value = null;

			IDataCursor c = i.getCursor();
			while (c.next()) {
				key = c.getKey();
				value = c.getValue();
				Debug.logDebugPlus(6, 0, Debug.DB, "  key <" + key
						+ ">, value <" + value + ">");
				if (value instanceof IData)
					value = convertIDataToMap((IData) c.getValue());
				else if (value instanceof IData[])
					value = convertIDataArrayToMapArray((IData[]) c.getValue());
				else if (value instanceof Table)
					value = convertTableToMapArray((Table) c.getValue());
				m.put(key, value);
			}
			c.destroy();
		}
		return m;
	}

	public static Map<String,Object>[] convertIDataArrayToMapArray(IData[] i) {
		Map<String,Object>[] m = new HashMap[i.length];
		for (int y = 0; y < i.length; y++) {
			m[y] = convertIDataToMap(i[y]);
		}
		return m;
	}

	public static Map<String,Object>[] convertTableToMapArray(Table t) {
		Values[] v = t.getValues();
		Map<String,Object>[] m = convertIDataArrayToMapArray(v);
		return m;
	}
	
	
	/**
	 * From http://benjchristensen.com/2008/02/07/how-to-strip-invalid-xml-
	 * characters/ This method ensures that the output String has only valid XML
	 * unicode characters as specified by the XML 1.0 standard. For reference,
	 * please see <a
	 * href=?http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char?>the
	 * standard</a>. This method will return an empty String if the input is
	 * null or empty.
	 * 
	 * @param in
	 *            The String whose non-valid characters we want to remove.
	 * @return The in String, stripped of non-valid characters.
	 */
	public static String stripNonValidXMLCharacters(String in) {
		StringBuffer out = new StringBuffer(); // Used to hold the output.
		char current; // Used to reference the current character.

		if (in == null || ("".equals(in)))
			return ""; // vacancy test.
		for (int i = 0; i < in.length(); i++) {
			current = in.charAt(i); 
			if ((current == 0x9) || (current == 0xA) || (current == 0xD)
					|| ((current >= 0x20) && (current <= 0xD7FF))
					|| ((current >= 0xE000) && (current <= 0xFFFD))
					|| ((current >= 0x10000) && (current <= 0x10FFFF)))
				out.append(current);
		}
		return out.toString();
	}  	
	

	/*
	 * each row in the list consists of (path, parentpath, key, value, type)
	 * path is a specific syntax meant to locate the current key in an IData
	 * structure parentpath is the same syntax for the parent of the current key
	 * key is a nicely formatted string indicating the key at this level - used
	 * for viewing value is the value type is the value data type path and
	 * parentpath are used by the display tree table object to determine the
	 * tree hierarchy path syntax is indicated by the delimiters in the code:
	 * col=, row=\n array=# arrays are indicated at 2 levels: the key of the
	 * array is one level, then the children of the array level are the actual
	 * members of the array
	 */
	public static List convertIDataToFlatList(String parent, IData i) {
		String COL_DELIM = ",";
		String ROW_DELIM = "\n";
		IDataCursor cursor = null;
		String dataKey;
		Object dataValue;
		String dataType = "none"; // needs to be non-null
		List l = new ArrayList();
		String delimBookmark = (parent.equals("") ? "" : ":~:");
		try {
			cursor = i.getCursor();
			while (cursor.next()) {
				Debug.logDebugPlus(5, 0, Debug.MON, "  parent <" + parent + ">");
				dataKey = cursor.getKey();
				Debug.logDebugPlus(5, 0, Debug.MON, "  dataKey <" + dataKey
						+ ">");
				dataValue = cursor.getValue();
				Debug.logDebugPlus(5, 0, Debug.MON, "  dataValue <" + dataValue
						+ ">");
				if (dataValue != null) {
					dataType = dataValue.getClass().getName();
					if (dataType.startsWith("java.lang"))
						dataType = dataType.substring(10);
					else if (dataType.startsWith("java.util"))
						dataType = dataType.substring(10);
					Debug.logDebugPlus(5, 0, Debug.MON, "  dataType <"
							+ dataType + ">");
				}

				// if value is a basic type
				if ("Integer,Short,Long,Float,Double,Date,Character,Byte"
						.indexOf(dataType) >= 0) {
					StringBuffer sb = new StringBuffer().append(parent)
							.append(delimBookmark).append(dataKey).append(",");
					sb.append(parent).append(COL_DELIM);
					sb.append(dataKey).append(COL_DELIM);
					if (dataValue == null)
						sb.append("null").append(COL_DELIM);
					else
						sb.append(dataValue).append(COL_DELIM);
					sb.append(dataType).append(ROW_DELIM);
					l.add(sb.toString());
					Debug.logDebugPlus(5, 0, Debug.MON,
							" basic type: " + sb.toString());
				} else if (dataType.equals("String")) {
					StringBuffer sb = new StringBuffer().append(parent)
							.append(delimBookmark).append(dataKey).append(",");
					sb.append(parent).append(COL_DELIM);
					sb.append(dataKey).append(COL_DELIM);
					if (dataValue == null) // port of 1URP1G
					{
						sb.append("null").append(COL_DELIM);
					} else{
						// extra check for a special case when using file
						// adapter. fwd port
						if (dataValue.toString().indexOf("\b") == 0)
							sb.append("null").append(COL_DELIM);
						else
							sb.append(
									((String) dataValue).replaceAll(COL_DELIM,
											"%2C")).append(COL_DELIM);
						// /extra check for special characters used by file
						// adapter as valid record delimiters
						// within document content
						String temp = "";
						temp = sb.toString();

						sb = new StringBuffer(stripNonValidXMLCharacters(temp));
					}
					sb.append(dataType).append(ROW_DELIM);
					l.add(sb.toString());
					Debug.logDebugPlus(5, 0, Debug.MON,
							" basic type: " + sb.toString());
				} else { // value is not a basic type
					IData d = null;
					if (dataValue instanceof IData) {
						d = (IData) dataValue;
					}
					if (d != null) { // handle IData case
						StringBuffer sb = new StringBuffer().append(parent)
								.append(delimBookmark).append(dataKey)
								.append(",");
						sb.append(parent).append(COL_DELIM);
						sb.append(dataKey).append(COL_DELIM);
						sb.append(COL_DELIM); // don't show a value on record
												// rows
						sb.append("Record").append(ROW_DELIM);
						l.add(sb.toString());
						Debug.logDebugPlus(5, 0, Debug.MON,
								" record: " + sb.toString());
						l.addAll(convertIDataToFlatList(parent + delimBookmark
								+ dataKey, d));
					} else {
						if (dataValue instanceof IData[]) { // handle IData[]
															// case
							IData[] da = (IData[]) dataValue;
							// this makes the array show up as expandable under
							// a heading. also takes care of empty recordlist
							StringBuffer sb = new StringBuffer().append(parent)
									.append(delimBookmark).append(dataKey)
									.append(",");
							sb.append(parent).append(COL_DELIM);
							sb.append(dataKey).append(COL_DELIM);
							sb.append(COL_DELIM);
							sb.append("Record#").append(ROW_DELIM);
							l.add(sb.toString());
							for (int j = 0; j < da.length; j++) {
								StringBuffer thisKey = new StringBuffer(dataKey)
										.append(ARRAY_DELIM).append(j);
								sb = new StringBuffer().append(parent)
										.append(delimBookmark).append(thisKey)
										.append(COL_DELIM);
								sb.append(parent).append(delimBookmark)
										.append(dataKey).append(COL_DELIM); // all
																			// members
																			// of
																			// the
																			// array
																			// are
																			// children
																			// of
																			// the
																			// parent
																			// created
																			// immediately
																			// above
								sb.append(dataKey).append("[").append(j)
										.append("]").append(COL_DELIM);
								sb.append(COL_DELIM); // don't show a value on
														// record rows
								sb.append("Record").append(ROW_DELIM);
								l.add(sb.toString());
								Debug.logDebugPlus(
										5,
										0,
										Debug.MON,
										" record array " + j + ": "
												+ sb.toString());
								l.addAll(convertIDataToFlatList(parent
										+ delimBookmark + thisKey.toString(),
										da[j]));
							}
						} else {
							String[] sa = null;
							if (dataValue instanceof String[]) {
								sa = (String[]) dataValue;
							}
							if (sa != null) {
								// this makes the array show up as expandable
								// under a heading. also takes care of empty
								// stringlist
								StringBuffer sb = new StringBuffer()
										.append(parent).append(delimBookmark)
										.append(dataKey).append(",");
								sb.append(parent).append(COL_DELIM);
								sb.append(dataKey).append(COL_DELIM);
								sb.append(COL_DELIM);
								sb.append("String[]").append(ROW_DELIM);
								l.add(sb.toString());
								for (int j = 0; j < sa.length; j++) {
									sb = new StringBuffer().append(parent)
											.append(delimBookmark)
											.append(dataKey)
											.append(ARRAY_DELIM).append(j)
											.append(COL_DELIM);
									sb.append(parent).append(delimBookmark)
											.append(dataKey).append(COL_DELIM); // all
																				// members
																				// of
																				// the
																				// array
																				// are
																				// children
																				// of
																				// the
																				// parent
																				// created
																				// immediately
																				// above
									sb.append(dataKey).append("[").append(j)
											.append("]").append(COL_DELIM);
									sb.append(
											sa[j].replaceAll(COL_DELIM, "%2C"))
											.append(COL_DELIM);
									sb.append("String").append(ROW_DELIM);
									l.add(sb.toString());
									Debug.logDebugPlus(5, 0, Debug.MON,
											" string list: " + sb.toString());
								}
							} else {
								String[][] st = null;
								if (dataValue instanceof String[][]) {
									st = (String[][]) dataValue;
								}
								if (st != null) {
									// this makes the table show up as
									// expandable under a heading. also takes
									// care of empty stringtable
									StringBuffer sb = new StringBuffer()
											.append(parent)
											.append(delimBookmark)
											.append(dataKey).append(",");
									sb.append(parent).append(COL_DELIM);
									sb.append(dataKey).append(COL_DELIM);
									sb.append(COL_DELIM);
									sb.append("String[][]").append(ROW_DELIM);
									l.add(sb.toString());
									for (int j = 0; j < st.length; j++) {
										for (int k = 0; k < st.length; k++) {
											sb = new StringBuffer()
													.append(parent)
													.append(delimBookmark)
													.append(dataKey)
													.append(ARRAY_DELIM)
													.append(j)
													.append(ARRAY_DELIM)
													.append(k)
													.append(COL_DELIM);
											sb.append(parent)
													.append(delimBookmark)
													.append(dataKey)
													.append(COL_DELIM); // all
																		// members
																		// of
																		// the
																		// table
																		// are
																		// children
																		// of
																		// the
																		// parent
																		// created
																		// immediately
																		// above
											sb.append(dataKey).append("[")
													.append(j).append("][")
													.append(k).append("]")
													.append(COL_DELIM);
											sb.append(
													st[j][k].replaceAll(",",
															"%2C")).append(",");
											sb.append("String").append(
													ROW_DELIM);
											l.add(sb.toString());
											Debug.logDebugPlus(
													5,
													0,
													Debug.MON,
													" string table: "
															+ sb.toString());
										}
									}
								} else {
									StringBuffer sb = new StringBuffer()
											.append(parent)
											.append(delimBookmark)
											.append(dataKey).append(",");
									sb.append(parent).append(COL_DELIM);
									sb.append(dataKey).append(COL_DELIM);
									if (dataValue == null)
										sb.append("null").append(COL_DELIM);
									else
										sb.append(dataValue).append(COL_DELIM);
									sb.append(dataType).append(ROW_DELIM);
									l.add(sb.toString());
									Debug.logDebugPlus(5, 0, Debug.MON,
											" other: " + sb.toString());
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			if (cursor != null) {
				cursor.destroy();
			}
			Debug.logError(1019, Debug.MON, e.toString());
		}
		Debug.logDebugPlus(4, 0, Debug.MON, "  fieldList: " + l.toString());
		return l;
	}

	/*
	 * edits is a list of key-value pairs where each key-value pair is delimited
	 * by :#:, and within that each key is separated from the value by :%:. the
	 * key in the key-value pair is a fully qualified path within the idata to a
	 * specific field.
	 */
	public static void applyEdits(IData data, String edits) {
		String COL_DELIM = ":%:";
		String ROW_DELIM = ":#:";

		Debug.logDebugPlus(2, 0, Debug.MON, "edits: " + edits);
		if (edits != null && edits.length() > 0) {
			String[] rows = edits.split(ROW_DELIM);
			for (int i = 0; i < rows.length; i++) {
				Debug.logDebugPlus(2, 0, Debug.MON, "edit: " + rows[i]);
				String[] kvp = rows[i].split(COL_DELIM);
				Debug.logDebugPlus(2, 0, Debug.MON, "edit key: " + kvp[0]);
				Debug.logDebugPlus(2, 0, Debug.MON, "edit value: " + kvp[1]);
				if (kvp[1].equals("null"))
					kvp[1] = "";
				applyEdit(data, kvp[0], kvp[1]);
			}
		}
	}

	/*
	 * key is a fully qualified path to a field in data, where sublevels are
	 * indicated by :
	 */
	public static void applyEdit(IData data, String key, String value) {
		String LEVEL_DELIM = ":~:";
		String[] levels = key.split(LEVEL_DELIM);
		Debug.logDebugPlus(2, 0, Debug.MON, "applyEdit - levels0: " + levels[0]);

		Object levelValue = data;

		for (int i = 0; i < levels.length; i++) {
			String level = levels[i];
			Debug.logDebugPlus(2, 0, Debug.MON, "applyEdit - level: "
					+ levels[i]);
			boolean isLeaf = false, isArrayMember = false;
			if (i == levels.length - 1) {
				isLeaf = true;
				if (levels[i].indexOf(ARRAY_DELIM) > 0)
					isArrayMember = true;
			}

			IDataCursor c = null;
			try {
				Debug.logDebugPlus(2, 0, Debug.MON, "applyEdit - levelValue: "
						+ levelValue);
				String[] keyparts = level.split(ARRAY_DELIM);
				Debug.logDebugPlus(2, 0, Debug.MON,
						"applyEdit - keyparts array split: " + keyparts[0]);
				IData d = (IData) levelValue;
				c = d.getCursor();
				c.next(keyparts[0]);
				Object o = c.getValue();
				Debug.logDebugPlus(2, 0, Debug.MON, "applyEdit - next IData: "
						+ o);

				if (isLeaf) {
					if (keyparts.length == 1) { // this is a single basic type
						Debug.logDebugPlus(2, 0, Debug.MON,
								"applyEdit - edit basic type " + keyparts[0]);
						c.delete();
						Object newvalue = changeValue(o, value);
						c.insertBefore(level, newvalue);
					} else if (keyparts.length == 2) { // this is a member of a
														// basic type array
						Debug.logDebugPlus(2, 0, Debug.MON,
								"applyEdit - edit basic type array member "
										+ keyparts[0] + ":" + keyparts[1]);
						int x = new Integer(keyparts[1]).intValue();
						Object[] a = (Object[]) o;
						a[x] = changeValue(a[x], value);
					} else if (keyparts.length == 3) { // this is a member of a
														// stringtable
						Debug.logDebugPlus(2, 0, Debug.MON,
								"applyEdit - edit string table member "
										+ keyparts[0] + ":" + keyparts[1] + ":"
										+ keyparts[2]);
						int x = new Integer(keyparts[1]).intValue();
						int y = new Integer(keyparts[2]).intValue();
						String[][] a = (String[][]) levelValue;
						a[x][y] = value;
					}
					Debug.logDebugPlus(2, 0, Debug.MON, "data after edit: "
							+ data);
				} else { // not a leaf - step down a level
					if (keyparts.length == 1) {
						Debug.logDebugPlus(2, 0, Debug.MON,
								"applyEdit - step down to idata " + keyparts[0]);
						levelValue = o;
					} else if (keyparts.length == 2) {
						Debug.logDebugPlus(2, 0, Debug.MON,
								"applyEdit - step down to array member "
										+ keyparts[0] + ":" + keyparts[1]);
						int x = new Integer(keyparts[1]).intValue();
						levelValue = ((Object[]) o)[x];
					}
				}
				c.destroy();
			} catch (Throwable e) {
				Debug.logDebugPlus(2, 0, Debug.MON, Debug.stackTraceToString(e));
			} finally {
				if (c != null)
					c.destroy();
			}
		}
	}

	// returns an object of the same type as the prev object
	private static Object changeValue(Object prev, String next) {
		Object out = null;
		if (prev != null) {
			String dataType = prev.getClass().getName();

			if (dataType.startsWith("java.lang"))
				dataType = dataType.substring(10);
			else if (dataType.startsWith("java.util"))
				dataType = dataType.substring(10);
			Debug.logDebugPlus(3, 0, Debug.MON, "  dataType <" + dataType + ">");

			if (dataType.equals("String")) {
				if (next.equals(""))
					out = "";
				else
					out = next;
			} else if (dataType.equals("Integer")) {
				if (next.equals(""))
					out = "";
				else
					out = new Integer(next);
			} else if (dataType.equals("Boolean")) {
				if (next.equals(""))
					out = "";
				else
					out = new Boolean(next);
			} else if (dataType.equals("Long")) {
				if (next.equals(""))
					out = "";
				else
					out = new Long(next);
			} else if (dataType.equals("Float")) {
				if (next.equals(""))
					out = "";
				else
					out = new Float(next);
			} else if (dataType.equals("Short")) {
				if (next.equals(""))
					out = "";
				else
					out = new Short(next);
			} else if (dataType.equals("Double")) {
				if (next.equals(""))
					out = "";
				else
					out = new Double(next);
			} else if (dataType.equals("Date")) {
				if (next.equals(""))
					out = "";
				else {
					Date dt = (new SimpleDateFormat(
							PkgUtil.lbl("timestrMillis"))).parse(next,
							new java.text.ParsePosition(0));
					if (dt == null) // dt is null if parse failed
						throw new NumberFormatException(next);
					out = dt;
				}
			} else if (dataType.equals("Character")) {
				if (next.equals(""))
					out = "";
				else
					out = new Character(next.charAt(0));
			} else if (dataType.equals("Byte")) {
				if (next.equals(""))
					out = "";
				else
					out = new Byte(next);
			} else
				Debug.logDebugPlus(2, 0, Debug.MON, "type of data is: "
						+ dataType);
		}else if(prev==null){ //Fix for WMN-3119
			out=next;
		}
		return out;
	}

	// create a new context id
	public static String newUniqueId() {
		try {
			IAuditRuntime ar = getRuntime();
			return ar.generateContextId();
		} catch (AuditException e) {
			Debug.logError(46, Debug.MON, e.toString());
			return com.wm.util.text.UUID.generate();
		}
	}

	// get a runtime object which can publish log events
	public static IAuditRuntime getRuntime() throws AuditException {
		IAuditRuntime ar = null;
		ar = AuditLogManager.getAuditRuntime();
		if (ar == null) {
			throw new AuditException(PkgUtil.msg(207));
		}

		return ar;
	}

	/** Helper function for getCalendar */
	public static int getNumWk(int year, int month, Locale locale) {
		Calendar cal = Calendar.getInstance(locale);
		// set the calendar to the first day of specified month
		cal.set(year, month, 1);
		// get day (sunday, monday, etc) of 1st day in month
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		// System.out.println("\nday of week: " + dow);
		// get what is first day of week on calendar - sunday/1 or monday/2,
		// depending on locale
		int firstDayOfCalWeek = cal.getFirstDayOfWeek();
		// System.out.println("first day of calendar week: " +
		// firstDayOfCalWeek);
		// get the number of days in the first week that belong to the previous
		// month
		dow = (dow - firstDayOfCalWeek) >= 0 ? dow - firstDayOfCalWeek : dow
				- firstDayOfCalWeek + 7;
		// System.out.println("days shown from prev month: " + dow);
		// get the number of days in the current month
		int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// System.out.println("days in month: " + maxDate);
		// temp = total days in this month + days in previous month in first
		// week
		// i.e. total days that MUST be shown on this calendar page
		int temp = dow + maxDate;
		// System.out.println("total days to show: " + temp);
		int numWk = -1;
		if (temp % 7 == 0) {
			numWk = temp / 7;
		} else {
			numWk = temp / 7 + 1;
		}
		// System.out.println("number of weeks in month: " + numWk);
		return numWk;
	}

	// creates part of the query string for relative dates (i.e. "past 7 days")
	// this just puts together "#DATE1# AND #DATE2#" for use after the BETWEEN
	// modifier in the select string
	public static Range createDateRangeString(String range) {
		// set until date to be the last minute of today
		Calendar until = Calendar.getInstance();
		until.add(Calendar.DAY_OF_YEAR, 1);
		beginningOfDay(until);

		Calendar since = null;

		if (range.equalsIgnoreCase(TIME_TODAY)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
		}

		if (range.equalsIgnoreCase(TIME_YESTERDAY)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -1);
			// set until string to beginning of today
			until = Calendar.getInstance();
			beginningOfDay(until);
		}

		if (range.equalsIgnoreCase(TIME_LAST_7_DAYS)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -7);
		}

		if (range.equalsIgnoreCase(TIME_LAST_WEEK)) {
			until.add(Calendar.DAY_OF_WEEK,
					-(until.get(Calendar.DAY_OF_WEEK) - until
							.getFirstDayOfWeek()));
			beginningOfDay(until);
			since = (Calendar) until.clone();
			since.add(Calendar.DAY_OF_WEEK, -7);
		}

		if (range.equalsIgnoreCase(TIME_THIS_WEEK)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_WEEK,
					-(since.get(Calendar.DAY_OF_WEEK) - since
							.getFirstDayOfWeek()));
			beginningOfDay(since);
		}

		if (range.equalsIgnoreCase(TIME_LAST_MONTH)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			until.add(Calendar.DAY_OF_MONTH,
					-(until.get(Calendar.DAY_OF_MONTH) - until
							.getMinimum(Calendar.DAY_OF_MONTH)));
			since = (Calendar) until.clone();
			since.add(Calendar.MONTH, -1);
		}

		if (range.equalsIgnoreCase(TIME_THIS_MONTH)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_MONTH,
					-(since.get(Calendar.DAY_OF_MONTH) - since
							.getMinimum(Calendar.DAY_OF_MONTH)));
		}

		if (range.equalsIgnoreCase(TIME_YEAR_TO_DATE)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -(since.get(Calendar.DAY_OF_YEAR)));
			since.add(Calendar.DAY_OF_YEAR, 1);
		}

		Range _range = null;
		try {
			_range = new Range(new Long((since.getTime()).getTime()), new Long(
					(until.getTime()).getTime()));
		} catch (QueryGenerationException e) {
			Debug.logError(47, Debug.MON, e.toString());
			Debug.logDebugPlus(4, 47, Debug.MON, Debug.stackTraceToString(e));
		}

		return _range;
	}

	public static Range createDateRangeTimeStampString(String range) {
		// set until date to be the last minute of today
		Calendar until = Calendar.getInstance();
		until.add(Calendar.DAY_OF_YEAR, 1);
		beginningOfDay(until);

		Calendar since = null;

		if (range.equalsIgnoreCase(TIME_TODAY)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
		}

		if (range.equalsIgnoreCase(TIME_YESTERDAY)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -1);
			// set until string to beginning of today
			until = Calendar.getInstance();
			beginningOfDay(until);
		}

		if (range.equalsIgnoreCase(TIME_LAST_7_DAYS)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -7);
		}

		if (range.equalsIgnoreCase(TIME_LAST_WEEK)) {
			until.add(Calendar.DAY_OF_WEEK,
					-(until.get(Calendar.DAY_OF_WEEK) - until
							.getFirstDayOfWeek()));
			beginningOfDay(until);
			since = (Calendar) until.clone();
			since.add(Calendar.DAY_OF_WEEK, -7);
		}

		if (range.equalsIgnoreCase(TIME_THIS_WEEK)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_WEEK,
					-(since.get(Calendar.DAY_OF_WEEK) - since
							.getFirstDayOfWeek()));
			beginningOfDay(since);
		}

		if (range.equalsIgnoreCase(TIME_LAST_MONTH)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			until.add(Calendar.DAY_OF_MONTH,
					-(until.get(Calendar.DAY_OF_MONTH) - until
							.getMinimum(Calendar.DAY_OF_MONTH)));
			since = (Calendar) until.clone();
			since.add(Calendar.MONTH, -1);
		}

		if (range.equalsIgnoreCase(TIME_THIS_MONTH)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_MONTH,
					-(since.get(Calendar.DAY_OF_MONTH) - since
							.getMinimum(Calendar.DAY_OF_MONTH)));
		}

		if (range.equalsIgnoreCase(TIME_YEAR_TO_DATE)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -(since.get(Calendar.DAY_OF_YEAR)));
			since.add(Calendar.DAY_OF_YEAR, 1);
		}

		Range _range = null;
		try {
			_range = new Range(getDateTimeFromLong((since.getTime()).getTime()),getDateTimeFromLong(
					(until.getTime()).getTime()));
		} catch (QueryGenerationException e) {
			Debug.logError(47, Debug.MON, e.toString());
			Debug.logDebugPlus(4, 47, Debug.MON, Debug.stackTraceToString(e));
		}

		return _range;
	}
	
	public static Range createDateRangeTimeStampLong(String range) {
		// set until date to be the last minute of today
		Calendar until = Calendar.getInstance();
		until.add(Calendar.DAY_OF_YEAR, 1);
		beginningOfDay(until);

		Calendar since = null;

		if (range.equalsIgnoreCase(TIME_TODAY)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
		}

		if (range.equalsIgnoreCase(TIME_YESTERDAY)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -1);
			// set until string to beginning of today
			until = Calendar.getInstance();
			beginningOfDay(until);
		}

		if (range.equalsIgnoreCase(TIME_LAST_7_DAYS)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -7);
		}

		if (range.equalsIgnoreCase(TIME_LAST_WEEK)) {
			until.add(Calendar.DAY_OF_WEEK,
					-(until.get(Calendar.DAY_OF_WEEK) - until
							.getFirstDayOfWeek()));
			beginningOfDay(until);
			since = (Calendar) until.clone();
			since.add(Calendar.DAY_OF_WEEK, -7);
		}

		if (range.equalsIgnoreCase(TIME_THIS_WEEK)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_WEEK,
					-(since.get(Calendar.DAY_OF_WEEK) - since
							.getFirstDayOfWeek()));
			beginningOfDay(since);
		}

		if (range.equalsIgnoreCase(TIME_LAST_MONTH)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			until.add(Calendar.DAY_OF_MONTH,
					-(until.get(Calendar.DAY_OF_MONTH) - until
							.getMinimum(Calendar.DAY_OF_MONTH)));
			since = (Calendar) until.clone();
			since.add(Calendar.MONTH, -1);
		}

		if (range.equalsIgnoreCase(TIME_THIS_MONTH)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_MONTH,
					-(since.get(Calendar.DAY_OF_MONTH) - since
							.getMinimum(Calendar.DAY_OF_MONTH)));
		}

		if (range.equalsIgnoreCase(TIME_YEAR_TO_DATE)) {
			since = Calendar.getInstance();
			beginningOfDay(since);
			since.add(Calendar.DAY_OF_YEAR, -(since.get(Calendar.DAY_OF_YEAR)));
			since.add(Calendar.DAY_OF_YEAR, 1);
		}

		Range _range = null;
		try {
			_range = new Range(since.getTimeInMillis(), 
					until.getTimeInMillis());
		} catch (QueryGenerationException e) {
			Debug.logError(47, Debug.MON, e.toString());
			Debug.logDebugPlus(4, 47, Debug.MON, Debug.stackTraceToString(e));
		}

		return _range;
	}
	public static DateTime getDateTimeFromLong(long timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = sdf.format(new Timestamp(timestamp));
		return new DateTime(timeString);
	}
	
	// Moves a calendar to the beginning of the day it's on
	public static void beginningOfDay(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, c.getMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getMinimum(Calendar.SECOND));
		c.set(Calendar.MILLISECOND, c.getMinimum(Calendar.MILLISECOND));
	}

	public static Long parseDate(String dateParse) {
		Long parsedTime = new Long(0);

		// 2002-02-02 00:00:00
		// 0123456789
		String year = null;
		String month = null;
		String date = null;
		String hour = null;
		String minute = null;
		String second = null;
		int iyear = 0;
		int imonth = 0;
		int idate = 0;
		int ihour = 0;
		int imin = 0;
		int isec = 0;
		boolean hasCorrectTime = true;
		// FIXME: add some way of error checking and throwing a reasonable
		// exception
		year = dateParse.substring(0, 4);
		if (year != null && year.indexOf("0") == 0) {
			year = year.substring(1, 1);
		}
		if (year != null && year.length() == 4) {
			iyear = Integer.parseInt(year);
		} else {
			hasCorrectTime = false;
		}
		month = dateParse.substring(5, 7);
		if (month != null && month.indexOf("0") == 0) {
			month = month.substring(1);
		}
		if (month != null && month.length() >= 1 && month.length() <= 2) {
			imonth = Integer.parseInt(month);
			imonth--;
		} else {
			hasCorrectTime = false;
		}
		date = dateParse.substring(8, 10);
		if (date != null && date.indexOf("0") == 0) {
			date = date.substring(1);
		}
		if (date != null && date.length() >= 1 && date.length() <= 2) {
			idate = Integer.parseInt(date);
		} else {
			hasCorrectTime = false;
		}

		if (dateParse.length() > 10) {
			// find hour from position 11 to first colon
			hour = dateParse.substring(11, dateParse.indexOf(":"));
			if (hour != null && hour.indexOf("0") == 0) {
				hour = hour.substring(1);
			}
			if (hour != null && hour.length() >= 1 && hour.length() <= 2) {
				ihour = Integer.parseInt(hour);
			} else {
				hasCorrectTime = false;
			}
			// find minute from after first colon to second colon
			minute = dateParse.substring(dateParse.indexOf(":") + 1,
					dateParse.indexOf(":", (dateParse.indexOf(":") + 1)));
			if (minute != null && minute.indexOf("0") == 0) {
				minute = minute.substring(1);
			}
			if (minute != null && minute.length() >= 1 && minute.length() <= 2) {
				imin = Integer.parseInt(minute);
			} else {
				hasCorrectTime = false;
			}
			// find second from after last colon to end
			second = dateParse.substring(dateParse.lastIndexOf(":") + 1);
			if (second != null && second.indexOf("0") == 0) {
				second = second.substring(1);
			}
			if (second != null && second.length() >= 1 && second.length() <= 2) {
				isec = Integer.parseInt(second);
			} else {
				hasCorrectTime = false;
			}
		}
		if (hasCorrectTime) {
			Calendar cal = Calendar.getInstance();
			cal.setLenient(false);
			cal.set(iyear, imonth, idate, ihour, imin, isec);
			parsedTime = new Long(cal.getTime().getTime());
		}
		return parsedTime;
	}

	public static Long parseDateReports(String dateParse) {
		Long parsedTime = new Long(0);

		// 2002-02-02 00:00:00
		// 0123456789
		String year = null;
		String month = null;
		String date = null;
		String hour = null;
		String minute = null;
		int iyear = 0;
		int imonth = 0;
		int idate = 0;
		int ihour = 0;
		int imin = 0;
		boolean hasCorrectTime = true;
		// FIXME: add some way of error checking and throwing a reasonable
		// exception
		year = dateParse.substring(0, 4);
		if (year != null && year.indexOf("0") == 0) {
			year = year.substring(1, 1);
		}
		if (year != null && year.length() == 4) {
			iyear = Integer.parseInt(year);
		} else {
			hasCorrectTime = false;
		}
		month = dateParse.substring(5, 7);
		if (month != null && month.indexOf("0") == 0) {
			month = month.substring(1);
		}
		if (month != null && month.length() >= 1 && month.length() <= 2) {
			imonth = Integer.parseInt(month);
			imonth--;
		} else {
			hasCorrectTime = false;
		}
		date = dateParse.substring(8, 10);
		if (date != null && date.indexOf("0") == 0) {
			date = date.substring(1);
		}
		if (date != null && date.length() >= 1 && date.length() <= 2) {
			idate = Integer.parseInt(date);
		} else {
			hasCorrectTime = false;
		}

		if (dateParse.length() > 10) {
			hour = dateParse.substring(11, 13);
			if (hour != null && hour.indexOf("0") == 0) {
				hour = hour.substring(1);
			}
			if (hour != null && hour.length() >= 1 && hour.length() <= 2) {
				ihour = Integer.parseInt(hour);
			} else {
				hasCorrectTime = false;
			}
			minute = dateParse.substring(14, 16);
			if (minute != null && minute.indexOf("0") == 0) {
				minute = minute.substring(1);
			}
			if (minute != null && minute.length() >= 1 && minute.length() <= 2) {
				imin = Integer.parseInt(minute);
			} else {
				hasCorrectTime = false;
			}
		}
		if (hasCorrectTime) {
			Calendar cal = Calendar.getInstance();
			cal.setLenient(false);
			cal.set(iyear, imonth, idate, ihour, imin);
			parsedTime = new Long(cal.getTime().getTime());
		}
		return parsedTime;
	}

	/**
	 * Method to create a millisecond time based on the offset specified by the
	 * user.
	 **/
	public static long createAgedDate(long time) {
		Date date = new Date();
		long now = date.getTime();
		// create multiplier
		long timeMillis = 1000 * 60 * 60 * 24;
		// multiply integer to get a long
		time = time * timeMillis;
		// subtract the aged date from now to get the millis for the aged date
		time = now - time;

		// create a date object from the long offset
		Date finDate = new Date(time);

		// get a calendar instance and set it with the date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(finDate);

		// retrieve the year, month and day and set the calendar to that date at
		// 0 time
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 0, 0, 0);

		// get back to a long through calendar and date
		finDate = calendar.getTime();
		time = finDate.getTime();

		return time;
	}

	public static final String getRequiredParam(IData pipe, String key)
			throws ServiceException {
		return getRequiredObject(pipe, key).toString();
	}

	public static final Object getRequiredObject(IData pipe, String key)
			throws ServiceException {
		Object o = ValuesEmulator.get(pipe, key);
		if (o != null)
			return o;
		throw new ServiceException(MonMessages.class,
				"pm.requiredInputValueMissing", "MON", new Object[] { key });
	}

	public static final long getRequiredLong(IData pipe, String key)
			throws ServiceException {
		Object o = getRequiredObject(pipe, key);
		if (o instanceof Long)
			return ((Long) o).longValue();
		if (o instanceof String)
			try {
				return Long.parseLong(o.toString());
			} catch (Exception e) {
			}
		throw new ServiceException(MonMessages.class, "pm.incorrectValue",
				"MON", new Object[] { key, o });
	}

	public static final int getRequiredInt(IData pipe, String key)
			throws ServiceException {
		Object o = getRequiredObject(pipe, key);
		if (o instanceof Integer)
			return ((Integer) o).intValue();
		if (o instanceof String)
			try {
				return Integer.parseInt(o.toString());
			} catch (Exception e) {
			}
		throw new ServiceException(MonMessages.class, "pm.incorrectValue",
				"MON", new Object[] { key, o });
	}

	public static final IData ensure(IData pipe, String key) {
		IData d = (IData) ValuesEmulator.get(pipe, key);
		if (d == null) {
			d = IDataFactory.create();
			ValuesEmulator.put(pipe, key, d);
		}
		return d;
	}

	public static void rethrow(Throwable t, String ifc, String svc)
			throws MonitorException {
		if (t instanceof MonitorException)
			throw (MonitorException) t;
		else {
			MonitorException m = new MonitorException(t, ("[" + ifc + ":" + svc
					+ "] " + t.toString()));
			throw m;
		}
	}

	public static boolean charCheck(String s, String delim) {
		if (s != null && s.indexOf(delim) != -1)
			return true;
		else
			return false;
	}

	public static String[] createArray(String s, String delim) {
		Vector v = new Vector();
		int i = 0;
		while (s.length() != 0) {
			int j = s.indexOf(delim);
			if (j != -1) {
				v.add(s.substring(i, j));
				s = s.substring(++j);
			} else {
				v.add(s);
				s = "";
			}
		}
		Object[] obj = v.toArray();
		if (obj != null) {
			String[] str = new String[obj.length];
			for (i = 0; i < obj.length; i++) {
				str[i] = (String) obj[i];
			}
			return str;
		}

		return null;
	}

	public static Integer[] createIntArray(String s, String delim) {
		Vector v = new Vector();
		int i = 0;
		while (s.length() != 0) {
			int j = s.indexOf(delim);
			if (j != -1) {
				v.add(s.substring(i, j));
				s = s.substring(++j);
			} else {
				v.add(s);
				s = "";
			}
		}
		Object[] obj = v.toArray();
		if (obj != null) {
			Integer[] num = new Integer[obj.length];
			for (i = 0; i < obj.length; i++) {
				int j = -1;
				if (obj[i] != null && !obj[i].equals("")) {
					j = Integer.parseInt((String) obj[i]);
				}
				num[i] = new Integer(j);
			}
			return num;
		}

		return null;
	}

	public static InList createInList(String s) {
		InList il = new InList();
		int i = 0;
		if (s != null) {
			while (s.length() != 0) {
				int j = s.indexOf(",");
				il.addField(s.substring(i, j - 1));
				s = s.substring(i, j);
				i = ++j;
			}
		}
		return il;
	}

	public static InList createInList(int[] set) {
		InList il = new InList();
		if (set != null) {
			for (int i = 0; i < set.length; i++) {
				if (set[i] != -1)
					il.addField(new Integer(set[i]));
			}
		}
		return il;
	}
	
	public static InList createInListAsParams(int[] set) {
		InList il = new InList();
		if (set != null) {
			for (int i = 0; i < set.length; i++) {
				if (set[i] != -1)
					il.addField(new Field(new PSParameter()));
			}
		}
		return il;
	}

	public static InList createInList(Integer[] set) {
		InList il = new InList();
		if (set != null) {
			for (int i = 0; i < set.length; i++) {
				if (set[i].intValue() != -1)
					il.addField(set[i]);
			}
		}
		return il;
	}

	public static InList createInList(String[] set) {
		InList il = new InList();
		if (set != null) {
			String s = null;
			for (int i = 0; i < set.length; i++) {
				s = set[i];
				if (s != null && !s.equals("")) {
					il.addField(s);
				}
			}
		}
		return il;
	}
	public static InList createInListAsParams(String[] set) {
		InList il = new InList();
		if (set != null) {
			String s = null;
			for (int i = 0; i < set.length; i++) {
				s = set[i];
				if (s != null && !s.equals("")) {
					il.addField(new Field(new PSParameter()));
				}
			}
		}
		return il;
	}

	public static Vector copyArray(String[] array) {
		Vector v = new Vector();
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				v.add(array[i]);
			}
		}
		return v;
	}

	public static int[] convertAuditType(String[] array) {
		String strAudType = "";
		int[] audTypeArray = null;
		if (array != null) {
			audTypeArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				int auditType = -1; // all audit types
				strAudType = array[i];
				if (strAudType != null && !strAudType.equals("")) {
					try {
						auditType = Integer.parseInt(strAudType);
					} catch (NumberFormatException e) {
						// then strAudType wasn't a number - try to resolve
						// decode
						// these values have to match the statuses in Constants
						if (strAudType.equalsIgnoreCase("Begin"))
							auditType = Constants.STAT4_BEGIN;
						else if (strAudType.equalsIgnoreCase("End"))
							auditType = Constants.STAT4_END;
						else if (strAudType.equalsIgnoreCase("Error"))
							auditType = Constants.STAT4_ERROR;
						else if (strAudType.equalsIgnoreCase("Resubmitted"))
							auditType = Constants.STAT4_RESUBMITTED;
						else if (strAudType.equalsIgnoreCase("Message"))
							auditType = Constants.STAT_MESSAGE; // this uses a
																// 6.x status
						else if (strAudType.equalsIgnoreCase("User Data"))
							auditType = Constants.STAT_USERDATA; // this uses a
																	// 6.x
																	// status
					}
					audTypeArray[i] = auditType;
				}
			}
			if (audTypeArray != null && audTypeArray.length == 1) {
				if (audTypeArray[0] == 0) {
					audTypeArray = null;
				}
			}
		}
		return audTypeArray;
	}

	public static int[] convertProcessStatus(String[] array) {
		String strStatus = "";
		int[] processStatusArray = null;
		if (array != null) {
			processStatusArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				strStatus = array[i];
				int status = -1; // all statuses
				if (strStatus != null && !strStatus.equals("")) {
					try {
						status = Integer.parseInt(strStatus);
					} catch (NumberFormatException e) {
						// then strStatus wasn't a number - resolve decode
						// these values have to match the statuses in Constants
						if (strStatus.equalsIgnoreCase("Started"))
							status = Constants.STAT_STARTED;
						else if (strStatus.equalsIgnoreCase("Completed"))
							status = Constants.STAT_ENDED;
						else if (strStatus.equalsIgnoreCase("Failed"))
							status = Constants.STAT_FAILED;
						else if (strStatus.equalsIgnoreCase("Resubmitted"))
							status = Constants.STAT_RESUBMITTED;
						else if (strStatus.equalsIgnoreCase("Resumed"))
							status = Constants.STAT_RESUMED;
						else if (strStatus.equalsIgnoreCase("Suspended"))
							status = Constants.STAT_SUSPENDED;
						else if (strStatus.equalsIgnoreCase("Stopped"))
							status = Constants.STAT_CANCELLED;
						else if (strStatus.equalsIgnoreCase("Suspended"))
							status = Constants.STAT_SUSPENDED;
						else if (strStatus.equalsIgnoreCase("Cancelled"))
							status = Constants.STAT_CANCELLED;
						else if (strStatus.equalsIgnoreCase("Waiting"))
							status = Constants.STAT_WAITING;
						else if (strStatus.equalsIgnoreCase("Expired"))
							status = Constants.STAT_EXPIRED;
					}
					processStatusArray[i] = status;
				}
			}
			if (processStatusArray != null && processStatusArray.length == 1) {
				if (processStatusArray[0] == 0) {
					processStatusArray = null;
				}
			}
		}
		return processStatusArray;
	}

	public static int[] convertDocumentType(String[] array) {

		String docType = "";
		int[] docTypeArray = null;
		if (array != null) {
			docTypeArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				docTypeArray[i] = -1;
				docType = array[i];
				int type = -1; // all types
				if (docType != null && !docType.equals("")) {
					try {
						type = Integer.parseInt(docType);
					} catch (NumberFormatException e) {
						// then strType was not a number - resolve decode
						// these values have to match the statuses in Constants
						if (docType.contains("Broker"))
							type = Constants.STAT_BROKER;
						else if (docType.equalsIgnoreCase("In Doubt"))
							type = Constants.STAT_INDOUBT;
						else if (docType.equalsIgnoreCase("Retries Exceeded"))
							type = Constants.STAT_RETRIES_EXC;
						else if (docType.equalsIgnoreCase("Failed"))
							type = Constants.STAT_FAILED;
					}
					docTypeArray[i] = type;
				}
			}
			if (docTypeArray != null && docTypeArray.length == 1) {
				if (docTypeArray[0] == -1) {
					docTypeArray = null;
				}
			}
		}
		return docTypeArray;
	}

	public static int[] convertServiceStatus(String[] array) {
		String strStatus = "";
		int[] serviceStatusArray = null;
		if (array != null) {
			serviceStatusArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				strStatus = array[i];
				int status = -1; // all statuses
				if (strStatus != null && !strStatus.equals("")) {
					try {
						status = Integer.parseInt(strStatus);
					} catch (NumberFormatException e) {
						// then strStatus wasn't a number - resolve decode
						// these values have to match the statuses in Constants
						if (strStatus.equalsIgnoreCase("Started"))
							status = Constants.STAT_STARTED;
						else if (strStatus.equalsIgnoreCase("Completed"))
							status = Constants.STAT_ENDED;
						else if (strStatus.equalsIgnoreCase("Failed"))
							status = Constants.STAT_FAILED;
						else if (strStatus.equalsIgnoreCase("Resubmitted"))
							status = Constants.STAT_RESUBMITTED;
						else if (strStatus.equalsIgnoreCase("Retried"))
							status = Constants.STAT_RETRIED;
						else if (strStatus.equalsIgnoreCase("Activity"))
							status = Constants.STAT_ACTIVITY;
					}
					serviceStatusArray[i] = status;
				}
			}
			if (serviceStatusArray != null && serviceStatusArray.length == 1) {
				if (serviceStatusArray[0] == 0) {
					serviceStatusArray = null;
				}
			}
		}
		return serviceStatusArray;
	}

	/**
	 * Encodes non-ASCII characters to Hex since Tomcat doesn't seem to
	 * interpret them correctly when they are UTF-8.
	 * 
	 * @param input
	 * @return
	 */
	public static String XmlNumericEncode(String input) {
		StringCharacterIterator iter = new StringCharacterIterator(input);
		StringBuffer buf = new StringBuffer();
		char c = iter.first();
		while (c != CharacterIterator.DONE) {
			if (c < 0x80) {
				buf.append(c);
			} else {
				buf.append("&#x");
				buf.append(Integer.toHexString(c + 0x10000).substring(1));
				buf.append(";");
			}
			c = iter.next();
		}
		return buf.toString();
	}

	/**
	 * It checks for invalid characters in a string.
	 */
	public static boolean hasInvalidCharacters(String toCheck,
			String invalidChars) {

		int i = 0;
		boolean status = false;

		for (i = 0; i < toCheck.length(); i++) {

			if (invalidChars.indexOf(toCheck.charAt(i)) != -1) {

				status = true;
				// System.out.println("******invalid found is ****"+toCheck.charAt(i));
				INVALIDCHAR = "" + toCheck.charAt(i);
				return status;
			} else {
				status = false;
				// System.out.println("******output*************"+toCheck.charAt(i));
			}
		}

		return status;
	}

	/**
	 * It checks for valid string lengths
	 */
	public static boolean isLengthOK(String toCheck, String stringType) {

		boolean status = false;

		if (stringType.equals("processKey") && toCheck.length() > 0
				&& toCheck.length() <= 255)
			status = true;

		if (stringType.equals("processLabel") && toCheck.length() > 0
				&& toCheck.length() <= 1024)
			status = true;

		if (stringType.equals("instanceID") && toCheck.length() > 0
				&& toCheck.length() <= 36)
			status = true;

		if (stringType.equals("stepLabel") && toCheck.length() > 0
				&& toCheck.length() <= 1024)
			status = true;

		if (stringType.equals("stepID") && toCheck.length() > 0
				&& toCheck.length() <= 128)
			status = true;

		if (stringType.equals("fieldAlias") && toCheck.length() > 0
				&& toCheck.length() <= 640)
			status = true;

		if (stringType.equals("fieldName") && toCheck.length() > 0
				&& toCheck.length() <= 512)
			status = true;

		if (stringType.equals("documentType") && toCheck.length() > 0
				&& toCheck.length() <= 512)
			status = true;

		if (stringType.equals("documentName") && toCheck.length() > 0
				&& toCheck.length() <= 128)
			status = true;

		if (stringType.equals("stringValue") && toCheck.length() > 0
				&& toCheck.length() <= 255)
			status = true;

		if (stringType.equals("serviceName") && toCheck.length() > 0
				&& toCheck.length() <= 255)
			status = true;

		if (stringType.equals("errorMsg") && toCheck.length() > 0
				&& toCheck.length() <= 1024)
			status = true;

		if (stringType.equals("errorStackTrace") && toCheck.length() > 0
				&& toCheck.length() <= 2000)
			status = true;

		return status;

	}

	/**
	 * This method will take in the entire string entered in a keyword field and
	 * return a Collection of strings that is a list of the phrases that should
	 * be placed in LIKE phrases in the db query. It should properly handle
	 * wildcards by replacing them with % and should handle non-alphanumeric
	 * characters by replacing them with _. Unmatched "s will be discarded. All
	 * phrases will be uppercased so the db can do a case insensitive search.
	 * All phrases will be prepended and appended with % for a contains search
	 */
	public static Collection<String> parseKeywordField(String keyword) {
		ArrayList<String> out = new ArrayList<String>();
		String[] arrQuote = keyword.split("\"", -1);

		for (int i = 0; i < arrQuote.length; i++) {
			if (arrQuote[i].length() > 0) {
				// even number array indices are not in quotes, so should be
				// split on spaces
				// if there are an even number of fields in arrQuote, then there
				// are an odd number of quotes
				// and the last field should also be split on spaces
				if (((i % 2) == 0) || (i == arrQuote.length - 1)) {
					String[] arrSpace = arrQuote[i].split(" ", -1);
					for (int j = 0; j < arrSpace.length; j++)
						if (arrSpace[j].length() > 0)
							out.add("%"
									+ parseKeywordPhrase(arrSpace[j], false)
									+ "%");
				} else
					out.add("%" + parseKeywordPhrase(arrQuote[i], true) + "%");
			}
		}
		return out;
	}

	/**
	 * This method makes all characters uppercase, replaces '*' with '%' and
	 * replaces any non-alpahnumeric characters with '_'
	 */
	private static String parseKeywordPhrase(String phrase, boolean inQuotes) {
		char[] in = phrase.toCharArray();
		char[] out = new char[in.length];

		for (int i = 0; i < in.length; i++) {
			if (in[i] == '*')
				out[i] = inQuotes ? '_' : '%';
			else if (Character.isLetterOrDigit(in[i]))
				out[i] = Character.toUpperCase(in[i]);
			else if (in[i] == ' ')
				out[i] = inQuotes ? ' ' : '_';
			else
				out[i] = '_';
		}
		return new String(out);
	}

	public static IDataBinCoder getFastBinCoder() {
		return new IDataBinCoder();
	}

	public static IData binDecode(InputStream is) throws IOException,
			InvalidDatatypeException {
		IDataBinCoder c = getFastBinCoder();
		return c.decode(is);
	}

	public static byte[] encodeToBytes(IData pipe) throws IOException {
		IDataBinCoder c = getFastBinCoder();
		return c.encodeToBytes(pipe);
	}

	// WMN-1765
	public static String getTimestamp(Range range) {
		int dbtype = DbUtil.getDBTypeForAlias(Constants.PROC_AUD);
		long begin = new Long(range.getBegin().toString()).longValue();
		long end = new Long(range.getEnd().toString()).longValue();
		StringBuffer buf = new StringBuffer();
		if (dbtype == Constants.DB_ORACLE) {
			buf.append("TIMESTAMP");
		}
		buf.append(" '");
		buf.append(new java.sql.Timestamp(begin));
		buf.append("'");
		buf.append(" AND ");
		if (dbtype == Constants.DB_ORACLE) {
			buf.append("TIMESTAMP");
		}
		buf.append(" '");
		buf.append(new java.sql.Timestamp(end));
		buf.append("'");

		return buf.toString();
	}

	public static String getTimestampFromDate(Long date) {
		StringBuffer buf = new StringBuffer();
		if (DbUtil.getDBTypeForAlias(Constants.PROC_AUD) == Constants.DB_ORACLE) {
			buf.append("TIMESTAMP");
		}
		buf.append(" '");
		buf.append(new java.sql.Timestamp(date.longValue()));
		buf.append("'");

		return buf.toString();
	}

	/**
	 * Oracle query is built using a format that has extra set of quotes around
	 * the keyword TIMESTAMP and so this simply strips the query off those extra
	 * pair of quotes
	 * 
	 * @param oraQuery
	 * @param timestamp
	 * @return
	 */
	public static String parseOraQueryForTimestamp(String oraQuery,
			String timestamp) {
		int time_startIndex = oraQuery.indexOf(timestamp) - 1;
		int time_endIndex = time_startIndex + timestamp.length() + 1;
		String timeportion = timestamp.substring(10, timestamp.length() - 1);
		String qOra = oraQuery.substring(0, time_startIndex) + " "
				+ "TIMESTAMP" + " " + timeportion
				+ oraQuery.substring(time_endIndex, oraQuery.length());
		return qOra;
	}

	private static com.webmethods.sc.security.passman.PasswordManager passman;

	/**
	 * @return Returns a configured instance of the shared component group's
	 *         password manager
	 */
	public static com.webmethods.sc.security.passman.PasswordManager instance() {
		if (passman == null) {
			passman = OutboundPasswordStore.getSCPasswordManager();
		}
		return passman;
	}

	public static void updatePassword(String inHandle, String inPassword) {
		instance().storePassword(inHandle, new WmSecureString(inPassword));
	}

	public static String getPassword(String inHandle) {
		com.webmethods.sc.security.passman.PasswordManager instance = instance();
		WmSecureString secureString = instance.retrievePassword(inHandle);

		if (secureString == null) {
			return null;
		}
		return secureString.toString();
	}

	public static CriteriaSet parseCriteriaFilter(String criteriaFilter,
			boolean modelFlag, Column whereColumn) {
		// criteria filter will be of the form key=value,value AND key=value
		// AND/OR ...
		// 1. search for AND to scan delimited by AND, if not found then just
		// scan for equals once
		// 2. scan for equals to find key and value
		// 3. search for comma, if found scan delimited by comma

		com.wm.monitor.db.querygeneration.Table tableTable = null;
		Column selectColumn = null;
		Column userColumn = null;
		Column fieldNameColumn = null;
		Column stringValueColumn = null;
		if (modelFlag) {
			tableTable = ProcessAccess.TBL_PROCFILTER;
			selectColumn = ProcessAccess.PROCFILTER_COL_PROCKEY;
			fieldNameColumn = ProcessAccess.PROCFILTER_COL_FLDNM;
			stringValueColumn = ProcessAccess.PROCFILTER_COL_STRVAL;
		} else {
			tableTable = ProcessAccess.TBL_PROCDATA;
			selectColumn = ProcessAccess.PROCDATA_COL_IID;
			fieldNameColumn = ProcessAccess.PROCDATA_COL_FLDALIAS;
			stringValueColumn = ProcessAccess.PROCDATA_COL_STRVAL;
		}

		CriteriaSet csReturn = new CriteriaSet();
		String fieldName = null;
		String stringValue = null;
		criteriaFilter = criteriaFilter.replace("and", "AND");
		if ((criteriaFilter.indexOf("AND") > 0)) {
			Scanner scannerAnd = new Scanner(criteriaFilter);
			scannerAnd.useDelimiter("AND");
			while (scannerAnd.hasNext()) {
				CriteriaSet csKeyValue = new CriteriaSet();
				Scanner scannerEquals = new Scanner(scannerAnd.next());
				scannerEquals.useDelimiter("=");
				fieldName = (((scannerEquals.next()).replace('\"', ' '))
						.replace('\'', ' ')).trim();
				csKeyValue.addCriterion(fieldNameColumn, Criterion.EQ,
						fieldName);
				stringValue = (((scannerEquals.next()).replace('\"', ' '))
						.replace('\'', ' ')).trim();
				if (stringValue.indexOf(",") > 0) {
					CriteriaSet csValueList = new CriteriaSet();
					csValueList.setOperator(CriteriaSet.OR_OP);
					Scanner scannerComma = new Scanner(stringValue);
					scannerComma.useDelimiter(",");
					while (scannerComma.hasNext()) {
						String stringListValue = (((scannerComma.next())
								.replace('\"', ' ')).replace('\'', ' ')).trim();
						csValueList.addCriterion(stringValueColumn,
								Criterion.EQ, stringListValue);
						csKeyValue.addCriteria(csValueList);
					}
				} else {
					csKeyValue.addCriterion(stringValueColumn, Criterion.EQ,
							stringValue);
				}
				Query q = new Query();
				q.addFromTable(tableTable);
				q.addSelectColumn(selectColumn);
				q.addWhereCriteria(csKeyValue);

				csReturn.addCriterion(whereColumn, Criterion.IN, q);
			}
		} else {
			Scanner scannerEquals = new Scanner(criteriaFilter);
			scannerEquals.useDelimiter("=");
			CriteriaSet csKeyValue = new CriteriaSet();
			fieldName = (((scannerEquals.next()).replace('\"', ' ')).replace(
					'\'', ' ')).trim();
			csKeyValue.addCriterion(fieldNameColumn, Criterion.EQ, fieldName);
			stringValue = (((scannerEquals.next()).replace('\"', ' ')).replace(
					'\'', ' ')).trim();
			if (stringValue.indexOf(",") > 0) {
				CriteriaSet csValueList = new CriteriaSet();
				csValueList.setOperator(CriteriaSet.OR_OP);
				Scanner scannerComma = new Scanner(stringValue);
				scannerComma.useDelimiter(",");
				while (scannerComma.hasNext()) {
					String stringListValue = (((scannerComma.next()).replace(
							'\"', ' ')).replace('\'', ' ')).trim();
					csValueList.addCriterion(stringValueColumn, Criterion.EQ,
							stringListValue);
					csKeyValue.addCriteria(csValueList);
				}
			} else {
				csKeyValue.addCriterion(stringValueColumn, Criterion.EQ,
						stringValue);
			}
			Query q = new Query();
			q.addFromTable(tableTable);
			q.addSelectColumn(selectColumn);
			q.addWhereCriteria(csKeyValue);

			csReturn.addCriterion(whereColumn, Criterion.IN, q);
		}
		return csReturn;
	}

	/**
	 * Criteria filter will be of the form key,value 1. scan for "'" to find key
	 * and value 2. Based on fieldType set the column name correctly 3. Also
	 * check the operator Contains and not-contains that required special db
	 * keywords
	 */
	public static CriteriaSet parseCriteriaFilter(String criteriaFilter,
			String comparator, String fieldType, Column whereColumn) {

		com.wm.monitor.db.querygeneration.Table tableTable = null;
		Column selectColumn = null;
		Column fieldNameColumn = null;
		Column valueColumn = null;
		tableTable = ProcessAccess.TBL_PROCDATA;
		selectColumn = ProcessAccess.PROCDATA_COL_IID;
		fieldNameColumn = ProcessAccess.PROCDATA_COL_FLDNM;

		CriteriaSet csReturn = new CriteriaSet();
		String fieldName = null;
		String stringValue = null;

		// scan for = within key=value of the criteia
		Scanner scannerEquals = new Scanner(criteriaFilter);
		scannerEquals.useDelimiter(",");
		CriteriaSet csKeyValue = new CriteriaSet();
		fieldName = (((scannerEquals.next()).replace('\"', ' ')).replace('\'',
				' ')).trim();
		csKeyValue.addCriterion(fieldNameColumn, Criterion.EQ, fieldName);
		if (fieldType.equalsIgnoreCase("String")
				|| fieldType.equalsIgnoreCase("Boolean")) {
			valueColumn = ProcessAccess.PROCDATA_COL_STRVAL;
			stringValue = (((scannerEquals.next()).replace('\"', ' ')).replace(
					'\'', ' ')).trim();
			if (comparator.equalsIgnoreCase("Contains")) {
				csKeyValue.addCriterion(valueColumn, Criterion.LIKE, "%"
						+ (stringValue.trim()).toUpperCase() + "%");
			} else if (comparator.equals("=")) {
				csKeyValue.addCriterion(valueColumn, Criterion.EQ,
						stringValue.trim());
			} else if (comparator.equalsIgnoreCase("Not Contains")) {
				csKeyValue.addCriterion(valueColumn, Criterion.NOTLIKE, "%"
						+ (stringValue.trim()).toUpperCase() + "%");
			} else
				csKeyValue.addCriterion(valueColumn, comparator, stringValue);
		} else if (fieldType.equalsIgnoreCase("Date")) {
			valueColumn = ProcessAccess.PROCDATA_COL_DATEVAL;
			stringValue = (((scannerEquals.next()).replace('\"', ' ')).replace(
					'\'', ' ')).trim();
			// if (stringValue.indexOf(' ') == -1) {
			if (comparator.equalsIgnoreCase("Contains")) {
				csKeyValue.addCriterion(valueColumn, Criterion.BETW, new Range(
						stringValue));
			} else if (comparator.equalsIgnoreCase("Not Contains")) {
				csKeyValue.addCriterion(valueColumn, Criterion.NOTBETW,
						new Range(stringValue));
			} else {
				csKeyValue.addCriterion(valueColumn, comparator, new DateTime(
						stringValue));
			}
			// }

		} else if (fieldType.equalsIgnoreCase("Number")) {
			valueColumn = ProcessAccess.PROCDATA_COL_NUMVAL;
			stringValue = (((scannerEquals.next()).replace('\"', ' ')).replace(
					'\'', ' ')).trim();
			csKeyValue.addCriterion(valueColumn, comparator, new Float(
					stringValue));

		}

		Query q = new Query();
		q.addFromTable(tableTable);
		q.addSelectColumn(selectColumn);
		q.addWhereCriteria(csKeyValue);

		csReturn.addCriterion(whereColumn, Criterion.IN, q);

		return csReturn;
	}
	
	    public static String getFieldValuefromIData(IData idata, String fieldName) {
		IDataCursor cursor = idata.getCursor();
		String dataKey;
		Object dataValue;
		String dataType = "none";
		String fieldValue = null;
		while (cursor.next()) {
			dataKey = cursor.getKey();
			dataValue = cursor.getValue();

			if (dataValue != null) {
				dataType = dataValue.getClass().getName();
				if (dataType.startsWith("java.lang"))
					dataType = dataType.substring(10);
				else if (dataType.startsWith("java.util"))
					dataType = dataType.substring(10);
			}
			// if value is a basic type
			if ("Integer,Short,Long,Float,Double,Date,Character,Byte,String"
					.indexOf(dataType) >= 0) {
				if (dataKey.equals(fieldName)) {
					if (dataValue == null) {
						return "null";
					} else {
						fieldValue = dataValue.toString();
						return fieldValue;
					}
				}
			} else { // value is not a basic type
				IData d = IDataUtil.getIData(cursor);
				if (d != null) { // handle IData case
					fieldValue = getFieldValuefromIData(d, fieldName);
					if (fieldValue != null) {
						return fieldValue;
					}
				} else {
					if (dataValue instanceof IData[]) { // handle IData[] case
						IData[] da = (IData[]) dataValue;
						for (int j = 0; j < da.length; j++) {
							fieldValue = getFieldValuefromIData(da[j],
									fieldName);
							if (fieldValue != null) {
								return fieldValue;
							}
						}
					}
				}
			}
		}
		cursor.destroy();
		return fieldValue;
	}
	
	public static long getLocalTime(Long time) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(time);
		java.util.Date localTime = new java.util.Date(time
				- cal.get(Calendar.ZONE_OFFSET) - cal.get(Calendar.DST_OFFSET));
		time = localTime.getTime();
		return time;
	}
	
	public static boolean isClusterAware() {
		boolean clusterAware = false;
		IData clusterSettings;
		try {
			clusterSettings = Service.doInvoke("wm.server.query",
					"getClusterSettings", null);
			clusterAware = ValuesEmulator.getBoolean(clusterSettings,
					"clusterAware");
		} catch (Exception e) {
			Debug.logWarning(22, Debug.MON, "Unable to get cluster settings");
		}
		return clusterAware;
	}
	
	public static boolean useCache() {
		
		String useCacheProperty = "";
		boolean useCache = false;
		useCacheProperty = MonitorUtil.getMonitorProperty("wm.monitor.useCache");
		if (useCacheProperty != null && useCacheProperty.equals("true"))
			useCache = Boolean.parseBoolean(useCacheProperty);
		return useCache;
	}
}
