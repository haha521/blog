package com.hanyuebb.blog.common.po;

import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbLeavingMsg;
import lombok.Data;

/**
 * ClassName:MsgDatePo
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/8 12:58
 * @auther:zh
 */

@Data
public class MsgDatePo {

    private ResultPage<LeavingMsgPo> msgPage;

    private String serverPath;
}
