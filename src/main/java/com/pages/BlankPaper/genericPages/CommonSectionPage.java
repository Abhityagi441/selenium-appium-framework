package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.SectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSectionPage {

    private static CommonSectionPage commonSectionPage;
    private static GlobalVars globalVars;

    public static CommonSectionPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonSectionPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonSectionPage = new SectionPage();
                    break;
            }
        }
        return commonSectionPage;
    }

    public abstract boolean publishSectionPage(String sectionName, String  sectionAlias);
    public abstract boolean allValidationToCreateSectionPage(String sectionName, String sectionAlias);
    public abstract boolean createDragAndDropStoryAndPublishSection(String pageSectionName, String sectionAlias, String headline);
    public abstract boolean editPageNameAndPublish(String editNewName, String id);
    public abstract boolean dragAndDropStory(String headline);
    public abstract boolean prefixAndSuffixForTitleAndDescriptionForSectionAndSubSectionPages(String domainName);
    public abstract boolean checkCreateSectionPageWithLivehindustanAffiliateTanent(String property, String sectionName, String sectionAlias);
}
