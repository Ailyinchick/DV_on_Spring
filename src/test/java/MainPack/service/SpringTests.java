package MainPack.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;

@ComponentScan(basePackages = "MainPack")
@WebAppConfiguration
public class SpringTests {

    @Autowired
    private MyService myService;

    @Test
    public void findById() {
        System.out.println(myService.findById("3"));
    }

}
