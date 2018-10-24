package Generic;


import org.junit.Test;

import java.util.*;

/**
 * 1、泛型的第一种使用方法
 * TestDemo1() TestDemo2()是泛型在集合中的使用方法
 * 2、自定义泛型类、泛型接口
 *
 */

public class TestGeneric {
    @Test
    public void TestDemo1(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i =0;i<list.size();i++){
            System.out.println("num is :"+list.get(i));
        }
    }
    @Test
    public void TestDemo2(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> o :entries) {
            System.out.println("key is :"+o.getKey()+",value is :"+o.getValue());
        }
    }
}
