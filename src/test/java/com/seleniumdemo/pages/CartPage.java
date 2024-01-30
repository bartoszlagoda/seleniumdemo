package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.seleniumdemo.utils.SeleniumHelper.waitForVisibility;

public class CartPage {

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutBtn;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AddressDetailsPage proceedToCheckout() {
        waitForVisibility(proceedToCheckoutBtn, driver);
        proceedToCheckoutBtn.click();

        return new AddressDetailsPage(driver);
    }
}
