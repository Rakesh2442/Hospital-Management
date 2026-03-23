package springboot.poject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springboot.poject.dto.ResponseStructure;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNotFound(DoctorNotFoundException ex) {
		ResponseStructure<String> resp = new ResponseStructure<>();
		resp.setStatus(404);
		resp.setMsg(ex.getMessage());
		resp.setData(null);
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}

}
