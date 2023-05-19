package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.InlineStoriesPage;
import com.pages.HindustanTimes.web.SocialSharingPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSocialSharingPage {
    private static CommonSocialSharingPage commonSocialSharingPage;
    private static GlobalVars globalVars;

    public static CommonSocialSharingPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonSocialSharingPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonSocialSharingPage= new SocialSharingPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonSocialSharingPage= new com.pages.HindustanTimes.android_amp.SocialSharingPage();
                    break;
                case Constants.IOS_AMP:
                    commonSocialSharingPage= new com.pages.HindustanTimes.ios_amp.SocialSharingPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonSocialSharingPage= new com.pages.HindustanTimes.android_mweb.SocialSharingPage();
                    break;
                case Constants.IOS_WEB:
                   commonSocialSharingPage= new com.pages.HindustanTimes.ios_mweb.SocialSharingPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSocialSharingPage= new com.pages.HindustanTimes.android_native.SocialSharingPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSocialSharingPage= new com.pages.HindustanTimes.ios_native.SocialSharingPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSocialSharingPage;
    }



    public abstract boolean checkSocialSharingFunctionality();

    public abstract boolean checkSocialSharingWithWhatsappAndGmail();

    public abstract boolean socialSharingInStoryPage(String params[]);

    public abstract boolean checkSocialSharingIconsClickable();

    public abstract boolean checkTwitterWhatsappDisplayInStoryPageBySearch();

    public abstract boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics();

}
