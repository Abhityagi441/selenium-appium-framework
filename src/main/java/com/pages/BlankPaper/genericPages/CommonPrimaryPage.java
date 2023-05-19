package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.PrimaryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPrimaryPage {

    private static CommonPrimaryPage commonPrimaryPage;
    private static GlobalVars globalVars;

    public static CommonPrimaryPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonPrimaryPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonPrimaryPage = new PrimaryPage();
                    break;
            }
        }
        return commonPrimaryPage;
    }

    public abstract boolean publishPrimaryPage(String primaryName, String primaryAlias);
    public abstract boolean allValidationToCreatePrimaryPage(String primaryName, String primaryAlias);
    public abstract boolean createDragAndDropStoryAndPublishPrimary(String primaryName, String primaryAlias, String headline);
    public abstract boolean checkSectionAndSubSectionFieldsForPrimaryPages(String primaryName, String primaryAlias);
    public abstract boolean createPrimaryPageOnLiveHindustanAffiliateAndPublish(String primaryName, String primaryAlias);
}
