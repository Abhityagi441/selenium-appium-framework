package com.pages.HT_TECH.generic;

import com.pages.HT_TECH.web.LoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage extends AbstractLoginPage {
    private static com.pages.HT_TECH.generic.CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;
    public static CommonLoginPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonLoginPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonLoginPage=new LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLoginPage;
    }
    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);
    public abstract boolean logout();
}
