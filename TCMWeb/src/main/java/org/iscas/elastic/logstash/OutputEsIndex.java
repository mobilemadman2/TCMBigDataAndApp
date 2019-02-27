package org.iscas.elastic.logstash;

public class OutputEsIndex extends LogstashOutput{
    public OutputEsIndex(String hosts, String index, String user, String password, String document_id) {
		super();
		this.hosts = hosts;
		this.index = index;
		this.user = user;
		this.password = password;
		this.document_id = document_id;
	}

	private String hosts;
    private String index;
    private String user;
    private String password;
    private String document_id;

	public OutputEsIndex() {
		// TODO Auto-generated constructor stub
	}

	public String getHosts() {
		return hosts;
	}

	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDocument_id() {
		return document_id;
	}

	public void setDocument_id(String document_id) {
		this.document_id = document_id;
	}

}
