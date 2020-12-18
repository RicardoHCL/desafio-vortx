package br.com.vortx.vxtel.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime date;
	private String message;
	private String description;

	public ExceptionResponse(LocalDateTime date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}

}
