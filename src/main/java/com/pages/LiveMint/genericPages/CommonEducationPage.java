package com.pages.LiveMint.genericPages;
import com.pages.LiveMint.web.EducationPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonEducationPage {
    private static CommonEducationPage commonEducationPage;
    private static GlobalVars globalVars;

    public static CommonEducationPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars = GlobalVars.getInstance();
        if (commonEducationPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonEducationPage = new EducationPage();
                    break;
                case Constants.IOS_WEB:
                    commonEducationPage = new com.pages.LiveMint.ios_mweb.EducationPage();
                    break;

                case Constants.ANDROID_WEB:
                    commonEducationPage = new com.pages.LiveMint.android_mweb.EducationPage();
                    break;
            }

        }
            System.out.println("******************* beforeMethod ends here *******************");
            return commonEducationPage;
        }


        public abstract boolean checkEducationPageLayout (String amp);

    public abstract boolean clickOnEducationsSection();
    public abstract boolean checkLHSMenuOnEducationPage();
    public abstract boolean checkRHSOnEducationPage();
    public abstract boolean checkTopNavOnEducationPage();
}
