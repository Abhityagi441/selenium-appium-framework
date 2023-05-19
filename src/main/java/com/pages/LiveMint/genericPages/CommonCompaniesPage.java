package com.pages.LiveMint.genericPages;


import com.pages.LiveMint.web.CompaniesPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCompaniesPage {
    private static CommonCompaniesPage commonCompaniesPage;
    private static GlobalVars globalVars;

    public static CommonCompaniesPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCompaniesPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCompaniesPage = new CompaniesPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonCompaniesPage = new com.pages.LiveMint.android_mweb.CompaniesPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonCompaniesPage = new com.pages.LiveMint.android_amp.CompaniesPage();
                    break;
                case Constants.IOS_WEB:
                    commonCompaniesPage = new com.pages.LiveMint.ios_mweb.CompaniesPage();
                    break;
                case Constants.IOS_AMP:
                    commonCompaniesPage = new com.pages.LiveMint.ios_amp.CompaniesPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCompaniesPage;
    }

    public abstract boolean checkCompaniesPageTopNav(String amp);

    public abstract boolean checkCompaniesSection(String Link, String Amp);

    public abstract boolean checkOpenAppButton(String Amp);

    public abstract boolean checkOpenAppButtonInOpenStory(String Amp);

    public abstract boolean checkShareIconsCompanieStoryPage(String Amp);

    public abstract boolean checkCompaniesPageLayout(String Amp);

    public abstract boolean checkSummaryOnCompaniesStoryPage();

    public abstract boolean checkParagraphOnCompaniesStoryPage();

    public abstract boolean checkStartUpsSubSection();

    public abstract boolean checkStartUpsTopNav();
}


