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

    private static final Logger logger = LogManager.getLogger();

    public static void waitForClickable(By locator, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForVisibility(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPresenceOfElementLocated(By locator, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void scrollWindowToElement(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,650)", "");
        Thread.sleep(5000);
    }

    public static void chooseSelect(WebElement element,String selectElement){
        Select countrySelect = new Select(element);
        countrySelect.selectByVisibleText(selectElement);
    }

    public static void waitForElementToExist(By locator){
        logger.info("Wywoluje metode waitForElementToExist z Timeoutem 12s i powtarzaniem co sekunde.");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getChromeDriver(),Duration.ofSeconds(12));
        wait.withTimeout(Duration.ofSeconds(12));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until(driver -> driver.findElements(locator).size() > 0);
    }

    public static void checkIfElementIsClickableOnTheLoop(By locator,int count) throws InterruptedException {
        logger.info("Cos poszlo nie tak z kliknieciem przycisku 'Register'");
        for(int i=0; i<count; i++){
            logger.info("Wywoluje " + (i+1) + " raz petle. Probuje ponownie...");
            if(DriverFactory.getChromeDriver().findElements(locator).size() > 0){
                Thread.sleep(1000);
                DriverFactory.getChromeDriver().findElement(locator).click();
                logger.info("Znaleziono element i go wybrano.");
                break;
            }
        }
    }
}
