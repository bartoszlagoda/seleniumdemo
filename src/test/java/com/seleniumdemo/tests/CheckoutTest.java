package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest(){
        new HomePage(driver).openShopPage()
                .chooseProductFromProductListPage("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .proceedToCheckout();
    }
}
