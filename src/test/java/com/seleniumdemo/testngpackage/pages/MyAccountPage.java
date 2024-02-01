package com.seleniumdemo.testngpackage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumdemo.testngpackage.utils.SeleniumHelper.waitForClickable;
import static com.seleniumdemo.testngpackage.utils.SeleniumHelper.waitForVisibility;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerBtn;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement loginUsername;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(name = "login")
    private WebElement loginBtn;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);

        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);

        return this;
    }

    public LoggedUserPage loginUserValidData(String email, String password) {
        loginUser(email, password);

        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginUserInvalidData(String email, String password) {
        loginUser(email, password);

        return this;
    }

    private void loginUser(String email, String password) {
        loginUsername.sendKeys(email);
        loginPassword.sendKeys(password);

        waitForClickable(By.name("login"), driver);

        loginBtn.click();
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);

        waitForVisibility(registerBtn,driver);

        registerBtn.click();
    }

    public WebElement getError() {
        waitForVisibility(error, driver);
        return error;
    }
}
