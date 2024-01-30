package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CartPage {

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutBtn;

    private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AddressDetailsPage proceedToCheckout(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();

        System.out.println("Poprawnie potwierdzono zamowienie");

        return new AddressDetailsPage(driver);
    }
}
