package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.web.InsurancePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonInsurancePage {
    private static CommonInsurancePage commonInsurancePage;
    private static GlobalVars globalVars;

    public static CommonInsurancePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonInsurancePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonInsurancePage = new InsurancePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonInsurancePage;
    }

    public abstract boolean checkTopNavOnInsurancePage();
    public abstract boolean checkLHSOnInsurancePage();
    public abstract boolean clickOnInsuranceSection();
    public abstract boolean checkRHSOnInsurancePage();
    public abstract boolean checkshareIconVisibility();
    public abstract boolean checkInsurancePageLayout();

}