package com.pages.HT_TECH.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_TECH.commonFunctions.CommonFunctionWebHT;
import com.pages.HT_TECH.generic.CommonPhotoPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PhotoPage extends CommonPhotoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionWebHT commonFunctionsHt;

    public static PhotoPage photoPage;
    public static PhotoPage getInstance(){
        if(photoPage==null){
            photoPage= new PhotoPage();
        }
        return photoPage;
    }
    @FindBy(xpath="//a[text()='PHOTOS']")
    private static WebElement photo;

    @FindBy(xpath="//nav[@class='pagination']")
    private static WebElement pagination;

    @FindBy(xpath = "//nav[@class='menuHeader']//a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath="//nav[@class='pagination']/a[text()='2']")
    private static WebElement page2;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a")
    private static List<WebElement> allTopStoriesLink;

    @FindBy(xpath="//div[@class='ltSide']/a[contains(@class,'firstArticle')]")
    private static WebElement photoPageMainTitles;

    @FindBy(xpath = "(//div[@class='article  photoPage'])[1]//h1")
    private static WebElement currentPageFirstHeading;


    @FindBy(xpath = "(//div[@id='entryArticle'])[1]//div[@class='zoomerModel']//following-sibling::figure[@class='clickPhotoPopup']")
    private static List<WebElement> firstPhotoStoryRelatedImages;

    @FindBy(id="imgId-3")
    private static WebElement img2;

 @Override
 public boolean checkPagination(){
     commonFunctions.navigateToURL(globalVars.getURL());
     commonFunctions.clickElement(photo);
     boolean isDirectedToPhotoPageIs = commonFunctions.getCurrentURL().contains("photos");
     commonFunctions.scrollToElement(pagination,"pagination section");
     JavascriptExecutor executor = (JavascriptExecutor) driver;
     executor.executeScript("arguments[0].scrollIntoView(true);", page2);
     boolean isClickOnPage2paginationSuccessful=commonFunctions.clickElementWithJS(page2, 10, "Page 2");
     String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
     boolean isRedirectionToPage2Successful = currentURL.equals(globalVars.getProdUrl() + "photos/?page=2");
     commonFunctions.navigateBack();
     return isDirectedToPhotoPageIs && isClickOnPage2paginationSuccessful && isRedirectionToPage2Successful;
 }

 @Override
 public boolean checkPhotosStories(){
     boolean isAllElementClickableTrue;
     commonFunctions.navigateToURL(globalVars.getURL());
     commonFunctions.clickElement(photo);
     int topStoriesSize = allTopStoriesLink.size();
     isAllElementClickableTrue =commonFunctionsHt.isElementClickableAndReturns200(allTopStoriesLink);
     return topStoriesSize == 10 && isAllElementClickableTrue;
 }

 @Override
 public boolean checkURLChange(){
     commonFunctions.navigateToURL(globalVars.getURL());
     commonFunctions.clickElement(photo);
     boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
     String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles, 10);
     commonFunctions.clickElement(photoPageMainTitles, 10, firstMainPhotoTextOfThePage);
     boolean isURLChangesWhileScrollingPhotosTrue = isURLChangesWhileScrollingPhotos();
     return isURLChangesWhileScrollingPhotosTrue && isLandingPageIsOfPhotos;
 }
    public boolean isURLChangesWhileScrollingPhotos() {
        boolean isURLChangesWhileScrollingPhotosTrue = true;
        String firstUrlText = commonFunctions.getCurrentURL();
        String nextUrlText;
        for (int i = 0; i < firstPhotoStoryRelatedImages.size(); i++) {
            if (i < firstPhotoStoryRelatedImages.size() - 1) {
                commonFunctions.dummyWait(2);
               commonFunctions.moveToElementToClick(firstPhotoStoryRelatedImages.get(i+1));
                commonFunctions.scrollToElement(firstPhotoStoryRelatedImages.get(i+1),"img1");
                commonFunctions.dummyWait(2);
                nextUrlText = commonFunctions.getCurrentURL();
                if (!commonFunctions.compareTexts(firstUrlText, nextUrlText)) {
                    isURLChangesWhileScrollingPhotosTrue &= true;
                } else {
                    isURLChangesWhileScrollingPhotosTrue &= false;
                }
                firstUrlText = nextUrlText;
            } else
                break;
        }
        return isURLChangesWhileScrollingPhotosTrue;
    }


    public PhotoPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt=CommonFunctionWebHT.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
}
