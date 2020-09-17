package com.tsl.model.basic;

/**
 * @ClassName businessProperty
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 11:38
 * @ModifyDate 2020/9/17 11:38
 * @Version 1.0
 */
public enum BusinessProperty {

    PRODUCTKEY("productKey"), IDENTIFIER("identifier");

    private String value;

    BusinessProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
