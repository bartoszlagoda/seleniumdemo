package com.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ProductListPage {

    private WebDriver driver;
    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage chooseProductFromProductListPage(String product){
        String path = "//h2[contains(text(),'" + product + "')]";
        WebElement elToAddFromCart = driver.findElement(By.xpath(path));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(elToAddFromCart));
        elToAddFromCart.click();

        System.out.println("Wybrano " + product);

        return new ProductPage(driver);
    }
}
