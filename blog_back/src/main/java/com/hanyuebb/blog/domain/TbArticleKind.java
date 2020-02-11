package com.hanyuebb.blog.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article_kind")
public class TbArticleKind extends BaseDomain {
    /**
     * ????id
     */
    @Id
    @Column(name = "art_kinds_id")
    private Integer artKindsId;

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
     * ????????
     */
    private Integer sum;

    /**
     * ????״̬
     */
    private String status;

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
     * 获取????id
     *
     * @return art_kinds_id - ????id
     */
    public Integer getArtKindsId() {
        return artKindsId;
    }

    /**
     * 设置????id
     *
     * @param artKindsId ????id
     */
    public void setArtKindsId(Integer artKindsId) {
        this.artKindsId = artKindsId;
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
     * 获取????????
     *
     * @return sum - ????????
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * 设置????????
     *
     * @param sum ????????
     */
    public void setSum(Integer sum) {
        this.sum = sum;
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
}