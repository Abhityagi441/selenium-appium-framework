package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.HomePage;
import com.pages.HindustanTimes.web.PhotosPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;

public abstract class CommonPhotosPage {
    private static CommonPhotosPage commonPhotosPage;
    private static GlobalVars globalVars;

    public static CommonPhotosPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPhotosPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonPhotosPage = new PhotosPage();
                    break;
                /*case Constants.ANDROID_AMP:
                    commonPhotosPage = new com.pages.HindustanTimes.android_amp.HomePage();
                    break;
                case Constants.IOS_AMP:
                    commonPhotosPage = new com.pages.HindustanTimes.ios_amp.HomePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonPhotosPage = new com.pages.HindustanTimes.android_mweb.HomePage();
                    break;
                case Constants.IOS_WEB:
                    commonPhotosPage = new com.pages.HindustanTimes.ios_mweb.HomePage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonPhotosPage = new com.pages.HindustanTimes.android_native.HomePage();
                    break;
                case Constants.IOS_NATIVE:
                    commonPhotosPage = new com.pages.HindustanTimes.ios_native.HomePage();
                    break;*/
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPhotosPage;
    }


    public abstract boolean CheckCountInLeadImageInPhotosSection();

    public abstract boolean CheckFollowUsInPhotoStory();
}
