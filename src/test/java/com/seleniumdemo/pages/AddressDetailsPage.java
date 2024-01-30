package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressDetailsPage {

    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement billingFirstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement billingLastName;

    @FindBy(xpath = "//input[@id='billing_company']")
    private WebElement billingCompany;

    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    private WebElement billingCountryContainer;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    private WebElement billingAddress1;

    @FindBy(xpath = "//input[@id='billing_address_2']")
    private WebElement billingAddress2;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement billingPostcode;

    @FindBy(xpath = "//input[@id='billing_city']")
    private WebElement billingCity;

    @FindBy(xpath = "//input[@id='billing_phone']")
    private WebElement billingPhone;

    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement billingEmail;

    @FindBy(xpath = "//input[@id='order_comments']")
    private WebElement orderComments;

    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement placeOrderBtn;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments){
        billingFirstName.sendKeys(customer.getFirstname());
        billingLastName.sendKeys(customer.getLastName());
        billingCompany.sendKeys(customer.getCompanyName());

        Select countrySelect = new Select(billingCountryContainer);
        countrySelect.selectByVisibleText(customer.getCountry());

        billingAddress1.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostcode.sendKeys(customer.getZipCode());
        billingCity.sendKeys(customer.getCity());
        billingCity.sendKeys(customer.getCity());
        billingPhone.sendKeys(customer.getPhone());
        billingEmail.sendKeys(customer.getEmail());
        orderComments.sendKeys(comments);

        return new OrderDetailsPage(driver);
    }
}
