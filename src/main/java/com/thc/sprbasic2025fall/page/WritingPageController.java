package com.thc.sprbasic2025fall.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/writing/")
@Controller
public class WritingPageController {

    //@RequestMapping("/create")
    @GetMapping("/{page}") // Get으로만 접근할 수 있는 RequestMapping (기능은 동일)
    public String create(@PathVariable String page) {
        return "writing/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id) {
        // @PathVariable 여러 개 사용 가능
        return "writing/" + page;
    }
}
