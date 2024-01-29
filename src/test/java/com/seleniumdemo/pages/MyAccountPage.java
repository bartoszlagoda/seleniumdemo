package com.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerBtn;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private WebElement failedRegisterAlert;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email,password);

        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email,password);

        return this;
    }

    private void registerUser(String email, String password){
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("register")));

        registerBtn.click();
    }

    public WebElement getFailedRegisterAlert(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(failedRegisterAlert));
        return failedRegisterAlert;
    }
}
