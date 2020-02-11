package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_perm")
public class TbPerm extends BaseDomain {
    @Id
    @Column(name = "perm_id")
    private Integer permId;

    @Column(name = "perm_content")
    private String permContent;

    @Column(name = "insert_time")
    private Date insertTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return perm_content
     */
    public String getPermContent() {
        return permContent;
    }

    /**
     * @param permContent
     */
    public void setPermContent(String permContent) {
        this.permContent = permContent;
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