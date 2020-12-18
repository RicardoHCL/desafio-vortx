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

	public RequestDTO() {

	}

	public RequestDTO(Integer origin, Integer destiny, Double minutes, Integer plan) {
		this.origin = origin;
		this.destiny = destiny;
		this.minutes = minutes;
		this.plan = plan;
	}
}
