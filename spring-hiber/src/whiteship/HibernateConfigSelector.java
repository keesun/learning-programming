package whiteship;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import whiteship.hibernate3.Hibernate3Config;
import whiteship.hibernate4.Hibernate4Config;

/**
 * @author Keesun Baik
 */
public class HibernateConfigSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		HibernateVersion hibernateVersion = (HibernateVersion) importingClassMetadata.getAnnotationAttributes(EnableHibernate.class.getName()).get("hibernateVersion");
		switch (hibernateVersion) {
			case HIBERNATE3:
				return new String[]{Hibernate3Config.class.getName()};
			case HIBERNATE4:
				return new String[]{Hibernate4Config.class.getName()};
		}
		throw new IllegalArgumentException();
	}
}
