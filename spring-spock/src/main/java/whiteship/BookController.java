package whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Keesun Baik
 */
@Controller
public class BookController {

    @Autowired BookService service;

    @RequestMapping("/book/{id}")
    public @ResponseBody String book(@PathVariable int id) {
        return service.book(id);
    }

}
