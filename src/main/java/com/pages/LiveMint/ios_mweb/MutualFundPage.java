package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.genericPages.CommonMutualFundPage;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MutualFundPage extends CommonMutualFundPage {

    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement MFWidgetHeader;

    @FindBy(xpath = "//div[contains(@class,'button-box ')]/a")
    private static List<WebElement> MFWidgetSliderCategories;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;

    @FindBy(xpath = "//div[contains(@class,'mutualFundData')][contains(@style,'block;')]//h2")
    private static List<WebElement> listingMFHeaders;

    @FindBy(xpath = "//div[contains(@class,'mutualFundData')][@style='display:block;']//li")
    private static List<WebElement> listingMFValuePlaceholder;

    @FindBy(xpath = "//div[@style='display:block;']/a[@class='fundTopHead']/p")
    private static List<WebElement> listingMFHeadersAssetsize;

    @FindBy(xpath = "((//div[@class='fundNavData'])[1]//p)")
    private static List<WebElement> rowHeaders;

    @FindBy(xpath = "//div[contains(@class,'swiper-button-next')][@role='button']")
    private static WebElement swiperNextButton;

    @FindBy(xpath="//div[@class='fundsInput']/select")
    private static WebElement dropdownBox;

    @FindBy(xpath="//div[@class='fundsInput']/select/option")
    private static List<WebElement> dropdownOptions;
    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement explore;
    @FindBy(xpath = "(//a[@href='/mutual-fund'])[2]")
    private static WebElement mutualFund;
    @FindBy(xpath = "(//div[@class='subnavArrow'])[5]")
    private static WebElement mutualFundExpand;
    @FindBy(xpath = "(//a[@href='/mutual-fund/mf-news'])[1]")
    private static WebElement mutualFundNews;
    @FindBy(xpath = "(//a[@id='getAppId'])[1]")
    private static WebElement getApp;
    @FindBy(css = "h1[class=listheading]")
    private static WebElement pageHeader;
    @FindBy(xpath = "//span[@class='blink']")
    private static WebElement offerText;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaper;
    @FindBy(xpath = "(//div[contains(@class,'icoSearch')])[2]")
    private static WebElement search;
    @FindBy(xpath = "//div[@id='offerMob']/a")
    private static WebElement subscribeNowCta;
    @FindBy(xpath = "(//div[contains(@class,'icoSearch')])[2]")
    private static WebElement searchSubsectionPage;



    public MutualFundPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkWidgetHeader(String header, String MFurl) {
        boolean isHeaderPresent;
        commonFunctions.navigateToURL(globalVars.getURL()+MFurl);
        commonFunctions.isElementDisplayed(mintLogo, 10, "mint logo");
        commonFunctions.isElementDisplayed(MFWidgetHeader, 10, "MF widget header");
        String MFheader = commonFunctions.getElementText(MFWidgetHeader, 10);
        isHeaderPresent = commonFunctions.checkTextEquals(header, MFheader, "Mutual Fund widget header");
        return isHeaderPresent;
    }

    @Override
    public boolean checkCategoriesInMFWidget(String header,String categories) {
        boolean iscategoryPresent = false;

        String[] category = categories.split(",");
        for (int i = 0; i < category.length; i++) {
            if(i>=3)
            {
                commonFunctions.scrollToElementView(swiperNextButton,10,"Swiper next button");
                commonFunctions.clickElementWithJS(swiperNextButton,10,"Swiper next button");
            }
            String actualCategory = commonFunctions.getElementText(MFWidgetSliderCategories.get(i), 10);
            String expectedCategory = category[i];
            iscategoryPresent = commonFunctions.checkTextEquals(expectedCategory, actualCategory, i + "th category in widget");
        }
        return iscategoryPresent;
    }

    @Override
    public boolean selectCategory(String category) {

        boolean isSelectedColor = false;
        boolean isSelectedBorderColor = false;
        for (int i = 0; i <= MFWidgetSliderCategories.size(); i++) {

            if (category.equalsIgnoreCase(commonFunctions.getElementText(MFWidgetSliderCategories.get(i), 10))) {
                commonFunctions.clickElementWithJS(MFWidgetSliderCategories.get(i), 10, "MF category");
                commonFunctions.isElementDisplayedIgnoringStaleElementReferenceException(MFWidgetSliderCategories.get(i),10,"MF category");
                commonFunctions.scrollToElementView(MFWidgetSliderCategories.get(i),10,"Selected Category of MF");
                isSelectedColor = commonFunctions.checkCSSProperty(MFWidgetSliderCategories.get(i), "color", "rgba(249, 157, 28, 1)", "Selcted MF Category color");
                isSelectedBorderColor = commonFunctions.checkCSSProperty(MFWidgetSliderCategories.get(i), "border-color", "rgb(249, 157, 28)", "Select MF category border color");
                break;
            }
        }
        return isSelectedColor && isSelectedBorderColor;
    }



    //to count listing and values palces
    @Override
    public boolean checkMFListingCountinWidget(String category) {

        boolean iscategoryPresent;
        int MFListedCount ;
        int MFValuescount ;
        iscategoryPresent = selectCategory(category);
        MFListedCount = listingMFHeaders.size();
        MFValuescount = listingMFValuePlaceholder.size();
        if (MFListedCount == 3 && MFValuescount == 21 && iscategoryPresent) {
            Utils.logStepInfo(true, "Mutual Fund count in list verified successfully");
            return true;

        } else {
            Utils.logStepInfo(false, "Mutual Fund count in list verification failed");
            return false;
        }
    }

    // to verify asset and keys in widget
    @Override
    public boolean checkAssetsizeFieldInMFWidget(String category, String key) {

        int assetCount = 0;
        boolean keyfound = false;
        selectCategory(category);
        for (int i = 0; i < listingMFHeadersAssetsize.size(); i++) {
            String actualKey = commonFunctions.getElementText(listingMFHeadersAssetsize.get(i), 10);
            assetCount=i;
            keyfound = commonFunctions.checkTextContains(key, actualKey, key + " in row:" + (i + 1) + " of widget");
        }
        if (keyfound) {
            Utils.logStepInfo(true, category+" Mutual Funds asset size field dispalyed suscessfully for " +(assetCount+1)+" rows");
            return true;
        } else {
            Utils.logStepInfo(false, "Mutual Funds asset size field display failed at "+assetCount+"th row");
            return false;
        }
    }

    // check nav / 1y 3y 4y 5y return
    @Override
    public boolean checkMFListingDataheaders(String category,String dataHeaders) {

        selectCategory(category);
        boolean rowHead = false;
        String[] dataHeader = dataHeaders.split(",");
        for (int i = 0; i < dataHeader.length; i++) {
            String expectedHead=commonFunctions.getElementText(rowHeaders.get(i));
            if (dataHeader[i].equalsIgnoreCase(expectedHead)) {
                rowHead = true;
                Utils.logStepInfo(true, "Row header found: " + expectedHead+"::"+dataHeader[i]);
            } else {
                Utils.logStepInfo(false, "Row head  not found: " + dataHeader[i]);
            }
        }
        return rowHead;
    }
// check dropdown box is present with MF options
    @Override
    public boolean checkDropdownHaveMFOptions(String category)
    {
        boolean dropdownDisplayed;
        boolean dropdownHaveOptions=false;
        dropdownDisplayed=commonFunctions.isElementDisplayed(dropdownBox,10,"MF dropdown box");
        if(dropdownOptions.size()>0)
        {
            dropdownHaveOptions=true;
            Utils.logStepInfo(true,"options found for MF category: "+category);
        }
        else{
            Utils.logStepInfo(false,"options not found for MF category: "+category);
        }
        if(dropdownDisplayed && dropdownHaveOptions)
        {
            return true;
        }
        else
        {
            Utils.logStepInfo(false,"Dropdown Verification failed, dropdown box is: "+dropdownDisplayed+" and dropdown have options is: "+dropdownHaveOptions);
            return false;
        }
    }

    //Validate MF listing is shown for selected MF category and option
    //Commented the in-progress code
    @Override
    public boolean checkMFListedDisplayedForSelectedMF(String category, String subCategory,String mfAPIUrl)
    {
        boolean listingCategoryVerified=false;
        /*int MFListedCount;
        String MFName;
       // commonFunctions.selectElement(dropdownBox,subCategory);

        commonFunctions.selecttextByJS(dropdownBox,dropdownOptions);
        commonFunctions.dummyWait(10);
        MFListedCount = listingMFHeaders.size();
        System.out.println(MFListedCount);
        for(int i=0;i<MFListedCount;i++)
        {
            MFName=commonFunctions.getElementText(listingMFHeaders.get(i),10);
            Response response = RestUtils.sendGetRequest(mfAPIUrl, "");
            String expectedMFName = RestUtils.getValueFromResponse(response, "$['"+category+"']['"+subCategory+"']["+i+"]['mfName']");
            listingCategoryVerified=commonFunctions.checkTextContains(expectedMFName,MFName,"Mutual fund name");
        }*/

        return listingCategoryVerified;
    }


    @Override
    public boolean checkMFSectionInHamburger(String Offer) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(mutualFund, 10, "Mutual Fund");
        isShowing &=commonFunctions.isElementDisplayed(pageHeader, 10, "Page Header");
        isShowing &=commonFunctions.checkElementText(offerText, Offer, 10, "Offer Text");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 10, "Get App");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &= commonFunctions.isElementClickable(search, 10, "Search");
        return isShowing;
    }


    @Override
    public boolean checkMFNewsSubSectionInHamburger(String Offer) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(mutualFundExpand, 10, "Mutual Fund Expand");
        commonFunctions.clickElementWithJS(mutualFundNews, 10, "MF News");
        isShowing &=commonFunctions.isElementDisplayed(pageHeader, 10, "Page Header");
        isShowing &=commonFunctions.checkElementText(offerText, Offer, 10, "Offer Text");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &= commonFunctions.isElementClickable(searchSubsectionPage, 10, "Search");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 10, "Get App");
        isShowing &= commonFunctions.isElementClickable(subscribeNowCta, 10, "Subscribe Now");
        return isShowing;
    }

}
