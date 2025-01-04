package id.my.hendisantika.springbootgraylog2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
@Service
public class DemoService {
    public void hello() {
        log.info("this is a test service,hello");
    }
}
