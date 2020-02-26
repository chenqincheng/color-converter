package exception;

public class OutOfBoundsException extends Exception {
	public OutOfBoundsException(String message) {
		super("Color coordinates are out of bounds: " + message);
	}

	public OutOfBoundsException(String message, Throwable e) {
		super("Color coordinates are out of bounds: " + message, e);
	}

	public String getMessage() {
		return super.getMessage();
	}

	public void printStackTrace() {
		super.printStackTrace();
	}
}