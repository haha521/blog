package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_todo")
public class TbTodo extends BaseDomain {
    /**
     * ????
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ???
     */
    private String type;

    /**
     * ???
     */
    private String title;

    /**
     * ????
     */
    private String depict;

    /**
     * ״̬
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
     * 获取????
     *
     * @return id - ????
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置????
     *
     * @param id ????
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取???
     *
     * @return type - ???
     */
    public String getType() {
        return type;
    }

    /**
     * 设置???
     *
     * @param type ???
     */
    public void setType(String type) {
        this.type = type;
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
     * 获取״̬
     *
     * @return status - ״̬
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置״̬
     *
     * @param status ״̬
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