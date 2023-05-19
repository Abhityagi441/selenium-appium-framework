package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.PremiumStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPremiumStoryPage {
    private static CommonPremiumStoryPage commonPremiumStoryPage;
    private static GlobalVars globalVars;

    public static CommonPremiumStoryPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars= GlobalVars.getInstance();
        if(commonPremiumStoryPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
//                    commonLoginPage= com.pages.LiveMint.AMPPages.LoginPage.getInstance();
                    break;
                case Constants.DESKTOP_WEB:
                   commonPremiumStoryPage = new com.pages.LiveMint.web.PremiumStoryPage();
                    break;
                case Constants.ANDROID_AMP:
                   commonPremiumStoryPage = new com.pages.LiveMint.android_amp.PremiumStoryPage();
                    break;
                case Constants.IOS_AMP:
                    commonPremiumStoryPage = new com.pages.LiveMint.ios_amp.PremiumStoryPage();
                    break;
                case Constants.ANDROID_WEB:
                   commonPremiumStoryPage = new com.pages.LiveMint.android_mweb.PremiumStoryPage();
                    break;
                case Constants.IOS_WEB:
                    commonPremiumStoryPage = new com.pages.LiveMint.ios_mweb.PremiumStoryPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonPremiumStoryPage=new com.pages.LiveMint.android_native.PremiumStoryPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonPremiumStoryPage= new PremiumStoryPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPremiumStoryPage;
    }

    public abstract boolean checkStory();

    public abstract boolean mintPremiumWidget(String email, String password, String mintPrimiumText);

    public abstract boolean storyPageTextSizeSelection();

    public abstract boolean moreFromSectionWidget();

    public abstract boolean checkAdsRemovedPremiumPage();

    public abstract boolean checkAdsPresentPremiumPage();

    public abstract boolean checkAdsRedirection();

    public abstract boolean checkPageSwitching(String email, String password, String premiumText);

    public abstract boolean checkNoPayWallToSubscribedUser(String email, String password);

    public abstract boolean mintPremiumWidgetListingStory();
    public abstract boolean subscribedUserAdsFreePremiumStoryDetailPage();
    public abstract boolean subscribedUserAdsFreePremiumListingPage();
    public abstract boolean nonSubscribedUserAdsFreePremiumListingPage();
    public abstract boolean checkBackButton();

    public abstract boolean checkPremiumPageSubNavTabs();

    public abstract boolean checkPremiumPageCompaniesSubNav();

    public abstract boolean checkPremiumPageTechnologySubNav();

    public abstract boolean checkPremiumPageMoneySubNav();

    public abstract boolean checkPremiumPageMarketsSubNav();

    public abstract boolean checkPremiumPageCompaniesDataLoad();

    public abstract boolean checkPremiumPageMutualFundsSubNav();

    public abstract boolean checkPremiumPageIndustrySubNav();


    public abstract boolean checkPremiumWidgetViewAll(String Heading, String Url, String AmpUrl);

    public abstract boolean checkPremiumPagePersonalFinanceSubNav();

    public abstract boolean checkPremiumPageAutoSubNav();

    public abstract boolean checkAdsNotPresentOnStoryDetailPage();

    public abstract boolean checkPremiumStickerPresentOnStoryDetailPage();

    public abstract boolean checkPremiumStickerDisappearOnStoryDetailPage();

    public abstract boolean checkPaywallForPremiumStories();

    public abstract boolean clickOnSignInFromPaywall();

    public abstract boolean checkPaywallAndAds();

    public abstract boolean checkNoPaywallAndAdsForSubscribedUser();

    public abstract boolean checkSignInFromFreemium();

    public abstract boolean checkNoPaywall();

    public abstract boolean checkSubscribedBtnNotDisplayedOnPaywall();
}
