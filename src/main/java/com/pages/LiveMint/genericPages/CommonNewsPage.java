package com.pages.LiveMint.genericPages;


import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonNewsPage {
    private static CommonNewsPage commonNewsPage;
    private static GlobalVars globalVars;

    public static CommonNewsPage getInstance() {
        System.out.println("******************* beforeMethod 'News Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonNewsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonNewsPage = new com.pages.LiveMint.android_native.NewsPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonNewsPage = new com.pages.LiveMint.ios_native.NewsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'News Page' ends here *******************");
        return commonNewsPage;
    }
    public abstract boolean checkNewsSection();
    public abstract boolean checkNewsSectionPosition();
    public abstract boolean checkNewsSectionStoriesIsFree();


    public abstract boolean checkStoryFunctionalityTextToSpeech();

    public abstract boolean checkRecommendedForYouOnStoryDetailPage();

    public abstract boolean checkStoryDetailAllField();

    public abstract boolean checkStoryDetailSwipePopup();

    public abstract boolean checkStoryDetailHomePage();

    public abstract boolean checkStoryDetailPageAfterClickOnListingStory();

    public abstract boolean checkHorizontallySwipeForNextStory();
}
