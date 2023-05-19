package com.pages.BlankPaper.webdesktop.stories;


import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonBannerPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BannerPage extends CommonBannerPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String bannerId;
    private static CommonDashboardPage dashboardPage;


    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(id = "createElementButton")
    private static WebElement elementButton;

    @FindBy(xpath = "//button[@id='createInputFormButton']/../following-sibling::li/button[@id='']")
    private static WebElement bannerButton;

    @FindBy(xpath = "//input[contains(@class, 'bannerName')]")
    private static WebElement bannerNameText;

    @FindBy(xpath = "//input[contains(@class, 'bannerUrl')]")
    private static WebElement landingUrlText;

    @FindBy(xpath = "//div[@class='imageInsert']")
    private static WebElement uploadFromFileButton;

    @FindBy(xpath = "//div[@class='imageLibrary']")
    private static WebElement uploadFromLibraryButton;

    @FindBy(id = "inputAddNameText")
    private static WebElement metaBannerNameText;

    @FindBy(id = "inputAddTagsText")
    private static WebElement metaBannerTagsText;

    @FindBy(id = "s_url")
    private static WebElement metaBannerExternalUrlText;

    @FindBy(id = "textAllChangesSaved")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//div[@class='imageLibrary']")
    private static WebElement imageLib;

    @FindBy(xpath = "(//div[@class='imagecontain']/img)[1]")
    private static WebElement imageLibList;

    @FindBy(xpath = "(//span[@class='hover']/button)[1]")
    private static WebElement useImageButton;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(id = "buttonCropingDone")
    private static WebElement doneButton;

    @FindBy(id = "buttonPublish")
    private static WebElement publishButton;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonPublishYes;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "//div[@class='searchtxt']/input")
    private static WebElement bannerSearchText;

    @FindBy(xpath = "//ul[contains(@class, 'listingul')]/a/li")
    private static List<WebElement> bannerSearchList;

    @FindBy(xpath = "//div[@class='dataField']/img")
    private static WebElement selectedImage;


    public BannerPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @Override
    public boolean checkInputFieldsShouldBeDisplayedForBanner(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        commonFunctions.isElementDisplayed(elementButton, 10, "Create Element Button");
        commonFunctions.clickElement(elementButton, 10, "Create Element Button");
        commonFunctions.isElementDisplayed(bannerButton, 10, "Create Banner Button");
        commonFunctions.clickElement(bannerButton, 10, "Create Banner Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.isElementPresentWithTryCatch(bannerNameText, 10) && commonFunctions.isElementPresentWithTryCatch(landingUrlText, 10) && commonFunctions.isElementPresentWithTryCatch(uploadFromFileButton, 10)  && commonFunctions.isElementPresentWithTryCatch(uploadFromLibraryButton, 10);
    }

    @Override
    public boolean checkUserShouldBeAbleToCreateBanner(String bannerName, String bannerLandingUrl, String metaBannerName, String metaTags, String metaExternalUrl){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        createBanner(bannerName, bannerLandingUrl, metaBannerName, metaTags, metaExternalUrl);
        return searchBanner(metaBannerName);
    }

    public boolean searchBanner(String metaBannerName){
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(bannerSearchText, 10, "Banner Search Text");
        commonFunctions.sendKeys(bannerSearchText, metaBannerName, 10, "Banner Search Text");
        commonFunctions.backSpace(bannerSearchText);
        commonFunctions.dummyWait(5);
        return commonFunctions.checkElementText(bannerSearchList.get(0), metaBannerName.trim(), 10, "Banner Data");
    }

    public boolean createBanner(String bannerName, String bannerLandingUrl, String metaBannerName, String metaTags, String metaExternalUrl){
        selectBannerElement();
        commonFunctions.isElementDisplayed(bannerNameText, 10, "Banner Name Text");
        commonFunctions.sendKeys(bannerNameText, bannerName, 10, "Banner Name Text");
        commonFunctions.isElementDisplayed(landingUrlText, 10, "Landing Url Text");
        commonFunctions.sendKeys(landingUrlText, bannerLandingUrl, 10, "Landing Url Text");
        selectLibImage();
        enterMetaForBanner(metaBannerName, metaTags, metaExternalUrl);
        getBannerId();
        commonFunctions.isElementDisplayed(publishButton, 10, "Publish Button");
        commonFunctions.clickElement(publishButton, 10, "Publish Button");
        if(commonFunctions.isElementPresentWithTryCatch(buttonPublishYes, 5)) {
            commonFunctions.clickElement(buttonPublishYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresent(popupPublishButton, 20);
    }

    public void enterMetaForBanner(String metaBannerName, String metaTags, String metaExternalUrl){
        commonFunctions.isElementDisplayed(metaBannerNameText, 10, "Meta Banner Name Text");
        commonFunctions.sendKeys(metaBannerNameText, metaBannerName, 10, "Meta Banner Name Text");
        commonFunctions.isElementDisplayed(metaBannerTagsText, 10, "Meta Banner Tags Text");
        commonFunctions.sendKeys(metaBannerTagsText, metaTags, 10, "Meta Banner Tags Text");
        commonFunctions.isElementDisplayed(metaBannerExternalUrlText, 10, "Meta Banner External Url Text");
        commonFunctions.sendKeys(metaBannerExternalUrlText, metaExternalUrl, 10, "Meta Banner External Url Text");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for saving changes ");
    }

    public void selectLibImage(){
        commonFunctions.isElementDisplayed(imageLib, 10, "Lib Image");
        commonFunctions.clickElement(imageLib, 10, "Lib Image");
        commonFunctions.isElementDisplayed(imageLibList, 10, "Lib Image List");
        commonFunctions.mouseHoverOnElement(imageLibList, 10, "Lib Image List");
        commonFunctions.isElementDisplayed(useImageButton, 10, "Use Image Button");
        commonFunctions.clickElement(useImageButton, 10, "Use Image Button");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 10)){
            commonFunctions.clickElementIfDisplayed(buttonYes, 5, "yes button");
        }
        commonFunctions.clickElement(doneButton, 10, "Done Button for lead Image");
        commonFunctions.isElementDisplayed(selectedImage, 10, "Selected Image");
    }

    public String getBannerId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        bannerId = id[id.length - 1];
        System.out.println("Banner ID:" + bannerId);
        return bannerId;
    }

    public void selectBannerElement(){
        commonFunctions.isElementDisplayed(elementButton, 10, "Create Element Button");
        commonFunctions.clickElement(elementButton, 10, "Create Element Button");
        commonFunctions.isElementDisplayed(bannerButton, 10, "Create Banner Button");
        commonFunctions.clickElement(bannerButton, 10, "Create Banner Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

}
