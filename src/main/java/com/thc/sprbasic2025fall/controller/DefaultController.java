package com.thc.sprbasic2025fall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {

    @ResponseBody
    @RequestMapping("/test")
    public List<String> test() {

        List<String> a_list = new ArrayList<>();

//        for(int i = 1; i < 10; i++){
//            for (int j = 1; j < 10; j++){
//                System.out.println(i + " * " + j + " = " + (i * j));
//            }
//            System.out.println("----------");
//        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                a_list.add(i + " * " + j + " = " + (i * j));
            }
            a_list.add("----------");
        }

        return a_list;
    }
}


/*
// 교수님 코드 (DefaultController 내에서)

@RequestMapping("/multiples")
public String[] multiples() {
    for (int i = 0; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            System.out.println(i + " * " + j + " = " + (i * j));
        }
    }

    String[] result = {"1", "2"};
    return result;
}
*/