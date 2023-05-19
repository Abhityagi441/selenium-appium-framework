package com.pages.LiveMint.genericPages;

import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSkipPage {
    private static CommonSkipPage commonSkipPage;
    private static GlobalVars globalVars;

    public static CommonSkipPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars= GlobalVars.getInstance();
        if(commonSkipPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
//                    commonSkipPage= com.pages.LiveMint.AMPPages.LoginPage.getInstance();
                    break;
                case Constants.DESKTOP_WEB:
//                    commonSkipPage = new com.pages.LiveMint.web.SkipPage();
                    break;
                case Constants.ANDROID_AMP:
//                    commonSkipPage = new com.pages.LiveMint.android_amp.SkipPage();
                    break;
                case Constants.IOS_AMP:
//                    commonSkipPage = new com.pages.LiveMint.ios_amp.SkipPage();
                    break;
                case Constants.ANDROID_WEB:
//                    commonSkipPage = new com.pages.LiveMint.android_mweb.SkipPage();
                    break;
                case Constants.IOS_WEB:
//                    commonSkipPage = new com.pages.LiveMint.ios_mweb.SkipPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSkipPage = new com.pages.LiveMint.android_native.SkipPage();
                    break;
                case Constants.IOS_NATIVE:
//                    commonSkipPage= new com.pages.LiveMint.ios_native.SkipPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSkipPage;
    }

    public abstract boolean checkSkipPage();

}
