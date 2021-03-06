package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbLeavingMsg;
import com.hanyuebb.blog.exmapper.ExTbLeavingMsgMapper;
import com.hanyuebb.blog.mapper.TbLeavingMsgMapper;
import com.hanyuebb.blog.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:MsgServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:58
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class MsgServiceImpl extends BaseServiceImpl<TbLeavingMsg, TbLeavingMsgMapper> implements MsgService<TbLeavingMsg> {

    @Autowired
    ExTbLeavingMsgMapper exTbLeavingMsgMapper;

    @Override
    public List<TbLeavingMsg> selectMsg() {
        return exTbLeavingMsgMapper.selectMsg();
    }
}
