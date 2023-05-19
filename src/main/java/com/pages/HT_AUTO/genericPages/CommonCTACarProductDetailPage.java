package com.pages.HT_AUTO.genericPages;


import com.pages.HT_AUTO.DesktopBrowserPages.CTACarProductDetailPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCTACarProductDetailPage {
    private static CommonCTACarProductDetailPage commonCTACarProductDetailPage;
    private static GlobalVars globalVars;

    public static CommonCTACarProductDetailPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCTACarProductDetailPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCTACarProductDetailPage = new CTACarProductDetailPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCTACarProductDetailPage;
    }

    public abstract boolean checkCTACarProductDetailPage();

}