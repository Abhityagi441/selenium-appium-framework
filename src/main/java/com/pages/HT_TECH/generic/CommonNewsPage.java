package com.pages.HT_TECH.generic;

import com.pages.HT_TECH.web.HomePage;
import com.pages.HT_TECH.web.NewsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonNewsPage {
    private static CommonNewsPage commonNewsPage;
    private static GlobalVars globalVars;
    public static CommonNewsPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonNewsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {

                case Constants.DESKTOP_WEB:
                    commonNewsPage=new NewsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonNewsPage;
    }

public abstract boolean checkNavigationLatestNews();
    public abstract boolean checkTopStoriesWidget();
    public abstract boolean checkNewsPageRHSAdsAreDisplayed();

    public abstract boolean checkTrendingNewsHeadingOnClickingSearchBox();

    public abstract boolean searchAnyProductUsingValidKeyword(String keyword);
    public abstract boolean searchUsingSpecialKeyword(String keyword);

}
