package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.TopicPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonTopicPage {

    private static CommonTopicPage commonTopicPage;
    private static GlobalVars globalVars;
    public static CommonTopicPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonTopicPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonTopicPage = new TopicPage();
                    break;
            }
        }
        return commonTopicPage;
    }
    public abstract boolean publishTopicPage(String topicName, String  topicAlias);
    public abstract boolean allValidationToCreateTopicPage(String topicName, String topicAlias);
    public abstract boolean createDragAndDropStoryAndPublishTopic(String pageTopicName, String pageTopicAlias,String section, String headline);
    public abstract boolean checkCreateTopicWithLivehindustanAffiliate(String property, String topicName, String  topicAlias);
}
