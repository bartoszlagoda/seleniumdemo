package com.seleniumdemo.testngpackage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[contains(text(),'Shop')]")
    private WebElement shopLink;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();

        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        System.out.println("Otworzono opcje 'Shop'");
        shopLink.click();

        return new ProductListPage(driver);
    }
}