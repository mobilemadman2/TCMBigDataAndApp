package org.iscas.elastic.logstash;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.iscas.elastic.ElasticSearchConfig;
import org.iscas.elastic.admin.ElasticSearchManagement;
import org.iscas.elastic.admin.ParseMysqlTableUtil;
import org.iscas.elastic.admin.RiverRule;

import io.netty.resolver.HostsFileEntries;


public class LogstashConfig {

	public static final String DEFAULT_jdbc_driver_library = "../mysql-connector-java-5.1.46/mysql-connector-java-5.1.46-bin.jar";
	public static final String DEFAULT_jdbc_driver_class = "com.mysql.jdbc.Driver";
	public static final String DEFAULT_jdbc_connection_string = "jdbc:mysql://192.168.31.170:3306/tcmdata";
	public static final String DEFAULT_jdbc_user = "root";
	public static final String DEFAULT_jdbc_password = "123456";
	public static final String DEFAULT_schedule = "* * * * *";
	public static final String DEFAULT_statement = "SELECT * FROM tcmdata.TABLENAME WHERE update_at >= :sql_last_value";
	public static final String DEFAULT_use_column_value = "true";
	public static final String DEFAULT_tracking_column_type = "timestamp";
	public static final String DEFAULT_tracking_column = "update_at";
	public static final String DEFAULT_last_run_metadata_path = "syncpoint_table_tablename";
	
	
	private static final String DEFAULT_es_user = "elastic";
	private static final String DEFAULT_es_password = "changeme";
	private static final String DEFAULT_es_hosts = "[\"localhost:9200\"]";
	private static final String DEFAULT_es_document_id = "%{id}";

	public LogstashConfig() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<LogstashConfigView> genLogstashConfig() throws ClassNotFoundException {
		Set<String> tables = ParseMysqlTableUtil.findTableName("org.iscas.web.entity");
		Set<LogstashConfigView> views = new LinkedHashSet<>();
		for(String tablename : tables) {
			Class<?> clazz = Class.forName(tablename);
		    RiverRule rule = RiverRule.extractRule(clazz,ElasticSearchConfig.ES_DOC_TYPE);
		    InputMysqlTable inputMysqlTable = new InputMysqlTable(
		    		DEFAULT_jdbc_driver_library, 
		    		DEFAULT_jdbc_driver_class, 
		    		DEFAULT_jdbc_connection_string,
		    		DEFAULT_jdbc_user,
		    		DEFAULT_jdbc_password,
		    		DEFAULT_schedule, 
		    		DEFAULT_statement.replace("TABLENAME", rule.targetIndex), 
		    		DEFAULT_use_column_value, 
		    		DEFAULT_tracking_column_type, 
		    		DEFAULT_tracking_column, 
		    		DEFAULT_last_run_metadata_path.replace("tablename", rule.targetIndex));
		    OutputEsIndex outputEsIndex = new OutputEsIndex(
		    		DEFAULT_es_hosts, 
		    		rule.targetIndex, 
		    		DEFAULT_es_user, 
		    		DEFAULT_es_password, 
		    		DEFAULT_es_document_id);
		    LogstashConfigView view = new LogstashConfigView(rule.targetIndex, inputMysqlTable, outputEsIndex);
		    views.add(view);
		    
//		    System.out.println(rule.targetIndex);
//		    System.out.println(rule.sourceTable.table);
//			System.out.println(tablename);
		}
		
		return views;
	}
	
	public static void main(String [] args) throws ClassNotFoundException {
		new LogstashConfig().genLogstashConfig();
	}

}
