package com.utils.dbUtils.backend;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Metadata {

    @SerializedName("metaTitle")
    @Expose
    private String metaTitle;
    @SerializedName("metaDescription")
    @Expose
    private String metaDescription;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("authors")
    @Expose
    private List<Object> authors = null;
    @SerializedName("syllableCount")
    @Expose
    private int syllableCount;
    @SerializedName("wordCount")
    @Expose
    private int wordCount;
    @SerializedName("sentenceCount")
    @Expose
    private int sentenceCount;
    @SerializedName("agency")
    @Expose
    private String agency;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("keywords")
    @Expose
    private List<Object> keywords = null;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("subSection")
    @Expose
    private String subSection;
    @SerializedName("subSectionL2")
    @Expose
    private String subSectionL2;
    @SerializedName("secondarySections")
    @Expose
    private List<Object> secondarySections = null;
    @SerializedName("secondaryBrands")
    @Expose
    private List<Object> secondaryBrands = null;
    @SerializedName("topic")
    @Expose
    private List<Object> topic = null;
    @SerializedName("alternateSection")
    @Expose
    private List<Object> alternateSection = null;
    @SerializedName("location")
    @Expose
    private List<String> location = null;
    @SerializedName("markUnimportant")
    @Expose
    private Boolean markUnimportant;
    @SerializedName("breakingNews")
    @Expose
    private Boolean breakingNews;
    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("syndicationFeed")
    @Expose
    private Boolean syndicationFeed;
    @SerializedName("premiumStory")
    @Expose
    private Boolean premiumStory;
    @SerializedName("editedBy")
    @Expose
    private List<Object> editedBy = null;
    @SerializedName("writtenBy")
    @Expose
    private List<Object> writtenBy = null;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("seoUrl")
    @Expose
    private String seoUrl;
    @SerializedName("reportedBy")
    @Expose
    private List<Object> reportedBy = null;
    @SerializedName("agencyByLine")
    @Expose
    private List<Object> agencyByLine = null;
    @SerializedName("bigStory")
    @Expose
    private Boolean bigStory;
    @SerializedName("column")
    @Expose
    private String column;
    @SerializedName("redirectUrl")
    @Expose
    private String redirectUrl;
    @SerializedName("videoMetadata")
    @Expose
    private VideoMetadata videoMetadata;
    @SerializedName("killed")
    @Expose
    private Boolean killed;
    @SerializedName("killedStatusCode")
    @Expose
    private int killedStatusCode;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    @SerializedName("sponsoredTitle")
    @Expose
    private String sponsoredTitle;
    @SerializedName("storyType")
    @Expose
    private String storyType;
    @SerializedName("jsonSourceUrl")
    @Expose
    private String jsonSourceUrl;
    @SerializedName("homePagePosition")
    @Expose
    private int homePagePosition;
    @SerializedName("live")
    @Expose
    private Boolean live;
    @SerializedName("developing")
    @Expose
    private Boolean developing;
    @SerializedName("interview")
    @Expose
    private Boolean interview;
    @SerializedName("exclusive")
    @Expose
    private Boolean exclusive;
    @SerializedName("inDepth")
    @Expose
    private Boolean inDepth;
    @SerializedName("opinion")
    @Expose
    private Boolean opinion;
    @SerializedName("latest")
    @Expose
    private Boolean latest;
    @SerializedName("factCheck")
    @Expose
    private Boolean factCheck;
    @SerializedName("notificationSent")
    @Expose
    private Boolean notificationSent;
    @SerializedName("authorsList")
    @Expose
    private List<Authors> authorsList = null;
    @SerializedName("sectionSpecificDefaultTags")
    @Expose
    private List<Object> sectionSpecificDefaultTags = null;

    @SerializedName("deadLinkUrl")
    @Expose
    private String deadLinkUrl;

    @SerializedName("primaryLocation")
    @Expose
    private String primaryLocation;

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Object> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Object> authors) {
        this.authors = authors;
    }

    public int getSyllableCount() {
        return syllableCount;
    }

    public void setSyllableCount(int syllableCount) {
        this.syllableCount = syllableCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public List<Object> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Object> keywords) {
        this.keywords = keywords;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubSection() {
        return subSection;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public String getSubSectionL2() {
        return subSectionL2;
    }

    public void setSubSectionL2(String subSectionL2) {
        this.subSectionL2 = subSectionL2;
    }

    public List<Object> getSecondarySections() {
        return secondarySections;
    }

    public void setSecondarySections(List<Object> secondarySections) {
        this.secondarySections = secondarySections;
    }

    public List<Object> getSecondaryBrands() {
        return secondaryBrands;
    }

    public void setSecondaryBrands(List<Object> secondaryBrands) {
        this.secondaryBrands = secondaryBrands;
    }

    public List<Object> getTopic() {
        return topic;
    }

    public void setTopic(List<Object> topic) {
        this.topic = topic;
    }

    public List<Object> getAlternateSection() {
        return alternateSection;
    }

    public void setAlternateSection(List<Object> alternateSection) {
        this.alternateSection = alternateSection;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public Boolean getMarkUnimportant() {
        return markUnimportant;
    }

    public void setMarkUnimportant(Boolean markUnimportant) {
        this.markUnimportant = markUnimportant;
    }

    public Boolean getBreakingNews() {
        return breakingNews;
    }

    public void setBreakingNews(Boolean breakingNews) {
        this.breakingNews = breakingNews;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Boolean getSyndicationFeed() {
        return syndicationFeed;
    }

    public void setSyndicationFeed(Boolean syndicationFeed) {
        this.syndicationFeed = syndicationFeed;
    }

    public Boolean getPremiumStory() {
        return premiumStory;
    }

    public void setPremiumStory(Boolean premiumStory) {
        this.premiumStory = premiumStory;
    }

    public List<Object> getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(List<Object> editedBy) {
        this.editedBy = editedBy;
    }

    public List<Object> getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(List<Object> writtenBy) {
        this.writtenBy = writtenBy;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    public List<Object> getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(List<Object> reportedBy) {
        this.reportedBy = reportedBy;
    }

    public List<Object> getAgencyByLine() {
        return agencyByLine;
    }

    public void setAgencyByLine(List<Object> agencyByLine) {
        this.agencyByLine = agencyByLine;
    }

    public Boolean getBigStory() {
        return bigStory;
    }

    public void setBigStory(Boolean bigStory) {
        this.bigStory = bigStory;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public VideoMetadata getVideoMetadata() {
        return videoMetadata;
    }

    public void setVideoMetadata(VideoMetadata videoMetadata) {
        this.videoMetadata = videoMetadata;
    }

    public Boolean getKilled() {
        return killed;
    }

    public void setKilled(Boolean killed) {
        this.killed = killed;
    }

    public int getKilledStatusCode() {
        return killedStatusCode;
    }

    public void setKilledStatusCode(int killedStatusCode) {
        this.killedStatusCode = killedStatusCode;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getSponsoredTitle() {
        return sponsoredTitle;
    }

    public void setSponsoredTitle(String sponsoredTitle) {
        this.sponsoredTitle = sponsoredTitle;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public String getJsonSourceUrl() {
        return jsonSourceUrl;
    }

    public void setJsonSourceUrl(String jsonSourceUrl) {
        this.jsonSourceUrl = jsonSourceUrl;
    }

    public int getHomePagePosition() {
        return homePagePosition;
    }

    public void setHomePagePosition(int homePagePosition) {
        this.homePagePosition = homePagePosition;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Boolean getDeveloping() {
        return developing;
    }

    public void setDeveloping(Boolean developing) {
        this.developing = developing;
    }

    public Boolean getInterview() {
        return interview;
    }

    public void setInterview(Boolean interview) {
        this.interview = interview;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Boolean getInDepth() {
        return inDepth;
    }

    public void setInDepth(Boolean inDepth) {
        this.inDepth = inDepth;
    }

    public Boolean getOpinion() {
        return opinion;
    }

    public void setOpinion(Boolean opinion) {
        this.opinion = opinion;
    }

    public Boolean getLatest() {
        return latest;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public Boolean getFactCheck() {
        return factCheck;
    }

    public void setFactCheck(Boolean factCheck) {
        this.factCheck = factCheck;
    }

    public Boolean getNotificationSent() {
        return notificationSent;
    }

    public void setNotificationSent(Boolean notificationSent) {
        this.notificationSent = notificationSent;
    }

    public List<Authors> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Authors> authorsList) {
        this.authorsList = authorsList;
    }

    public List<Object> getSectionSpecificDefaultTags() {
        return sectionSpecificDefaultTags;
    }

    public void setSectionSpecificDefaultTags(List<Object> sectionSpecificDefaultTags) {
        this.sectionSpecificDefaultTags = sectionSpecificDefaultTags;
    }

    public String getDeadLinkUrl() {
        return deadLinkUrl;
    }

    public void setDeadLinkUrl(String deadLinkUrl) {
        this.deadLinkUrl = deadLinkUrl;
    }

    public String getPrimaryLocation() {
        return primaryLocation;
    }

    public void setPrimaryLocation(String primaryLocation) {
        this.primaryLocation = primaryLocation;
    }

}
