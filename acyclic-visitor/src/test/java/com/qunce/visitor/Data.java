package com.qunce.visitor;

/**
 * @ClassName Data
 * @Description TODO
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/15 10:03
 * @ModifyDate 2020/9/15 10:03
 * @Version 1.0
 */
public class Data {

    /**
     * 代码不会改变，添加或修改处理方式，只需要修改Visitor即可。
     * @param visitor
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
