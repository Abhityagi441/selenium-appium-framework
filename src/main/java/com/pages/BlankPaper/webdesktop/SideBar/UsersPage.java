package com.pages.BlankPaper.webdesktop.SideBar;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonUsersPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends CommonUsersPage{
    private static CommonSectionPage sectionPage;

    private static DashboardPage dashboardPage;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public UsersPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        sectionPage= CommonSectionPage.getInstance();
    }
    @FindBy(xpath = "(//li[@id='usersLink'])[2]")
    private static WebElement usersButton;

    @FindBy(xpath = "//span[contains(@class,'tablinks')]")
    private static List<WebElement> allTabsInsideUserTab;

    @FindBy(xpath = "//div[contains(@class,'authorBio')]")
    private static List<WebElement> authorBioFields;

    @FindBy(xpath = "((//div[contains(@class,'authorBio')])//select)")
    private static List<WebElement> authorRoleSelect;


    @FindBy(xpath = "//div[contains(@class,'authorBio')]//input")
    private static List<WebElement> authorBioInputFields;

    @FindBy(xpath = "//div[contains(@class,'authorType')]//li//span")
    private static List<WebElement> authorType;


    @Override
    public boolean CheckIfUserIsAbleToClickOnUsersTabPresentInSidebar(String backgroundColor) {

        boolean isClicked=commonFunctions.clickElementWithJS(usersButton,10,"user tab");
        if(isClicked){
            return commonFunctions.getBackgroundColorOfWebElement(usersButton,10,"Users tab","background-color").equalsIgnoreCase(backgroundColor);
        }
        return false;
    }

    @Override
    public boolean CheckIfUserIsAbleToSeeFifteenHorizontalTabsOnTheUsersPage() {
        boolean isClicked=commonFunctions.clickElementWithJS(usersButton,10,"user tab");
        return isClicked && allTabsInsideUserTab.size()==15;
    }

    @Override
    public boolean CheckIfBackgroundColorShouldBecomeWhiteWhenUserClickOnAnyOfTheTab(String backgroundColor) {
        boolean isClicked=commonFunctions.clickElementWithJS(usersButton,10,"user tab");
        if(!isClicked) return false;
        boolean flag=false;
        for(int i=0;i<15;i++){
            commonFunctions.clickElement(allTabsInsideUserTab.get(i));
            flag=commonFunctions.getBackgroundColorOfWebElement(allTabsInsideUserTab.get(i),10,"tab background color","background-color").equalsIgnoreCase(backgroundColor);
        }
        return flag;
    }

    @Override
    public boolean CheckIfOutlineColorShouldBecomeBlueWhenUserClickOnAnyOfTheTab(String borderColor) {
        boolean isClicked=commonFunctions.clickElementWithJS(usersButton,10,"user tab");
        if(!isClicked) return false;
        boolean flag=false;
        for(int i=0;i<15;i++){
            commonFunctions.clickElement(allTabsInsideUserTab.get(i));
            flag=commonFunctions.getBorderColorOfWebElement(allTabsInsideUserTab.get(i),10,"tab background color","border").equalsIgnoreCase(borderColor);
        }
        return flag;
    }

    @Override
    public boolean CheckIfAllTheEightFieldShouldBePresentOnUsersPage() {
        boolean isClicked=commonFunctions.clickElementWithJS(usersButton,10,"user tab");
        if(!isClicked) return false;
        boolean flag=false;
        for(int i=0;i<authorBioFields.size();i++){
            flag=commonFunctions.isElementDisplayed(authorBioFields.get(i),10,"field"+(i+1));
        }
        flag=commonFunctions.isElementDisplayed(authorType.get(0),10,"author type");
        flag=commonFunctions.isElementDisplayed(authorType.get(1),10,"author type");
        return flag;
    }

    @Override
    public boolean CheckIfAllTheEightFieldsShouldBeClickable() {
        boolean flag=false;
        if(commonFunctions.clickElementWithJS(usersButton)){
            commonFunctions.isClickableElementClicked(authorRoleSelect.get(0),10,"role");
            commonFunctions.isClickableElementClicked(authorRoleSelect.get(1),10,"role");
            for(int i=0;i<authorBioInputFields.size();i++) flag=commonFunctions.isClickableElementClicked(authorBioInputFields.get(i),10,"field"+(i+1));
            flag=commonFunctions.clickElementWithJS(authorType.get(0),10,"check box one");
            flag=commonFunctions.clickElementWithJS(authorType.get(1),10,"check box two");
        }
        return flag;
    }

    @Override
    public boolean CheckIfUserIsAbleToSeeUsersTabPresentInSidebar() {
        return commonFunctions.isElementDisplayedWithExceptionHandling(usersButton,10,"Users tab");
    }
}
