/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *
 * @author 
 */
public class Tags {
    
    private int id;
    private String tagName;
    private String tagCode;
    private String relatedTag;

    public Tags(String tagName, String tagCode, String relatedTag) {
        this.tagName = tagName;
        this.tagCode = tagCode;
        this.relatedTag = relatedTag;
    }

    public Tags(int id, String tagName, String tagCode, String relatedTag) {
        this.id = id;
        this.tagName = tagName;
        this.tagCode = tagCode;
        this.relatedTag = relatedTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tags() {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getRelatedTag() {
        return relatedTag;
    }

    public void setRelatedTag(String relatedTag) {
        this.relatedTag = relatedTag;
    }
    
}
