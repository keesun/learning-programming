package whiteship

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Keesun Baik
 */
class SampleControllerTest extends Specification {

    MockMvc mockMvc;

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new SampleController()).build()
    }

    def "스팍과 스프링 MVC 테스트 연동 테스트"() {
        when:
        def response = mockMvc.perform(get("/hello"))

        then:
        response.andExpect(status().isOk())
                .andExpect(content().string("spock"))

        response.andReturn().response.contentAsString == "hello spock"
    }

}
