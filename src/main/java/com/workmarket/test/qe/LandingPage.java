package com.workmarket.test.qe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(xpath="//*[@id='landing-page-bucket']//div[2]/div[1]/button[1]")
    private WebElement buttonJoinAsAnIndividual;

    @FindBy(xpath="//input[@id='firstname']")
    private WebElement inputFirstName;

    @FindBy(xpath="//input[@id='lastname']")
    private WebElement inputLastName;

    @FindBy(xpath="//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath="//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath="//input[@type='checkbox']")
    private WebElement inputCheckAgreement;

    @FindBy(xpath="//footer[@data-component-identifier='wm-validating-form__actions']//button[@type='button']")
    private WebElement buttonRegister;

    private WebElement errorMessage;

    public LandingPage(WebDriver driver) {
        super(driver);
        waitForElement(buttonJoinAsAnIndividual);
    }

    public WebElement joinAsAnIndividual() {
        return this.buttonJoinAsAnIndividual;
    }

    public WebElement firstName() {
        return this.inputFirstName;
    }

    public WebElement lastName() {
        return this.inputLastName;
    }

    public WebElement email() {
        return this.inputEmail;
    }

    public WebElement password() {
        return this.inputPassword;
    }

    public WebElement checkAgreement() {      
        return this.inputCheckAgreement;
    }

    public WebElement register() {
        return this.buttonRegister;
    }

    public void login(String firstName, String lastName, String email, String password, boolean checkAgreement) {


    }

    public WebElement getErrorMessage(String inputMissing) {
        String expath = String.format("//*[contains(text(),'%s')]", inputMissing);
        this.errorMessage = driver.findElement(By.xpath(expath));
        return this.errorMessage;
    }

    

    
}
