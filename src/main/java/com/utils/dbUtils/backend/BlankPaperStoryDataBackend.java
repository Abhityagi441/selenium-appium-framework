package com.utils.dbUtils.backend;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.frontend.Id;
import com.utils.dbUtils.frontend.LastModifiedDate;

@Generated("jsonschema2pojo")
public class BlankPaperStoryDataBackend {

    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("elements")
    @Expose
    private List<Id> elements = null;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("newsletterSummary")
    @Expose
    private String newsletterSummary;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("mobileHeadline")
    @Expose
    private String mobileHeadline;
    @SerializedName("mobileAppNotificationHeadline")
    @Expose
    private String mobileAppNotificationHeadline;
    @SerializedName("browserNotificationHeadline")
    @Expose
    private String browserNotificationHeadline;
    @SerializedName("facebookHeadline")
    @Expose
    private String facebookHeadline;
    @SerializedName("twitterHeadline")
    @Expose
    private String twitterHeadline;
    @SerializedName("urlHeadline")
    @Expose
    private String urlHeadline;
    @SerializedName("newsletterHeadline")
    @Expose
    private String newsletterHeadline;
    @SerializedName("lastPublishedHeadline")
    @Expose
    private String lastPublishedHeadline;
    @SerializedName("h2HeaderHeadline")
    @Expose
    private String h2HeaderHeadline;
    @SerializedName("h3HeaderHeadline")
    @Expose
    private String h3HeaderHeadline;
    @SerializedName("lastPublishedSummary")
    @Expose
    private String lastPublishedSummary;
    @SerializedName("leadMedia")
    @Expose
    private LeadMedia leadMedia;
    @SerializedName("leadMediaGif")
    @Expose
    private LeadMediaGif leadMediaGif;
    @SerializedName("introBody")
    @Expose
    private String introBody;
    @SerializedName("related")
    @Expose
    private List<Object> related = null;
    @SerializedName("showRelated")
    @Expose
    private Boolean showRelated;
    @SerializedName("pinnedArticles")
    @Expose
    private List<Object> pinnedArticles = null;
    @SerializedName("manualSummary")
    @Expose
    private Boolean manualSummary;
    @SerializedName("crossDomainStories")
    @Expose
    private List<Object> crossDomainStories = null;
    @SerializedName("domainId")
    @Expose
    private String domainId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleWoSpChar")
    @Expose
    private String titleWoSpChar;
    @SerializedName("articleType")
    @Expose
    private String articleType;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createdDate")
    @Expose
    private LastModifiedDate createdDate;
    @SerializedName("lastModifiedBy")
    @Expose
    private String lastModifiedBy;
    @SerializedName("lastModifiedByUserName")
    @Expose
    private String lastModifiedByUserName;
    @SerializedName("lastModifiedDate")
    @Expose
    private LastModifiedDate lastModifiedDate;
    @SerializedName("lockedByUserId")
    @Expose
    private String lockedByUserId;
    @SerializedName("lockedByUserName")
    @Expose
    private String lockedByUserName;
    @SerializedName("lockedDate")
    @Expose
    private LastModifiedDate lockedDate;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("socialList")
    @Expose
    private SocialList socialList;
    @SerializedName("isDeleted")
    @Expose
    private int isDeleted;
    @SerializedName("readByUsers")
    @Expose
    private List<String> readByUsers = null;
    @SerializedName("changesPublished")
    @Expose
    private Boolean changesPublished;
    @SerializedName("suggest")
    @Expose
    private Suggest suggest;
    @SerializedName("softPublished")
    @Expose
    private Boolean softPublished;
    @SerializedName("imageAmpValidated")
    @Expose
    private Boolean imageAmpValidated;
    @SerializedName("lastRequestId")
    @Expose
    private String lastRequestId;
    @SerializedName("isAutoPublished")
    @Expose
    private Boolean isAutoPublished;
    @SerializedName("collectionStoriesVersion")
    @Expose
    private Id collectionStoriesVersion;
    @SerializedName("topicMigrated")
    @Expose
    private Boolean topicMigrated;
    @SerializedName("migrationInfoWebUrl")
    @Expose
    private String migrationInfoWebUrl;
    @SerializedName("migrationInfoWebUrlMigrated")
    @Expose
    private Boolean migrationInfoWebUrlMigrated;
    @SerializedName("topicPublished")
    @Expose
    private Boolean topicPublished;
    @SerializedName("migrationInfoWebUrlPublished")
    @Expose
    private Boolean migrationInfoWebUrlPublished;
    @SerializedName("companyChartAdded")
    @Expose
    private Boolean companyChartAdded;
    @SerializedName("_class")
    @Expose
    private String _class;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public List<Id> getElements() {
        return elements;
    }

    public void setElements(List<Id> elements) {
        this.elements = elements;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNewsletterSummary() {
        return newsletterSummary;
    }

    public void setNewsletterSummary(String newsletterSummary) {
        this.newsletterSummary = newsletterSummary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileHeadline() {
        return mobileHeadline;
    }

    public void setMobileHeadline(String mobileHeadline) {
        this.mobileHeadline = mobileHeadline;
    }

    public String getMobileAppNotificationHeadline() {
        return mobileAppNotificationHeadline;
    }

    public void setMobileAppNotificationHeadline(String mobileAppNotificationHeadline) {
        this.mobileAppNotificationHeadline = mobileAppNotificationHeadline;
    }

    public String getBrowserNotificationHeadline() {
        return browserNotificationHeadline;
    }

    public void setBrowserNotificationHeadline(String browserNotificationHeadline) {
        this.browserNotificationHeadline = browserNotificationHeadline;
    }

    public String getFacebookHeadline() {
        return facebookHeadline;
    }

    public void setFacebookHeadline(String facebookHeadline) {
        this.facebookHeadline = facebookHeadline;
    }

    public String getTwitterHeadline() {
        return twitterHeadline;
    }

    public void setTwitterHeadline(String twitterHeadline) {
        this.twitterHeadline = twitterHeadline;
    }

    public String getUrlHeadline() {
        return urlHeadline;
    }

    public void setUrlHeadline(String urlHeadline) {
        this.urlHeadline = urlHeadline;
    }

    public String getNewsletterHeadline() {
        return newsletterHeadline;
    }

    public void setNewsletterHeadline(String newsletterHeadline) {
        this.newsletterHeadline = newsletterHeadline;
    }

    public String getLastPublishedHeadline() {
        return lastPublishedHeadline;
    }

    public void setLastPublishedHeadline(String lastPublishedHeadline) {
        this.lastPublishedHeadline = lastPublishedHeadline;
    }

    public String getH2HeaderHeadline() {
        return h2HeaderHeadline;
    }

    public void setH2HeaderHeadline(String h2HeaderHeadline) {
        this.h2HeaderHeadline = h2HeaderHeadline;
    }

    public String getH3HeaderHeadline() {
        return h3HeaderHeadline;
    }

    public void setH3HeaderHeadline(String h3HeaderHeadline) {
        this.h3HeaderHeadline = h3HeaderHeadline;
    }

    public String getLastPublishedSummary() {
        return lastPublishedSummary;
    }

    public void setLastPublishedSummary(String lastPublishedSummary) {
        this.lastPublishedSummary = lastPublishedSummary;
    }

    public LeadMedia getLeadMedia() {
        return leadMedia;
    }

    public void setLeadMedia(LeadMedia leadMedia) {
        this.leadMedia = leadMedia;
    }

    public LeadMediaGif getLeadMediaGif() {
        return leadMediaGif;
    }

    public void setLeadMediaGif(LeadMediaGif leadMediaGif) {
        this.leadMediaGif = leadMediaGif;
    }

    public String getIntroBody() {
        return introBody;
    }

    public void setIntroBody(String introBody) {
        this.introBody = introBody;
    }

    public List<Object> getRelated() {
        return related;
    }

    public void setRelated(List<Object> related) {
        this.related = related;
    }

    public Boolean getShowRelated() {
        return showRelated;
    }

    public void setShowRelated(Boolean showRelated) {
        this.showRelated = showRelated;
    }

    public List<Object> getPinnedArticles() {
        return pinnedArticles;
    }

    public void setPinnedArticles(List<Object> pinnedArticles) {
        this.pinnedArticles = pinnedArticles;
    }

    public Boolean getManualSummary() {
        return manualSummary;
    }

    public void setManualSummary(Boolean manualSummary) {
        this.manualSummary = manualSummary;
    }

    public List<Object> getCrossDomainStories() {
        return crossDomainStories;
    }

    public void setCrossDomainStories(List<Object> crossDomainStories) {
        this.crossDomainStories = crossDomainStories;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleWoSpChar() {
        return titleWoSpChar;
    }

    public void setTitleWoSpChar(String titleWoSpChar) {
        this.titleWoSpChar = titleWoSpChar;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LastModifiedDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LastModifiedDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedByUserName() {
        return lastModifiedByUserName;
    }

    public void setLastModifiedByUserName(String lastModifiedByUserName) {
        this.lastModifiedByUserName = lastModifiedByUserName;
    }

    public LastModifiedDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LastModifiedDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLockedByUserId() {
        return lockedByUserId;
    }

    public void setLockedByUserId(String lockedByUserId) {
        this.lockedByUserId = lockedByUserId;
    }

    public String getLockedByUserName() {
        return lockedByUserName;
    }

    public void setLockedByUserName(String lockedByUserName) {
        this.lockedByUserName = lockedByUserName;
    }

    public LastModifiedDate getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(LastModifiedDate lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public SocialList getSocialList() {
        return socialList;
    }

    public void setSocialList(SocialList socialList) {
        this.socialList = socialList;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<String> getReadByUsers() {
        return readByUsers;
    }

    public void setReadByUsers(List<String> readByUsers) {
        this.readByUsers = readByUsers;
    }

    public Boolean getChangesPublished() {
        return changesPublished;
    }

    public void setChangesPublished(Boolean changesPublished) {
        this.changesPublished = changesPublished;
    }

    public Suggest getSuggest() {
        return suggest;
    }

    public void setSuggest(Suggest suggest) {
        this.suggest = suggest;
    }

    public Boolean getSoftPublished() {
        return softPublished;
    }

    public void setSoftPublished(Boolean softPublished) {
        this.softPublished = softPublished;
    }

    public Boolean getImageAmpValidated() {
        return imageAmpValidated;
    }

    public void setImageAmpValidated(Boolean imageAmpValidated) {
        this.imageAmpValidated = imageAmpValidated;
    }

    public String getLastRequestId() {
        return lastRequestId;
    }

    public void setLastRequestId(String lastRequestId) {
        this.lastRequestId = lastRequestId;
    }

    public Boolean getIsAutoPublished() {
        return isAutoPublished;
    }

    public void setIsAutoPublished(Boolean isAutoPublished) {
        this.isAutoPublished = isAutoPublished;
    }

    public Id getCollectionStoriesVersion() {
        return collectionStoriesVersion;
    }

    public void setCollectionStoriesVersion(Id collectionStoriesVersion) {
        this.collectionStoriesVersion = collectionStoriesVersion;
    }

    public Boolean getTopicMigrated() {
        return topicMigrated;
    }

    public void setTopicMigrated(Boolean topicMigrated) {
        this.topicMigrated = topicMigrated;
    }

    public String getMigrationInfoWebUrl() {
        return migrationInfoWebUrl;
    }

    public void setMigrationInfoWebUrl(String migrationInfoWebUrl) {
        this.migrationInfoWebUrl = migrationInfoWebUrl;
    }

    public Boolean getMigrationInfoWebUrlMigrated() {
        return migrationInfoWebUrlMigrated;
    }

    public void setMigrationInfoWebUrlMigrated(Boolean migrationInfoWebUrlMigrated) {
        this.migrationInfoWebUrlMigrated = migrationInfoWebUrlMigrated;
    }

    public Boolean getTopicPublished() {
        return topicPublished;
    }

    public void setTopicPublished(Boolean topicPublished) {
        this.topicPublished = topicPublished;
    }

    public Boolean getMigrationInfoWebUrlPublished() {
        return migrationInfoWebUrlPublished;
    }

    public void setMigrationInfoWebUrlPublished(Boolean migrationInfoWebUrlPublished) {
        this.migrationInfoWebUrlPublished = migrationInfoWebUrlPublished;
    }

    public Boolean getCompanyChartAdded() {
        return companyChartAdded;
    }

    public void setCompanyChartAdded(Boolean companyChartAdded) {
        this.companyChartAdded = companyChartAdded;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

}
