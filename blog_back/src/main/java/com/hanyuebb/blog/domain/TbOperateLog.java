package com.hanyuebb.blog.domain;

import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_operate_log")
public class TbOperateLog extends BaseDomain {
    /**
     * ????id
     */
    @Id
    @Column(name = "log_id")
    private Integer logId;

    /**
     * ??????(?û?)id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * ????????Ip
     */
    @Column(name = "operate_ip")
    private String operateIp;

    /**
     * ???????
     */
    @Column(name = "operate_type")
    private String operateType;

    /**
     * ????????
     */
    @Column(name = "operate_desc")
    private String operateDesc;

    /**
     * ??????ַ
     */
    @Column(name = "request_url")
    private String requestUrl;

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
     * ????????
     */
    @Column(name = "request_params")
    private String requestParams;

    /**
     * 获取????id
     *
     * @return log_id - ????id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置????id
     *
     * @param logId ????id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取??????(?û?)id
     *
     * @return operator_id - ??????(?û?)id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置??????(?û?)id
     *
     * @param operatorId ??????(?û?)id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取????????Ip
     *
     * @return operate_ip - ????????Ip
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置????????Ip
     *
     * @param operateIp ????????Ip
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * 获取???????
     *
     * @return operate_type - ???????
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * 设置???????
     *
     * @param operateType ???????
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    /**
     * 获取????????
     *
     * @return operate_desc - ????????
     */
    public String getOperateDesc() {
        return operateDesc;
    }

    /**
     * 设置????????
     *
     * @param operateDesc ????????
     */
    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    /**
     * 获取??????ַ
     *
     * @return request_url - ??????ַ
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 设置??????ַ
     *
     * @param requestUrl ??????ַ
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
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
     * 获取????????
     *
     * @return request_params - ????????
     */
    public String getRequestParams() {
        return requestParams;
    }

    /**
     * 设置????????
     *
     * @param requestParams ????????
     */
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }
}