package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.EmbedPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonEmbedPage {
    private static CommonEmbedPage commonEmbedPage;
    private static GlobalVars globalVars;

    public static CommonEmbedPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonEmbedPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonEmbedPage = new EmbedPage();
                    break;
            }
        }
        return commonEmbedPage;
    }

    public abstract void createEmbedInPopup(String embedCode);
    public abstract boolean createEmbedAndVerifyMetaDataValidation(String embedCode);
    public abstract boolean isEmbedVideoDisplayed(String embedVideoCode);
    public abstract boolean createEmbedInPopupAndVerifyEmbedVideoDisplayed(String embedCode,String embedVideoCode);
    public abstract boolean fillMetaDataAndVerifyEmbedPublishingStatus(String name, String tags, String externalURL, String title, String jsonSourceURL, String subtype);
    public abstract boolean navigateToAllElementsAndVerifyEmbedPublishingStatus(String name);
    public abstract void fillMetaDataOnCreateEmbedPage(String name, String tags,String externalURL,String title,String jsonSourceURL,String subtype);
    public abstract void navigateToHomePageAllElementsViaLeftMenu();
    public abstract boolean isEmbedCreationStatus(String name);
    public abstract boolean fillMetaDataAndVerifyEmbedCreationStatus(String name, String tags, String externalURL, String title, String jsonSourceURL, String subtype);
    public abstract boolean clickEditLinkOnEmbedVideoAndVerifyEmbedPopup();
    public abstract void selectEmbedButtonAndSwitchToNewWindow();
    public abstract void fillEmbedCode(String embedCode);
    public abstract boolean fillEmbedCodeAndClickCancelButtonAndVerifyEmbedPopUpClosed(String embedCode);
    public abstract boolean isEmbedPopupClosed();
    public abstract boolean createEmbedAndVerifyEmbedValidationMessagePresent(String embedCodeTextMessage);
    public abstract boolean createAndDiscardEmbed(String name,String tags,String externalURL,String title,String jsonSourceURL,String subtype);
    public abstract void discardCreatedEmbed();
    public abstract boolean discardEmbedAndVerifyDiscardEmbedNotDisplayed(String name);
//    public abstract boolean navigateToHomePageAllElements();
    public abstract boolean enterNameAndDiscardEmbed(String name);
    public abstract boolean editMetaDataAndRefreshAndVerifyChangedData(String editedName, String editedTags,String editedExternalURL, String editedTitle,String editedJsonSourceURL, String editedSubtype);
    public abstract boolean openCreatedEmbedAndPublishIt();
    public abstract boolean checkIfAllTheDropDownOptionsPresentInTagTypeSelectionField(String embedText, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8, String option9, String option10, String option11);
    public abstract boolean checkIfUserIsAbleToSelectAnyOfTheDropDownOptionsFromTagTypeAppField(String embedText, String oneOfTheOption);
    public abstract boolean checkIfDataIsGoingTillMasterForTheInputGivenForTagTypeAppField(String embedText, String name, String oneOfTheOption);

    public abstract boolean checkIfTheFieldTagTypeAppIsPresentInMetaDataForEmbed(String embedText,String tagFieldType);

    public abstract boolean checkIfTagTypeAppFieldIsNotMandatory(String embedText, String name);

}
