package com.insticator.automationtask.pagebase;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;
import com.insticator.automationtask.testbase.BaseTest;

public class BasePage extends BaseTest {

	public BasePage(WebDriver driver, ExtentTest test) {
		BaseTest.driver = driver;
		BaseTest.test = test;
	}

	public void logPass(String msg) {
		test.pass(MarkupHelper.createLabel(msg, ExtentColor.GREEN));
	}

	public void logInfo(String msg) {
		test.info(MarkupHelper.createLabel(msg, ExtentColor.BLUE));
	}

	public void logFail(String msg) {
		test.fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
		Assert.assertFalse(true, msg);
	}

	public void waitUntilElementDisplayed(final WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
	}

	public Faker FakerAPI() {
		Faker faker = new Faker();
		return faker;
	}

	public void actionClick(WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(locator));
		Actions act = new Actions(driver);
		act.moveToElement(locator).click(locator).build().perform();

	}

	public void isDisplayedThenActionClick(WebElement locator, String message) {
		try {
			waitUntilElementDisplayed(locator);
			if (locator.isDisplayed()) {
				actionClick(locator);
				logPass(message + " id Displayed and Clicked on it.");
			} else {
				logFail(message + " is Not Displayed");
			}
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

	public void isDisplayedThenEnterText(WebElement locator, String message, String sendText) {
		try {
			waitUntilElementDisplayed(locator);
			System.out.println("element present:: ");
			locator.clear();
			sleep(3);
			locator.sendKeys(sendText);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

	public void isDisplayed(WebElement locator, String message) {
		try {
			if (locator != null) {
				waitUntilElementDisplayed(locator);
				if (locator.isDisplayed()) {
					logPass(message + " is Displayed");
				} else {
					logFail(message + " is Not Displayed");
				}
			}

			else {
				logInfo("Locator is Null");
			}
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(min) + max;
	}

	public void selectValueRandomly(WebElement locator, String message) {
		try {
			int index = 0;
			Select selRandom = new Select(locator);
			List<WebElement> options = selRandom.getOptions();
			int optionSize = options.size();
			String value = options.get(0).getText();
			if (value.equals("-") || value.equals("--")) {
				index = getRandomNumber(1, optionSize - 1);
			} else {
				index = getRandomNumber(0, optionSize - 1);
			}
			selRandom.selectByIndex(index);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

	public void mouseHover(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(locator));
		Actions act = new Actions(driver);
		act.moveToElement(locator).build().perform();
	}

	public void selectDropDownByText(WebElement locator, String text) {
		try {
			Select selectByText = new Select(locator);
			selectByText.selectByVisibleText(text);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}

	}

	public String getText(WebElement locator) {

		String text = "";

		if (locator.isDisplayed()) {
			waitUntilElementDisplayed(locator);
			text = locator.getText().trim();
		}
		return text;
	}

	public void textCompare(String text1, String text2) {
		Assert.assertEquals(text1, text2);
	}

	public void verifyText(WebElement locator, String text) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
		Assert.assertEquals(locator.getText().trim(), text);

	}

	public void scrollDownPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,390)", "");
	}

	public void scrollUpPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public void scrollToTopPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-1000)", "");
	}

	public void isDisplayedThenClickRadioBtn(WebElement locator, String message) {
		try {
			waitUntilElementDisplayed(locator);
			isDisplayed(locator, message);
			boolean isSelectedOrNot = locator.isSelected();
			if (!isSelectedOrNot) {
				locator.click();
				logPass(message + " id Displayed and Clicked on it.");
			} else {
				logFail(message + " is Not Displayed");
			}
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

	public void isDisplayedThenClickCheckBox(WebElement locator, String message) {
		try {
			waitUntilElementDisplayed(locator);
			isDisplayed(locator, message);
			boolean isSelectedOrNot = locator.isSelected();
			if (!isSelectedOrNot) {
				locator.click();
				logPass(message + " id Displayed and Clicked on it.");
			} else {
				logFail(message + " is Not Displayed");
			}
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

}
