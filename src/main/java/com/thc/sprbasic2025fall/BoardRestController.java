package com.thc.sprbasic2025fall;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    List<Map<String, Object>> list_board; // 휘발성이긴 함. 재기동 할 때 마다 다 날라감.
    // field기 때문에 서비스 컨테이너가 다시 올라가면 다 날라감 (재기동 할 때 마다 다 날라감)


    // create
    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {

        System.out.println("board create");
        System.out.println("title: " + params.get("title"));
        System.out.println("content: " + params.get("content"));

        if(list_board == null) {
            list_board = new ArrayList<>();
        }

        Map<String, Object> map_board = new HashMap<>();

        map_board.put("id", list_board.size() + 1);
        map_board.put("title", params.get("title") + "");
        map_board.put("content", params.get("content") + "");

        list_board.add(map_board); // ArrayList에 넣음

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode", "200");
        return_map.put("id", map_board.get("id"));
        return return_map;
    }

    // list
    @RequestMapping("/list")
    public Map<String, Object> list() {

        System.out.println("board list");

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode", "200");
        return_map.put("list", list_board);
        // field 값에 있는거 그냥 돌려주기만 할 뿐.
        return return_map;
    }

    // detail
    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable String id) {

        System.out.println("board detail");

        Map<String, Object> map_board = null;
        for(Map<String, Object> each:list_board) {
            if(id.equals(each.get("id") + "")) { // id가 Object니까. ""로 string으로 바꿔줌
                map_board = each;
            }
            //list_board 전체 돌면서 id값 똑같은 값 있으면 걔가 걔야(map_board = each;) 해줌.
            //이 for문을 해주는 이유가 잘 이해가 안 됨 -> 검색 작업이니까 for문 돌면서 리스트에서 원하는 id의 게시글을 찾는 작업임 !
        }

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode", "200");
        return_map.put("detail", map_board);
        return return_map;
    }

    // update
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {

        System.out.println("board update");
        System.out.println("id: " + params.get("id"));
        System.out.println("title: " + params.get("title"));
        System.out.println("content: " + params.get("content"));
        String id = params.get("id").toString();

        Map<String, Object> map_board = null;
        for(Map<String, Object> each:list_board) {
            if(id.equals(each.get("id") + "")) { // id가 Object니까. ""로 string으로 바꿔줌
                map_board = each;
            }
        }

        if(map_board != null) {
            map_board.put("title", params.get("title") + "");
            map_board.put("content", params.get("content") + "");
        }

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode", "200");
        return return_map;
    }
}
