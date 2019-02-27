package org.iscas.elastic.logstash;

public class LogstashConfigView {

	private String type;
	private LogstashInput input;
	private LogstashOutput output;
	
	public LogstashConfigView(String type, LogstashInput input, LogstashOutput output) {
		super();
		this.type = type;
		this.input = input;
		this.output = output;
	}

	public LogstashConfigView() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LogstashInput getInput() {
		return input;
	}

	public void setInput(LogstashInput input) {
		this.input = input;
	}

	public LogstashOutput getOutput() {
		return output;
	}

	public void setOutput(LogstashOutput output) {
		this.output = output;
	}

}
