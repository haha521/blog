package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_blog_user")
public class TbBlogUser extends BaseDomain implements Serializable {
    /**
     * ?û?id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * ?û??˺
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * ?û????
     */
    private String password;

    /**
     * ?û??ǳ
     */
    @Column(name = "user_nick_name")
    private String userNickName;

    /**
     * ?Ա
     */
    private String gender;

    /**
     * ͷ??ͼƬ·??
     */
    @Column(name = "user_img_path")
    private String userImgPath;

    /**
     * ?û??
     */
    private String summary;

    /**
     * ???
     */
    private Integer age;

    /**
     * ?绰
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * ?ֻ??
     */
    private String moblie;

    /**
     * ???
     */
    private String email;

    /**
     * ??ַ
     */
    private String address;

    /**
     * ??ҵԺУ
     */
    @Column(name = "graduate_school")
    private String graduateSchool;

    /**
     * ѧ??
     */
    private String education;

    /**
     * ???????
     */
    private Date birtd;

    /**
     * ??ʵ????
     */
    @Column(name = "user_real_name")
    private String userRealName;

    /**
     * ?û????
     */
    @Column(name = "user_type")
    private String userType;

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
     * 获取?û?id
     *
     * @return user_id - ?û?id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置?û?id
     *
     * @param userId ?û?id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取?û????
     *
     * @return password - ?û????
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置?û????
     *
     * @param password ?û????
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取?û??ǳ
     *
     * @return user_nick_name - ?û??ǳ
     */
    public String getUserNickName() {
        return userNickName;
    }

    /**
     * 设置?û??ǳ
     *
     * @param userNickName ?û??ǳ
     */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    /**
     * 获取?Ա
     *
     * @return gender - ?Ա
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置?Ա
     *
     * @param gender ?Ա
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取ͷ??ͼƬ·??
     *
     * @return user_img_path - ͷ??ͼƬ·??
     */
    public String getUserImgPath() {
        return userImgPath;
    }

    /**
     * 设置ͷ??ͼƬ·??
     *
     * @param userImgPath ͷ??ͼƬ·??
     */
    public void setUserImgPath(String userImgPath) {
        this.userImgPath = userImgPath;
    }

    /**
     * 获取?û??
     *
     * @return summary - ?û??
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置?û??
     *
     * @param summary ?û??
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取???
     *
     * @return age - ???
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置???
     *
     * @param age ???
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取?绰
     *
     * @return phone_number - ?绰
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置?绰
     *
     * @param phoneNumber ?绰
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取?ֻ??
     *
     * @return moblie - ?ֻ??
     */
    public String getMoblie() {
        return moblie;
    }

    /**
     * 设置?ֻ??
     *
     * @param moblie ?ֻ??
     */
    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    /**
     * 获取???
     *
     * @return email - ???
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置???
     *
     * @param email ???
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取??ַ
     *
     * @return address - ??ַ
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置??ַ
     *
     * @param address ??ַ
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取??ҵԺУ
     *
     * @return graduate_school - ??ҵԺУ
     */
    public String getGraduateSchool() {
        return graduateSchool;
    }

    /**
     * 设置??ҵԺУ
     *
     * @param graduateSchool ??ҵԺУ
     */
    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    /**
     * 获取ѧ??
     *
     * @return education - ѧ??
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置ѧ??
     *
     * @param education ѧ??
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取???????
     *
     * @return birtd - ???????
     */
    public Date getBirtd() {
        return birtd;
    }

    /**
     * 设置???????
     *
     * @param birtd ???????
     */
    public void setBirtd(Date birtd) {
        this.birtd = birtd;
    }

    /**
     * 获取??ʵ????
     *
     * @return user_real_name - ??ʵ????
     */
    public String getUserRealName() {
        return userRealName;
    }

    /**
     * 设置??ʵ????
     *
     * @param userRealName ??ʵ????
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /**
     * 获取?û????
     *
     * @return user_type - ?û????
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置?û????
     *
     * @param userType ?û????
     */
    public void setUserType(String userType) {
        this.userType = userType;
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