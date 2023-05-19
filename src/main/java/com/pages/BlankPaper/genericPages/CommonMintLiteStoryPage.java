package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.MintLiteStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMintLiteStoryPage {
    private static CommonMintLiteStoryPage commonMintLiteStoryPage;
    private static GlobalVars globalVars;

    public static CommonMintLiteStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonMintLiteStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonMintLiteStoryPage = new MintLiteStoryPage();
                    break;
            }
        }
        return commonMintLiteStoryPage;
    }

    public abstract boolean checkUserCanCreateMintLiteStoryWithHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkIfUserIsAbleToCreateStoryMintLite(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
}
