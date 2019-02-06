package com.workmarket.test.qe;

import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    protected static WebDriver driver;
    protected Faker faker;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        faker = new Faker();
        driver = new ChromeDriver();
    }

    public void navigateToSignUpPage() {
        String url = "https://dev.workmarket.com/register/campaign/10081C503B209A0C8E7F05FDCC1AA98D4C904DEEF5F73265CAE38C744E7EAD3E";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void navigateToLoginPage() {
        String url = "http://dev.workmarket.com/login";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public LandingPage landingPage() {
        return new LandingPage(driver);
    }

    public RegistrationLandingPage regLandingPage() {
        return new RegistrationLandingPage(driver);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}