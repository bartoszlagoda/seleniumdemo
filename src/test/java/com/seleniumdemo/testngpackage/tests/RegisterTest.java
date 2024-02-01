package com.seleniumdemo.testngpackage.tests;

import com.seleniumdemo.testngpackage.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() throws InterruptedException {

        int randomNum = (int) (Math.random() * 1000);

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("test" + randomNum + "@test2.com", "test" + randomNum + "@test2.com")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.getText().contains("Hello"));
    }

    @Test
    public void registerUserWithSameEmailTest() throws InterruptedException {

        WebElement failedRegisterAlert = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test1@test1.com", "test1@test1.com")
                .getError();

        Assert.assertTrue(failedRegisterAlert.getText().contains("An account is already registered"));
    }
}
