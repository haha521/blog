package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_role")
public class TbUserRole extends BaseDomain {
    @Id
    @Column(name = "ur_id")
    private Integer urId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "insert_time")
    private Date insertTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return ur_id
     */
    public Integer getUrId() {
        return urId;
    }

    /**
     * @param urId
     */
    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return insert_time
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}