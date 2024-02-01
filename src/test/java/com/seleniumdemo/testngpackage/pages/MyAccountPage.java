package com.seleniumdemo.testngpackage.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumdemo.testngpackage.utils.SeleniumHelper.*;

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
    private static final Logger logger = LogManager.getLogger();

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) throws InterruptedException {
        waitForElementToExist(By.name("register"));
        registerUser(email, password);

        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) throws InterruptedException {
        waitForElementToExist(By.name("register"));
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

    private void registerUser(String email, String password) throws InterruptedException {
        logger.info("Uruchamiam metode registerUser");
        logger.info("Wprowadzam email '" + email + "'");
        regEmailInput.sendKeys(email);
        logger.info("Wprowadzam haslo '" + password + "'");
        regPasswordInput.sendKeys(password);
        logger.info("Scrolluje do elementu Register");
        scrollWindowToElement(driver);
        logger.info("Czekam az element Register zaistnieje na stronie");
        waitForElementToExist(By.name("register"));
        checkIfElementIsClickableOnTheLoop(By.name("register"),6);
    }

    public WebElement getError() {
        waitForVisibility(error, driver);
        return error;
    }
}
