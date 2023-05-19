package com.utils.dbUtils.backend.paragraphData;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Metadata {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("authors")
    @Expose
    private List<Object> authors = null;
    @SerializedName("syllableCount")
    @Expose
    private int syllableCount;
    @SerializedName("charCount")
    @Expose
    private int charCount;
    @SerializedName("wordCount")
    @Expose
    private int wordCount;
    @SerializedName("sentenceCount")
    @Expose
    private int sentenceCount;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("topic")
    @Expose
    private List<Object> topic = null;
    @SerializedName("alternateSection")
    @Expose
    private List<Object> alternateSection = null;
    @SerializedName("location")
    @Expose
    private List<Object> location = null;
    @SerializedName("markUnimportant")
    @Expose
    private boolean markUnimportant;
    @SerializedName("breakingNews")
    @Expose
    private boolean breakingNews;
    @SerializedName("sponsored")
    @Expose
    private boolean sponsored;
    @SerializedName("syndicationFeed")
    @Expose
    private boolean syndicationFeed;
    @SerializedName("premiumStory")
    @Expose
    private boolean premiumStory;
    @SerializedName("editedBy")
    @Expose
    private List<Object> editedBy = null;
    @SerializedName("writtenBy")
    @Expose
    private List<Object> writtenBy = null;
    @SerializedName("reportedBy")
    @Expose
    private List<Object> reportedBy = null;
    @SerializedName("agencyByLine")
    @Expose
    private List<Object> agencyByLine = null;
    @SerializedName("bigStory")
    @Expose
    private boolean bigStory;
    @SerializedName("killed")
    @Expose
    private boolean killed;
    @SerializedName("killedStatusCode")
    @Expose
    private int killedStatusCode;
    @SerializedName("sponsoredTitle")
    @Expose
    private String sponsoredTitle;
    @SerializedName("homePagePosition")
    @Expose
    private int homePagePosition;
    @SerializedName("live")
    @Expose
    private boolean live;
    @SerializedName("developing")
    @Expose
    private boolean developing;
    @SerializedName("interview")
    @Expose
    private boolean interview;
    @SerializedName("exclusive")
    @Expose
    private boolean exclusive;
    @SerializedName("inDepth")
    @Expose
    private boolean inDepth;
    @SerializedName("opinion")
    @Expose
    private boolean opinion;
    @SerializedName("latest")
    @Expose
    private boolean latest;
    @SerializedName("factCheck")
    @Expose
    private boolean factCheck;
    @SerializedName("notificationSent")
    @Expose
    private boolean notificationSent;
    @SerializedName("sectionSpecificDefaultTags")
    @Expose
    private List<Object> sectionSpecificDefaultTags = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Metadata withUrl(String url) {
        this.url = url;
        return this;
    }

    public List<Object> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Object> authors) {
        this.authors = authors;
    }

    public Metadata withAuthors(List<Object> authors) {
        this.authors = authors;
        return this;
    }

    public int getSyllableCount() {
        return syllableCount;
    }

    public void setSyllableCount(int syllableCount) {
        this.syllableCount = syllableCount;
    }

    public Metadata withSyllableCount(int syllableCount) {
        this.syllableCount = syllableCount;
        return this;
    }

    public int getCharCount() {
        return charCount;
    }

    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    public Metadata withCharCount(int charCount) {
        this.charCount = charCount;
        return this;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public Metadata withWordCount(int wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public Metadata withSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Metadata withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Metadata withTags(List<Object> tags) {
        this.tags = tags;
        return this;
    }

    public List<Object> getTopic() {
        return topic;
    }

    public void setTopic(List<Object> topic) {
        this.topic = topic;
    }

    public Metadata withTopic(List<Object> topic) {
        this.topic = topic;
        return this;
    }

    public List<Object> getAlternateSection() {
        return alternateSection;
    }

    public void setAlternateSection(List<Object> alternateSection) {
        this.alternateSection = alternateSection;
    }

    public Metadata withAlternateSection(List<Object> alternateSection) {
        this.alternateSection = alternateSection;
        return this;
    }

    public List<Object> getLocation() {
        return location;
    }

    public void setLocation(List<Object> location) {
        this.location = location;
    }

    public Metadata withLocation(List<Object> location) {
        this.location = location;
        return this;
    }

    public boolean isMarkUnimportant() {
        return markUnimportant;
    }

    public void setMarkUnimportant(boolean markUnimportant) {
        this.markUnimportant = markUnimportant;
    }

    public Metadata withMarkUnimportant(boolean markUnimportant) {
        this.markUnimportant = markUnimportant;
        return this;
    }

    public boolean isBreakingNews() {
        return breakingNews;
    }

    public void setBreakingNews(boolean breakingNews) {
        this.breakingNews = breakingNews;
    }

    public Metadata withBreakingNews(boolean breakingNews) {
        this.breakingNews = breakingNews;
        return this;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Metadata withSponsored(boolean sponsored) {
        this.sponsored = sponsored;
        return this;
    }

    public boolean isSyndicationFeed() {
        return syndicationFeed;
    }

    public void setSyndicationFeed(boolean syndicationFeed) {
        this.syndicationFeed = syndicationFeed;
    }

    public Metadata withSyndicationFeed(boolean syndicationFeed) {
        this.syndicationFeed = syndicationFeed;
        return this;
    }

    public boolean isPremiumStory() {
        return premiumStory;
    }

    public void setPremiumStory(boolean premiumStory) {
        this.premiumStory = premiumStory;
    }

    public Metadata withPremiumStory(boolean premiumStory) {
        this.premiumStory = premiumStory;
        return this;
    }

    public List<Object> getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(List<Object> editedBy) {
        this.editedBy = editedBy;
    }

    public Metadata withEditedBy(List<Object> editedBy) {
        this.editedBy = editedBy;
        return this;
    }

    public List<Object> getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(List<Object> writtenBy) {
        this.writtenBy = writtenBy;
    }

    public Metadata withWrittenBy(List<Object> writtenBy) {
        this.writtenBy = writtenBy;
        return this;
    }

    public List<Object> getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(List<Object> reportedBy) {
        this.reportedBy = reportedBy;
    }

    public Metadata withReportedBy(List<Object> reportedBy) {
        this.reportedBy = reportedBy;
        return this;
    }

    public List<Object> getAgencyByLine() {
        return agencyByLine;
    }

    public void setAgencyByLine(List<Object> agencyByLine) {
        this.agencyByLine = agencyByLine;
    }

    public Metadata withAgencyByLine(List<Object> agencyByLine) {
        this.agencyByLine = agencyByLine;
        return this;
    }

    public boolean isBigStory() {
        return bigStory;
    }

    public void setBigStory(boolean bigStory) {
        this.bigStory = bigStory;
    }

    public Metadata withBigStory(boolean bigStory) {
        this.bigStory = bigStory;
        return this;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public Metadata withKilled(boolean killed) {
        this.killed = killed;
        return this;
    }

    public int getKilledStatusCode() {
        return killedStatusCode;
    }

    public void setKilledStatusCode(int killedStatusCode) {
        this.killedStatusCode = killedStatusCode;
    }

    public Metadata withKilledStatusCode(int killedStatusCode) {
        this.killedStatusCode = killedStatusCode;
        return this;
    }

    public String getSponsoredTitle() {
        return sponsoredTitle;
    }

    public void setSponsoredTitle(String sponsoredTitle) {
        this.sponsoredTitle = sponsoredTitle;
    }

    public Metadata withSponsoredTitle(String sponsoredTitle) {
        this.sponsoredTitle = sponsoredTitle;
        return this;
    }

    public int getHomePagePosition() {
        return homePagePosition;
    }

    public void setHomePagePosition(int homePagePosition) {
        this.homePagePosition = homePagePosition;
    }

    public Metadata withHomePagePosition(int homePagePosition) {
        this.homePagePosition = homePagePosition;
        return this;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Metadata withLive(boolean live) {
        this.live = live;
        return this;
    }

    public boolean isDeveloping() {
        return developing;
    }

    public void setDeveloping(boolean developing) {
        this.developing = developing;
    }

    public Metadata withDeveloping(boolean developing) {
        this.developing = developing;
        return this;
    }

    public boolean isInterview() {
        return interview;
    }

    public void setInterview(boolean interview) {
        this.interview = interview;
    }

    public Metadata withInterview(boolean interview) {
        this.interview = interview;
        return this;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Metadata withExclusive(boolean exclusive) {
        this.exclusive = exclusive;
        return this;
    }

    public boolean isInDepth() {
        return inDepth;
    }

    public void setInDepth(boolean inDepth) {
        this.inDepth = inDepth;
    }

    public Metadata withInDepth(boolean inDepth) {
        this.inDepth = inDepth;
        return this;
    }

    public boolean isOpinion() {
        return opinion;
    }

    public void setOpinion(boolean opinion) {
        this.opinion = opinion;
    }

    public Metadata withOpinion(boolean opinion) {
        this.opinion = opinion;
        return this;
    }

    public boolean isLatest() {
        return latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    public Metadata withLatest(boolean latest) {
        this.latest = latest;
        return this;
    }

    public boolean isFactCheck() {
        return factCheck;
    }

    public void setFactCheck(boolean factCheck) {
        this.factCheck = factCheck;
    }

    public Metadata withFactCheck(boolean factCheck) {
        this.factCheck = factCheck;
        return this;
    }

    public boolean isNotificationSent() {
        return notificationSent;
    }

    public void setNotificationSent(boolean notificationSent) {
        this.notificationSent = notificationSent;
    }

    public Metadata withNotificationSent(boolean notificationSent) {
        this.notificationSent = notificationSent;
        return this;
    }

    public List<Object> getSectionSpecificDefaultTags() {
        return sectionSpecificDefaultTags;
    }

    public void setSectionSpecificDefaultTags(List<Object> sectionSpecificDefaultTags) {
        this.sectionSpecificDefaultTags = sectionSpecificDefaultTags;
    }

    public Metadata withSectionSpecificDefaultTags(List<Object> sectionSpecificDefaultTags) {
        this.sectionSpecificDefaultTags = sectionSpecificDefaultTags;
        return this;
    }

}