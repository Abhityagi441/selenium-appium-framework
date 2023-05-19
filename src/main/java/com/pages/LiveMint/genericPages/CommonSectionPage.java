package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.SectionPage;
import com.pages.LiveMint.web.PoliticsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSectionPage {
    private static CommonSectionPage commonSectionPage;
    private static GlobalVars globalVars;

    public static CommonSectionPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSectionPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonSectionPage = new com.pages.LiveMint.web.SectionPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonSectionPage = new com.pages.LiveMint.android_amp.SectionPage();
                    break;
                case Constants.IOS_AMP:
                    commonSectionPage = new com.pages.LiveMint.ios_amp.SectionPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonSectionPage = new com.pages.LiveMint.android_mweb.SectionPage();
                    break;
                case Constants.IOS_WEB:
                    commonSectionPage = new com.pages.LiveMint.ios_mweb.SectionPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSectionPage = new com.pages.LiveMint.android_native.SectionPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSectionPage = new SectionPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSectionPage;
    }

    public abstract boolean checkAutoNewsPage(String[] params);

    public abstract boolean checkPodcastPage(String[] params);

    public abstract boolean checkBrandStoriesPage(String[] params);

    public abstract boolean checkBrandPostPage(String[] params);
    public abstract boolean checkQuickReadsPage(String[] params);

    public abstract boolean checkBudgetPage(String[] params);

    public abstract boolean checkLoungePage();

    public abstract boolean checkCompaniesSectionPage(String[] params);

    public abstract boolean checkEducationSectionPage(String[] params);

    public abstract boolean checkIndustrySectionPage(String[] params);

    public abstract boolean checkMarketSectionPage(String[] params);

    public abstract boolean checkTechnologySectionPage(String[] params);

    public abstract boolean checkSportsSectionPage(String[] params);

    public abstract boolean checkPoliticsSectionPage(String[] params);

    public abstract boolean checkInsuranceSectionPage(String[] params);

    public abstract boolean checkMoneySectionPage(String[] params);

    public abstract boolean checkMutualFundSectionPage(String[] params);

    public abstract boolean checkOpinionSectionPage(String[] params);

    public abstract boolean checkPhotosSectionPage(String[] params);

    public abstract boolean videoValidation();

    public abstract boolean checkSearchSectionPage(String serachText);


    public abstract boolean checkAppVersionDisplayed();
    public abstract void clickOnHomeAndExploreTab();

    public abstract boolean checkOpinionPageMastHead();

    public abstract boolean checkBankingSubSectionPage();

    public abstract boolean checkBankingPageTopNav();

    public abstract boolean checkIndustryPageParagraphShare();
}
