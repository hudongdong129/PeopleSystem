package com.hu.controller;

import com.hu.domain.Employee;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String,Employee> staff = new HashMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-3234",new Employee("Harry"));
        staff.put("125-23-1215",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));


//        staff.putIfAbsent("word",0);
        System.out.println(staff);

        staff.remove("567-24-3234");

        staff.put("456-62-5527",new Employee("Francesca Miller"));

        System.out.println(staff.get("125-23-1215"));

//        staff.forEach((k,v) -> System.out.println("key=" + k + ",value=" + v));
    }
}
