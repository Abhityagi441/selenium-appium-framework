package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.SideBar.UsersPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonUsersPage {
    private static CommonUsersPage commonUsersPage;
    private static GlobalVars globalVars;

    public static CommonUsersPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonUsersPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonUsersPage = new UsersPage();
                    break;
            }
        }
        return commonUsersPage;
    }

    public abstract boolean CheckIfUserIsAbleToClickOnUsersTabPresentInSidebar(String backgroundColor);
    public abstract boolean CheckIfUserIsAbleToSeeFifteenHorizontalTabsOnTheUsersPage();
    public abstract boolean CheckIfBackgroundColorShouldBecomeWhiteWhenUserClickOnAnyOfTheTab(String backgroundColor);
    public abstract boolean CheckIfOutlineColorShouldBecomeBlueWhenUserClickOnAnyOfTheTab(String borderColor);
    public abstract boolean CheckIfAllTheEightFieldShouldBePresentOnUsersPage();
    public abstract boolean CheckIfAllTheEightFieldsShouldBeClickable();
    public abstract boolean CheckIfUserIsAbleToSeeUsersTabPresentInSidebar();

}
