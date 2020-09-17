package com.qunce;

import com.iluwatar.abstractdocument.AbstractDocument;
import com.iluwatar.abstractdocument.AbstractDocumentTest;
import com.iluwatar.abstractdocument.App;
import com.iluwatar.abstractdocument.domain.Car;
import com.iluwatar.abstractdocument.domain.enums.Property;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @ClassName TestAbstractDocument
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 9:16
 * @ModifyDate 2020/9/17 9:16
 * @Version 1.0
 */
public class TestAbstractDocument {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAbstractDocument.class);

    public static final String KEY = "key";

    public static final String VALUE = "value";

    private class DocumentImplementation extends AbstractDocument {

        protected DocumentImplementation(Map<String, Object> properties) {
            super(properties);
        }
    }

    private DocumentImplementation documentImplementation = new DocumentImplementation(new HashMap<>());

    /**
     * 放进去和取出来的是一个值
     */
    @Test
    public void shouldPutAndGetValue() {
        documentImplementation.put(KEY, VALUE);
        assertEquals(VALUE, documentImplementation.get(KEY));
    }

    /**
     * 可以查找子节点
     */
    @Test
    public void shouldRetrieveChildren() {
        Map<String, Object> child1 = new HashMap<>();
        Map<String, Object> child2 = new HashMap<>();

        List<Map<String, Object>> children = Arrays.asList(child1, child2);

        documentImplementation.put(KEY, children);

        Stream<DocumentImplementation> childrenStream = documentImplementation.children(KEY, DocumentImplementation::new);
        assertNotNull(childrenStream);
        assertEquals(2, childrenStream.count());
    }

    /**
     * 如果没有对应的子节点，应该返回空的流
     */
    @Test
    public void shouldRetrieveEmptyStreamForNonExistingChildren() {
        Stream<DocumentImplementation> children = documentImplementation.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(0, children.count());
    }

    /**
     * 可以将包含的属性打印出来
     */
    @Test
    public void shouldIncludePropsInToString() {
        Map<String, Object> props = new HashMap<>();
        props.put(KEY, VALUE);
        DocumentImplementation document = new DocumentImplementation(props);
        assertTrue(document.toString().contains(KEY));
        assertTrue(document.toString().contains(VALUE));
    }

    /**
     * 对业务数据的组装
     */
    @Test
    public void assembly() {
        LOGGER.info("Constructing parts and car");

        Map<String, Object> carProperties = new HashMap<>();
        carProperties.put(Property.MODEL.toString(), "300SL");
        carProperties.put(Property.PRICE.toString(), 10000L);

        Map<String, Object> wheelProperties = new HashMap<>();
        wheelProperties.put(Property.TYPE.toString(), "wheel");
        wheelProperties.put(Property.MODEL.toString(), "15C");
        wheelProperties.put(Property.PRICE.toString(), 100L);

        Map<String, Object> doorProperties = new HashMap<>();
        doorProperties.put(Property.TYPE.toString(), "door");
        doorProperties.put(Property.MODEL.toString(), "Lambo");
        doorProperties.put(Property.PRICE.toString(), 300L);

        carProperties.put(Property.PARTS.toString(), Arrays.asList(wheelProperties, doorProperties));

        Car car = new Car(carProperties);

        LOGGER.info("Here is our car:");
        LOGGER.info("-> model: {}", car.getModel().get());
        LOGGER.info("-> price: {}", car.getPrice().get());
        LOGGER.info("-> parts: ");
        car.getParts().forEach(p -> LOGGER.info("\t{}/{}/{}", p.getType().get(), p.getModel().get(), p.getPrice().get()));
    }

}
