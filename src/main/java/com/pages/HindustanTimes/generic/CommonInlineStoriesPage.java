package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.InlineStoriesPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonInlineStoriesPage {
    private static CommonInlineStoriesPage commonInlineStoriesPage;
    private static GlobalVars globalVars;

    public static CommonInlineStoriesPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonInlineStoriesPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonInlineStoriesPage= new InlineStoriesPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonInlineStoriesPage= new com.pages.HindustanTimes.android_amp.InlineStoriesPage();
                    break;
                case Constants.IOS_AMP:
                    commonInlineStoriesPage= new com.pages.HindustanTimes.ios_amp.InlineStoriesPage();
                    break;
                case Constants.ANDROID_WEB:
                	commonInlineStoriesPage= new com.pages.HindustanTimes.android_mweb.InlineStoriesPage();
                    break;
                case Constants.IOS_WEB:
                    commonInlineStoriesPage= new com.pages.HindustanTimes.ios_mweb.InlineStoriesPage();
                    break;
                case Constants.ANDROID_NATIVE:
                   commonInlineStoriesPage= new com.pages.HindustanTimes.android_native.InlineStoriesPage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonInlineStoriesPage;
    }



    public abstract boolean checkInlineStoriesCases(String uri,String address);

    public abstract boolean checkInlineStoriesOpening();
}
