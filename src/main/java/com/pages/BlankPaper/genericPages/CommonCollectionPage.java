package com.pages.BlankPaper.genericPages;
import com.pages.BlankPaper.webdesktop.stories.CollectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCollectionPage {
    private static CommonCollectionPage commonCollectionPage;
    private static GlobalVars globalVars;

    public static CommonCollectionPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonCollectionPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonCollectionPage = new CollectionPage();
                    break;
            }
        }
        return commonCollectionPage;
    }

    public abstract boolean byLineFilter(String byline, String headline);
    public abstract boolean domainFilter(String headline, String domain);
    public abstract boolean createdOnFilter(String headline);
    public abstract boolean typeFilter(String headline, String type);
    public abstract boolean typeFilterForCollection(String headline, String type);
    public abstract boolean sectionFilter(String headline, String section);
    public abstract boolean categoryFilter(String headline, String category);
    public abstract boolean dropDown(String story, String page);
    public abstract boolean topicsFilter(String headline, String topic, String doamin);
    public abstract boolean dragAndDropStories();
    public abstract boolean deleteStoryFromCollection();
    public abstract boolean createCollectionStatus(String name,String tags,String URL, String section, String subsection);
    public abstract boolean createElementButton();
    public abstract boolean locationFilter(String headline, String location, String domain);
    public abstract boolean publishCreateCollection();
    public abstract boolean storiesUpAndDownPosition(String name, String tags, String URL, String section, String subsection);
    public abstract boolean metadataName(String name);
    public abstract boolean metadataTags(String tags);
    public abstract boolean metadataExternalURL(String URL);
    public abstract boolean metadataSection(String section, String domain);
    public abstract boolean metadataSubsection(String subsection, String domain);
    public abstract boolean editStatus(String editName);
    public abstract boolean previewStories(String headline);
    public abstract boolean cancelButton(String name,String tags, String URL, String section ,String subsection,String PageSectionName);
    public abstract boolean createAndPublishPageSection(String pageSectionName, String  pageSectionAlias);
    public abstract boolean createPublishEditRefreshPage(String name, String tags, String URL, String section, String subsection,String editname, String domain);
    public abstract boolean createCollection(String name, String tags, String URL, String section, String subsection);
    public abstract boolean discardCollection();
    public abstract boolean pagesPublishCollection(String id,String collectionName,String headline);
    public abstract boolean dragAndDropFirstStoriesAndPublish(String headline);
    public abstract boolean dragAndDropSecondStoriesAndPublish(String headline1,String headline);
    public abstract boolean dragAndDropStoryTypeAndPublish();
    public abstract boolean deleteStoryFromCollection(String headline1);
    public abstract void deleteCollectionOnPages(String id, String collectionName);
    public abstract boolean storiesUpAndDownPositionOnPages(String headline, String headline1, String collectionName);
    public abstract boolean editCollectionName(String editName);
    public abstract boolean verifyAddOptionToIncludeProductWidgetsOnHtAutoOrTech(String collectionName, String firstDropdown, String secoundDropdown, String thirdDropdown);
    public abstract boolean checkToggleSwitchesShouldBePresentAppAndAmp();
    public abstract boolean checkByDefaultBothTheButtonsShouldInOnPosition(String expectedBgColorHexCode);
    public abstract boolean checkAbleToSelectOneOrNoneFromBothTheOptions(String appBgColorHexCodeBeforeSelect, String appBgColorHexCodeAfterSelect, String ampBgColorHexCodeBeforeSelect, String ampBgColorHexCodeAfterSelect);

    public abstract boolean createACollectionOnLiveHindustanAffiliateAndPublish(String name,String tag,String url);

    public abstract boolean createAnEmbedCollectionOnLiveHindustanAffiliateAndPublish(String name,String codeForTweets,String codeForDarkMode);

    public abstract boolean createInputFormOnLiveHindustanAffiliateAndPublish(String name,String topicName,String topicURL);

    public abstract boolean createChartOnLiveHindustanAffiliateAndPublish(String name);

    public abstract boolean createTableOnLiveHindustanAffiliateAndPublish(String name);
}
