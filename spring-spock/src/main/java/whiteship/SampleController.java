package whiteship;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Keesun Baik
 */
@Controller
public class SampleController {

    @RequestMapping("/hello")
    public @ResponseBody String hello() {
        return "spock";
    }

}
