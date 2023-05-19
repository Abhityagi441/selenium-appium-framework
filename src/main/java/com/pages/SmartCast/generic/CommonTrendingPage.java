package com.pages.SmartCast.generic;

import com.pages.SmartCast.web.TrendingPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonTrendingPage {
    private static CommonTrendingPage commonTrendingPage;
    private static GlobalVars globalVars;

    public static CommonTrendingPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonTrendingPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonTrendingPage= new TrendingPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonTrendingPage = new com.pages.SmartCast.AndroidWebPages.TrendingPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonTrendingPage;
    }
    public abstract boolean navigateToTrendingPage() ;
    public abstract String  getSmartCastTitle();
    public abstract boolean checkTrendingSection(String expectedTextForShows, String expectedTextForEpisodes) ;
}
