package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonListingPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ListingPage extends CommonListingPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;



    public ListingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElement(skipButton, 8);
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }


    @Override
    public boolean clickOnEntertainmentSection()  {
        return false;
    }

    @Override
    public boolean checkRedirectionToEntertainmentSection()  {
        return false;
    }

    @Override
    public boolean scrollDownToBottomOfTheEntertainmentPage() {
        return false;
    }

    @Override
    public boolean checkViewMoreButtonOnListingPages() {
        return false;
    }

    @Override
    public boolean clickAtNumber2PaginationOption()  {
        return false;
    }

    @Override
    public boolean checkRedirectionToTopOfThePage2OfSameSection() {
        return false;
    }

    @Override
    public boolean clickOnExplorerMenu() {
        return false;
    }
    
    @Override
    public boolean checkPaginationWorkingOnListingPages() {
        return false;
    }


	@Override
	public boolean checkViewMoreButton() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean scrollDownToBottomOfTheWorldNewsPage() {
        return false;
    }
}
