package edu.wccnet.mbrown99.pizzaApp.api;

public class OrderNotFoundErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
	
	public OrderNotFoundErrorResponse() {
		
	}

	public OrderNotFoundErrorResponse(int status, String message, long timeStamp) {
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
		return "OrderNotFoundErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp
				+ "]";
	}

}
