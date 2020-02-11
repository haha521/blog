package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_outer_link")
public class TbOuterLink extends BaseDomain {
    /**
     * ????id
     */
    @Id
    @Column(name = "link_id")
    private Integer linkId;

    /**
     * ???????
     */
    private String type;

    /**
     * ????
     */
    private String depict;

    /**
     * ???
     */
    private String link;

    /**
     * ˳?
     */
    private Integer sequence;

    /**
     * ????״̬
     */
    private String status;

    /**
     * ????ʱ?
     */
    @Column(name = "insert_time")
    private Date insertTime;

    /**
     * ????ʱ?
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取????id
     *
     * @return link_id - ????id
     */
    public Integer getLinkId() {
        return linkId;
    }

    /**
     * 设置????id
     *
     * @param linkId ????id
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
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
     * 获取????
     *
     * @return depict - ????
     */
    public String getDepict() {
        return depict;
    }

    /**
     * 设置????
     *
     * @param depict ????
     */
    public void setDepict(String depict) {
        this.depict = depict;
    }

    /**
     * 获取???
     *
     * @return link - ???
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置???
     *
     * @param link ???
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取˳?
     *
     * @return sequence - ˳?
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置˳?
     *
     * @param sequence ˳?
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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