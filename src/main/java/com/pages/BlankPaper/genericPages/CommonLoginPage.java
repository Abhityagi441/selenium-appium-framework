package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.login.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage {
    private static CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static CommonLoginPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonLoginPage==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage= new LoginPage();
                    break;
            }
        }
        return commonLoginPage;
    }

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);
    public abstract boolean logout();
    public abstract boolean loginWithId(String userId, String password, String expectedUserName);
}