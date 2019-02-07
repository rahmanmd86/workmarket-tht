package com.workmarket.test.qe;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.Keys;

import junit.framework.Assert;

public class HomePageTest extends TestBase {

    private static final String USERNAME = "qa+candidatetest@workmarket.com";
    private static final String PASSWORD = "candidate123";

    @Test
    public void testVerifySearchCriteriaExistsInHomePage() throws InterruptedException {

        navigateToLoginPage();
        loginPage().login(USERNAME, PASSWORD);
        
        homePage().navigateToMenuItem("Find Talent");
        searchPage().search().sendKeys("test" + Keys.ENTER);

        assertTrue(searchPage().verifySearchCriteriaIsPresent("test"));

        // Object spContainter = homePage().navigateToMenuItem("Find Talent");
        // ((SearchPageContainer) spContainter).search().sendKeys("test");

        //assertTrue(loginPage().hasSearchCriteriaOnPage, "true");

        //assertTrue();
    }
}