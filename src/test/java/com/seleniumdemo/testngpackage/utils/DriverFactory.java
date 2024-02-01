package com.seleniumdemo.testngpackage.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            String info = "Using chrome driver for Cucumber Selenium";
            System.out.println(info);
        }
        return driver;
    }

    public static void quitDriver(){
        // to stworzy obiekt przegladarki, ktora jest zamknieta
        if(driver != null){
            driver.quit();
            driver = null; // ustaw ponownie stan przegladarki na null
        }
    }
}
