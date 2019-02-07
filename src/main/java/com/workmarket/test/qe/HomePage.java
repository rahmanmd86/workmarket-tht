package com.workmarket.test.qe;

import java.awt.Container;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath="//body[contains(@class, 'loggedin')]")
    private WebElement pageLoggedIn;

    public HomePage(WebDriver driver) {
        super(driver);
        waitForElement(pageLoggedIn);
    }

    public void navigateToMenuItem(String linkText) {
        String linkXPath = String.format("//a[contains(@role,'menuitem')]//div[contains(text(),'%s')]", linkText);
        driver.findElement(By.xpath(linkXPath)).click();
    }

    // public Object navigateToMenuItem(String linkText) {
    //     String linkXPath = String.format("//a[contains(@role,'menuitem')]//div[contains(text(),'%s')]", linkText);
    //     driver.findElement(By.xpath(linkXPath)).click();

    //     Object container = getContainer(linkText);
    //     return container;
    // }

    // private Object getContainer(String containerText) {
    //     Object container;
    //     switch (containerText) {
    //         case "Find Talent": 
    //             container = new SearchPageContainer(driver);
    //             break;
    //         //case "Assignments":
    //             //container = new AssignmentsPageContainer(driver);
    //             //break;
    //         default: 
    //             container = null; 
    //             break;
    //     }
    //     return container;
    // }
}