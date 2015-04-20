package org.util_jdbc_dao.ex;

import org.util_jdbc_dao.ConnectionWrapper;

abstract class GenericExceptionDbRollBackDao extends
		GenericExceptionDbDao {

	private static final long serialVersionUID = -7235006539649561859L;

	public GenericExceptionDbRollBackDao(
			@SuppressWarnings("rawtypes") Class throwerClass,
			Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(throwerClass, thirdException, connectionWrapper);

		super.operationType = "TRANSACTION";
	}

}
