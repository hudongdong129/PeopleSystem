package com.hu.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("3");
        stringSet.add("2");
        stringSet.add("3");
        stringSet.add("10");
        Object[] strings = stringSet.toArray();
        System.out.println(strings[0]+","+strings[1]);


//        boolean removeBoolean = stringSet.remove("5");
//
//        System.out.println(removeBoolean);
//        System.out.println(stringSet.size());
        Iterator<String> stringIterator = stringSet.iterator();
        while (stringIterator.hasNext()) {
            String a = stringIterator.next();
            stringIterator.remove();
//            stringIterator.remove();
//            System.out.println(a);
//            System.out.println(stringSet.size());
        }
    }
}
