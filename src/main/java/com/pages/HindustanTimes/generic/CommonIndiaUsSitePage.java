package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.HamburgerPage;
import com.pages.HindustanTimes.web.IndiaUsSitePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonIndiaUsSitePage {
    private static CommonIndiaUsSitePage commonIndiaUsSitePage;
    private static GlobalVars globalVars;

    public static CommonIndiaUsSitePage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonIndiaUsSitePage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonIndiaUsSitePage= new IndiaUsSitePage();
                    break;
                case Constants.ANDROID_AMP:
                    commonIndiaUsSitePage= new com.pages.HindustanTimes.android_amp.IndiaUsSitePage();
                    break;
                case Constants.IOS_AMP:
                case Constants.ANDROID_WEB:
                    commonIndiaUsSitePage= new com.pages.HindustanTimes.android_mweb.IndiaUsSitePage();
                    break;
                case Constants.IOS_WEB:
                  //  commonHistoryPage= new com.pages.HindustanTimes.ios_mweb.BookmarkPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonIndiaUsSitePage= new com.pages.HindustanTimes.android_native.IndiaUsSitePage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonIndiaUsSitePage;
    }
    public abstract boolean clickOnExplorerMenu() throws Exception;

    public abstract boolean clickOnUsaOnTopHamburger() throws Exception;

    public abstract boolean checkUSPageDisplayed() throws Exception;

    public abstract boolean goToIndiaPageHamburgerMenu() throws Exception;

    public abstract boolean checkIndiaUsToggleWorking();
}
