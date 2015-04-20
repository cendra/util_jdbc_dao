package org.util_jdbc_dao.ex;

import org.util_jdbc_dao.ConnectionWrapper;

public class ExCommitDao extends GenericExceptionDbCommitDao {

	private static final long serialVersionUID = 6896292342225230993L;

	@SuppressWarnings("rawtypes")
	public ExCommitDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(throwerClass, thirdException, connectionWrapper);

		super.title = "Fin de Transacción";
		super.message = "Error al intentar confirmar una transacción.";

	}

}
