
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonPhotosPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotosPage extends CommonPhotosPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static PhotosPage photoPage;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy (xpath = "//ul[@id='cohort_subnav']//a[text()='Photos']")
    private static WebElement photosOptionInL2;

    @FindBy(xpath = "//div[@class = 'large-txt']")
    private static WebElement noStoryFoundMessage;

    @FindBy(xpath = "//section[@id='dataHolder']/div[1]/div/h1")
    private static WebElement sectionHeading;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/figure/span/a/small")
    private static WebElement iconAndCountInPhoto;

    public static PhotosPage getInstance(){
        if(photoPage==null){
            photoPage= new PhotosPage();
        }
        return photoPage;
    }

    public PhotosPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean CheckCountInLeadImageInPhotosSection() {
        boolean isCountInFirstPhotoStory = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(photosOptionInL2,5,photosOptionInL2.getText());
        boolean isPhotoPageDisplayed = commonFunctions.getElementText(sectionHeading,5).equalsIgnoreCase("PHOTOS");
        boolean isNoStoryFound = !commonFunctions.isElementDisplayed(noStoryFoundMessage,3,"No Story Found Message");
        if (isPhotoPageDisplayed && isNoStoryFound){
            isCountInFirstPhotoStory &= commonFunctions.isElementDisplayed(iconAndCountInPhoto,5,"Count Icon in First Photo Story");
            String count = commonFunctions.getElementText(iconAndCountInPhoto,5);
            Utils.logStepInfo(true,"count = "+count);
            isCountInFirstPhotoStory &= !count.isEmpty();
        }
        else{
            Utils.logStepInfo(false, "Photos Section Page is not available or No photo Story available");
        }
        return isPhotoPageDisplayed && isCountInFirstPhotoStory;
    }

    @Override
    public boolean CheckFollowUsInPhotoStory() {
        return false;
    }

}
