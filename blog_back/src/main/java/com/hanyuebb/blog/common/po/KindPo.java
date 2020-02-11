package com.hanyuebb.blog.common.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName:KindPo
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/6 13:53
 * @auther:zh
 */
@Data
public class KindPo {
    private String type;

    private List<Children> children = new ArrayList<>();

    private String year;
}
