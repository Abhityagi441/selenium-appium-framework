package com.pages.LiveMint.genericPages;


import com.pages.LiveMint.web.PoliticsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPoliticsPage {
    private static CommonPoliticsPage commonPoliticsPage;
    private static GlobalVars globalVars;

    public static CommonPoliticsPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPoliticsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonPoliticsPage = new PoliticsPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonPoliticsPage = new com.pages.LiveMint.android_mweb.PoliticsPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonPoliticsPage = new com.pages.LiveMint.android_amp.PoliticsPage();
                    break;
                case Constants.IOS_WEB:
                    commonPoliticsPage = new com.pages.LiveMint.ios_mweb.PoliticsPage();
                    break;
                case Constants.IOS_AMP:
                    commonPoliticsPage = new com.pages.LiveMint.ios_amp.PoliticsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPoliticsPage;
    }


    public abstract boolean checkPoliticsPageLayout(String amp);

    public abstract boolean checkLHSMenuOnPoliticsPage();

    public abstract boolean checkRHSMenuOnPoliticsPage();

    public abstract boolean checkShareIconsPoliticsPage(String Amp);

    public abstract boolean checkParagraphOnPoliticsStoryPage();

    public abstract boolean checkSummaryOnPoliticsStoryPage();
}


