package springboot.poject.exception;

public class DoctorNotFoundException extends RuntimeException {

	public DoctorNotFoundException(String message) {
		super(message);
	}

}
