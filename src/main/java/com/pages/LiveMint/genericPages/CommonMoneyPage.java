package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.web.MoneyPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMoneyPage {
    private static CommonMoneyPage commonMoneyPage;
    private static GlobalVars globalVars;

    public static CommonMoneyPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars = GlobalVars.getInstance();

        if (commonMoneyPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonMoneyPage = new MoneyPage();
                    break;
                case Constants.IOS_WEB:
                    commonMoneyPage = new com.pages.LiveMint.ios_mweb.MoneyPage();
                    break;

                case Constants.ANDROID_WEB:
                    commonMoneyPage = new com.pages.LiveMint.android_mweb.MoneyPage();
                    break;

                case Constants.IOS_AMP:
                    commonMoneyPage = new com.pages.LiveMint.ios_amp.MoneyPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonMoneyPage = new com.pages.LiveMint.android_amp.MoneyPage();
                    break;
            }

        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonMoneyPage;
    }
    public abstract boolean checkMoneyPagelayout();
    public abstract boolean checklshMoneyPage();
    public abstract boolean checkTopNavLink();
    public abstract boolean checkrhsMoneyPage();
    public abstract boolean checMoneyPagelayoutSubscribedUSer();
    public abstract boolean checklshMoneyPageforSubscribedUser();
    public abstract boolean checkrHSNAVLinksforSubscribeduserMoney();
    public abstract boolean checkFirstStoryMoney();
    public abstract boolean checkFirstStoryMoneyforsubscribeusder();

}
