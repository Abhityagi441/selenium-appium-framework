package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.CarByTrendingPopularBudgetPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCarByTrendingPopularBudgetPage {
    private static CommonCarByTrendingPopularBudgetPage commonCarByTrendingPopularBudgetPage;
    private static GlobalVars globalVars;

    public static CommonCarByTrendingPopularBudgetPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCarByTrendingPopularBudgetPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCarByTrendingPopularBudgetPage = new CarByTrendingPopularBudgetPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCarByTrendingPopularBudgetPage;
    }

    public abstract boolean checkCarByTrendingPopularBudget(String expectedTrendingCarText);

}