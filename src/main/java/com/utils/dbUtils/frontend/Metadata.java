package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Metadata {

    @JsonIgnoreProperties("url")
    private String url;
    @JsonIgnoreProperties("authorsList")
    private List<Authors> authorsList = null;
    @JsonIgnoreProperties("charCount")
    private Integer charCount;
    @JsonIgnoreProperties("wordCount")
    private Integer wordCount;
    @JsonIgnoreProperties("agency")
    private String agency;
    @JsonIgnoreProperties("status")
    private String status;
    @JsonIgnoreProperties("tags")
    private List<String> tags = null;
    @JsonIgnoreProperties("keywords")
    private List<String> keywords = null;
    @JsonIgnoreProperties("section")
    private String section;
    @JsonIgnoreProperties("subSection")
    private String subSection;
    @JsonIgnoreProperties("location")
    private List<String> location = null;
    @JsonIgnoreProperties("authors")
    private List<String> authors = null;
    @JsonIgnoreProperties("markUnimportant")
    private Boolean markUnimportant;
    @JsonIgnoreProperties("breakingNews")
    private Boolean breakingNews;
    @JsonIgnoreProperties("sponsored")
    private Boolean sponsored;
    @JsonIgnoreProperties("syndicationFeed")
    private Boolean syndicationFeed;
    @JsonIgnoreProperties("canonicalUrl")
    private String canonicalUrl;
    @JsonIgnoreProperties("old_author")
    private String oldAuthor;
    @JsonIgnoreProperties("topic")
    private List<String> topic = null;

    @JsonIgnoreProperties("primaryLocation")
    private String primaryLocation;

    @JsonIgnoreProperties("url")
    public String getUrl() {
        return url;
    }

    @JsonIgnoreProperties("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnoreProperties("authorsList")
    public List<Authors> getAuthorsList() {
        return authorsList;
    }

    @JsonIgnoreProperties("authorsList")
    public void setAuthorsList(List<Authors> authorsList) {
        this.authorsList = authorsList;
    }

    @JsonIgnoreProperties("charCount")
    public Integer getCharCount() {
        return charCount;
    }

    @JsonIgnoreProperties("charCount")
    public void setCharCount(Integer charCount) {
        this.charCount = charCount;
    }

    @JsonIgnoreProperties("wordCount")
    public Integer getWordCount() {
        return wordCount;
    }

    @JsonIgnoreProperties("wordCount")
    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    @JsonIgnoreProperties("agency")
    public String getAgency() {
        return agency;
    }

    @JsonIgnoreProperties("agency")
    public void setAgency(String agency) {
        this.agency = agency;
    }

    @JsonIgnoreProperties("status")
    public String getStatus() {
        return status;
    }

    @JsonIgnoreProperties("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnoreProperties("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonIgnoreProperties("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonIgnoreProperties("keywords")
    public List<String> getKeywords() {
        return keywords;
    }

    @JsonIgnoreProperties("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @JsonIgnoreProperties("section")
    public String getSection() {
        return section;
    }

    @JsonIgnoreProperties("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonIgnoreProperties("subSection")
    public String getSubSection() {
        return subSection;
    }

    @JsonIgnoreProperties("subSection")
    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    @JsonIgnoreProperties("location")
    public List<String> getLocation() {
        return location;
    }

    @JsonIgnoreProperties("location")
    public void setLocation(List<String> location) {
        this.location = location;
    }

    @JsonIgnoreProperties("authors")
    public List<String> getAuthors() {
        return authors;
    }

    @JsonIgnoreProperties("authors")
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }


    @JsonIgnoreProperties("markUnimportant")
    public Boolean getMarkUnimportant() {
        return markUnimportant;
    }

    @JsonIgnoreProperties("markUnimportant")
    public void setMarkUnimportant(Boolean markUnimportant) {
        this.markUnimportant = markUnimportant;
    }

    @JsonIgnoreProperties("breakingNews")
    public Boolean getBreakingNews() {
        return breakingNews;
    }

    @JsonIgnoreProperties("breakingNews")
    public void setBreakingNews(Boolean breakingNews) {
        this.breakingNews = breakingNews;
    }

    @JsonIgnoreProperties("sponsored")
    public Boolean getSponsored() {
        return sponsored;
    }

    @JsonIgnoreProperties("sponsored")
    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    @JsonIgnoreProperties("syndicationFeed")
    public Boolean getSyndicationFeed() {
        return syndicationFeed;
    }

    @JsonIgnoreProperties("syndicationFeed")
    public void setSyndicationFeed(Boolean syndicationFeed) {
        this.syndicationFeed = syndicationFeed;
    }

    @JsonIgnoreProperties("canonicalUrl")
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    @JsonIgnoreProperties("canonicalUrl")
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @JsonIgnoreProperties("old_author")
    public String getOldAuthor() {
        return oldAuthor;
    }

    @JsonIgnoreProperties("old_author")
    public void setOldAuthor(String oldAuthor) {
        this.oldAuthor = oldAuthor;
    }

    @JsonIgnoreProperties("topic")
    public List<String> getTopic() {
        return topic;
    }

    @JsonIgnoreProperties("topic")
    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public String getPrimaryLocation() {
        return primaryLocation;
    }

    public void setPrimaryLocation(String primaryLocation) {
        this.primaryLocation = primaryLocation;
    }

}