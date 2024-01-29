package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUser("test2@test2.com", "test2@test2.com")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.getText().contains("Hello"));
    }
}
