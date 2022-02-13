package com.pos.Exception;


import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
// exception handler class
@ControllerAdvice
public class CustomExceptionHandeler extends ResponseEntityExceptionHandler {
	// catch exceptions
	@ExceptionHandler(Exception.class)
	final ResponseEntity<ExceptionHandelModel> catchExceptions(Exception ex) {
		ExceptionHandelModel exception = new ExceptionHandelModel("... عفوا حدث خطا ما", ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString(),new Date());
		return new ResponseEntity<ExceptionHandelModel>(exception, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
// exception resrpnse class
	class ExceptionHandelModel {
		private String message;
		private String details;
		private String statuscode;
		private Date exceptiontime;
		public Date getExceptiontime() {
			return exceptiontime;
		}

		public void setExceptiontime(Date exceptiontime) {
			this.exceptiontime = exceptiontime;
		}

		ExceptionHandelModel(String message, String details, String statuscode,Date exceptiontime) {
			super();
			this.message = message;
			this.details = details;
			this.statuscode = statuscode;
			this.exceptiontime=exceptiontime;
		}

		public String getStatuscode() {
			return statuscode;
		}

		public void setStatuscode(String statuscode) {
			this.statuscode = statuscode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

	}
}
