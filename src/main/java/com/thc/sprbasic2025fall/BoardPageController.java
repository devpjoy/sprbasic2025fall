package com.thc.sprbasic2025fall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@Controller
public class BoardPageController {

    @RequestMapping("/index")
    public String index() {
        return "board/index";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        // @PathVariable : 경로에 있는 것도 변수 처럼 쓰겠다 !
        return "board/" + page;
    }
}
