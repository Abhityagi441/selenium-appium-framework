package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.web.WebStoriesPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonWebStoriesPage {
    private static CommonWebStoriesPage commonWebStoriesPage;
    private static GlobalVars globalVars;

    public static CommonWebStoriesPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonWebStoriesPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonWebStoriesPage = new WebStoriesPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonWebStoriesPage;
    }
    public abstract boolean checkWebStoriesLandingPage();
    public abstract boolean checkLHSOnWebStoriesLandingPage();
    public abstract boolean checkL1NavOnWebStoriesPage();
    public abstract boolean checkWebStoriesPageLayout();
}