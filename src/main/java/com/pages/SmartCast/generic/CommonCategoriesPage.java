package com.pages.SmartCast.generic;

import com.pages.SmartCast.web.CategoriesPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCategoriesPage {
    private static CommonCategoriesPage commonCategoriesPage;
    private static GlobalVars globalVars;

    public static CommonCategoriesPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonCategoriesPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonCategoriesPage= new CategoriesPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCategoriesPage;
    }
    public abstract boolean navigateToCategoriesPage() ;
    public abstract String  getSmartCastTitle();
    public abstract boolean checkCategoriesSection() ;
}
