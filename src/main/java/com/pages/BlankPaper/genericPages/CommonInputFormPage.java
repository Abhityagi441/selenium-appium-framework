package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.InputFormPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonInputFormPage {

    private static CommonInputFormPage commonInputFormPage;
    private static GlobalVars globalVars;

    public static CommonInputFormPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonInputFormPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonInputFormPage = new InputFormPage();
                    break;
            }
        }
        return commonInputFormPage;
    }
    public abstract boolean createAndValidateInputForm(String name, String tags, String URL, String topics);
    public abstract boolean discardElements();
    public abstract boolean metadataName(String name);
    public abstract boolean metadataTags(String tags);
    public abstract boolean metadataExternalURL(String URL);
    public abstract boolean refreshAndPublish(String name, String tags, String URL, String topics);
    public abstract boolean createInputFormAndValidateTrendingTopicAddAndDelete(String name, String tags, String URL, String topics);
    public abstract boolean searchSection();
    public abstract boolean createdOnFilter(String name);
    public abstract boolean typeFilter(String name, String type);
    public abstract boolean statusFilter(String name, String status);
    public abstract String getElementId();
    public abstract void searchElementByID(String id);
    public abstract void createInputForm(String name, String tags, String URL, String topic);
}

