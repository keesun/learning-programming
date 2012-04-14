package mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AnnoConfig {

    @Autowired ApplicationContext applicationContext;

    @Autowired RequestMappingHandlerMapping rmhm;

    @Test
    public void di(){
        for(String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(applicationContext.getBean(name));
        }
    }

    @Test
    public void rmhm(){
        for(Map.Entry<RequestMappingInfo, HandlerMethod> hm : rmhm.getHandlerMethods().entrySet()) {
            System.out.println(hm.getKey() + "=>" + hm.getValue() + "</br>");
        }
    }

    @Controller
    @RequestMapping({"/a", "/b"})
    public static class SampleController {
        @RequestMapping({"/c", "/d"})
        public void hi(){
        }
    }
}
