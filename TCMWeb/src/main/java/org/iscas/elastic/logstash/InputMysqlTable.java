package org.iscas.elastic.logstash;

public class InputMysqlTable extends LogstashInput{
    public InputMysqlTable(String jdbc_driver_library, String jdbc_driver_class, String jdbc_connection_string,
			String jdbc_user, String jdbc_password, String schedule, String statement, String use_column_value,
			String tracking_column_type, String tracking_column, String last_run_metadata_path) {
		super();
		this.jdbc_driver_library = jdbc_driver_library;
		this.jdbc_driver_class = jdbc_driver_class;
		this.jdbc_connection_string = jdbc_connection_string;
		this.jdbc_user = jdbc_user;
		this.jdbc_password = jdbc_password;
		this.schedule = schedule;
		this.statement = statement;
		this.use_column_value = use_column_value;
		this.tracking_column_type = tracking_column_type;
		this.tracking_column = tracking_column;
		this.last_run_metadata_path = last_run_metadata_path;
	}


	private String jdbc_driver_library;
    private String jdbc_driver_class;
    private String jdbc_connection_string;
    private String jdbc_user;
    private String jdbc_password;
    private String schedule;
    private String statement;
    private String use_column_value;
    private String tracking_column_type;
    private String tracking_column;
    private String last_run_metadata_path;
    

	public InputMysqlTable() {
		// TODO Auto-generated constructor stub
	}


	public String getJdbc_driver_library() {
		return jdbc_driver_library;
	}


	public void setJdbc_driver_library(String jdbc_driver_library) {
		this.jdbc_driver_library = jdbc_driver_library;
	}


	public String getJdbc_driver_class() {
		return jdbc_driver_class;
	}


	public void setJdbc_driver_class(String jdbc_driver_class) {
		this.jdbc_driver_class = jdbc_driver_class;
	}


	public String getJdbc_connection_string() {
		return jdbc_connection_string;
	}


	public void setJdbc_connection_string(String jdbc_connection_string) {
		this.jdbc_connection_string = jdbc_connection_string;
	}


	public String getJdbc_user() {
		return jdbc_user;
	}


	public void setJdbc_user(String jdbc_user) {
		this.jdbc_user = jdbc_user;
	}


	public String getJdbc_password() {
		return jdbc_password;
	}


	public void setJdbc_password(String jdbc_password) {
		this.jdbc_password = jdbc_password;
	}


	public String getSchedule() {
		return schedule;
	}


	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


	public String getStatement() {
		return statement;
	}


	public void setStatement(String statement) {
		this.statement = statement;
	}


	public String getUse_column_value() {
		return use_column_value;
	}


	public void setUse_column_value(String use_column_value) {
		this.use_column_value = use_column_value;
	}


	public String getTracking_column_type() {
		return tracking_column_type;
	}


	public void setTracking_column_type(String tracking_column_type) {
		this.tracking_column_type = tracking_column_type;
	}


	public String getTracking_column() {
		return tracking_column;
	}


	public void setTracking_column(String tracking_column) {
		this.tracking_column = tracking_column;
	}


	public String getLast_run_metadata_path() {
		return last_run_metadata_path;
	}


	public void setLast_run_metadata_path(String last_run_metadata_path) {
		this.last_run_metadata_path = last_run_metadata_path;
	}

}
