package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.android_native.ForYouPage;
import com.pages.LiveMint.android_native.NewsInNumberPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonNewsInNumberPage {
    private static CommonNewsInNumberPage commonForYouPage;
    private static GlobalVars globalVars;

    public static CommonNewsInNumberPage getInstance() {
        System.out.println("******************* beforeMethod 'NewsInNumber Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonForYouPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonForYouPage = new NewsInNumberPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonForYouPage = new com.pages.LiveMint.ios_native.NewsInNumberPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'NewsInNumber Page' ends here *******************");
        return commonForYouPage;
    }

    public abstract boolean checkNewsInNumberWidgetOnHomePage();

    public abstract boolean checkOnlyOneCardVisibleOnNewsInNumberListingPage();

    public abstract boolean checkThreeDotsAndBackFunctionalityOnNewsInNumberListingPage();

    public abstract boolean checkTitleAndSubTitleOnNewsInNumberListingPage();

    public abstract boolean checkDiffCardInfoOnWidgetNewsInNumber();

    public abstract boolean checkNewTagAndTitleOnWidgetNewsInNumber();

    public abstract boolean checkShareIconAndFunctionalityOnNewsInNumberListingPage();

    public abstract boolean checkLatestDataOnNewsInNumberWidget();

    public abstract boolean checkCardVisibilityOnNewsInNumberWidget();

    public abstract boolean checkViewAllFunctionality();

    public abstract boolean checkCardSwipeFunctionality();

    public abstract boolean checkReadFullStoryButtonAndFunctionality();

    public abstract boolean checkSwipeTextAtButton();
}
