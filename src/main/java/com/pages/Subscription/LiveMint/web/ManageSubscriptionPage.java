package com.pages.Subscription.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.Subscription.LiveMint.genericPages.CommonManageSubscriptionPage;
import com.utils.GlobalVars;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ManageSubscriptionPage extends CommonManageSubscriptionPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(css="#mint-only > label.shadowBox")
    private static List<WebElement> listofPlans;
    @FindBy(css="#mint-only > label.shadowBox.active , #mint-wsj > label.shadowBox.active")
    private static WebElement activePlanBox;
    // new UI
    @FindBy(css=".clearfix > .dPrice")
    private static WebElement currentPlanPrice;

    @FindBy(css="div.clearfix > .expiry")
    private static WebElement currentPlanExpiry;

    @FindBy(css="div.clearfix > .pName")
    private static WebElement currentPlan;


    public ManageSubscriptionPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        //globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
       // commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean getAllSubscriptionPlans() {

        return false;
    }

    @Override
    public WebElement getActiveSubscriptionPlan() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(activePlanBox));
        return activePlanBox;
    }

   @Override
    public String getPlanDuration(){
       return activePlanBox.findElement(By.xpath("./span[@class='planName']")).getText();
   }

   @Override
    public String getPlanPrice(){
       return activePlanBox.findElement(By.xpath(".//span[@class='disgPrice']")).getText();
   }

   @Override
   public void VerifyUserPlanAsPerAPI(String email){

       String uri= "https://stg-apigw.livemint.com/ss/api/v1/subscription/customer";
       RestAssured.useRelaxedHTTPSValidation();
       RequestSpecification httpRequest = RestAssured
               .given()
               .param("email",email)
               .headers("ProductId","134180000000006486");

       String json= httpRequest.get(uri).asString();
       //System.out.println(json);
       JsonPath jsonPath = new JsonPath(json);
       String planName= jsonPath.getString("subscriptions[0].plan.name");
       String planTotalPrince=jsonPath.getString("subscriptions[0].plan.total");
       String planPrince=jsonPath.getString("subscriptions[0].plan.price");
       String currency=jsonPath.getString("subscriptions[0].plan.currency_symbol");
       String nextBillingDate=jsonPath.getString("subscriptions[0].plan.next_billing_at");
       String expireDate=jsonPath.getString("subscriptions[0].plan.expires_at");

       System.out.println(planTotalPrince);
       System.out.println(planPrince);



    }

    @Override
    public String VerifyUserPlanAttributeAsPerAPI(String email, String attributeName){

        String uri= "https://stg-apigw.livemint.com/ss/api/v1/subscription/customer";
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification httpRequest = RestAssured
                .given()
                .param("email",email)
                .headers("ProductId","134180000000006486");

        String json= httpRequest.get(uri).asString();
        //System.out.println(json);
        JsonPath jsonPath = new JsonPath(json);
        String attributeValue= jsonPath.getString("subscriptions[0]."+attributeName);


         return attributeValue;

    }

    @Override
    public String getCurrentPlanPrice()
    {
        return commonFunctions.getElementText(currentPlanPrice,20);

    }

    @Override
    public String getCurrentPlanName()
    {
        return commonFunctions.getElementText(currentPlan,20);

    }

    @Override
    public String getCurrentPlanExpiry()
    {
        return commonFunctions.getElementText(currentPlanExpiry,20);

    }

}
