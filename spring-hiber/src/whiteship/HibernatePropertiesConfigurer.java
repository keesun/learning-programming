package whiteship;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public interface HibernatePropertiesConfigurer {

	void hibernateProperties(HashMap<String, Object> props);

}
