package com.pages.SmartCast.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.SmartCast.generic.CommonCategoriesPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesPage extends CommonCategoriesPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "(//button[@class='ng-binding'])[1]")
    private static WebElement dontAllow;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[4]")
    private static WebElement hamburgerCategories;
    @FindBy(xpath = "//div[@class='circle-image-wrap']/img")
    private static List<WebElement> allImagesInTray;
    @FindBy(xpath = "//h1[@class='blockHeading']")
    private static List<WebElement> categoriesPageTrays;
    @FindBy(xpath = "//div//span[@class='errorThumb']/img")
    private static WebElement error;
    @FindBy(xpath = "//div[@class='articleBlockNew_in']/a")
    private static List<WebElement> categoriesPageTrayList;
    @FindBy(xpath = "//h3[@class='heading']")
    private static List<WebElement> categoriesPageTrayListItems;


    public CategoriesPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        long t1=System.currentTimeMillis();
        commonFunctions.clickElementIfDisplayed(allow, 10,"enable-notifications");
        long t2=System.currentTimeMillis();
        System.out.println("Cookie time for "+globalVars.getProjectName()+" >> "+(t2-t1));
        System.out.println("****************** Test started for :"+globalVars.getProjectName());

    }


    @Override
    public boolean navigateToCategoriesPage() {
        boolean navigateToCategoriesPageStatus = false;
        try{
            navigateToCategoriesPageStatus=commonFunctions.navigateToSpecificPage(hamburgerCategories,30,"Categories Section");
            navigateToCategoriesPageStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return navigateToCategoriesPageStatus;
    }

    @Override
    public String getSmartCastTitle() {
        return commonFunctions.getTitle();
    }

    @Override
    public boolean checkCategoriesSection() {
        boolean checkCategoriesSectionStatus;
        boolean isCategoriesPageTraysAvailable = false;
        boolean checkedAllTraysWithPage=false;
        boolean checkAllImagesInTray =false;
        try{
            isCategoriesPageTraysAvailable=commonFunctions.checkNumberOfTraysInPage(categoriesPageTrays,error);
            checkAllImagesInTray=commonFunctions.checkAllImagesInElements(allImagesInTray,error,30);
            checkedAllTraysWithPage=commonFunctions.clickElementsListAndNavigateBack(categoriesPageTrayList,categoriesPageTrayListItems,30,"Category");
            commonFunctions.navigateToHomePageSC();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ( isCategoriesPageTraysAvailable && checkAllImagesInTray && checkedAllTraysWithPage) {
            checkCategoriesSectionStatus = true;
        } else {
            checkCategoriesSectionStatus = false;
        }
        return checkCategoriesSectionStatus;
    }

}