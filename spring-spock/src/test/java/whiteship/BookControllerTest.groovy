package whiteship

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @author Keesun Baik
 */
class BookControllerTest extends Specification {

    MockMvc mockMvc;
    BookService mockBookService;

    def setup() {
        def controller = new BookController()
        mockBookService = Mock(BookService.class)
        controller.service = mockBookService;
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    def "서비스는 가짜 객체로 바꾸고 테스트"() {
        given:
        def book = "book100"

        when:
        def response = mockMvc.perform(get("/book/100"))

        then:
        1 * mockBookService.book(100) >> book
        response.andExpect(status().isOk())
    }

}
