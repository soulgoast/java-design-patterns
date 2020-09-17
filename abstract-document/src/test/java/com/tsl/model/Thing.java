package com.tsl.model;

import com.iluwatar.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * @ClassName Thing
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 11:22
 * @ModifyDate 2020/9/17 11:22
 * @Version 1.0
 */
public class Thing extends AbstractDocument implements HasProfile, HasEvents {

    public Thing(Map<String, Object> properties) {
        super(properties);
    }
}
