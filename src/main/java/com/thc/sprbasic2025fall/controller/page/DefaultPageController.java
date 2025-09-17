package com.thc.sprbasic2025fall.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/board")
@Controller // 컨트롤러임을 알리기 위해 붙이는 어노테이션!
public class DefaultPageController {

    @RequestMapping("/index") // 찾아올 수 있는 주소값을 설정한 것입니다!
    public String index() { // method
        System.out.println("DefaultPageController.index()");
        return "board/index"; // 페이지컨트롤러 리턴값! src->resources->templates 아래에 있는 리턴값, index.html을 찾아서 파씽해줌!!
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) { // method
        return "board/" + page;
    }

//    @RequestMapping("/add")
//    public String add(int a, int b, Model model) { // method
//        //Model import 할 때 항상 springframework로 해야함
//        //파라미터를 받아볼게요!
//        // (url..)?key1=value1&key2=value2&key3=value3 (url에 이렇게 적혀 있으면 , 파라미터 사용 가능!)
//        System.out.println("DefaultPageController.add()");
//        System.out.println("a : " + a);
//        System.out.println("b : " + b);
//
//        int sum = a + b;
//        System.out.println("sum : " + sum);
//
//        model.addAttribute("sum", sum);
//
//        return "add";
//    }
//
//    @RequestMapping("/addString")
//    public String addString(String a, String b, Model model) { // method
//        //두 개의 글자를 입력 받아서 결합해보세요! (실습)
//        String result = a + b;
//        System.out.println("result : " + result);
//
//        model.addAttribute("result", result);
//
//        return "addstring";
//    }
}
