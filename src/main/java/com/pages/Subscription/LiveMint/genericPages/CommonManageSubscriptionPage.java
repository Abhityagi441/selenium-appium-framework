package com.pages.Subscription.LiveMint.genericPages;

import com.pages.Subscription.LiveMint.web.ManageSubscriptionPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.openqa.selenium.WebElement;

public abstract class  CommonManageSubscriptionPage {

    private static CommonManageSubscriptionPage commonManageSubscriptionPage;
    private static GlobalVars globalVars;

    public static CommonManageSubscriptionPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");
        commonManageSubscriptionPage = null;
        globalVars = GlobalVars.getInstance();
        if (commonManageSubscriptionPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonManageSubscriptionPage = new ManageSubscriptionPage();
                    break;

                default:
                    try {
                        throw new Exception("Incorrect platform name or Platform does not exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonManageSubscriptionPage;
    }


    public abstract boolean getAllSubscriptionPlans();
    public abstract WebElement getActiveSubscriptionPlan();

    public abstract String getPlanDuration();

    public abstract String getPlanPrice();


    public abstract void VerifyUserPlanAsPerAPI(String email);

    public abstract String VerifyUserPlanAttributeAsPerAPI(String email, String attributeName);

    public abstract String getCurrentPlanPrice();

    public abstract String getCurrentPlanName();

    public abstract String getCurrentPlanExpiry();
}
