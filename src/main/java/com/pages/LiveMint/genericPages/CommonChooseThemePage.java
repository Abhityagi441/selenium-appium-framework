package com.pages.LiveMint.genericPages;

import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonChooseThemePage {
    private static CommonChooseThemePage commonChooseThemePage;
    private static GlobalVars globalVars;

    public static CommonChooseThemePage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars= GlobalVars.getInstance();
        if(commonChooseThemePage==null || !globalVars.getIsLastTestCasePass()){
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
                    commonChooseThemePage = new com.pages.LiveMint.android_native.ChooseThemePage();
                    break;
                case Constants.IOS_NATIVE:
//                    commonStoryPage= new com.pages.LiveMint.ios_native.LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonChooseThemePage;
    }

    public abstract boolean checkThemeChangesAtChooseWorks();


}
