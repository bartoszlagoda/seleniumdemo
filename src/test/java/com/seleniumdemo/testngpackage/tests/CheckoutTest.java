package com.seleniumdemo.testngpackage.tests;

import com.seleniumdemo.testngpackage.models.Customer;
import com.seleniumdemo.testngpackage.pages.HomePage;
import com.seleniumdemo.testngpackage.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() throws InterruptedException {
        Customer customer = new Customer();
        customer.setEmail("specificEmail@specificemail.com");

        OrderDetailsPage order = new HomePage(driver)
                .openShopPage()
                .chooseProductFromProductListPage("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .proceedToCheckout()
                .fillAddressDetails(customer, "Some random comment");

        Assert.assertEquals(order.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(order.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}
