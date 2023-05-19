package com.pages.SmartCast.generic;

import com.pages.SmartCast.web.PublishersPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPublishersPage {
    private static CommonPublishersPage commonPublishersPage;
    private static GlobalVars globalVars;

    public static CommonPublishersPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonPublishersPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonPublishersPage= new PublishersPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonPublishersPage = new com.pages.SmartCast.AndroidWebPages.PublishersPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPublishersPage;
    }
    public abstract boolean navigateToPublishersPage() ;
    public abstract String  getSmartCastTitle();
    public abstract boolean checkPublishersSection() ;
}
