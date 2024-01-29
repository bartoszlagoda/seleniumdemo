package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        addToCartBtn.click();

        return this;
    }

    public CartPage viewCart(){
        viewCartBtn.click();

        return new CartPage(driver);
    }
}
