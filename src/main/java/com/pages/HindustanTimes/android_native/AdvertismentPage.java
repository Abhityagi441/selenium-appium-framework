package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.View;
import java.util.List;

public class AdvertismentPage extends CommonAdvertismentPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @AndroidFindBy(className = "android.view.View")
    private static List<MobileElement> topAd;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ht.news:id/ad_view']")
    private static MobileElement footerAd;

    @AndroidFindBy(id = "com.ht.news:id/navigation_home_section")
    private static MobileElement homeButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc]")
    private static MobileElement hometabHeader;

    @AndroidFindBy(className = "android.view.View")
    private static List<MobileElement> firstAdAfterFiveStories;

    @AndroidFindBy(id="com.ht.news:id/titleTv")
    private static List<MobileElement> firstAdv;

    @AndroidFindBy(className="android.view.View")
    private static List<MobileElement> secondAdAfterThreeSections;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Latest Videos']")
    private static MobileElement secondAdv;

    @AndroidFindBy(className = "android.view.View")
    private static List<MobileElement> thirdAdAfterNextThreeSections;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lifestyle']")
    private static MobileElement thirdAdv;

    @AndroidFindBy(id="com.ht.news:id/adsContainerLayout")
    private static List<MobileElement> adsList;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.ht.news:id/imgViewThumbnail'])[1]")
    private static MobileElement leadImageInHomePage;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ht.news:id/ad_view_320_100']")
    private static MobileElement headerAd;

    @AndroidFindBy(id="com.ht.news:id/adIndicator")
    private static MobileElement sectionPageAd;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
    private static MobileElement indiaSection;

    @AndroidFindBy(id="com.ht.news:id/bt_continue")
    private static MobileElement gotItPopupInCityTab;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> listOfHeader;

    public AdvertismentPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        /*commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }

    public boolean checkHomePageLoadedProperly(){
        return commonFunctions.isElementDisplayed(headerAd,5,"HomePage Properly Loaded");
    }

    public boolean checkHomePageHeaderAdFooterAdLoadedAndVisible(){
        boolean headerAdStatus;
        headerAdStatus=commonFunctions.isElementDisplayed(headerAd,5,"Top Advertise");
        //footer ad is not available anymore
        //FooterAd=commonFunctions.isElementDisplayed(footerAd,60,"Footer Advertise");
        return headerAdStatus;
    }

    public boolean checkAdDisplayAfter5storiesInHomePage() {
        commonFunctions.scrollUpToElementDisplayed(firstAdv.get(2)); //should be get(4)::Will check during execution
        return commonFunctions.isElementDisplayed(firstAdAfterFiveStories.get(0),5,"First Adv after 5 stories");
    }

    public boolean checkAdDisplayAfter3CollectionsInHomePage() {
        commonFunctions.scrollTillVisibleText("Cricket","Latest Videos");
        return commonFunctions.isElementDisplayed(secondAdAfterThreeSections.get(1),5,"Second Adv after 3 collections");
    }

    public boolean checkThirdAdDisplayAfter3CollectionsInHomePage() {
//        commonFunctions.scrollUpToElementDisplayed(thirdAdv);
        commonFunctions.scrollTillVisibleText("HT Insight","Lifestyle");
        return commonFunctions.isElementDisplayed(thirdAdAfterNextThreeSections.get(2),5,"Third Adv after next 3 collection");
    }


    public boolean checkNoTwoAdsComeTogetherWhileBrowsing(){
        boolean isStepTrue=false;
        int size=adsList.size();
        if(size<=1)
        {
            Utils.logStepInfo(true, "No Two ads are together");
            isStepTrue=true;
        }
        return isStepTrue;
    }

  
    @Override
    public boolean checkAdsDisplayInLineStory() {
        return false;
    }

    @Override
    public boolean checkAdsInlineStories() {
        return false;
    }

    @Override
    public boolean checkAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingHomePageTopAd() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingAtEndOfFirstCollection() {
        return false;
    }

    @Override
    public boolean checkAdDisplayWordCountAndAdRedirection() {
        return false;
    }

    @Override
    public boolean checkHeaderAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkHeaderAdisDisplayed() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        commonFunctions.isElementDisplayed(hometabHeader, 5, "Header");
        boolean isHeaderAdDisplayed= commonFunctions.isElementDisplayed(headerAd, 5, "Header Ad");
        return isHeaderAdDisplayed;
    }

    @Override
    public boolean checkHomePageRHSAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkTopAdDisplayOnEverySection() {
        commonFunctions.clickElement(homeButton,5,"HT home button");
        boolean isTopAdDisplayed = false;
        for(int i=0; i<4; i++){
            commonFunctions.clickElement(listOfHeader.get(i),5,listOfHeader.get(i).getText()+" Section");
            isTopAdDisplayed = commonFunctions.isElementDisplayed(sectionPageAd,15,"Current page Top Ad");
            if (isTopAdDisplayed){
                break;
            }
        }
        return isTopAdDisplayed;
    }

    @Override
    public boolean checkAdDisplayingAfterEveryCollection() {
        return false;
    }

    @Override
	public boolean checkAdDisplayingAfterCollection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkAdDisplayingHomePage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,10);
        boolean homePageLoading=checkHomePageLoadedProperly();
        boolean HeaderFooterAds=checkHomePageHeaderAdFooterAdLoadedAndVisible();
        boolean firstAdv=checkAdDisplayAfter5storiesInHomePage();
        boolean secondAdv=checkAdDisplayAfter3CollectionsInHomePage();
        boolean thirdAdv=checkThirdAdDisplayAfter3CollectionsInHomePage();
        boolean noAdsTogether=checkNoTwoAdsComeTogetherWhileBrowsing();
//        commonFunctions.pressAndroidBackKey();
        return  homePageLoading && HeaderFooterAds && firstAdv && secondAdv && thirdAdv && noAdsTogether;
	}
}
