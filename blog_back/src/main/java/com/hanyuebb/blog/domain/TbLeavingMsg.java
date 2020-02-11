package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_leaving_msg")
public class TbLeavingMsg extends BaseDomain {
    /**
     * ????id
     */
    @Id
    @Column(name = "msg_id")
    private Integer msgId;

    /**
     * ???????
     */
    private String type;

    /**
     * ?????û?id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * ????????id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * ???Ը???id
     */
    @Column(name = "upper_id")
    private Integer upperId;

    /**
     * ????˳??????Ϊ?Ӽ???
     */
    @Column(name = "msg_order")
    private Integer msgOrder;

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
     * ???????
     */
    private String content;

    /**
     * 获取????id
     *
     * @return msg_id - ????id
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * 设置????id
     *
     * @param msgId ????id
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
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
     * 获取?????û?id
     *
     * @return user_id - ?????û?id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置?????û?id
     *
     * @param userId ?????û?id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取????????id
     *
     * @return article_id - ????????id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置????????id
     *
     * @param articleId ????????id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取???Ը???id
     *
     * @return upper_id - ???Ը???id
     */
    public Integer getUpperId() {
        return upperId;
    }

    /**
     * 设置???Ը???id
     *
     * @param upperId ???Ը???id
     */
    public void setUpperId(Integer upperId) {
        this.upperId = upperId;
    }

    /**
     * 获取????˳??????Ϊ?Ӽ???
     *
     * @return msg_order - ????˳??????Ϊ?Ӽ???
     */
    public Integer getMsgOrder() {
        return msgOrder;
    }

    /**
     * 设置????˳??????Ϊ?Ӽ???
     *
     * @param msgOrder ????˳??????Ϊ?Ӽ???
     */
    public void setMsgOrder(Integer msgOrder) {
        this.msgOrder = msgOrder;
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
     * 获取???????
     *
     * @return content - ???????
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置???????
     *
     * @param content ???????
     */
    public void setContent(String content) {
        this.content = content;
    }
}