package com.pages.HT_AUTO.genericPages;


import com.pages.HT_AUTO.DesktopBrowserPages.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSectionAndSubSectionPage {
    private static CommonSectionAndSubSectionPage commonSectionAndSubSectionPage;
    private static GlobalVars globalVars;

    public static CommonSectionAndSubSectionPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSectionAndSubSectionPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
//                    commonSectionAndSubSectionPage = new LoginPage();
//                    break;
                case Constants.ANDROID_WEB:
                    commonSectionAndSubSectionPage = new com.pages.HT_AUTO.AndroidWebPages.SectionAndSubSectionPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSectionAndSubSectionPage;
    }

    public abstract boolean checkSectionAndSubSection(String hamburger, String notific, String autoN, String findC, String findB, String comC, String comB, String emi, String fastAg, String urlSubString);
}
