package edu.wccnet.mbrown99.pizzaApp.api;

public class CustomerNotFoundErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
	
	public CustomerNotFoundErrorResponse() {
		
	}

	public CustomerNotFoundErrorResponse(int status, String message, long timeStamp) {
		setStatus(status);
		setMessage(message);
		setTimeStamp(timeStamp);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "CustomerNotFoundErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp
				+ "]";
	}
	
}
