package id.my.hendisantika.springbootgraylog2.controller;

import id.my.hendisantika.springbootgraylog2.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-graylog2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 06.20
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private final DemoService demoService;

    @GetMapping("/hello")
    public Map<String, Object> showHelloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        log.info("my name is HelloWorldController");
        demoService.hello();
        return map;
    }

    @GetMapping("/log")
    public String log() {
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        int i = 1 / 0;
        return "success";
    }
}
