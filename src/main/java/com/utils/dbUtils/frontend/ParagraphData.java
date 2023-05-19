
package com.utils.dbUtils.frontend;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ParagraphData {

    @SerializedName("_id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("paragraph")
    @Expose
    private Paragraph__1 paragraph;
    @SerializedName("reusable")
    @Expose
    private Boolean reusable;
    @SerializedName("parentElementId")
    @Expose
    private Long parentElementId;
    @SerializedName("lShapeBand")
    @Expose
    private Boolean lShapeBand;
    @SerializedName("amazonMeta")
    @Expose
    private Boolean amazonMeta;
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
    private String createdDate;
    @SerializedName("lastModifiedBy")
    @Expose
    private String lastModifiedBy;
    @SerializedName("lastModifiedByUserName")
    @Expose
    private String lastModifiedByUserName;
    @SerializedName("lastModifiedDate")
    @Expose
    private String lastModifiedDate;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("isDeleted")
    @Expose
    private Long isDeleted;
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
    private Long collectionStoriesVersion;
    @SerializedName("topicMigrated")
    @Expose
    private Boolean topicMigrated;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Paragraph__1 getParagraph() {
        return paragraph;
    }

    public void setParagraph(Paragraph__1 paragraph) {
        this.paragraph = paragraph;
    }

    public Boolean getReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }

    public Long getParentElementId() {
        return parentElementId;
    }

    public void setParentElementId(Long parentElementId) {
        this.parentElementId = parentElementId;
    }

    public Boolean getlShapeBand() {
        return lShapeBand;
    }

    public void setlShapeBand(Boolean lShapeBand) {
        this.lShapeBand = lShapeBand;
    }

    public Boolean getAmazonMeta() {
        return amazonMeta;
    }

    public void setAmazonMeta(Boolean amazonMeta) {
        this.amazonMeta = amazonMeta;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
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

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
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

    public Long getCollectionStoriesVersion() {
        return collectionStoriesVersion;
    }

    public void setCollectionStoriesVersion(Long collectionStoriesVersion) {
        this.collectionStoriesVersion = collectionStoriesVersion;
    }

    public Boolean getTopicMigrated() {
        return topicMigrated;
    }

    public void setTopicMigrated(Boolean topicMigrated) {
        this.topicMigrated = topicMigrated;
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