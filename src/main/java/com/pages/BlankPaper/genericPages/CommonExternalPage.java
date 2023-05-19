package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.ExternalPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonExternalPage {

    private static CommonExternalPage commonExternalPage;
    private static GlobalVars globalVars;

    public static CommonExternalPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonExternalPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonExternalPage = new ExternalPage();
                    break;
            }
        }
        return commonExternalPage;
    }

    public abstract boolean createAndPublishExternalPage(String externalName, String  externalAlias, String typeFilterValue);
    public abstract boolean editExternal(String editExternalName,String typeFilterValue);

}
