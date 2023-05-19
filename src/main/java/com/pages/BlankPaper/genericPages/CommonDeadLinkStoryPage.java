package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.DeadLinkStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonDeadLinkStoryPage {

    private static CommonDeadLinkStoryPage commonDeadLinkStoryPage;
    private static GlobalVars globalVars;

    public static CommonDeadLinkStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonDeadLinkStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonDeadLinkStoryPage = new DeadLinkStoryPage();
                    break;
            }
        }
        return commonDeadLinkStoryPage;
    }

    public abstract boolean createDeadLinkAndVerify(String headline, String summary, String section, String subsection, String url);
    public abstract boolean publishForDeadLinkAndVerify();
    public abstract boolean purgeDeadLinkAndVerify();
    public abstract boolean killDeadLinkAndVerify();
    public abstract boolean changeUrlDeadLinkAndVerify();
    public abstract boolean softPublishDeadLinkAndVerify();
    public abstract boolean verifyUploadImageForDeadlinkStory();
    public abstract boolean verifyEditDeadlinkStoryContent();
    public abstract boolean verifyImageCroppingForDeadlinkStory();
    public abstract boolean deleteDeadLinkContent();
    public abstract boolean discardDeadlinkAndVerify();
    public abstract void clickOnBlankPaperLogo();
    public abstract boolean mouseHoverOnLeftPanelAndVerifyElementsAndUser(String expectedUserName);
    public abstract boolean validateDeadLinkURLAndFormat(String expectedURL);
    public abstract boolean checkSelectedImageShouldBeUploadedForDeadlink(String headline, String summary, String section, String subsection, String url);
}
