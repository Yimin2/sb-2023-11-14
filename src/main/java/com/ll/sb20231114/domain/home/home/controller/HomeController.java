package com.ll.sb20231114.domain.home.home.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
// 컨트롤러 입니다.
public class HomeController {
    int num = 1;

    @GetMapping("/")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain() {
        System.out.println("안녕하세요!!!"); // 이 메시지는 콘솔에 출력됨, 클라이언트에게 전송되지 않습니다.
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b) {
        return "계산 결과 : %d".formatted(a + b);
    }
    // 값이 없어 오류 나옴
    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "a : " + a + ", b : " + b;
    }
    //null 값을 받을 수 있어 오류 나지 않음
    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산 결과 : %d".formatted(a + b);
    }
    // defaultValue 값을 지정해줘 calc와 다르게 오류가 나지 않음.

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산 결과 : %f".formatted(a + b);
    }
    // 정수에서 실수까지 범위 확장, double 형은 %f 사용

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "-") String b
    ) {
        return "계산 결과 : %s".formatted(a + b);
    }
    // 문자열 입력 가능
    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
            int a, int b
    ) {
        return a + b;
    }
    // 실제 a+b 정수가 들어가는 것이 아닌 계산된 문자가 들어감.
    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }
    // calc 6과 동일하게 참 일 시true 값이 아닌 문자 true가 들어가게 됨
    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(name, age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        Map<String, Object> personMap = Map.of( //
                //object 가장 큰 범위, String, int 둘다 포함
                // json 객체,맵을 구분할 방법이 없음
                "name", name,
                "age", age
        );

        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Integer> showCalc11() {
        List<Integer> nums = new ArrayList<>() {{
            add(10);
            add(-510);
            add(10010);
        }};
        // 계속 추가 가능
        return nums;
    }

    @GetMapping("/calc12")
    @ResponseBody
    int[] showCalc12() {
        int[] nums = new int[]{10, -510, 10010};
        //길이 고정
        return nums;
    }

    @GetMapping("/calc13")
    @ResponseBody
    List<Person2> showCalc13(
            String name, int age
    ) {
        List<Person2> persons = new ArrayList<>() {{
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }};

        return persons;
    }

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14() {
        String html = "";

        html += "<div>";
        html += "<input type=\"text\" placeholder=\"내용\">";
        html += "</div>";
        //메모리 상 좋지 않음. 문자의 불변성
        return html;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"내용\">");
        sb.append("</div>");
        // StringBuilder를 주로 사용
        return sb.toString();
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16() {
        String html = "<div><input type=\"text\" placeholder=\"내용\"></div>";
        // 한줄로만 사용 가능
        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17() {
        String html = """
                <div>
                    <input type="text" placeholder="내용">
                </div>
                """;
        // 여러줄 사용시 """ """하면 됨
        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18() {
        String html = """
                <div>
                    <input type="text" placeholder="내용" value="반가워요.">
                </div>
                """;
        //placeholder 값이 없는 상태
        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(
            @RequestParam(defaultValue = "") String subject,
            // 제목이 안들어 갔을 떼 빈칸 입력
            @RequestParam(defaultValue = "") String content
    ) {
        String html = """
                <div>
                    <input type="text" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="내용" value="%s">
                </div>
                """.formatted(subject, content);
        // 제목과 내용을 받음
        return html;
    }

    @GetMapping("/calc20")
    String showCalc20() {
        return "calc20";
    }
    //콘트롤러에서 뷰를 다르면 mvc 정책위반, 타임리프를 통해 뷰 호출
    @GetMapping("/calc21")
    String showCalc21(Model model) {
        model.addAttribute("v1", "안녕");
        model.addAttribute("v2", "반가워");
        return "calc21";
        //콘트롤러에서 뷰를 다르면 mvc 정책위반, 타임리프를 통해 뷰 호출
    }

    @GetMapping("/calc22")
    @ResponseBody
    int showCalc21() {
        return num++;
    }
} //지역변수를 인스턴스 변수로 선언

@AllArgsConstructor
// 모든 필드에 대한 매개변수를 사용하는 생성자를 자동으로 생성
class Person {
    public String name;
    public int age;
}

@AllArgsConstructor
class Person2 {
    @Getter
    //getter를 이용하여 private 상태에서 값을 읽음
    private String name;
    @Getter
    private int age;
}