package enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableWorkHard(hardness = 5)
public class AppConfig {

}