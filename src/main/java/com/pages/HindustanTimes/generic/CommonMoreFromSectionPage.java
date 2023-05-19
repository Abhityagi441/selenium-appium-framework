package com.pages.HindustanTimes.generic;

import com.pages.HindustanTimes.web.MoreFromSectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMoreFromSectionPage {
    private static CommonMoreFromSectionPage commonMoreFromSectionPage;
    private static GlobalVars globalVars;

    public static CommonMoreFromSectionPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonMoreFromSectionPage ==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonMoreFromSectionPage = new MoreFromSectionPage();
                    break;

                case Constants.IOS_NATIVE:
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonMoreFromSectionPage;
    }

    public abstract boolean clickReadFullStory();
    public abstract boolean checkMoreFromSection(String expectedMoreFromThisSection);
    public abstract boolean checkClose();
}


