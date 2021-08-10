package com.insticator.automationtask.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.insticator.automationtask.testbase.BaseTest;

public class FrameWorkUtils {
	
	//OS Details	
	public static String getOSDetails() throws Exception {
		String OS = System.getProperty("os.name");
		OS = (OS).toUpperCase();
		//System.out.println(OS);
		return OS;
	}

	//Host Details
	public static String getHostDetails() throws Exception {
		String myHost = InetAddress.getLocalHost().getHostName().toUpperCase().trim();
		//System.out.println(myHost);
		return myHost;
	}
	
	//Date and Time Details
	public static String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		return sdf.format(date);
	}
	
	//Take Screenshot
	public static String capture(WebDriver driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String dest = BaseTest.screenShotFolder + "/" + getCurrentDateTime() + ".png";
		System.out.println("Dest:........" + dest);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

}
