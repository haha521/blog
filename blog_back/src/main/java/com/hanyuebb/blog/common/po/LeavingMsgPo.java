package com.hanyuebb.blog.common.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * ClassName:LeavingMsgPo
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/7 12:12
 * @auther:zh
 */

@Data
public class LeavingMsgPo {

    private String userNickName;

    private Integer msgId;


    private String type;


    private Integer userId;


    private Integer articleId;


    private Integer upperId;


    private Integer msgOrder;


    private String status;


    private Date insertTime;


    private Date updateTime;


    private String content;
}
