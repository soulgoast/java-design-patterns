package com.tsl.model;

import com.iluwatar.abstractdocument.Document;
import com.tsl.model.basic.BusinessProperty;

import java.util.Optional;

/**
 * @ClassName Identifier
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 13:40
 * @ModifyDate 2020/9/17 13:40
 * @Version 1.0
 */
public interface HasIdentifier extends Document {

    default Optional<String> getIdentifier() {
        return Optional.ofNullable( (String ) get(BusinessProperty.IDENTIFIER.getValue()));
    }

}
