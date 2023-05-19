
package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.HamburgerPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHamburgerPage {

    private static CommonHamburgerPage hamburgerPage;
    private static GlobalVars globalVars;

    public static CommonHamburgerPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (hamburgerPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    hamburgerPage = new HamburgerPage();
                    break;
            }
        }
        return hamburgerPage;
    }

    public abstract  boolean typeFilter(String type,String pageSectionName);
    public abstract boolean publishedFilter(String pageSectionName);
    public abstract boolean clickOnPages();
    public abstract boolean dragAndDrop(String type,String pageSectionName);
    public abstract boolean searchOnHamburgerPage(String pageSectionName);
    public abstract boolean hamburgerPageSectionLineUp();
    public abstract boolean hamburgerPagePreviewOfIcon(String pageSectionName);
    public abstract boolean dragAndDropDelete(String type,String pageSectionName);
    public abstract boolean upAndDownPosition(String pageSectionName, String  pageSectionAlias, String pageSectionName1,String pageSectionAlias1);
    public abstract boolean publishHamburgerPage(String type, String pageSectionName);
    public abstract boolean allTopicsAndSection();
    public abstract boolean editAndRefreshPage(String sectionName);
    public abstract boolean deleteSection(String pageSectionName);
    public abstract boolean editSectionName(String pageSectionName,String newSectionName);
    public abstract boolean deleteCreatedSection(String pageSectionName);
    public abstract boolean sectionNameUpAndDownPosition(String pageSectionName, String pageSectionAlias,String pageSectionName1,String pageSectionAlias1);
}

