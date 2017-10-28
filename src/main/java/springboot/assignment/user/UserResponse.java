package springboot.assignment.user;

public class UserResponse {

	private String resMsg;
	private String userId;
	private ValidationError valErrors;
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public UserResponse(String resMsg, String userId, ValidationError valErrors) {
		super();
		this.resMsg = resMsg;
		this.userId = userId;
		this.valErrors = valErrors;
	}
	public ValidationError getValErrors() {
		return valErrors;
	}
	public void setValErrors(ValidationError valErrors) {
		this.valErrors = valErrors;
	}
	public UserResponse() {
		super();
	}
	
}
