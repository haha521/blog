package com.hanyuebb.blog.common.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:MtcPo
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/1 16:00
 * @auther:zh
 */
@Data
public class MtcPo {
    private Set<String> modules = new HashSet<>();

    private Set<String> types = new HashSet<>();

    private Set<String> classifys = new HashSet<>();
}
