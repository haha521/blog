package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_role")
public class TbRole extends BaseDomain {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_content")
    private String roleContent;

    @Column(name = "insert_time")
    private Date insertTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return role_content
     */
    public String getRoleContent() {
        return roleContent;
    }

    /**
     * @param roleContent
     */
    public void setRoleContent(String roleContent) {
        this.roleContent = roleContent;
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