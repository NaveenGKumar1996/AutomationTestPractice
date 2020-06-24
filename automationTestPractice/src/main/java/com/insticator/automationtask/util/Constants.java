package com.insticator.automationtask.util;

public class Constants {

		public static final String NEW_LINE = System.getProperty("line.separator");
		public static final String FILE_SEPARATOR = System.getProperty("file.separator");

		// Getting the current Project Directory
		public static final String USER_DIR = System.getProperty("user.dir");

		// Folders names
		public static final String DRIVER_FOLDER_NAME = "BrowserDrivers";
		public static final String CONFIG_FOLDER_NAME = "Configuration";
		public static final String REPORTS_FOLDER_NAME = "Reports";
		

		// Directories absolute paths
		public static final String DRIVER_DIR = USER_DIR + FILE_SEPARATOR + DRIVER_FOLDER_NAME + FILE_SEPARATOR;
		public static final String CONFIG_DIR = USER_DIR + FILE_SEPARATOR + CONFIG_FOLDER_NAME + FILE_SEPARATOR;
		public static final String REPORTS_DIR = USER_DIR + FILE_SEPARATOR + REPORTS_FOLDER_NAME + FILE_SEPARATOR;
		
	}
