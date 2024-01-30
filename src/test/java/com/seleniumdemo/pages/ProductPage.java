package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ProductPage {

    private WebDriver driver;

    @FindBy(name = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[contains(text(),'View cart')]")
    private WebElement viewCartBtn;
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addProductToCart(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        addToCartBtn.click();

        System.out.println("Dodano produkt do karty");

        return this;
    }

    public CartPage viewCart(){
        System.out.println("Poprawne przejscie do podgladu zamowienia");
        viewCartBtn.click();

        return new CartPage(driver);
    }
}
