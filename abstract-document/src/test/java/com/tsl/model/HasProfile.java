package com.tsl.model;

import com.iluwatar.abstractdocument.Document;
import com.tsl.model.basic.BasicProperty;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName Hasprofile
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 11:41
 * @ModifyDate 2020/9/17 11:41
 * @Version 1.0
 */
public interface HasProfile extends Document {

    default Optional<Profile> getProfile() {
      /*  Stream<Profile> childrenOptional = children(BasicProperty.PROFILE.getValue(), Profile::new);
        return childrenOptional.findFirst();*/
      return Optional.empty();
    }

}
