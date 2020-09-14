/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Document interface
 * 一种数据的组织方式
 *
 * 现在有一个小车对象，就差轮子，门了。
 * class Car {
 *     private String model;
 *
 *     private float price;
 *
 *     private Wheel wheel;
 *
 *     private Door door;
 * }
 *
 * class Wheel {
 *
 *     private String model;
 *
 *     private float price;
 * }
 *
 * class Door {
 *     private String model;
 *
 *     private float price;
 * }
 *
 * 封装行为和属性
 *
 * 存和取
 *
 * 属性自定义
 *
 * 数据结构比较灵活，行为比较简单。
 *
 * 对象及其部件有部分相同的属性
 *
 *
 *
 *
 *
 * NoSQL
 *
 *
 * 抽象文档是树形接口单个节点的抽象
 *
 */
public interface Document {

  /**
   * Puts the value related to the key
   *
   * @param key   element key
   * @param value element value
   * @return Void
   */
  Void put(String key, Object value);

  /**
   * Gets the value for the key
   *
   * @param key element key
   * @return value or null
   */
  Object get(String key);

  /**
   * Gets the stream of child documents
   *
   * @param key         element key
   * @param constructor constructor of child class
   * @return child documents
   */
  <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
