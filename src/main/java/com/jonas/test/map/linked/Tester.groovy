package com.jonas.test.map.linked

/**
 * 测试 LinkedHashMap。测试对同一个 key 进行多次 put 后，该 key 的顺序是否被刷新
 * Created by jonas on 2017/3/31.
 */

Map<String, String> linkedHashMap = new LinkedHashMap<>()

linkedHashMap.put("A", "Im A1")
linkedHashMap.put("B", "Im B1")

linkedHashMap.forEach({ key, value -> println key })

linkedHashMap.put("A", "Im A2")
println 'Now! A value has changed'

linkedHashMap.forEach({ key, value -> println key })