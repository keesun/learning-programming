package whiteship;

/**
 *
 * http://docs.jboss.org/hibernate/orm/4.1/manual/en-US/html/ch03.html#configuration-optional-dialects
 *
 * @author Keesun Baik
 */
public class HibernateDialects {

	// Hibernate SQL Dialects (hibernate.dialect)
	public static final String DB2 = "org.hibernate.dialect.DB2Dialect";
	public static final String DB2_AS400 = "org.hibernate.dialect.DB2400Dialect";
	public static final String DB2_OS390 = "org.hibernate.dialect.DB2390Dialect";
	public static final String PostgreSQL = "org.hibernate.dialect.PostgreSQLDialect";
	public static final String MySQL5 = "org.hibernate.dialect.MySQL5Dialect";
	public static final String MySQL5_with_InnoDB = "org.hibernate.dialect.MySQL5InnoDBDialect";
	public static final String MySQL_with_MyISAM = "org.hibernate.dialect.MySQLMyISAMDialect";
	public static final String Oracle = "org.hibernate.dialect.OracleDialect";
	public static final String Oracle9i = "org.hibernate.dialect.Oracle9iDialect";
	public static final String Oracle10g = "org.hibernate.dialect.Oracle10gDialect";
	public static final String Oracle11g = "org.hibernate.dialect.Oracle10gDialect";
	public static final String Sybase = "org.hibernate.dialect.SybaseASE15Dialect";
	public static final String Sybase_Anywhere = "org.hibernate.dialect.SybaseAnywhereDialect";
	public static final String Microsoft_SQL_Server_2000 = "org.hibernate.dialect.SQLServerDialect";
	public static final String Microsoft_SQL_Server_2005 = "org.hibernate.dialect.SQLServer2005Dialect";
	public static final String Microsoft_SQL_Server_2008 = "org.hibernate.dialect.SQLServer2008Dialect";
	public static final String SAP_DB = "org.hibernate.dialect.SAPDBDialect";
	public static final String Informix = "org.hibernate.dialect.InformixDialect";
	public static final String HypersonicSQL = "org.hibernate.dialect.HSQLDialect";
	public static final String H2_Database = "org.hibernate.dialect.H2Dialect";
	public static final String Ingres = "org.hibernate.dialect.IngresDialect";
	public static final String Progress = "org.hibernate.dialect.ProgressDialect";
	public static final String Mckoi_SQL = "org.hibernate.dialect.MckoiDialect";
	public static final String Interbase = "org.hibernate.dialect.InterbaseDialect";
	public static final String Pointbase = "org.hibernate.dialect.PointbaseDialect";
	public static final String FrontBase = "org.hibernate.dialect.FrontbaseDialect";
	public static final String Firebird = "org.hibernate.dialect.FirebirdDialect";

}
