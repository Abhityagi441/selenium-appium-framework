package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.JsonEmbedPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonJsonEmbedPage {

    private static CommonJsonEmbedPage commonJsonEmbedPage;
    private static GlobalVars globalVars;

    public static CommonJsonEmbedPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonJsonEmbedPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonJsonEmbedPage = new JsonEmbedPage();
                    break;
            }
        }
        return commonJsonEmbedPage;
    }

public abstract boolean createJsonEmbed(String addJsonURL,String name,String tags,String externalURL,String jsonSourceURL,String subType);
public abstract boolean publishJsonEmbed();
public abstract boolean metadataJsonSourceURL(String jsonSourceURL);
public abstract boolean metadataSubType(String jsonSourceURL, String domain);
public abstract boolean metadataName(String addJsonURL,String name);
public abstract boolean cancelButton();
public abstract boolean createPublishEditRefreshPage(String addJsonURL,String name,String editName, String tags, String externalURL, String jsonSourceURL,String subType,String domain);
public abstract boolean jsonCodeValidation(String addJsonURL);
public abstract boolean jsonEmbedCodePage(String addJsonURL);
public abstract boolean editJsonEmbed(String editName);
public abstract boolean editableExistingJson(String addJsonURL,String editAddJsonURL);
public abstract boolean checkIfTheFieldTagTypeAppIsPresentInMetaDataForJsonEmbed(String addJsonData, String name, String jsonSourceUrl, String tagFieldCheck);
public abstract boolean checkIfeUserIsAbleToCreateJsonEmbed(String addJsonData, String name, String jsonSourceUrl, String subtype);

}
