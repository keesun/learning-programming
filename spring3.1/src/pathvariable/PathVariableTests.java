package pathvariable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

/**
 * @author Keesun Baik
 */
public class PathVariableTests {
	
	@Test
	public void path() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();
		mockMvc.perform(get("/hi/3"))
				.andExpect(status().isOk())
				.andExpect(content().string("ok"));
		mockMvc.perform(get("/hi/3/month/4"))
				.andExpect(status().isNotFound());
	}

	
	@Controller
	static class SampleController {
		@RequestMapping("/hi/{value}")
		public @ResponseBody String hi(@PathVariable String value) {
			System.out.println(value);
			return "ok";
		}
		
	}

}
