package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.HomePage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest(){
        Customer customer = new Customer();
        customer.setFirstname("Bartosz");
        customer.setLastName("Testowy");
        customer.setCompanyName("BMB");
        customer.setCountry("Poland");
        customer.setStreet("Testowa");
        customer.setFlatNumber("22");
        customer.setZipCode("11111");
        customer.setCity("Testowe");
        customer.setPhone("111111111");
        customer.setEmail("random@gmail.com");

        new HomePage(driver).openShopPage()
                .chooseProductFromProductListPage("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .proceedToCheckout()
                .fillAddressDetails(customer,"Some random comment");
    }
}
