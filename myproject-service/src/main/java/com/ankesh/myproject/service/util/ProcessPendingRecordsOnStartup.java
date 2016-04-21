package com.ankesh.myproject.service.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.ankesh.myproject.persistence.dao.util.DBConstants;


public class ProcessPendingRecordsOnStartup
               implements ServletContextListener{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProcessPendingRecordsOnStartup.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LOGGER.info("ServletContextListener destroyed");
	}

    //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {		

		LOGGER.info("ServletContextListener started");
		//invokeProcessPendingRecordsSP(DBConstants.CALL_PROCESS_PENDING_RECORDS_PROCEDURE);
	}
	
	
	private void invokeProcessPendingRecordsSP(String storedProcedureName) {
		System.out.println("Method name invokeProcessPendingRecordsSP called");
	}
}

