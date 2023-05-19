package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlankPaperStoryData {

    @JsonIgnoreProperties("_id")
    private Id id;
    @SerializedName("elements")
    @Expose
    private List<Id> elements = null;
    @JsonIgnoreProperties("headline")
    private String headline;
    @JsonIgnoreProperties("summary")
    private String summary;
    @JsonIgnoreProperties("type")
    private String type;
    @JsonIgnoreProperties("mobileHeadline")
    private String mobileHeadline;
    @JsonIgnoreProperties("mobileAppNotificationHeadline")
    private String mobileAppNotificationHeadline;
    @JsonIgnoreProperties("browserNotificationHeadline")
    private String browserNotificationHeadline;
    @JsonIgnoreProperties("facebookHeadline")
    private String facebookHeadline;
    @JsonIgnoreProperties("twitterHeadline")
    private String twitterHeadline;
    @JsonIgnoreProperties("urlHeadline")
    private String urlHeadline;
    @JsonIgnoreProperties("leadMedia")
    private LeadMedia leadMedia;
    @JsonIgnoreProperties("oldUuid")
    private String oldUuid;
    @JsonIgnoreProperties("domainId")
    private String domainId;
    @JsonIgnoreProperties("title")
    private String title;
    @JsonIgnoreProperties("articleType")
    private String articleType;
    @JsonIgnoreProperties("createdBy")
    private String createdBy;
    @JsonIgnoreProperties("lastModifiedBy")
    private String lastModifiedBy;
    @JsonIgnoreProperties("lastModifiedDate")
    private LastModifiedDate lastModifiedDate;
    @JsonIgnoreProperties("lastPublishedBy")
    private String lastPublishedBy;
    @JsonIgnoreProperties("lastPublishedDate")
    private LastPublishedDate lastPublishedDate;
    @JsonIgnoreProperties("metadata")
    private Metadata metadata;
    @JsonIgnoreProperties("webId")
    private String webId;
    @JsonIgnoreProperties("webType")
    private String webType;
    @JsonIgnoreProperties("isDeleted")
    private Integer isDeleted;
   /* @JsonIgnoreProperties("elements")
    private List<Long> elements;*/
    @JsonIgnoreProperties("firstPublishedDate")
    private FirstPublishedDate firstPublishedDate;
    @JsonIgnoreProperties("listElement")
    private List<ListElement> listElement = null;
    @JsonIgnoreProperties("_class")
    private String _class;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("_id")
    public Id getId() {
        return id;
    }

    @JsonIgnoreProperties("_id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonIgnoreProperties("headline")
    public String getHeadline() {
        return headline;
    }

    @JsonIgnoreProperties("headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @JsonIgnoreProperties("summary")
    public String getSummary() {
        return summary;
    }

    @JsonIgnoreProperties("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonIgnoreProperties("type")
    public String getType() {
        return type;
    }

    @JsonIgnoreProperties("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnoreProperties("mobileHeadline")
    public String getMobileHeadline() {
        return mobileHeadline;
    }

    @JsonIgnoreProperties("mobileHeadline")
    public void setMobileHeadline(String mobileHeadline) {
        this.mobileHeadline = mobileHeadline;
    }

    @JsonIgnoreProperties("mobileAppNotificationHeadline")
    public String getMobileAppNotificationHeadline() {
        return mobileAppNotificationHeadline;
    }

    @JsonIgnoreProperties("mobileAppNotificationHeadline")
    public void setMobileAppNotificationHeadline(String mobileAppNotificationHeadline) {
        this.mobileAppNotificationHeadline = mobileAppNotificationHeadline;
    }

    @JsonIgnoreProperties("browserNotificationHeadline")
    public String getBrowserNotificationHeadline() {
        return browserNotificationHeadline;
    }

    @JsonIgnoreProperties("browserNotificationHeadline")
    public void setBrowserNotificationHeadline(String browserNotificationHeadline) {
        this.browserNotificationHeadline = browserNotificationHeadline;
    }

    @JsonIgnoreProperties("facebookHeadline")
    public String getFacebookHeadline() {
        return facebookHeadline;
    }

    @JsonIgnoreProperties("facebookHeadline")
    public void setFacebookHeadline(String facebookHeadline) {
        this.facebookHeadline = facebookHeadline;
    }

    @JsonIgnoreProperties("twitterHeadline")
    public String getTwitterHeadline() {
        return twitterHeadline;
    }

    @JsonIgnoreProperties("twitterHeadline")
    public void setTwitterHeadline(String twitterHeadline) {
        this.twitterHeadline = twitterHeadline;
    }

    @JsonIgnoreProperties("urlHeadline")
    public String getUrlHeadline() {
        return urlHeadline;
    }

    @JsonIgnoreProperties("urlHeadline")
    public void setUrlHeadline(String urlHeadline) {
        this.urlHeadline = urlHeadline;
    }

    @JsonIgnoreProperties("leadMedia")
    public LeadMedia getLeadMedia() {
        return leadMedia;
    }

    @JsonIgnoreProperties("leadMedia")
    public void setLeadMedia(LeadMedia leadMedia) {
        this.leadMedia = leadMedia;
    }

    @JsonIgnoreProperties("oldUuid")
    public String getOldUuid() {
        return oldUuid;
    }

    @JsonIgnoreProperties("oldUuid")
    public void setOldUuid(String oldUuid) {
        this.oldUuid = oldUuid;
    }

    @JsonIgnoreProperties("domainId")
    public String getDomainId() {
        return domainId;
    }

    @JsonIgnoreProperties("domainId")
    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    @JsonIgnoreProperties("title")
    public String getTitle() {
        return title;
    }

    @JsonIgnoreProperties("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnoreProperties("articleType")
    public String getArticleType() {
        return articleType;
    }

    @JsonIgnoreProperties("articleType")
    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    @JsonIgnoreProperties("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonIgnoreProperties("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonIgnoreProperties("lastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @JsonIgnoreProperties("lastModifiedBy")
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @JsonIgnoreProperties("lastModifiedDate")
    public LastModifiedDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    @JsonIgnoreProperties("lastModifiedDate")
    public void setLastModifiedDate(LastModifiedDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @JsonIgnoreProperties("lastPublishedBy")
    public String getLastPublishedBy() {
        return lastPublishedBy;
    }

    @JsonIgnoreProperties("lastPublishedBy")
    public void setLastPublishedBy(String lastPublishedBy) {
        this.lastPublishedBy = lastPublishedBy;
    }

    @JsonIgnoreProperties("lastPublishedDate")
    public LastPublishedDate getLastPublishedDate() {
        return lastPublishedDate;
    }

    @JsonIgnoreProperties("lastPublishedDate")
    public void setLastPublishedDate(LastPublishedDate lastPublishedDate) {
        this.lastPublishedDate = lastPublishedDate;
    }

    @JsonIgnoreProperties("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonIgnoreProperties("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonIgnoreProperties("webId")
    public String getWebId() {
        return webId;
    }

    public List<Id> getElements() {
        return elements;
    }

    @JsonIgnoreProperties("webId")
    public void setWebId(String webId) {
        this.webId = webId;
    }

    @JsonIgnoreProperties("webType")
    public String getWebType() {
        return webType;
    }

    @JsonIgnoreProperties("webType")
    public void setWebType(String webType) {
        this.webType = webType;
    }

    @JsonIgnoreProperties("isDeleted")
    public Integer getIsDeleted() {
        return isDeleted;
    }

    @JsonIgnoreProperties("isDeleted")
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /*@JsonIgnoreProperties("elements")
    public List<Long> getElements() {
        return elements;
    }

    @JsonIgnoreProperties("elements")
    public void setElements(List<ListElements> elements) {
        this.elements = elements;
    }*/

    @JsonIgnoreProperties("firstPublishedDate")
    public FirstPublishedDate getFirstPublishedDate() {
        return firstPublishedDate;
    }

    @JsonIgnoreProperties("firstPublishedDate")
    public void setFirstPublishedDate(FirstPublishedDate firstPublishedDate) {
        this.firstPublishedDate = firstPublishedDate;
    }

    @JsonIgnoreProperties("listElement")
    public List<ListElement> getListElement() {
        return listElement;
    }

    @JsonIgnoreProperties("listElement")
    public void setListElement(List<ListElement> listElement) {
        this.listElement = listElement;
    }

    @JsonIgnoreProperties("_class")
    public String getClass_() {
        return _class;
    }

    @JsonIgnoreProperties("_class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
