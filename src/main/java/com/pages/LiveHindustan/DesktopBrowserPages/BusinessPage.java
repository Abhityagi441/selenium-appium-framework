package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonBusinessPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;


public class BusinessPage extends CommonBusinessPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "(//a[@title='बिजनेस'])[1]")
    private static WebElement businessPage;

    @FindBy(xpath = "//a[@title='IFSC Code']")
    private static WebElement ifscCodeLink;

    @FindBy(xpath = "//input[@id='txtIfscCode']")
    private static WebElement inputIfscCode;

    @FindBy(xpath = "//button[@id='btnIfscCode']")
    private static WebElement findAddress;

    @FindBy(xpath = "//div[@class='brd-crum']//a")
    private static List<WebElement> breadCrumb;

    @FindBy(xpath = "//div[@class='brd-crum']//span")
    private static WebElement ifscInBreadCrumb;

    @FindBy(xpath = "//section[@id='ifscContent']//div")
    private static List<WebElement> ifscContent;

    @FindBy(xpath = "//section[@id='ifscContent']//div")
    private static WebElement state;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(xpath = "//h1[@class='wdgt-hdng']/span[contains(text(), 'आईएफएससी कोड  खोजें')]")
    private static WebElement ifscCodeKhojeSection;

    @FindBy(id = "sel_ifsc_bank")
    private static WebElement ifscBankSelect;

    @FindBy(id = "sel_ifsc_state")
    private static WebElement ifscStateSelect;

    @FindBy(id = "sel_ifsc_district")
    private static WebElement ifscDistrictSelect;

    @FindBy(id = "sel_ifsc_branch")
    private static WebElement ifscBranchSelect;

    @FindBy(id = "ifsc_findnow")
    private static WebElement ifscFindNowButton;

    @FindBy(xpath = "(//section[@id='ifscContent']/div/label[2])[1]")
    private static WebElement returnIfscCode;

    @FindBy(xpath = "(//section[@id='ifscContent']/div/label[2])[9]")
    private static WebElement returnState;

    @FindBy(xpath = "//div[@class='brd-crum']/a")
    private static List<WebElement> brdcrumList;

    @FindBy(xpath = "//div[@class='brd-crum']/span[@class='brd-crum-last']")
    private static WebElement brdcrumIfscCode;

    private String bankOptionElement = "//Select[@id='sel_ifsc_bank']/option[text()= '%s']";
    private String stateOptionElement = "//Select[@id='sel_ifsc_state']/option[text()= '%s']";
    private String districtOptionElement = "//Select[@id='sel_ifsc_district']/option[text()= '%s']";
    private String branchOptionElement = "//Select[@id='sel_ifsc_branch']/option[text()= '%s']";





    public BusinessPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    @Override
    public boolean checkTheIFCSCodeSubMenuByEnteringTheIFSCCodeOnBusinessPage(String ifscCode) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(businessPage,10,"business page");
        commonFunctions.clickElementWithJS(businessPage,10,"business page");
        commonFunctions.moveToElementWithActions(ifscCodeLink,10,"ifsc code link");
        commonFunctions.clickElementWithJS(ifscCodeLink,10,"ifsc code link");
        commonFunctions.moveToElementWithActions(inputIfscCode,10,"ifsc code field");
        commonFunctions.sendKeys(inputIfscCode,ifscCode,10,"search ifsc");
        commonFunctions.clickElementWithJS(findAddress,10,"find address");
        commonFunctions.dummyWait(5);
        return checkIfscData();
    }

    @Override
    public boolean checkIFCSCodeSubMenuByEnteringLocationOnBusinessPage(String bankName, String stateName, String districtName, String branchName, String ifscCode){
        boolean ifscCodeStatus;
        boolean stateStatus;
        boolean brdcrumStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(businessPage,10,"business page");
        commonFunctions.clickElementWithJS(businessPage,10,"business page");
        commonFunctions.scrollToElement(ifscCodeLink,"ifsc code link");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(ifscCodeLink,10,"ifsc code link");
        commonFunctions.isElementDisplayed(ifscCodeKhojeSection,10,"Ifsc Code Khoje Section");
        commonFunctions.scrollToElement(ifscCodeKhojeSection,"Ifsc Code Khoje Section");
        commonFunctions.clickElementWithJS(ifscBankSelect,10,"ifsc BANK");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementIfDisplayed(String.format(bankOptionElement, bankName.trim()), 10);
        commonFunctions.scrollToElement(ifscCodeKhojeSection,"Ifsc Code Khoje Section");
        commonFunctions.clickElementWithJS(ifscStateSelect,10,"ifsc State");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementIfDisplayed(String.format(stateOptionElement, stateName.trim()), 10);
        commonFunctions.scrollToElement(ifscCodeKhojeSection,"Ifsc Code Khoje Section");
        commonFunctions.clickElementWithJS(ifscDistrictSelect,10,"ifsc District");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementIfDisplayed(String.format(districtOptionElement, districtName.trim()), 10);
        commonFunctions.scrollToElement(ifscCodeKhojeSection,"Ifsc Code Khoje Section");
        commonFunctions.clickElementWithJS(ifscBranchSelect,10,"ifsc branch");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementIfDisplayed(String.format(branchOptionElement, branchName.trim()), 10);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(ifscCodeKhojeSection,"Ifsc Code Khoje Section");
        commonFunctions.isElementDisplayed(ifscFindNowButton,10,"Ifsc Find Now Button");
        commonFunctions.clickElement(ifscFindNowButton,10,"Ifsc Find Now Button");
        commonFunctions.isElementDisplayed(returnIfscCode,10,"Ifsc Code");
        String actualIfscCode = commonFunctions.getElementText(returnIfscCode);
        ifscCodeStatus = actualIfscCode.trim().equalsIgnoreCase(ifscCode.trim());
        String actualState = commonFunctions.getElementText(returnState);
        stateStatus = actualState.trim().equalsIgnoreCase(stateName.trim());
        int brdcrumSize = brdcrumList.size();
        String brdcrumValue = "Hindi News,IFSC Code,"+bankName+","+stateName+","+districtName+","+branchName;
        brdcrumStatus = verifyBrdcrum(brdcrumList, brdcrumSize, brdcrumValue);
        brdcrumStatus &=commonFunctions.getElementText(brdcrumIfscCode).trim().equalsIgnoreCase(ifscCode.trim());
        return ifscCodeStatus && stateStatus && brdcrumStatus;
    }

    public boolean verifyBrdcrum(List<WebElement> webElementList, int size, String stringWithComma){
        boolean status = true;
        String[] ch = stringWithComma.split(",");
        for(int i=0;i<size;i++){
            String actualValue = commonFunctions.getElementText(webElementList.get(i));
            if(actualValue.trim().equalsIgnoreCase(ch[i].trim())){
                status &= true;
            }else{
                status &= false;
            }

            if(status == false){
                System.out.println("Brdcrum is not matching as expected:- "+ch[i].trim()+" but found:- "+actualValue.trim());
                Utils.logStepInfo("Brdcrum is not matching as expected:- "+ch[i].trim()+" but found:- "+actualValue.trim());
                break;
            }
        }
        return status;
    }

    public boolean checkIfscData(){
        int count =0;
        boolean ifscValues=false;
        String ifscInBrdCrumb=commonFunctions.getElementText(ifscInBreadCrumb,10).toUpperCase();
        List <String> breadCrumbList = new ArrayList<String>();
        breadCrumbList.add(ifscInBrdCrumb);
        for(int i=breadCrumb.size()-1;i>=3;i--){
            String breadCrumbValues=commonFunctions.getElementText(breadCrumb.get(i),10).toUpperCase();
            breadCrumbList.add(breadCrumbValues);
        }
        Map<String, String> breadCrumbCompareMap = new HashMap<String,String>();
        for(int i=ifscContent.size()-1;i>=0;i--) {
            String ifscData = commonFunctions.getElementText(ifscContent.get(i), 10);
            String[] ifscDataSplit =  ifscData.split("\n");
            breadCrumbCompareMap.put(ifscDataSplit[0],ifscDataSplit[1]);
        }
        for(Map.Entry ifscData : breadCrumbCompareMap.entrySet()){
            if (breadCrumbList.contains(ifscData.getValue()))
                count++;
        }
        if(count>=3){
            ifscValues=true;
        }
        return ifscValues;
    }
}