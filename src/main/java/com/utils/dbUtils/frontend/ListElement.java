package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListElement {

    @JsonIgnoreProperties("name")
    private String name;
    @JsonIgnoreProperties("type")
    private String type;
    @JsonIgnoreProperties("paragraph")
    private Paragraph paragraph;
    @JsonIgnoreProperties("parentElementId")
    private ParentElementId parentElementId;
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
    @JsonIgnoreProperties("lastPublishedBy")
    private String lastPublishedBy;
    @JsonIgnoreProperties("webId")
    private String webId;
    @JsonIgnoreProperties("isDeleted")
    private Integer isDeleted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("name")
    public String getName() {
        return name;
    }

    @JsonIgnoreProperties("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnoreProperties("type")
    public String getType() {
        return type;
    }

    @JsonIgnoreProperties("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnoreProperties("paragraph")
    public Paragraph getParagraph() {
        return paragraph;
    }

    @JsonIgnoreProperties("paragraph")
    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    @JsonIgnoreProperties("parentElementId")
    public ParentElementId getParentElementId() {
        return parentElementId;
    }

    @JsonIgnoreProperties("parentElementId")
    public void setParentElementId(ParentElementId parentElementId) {
        this.parentElementId = parentElementId;
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

    @JsonIgnoreProperties("lastPublishedBy")
    public String getLastPublishedBy() {
        return lastPublishedBy;
    }

    @JsonIgnoreProperties("lastPublishedBy")
    public void setLastPublishedBy(String lastPublishedBy) {
        this.lastPublishedBy = lastPublishedBy;
    }

    @JsonIgnoreProperties("webId")
    public String getWebId() {
        return webId;
    }

    @JsonIgnoreProperties("webId")
    public void setWebId(String webId) {
        this.webId = webId;
    }

    @JsonIgnoreProperties("isDeleted")
    public Integer getIsDeleted() {
        return isDeleted;
    }

    @JsonIgnoreProperties("isDeleted")
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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