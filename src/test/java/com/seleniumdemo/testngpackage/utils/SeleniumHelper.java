package com.seleniumdemo.testngpackage.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    private static Logger logger;

    public static void waitForClickable(By locator, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForVisibility(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPresenceOfElementLocated(By locator, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,0));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public static void scrollWindowToElement(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,650)", "");
    }

    public static void chooseSelect(WebElement element,String selectElement){
        Select countrySelect = new Select(element);
        countrySelect.selectByVisibleText(selectElement);
    }

    public static void waitForElementToExist(By locator){
        logInfo("Calls the waitForElement Exist method with a timeout of 12s and repetition every second");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(12));
        wait.withTimeout(Duration.ofSeconds(12));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until(driver -> driver.findElements(locator).size() > 0);
    }

    public static void checkIfElementIsClickableOnTheLoop(By locator,int count) throws InterruptedException {
        logInfo("Need to check if locator " + locator + " is clickable in the loop");
//        for(int i=0; i<count; i++){
//            logInfo((i+1) + " attempt");
//            if(DriverFactory.getDriver().findElements(locator).size() > 0){
//                Thread.sleep(1000);
//                DriverFactory.getDriver().findElement(locator).click();
//                logInfo(locator + " is found");
//                break;
//            }
//        }
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(12));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,0));
        wait.withTimeout(Duration.ofSeconds(12));
        wait.pollingEvery(Duration.ofSeconds(1));
        DriverFactory.getDriver().findElement(locator).click();
    }

    public static void logInfo(String info){
        logger = LogManager.getLogger();
        logger.info(info);
    }
}
