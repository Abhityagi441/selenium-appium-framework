package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.BreadCrumbsPage;
import com.pages.HindustanTimes.web.IndiaUsSitePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBreadCrumbsPage {
    private static CommonBreadCrumbsPage commonBreadCrumbsPage;
    private static GlobalVars globalVars;

    public static CommonBreadCrumbsPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonBreadCrumbsPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonBreadCrumbsPage= new BreadCrumbsPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonBreadCrumbsPage= new com.pages.HindustanTimes.android_amp.BreadCrumbsPage();
                    break;
                case Constants.IOS_AMP:
                    commonBreadCrumbsPage= new com.pages.HindustanTimes.ios_amp.BreadCrumbsPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonBreadCrumbsPage= new com.pages.HindustanTimes.android_mweb.BreadCrumbsPage();
                    break;
                case Constants.IOS_WEB:
                    commonBreadCrumbsPage= new com.pages.HindustanTimes.ios_mweb.BreadCrumbsPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonBreadCrumbsPage= new com.pages.HindustanTimes.android_native.BreadCrumbsPage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonBreadCrumbsPage;
    }
    public  abstract boolean checkNavigationIndiaNews();
    public abstract boolean breadcrumbDisplayedOtherThanHomePage();
    public abstract boolean checkNavigationPopularNews();
    public abstract boolean checkNavigationCricketNews();
    public abstract boolean checkNavigationEditorialNews();
    public abstract boolean checkNavigationEntertainmentNews();
    public abstract boolean checkNavigationCitiesNews();
    public abstract boolean checkNavigationLatestNews();
    public abstract boolean checkBreadcrumbVisible();
    public abstract boolean checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(String googleUrl,String searchText);
    public abstract boolean checkBreadcrumbVisibleViaGoogle();

    public abstract boolean checkBreadcrumbAndClickRedirection();
}
