package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.SubSectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSubSectionPage {

    private static CommonSubSectionPage commonSubSectionPage;
    private static GlobalVars globalVars;

    public static CommonSubSectionPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonSubSectionPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonSubSectionPage = new SubSectionPage();
                    break;
            }
        }
        return commonSubSectionPage;
    }
    public abstract boolean publishSubSectionPage(String subSectionName, String  subSectionAlias);
    public abstract boolean editAndRefreshPage(String subSectionEditName);
    public abstract boolean allValidationToCreateSubsectionPage(String subSectionName, String subSectionAlias);
    public abstract boolean createPageAndValidate(String subSectionName);
    public abstract boolean createDragAndDropStoryAndPublishSection(String pageSubSectionName, String pageSubSectionAlias,String section, String headline);
    public abstract boolean checkCreateSubSectionPageWithLivehindustanAffiliateTanent(String property, String subSectionName, String subSectionAlias);


}
