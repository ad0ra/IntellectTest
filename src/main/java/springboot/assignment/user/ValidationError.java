package springboot.assignment.user;

public class ValidationError {

	private String code;
	private String field;
	private String Message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public ValidationError(String code, String field, String message) {
		super();
		this.code = code;
		this.field = field;
		Message = message;
	}
	public ValidationError() {
		super();
	}
	
	
}
