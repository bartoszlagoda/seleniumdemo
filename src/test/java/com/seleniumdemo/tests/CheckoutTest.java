package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.HomePage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest(){
        Customer customer = new Customer();
        customer.setEmail("specificEmail@specificemail.com");

        new HomePage(driver).openShopPage()
                .chooseProductFromProductListPage("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .proceedToCheckout()
                .fillAddressDetails(customer,"Some random comment");
    }
}
