package whiteship;

/**
 *
 * http://docs.jboss.org/hibernate/orm/4.1/manual/en-US/html/ch03.html#configuration-optional
 *
 * @author Keesun Baik
 */
public class HibernateProperties {

	// Hibernate Configuration Properties
	public static final String DIALECT = "hibernate.dialect";
	public static final String SHOW_SQL = "hibernate.show_sql";
	public static final String FORMAT_SQL = "hibernate.format_sql";
	public static final String DEFAULT_SCHEMA = "hibernate.default_schema";
	public static final String DEFAULT_CATALOG = "hibernate.default_catalog";
	public static final String SESSION_FACTORY_NAME = "hibernate.session_factory_name";
	public static final String MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
	public static final String DEFAULT_BATCH_FETCH_SIZE = "hibernate.default_batch_fetch_size";
	public static final String DEFAULT_ENTITY_MODE = "hibernate.default_entity_mode";
	public static final String ORDER_UPDATES = "hibernate.order_updates";
	public static final String GENERATE_STATISTICS = "hibernate.generate_statistics";
	public static final String USE_IDENTIFIER_ROLLBACK = "hibernate.use_identifier_rollback";
	public static final String USE_SQL_COMMENTS = "hibernate.use_sql_comments";
	public static final String ID_NEW_GENERATOR_MAPPINGS = "hibernate.id.new_generator_mappings";

	// Hibernate JDBC and Connection Properties
	public static final String JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
	public static final String JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	public static final String JDBC_BATCH_VERSIONED_DATA = "hibernate.jdbc.batch_versioned_data";
	public static final String JDBC_FACTORY_CLASS = "hibernate.jdbc.factory_class";
	public static final String JDBC_USE_SCROLLABLE_RESULTSET = "hibernate.jdbc.use_scrollable_resultset";
	public static final String JDBC_USE_STREAMS_FOR_BINARY = "hibernate.jdbc.use_streams_for_binary";
	public static final String JDBC_USE_GET_GENERATED_KEYS = "hibernate.jdbc.use_get_generated_keys";
	public static final String CONNECTION_PROVIDER_CLASS = "hibernate.connection.provider_class";
	public static final String CONNECTION_ISOLATION = "hibernate.connection.isolation";
	public static final String CONNECTION_AUTOCOMMIT = "hibernate.connection.autocommit";
	public static final String CONNECTION_RELEASE_MODE = "hibernate.connection.release_mode";

	// Hibernate Cache Properties
	public static final String CACHE_PROVIDER_CLASS = "hibernate.cache.provider_class";
	public static final String CACHE_USE_MINIMAL_PUTS = "hibernate.cache.use_minimal_puts";
	public static final String CACHE_USE_QUERY_CACHE = "hibernate.cache.use_query_cache";
	public static final String CACHE_USE_SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
	public static final String CACHE_QUERY_CACHE_FACTORY = "hibernate.cache.query_cache_factory";
	public static final String CACHE_REGION_PREFIX = "hibernate.cache.region_prefix";
	public static final String CACHE_USE_STRUCTURED_ENTRIES = "hibernate.cache.use_structured_entries";
	public static final String CACHE_DEFAULT_CACHE_CONCURRENCY_STRATEGY = "hibernate.cache.default_cache_concurrency_strategy";

	// TODO: Hibernate Transaction Properties
	// TODO: Miscellaneous Properties

}
