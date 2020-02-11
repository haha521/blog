package com.hanyuebb.blog.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article")
public class TbArticle extends BaseDomain {
    /**
     * ????id
     */
    @Id
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * ģ?
     */
    private String module;

    /**
     * ???????
     */
    private String type;

    /**
     * ???ࣨ???壩
     */
    private String classify;

    /**
     * ???
     */
    private String title;

    /**
     * ???
     */
    private String author;

    /**
     * ???ߣ??û???id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * ?ؼ??
     */
    @Column(name = "rux_words")
    private String ruxWords;

    /**
     * ?
     */
    private String summary;

    /**
     * ?ĵ??༭?????
     */
    @Column(name = "word_type")
    private String wordType;

    /**
     * ???µ?״̬
     */
    @Column(name = "art_state")
    private String artState;

    /**
     * ͼƬ·??
     */
    @Column(name = "art_img_path")
    private String artImgPath;

    /**
     * ϲ??????
     */
    private Integer likes;

    /**
     * ????????
     */
    private Integer views;

    /**
     * ????????
     */
    private Integer commons;

    /**
     * ????״̬
     */
    private String status;


    private Integer year;


    private Integer month;

    private Integer day;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * ????ʱ?
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "insert_time")
    private Date insertTime;

    /**
     * ????ʱ?
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * ????(html??ʽ)
     */
    private String content;

    /**
     * ?ĵ?????(?༭???е?ԭ??ʽ)
     */
    @Column(name = "word_content")
    private String wordContent;

    /**
     * 获取????id
     *
     * @return article_id - ????id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置????id
     *
     * @param articleId ????id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取ģ?
     *
     * @return module - ģ?
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置ģ?
     *
     * @param module ģ?
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * 获取???????
     *
     * @return type - ???????
     */
    public String getType() {
        return type;
    }

    /**
     * 设置???????
     *
     * @param type ???????
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取???ࣨ???壩
     *
     * @return classify - ???ࣨ???壩
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 设置???ࣨ???壩
     *
     * @param classify ???ࣨ???壩
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * 获取???
     *
     * @return title - ???
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置???
     *
     * @param title ???
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取???
     *
     * @return author - ???
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置???
     *
     * @param author ???
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取???ߣ??û???id
     *
     * @return user_id - ???ߣ??û???id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置???ߣ??û???id
     *
     * @param userId ???ߣ??û???id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取?ؼ??
     *
     * @return rux_words - ?ؼ??
     */
    public String getRuxWords() {
        return ruxWords;
    }

    /**
     * 设置?ؼ??
     *
     * @param ruxWords ?ؼ??
     */
    public void setRuxWords(String ruxWords) {
        this.ruxWords = ruxWords;
    }

    /**
     * 获取?
     *
     * @return summary - ?
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置?
     *
     * @param summary ?
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取?ĵ??༭?????
     *
     * @return word_type - ?ĵ??༭?????
     */
    public String getWordType() {
        return wordType;
    }

    /**
     * 设置?ĵ??༭?????
     *
     * @param wordType ?ĵ??༭?????
     */
    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    /**
     * 获取???µ?״̬
     *
     * @return art_state - ???µ?״̬
     */
    public String getArtState() {
        return artState;
    }

    /**
     * 设置???µ?״̬
     *
     * @param artState ???µ?״̬
     */
    public void setArtState(String artState) {
        this.artState = artState;
    }

    /**
     * 获取ͼƬ·??
     *
     * @return art_img_path - ͼƬ·??
     */
    public String getArtImgPath() {
        return artImgPath;
    }

    /**
     * 设置ͼƬ·??
     *
     * @param artImgPath ͼƬ·??
     */
    public void setArtImgPath(String artImgPath) {
        this.artImgPath = artImgPath;
    }

    /**
     * 获取ϲ??????
     *
     * @return likes - ϲ??????
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * 设置ϲ??????
     *
     * @param likes ϲ??????
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * 获取????????
     *
     * @return views - ????????
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 设置????????
     *
     * @param views ????????
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取????????
     *
     * @return commons - ????????
     */
    public Integer getCommons() {
        return commons;
    }

    /**
     * 设置????????
     *
     * @param commons ????????
     */
    public void setCommons(Integer commons) {
        this.commons = commons;
    }

    /**
     * 获取????״̬
     *
     * @return status - ????״̬
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置????״̬
     *
     * @param status ????״̬
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取????ʱ?
     *
     * @return insert_time - ????ʱ?
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置????ʱ?
     *
     * @param insertTime ????ʱ?
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 获取????ʱ?
     *
     * @return update_time - ????ʱ?
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置????ʱ?
     *
     * @param updateTime ????ʱ?
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取????(html??ʽ)
     *
     * @return content - ????(html??ʽ)
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置????(html??ʽ)
     *
     * @param content ????(html??ʽ)
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取?ĵ?????(?༭???е?ԭ??ʽ)
     *
     * @return word_content - ?ĵ?????(?༭???е?ԭ??ʽ)
     */
    public String getWordContent() {
        return wordContent;
    }

    /**
     * 设置?ĵ?????(?༭???е?ԭ??ʽ)
     *
     * @param wordContent ?ĵ?????(?༭???е?ԭ??ʽ)
     */
    public void setWordContent(String wordContent) {
        this.wordContent = wordContent;
    }
}