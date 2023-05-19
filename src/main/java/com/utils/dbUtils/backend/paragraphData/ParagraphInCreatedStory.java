package com.utils.dbUtils.backend.paragraphData;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.frontend.Id;
import com.utils.dbUtils.frontend.LastModifiedDate;

@Generated("jsonschema2pojo")
public class ParagraphInCreatedStory {

    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("paragraph")
    @Expose
    private Paragraph paragraph;
    @SerializedName("reusable")
    @Expose
    private boolean reusable;
    @SerializedName("parentElementId")
    @Expose
    private Id parentElementId;
    @SerializedName("lShapeBand")
    @Expose
    private boolean lShapeBand;
    @SerializedName("amazonMeta")
    @Expose
    private boolean amazonMeta;
    @SerializedName("domainId")
    @Expose
    private String domainId;
    @SerializedName("title")
    @Expose
    private String title;
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
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("isDeleted")
    @Expose
    private int isDeleted;
    @SerializedName("readByUsers")
    @Expose
    private List<String> readByUsers = null;
    @SerializedName("changesPublished")
    @Expose
    private boolean changesPublished;
    @SerializedName("suggest")
    @Expose
    private Suggest suggest;
    @SerializedName("softPublished")
    @Expose
    private boolean softPublished;
    @SerializedName("imageAmpValidated")
    @Expose
    private boolean imageAmpValidated;
    @SerializedName("lastRequestId")
    @Expose
    private String lastRequestId;
    @SerializedName("isAutoPublished")
    @Expose
    private boolean isAutoPublished;
    @SerializedName("collectionStoriesVersion")
    @Expose
    private Id collectionStoriesVersion;
    @SerializedName("topicMigrated")
    @Expose
    private boolean topicMigrated;
    @SerializedName("migrationInfoWebUrlMigrated")
    @Expose
    private boolean migrationInfoWebUrlMigrated;
    @SerializedName("topicPublished")
    @Expose
    private boolean topicPublished;
    @SerializedName("migrationInfoWebUrlPublished")
    @Expose
    private boolean migrationInfoWebUrlPublished;
    @SerializedName("companyChartAdded")
    @Expose
    private boolean companyChartAdded;
    @SerializedName("_class")
    @Expose
    private String _class;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public ParagraphInCreatedStory withId(Id id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParagraphInCreatedStory withName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ParagraphInCreatedStory withType(String type) {
        this.type = type;
        return this;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    public ParagraphInCreatedStory withParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
        return this;
    }

    public boolean isReusable() {
        return reusable;
    }

    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    public ParagraphInCreatedStory withReusable(boolean reusable) {
        this.reusable = reusable;
        return this;
    }

    public Id getParentElementId() {
        return parentElementId;
    }

    public void setParentElementId(Id parentElementId) {
        this.parentElementId = parentElementId;
    }

    public ParagraphInCreatedStory withParentElementId(Id parentElementId) {
        this.parentElementId = parentElementId;
        return this;
    }

    public boolean islShapeBand() {
        return lShapeBand;
    }

    public void setlShapeBand(boolean lShapeBand) {
        this.lShapeBand = lShapeBand;
    }

    public ParagraphInCreatedStory withlShapeBand(boolean lShapeBand) {
        this.lShapeBand = lShapeBand;
        return this;
    }

    public boolean isAmazonMeta() {
        return amazonMeta;
    }

    public void setAmazonMeta(boolean amazonMeta) {
        this.amazonMeta = amazonMeta;
    }

    public ParagraphInCreatedStory withAmazonMeta(boolean amazonMeta) {
        this.amazonMeta = amazonMeta;
        return this;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public ParagraphInCreatedStory withDomainId(String domainId) {
        this.domainId = domainId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ParagraphInCreatedStory withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public ParagraphInCreatedStory withArticleType(String articleType) {
        this.articleType = articleType;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ParagraphInCreatedStory withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LastModifiedDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LastModifiedDate createdDate) {
        this.createdDate = createdDate;
    }

    public ParagraphInCreatedStory withCreatedDate(LastModifiedDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public ParagraphInCreatedStory withLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public String getLastModifiedByUserName() {
        return lastModifiedByUserName;
    }

    public void setLastModifiedByUserName(String lastModifiedByUserName) {
        this.lastModifiedByUserName = lastModifiedByUserName;
    }

    public ParagraphInCreatedStory withLastModifiedByUserName(String lastModifiedByUserName) {
        this.lastModifiedByUserName = lastModifiedByUserName;
        return this;
    }

    public LastModifiedDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LastModifiedDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public ParagraphInCreatedStory withLastModifiedDate(LastModifiedDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ParagraphInCreatedStory withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public ParagraphInCreatedStory withSocial(Social social) {
        this.social = social;
        return this;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ParagraphInCreatedStory withIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public List<String> getReadByUsers() {
        return readByUsers;
    }

    public void setReadByUsers(List<String> readByUsers) {
        this.readByUsers = readByUsers;
    }

    public ParagraphInCreatedStory withReadByUsers(List<String> readByUsers) {
        this.readByUsers = readByUsers;
        return this;
    }

    public boolean isChangesPublished() {
        return changesPublished;
    }

    public void setChangesPublished(boolean changesPublished) {
        this.changesPublished = changesPublished;
    }

    public ParagraphInCreatedStory withChangesPublished(boolean changesPublished) {
        this.changesPublished = changesPublished;
        return this;
    }

    public Suggest getSuggest() {
        return suggest;
    }

    public void setSuggest(Suggest suggest) {
        this.suggest = suggest;
    }

    public ParagraphInCreatedStory withSuggest(Suggest suggest) {
        this.suggest = suggest;
        return this;
    }

    public boolean isSoftPublished() {
        return softPublished;
    }

    public void setSoftPublished(boolean softPublished) {
        this.softPublished = softPublished;
    }

    public ParagraphInCreatedStory withSoftPublished(boolean softPublished) {
        this.softPublished = softPublished;
        return this;
    }

    public boolean isImageAmpValidated() {
        return imageAmpValidated;
    }

    public void setImageAmpValidated(boolean imageAmpValidated) {
        this.imageAmpValidated = imageAmpValidated;
    }

    public ParagraphInCreatedStory withImageAmpValidated(boolean imageAmpValidated) {
        this.imageAmpValidated = imageAmpValidated;
        return this;
    }

    public String getLastRequestId() {
        return lastRequestId;
    }

    public void setLastRequestId(String lastRequestId) {
        this.lastRequestId = lastRequestId;
    }

    public ParagraphInCreatedStory withLastRequestId(String lastRequestId) {
        this.lastRequestId = lastRequestId;
        return this;
    }

    public boolean isIsAutoPublished() {
        return isAutoPublished;
    }

    public void setIsAutoPublished(boolean isAutoPublished) {
        this.isAutoPublished = isAutoPublished;
    }

    public ParagraphInCreatedStory withIsAutoPublished(boolean isAutoPublished) {
        this.isAutoPublished = isAutoPublished;
        return this;
    }

    public Id getCollectionStoriesVersion() {
        return collectionStoriesVersion;
    }

    public void setCollectionStoriesVersion(Id collectionStoriesVersion) {
        this.collectionStoriesVersion = collectionStoriesVersion;
    }

    public ParagraphInCreatedStory withCollectionStoriesVersion(Id collectionStoriesVersion) {
        this.collectionStoriesVersion = collectionStoriesVersion;
        return this;
    }

    public boolean isTopicMigrated() {
        return topicMigrated;
    }

    public void setTopicMigrated(boolean topicMigrated) {
        this.topicMigrated = topicMigrated;
    }

    public ParagraphInCreatedStory withTopicMigrated(boolean topicMigrated) {
        this.topicMigrated = topicMigrated;
        return this;
    }

    public boolean isMigrationInfoWebUrlMigrated() {
        return migrationInfoWebUrlMigrated;
    }

    public void setMigrationInfoWebUrlMigrated(boolean migrationInfoWebUrlMigrated) {
        this.migrationInfoWebUrlMigrated = migrationInfoWebUrlMigrated;
    }

    public ParagraphInCreatedStory withMigrationInfoWebUrlMigrated(boolean migrationInfoWebUrlMigrated) {
        this.migrationInfoWebUrlMigrated = migrationInfoWebUrlMigrated;
        return this;
    }

    public boolean isTopicPublished() {
        return topicPublished;
    }

    public void setTopicPublished(boolean topicPublished) {
        this.topicPublished = topicPublished;
    }

    public ParagraphInCreatedStory withTopicPublished(boolean topicPublished) {
        this.topicPublished = topicPublished;
        return this;
    }

    public boolean isMigrationInfoWebUrlPublished() {
        return migrationInfoWebUrlPublished;
    }

    public void setMigrationInfoWebUrlPublished(boolean migrationInfoWebUrlPublished) {
        this.migrationInfoWebUrlPublished = migrationInfoWebUrlPublished;
    }

    public ParagraphInCreatedStory withMigrationInfoWebUrlPublished(boolean migrationInfoWebUrlPublished) {
        this.migrationInfoWebUrlPublished = migrationInfoWebUrlPublished;
        return this;
    }

    public boolean isCompanyChartAdded() {
        return companyChartAdded;
    }

    public void setCompanyChartAdded(boolean companyChartAdded) {
        this.companyChartAdded = companyChartAdded;
    }

    public ParagraphInCreatedStory withCompanyChartAdded(boolean companyChartAdded) {
        this.companyChartAdded = companyChartAdded;
        return this;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public ParagraphInCreatedStory withClass(String _class) {
        this._class = _class;
        return this;
    }

}
