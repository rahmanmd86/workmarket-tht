package com.workmarket.test.qe;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SearchPageContainer extends BasePage {

    @FindBy(xpath="//div[@id='cart']")
    private WebElement divCart;

    @FindBy(xpath="//h1[contains(text(),'Find Talent')]")
    private WebElement textFindTalent;

    @FindBy(xpath="//input[@id='input-text']")
    private WebElement inputSearch;

    @FindBy(xpath="//button[@id='clear_facets']")
    private WebElement buttonClearSearch;

    @FindBy(xpath="//div[contains(@data-value,'Keyword')]")
    private WebElement searchCriteria;

    @FindAll({@FindBy(xpath="//div[@class='profile-card']")})
    private List<WebElement> searchResults;

    @FindAll({@FindBy(xpath="//div[@class='profile-card--details']/h2/a")})
    private List<WebElement> profileCardNames;
    
    @FindAll({@FindBy(xpath="//div[@class='profile-card--details']/*[@class='profile-card--address']")})
    private List<WebElement> profileCardAddresses;

    @FindAll({@FindBy(xpath="//div[@class='profile-card--details']/*[@class='profile-card--tests']")})
    private List<WebElement> profileCardTests;

    public SearchPageContainer(WebDriver driver) {
        super(driver);
        waitForElement(textFindTalent);
    }

    public WebElement search() {
        return this.inputSearch;
    }

    public WebElement clearSearch() {
        return this.buttonClearSearch;
    }

	public boolean verifySearchCriteriaIsPresent(String criteria) throws InterruptedException {
        waitForElement(divCart);
        Thread.sleep(5000);

        boolean isDisplayed = searchCriteria.isDisplayed();

        //System.out.println(searchResults.size());
        WebElement profileCardName, profileCardAddress, profileCardTest;

        for(int i=0; i<searchResults.size(); i++) {

            profileCardName = profileCardNames.get(i);
            profileCardAddress = profileCardAddresses.get(i);
            profileCardTest = profileCardTests.get(i);

            // System.out.println(profileCardName.getText());
            // System.out.println(profileCardAddress.getText());
            // System.out.println(profileCardTest.getText());

            if(checkIfContainsText(profileCardName, criteria) || 
                checkIfContainsText(profileCardAddress, criteria) || 
                    checkIfContainsText(profileCardTest, criteria)) {
                        isDisplayed = true;
            }
            else {
                System.out.println(String.format("No match found for %s in profile card: %s, index", criteria, profileCardName.getText()));
                isDisplayed = false;
            }
        }
        
		return isDisplayed;
	}

    private boolean checkIfContainsText(WebElement element, String criteria) {

        boolean isPresent = false;

        if(element.isDisplayed()) {
            if(element.getText().toLowerCase().contains(criteria)) {
                isPresent = true;
            }
            else {
                isPresent = false;
            }
            
        }
            
        return isPresent;

    }

    //Profile search result : //div[@class='profile-card'] == 50
    //Profile card name : //div[@class='profile-card--details']/h2/a == 50
    //Profile card address > company : //div[@class='profile-card--details']/*[@class='profile-card--address']
    //Profile card tests: //div[@class='profile-card--details']/*[@class='profile-card--tests']


}