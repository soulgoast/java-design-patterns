package com.tsl.model;

import com.iluwatar.abstractdocument.Document;
import com.tsl.model.basic.BusinessProperty;

import java.util.Optional;

/**
 * @ClassName HasProductKey
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 11:35
 * @ModifyDate 2020/9/17 11:35
 * @Version 1.0
 */
public interface HasProductKey extends Document {

    default Optional<String> getProductKey() { return Optional.ofNullable((String) get(BusinessProperty.PRODUCTKEY.getValue())); }
}
