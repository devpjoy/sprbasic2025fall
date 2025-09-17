package com.thc.sprbasic2025fall;

import com.thc.sprbasic2025fall.dto.MultipleBasket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api") // 모든 메서드에 앞에 붙는 메핑!!!
@RestController //페이지 리턴이 아니라, 객체 리턴할꺼에요!
public class DefaultRestController {

    @RequestMapping("/add")
    public Map<String, Object> add(int a, int b) {
        int sum = a + b;
        Map<String, Object> map = new HashMap<>();
        map.put("resultCode", 200);
        map.put("sum", sum);
        return map;
    }

    //과제 (깃허브 연동까지) : 두 개 숫자 값 곱해서 map으로 리턴
    @RequestMapping("/multiple")
    //public Map<String, Object> multiple(int a, int b) {
        // 만약 웹에서 b 값을 안주면 error! (연산할 숫자가 없어지는 거니까)
    public Map<String, Object> multiple(@RequestParam int a1, int a, int b) {
        // 필수적인 param인 경우 requestparam 사용
        // 이 경우 a1만 필수! (나머지도 다 필수로 하려면 각각 @RequestParam 붙여 줘야 함)
        int multi = a * b;
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("multi", multi);
        return result_map;
        // 과제 완료! (09/10)
    }

    // 만약 10개의 수 끼리 곱할때, 10개의 변수를 일일이 파라미터로 선언해 줄 것인가? - NO!
    // 한 번에 map으로 해결
    @RequestMapping("/multiple2")
    public Map<String, Object> multiple2(@RequestParam Map<String, Object> param) {
        // @RequestParam 꼭 필요! 안 그러면 에러 나더라.
        // (Map은 확실하게 파라미터 라는 것을 명령 : key value 형태로 강제로 map 안에 넣어줌)
        int a = Integer.parseInt(param.get("a") + ""); //string을 integer로 강제로 형변환
        int b = Integer.parseInt(param.get("b") + "");
        int result = a * b;
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("resultCode", 200);
        result_map.put("result", result);
        return result_map;
    }

    // 파라미터로 MultipleBasket라는 클래스 사용
    @RequestMapping("/multiple3")
    public Map<String, Object> multiple3(MultipleBasket param) {
        // 객체로 받을 때는 @RequestParam를 하면 그 객체 자체를 파라미터로 받는 줄 알고 에러 날 수 있음
        // 따라서 여기서는 @RequestParam 사용 x
        int a = param.getA();
        int b = param.getB();

        int result = a * b;
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("resultCode", 200);
        result_map.put("result", result);
        return result_map;
    }
}
