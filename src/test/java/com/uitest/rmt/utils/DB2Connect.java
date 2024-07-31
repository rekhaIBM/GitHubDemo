package com.uitest.rmt.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.uitest.createcmr.pageObjects.db.DBQueries;

public class DB2Connect {
	private TestContextSetup ctx;
	private Logger logger = LogManager.getLogger(DB2Connect.class);
	private Connection _dbConn; // active DB connection
	// private DBQueries dbQueries;

	public DB2Connect(TestContextSetup ctx) {
		this.ctx = ctx;
		_dbConn = null;
	}

	public DB2Connect() {
		_dbConn = null;
	}

	// Here we are passing all the required detailed of the DB2
	public List<Map<String, String>> setUp(String query) {
		java.util.Properties properties = new java.util.Properties();
		properties.put("user", System.getenv("user"));
		properties.put("password", System.getenv("pwd"));
		properties.put("sslConnection", System.getenv("sslConnection"));
		properties.put("sslTrustStoreLocation", System.getenv("sslTrustStoreLocation"));
		properties.put("sslTrustStorePassword", System.getenv("sslTrustStorePassword"));
		DB2Connect db2 = new DB2Connect();
		db2.connect(System.getenv("host"), System.getenv("port"), System.getenv("dbName"), System.getenv("user"),
				properties);
		return db2.query(query);

	}

//  public DBQueries createDBQueries() {
//    if (dbQueries == null) {
//      dbQueries = new DBQueries(ctx);
//    }
//    return dbQueries;
//  }

	public void conn() {

	}

	public boolean connect(String ip, String port, String dbName, String userName, java.util.Properties properties) {
		if (!close())
			return false;
		logger.info("Create connection to DB: " + "jdbc:db2://" + ip + ":" + port + "/" + dbName + " with username: "
				+ userName);
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			_dbConn = DriverManager.getConnection("jdbc:db2://" + ip + ":" + port + "/" + dbName, properties);

		} catch (Exception e) {
			logger.error("Failed to create connection to DB: " + "jdbc:db2://" + ip + ":" + port + "/" + dbName
					+ " with username: " + userName);
			logger.error(e.toString());
			e.printStackTrace();
			_dbConn = null;
			return false;
		}
		return true;
	}

	public boolean close() {
		try {
			if (_dbConn != null) {
				logger.info("Close active connection to DB");
				_dbConn.close();
				_dbConn = null;
			}
		} catch (Exception e) {
			logger.error("Failed to close the active connection to DB");
			logger.error(e.toString());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method executes provided SQL statement and return result data
	 * 
	 * @param sql SQL statement
	 * 
	 * @return <code>List<Map<String, String>></code>
	 */
	public List<Map<String, String>> query(String sql) {
		List<Map<String, String>> result = null;
		try {
			if (sql == null) {
				logger.error("Provided SQL statement is NULL");
				return null;
			}
			logger.info("Execute specified SQL: " + "\"" + sql + "\"");
			if (_dbConn == null) {
				logger.error("No valid DB connection for executing SQL");
				return null;
			}
			result = new ArrayList<Map<String, String>>();
			Statement sqlStatement = _dbConn.createStatement();
			ResultSet rs = sqlStatement.executeQuery(sql);
			while (rs.next()) {
				Map<String, String> recordMap = new HashMap<String, String>();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					recordMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
				}
				result.add(recordMap);
			}
			sqlStatement.close();
		} catch (Exception e) {
			result = null;
			logger.error("Failed to execute specified SQL: " + "\"" + sql + "\"");
			logger.error(e.toString());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method executes provided SQL statement and return result data
	 * 
	 * @param sql SQL statement
	 * 
	 * @return <code>List<Map<String, Object>></code>
	 */
	public List<Map<String, Object>> getQueryResult(String sql) {
		List<Map<String, Object>> result = null;
		try {
			if (sql == null) {
				logger.error("Provided SQL statement is NULL");
				return null;
			}
			logger.info("Execute specified SQL: " + "\"" + sql + "\"");
			if (_dbConn == null) {
				logger.error("No valid DB connection for executing SQL");
				return null;
			}
			result = new ArrayList<Map<String, Object>>();
			Statement sqlStatement = _dbConn.createStatement();
			ResultSet rs = sqlStatement.executeQuery(sql);
			while (rs.next()) {
				Map<String, Object> recordMap = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String columnType = rsmd.getColumnTypeName(i);
					if (columnType.equalsIgnoreCase("TIMESTAMP")) {
						recordMap.put(rsmd.getColumnName(i), rs.getTimestamp(rsmd.getColumnName(i)));
					} else {
						recordMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
					}
				}
				result.add(recordMap);
			}
			sqlStatement.close();
		} catch (Exception e) {
			result = null;
			logger.error("Failed to execute specified SQL: " + "\"" + sql + "\"");
			logger.error(e.toString());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * The following methods are deprecated, we do not encourage you to use
	 */
	public List<Map<String, String>> getResultFromDB2(String ip, String port, String dbName, String userName,
			Properties properties, String sql) {
		this.connect(ip, port, dbName, userName, properties);
		return query(sql);
	}

	public ResultSet getQuery(String sql) throws Exception {
		ResultSet rs = null;
		Statement sqlStatement = _dbConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,
				ResultSet.HOLD_CURSORS_OVER_COMMIT);
		System.out.println(sql);
		rs = sqlStatement.executeQuery(sql);
		return rs;
	}

	/**
	 * The following methods execute SQL, such as update
	 */
	public Boolean executesql(String sql) {
		Boolean result = null;
		try {
			if (sql == null) {
				logger.error("Provided SQL statement is NULL");
				return null;
			}
			logger.info("Execute specified SQL: " + "\"" + sql + "\"");
			if (_dbConn == null) {
				logger.error("No valid DB connection for executing SQL");
				return null;
			}

			Statement sqlStatement = _dbConn.createStatement();
			result = sqlStatement.execute(sql);

		} catch (Exception e) {
			logger.error("Failed to execute specified SQL: " + "\"" + sql + "\"");
			logger.error(e.toString());
			e.printStackTrace();
		}
		return result;
	}

	// call DB executesql methord
	public void main1(String Query) throws Exception {
		Properties Param = null;
		Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "./properties/DB.properties");
		Param.load(fip);
		String DBhost = Param.getProperty("PREDBhost");
		String DBportnumber = Param.getProperty("PREDBportnumber");
		String DBname = Param.getProperty("PREDBname");
		String DBusername = Param.getProperty("PREDBusername");
		String DBpassword = Param.getProperty("PREDBpassword");
		String sslTrustStoreLocation = Param.getProperty("sslTrustStoreLocation");
		String sslTrustStorePassword = Param.getProperty("sslTrustStorePassword");
		java.util.Properties properties = new java.util.Properties();
		properties.put("user", DBusername);
		properties.put("password", DBpassword);
		properties.put("sslConnection", "true");
		properties.put("sslTrustStoreLocation", sslTrustStoreLocation);
		properties.put("sslTrustStorePassword", sslTrustStorePassword);
		DB2Connect db = new DB2Connect();
		db.connect(DBhost, DBportnumber, DBname, DBusername, properties);
		db.executesql(Query);

		db.close();
	}

	// Below is showing a demo how to use DB2Connect Class.
	public List<Map<String, String>> main2(String Query) throws Exception {
		Properties Param = null;
		Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "./properties/DB.properties");
		Param.load(fip);
		String DBhost = Param.getProperty("PREDBhost");
		String DBportnumber = Param.getProperty("PREDBportnumber");
		String DBname = Param.getProperty("PREDBname");
		String DBusername = Param.getProperty("PREDBusername");
		String DBpassword = Param.getProperty("PREDBpassword");
		String sslTrustStoreLocation = Param.getProperty("sslTrustStoreLocation");
		String sslTrustStorePassword = Param.getProperty("sslTrustStorePassword");
		java.util.Properties properties = new java.util.Properties();
		properties.put("user", DBusername);
		properties.put("password", DBpassword);
		properties.put("sslConnection", "true");
		properties.put("sslTrustStoreLocation", sslTrustStoreLocation);
		properties.put("sslTrustStorePassword", sslTrustStorePassword);
		DB2Connect db = new DB2Connect();
		db.connect(DBhost, DBportnumber, DBname, DBusername, properties);
		List<Map<String, String>> result1 = db.query(Query);
		// System.out.println(result1.toString());
		for (int i = 0; i < result1.size(); i++) {
			Map<String, String> AllmsrcResults = result1.get(i);
			System.out.println(AllmsrcResults.toString());
		}
		db.close();
		return result1;
	}

	public Map<String, String> main3(String Query) throws Exception {
		Properties Param = null;
		Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "./properties/DB.properties");
		Param.load(fip);
		String DBhost = Param.getProperty("PREDBhost");
		String DBportnumber = Param.getProperty("PREDBportnumber");
		String DBname = Param.getProperty("PREDBname");
		String DBusername = Param.getProperty("PREDBusername");
		String DBpassword = Param.getProperty("PREDBpassword");
		String sslTrustStoreLocation = Param.getProperty("sslTrustStoreLocation");
		String sslTrustStorePassword = Param.getProperty("sslTrustStorePassword");
		java.util.Properties properties = new java.util.Properties();
		properties.put("user", DBusername);
		properties.put("password", DBpassword);
		properties.put("sslConnection", "true");
		properties.put("sslTrustStoreLocation", sslTrustStoreLocation);
		properties.put("sslTrustStorePassword", sslTrustStorePassword);
		DB2Connect db = new DB2Connect();
		db.connect(DBhost, DBportnumber, DBname, DBusername, properties);
		List<Map<String, String>> result1 = db.query(Query);
		Map<String, String> AllmsrcResults = null;
		for (int i = 0; i < 1; i++) {
			AllmsrcResults = result1.get(i);
			System.out.println(AllmsrcResults.toString());
		}
		db.close();
		return AllmsrcResults;
	}

	public Map<String, String> main4(String Query, DB2Connect db) throws Exception {
		// commented below code to avoid multiple times establishing and closing
		// connection for multiple queries
		Map<String, String> AllmsrcResults = null;
		try {
			List<Map<String, String>> result1 = db.query(Query);
			for (int i = 0; i < 1; i++) {
				AllmsrcResults = result1.get(i);
				System.out.println(AllmsrcResults.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No data is generated in >>" + Query
					+ " or DB Connection is not established. Error Msg: " + e.getMessage());
		}
		return AllmsrcResults;
	}

	public Map<String, String> get2ColumnAsMap(String Query) throws Exception {
		Properties Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "./properties/DB.properties");
		Param.load(fip);
		String DBhost = Param.getProperty("PREDBhost");
		String DBportnumber = Param.getProperty("PREDBportnumber");
		String DBname = Param.getProperty("PREDBname");
		String DBusername = Param.getProperty("PREDBusername");
		String DBpassword = Param.getProperty("PREDBpassword");
		String DBurl = Param.getProperty("dbpreprodURL");
		String sslTrustStoreLocation = Param.getProperty("sslTrustStoreLocation");
		String sslTrustStorePassword = Param.getProperty("sslTrustStorePassword");
		java.util.Properties properties = new java.util.Properties();
		properties.put("user", DBusername);
		properties.put("password", DBpassword);
		properties.put("sslConnection", "true");
		properties.put("sslTrustStoreLocation", sslTrustStoreLocation);
		properties.put("sslTrustStorePassword", sslTrustStorePassword);
		Map<String, String> recordMap = new HashMap<String, String>();
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			// DB2Driver db2driver = new DB2Driver();
			// db2driver.connect("jdbc:db2://rdcppdb21.az13.dal.cpc.ibm.com:60000/EUSHDB2A",
			// properties);
			_dbConn = DriverManager.getConnection(DBurl, properties);
			Statement sqlStatement = _dbConn.createStatement();
			ResultSet rs = sqlStatement.executeQuery(Query);

			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				String queryStr = recordMap.put(rs.getString(rsmd.getColumnName(1)),
						rs.getString(rsmd.getColumnName(2)));
				System.out.println("Data is=" + queryStr);
			}
			sqlStatement.close();
			_dbConn.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Failed to execute specified SQL: " + e);
			recordMap.put("None", "None");
		}

		return recordMap;
	}
}
