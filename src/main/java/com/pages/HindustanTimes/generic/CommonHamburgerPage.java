package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.HamburgerPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHamburgerPage {
    private static CommonHamburgerPage commonHamburgerPage;
    private static GlobalVars globalVars;

    public static CommonHamburgerPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonHamburgerPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonHamburgerPage= new HamburgerPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonHamburgerPage= new com.pages.HindustanTimes.android_amp.HamburgerPage();
                    break;
                case Constants.IOS_AMP:
                    commonHamburgerPage= new com.pages.HindustanTimes.ios_amp.HamburgerPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonHamburgerPage= new com.pages.HindustanTimes.android_mweb.HamburgerPage();
                    break;
                case Constants.IOS_WEB:
                    commonHamburgerPage= new com.pages.HindustanTimes.ios_mweb.HamburgerPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonHamburgerPage= new com.pages.HindustanTimes.android_native.HamburgerPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonHamburgerPage= new com.pages.HindustanTimes.ios_native.HamburgerPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHamburgerPage;
    }

    public abstract boolean checkHamberburgerCases();


    public abstract boolean checkHamburgerElementsClickable();

    public abstract boolean clickOnExplorerMenu() throws Exception;

    public abstract boolean checkHamburgerMenuAllOptionDisplayed() throws Exception;

    public abstract boolean clickOnEntertainmentSection() throws Exception;

    public abstract boolean checkRedirectionToEntertainmentSection() throws Exception;

    public abstract boolean checkAnySectionPage();

    public abstract boolean checkIndiaNewsPageScrollable();

    public abstract boolean checkNavigationIndiaNews();

    public abstract boolean breadcrumbDisplayedOtherThanHomePage();

    public abstract boolean checkNavigationPopularNews();

    public abstract boolean checkNavigationCricketNews();

    public abstract boolean checkNavigationEditorialNews();

    public abstract boolean checkNavigationEntertainmentNews();

    public abstract boolean checkNavigationCitiesNews();

    public abstract boolean checkNavigationLatestNews();


    public abstract boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() throws Exception;

    public abstract boolean clickWorldNewsSectionOnHamburgerMenu();

    public abstract boolean checkExploreHTOptionDisplayedOnHamburgerMenu();

    public abstract boolean checkPopularSectionsDisplayed();

    public abstract boolean checkSectionsDisplayed();
}
