package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.notifications.NotificationsPage;
import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonNotificationsPage {

    private static CommonNotificationsPage commonNotificationsPage;
    private static GlobalVars globalVars;

    public static CommonNotificationsPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonNotificationsPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonNotificationsPage = new NotificationsPage();
                    break;
            }
        }
        return commonNotificationsPage;
    }

    public abstract boolean checkThatUserIsAbleToSendNotificationsForTamilTenants(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkThatUserIsAbleToSendNotificationsForMarathiTenants(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);

    public abstract boolean checkThatUserIsAbleToSendNotificationsForTeluguTenants(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);

}
