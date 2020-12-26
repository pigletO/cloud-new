package com.pig1et.study.cloudnew;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-30 15:05
 **/
public class Test {
    public static void main(String[] args) {
        /*ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(16);

        map.put(2, "hah");*/

        List<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        for (Integer i : list) {
            if (i.equals(2)) {
                list.remove(i);
//                list.add(55);
            }
        }
//        for (int i = list.size() - 1; i > 0; i--) {
//            if (list.get(i).equals(2)) {
//                list.remove(i);
////                list.add(55);
//            }
//        }

        list.stream().forEach(i -> System.out.println(i));
    }
}
