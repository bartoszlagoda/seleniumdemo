package com.seleniumdemo.testngpackage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumdemo.testngpackage.utils.SeleniumHelper.waitForVisibility;

public class OrderDetailsPage {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderNotice;

    @FindBy(xpath = "//td[contains(@class,'product-name')]")
    private WebElement productName;

    private WebDriver driver;

    public WebElement getOrderNotice() {
        waitForVisibility(orderNotice, driver);
        return orderNotice;
    }

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getProductName() {
        return productName;
    }
}
