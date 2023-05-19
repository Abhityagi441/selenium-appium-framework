package com.pages.HT_AUTO.genericPages;


import com.pages.HT_AUTO.DesktopBrowserPages.HamburgerMenuAvailablePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHamburgerMenuAvailablePage {
    private static CommonHamburgerMenuAvailablePage commonHamburgerMenuAvailablePage;
    private static GlobalVars globalVars;

    public static CommonHamburgerMenuAvailablePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonHamburgerMenuAvailablePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonHamburgerMenuAvailablePage = new HamburgerMenuAvailablePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonHamburgerMenuAvailablePage = new com.pages.HT_AUTO.AndroidWebPages.HamburgerMenuAvailablePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHamburgerMenuAvailablePage;
    }

    public abstract boolean checkHamburgerMenuAvailablePage();
    public abstract boolean checkSearchPresent();
}