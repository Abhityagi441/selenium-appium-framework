package com.pages.HindustanTimes.generic;

import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonStandardStoryPage {
    private static CommonStandardStoryPage commonStandardStoryPage;
    private static GlobalVars globalVars;

    public static CommonStandardStoryPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonStandardStoryPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonStandardStoryPage = new com.pages.HindustanTimes.web.StandardStoryPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonStandardStoryPage;
    }

    public abstract boolean checkSectionPageOnDetailPage(String indiaNewsUrl);

    public abstract boolean checkTaboolaWidgets(String indiaNewsUrl);

    public abstract boolean checkAdsAfterFirstParagraph(String indiaNewsUrl);

    public abstract boolean checkFollowUsRedirection(String indiaNewsUrl, String followUsUrl);

    public abstract boolean checkLeadImageOfStory(String indiaNewsUrl);
}


