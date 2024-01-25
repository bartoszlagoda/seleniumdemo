package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {

    @FindBy(xpath = "//span[text()='My account']")
    private List<WebElement> myAccountLink;

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public RegisterPage openMyAccountLink(){
        myAccountLink
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return this;
    }
}
