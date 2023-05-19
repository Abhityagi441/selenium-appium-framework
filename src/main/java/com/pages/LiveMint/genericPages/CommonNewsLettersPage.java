package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.NewsLettersPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.openqa.selenium.WebElement;

public abstract class CommonNewsLettersPage {
    private static CommonNewsLettersPage commonNewsLettersPage;
    private static GlobalVars globalVars;

    public static CommonNewsLettersPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonNewsLettersPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.IOS_NATIVE:
                    commonNewsLettersPage = new NewsLettersPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonNewsLettersPage = new com.pages.LiveMint.android_native.NewsLettersPage();
                    break;

                case Constants.DESKTOP_WEB:
                    commonNewsLettersPage = new com.pages.LiveMint.web.NewsLettersPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonNewsLettersPage = new com.pages.LiveMint.android_mweb.NewsLettersPage();
                    break;
                case Constants.IOS_WEB:
                    commonNewsLettersPage = new com.pages.LiveMint.ios_mweb.NewsLettersPage();
                    break;

            }
        }

        System.out.println("******************* beforeMethod ends here *******************");
        return commonNewsLettersPage;
    }

    public abstract boolean checkNewsLetterFunctionality();
    public abstract boolean checkFirstNewsLettersOption();
    public abstract boolean checkFreeNewsLettersTypes();
    public abstract boolean checkPreviewFunctionality();
    public abstract boolean checkLoginPopUpForSubscribeFreeNewsLetters();
    public abstract boolean checkLoginPopUpForSubscribePaidNewsLetters();
    public abstract boolean checkPlanPageForPaidNewsLettersSubscribeButton();
    public abstract boolean checkSubscribedTagForFreeNewsLetters();
    public abstract boolean checkSubscribedTagForPaidNewsLetters();
    public abstract boolean checkPrivacyPolicyNewsLetters();
    public abstract boolean checkSubscribedTagForPaidAndFreeNewsLetters();
    public abstract boolean checkNoSubscribedNewsLettersIsShowing();
    public abstract boolean checkSubscribedTagAndUnSubscribedPaidAndFreeNewsLetters();
    public abstract boolean checkNewsletterPageLayout();
    public abstract boolean checkNewsletterPageLayoutForSubscribedUsers();
    public abstract boolean checkNewslettersTopNav();
    public  abstract boolean checkRHSOnNewslettersSubscribedUsers();

    public  abstract boolean checkLHSOnNewslettersPage();

    public  abstract boolean checkEasynomicsOnNewslettersPage();
    public  abstract boolean checkCryptoNotesOnNewslettersPage();
    public  abstract boolean checkCompanyOutsiderOnNewslettersPage();

    public abstract boolean checkTickerOnNewslettersPage();

    public abstract boolean checkSaturdayFeelingOnNewslettersPage()
            ;
    public  abstract boolean checkEditorChoiceOnNewslettersPageForSubscriberOnlyNewsletters();

    public abstract boolean checkMintMoneyOnNewslettersPageForSubscriberOnlyNewsletters();


    public  abstract boolean checkMintTechOnNewslettersPageForSubscriberOnlyNewsletters();

    public  abstract boolean checkMintPrimerOnNewslettersPageForSubscriberOnlyNewsletters();

    public  abstract boolean checkTOTMOnNewslettersPage();

    public  abstract boolean checkPlainsFactOnNewslettersPageForSubscriberOnlyNewsletters();

    public  abstract boolean checkMarkToMarketOnNewslettersPageForSubscriberOnlyNewsletters();

    public  abstract boolean checkTwichOnNewslettersPageForSubscriberOnlyNewsletters();

    public  abstract boolean checkLikeShareSuscribeOnNewslettersPageForSubscriberOnlyNewsletters();

    public abstract boolean previewUrlValidation(WebElement element, String title);

    public abstract boolean checkNewsLetterCarouselTitleOnHomePage();
public abstract boolean checkNewsLetterViewAllButton();
public abstract boolean checkNewsletterCardDesign();
public abstract boolean checkNewsLetterViewAllFunctionality();
public abstract boolean checkNewsletterSubscribeButton();
public abstract boolean checkNewsletterReadButtonAndFunctionality();
public abstract boolean checkNewsletterFreeTag();
public abstract boolean checkFreeNewsLetterSubscribeByNonLoggedInUser();
public abstract boolean checkSubscribedTagByClickingOnSubscribeButton();
public abstract boolean checkSwipeFunctionality();
public abstract boolean checkFreeSubscriptionFlowInCaseOfNonLoggedInUsers();
public abstract boolean checkRHSOnNewslettersPage();
public  abstract boolean checkPreviewLinkOnNewslettersPage();
public abstract boolean checkFreeNewsLetterSubscriptionByNonLoggedInUser();
public abstract boolean checkPaidNewsLetterSubscriptionByNonLoggedInUser();


    public abstract boolean checkSubscribedTagAndClickOnUnsubscribed();

    public abstract boolean checkPremiumTag();
}









