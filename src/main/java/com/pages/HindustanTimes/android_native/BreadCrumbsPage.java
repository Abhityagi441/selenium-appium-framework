package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BreadCrumbsPage extends CommonBreadCrumbsPage {
	private static AndroidDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsMobile commonFunctions;

	@AndroidFindBy(id = "com.ht.news:id/tvSkip")
	private static MobileElement skipButton;

	public BreadCrumbsPage() {
		globalVars = GlobalVars.getInstance();
		driver = (AndroidDriver) globalVars.getAppiumDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		commonFunctions = CommonFunctionsMobile.getInstance();
		commonFunctions.clickElement(skipButton, 8);
		System.out.println("****************** Test started ******************");
		System.out.println("******************" +globalVars.getProjectName()  + "******************");

	}

	@Override
	public boolean checkNavigationIndiaNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationPopularNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationCricketNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationEditorialNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationEntertainmentNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationCitiesNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationLatestNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBreadcrumbVisible() {
		return false;
	}

	@Override
	public boolean checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(String googleUrl, String searchText) {
		return false;
	}

    @Override
    public boolean checkBreadcrumbVisibleViaGoogle() {
        return false;
    }

	@Override
	public boolean checkBreadcrumbAndClickRedirection() {
		return false;
	}

	@Override
	public boolean breadcrumbDisplayedOtherThanHomePage() {
		// TODO Auto-generated method stub
		return false;
	}
}
