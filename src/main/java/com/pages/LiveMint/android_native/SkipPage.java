package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonSkipPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkipPage extends CommonSkipPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewThumbnailStory")
    private static MobileElement skipButton;
    @FindBy(xpath = "//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;


    public SkipPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(yesIAmButton, 5, "Yes I am in Popup");
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
    }


    @Override
    public boolean checkSkipPage() {
        boolean isSkipAvailable;
        isSkipAvailable=commonFunctions.clickElement(skipButton,10,"Skip button");
        return isSkipAvailable;
    }
}
