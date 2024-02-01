package com.seleniumdemo.testngpackage.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

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

    public static boolean checkIfElementIsClickableOnTheLoop(By locator,int count) throws InterruptedException {
        for(int i=0; i<count; i++){
            if(DriverFactory.getDriver().findElements(locator).size() > 0){
                Thread.sleep(1000);
                DriverFactory.getDriver().findElement(locator).click();
                return true;
            }
        }
        return false;
    }
}
