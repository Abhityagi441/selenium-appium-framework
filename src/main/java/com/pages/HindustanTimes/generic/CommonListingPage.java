package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.ListingPage;
import com.pages.HindustanTimes.web.SearchPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonListingPage {
    private static CommonListingPage commonListingPage;
    private static GlobalVars globalVars;

    public static CommonListingPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonListingPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonListingPage= new ListingPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonListingPage= new com.pages.HindustanTimes.android_amp.ListingPage();
                    break;
                case Constants.IOS_AMP:
                    commonListingPage= new com.pages.HindustanTimes.ios_amp.ListingPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonListingPage= new com.pages.HindustanTimes.android_mweb.ListingPage();
                    break;
                case Constants.IOS_WEB:
                   commonListingPage= new com.pages.HindustanTimes.ios_mweb.ListingPage();
                    break;
                case Constants.ANDROID_NATIVE:
                   commonListingPage= new com.pages.HindustanTimes.android_native.ListingPage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonListingPage;
    }

    public abstract boolean clickOnEntertainmentSection();

    public abstract boolean checkRedirectionToEntertainmentSection();

    public abstract boolean scrollDownToBottomOfTheEntertainmentPage();

    public abstract boolean checkViewMoreButtonOnListingPages();

    public abstract boolean clickAtNumber2PaginationOption();

    public abstract boolean checkRedirectionToTopOfThePage2OfSameSection();

    public abstract boolean clickOnExplorerMenu();

    public abstract boolean checkPaginationWorkingOnListingPages();
    
    public abstract boolean checkViewMoreButton();

    public abstract boolean scrollDownToBottomOfTheWorldNewsPage();
}
