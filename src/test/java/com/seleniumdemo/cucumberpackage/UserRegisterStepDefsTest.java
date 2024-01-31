package com.seleniumdemo.cucumberpackage;

import com.seleniumdemo.testngpackage.pages.HomePage;
import com.seleniumdemo.testngpackage.pages.MyAccountPage;
import com.seleniumdemo.testngpackage.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserRegisterStepDefsTest {

    WebDriver driver;
    WebElement entryTitle;

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
        entryTitle = new MyAccountPage(driver)
                .registerUserValidData("tester"+ (int) (Math.random()*1000) + "@gmail.com","testeroprogramowania@testeroprogramowania.com")
                .getEntryTitle();
    }

    @Then("Uzytkownik zostaje przekierowany do strony Moje Konto")
    public void uzytkownikZostajePrzekierowanyDoStronyMojeKonto() {
        Assert.assertTrue(entryTitle.getText().contains("Hello"));
    }

    @But("Nie jest widoczny formularz rejestracji uzytkownika")
    public void nieJestWidocznyFormularzRejestracjiUzytkownika() {
        System.out.println("Nie jest widoczny formularz rejestracji");
    }

    @And("Wprowadzamy niepoprawne dane do formularza rejestracji")
    public void wprowadzamyNiepoprawneDaneDoFormularzaRejestracji() {
        System.out.println("Wprowadzamy niepoprawne dane");
    }

    @Then("Wyswietla sie komunikat o niepoprawnym adresie email")
    public void wyswietlaSieKomunikatONiepoprawnymAdresieEmail() {
        System.out.println("Wyswietla sie komunikat o niepoprawnym adresie email");
    }
}
