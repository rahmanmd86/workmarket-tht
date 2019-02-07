package com.workmarket.test.qe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath="//input[@id='login-email']")
    private WebElement inputLoginEmail;

    @FindBy(xpath="//input[@id='login-password']")
    private WebElement inputLoginPassword;

    @FindBy(xpath="//button[@id='login_page_button']")
    private WebElement buttonLogin;

    @FindBy(xpath="//input[@id='credentials__remember-me']")
    private WebElement inputRememberMe;

    @FindBy(xpath="//button[starts-with(text(),'I forgot')]")
    private WebElement buttonForgotPassword;

    @FindBy(xpath="//img[starts-with(@alt,'WorkMarket')]")
    private WebElement imageWorkMarketLogo;

    public LoginPage(WebDriver driver) {
        super(driver);
        waitForElement(this.imageWorkMarketLogo);
    }

    public void login(String email, String password) {
        this.inputLoginEmail.sendKeys(email);
        this.inputLoginPassword.sendKeys(password);
        this.buttonLogin.click();
    }
    
}