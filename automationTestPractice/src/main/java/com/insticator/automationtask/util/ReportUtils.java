package com.insticator.automationtask.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.insticator.automationtask.testbase.BaseTest;

//import com.framework.basetest.BaseTest;

public class ReportUtils {

	//Creates the folder path
	public static void createResultsFolder(String folderPath) {
		File dirInfo = new File(folderPath);

		
		if (!dirInfo.exists()) {
			dirInfo.mkdir();
		}
	}

	//create index html page
	public static void createIndexFile() {
		// Creating Index file
		File source = new File(BaseTest.resultFile);
		File destination = new File(BaseTest.indexFile);
		
		try {
		    FileUtils.copyFile(source, destination);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
	}

}
