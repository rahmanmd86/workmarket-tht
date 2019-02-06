package com.workmarket.test.qe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationLandingPage extends BasePage {

    @FindBy(xpath="//h2[contains(text(),'from CoName_6225')]")
    private WebElement textCoName_6225;

    public RegistrationLandingPage(WebDriver driver) {
        super(driver);
        waitForElement(textCoName_6225);
    }

    public WebElement successMessage() {
        return this.textCoName_6225;
    }

}