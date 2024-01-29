package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        int randomNum = (int) (Math.random() * 1000);

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUser("test" + randomNum + "@test2.com", "test" + randomNum + "@test2.com")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.getText().contains("Hello"));
    }
}
