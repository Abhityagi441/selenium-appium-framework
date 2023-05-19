package com.pages.HindustanTimes.android_mweb;

import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHistoryPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;

public class HistoryPage extends CommonHistoryPage {

	private static AndroidDriver<WebElement> driver;
	private static GlobalVars globalVars;
	private static ApiValidation apiValidation;
	private static CommonFunctionsMobile commonFunctions;
	private static CommonFunctionsWebHt commonFunctionsWeb;

	@FindBy(xpath = "(//h3[@class='hdg3'])[1]")
	private static WebElement firstStory;

	@FindBy(xpath = "//div[contains(@class,'myAccountPop')]/div[6]/a")
	private static WebElement myRead;

	@FindBy(xpath="(//div[contains(@class,'cartHolder bigCart')]//h3[@class='hdg3']/a)[1]")
	private static WebElement openFullStory;

	@FindBy(xpath = "(//div[@class='storyShortDetail'])[2]")
	private static WebElement topics;

	@FindBy(xpath = "//*[@id='content-div']/div[2]/h3/a")
	private static WebElement myReadsFirstHeadLine;

	@FindBy(className = "crossicon")
	private static WebElement closeHamburger;

	@FindBy(xpath = "//div[@class='btnExplore']")
	private static WebElement hamBurger;

	@FindBy(xpath = "//div[contains(@class,'userName')]")
	private static WebElement myAccountButton;

	@FindBy(xpath = "//span[@class = 'large-font']")
	private static WebElement pageNotFound404Error;

	@FindBy(xpath = "//section[@id='dataHolder']/div[3]/h3/a")
	private static MobileElement storyTitleInMyRead;

	public HistoryPage() {
		globalVars = GlobalVars.getInstance();
		driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		commonFunctions = CommonFunctionsMobile.getInstance();
		commonFunctionsWeb = CommonFunctionsWebHt.getInstance();
		apiValidation = ApiValidation.getInstance();
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
	}

	@Override
	public boolean checkMyReadsHasHistoryOfAllStoriesRead(String uri, String address) {
		return commonFunctionsWeb.verifyMyReadsHasHistory(uri, address, closeHamburger,openFullStory, hamBurger,
				myAccountButton, myRead, myReadsFirstHeadLine, storyTitleInMyRead);
	}
}
