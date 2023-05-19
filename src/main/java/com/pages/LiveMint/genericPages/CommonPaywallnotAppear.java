package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.web.PaywallnotAppear;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPaywallnotAppear {
    private static CommonPaywallnotAppear commonPaywallnotAppear;
    private static GlobalVars globalVars;

    public static CommonPaywallnotAppear getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars = GlobalVars.getInstance();
        if (commonPaywallnotAppear == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonPaywallnotAppear = new PaywallnotAppear();
                    break;
                /*case Constants.IOS_WEB:
                    commonPaywallnotAppear = new com.pages.LiveMint.ios_mweb.PaywallnotAppear();
                    break;

                case Constants.ANDROID_WEB:
                    commonPaywallnotAppear = new com.pages.LiveMint.android_mweb.PaywallnotAppear();
                    break;*/
            }

        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPaywallnotAppear;
    }
    public abstract boolean PaywallnotAppear();
}