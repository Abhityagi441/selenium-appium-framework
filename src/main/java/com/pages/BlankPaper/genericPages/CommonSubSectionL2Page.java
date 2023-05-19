package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.Pages.SubSectionL2Page;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSubSectionL2Page {
    private static CommonSubSectionL2Page commonSubSectionL2Page;
    private static GlobalVars globalVars;

    public static CommonSubSectionL2Page getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonSubSectionL2Page == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonSubSectionL2Page = new SubSectionL2Page();
                    break;
            }
        }
        return commonSubSectionL2Page;
    }

    public abstract boolean checkIfUserIsAbleToClickOnSubSectionL2PageFromDropDowns();
    public abstract boolean checkIfSubSectionl2PopupAppearsOnceThisOptionIsClicked();
    public abstract boolean checkIfUserIsAbleToAddNameAlisaSectionAndSubsectionField(String name, String alias,String backgroundColor);
    public abstract boolean checkIfUserIsAbleToAddNameAlisaSectionAndSubsectionFieldAndCreate(String name, String alias);
    public abstract boolean SubSectionPageAndCheckThatInANewStdStorySubSectionField(String name, String alias);
    public abstract boolean SubSectionL2PageAndCheckThatInANewStdStorySubSectionL2Field(String name, String alias);
    public abstract boolean SubSectionL2PageAndSelectThatInANewStdStorySubSectionL2Field(String name, String alias);

}
