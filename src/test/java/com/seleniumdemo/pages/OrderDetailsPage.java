package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class OrderDetailsPage {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderNotice;

    private WebDriver driver;

    public WebElement getOrderNotice() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(orderNotice));
        return orderNotice;
    }

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
