package com.thc.sprbasic2025fall.controller;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/posting")
@RestController
public class PostingRestController {

    final PostingService postingService;

    @PostMapping("")
    public Long create(@RequestBody Map<String, Object> param) {
        return postingService.create(param); // create 할 때, param을 넘겨주면 service에서 저장
    }

    @PutMapping("")
    public void update(@RequestBody Map<String, Object> param) {
        postingService.update(param);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long id) {
        postingService.delete(id);
    }

    @GetMapping("")
    public Posting detail(@RequestParam Long id) { // Get 방식은 RequestBody가 아닌, RequestParam
        return postingService.detail(id);
    }

    @GetMapping("/list")
    public List<Posting> list() { // Get 방식은 RequestBody가 아닌, RequestParam
        return postingService.list();
    }
}
