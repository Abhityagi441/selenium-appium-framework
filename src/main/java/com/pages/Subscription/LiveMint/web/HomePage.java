package com.pages.Subscription.LiveMint.web;

import com.base.DesktopBase;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.Subscription.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;


    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private static WebElement myAccount;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(css = "#deny")
    private static WebElement denyNotification;

    @FindBy(id = "uName")
    private static WebElement userEmailUsed;

    @FindBy(id = "pswfield")
    private static WebElement newPasswordTextField;

    @FindBy(id = "confpswfield")
    private static WebElement confirmPasswordTextField;

    @FindBy(xpath = "//*[text()='Subscribe Now']")
    private static WebElement subscribeNowbtn;


    @FindBy(xpath = "//*[@id=\"userPlanSec\"]")
    private static WebElement myAccountSubscriptionDetails;

    @FindBy(css = "#userPlanSec > span")
    private static WebElement myAccountNextBillingDate;

    @FindBy(css = "a.hideOnPhonePe:nth-child(5) , #userPlanMSSec > a")//(css="#userPlanSec > a")
    private static WebElement manageSubscriptionButton;

    @FindBy(css = "a.hideOnPhonePe:nth-child(3) , #userPlanMSSec > a")
    private static WebElement manageSubscriptionButtonMint;

    @FindBy(css = "#desktopBannerWrapped > div > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)")
    private static WebElement firstnotificationDontallow;


    @FindBy(id = "webpush-onsite")
    private static WebElement iframeNotification;

    @FindBy(id = "userPlanSec")
    private static WebElement myAccountPlanSection;

    @FindBy(css = "#myAccount > a.LinkCTANoArrow.hideOnPhonePe")
    private static WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"userPlanSec\"]")
    private static WebElement myAccountPlanDetails;


    @FindBy(id = "sbscribe")
    private static WebElement subscribebutton;

    @FindBy(css = "input#btSetPassword")
    private static WebElement continueButtonSetPass;

    @FindBy(css="a.userSignin")
    private static WebElement signInButton;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        clickDenyPushnotification();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean checkEmailIDUsedForLogin(String email) {
        boolean checkEmailIDUsedForLoginStatus;
        String actualEmail = commonFunctions.getElementText(userEmailUsed);
        actualEmail = actualEmail.replaceAll("TestAutomation", "").replaceAll("\n", "").trim();
        checkEmailIDUsedForLoginStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        return checkEmailIDUsedForLoginStatus;
    }


    @Override
    public boolean clickManageSubscriptionButton() {
        commonFunctions.clickElement(manageSubscriptionButton, 30);
        return false;
    }

    @Override
    public boolean clickManageSubscriptionButtonMint() {
        commonFunctions.clickElement(manageSubscriptionButtonMint, 30);
        return false;
    }

    @Override
    public boolean checkSignInLink() {
        return false;
    }

    @Override
    public boolean checkSubscribeLink() {
        // System.out.println("$$$$$$$$$$$$$$title =======  "+driver.getTitle());
        try {

            subscribeNowbtn.click();
            return true;
        } catch (Exception e) {
            System.out.println("Exception details " + e);
            return false;
        }


    }

    @Override
    public boolean checkMyAccountLink() {
        commonFunctions.clickElement(myAccount, 60);
        commonFunctions.isElementDisplayedIgnoringNoSuchElementException(myAccountSubscriptionDetails, 5, "myAccountSubscriptionDetails");
        System.out.println(myAccountSubscriptionDetails.getText());
        System.out.println(myAccountNextBillingDate.getText());
        return false;
    }


    @Override
    public boolean clickDenyPushnotification() {
        commonFunctions.clickElementIfDisplayed(firstnotificationDontallow, 10);
        commonFunctions.switchToFrame(iframeNotification, 5);
        commonFunctions.clickElementIfDisplayed(denyNotification, 5);
        commonFunctions.switchToDefaultContent();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //((JavascriptExecutor) driver).executeScript("document.getElementById('deny').click()");
        return true;
    }

    @Override
    public String getPlanDetailsmyAccountPlanSection() {
        return myAccountPlanSection.getText();
    }

    @Override
    public void logout() {
        boolean loggedIn = true;
        DesktopBase.navigateToHomePageUrl();
        try {
            commonFunctions.clickElement(myAccount, 30);
        } catch (Exception e) {
            loggedIn = false;

        }

        if (loggedIn) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logoutButton.click();
        }


    }

    @Override
    public String[] getMyAccountPlanDetails() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String planDetails = myAccountPlanDetails.getText();
        String planPrice = planDetails.substring(planDetails.indexOf(":") + 1, planDetails.indexOf("Valid")).trim();
        String planName = planDetails.substring(planDetails.indexOf("Plan") + 4, planDetails.indexOf(":")).trim();
        int spaceCount = 0;
        int startIndex = planName.length();
        for (int i = planName.length() - 1; i >= 0; i--) {
            startIndex--;
            if (planName.charAt(i) == ' ') {
                spaceCount++;
            }
            if (spaceCount == 2) {
                break;
            }
        }

        planName = planName.substring(startIndex).trim();
        String[] plan_details = new String[2];
        plan_details[0] = planPrice;
        plan_details[1] = planName;
        return plan_details;

    }


    @Override
    public void setNewPasswordText() {
        commonFunctions.sendKeys(newPasswordTextField, "TestPass@PO123", 50, "newPasswordTextField");
    }

    @Override
    public void setConfirmPasswordTextField() {
        commonFunctions.sendKeys(confirmPasswordTextField, "TestPass@PO123", 10, "newPasswordTextField");
    }

    @Override
    public void ClickContinueButtonToSetPass() {
        commonFunctions.scrollToElementViewAndClick(continueButtonSetPass, 5, "continueButtonSetPass");

    }

    @Override
    public boolean clickSignInButton(){
       commonFunctions.waitForElementToBeVisibleAndClickable(signInButton,30,"SigninButton");
      return commonFunctions.clickElement(signInButton,10,"SigninButton");
    }

    @Override
    public boolean isMyAccountPresent(){
       return commonFunctions.isElementDisplayed(myAccount,30);
    }

}
