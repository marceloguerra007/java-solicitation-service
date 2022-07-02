package br.com.margb.services.solicitationservice.model;

public class Response {
	
	private String message = "";
	
	private Object data;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	public Response(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}	
}
