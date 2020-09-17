package com.tsl.model;

import com.iluwatar.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * @ClassName Event
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 13:39
 * @ModifyDate 2020/9/17 13:39
 * @Version 1.0
 */
public class Event extends AbstractDocument implements HasIdentifier {

    public Event(Map<String, Object> properties) {
        super(properties);
    }
}
