package org.util_jdbc_dao.ex;

import org.util_jdbc_dao.ConnectionWrapper;



public class ExBeginDao extends GenericExceptionDbBeginDao {

	private static final long serialVersionUID = 9189527380098903220L;

	@SuppressWarnings("rawtypes")
	public ExBeginDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(throwerClass, thirdException, connectionWrapper);

		super.title = "Comienzo de Transacción";
		super.message = "Error al intentar iniciar una transacción.";

	}

}
