package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class AddressDetailsPage {

    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement billingFirstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement billingLastName;

    @FindBy(xpath = "//input[@id='billing_company']")
    private WebElement billingCompany;

    @FindBy(xpath = "//span[@class='woocommerce-input-wrapper']/select[@id='billing_country']")
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

    @FindBy(xpath = "//span[@class='woocommerce-input-wrapper']/textarea[@name='order_comments']")
    private WebElement orderComments;

    @FindBy(xpath = "//button[@name='woocommerce_checkout_place_order']")
    private WebElement placeOrderBtn;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(ExpectedConditions.visibilityOf(billingFirstName));
        billingFirstName.sendKeys(customer.getFirstname());
        wait.until(ExpectedConditions.visibilityOf(orderComments));
        orderComments.sendKeys(comments);

        billingLastName.sendKeys(customer.getLastName());
        billingCompany.sendKeys(customer.getCompanyName());

        Select countrySelect = new Select(billingCountryContainer);
        countrySelect.selectByVisibleText(customer.getCountry());

        billingAddress1.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostcode.sendKeys(customer.getZipCode());
        billingCity.sendKeys(customer.getCity());
        billingPhone.sendKeys(customer.getPhone());
        billingEmail.sendKeys(customer.getEmail());

        System.out.println("Poprawnie wypelniono wszystkie dane do zamowienia");

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)", "");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='woocommerce_checkout_place_order']")));
        placeOrderBtn.click();

        System.out.println("Poprawnie kliknieto w placeOrder button");

        return new OrderDetailsPage(driver);
    }
}
