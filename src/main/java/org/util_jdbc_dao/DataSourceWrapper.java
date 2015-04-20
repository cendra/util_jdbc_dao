package org.util_jdbc_dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.util_jdbc_dao.ex.ExGetConnection;
import org.util_jdbc_dao.ex.ExMetaDataDbCloseConnection;
import org.util_jdbc_dao.ex.ExMetaDataDbDao;

public class DataSourceWrapper {

	private DataSource dataSource;

	private DataSourceMetaData dataSourceMetaData;

	public DataSourceWrapper(DataSource dataSource) {
		this.dataSource = dataSource;

		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			dataSourceMetaData = new DataSourceMetaData();

			dataSourceMetaData.url = connection.getMetaData().getURL();
			dataSourceMetaData.userName = connection.getMetaData()
					.getUserName();
			dataSourceMetaData.databaseProductName = connection.getMetaData()
					.getDatabaseProductName();
			dataSourceMetaData.databaseProductVersion = connection
					.getMetaData().getDatabaseProductVersion();
			dataSourceMetaData.driverName = connection.getMetaData()
					.getDriverName();
			dataSourceMetaData.driverVersion = connection.getMetaData()
					.getDriverVersion();
			dataSourceMetaData.jDBCMajorVersion = connection.getMetaData()
					.getJDBCMajorVersion();
			dataSourceMetaData.jDBCMinorVersion = connection.getMetaData()
					.getJDBCMinorVersion();

			try {
				connection.close();
			} catch (Exception e) {
				ExMetaDataDbCloseConnection exMetaDataDbCloseConnection = new ExMetaDataDbCloseConnection(
						this.getClass(), e);
				exMetaDataDbCloseConnection.setFirstTrace(e, this.getClass());
				throw exMetaDataDbCloseConnection;
			}
		} catch (Exception e) {
			ExMetaDataDbDao exMetaDataDb = new ExMetaDataDbDao(this.getClass(),
					e);
			exMetaDataDb.setFirstTrace(e, this.getClass());
			throw exMetaDataDb;
		}
	}

	public String getUrl() {
		return dataSourceMetaData.url;
	}

	public String getUserName() {
		return dataSourceMetaData.userName;
	}

	public String getDatabaseProductName() {
		return dataSourceMetaData.databaseProductName;
	}

	public String getDatabaseProductVersion() {
		return dataSourceMetaData.databaseProductVersion;
	}

	public String getDriverName() {
		return dataSourceMetaData.driverName;
	}

	public String getDriverVersion() {
		return dataSourceMetaData.driverVersion;
	}

	public int getjDBCMajorVersion() {
		return dataSourceMetaData.jDBCMajorVersion;
	}

	public int getjDBCMinorVersion() {
		return dataSourceMetaData.jDBCMinorVersion;
	}
	
	public synchronized ConnectionWrapper getConnectionWrapper() {

		try {
			return new ConnectionWrapper(dataSource.getConnection(),
					dataSourceMetaData);
		} catch (Exception e) {
			ExGetConnection ex = new ExGetConnection(this.getClass(), e,
					new ConnectionWrapper(null, dataSourceMetaData));

			ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

}
