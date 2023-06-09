package com.pages.SmartCast.generic;
import com.pages.SSO.AbstractLoginPage;
import com.pages.SmartCast.web.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage extends AbstractLoginPage {
    private static CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static CommonLoginPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonLoginPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage= new LoginPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonLoginPage = new com.pages.SmartCast.AndroidWebPages.LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLoginPage;
    }

    public abstract boolean loginWithEmailAndPassword(String email, String password, String expectedUserName);
    public abstract boolean loginWithMobileAndPassword(String phone, String password, String expectedUserName);
    public abstract boolean loginWithFacebook(String phone, String password, String expectedUserName);
    public abstract boolean signOut();
}
