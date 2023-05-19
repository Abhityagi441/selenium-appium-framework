package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.SubscriptionPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSubscriptionPage {
    private static CommonSubscriptionPage commonSubscriptionPage;
    private static GlobalVars globalVars;

    public static CommonSubscriptionPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSubscriptionPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    break;
                case Constants.ANDROID_AMP:
                    break;
                case Constants.IOS_AMP:
                    break;
                case Constants.ANDROID_WEB:
                    break;
                case Constants.IOS_WEB:
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSubscriptionPage = new com.pages.LiveMint.android_native.SubscriptionPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSubscriptionPage = new SubscriptionPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSubscriptionPage;
    }

    public abstract boolean checkPlanPage();

    public abstract boolean checkSubscribeNavigation();

    public abstract boolean checkPlansVisible();

    public abstract boolean checkPremiumStoryPlansVisible();

    public abstract boolean checkSubscribeLink();

    public abstract boolean checkRemoveAd();

    public abstract boolean checkNonLoggedInUserStories();

    public abstract boolean checkSubscribedUserStories();

    public abstract boolean checkPlanVisibilityAndClickable();

    public abstract boolean checkSubscribedUserIsAdFree();

    public abstract boolean checkValidationOfSubscriptionsPlanDetails();
}