package com.tsl.model;

import com.iluwatar.abstractdocument.Document;
import com.iluwatar.abstractdocument.domain.Part;
import com.iluwatar.abstractdocument.domain.enums.Property;
import com.tsl.model.basic.BasicProperty;

import java.util.stream.Stream;

/**
 * @ClassName HasEvent
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 13:43
 * @ModifyDate 2020/9/17 13:43
 * @Version 1.0
 */
public interface HasEvents extends Document {

    default Stream<Event> getEvents() {
        return children(BasicProperty.EVENTS.getValue(), Event::new);
    }

}
