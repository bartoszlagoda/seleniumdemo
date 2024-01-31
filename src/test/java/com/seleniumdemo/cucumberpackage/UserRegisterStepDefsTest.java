package com.seleniumdemo.cucumberpackage;

import com.github.javafaker.Faker;
import com.seleniumdemo.testngpackage.pages.HomePage;
import com.seleniumdemo.testngpackage.pages.MyAccountPage;
import com.seleniumdemo.testngpackage.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class UserRegisterStepDefsTest {

    WebDriver driver;
    WebElement entryTitle;
    WebElement failedRegisterAlert;
    int randomNumber = (int) (Math.random()*1000);

    @Given("Uzytkownik znajduje sie na stronie glownej sklepu")
    public void uzytkownik_znajduje_sie_na_stronie_glownej_sklepu() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
    }

    @When("Przejscie do strony MyAccount")
    public void przejscie_do_strony_my_account() {
         new HomePage(driver)
                .openMyAccountPage();
    }


    @And("Wprowadzamy poprawne dane do formularza rejestracji")
    public void wprowadzamyPoprawneDaneDoFormularzaRejestracji() {
        Faker faker = new Faker();
        entryTitle = new MyAccountPage(driver)
                .registerUserValidData(faker.internet().emailAddress(),"testeroprogramowania@testeroprogramowania.com")
                .getEntryTitle();
    }

    @Then("Uzytkownik zostaje przekierowany do strony Moje Konto")
    public void uzytkownikZostajePrzekierowanyDoStronyMojeKonto() {
        List<WebElement> logoutLinks = driver.findElements(By.linkText("Logout"));
        Assert.assertTrue(logoutLinks.size() > 0);
        Assert.assertTrue(logoutLinks.get(0).isDisplayed());
        Assert.assertTrue(entryTitle.getText().contains("Hello"));
    }

    @But("Nie jest widoczny formularz rejestracji uzytkownika")
    public void nieJestWidocznyFormularzRejestracjiUzytkownika() {
        int emailInputSize = driver.findElements(By.id("reg_email")).size();
        Assert.assertTrue(emailInputSize == 0);
        driver.quit();
    }

    @And("Wprowadzamy niepoprawne dane do formularza rejestracji")
    public void wprowadzamyNiepoprawneDaneDoFormularzaRejestracji() {
        failedRegisterAlert = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test1@test1.com", "test1@test1.com")
                .getError();
    }

    @Then("Wyswietla sie komunikat o niepoprawnym adresie email")
    public void wyswietlaSieKomunikatONiepoprawnymAdresieEmail() {
        Assert.assertTrue(failedRegisterAlert.getText().contains("An account is already registered"));
        driver.quit();
    }
}
