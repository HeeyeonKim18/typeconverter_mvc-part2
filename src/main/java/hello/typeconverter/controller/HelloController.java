package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        /**
         * request.getParameter는 문자 타입으로 처리됨
         * Integer 타입으로 변경하고 싶다면, 한번 더 변환해줘야 함
         */
        String data = request.getParameter("data");// 문자 타입 조회
        Integer intValue = Integer.valueOf(data); // 숫자 타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    /**
     * 쿼리 스트링에서 전달된 data = 10의 값은 문자
     * @RequestParam 을 사용하면 스프링이 내부에서 동작하여 숫자 10으로 변환해준다.
     * @ModelAttribute, @PathVariable 도 내부에서 타입 변환이 일어남
     * 이 외에 문자 -> 숫자, boolean -> 숫자도 가능
     * 만약 개발자가 문자 -> 특정 클래스로 변경하고 싶다면 스프링에서 제공하는
     * 컨버터 인터페이스를 구현하면 된다.
     */
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort){
        System.out.println("ipPort.getIp() = " + ipPort.getIp());
        System.out.println("ipPort.getPort() = " + ipPort.getPort());
        return "ok";
    }
}
