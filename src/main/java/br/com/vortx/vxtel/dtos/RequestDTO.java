package br.com.vortx.vxtel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

	private Integer origin;
	private Integer destiny;
	private Double minutes;
	private Integer plan;
}
