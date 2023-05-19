package com.pages.LiveMint.generic;

import com.pages.LiveMint.ios_native.SettingsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSettingsPage {
    private static CommonSettingsPage commonSettingsPage;
    private static GlobalVars globalVars;

    public static CommonSettingsPage getInstance() {
        System.out.println("******************* beforeMethod Setting Page starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSettingsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    break;
                case Constants.ANDROID_AMP:
                    break;
                case Constants.IOS_AMP:
                    break;
                case Constants.ANDROID_WEB:
                    break;
                case Constants.IOS_WEB:
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSettingsPage = new com.pages.LiveMint.android_native.SettingsPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSettingsPage = new SettingsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod Setting Page ends here *******************");
        return commonSettingsPage;
    }

    public abstract boolean checkNotificationToggle();
    public abstract boolean checkThemeSelector();
    public abstract boolean checkFontSelection();
    public abstract boolean checkFontSizeOption();

    public abstract boolean checkExploreSettingIconAndPage();
}
