package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.android_native.MintLoungePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMintLoungePage {
    private static CommonMintLoungePage commonMintLoungePage;
    private static GlobalVars globalVars;

    public static CommonMintLoungePage getInstance() {
        System.out.println("******************* beforeMethod 'MintLounge Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonMintLoungePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonMintLoungePage = new MintLoungePage();
                    break;
                case Constants.IOS_NATIVE:
                    commonMintLoungePage = new com.pages.LiveMint.ios_native.MintLoungePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'MintLounge Page' ends here *******************");
        return commonMintLoungePage;
    }

public abstract boolean checkMintLoungeCarousel();
    public abstract boolean checkAllMintLoungeStoryCardSizeSame();
    public abstract boolean checkMintLoungeStoryCardDesign();
    public abstract boolean checkMintLoungeVewAllFunctionality();
    public abstract boolean checkMintLoungePageAndBackButtonByHomePage();
    public abstract boolean checkMintLoungePageAndBackButtonByExploreHamburger();
    public abstract boolean checkMintLoungeCarouselSlider();
    public abstract boolean checkMintLoungeListingPage();
    public abstract boolean checkBookmarkIcon();
    public abstract boolean checkNoBookmarkIconOnMintLoungeListingPage();
    public abstract boolean checkShareIconAllAvailableOptionOnMintLoungeListingPage();
    public abstract boolean checkAdsOnListingPage();
    public abstract boolean checkStoryDetailPage();
    public abstract boolean checkStoryDetailPageShareFunctionality();
    public abstract boolean checkStoryDetailPageFontSize();
}
