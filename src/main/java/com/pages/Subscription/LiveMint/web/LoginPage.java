package com.pages.Subscription.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.Subscription.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//*[@id=\"phoneNum\"]/input")
    private static WebElement emailTextBox;

    @FindBy(id="btSubmit")
    private static WebElement continueButton;

    @FindBy(id="loginPassword")
    private static WebElement passwordTextBox;

    @FindBy(id="btSubmit")
    private static WebElement loginButton;

    @FindBy(css="#header > div.container > div > aside > div.fr > a.userSignin")
    private static WebElement singInButton;

    @FindBy(css="#upass")
    private static WebElement passwordTextBox2;


    @FindBy(id="loginVerifyOtp")
    private static WebElement VerifyOTPButton;

    @FindBy(id ="login")
    private static WebElement yopMailEmailBox;

    @FindBy(css="#refreshbut > button")
    private static WebElement yopMailSearchButton;

    @FindBy(css="#mail tr:nth-child(5) td strong")
    private static WebElement getYopMailOTP;

    @FindBy(id="ifmail")
    private static WebElement yopMailOTPiFrame;

    @FindBy(css="#validateOtp  input[id^='otp']")
    private static List<WebElement> optinPutbox;


    @FindBy(css="#otpInputBox  input[id^='otp']")
    private static List<WebElement> optinPutboxLogin;

    @FindBy(css="input[id^='otp']")
    private static List<WebElement> getOptInPutBoxLogin2;

    @FindBy(id="verifyLoginOTP")
    private static WebElement verifyLoginOTPButton2 ;

    @FindBy(id="refresh")
    private static WebElement yopMailRefreshButton;

    @FindBy(id="generate_otp")
    private  static WebElement generateOTPButton;

    @FindBy(id="reGenOtpForgot")
    private  static WebElement reGenerateOTPButton;

    @FindBy(id="otp1")
    private  static WebElement firstOTPBox;

    @FindBy(id="lmSsoinput")
    private  static WebElement loginTextBox;

    @FindBy(xpath="//div [normalize-space()='Login/Register']")
    private  static WebElement loginPageText;

    @FindBy(id="skipDefault")
    private static WebElement doThisLaterBtn;

    @FindBy(css="a.facebook")
    private static WebElement facebookBtn;

    @FindBy(id="email")
    private static WebElement facebookEmailPhoneBox;

    @FindBy(id="loginbutton")
    private static WebElement facebookloginBtn;

    @FindBy(id="pass")
    private static WebElement facebookPasswordBox;

    @FindBy(css="div[aria-label='Continue as LM']")
    private static WebElement facebookContinue;






    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        //commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        return false;
    }


    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        emailTextBox.sendKeys(email);
        commonFunctions.clickElement(continueButton, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBox, password, 10, "Password text box");
        ( (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",loginButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonFunctions.clickElement(loginButton);

        return true;
    }

    @Override
    public boolean logout() {
          return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {

        return false;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkSignInLinkRedirection() {
        return false;
    }

    @Override
    public boolean loginWithNonSuscribedUser(String [] params) {
        return false;
    }

    @Override
    public boolean loginWithPassword(String[] params) {
        return false;
    }

    @Override
    public boolean verifyPlanDetails() {
        return false;
    }

    @Override
    public boolean loginWithSubscribedUser(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithNonSubscribedUser(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkSubscribedUserLogin(String email, String password, String expectedUserName) {
        return false;
    }


    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean checkMintLogoIsAlignedToCenter() {
       return false;
    }

    public boolean checkURLChangedToHTAccountsURL(String htAccountsURL) {
        boolean checkURLChangedToHTAccountsURLStatus;
        commonFunctions.waitForURLContains("Login");
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToHTAccountsURLStatus = commonFunctions.checkTextContains(htAccountsURL, actualURL, "HT accounts Login URL");
        return checkURLChangedToHTAccountsURLStatus;
    }

    public boolean checkEmailIDUsedForLogin(String email) {
          return false;
    }


    public void loginWithPasswordfromHomePage(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
         // commonFunctions.clickElement(mintLogo, 60, "mint Logo");
            commonFunctions.clickElement(singInButton, 60, "Sign In Button");
         //  boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
         commonFunctions.sendKeyBoolean(emailTextBox, email, 20, "Email/Phone Button");
       // emailTextBox.sendKeys(email);
        commonFunctions.clickElement(continueButton, 10, "Continue Button");
       // commonFunctions.sendKeyBoolean(passwordTextBox2, password, 10, "Password text box");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      // driver.findElement(By.cssSelector("#upass")).sendKeys(password);
        commonFunctions.sendKey(passwordTextBox2,password);
       driver.findElement(By.cssSelector("#btnLogin")).click();
       // ( (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",loginButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //commonFunctions.clickElement(loginButton);


    }
    @Override
    public void signupWithOTP(String email) {
        //commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        //  boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        String yopMailHandle= "";
        commonFunctions.sendKeyBoolean(emailTextBox, email+"@yopmail.com", 10, "Email/Phone Button");
        // emailTextBox.sendKeys(email);
        commonFunctions.clickElement(continueButton, 10, "Continue Button");
        // commonFunctions.sendKeyBoolean(passwordTextBox2, password, 10, "Password text box");

        String mainWindow = driver.getWindowHandle();
        commonFunctions.newTabWithUrl("https://yopmail.com/");
        Set<String> set = commonFunctions.getWindowHandles(2);
        for (String s : set) {
            if (!s.equals(mainWindow))
                //  commonFunctions.switchToWindow();
                driver.switchTo().window(s);
                yopMailHandle=s;
        }

        commonFunctions.sendKey(yopMailEmailBox, email, 10);
        commonFunctions.clickElement(yopMailSearchButton, 5);
        commonFunctions.switchToFrame(yopMailOTPiFrame, 10);
        for(int i=0;i<16;i++){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonFunctions.switchToDefaultContent();
        commonFunctions.clickElement(yopMailRefreshButton,2);
        commonFunctions.switchToFrame(yopMailOTPiFrame, 2);

            try{
                if(commonFunctions.isElementDisplayed(getYopMailOTP,3))
                {break;}}
            catch (Exception e){

                if(i==15){
                    commonFunctions.switchToWindow(mainWindow);
                    commonFunctions.clickElement(reGenerateOTPButton,2);
                    commonFunctions.switchToWindow(yopMailHandle);

                }
            }
        }

        String OTP = commonFunctions.getElementText(getYopMailOTP, 10);
        commonFunctions.switchToDefaultContent();
        System.out.println(OTP);
        driver.close();
        commonFunctions.switchToWindow(mainWindow);
        int otpCounter=0;
        for (WebElement otpBox : optinPutbox)
        {


            commonFunctions.sendKeys(otpBox,OTP.charAt(otpCounter++)+"",10,"otpInputbox");


        }

        commonFunctions.clickElement(VerifyOTPButton,5);
        // ( (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",loginButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void clickgenerateOTP(){

        commonFunctions.clickElement(generateOTPButton,10);
    }

   public  void clickReGenerateOTPButton(){

       commonFunctions.clickElement(reGenerateOTPButton,10);
   }

   @Override
   public  void signinUsingOTP(String email){
        String yopMailHandle="";
       commonFunctions.clickElement(singInButton, 60, "Sign In Button");
       commonFunctions.sendKeyBoolean(emailTextBox, email+"@yopmail.com", 10, "Email/Phone Button");
       commonFunctions.clickElement(continueButton, 10, "Continue Button");
       clickgenerateOTP();
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       String mainWindow = driver.getWindowHandle();
       commonFunctions.newTabWithUrl("https://yopmail.com/");
       Set<String> set = commonFunctions.getWindowHandles(2);
       for (String s : set) {
           if (!s.equals(mainWindow))

               driver.switchTo().window(s);
               yopMailHandle=s;
       }
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       //commonFunctions.waitForElementToBeVisibleAndClickable(yopMailEmailBox,10,"yopmail search textbox");
       WebDriverWait wait;
       wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(yopMailEmailBox));
       yopMailEmailBox.clear();
       commonFunctions.clearText(yopMailEmailBox);

       commonFunctions.sendKey(yopMailEmailBox, email, 10);
       commonFunctions.clickElement(yopMailSearchButton, 5);
       commonFunctions.switchToFrame(yopMailOTPiFrame, 10);
       for(int i=0;i<11;i++){
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           commonFunctions.switchToDefaultContent();
           commonFunctions.clickElement(yopMailRefreshButton,5);
           commonFunctions.switchToFrame(yopMailOTPiFrame, 2);
           try{
           if(commonFunctions.isElementDisplayed(getYopMailOTP,3))
           {break;}}
           catch (Exception e){

               if(i==8){
                   commonFunctions.switchToWindow(mainWindow);
                   commonFunctions.clickElement(reGenerateOTPButton,2);
                   commonFunctions.switchToWindow(yopMailHandle);

               }
           }
       }

       String OTP = commonFunctions.getElementText(getYopMailOTP, 10);
       commonFunctions.switchToDefaultContent();
       System.out.println(OTP);
       commonFunctions.switchToWindow(mainWindow);
       int otpCounter=0;
       for (WebElement otpBox : optinPutboxLogin)
       {


           commonFunctions.sendKeys(otpBox,OTP.charAt(otpCounter++)+"",10,"otpInputbox");


       }

       commonFunctions.clickElement(verifyLoginOTPButton2,5);
       // ( (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",loginButton);
       try {
           Thread.sleep(500);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   }
@Override
   public void SignupUsingAPI(String email){
      email=email+"@yopmail.com";
      String uri= "http://10.136.172.234:8080/v2/signUp";
       RequestSpecification httpRequest = RestAssured
               .given()
               .headers("Content-Type","application/json");


       httpRequest.body("{\"name\": \"TestName\",\"email\": \""+email+"\",\"source\": \"S\",\"referrer\": \"LM\",\"repeatPassword\": \"TestLM@123\",\"password\": \"TestLM@123\",\"type\": \"web\",\"os\": \"windows\",\"newsletterConsent\": \"true\"}").post(uri);

    }


    @Override
    public  void signUpUsingOTPAPI(String email)

    {
        String yopMailHandle="";
        //commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBox, email, 10, "Email/Phone Button");
        commonFunctions.clickElement(continueButton, 10, "Continue Button");
        //clickgenerateOTP();
        WebDriverWait wait =new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(firstOTPBox));
        String uri="http://10.136.172.230:8080/v2/generatedOtp"; //"https://accounts.hindustantimes.com/v2/generatedOtp";
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification httpRequest = RestAssured
                .given()
                .param("identifier",email);
        // .headers("Accept","*/*","Accept-Encoding","gzip, deflate, br","Connection","keep-alive");

        String json= httpRequest.get(uri).asString();

        System.out.println(json);
        JsonPath jsonPath = new JsonPath(json);
        String OTP= jsonPath.getString("data");
      int otpCounter=0;
        for (WebElement otpBox : optinPutbox)
        {


            commonFunctions.sendKeys(otpBox,OTP.charAt(otpCounter++)+"",10,"otpInputbox");


        }

        try {
            commonFunctions.clickElement(VerifyOTPButton, 5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        // ( (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",loginButton);
       /* try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



    }

    @Override
    public String fetchOTP(String email, String OtpAPI ,String accessAccount)
    {
        String uri= OtpAPI;
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification httpRequest = RestAssured
                .given()
                .param("identifier",email)
                .headers("accessAccount",accessAccount);

        String json= httpRequest.get(uri).asString();

        System.out.println(json);
        JsonPath jsonPath = new JsonPath(json);
        String OTP= jsonPath.getString("data");
        return OTP;

    }


    @Override
    public boolean enterLoginTextBox(String email){
         try{
         commonFunctions.sendKeysOnElementVisibility(loginTextBox,email,30,"loginTextBox");
         return true;
         }
         catch(Exception e)
         {return false;}
    }

    @Override
    public boolean clickContinueButton()
    {
      return  commonFunctions.clickElement(continueButton,10);
    }

     @Override
     public boolean enterOTP(String OTP)
     {
         int otpCounter=0;
         try{
         for (WebElement otpBox : getOptInPutBoxLogin2)
         {
             commonFunctions.sendKey(otpBox,OTP.charAt(otpCounter++)+"",10);
         }
         return true;
         }
         catch(Exception e)
         {
             return false;
         }
     }

     @Override
     public boolean isLoginPageTextPresent()
     {
       return  commonFunctions.isElementDisplayed(loginPageText,30);
     }

     @Override
     public boolean isOTPBox1Present(){
         return  commonFunctions.isElementDisplayed(firstOTPBox,30);
     }

     @Override
     public void refreshOtpLimit(String email, String OtpRefreshAPI ,String accessAccount)
     {
       try{
         String uri= OtpRefreshAPI;
         RestAssured.useRelaxedHTTPSValidation();
         RequestSpecification httpRequest = RestAssured
                 .given()
                 .param("identifier",email)
                 .headers("accessAccount",accessAccount);
           String json= httpRequest.get(uri).asString();

       }

       catch(Exception e){

       }

     }

     @Override
     public boolean clickDoThisLater()
     {
         commonFunctions.waitForElementToBeVisibleAndClickable(doThisLaterBtn,30,"doThisLaterBtn");
         return commonFunctions.clickElement(doThisLaterBtn);
     }

    @Override
    public boolean enterOTPwithRefresh(String email, String otpRefreshAPI, String otpAPI, String accessAccount) {
       try{
        refreshOtpLimit(email,otpRefreshAPI,accessAccount);
        String Otp= fetchOTP(email, otpAPI,accessAccount);
        enterOTP(Otp);
        return true;}
       catch(Exception e)
       {
           return false;
       }
    }

    @Override
    public boolean fetchOTPandType(String email, String OtpAPI ,String accessAccount)
    {
        try{
       String otp= fetchOTP(email,OtpAPI,accessAccount);
       enterOTP(otp);
        return true;
        }

        catch(Exception e){
            return false;
        }


    }

    @Override
    public boolean facebookLogin(String emailOrPhone , String password )
    {
        try{
        String mainWindow= commonFunctions.getWindowHandle();
        commonFunctions.clickElement(facebookBtn,10,"faceBookButton");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> allWindows= commonFunctions.getWindowHandles();
        for(String w : allWindows)
        {
            if(!mainWindow.equalsIgnoreCase(w))
            {
                commonFunctions.switchToWindow(w);
                break;
            }
        }

        commonFunctions.sendKey(facebookEmailPhoneBox,emailOrPhone);
        commonFunctions.sendKey(facebookPasswordBox,password);
        commonFunctions.clickElement(facebookloginBtn,5);
        try{
        commonFunctions.clickElement(facebookContinue,10);}
        catch(Exception e){}
        commonFunctions.switchToWindow(mainWindow);
        return true;}
        catch (Exception e)
        {return false;}
    }


}
