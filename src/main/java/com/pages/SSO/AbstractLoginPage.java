package com.pages.SSO;


import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class AbstractLoginPage {
    private static AbstractLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static AbstractLoginPage getInstance(){

        globalVars= GlobalVars.getInstance();
        switch (globalVars.getApplicationName()){
            case Constants.HINDUSTAN_TIMES:
                commonLoginPage= com.pages.HindustanTimes.generic.CommonLoginPage.getInstance();
                break;
            case Constants.LIVE_MINT:
                commonLoginPage= com.pages.LiveMint.genericPages.CommonLoginPage.getInstance();
                break;
            case Constants.LIVE_HINDUSTAN:
                commonLoginPage= com.pages.LiveHindustan.genericPages.CommonLoginPage.getInstance();
                break;
            case Constants.HT_E_PAPER:
                commonLoginPage= com.pages.HT_Epaper.genericPages.CommonLoginPage.getInstance();
                break;
            case Constants.LM_E_PAPER:
                commonLoginPage= com.pages.LM_Epaper.genericPages.CommonLoginPage.getInstance();
                break;
            case Constants.LH_E_PAPER:
                commonLoginPage= com.pages.LH_Epaper.genericPages.CommonLoginPage.getInstance();
                break;
            case Constants.SMART_CAST:
                commonLoginPage= com.pages.SmartCast.generic.CommonLoginPage.getInstance();
                break;
            case Constants.HT_TECH:
                commonLoginPage=com.pages.HT_TECH.generic.CommonLoginPage.getInstance();
        }

        return commonLoginPage;
    }

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName);
    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);
    public abstract boolean loginWithAppleID(String email, String password, String expectedUserName);
    public abstract boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName);
    public abstract boolean logout();
}
