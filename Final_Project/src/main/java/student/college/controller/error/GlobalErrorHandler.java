package student.college.controller.error;

import java.time.OffsetDateTime;
//import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

	private enum LogStatus {
		STACK_TRACE, MESSAGE_ONLY;
	}
	
	@Data
	private class ExceptionMessage {
		private String message;
		private String httpReason;
		private int httpCode;
		private String timestamp;
		private String uri;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionMessage handleNoSuchElementException(
						NoSuchElementException err, WebRequest httpRequest) {
		return buildExceptionMessage(err, HttpStatus.NOT_FOUND, httpRequest, LogStatus.MESSAGE_ONLY);
	}

	private ExceptionMessage buildExceptionMessage(NoSuchElementException err, HttpStatus httpStatus,
			WebRequest httpRequest, LogStatus logStatus) {
		String message = err.toString();
		String httpReason = httpStatus.getReasonPhrase();
		int httpCode = httpStatus.value();
		String uri = null;
		String timestamp = OffsetDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
		
		if(httpRequest instanceof ServletWebRequest swr) {
			uri = swr.getRequest().getRequestURI();
		}
		if(logStatus == LogStatus.MESSAGE_ONLY) {
			log.error("Exception {}", err.toString());
		}
		else {
			log.error("Exception {}", err);
		}
		
		ExceptionMessage exeMess = new ExceptionMessage();
		exeMess.setMessage(message);
		exeMess.setHttpReason(httpReason);
		exeMess.setHttpCode(httpCode);
		exeMess.setTimestamp(timestamp);
		exeMess.setUri(uri);
		
		return exeMess;
	}
}
