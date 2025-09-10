package com.thc.sprbasic2025fall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //페이지 리턴이 아니라, 객체 리턴할꺼에요!
public class DefaultRestController {

    @RequestMapping("/api/add")
    public Map<String, Object> add(int a, int b) {
        int sum = a + b;
        Map<String, Object> map = new HashMap<>();
        map.put("resultCode", 200);
        map.put("sum", sum);
        return map;
    }

    //과제 (깃허브 연동까지) : 두 개 숫자 값 곱해서 map으로 리턴
    @RequestMapping("/api/multiple")
    public Map<String, Object> multiple(int a, int b) {
        int multi = a * b;
        Map<String, Object> map = new HashMap<>();
        map.put("multi", multi);
        return map;
        // 과제 완료! (09/10)
    }
}
