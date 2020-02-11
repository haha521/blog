package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_role_perm")
public class TbRolePerm extends BaseDomain {
    @Id
    @Column(name = "rp_id")
    private Integer rpId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "perm_id")
    private Integer permId;

    @Column(name = "insert_time")
    private Date insertTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return rp_id
     */
    public Integer getRpId() {
        return rpId;
    }

    /**
     * @param rpId
     */
    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return perm_id
     */
    public Integer getPermId() {
        return permId;
    }

    /**
     * @param permId
     */
    public void setPermId(Integer permId) {
        this.permId = permId;
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