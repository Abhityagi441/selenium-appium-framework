package com.pages.HT_AUTO.genericPages;


import com.pages.HT_AUTO.DesktopBrowserPages.CarRoadPricePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCarRoadPricePage {
    private static CommonCarRoadPricePage commonCarRoadPricePage;
    private static GlobalVars globalVars;

    public static CommonCarRoadPricePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCarRoadPricePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCarRoadPricePage = new CarRoadPricePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCarRoadPricePage;
    }

    public abstract boolean checkCarRoadPriceWithCitySelection(String expectedCity, String expectedRoadPriceText);

    public abstract boolean checkCarRoadPriceWithCityFromList(String expectedCity, String expectedRoadPriceText);
}