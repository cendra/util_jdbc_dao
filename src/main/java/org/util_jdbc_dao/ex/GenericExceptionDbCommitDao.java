package org.util_jdbc_dao.ex;

import org.util_jdbc_dao.ConnectionWrapper;

abstract class GenericExceptionDbCommitDao extends GenericExceptionDbDao {

	private static final long serialVersionUID = 3056315135987623641L;

	public GenericExceptionDbCommitDao(
			@SuppressWarnings("rawtypes") Class throwerClass,
			Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(throwerClass, thirdException, connectionWrapper);

		super.operationType = "TRANSACTION";
	}

}
