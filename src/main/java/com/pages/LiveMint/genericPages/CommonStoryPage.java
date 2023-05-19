package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.StoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonStoryPage {
    private static CommonStoryPage commonStoryPage;
    private static GlobalVars globalVars;

    public static CommonStoryPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars= GlobalVars.getInstance();
        if(commonStoryPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
//                    commonLoginPage= com.pages.LiveMint.AMPPages.LoginPage.getInstance();
                    break;
                case Constants.DESKTOP_WEB:
//                    commonStoryPage = new com.pages.LiveMint.web.LoginPage();
                    break;
                case Constants.ANDROID_AMP:
//                    commonStoryPage = new com.pages.LiveMint.android_amp.LoginPage();
                    break;
                case Constants.IOS_AMP:
//                    commonStoryPage = new com.pages.LiveMint.ios_amp.LoginPage();
                    break;
                case Constants.ANDROID_WEB:
//                    commonStoryPage = new com.pages.LiveMint.android_mweb.LoginPage();
                    break;
                case Constants.IOS_WEB:
//                    commonStoryPage = new com.pages.LiveMint.ios_mweb.LoginPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonStoryPage = new com.pages.LiveMint.android_native.StoryPage();
                    break;
                case Constants.IOS_NATIVE:
                   commonStoryPage= new StoryPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonStoryPage;
    }

    public abstract boolean mintPremiumWidget();
    public abstract boolean storyPageTextSizeSelection();
    public abstract boolean moreFromSectionWidget();
    public abstract boolean checkSimilarStoryWidget();
    public abstract boolean checkTextToSpeechNotPresent();
    public abstract boolean checkTextToSpeechPresent();
    public abstract boolean TextToSpeechFeatureNotPresentOnStoryWithPaywall();
}
