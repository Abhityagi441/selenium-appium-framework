package com.pages.Subscription.LiveMint.genericPages;


import com.pages.Subscription.LiveMint.web.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHomePage {
    public static CommonHomePage commonHomePage;
    private static GlobalVars globalVars;

    public static CommonHomePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");
        commonHomePage = null;
        globalVars = GlobalVars.getInstance();
        if (commonHomePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonHomePage = new HomePage();
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
        return commonHomePage;
    }

    public abstract boolean checkSignInLink();
    public abstract boolean checkSubscribeLink();
    public abstract boolean clickManageSubscriptionButtonMint();
    // mine----
    public abstract boolean clickManageSubscriptionButton();

    public abstract boolean checkMyAccountLink();

    public abstract boolean clickDenyPushnotification();

    public abstract String getPlanDetailsmyAccountPlanSection();

    public abstract void logout();

    public abstract String[] getMyAccountPlanDetails();

    public abstract void setNewPasswordText();

    public abstract void setConfirmPasswordTextField();

    public abstract void ClickContinueButtonToSetPass();
    public  abstract boolean clickSignInButton();

    public abstract boolean isMyAccountPresent();
}
