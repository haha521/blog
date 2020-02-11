package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_upload_file")
public class TbUploadFile extends BaseDomain {
    /**
     * ????id
     */
    @Id
    @Column(name = "path_id")
    private Integer pathId;

    /**
     * ???????
     */
    private String type;

    /**
     * ???ࣨ???壩
     */
    private String classify;

    /**
     * ͼƬ??
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * ͼƬ?
     */
    private String suffix;

    /**
     * ͼƬ·??
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * ˳?
     */
    private Integer sequence;

    /**
     * ?????ˣ??û???id
     */
    @Column(name = "user_id")
    private Integer userId;

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
     * @return path_id - ????id
     */
    public Integer getPathId() {
        return pathId;
    }

    /**
     * 设置????id
     *
     * @param pathId ????id
     */
    public void setPathId(Integer pathId) {
        this.pathId = pathId;
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
     * 获取ͼƬ??
     *
     * @return file_name - ͼƬ??
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置ͼƬ??
     *
     * @param fileName ͼƬ??
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取ͼƬ?
     *
     * @return suffix - ͼƬ?
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置ͼƬ?
     *
     * @param suffix ͼƬ?
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 获取ͼƬ·??
     *
     * @return img_path - ͼƬ·??
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 设置ͼƬ·??
     *
     * @param imgPath ͼƬ·??
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
     * 获取?????ˣ??û???id
     *
     * @return user_id - ?????ˣ??û???id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置?????ˣ??û???id
     *
     * @param userId ?????ˣ??û???id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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