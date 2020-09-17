package com.tsl.model.basic;

/**
 * @ClassName Property
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 11:23
 * @ModifyDate 2020/9/17 11:23
 * @Version 1.0
 */
public enum BasicProperty {

    PROPERTIES("properties"), EVENTS("events"), SERVICES("services"), PROFILE("profile");

    private String value;

    BasicProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
