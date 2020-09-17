package com.qunce;

import com.google.gson.Gson;
import com.tsl.model.Thing;
import com.tsl.model.exception.NotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @ClassName Test
 * @Description
 * 利用抽象文档的解决物模型的问题
 *
 * 什么是物模型？
 * 物模型指将物理空间中的实体数字化，并在云端构建的该实体的数据模型，用于描述实体的功能。下面介绍物模型相关概念和使用方法。
 *
 * 抽取实体的特征进行数字化表示。
 *
 * 给特征进行分类。
 *
 * 物模型TSL（Thing Specification Language）是一个JSON格式的文件。它是物理空间中的实体，如传感器、车载装置、楼宇、工厂等在云端的数字化表示，
 * 从属性、服务和事件三个维度，分别描述了该实体是什么、能做什么、可以对外提供哪些信息。定义了物模型的这三个维度，即完成了产品功能的定义。
 *
 * 物模型将产品功能类型分为三类：属性、服务和事件。
 *
 * 属性：一般用于描述设备运行时的状态，如环境监测设备所读取的当前环境温度等。属性支持GET和SET请求方式。应用系统可发起对属性的读取和设置请求。
 *
 * 服务：设备可被外部调用的能力或方法，可设置输入参数和输出参数。相比于属性，服务可通过一条指令实现更复杂的业务逻辑，如执行某项特定的任务。平台下发消息
 *
 * 事件：设备运行时的事件。事件一般包含需要被外部感知和处理的通知信息，可包含多个输出参数。如，某项任务完成的信息，或者设备发生故障或告警时的温度等，事件可以被订阅和推送。设备上报消息。
 *
 *
 * @Author hu zhongxi
 * @email m18967896507_1@163.com
 * @Date 2020/9/17 9:04
 * @ModifyDate 2020/9/17 9:04
 * @Version 1.0
 */
public class TestTSL {


    public static final String TSL = "{'schema':'物模型结构定义的访问URL','profile':{'productKey':'产品ProductKey'},'properties':[{'identifier':'属性唯一标识符（产品下唯一）','name':'属性名称','accessMode':'属性读写类型：只读（r）或读写（rw）。','required':'是否是标准功能的必选属性','dataType':{'specs':{'min':'参数最小值（int、float、double类型特有）','max':'参数最大值（int、float、double类型特有）','unit':'属性单位（int、float、double类型特有，非必填）','unitName':'单位名称（int、float、double类型特有，非必填）','size':'数组元素的个数，最大512（array类型特有）。','step':'步长（text、enum类型无此参数）','length':'数据长度，最大10240（text类型特有）。','0':'0的值（bool类型特有）','1':'1的值（bool类型特有）','item':{'type':'数组元素的类型（array类型特有）'}}}}],'events':[{'identifier':'事件唯一标识符（产品下唯一，其中post是默认生成的属性上报事件。）','name':'事件名称','desc':'事件描述','type':'事件类型（info、alert、error）','required':'是否是标准功能的必选事件','outputData':[{'identifier':'参数唯一标识符','name':'参数名称','dataType':{'specs':{'min':'参数最小值（int、float、double类型特有）','max':'参数最大值（int、float、double类型特有）','unit':'属性单位（int、float、double类型特有，非必填）','unitName':'单位名称（int、float、double类型特有，非必填）','size':'数组元素的个数，最大512（array类型特有）。','step':'步长（text、enum类型无此参数）','length':'数据长度，最大10240（text类型特有）。','0':'0的值（bool类型特有）','1':'1的值（bool类型特有）','item':{'type':'数组元素的类型（array类型特有）'}}}}],'method':'事件对应的方法名称（根据identifier生成）'}],'services':[{'identifier':'服务唯一标识符（产品下唯一，其中set/get是根据属性的accessMode默认生成的服务。）','name':'服务名称','desc':'服务描述','required':'是否是标准功能的必选服务','callType':'async（异步调用）或sync（同步调用）','inputData':[{'identifier':'入参唯一标识符','name':'入参名称','dataType':{'specs':{'min':'参数最小值（int、float、double类型特有）','max':'参数最大值（int、float、double类型特有）','unit':'属性单位（int、float、double类型特有，非必填）','unitName':'单位名称（int、float、double类型特有，非必填）','size':'数组元素的个数，最大512（array类型特有）。','step':'步长（text、enum类型无此参数）','length':'数据长度，最大10240（text类型特有）。','0':'0的值（bool类型特有）','1':'1的值（bool类型特有）','item':{'type':'数组元素的类型（array类型特有）'}}}}]}],'outputData':[{'identifier':'出参唯一标识符','name':'出参名称','dataType':{'specs':{'min':'参数最小值（int、float、double类型特有）','max':'参数最大值（int、float、double类型特有）','unit':'属性单位（int、float、double类型特有，非必填）','unitName':'单位名称（int、float、double类型特有，非必填）','size':'数组元素的个数，最大512（array类型特有）。','step':'步长（text、enum类型无此参数）','length':'数据长度，最大10240（text类型特有）。','0':'0的值（bool类型特有）','1':'1的值（bool类型特有）','item':{'type':'数组元素的类型（array类型特有）'}}}}],'method':'服务对应的方法名称（根据identifier生成）'}";

    /**
     * 当子文档是{}类型
     * @throws NotFoundException
     */
    @Test
    public void tslObj() throws NotFoundException {
        Gson gson = new Gson();
        Map<String, Object> stringObjectMap = gson.fromJson(TSL, Map.class);
        Thing thing = new Thing(stringObjectMap);

        // String productKey = thing.getProfile().get().getProductKey().orElseThrow(NotFoundException::new);
        // System.out.println("productKey:" + productKey);
    }

    /**
     * 当子文档是[]类型
     */
    @Test
    public void tslArr() {
        Gson gson = new Gson();
        Map<String, Object> stringObjectMap = gson.fromJson(TSL, Map.class);
        Thing thing = new Thing(stringObjectMap);
    }

}
