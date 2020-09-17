package com.tsl.model;

import com.iluwatar.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * @ClassName HasProfile
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 11:26
 * @ModifyDate 2020/9/17 11:26
 * @Version 1.0
 */
public class Profile extends AbstractDocument implements HasProductKey {

    protected Profile(Map<String, Object> properties) {
        super(properties);
    }


}
