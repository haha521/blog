package com.hanyuebb.blog.exmapper;

import com.hanyuebb.blog.domain.TbLeavingMsg;
import com.hanyuebb.blog.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExTbLeavingMsgMapper extends MyMapper<TbLeavingMsg> {

    List<TbLeavingMsg> selectMsg();
}