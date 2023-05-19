package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.ListicleStoryPage;
import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonListicleStoryPage {
    private static CommonListicleStoryPage commonListicleStoryPage;
    private static GlobalVars globalVars;

    public static CommonListicleStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonListicleStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonListicleStoryPage = new ListicleStoryPage();
                    break;
            }
        }
        return commonListicleStoryPage;
    }

    public abstract boolean checkUserCanCreateListicleStoryWithHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkIfUserCanCreateListicleStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
}
