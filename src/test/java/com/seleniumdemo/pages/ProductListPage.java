package com.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumdemo.utils.SeleniumHelper.waitForVisibility;

public class ProductListPage {

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage chooseProductFromProductListPage(String product) {
        String path = "//h2[contains(text(),'" + product + "')]";
        WebElement elToAddFromCart = driver.findElement(By.xpath(path));
        waitForVisibility(elToAddFromCart, driver);
        elToAddFromCart.click();

        return new ProductPage(driver);
    }
}
