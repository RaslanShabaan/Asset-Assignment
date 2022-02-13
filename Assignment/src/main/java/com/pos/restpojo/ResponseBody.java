package com.pos.restpojo;

public class ResponseBody {

// response body for login
	private String message;
	private long   isTrue;
	private long  timeStamp;
	private String userId;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ResponseBody() {
		super();
	}
	public long getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(long isTrue) {
		this.isTrue = isTrue;
	}
	public ResponseBody(Integer state, String message, long timeStamp,long isTrue,String userId,String token) {
		super();
		this.isTrue = isTrue;
//		this.state = state;
		this.userId = userId;
		this.message = message;
		this.timeStamp = timeStamp;
		this.token   = token;
	}
//	public Integer getState() {
//		return state;
//	}
//	public void setState(Integer state) {
//		this.state = state;
//	}
	
	public ResponseBody(Integer state, String message, long timeStamp,long isTrue,String userId ) {
		super();
		this.isTrue = isTrue;
//		this.state = state;
		this.userId = userId;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
}
