package br.com.vortx.vxtel.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tariffs")
public class Tariff {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "origin")
	private Integer origin;

	@Column(name = "destiny")
	private Integer destiny;

	@Column(name = "value_minutes")
	private BigDecimal value;

	public Tariff() {

	}

	public Tariff(Integer origin, Integer destiny, BigDecimal value) {
		this.origin = origin;
		this.destiny = destiny;
		this.value = value;
	}

}
