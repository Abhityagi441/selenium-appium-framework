package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.OpenInAppPage;
import com.pages.HindustanTimes.web.StoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonOpenInAppPage {
    private static CommonOpenInAppPage commonOpenInAppPage;
    private static GlobalVars globalVars;

    public static CommonOpenInAppPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonOpenInAppPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonOpenInAppPage= new OpenInAppPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonOpenInAppPage= new com.pages.HindustanTimes.android_amp.OpenInAppPage();
                    break;
                case Constants.IOS_AMP:
                    commonOpenInAppPage= new com.pages.HindustanTimes.ios_amp.OpenInAppPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonOpenInAppPage= new com.pages.HindustanTimes.android_mweb.OpenInAppPage();
                    break;
                case Constants.IOS_WEB:
                    commonOpenInAppPage= new com.pages.HindustanTimes.ios_mweb.OpenInAppPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonOpenInAppPage= new com.pages.HindustanTimes.android_native.OpenInAppPage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonOpenInAppPage;
    }


    public abstract boolean checkRedirectionBetweenApp(String ampUrl,String mwebUrl,String appName);

    public abstract boolean checkOpenAppButton();

    public abstract boolean checkOpenAppButtonTop();

    public abstract boolean checkOpenAppButtonAfterEachStory();

    public abstract boolean checkOpenAppButtonRedirectsToAppStore();
}
