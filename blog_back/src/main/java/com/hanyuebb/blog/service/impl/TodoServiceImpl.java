package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbTodo;
import com.hanyuebb.blog.mapper.TbTodoMapper;
import com.hanyuebb.blog.service.TodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:TodoServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:59
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class TodoServiceImpl extends BaseServiceImpl<TbTodo, TbTodoMapper> implements TodoService<TbTodo> {
}
