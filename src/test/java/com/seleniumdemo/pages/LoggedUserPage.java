package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoggedUserPage {

    @FindBy(xpath = "//div[@class='woocommerce']/div[@class='woocommerce-MyAccount-content']/p[contains(text(),'Hello ')]")
    private WebElement welcomeParagraph;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private WebElement failedRegisterAlert;


    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEntryTitle() {
        return welcomeParagraph;
    }

    public WebElement getFailedRegisterAlert(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(failedRegisterAlert));
        return failedRegisterAlert;
    }
}
