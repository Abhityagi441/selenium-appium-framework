package com.pages.LiveMint.genericPages;


import com.pages.LiveMint.web.MutualFundPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMutualFundPage {
    private static CommonMutualFundPage commonMutualFundPage;
    private static GlobalVars globalVars;

    public static CommonMutualFundPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonMutualFundPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonMutualFundPage = new MutualFundPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonMutualFundPage = new com.pages.LiveMint.android_mweb.MutualFundPage();
                    break;
                case Constants.IOS_WEB:
                    commonMutualFundPage = new com.pages.LiveMint.ios_mweb.MutualFundPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonMutualFundPage = new com.pages.LiveMint.android_amp.MutualFundPage();
                    break;
                case Constants.IOS_AMP:
                    commonMutualFundPage = new com.pages.LiveMint.android_amp.MutualFundPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonMutualFundPage;
    }

    public abstract boolean checkWidgetHeader(String categories, String MFurl );
    public abstract boolean checkCategoriesInMFWidget(String header,String categories);
    public abstract boolean selectCategory(String category);

    public abstract boolean checkMFListingCountinWidget(String category);

    public abstract boolean checkAssetsizeFieldInMFWidget(String header, String key);

    public abstract boolean checkMFListingDataheaders(String category, String key);
    public abstract boolean checkDropdownHaveMFOptions(String category);
    public abstract boolean checkMFListedDisplayedForSelectedMF(String category,String SubCategory,String mfAPIUrl);

    public abstract boolean checkMFSectionInHamburger(String Offer);

    public abstract boolean checkMFNewsSubSectionInHamburger(String Offer);
}


