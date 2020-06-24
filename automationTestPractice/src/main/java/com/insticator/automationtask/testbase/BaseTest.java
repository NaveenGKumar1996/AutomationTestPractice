package com.insticator.automationtask.testbase;

import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.insticator.automationtask.pages.HomePage;
import com.insticator.automationtask.util.Constants;
import com.insticator.automationtask.util.FrameWorkUtils;
import com.insticator.automationtask.util.PropUtils;
import com.insticator.automationtask.util.ReportUtils;

public class BaseTest extends FrameWorkUtils {

	public static WebDriver driver;
	public static Properties props;
	public static String resultFile;
	public static String indexFile;

	public ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String reportsFolder;
	public static String instanceReportsFolder;
	public static String screenShotFolder;
	public static File inputFile = PropUtils.getPropFile(Constants.CONFIG_DIR, "TestData.properties");
	public static Properties testData = PropUtils.getProps(inputFile);

	@BeforeSuite(alwaysRun = true)
	public void initializeReport() throws Exception {

		Date currentdate = new Date();
		reportsFolder = Constants.REPORTS_DIR + new SimpleDateFormat("MMMMM_dd_yyyy").format(currentdate);
		ReportUtils.createResultsFolder(reportsFolder);

		instanceReportsFolder = reportsFolder + Constants.FILE_SEPARATOR
				+ new SimpleDateFormat("MMMMM_dd_yyyy_hh-mm").format(currentdate);
		ReportUtils.createResultsFolder(instanceReportsFolder);
		

		screenShotFolder = instanceReportsFolder + Constants.FILE_SEPARATOR
		+ new SimpleDateFormat("MMM-dd-yyyy_hh-mm").format(currentdate) + "_screenshots";
		ReportUtils.createResultsFolder(screenShotFolder);

		resultFile = instanceReportsFolder + Constants.FILE_SEPARATOR + "AUTOMATION_PRACTICE_"
				+ new SimpleDateFormat("MMM-dd-yyyy_hh-mm").format(currentdate) + "_" + "AutomationResults.html";

		indexFile = Constants.REPORTS_DIR + Constants.FILE_SEPARATOR + "index.html";

		// Configuring Extent Reports
		if (extent == null) {
			htmlReporter = new ExtentSparkReporter(resultFile);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Project Name", "AUTOMATION_PRACTICE");
			extent.setSystemInfo("Tester Name", "NAVEEN");
			extent.setSystemInfo("Automation Tool", "SELENIUM");
			extent.setSystemInfo("Operating System", getOSDetails());
			extent.setSystemInfo("Host Name", getHostDetails());

			htmlReporter.config().setDocumentTitle("AutomationPractice Report");
			htmlReporter.config().setReportName("Automation Practice Testing");
			htmlReporter.config().setTheme(Theme.STANDARD);
		}
	}

	@BeforeTest(alwaysRun = true)
	public static void initialization() {
		String browserName = System.getProperty("propertyName");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.DRIVER_DIR + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			// firefox driver
		}

		driver.get(PropUtils.getPropValue(testData, "baseURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {

		try {
			
			HomePage homePage = new HomePage(driver, test);
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenShotPath = capture(driver);
				test.fail(MarkupHelper.createLabel(result.getName() + " Test case failed due to below issues:",
						ExtentColor.RED));
				test.fail(result.getThrowable());
				test.fail("Screenshot below: " + test.addScreenCaptureFromPath(screenShotPath));
				homePage.clickSignOut();
			} else if (result.getStatus() == ITestResult.SUCCESS) {

				test.pass(MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			} else {
				test.skip(MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
				test.skip(result.getThrowable());
			}
		} catch (Exception ex) {
			test.fail(ex.getMessage());
		}
	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {

		try {
			extent.flush();
			ReportUtils.createIndexFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
