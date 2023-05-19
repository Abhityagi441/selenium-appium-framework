package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.AdvertismentPage;
import com.pages.HindustanTimes.web.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonAdvertismentPage {
    private static CommonAdvertismentPage commonAdvertismentPage;
    private static GlobalVars globalVars;

    public static CommonAdvertismentPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonAdvertismentPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonAdvertismentPage= new AdvertismentPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonAdvertismentPage = new com.pages.HindustanTimes.android_amp.AdvertismentPage();
                    break;
                case Constants.IOS_AMP:
                    commonAdvertismentPage =new com.pages.HindustanTimes.ios_amp.AdvertismentPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonAdvertismentPage= new com.pages.HindustanTimes.android_mweb.AdvertismentPage();
                    break;
                case Constants.IOS_WEB:
                    commonAdvertismentPage= new com.pages.HindustanTimes.ios_mweb.AdvertismentPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonAdvertismentPage= new com.pages.HindustanTimes.android_native.AdvertismentPage();
                    break;
                case Constants.IOS_NATIVE:
                   commonAdvertismentPage= new com.pages.HindustanTimes.ios_native.AdvertismentPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonAdvertismentPage;
    }


    public abstract boolean checkAdDisplayingAfterEveryCollection();
    
    public abstract boolean checkAdDisplayingAfterCollection();
    
    public abstract boolean checkAdsDisplayInLineStory();

    public abstract boolean checkAdDisplayingHomePage();

    public abstract boolean checkAdsInlineStories();

    public abstract boolean checkAdsAreDisplayed();

    public abstract boolean checkAdDisplayingHomePageTopAd();

    public abstract boolean checkAdDisplayingAtEndOfFirstCollection();

    public abstract boolean checkAdDisplayWordCountAndAdRedirection();

    public abstract boolean checkHeaderAdsAreDisplayed();

    public abstract boolean checkHeaderAdisDisplayed();

    public abstract boolean checkHomePageRHSAdsAreDisplayed();

    public abstract boolean checkTopAdDisplayOnEverySection();
}
