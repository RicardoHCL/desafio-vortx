package br.com.vortx.vxtel.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vortx.vxtel.constants.GenericConstants;
import br.com.vortx.vxtel.dtos.RequestDTO;
import br.com.vortx.vxtel.dtos.ResponseDTO;
import br.com.vortx.vxtel.enums.PlanEnum;
import br.com.vortx.vxtel.exceptions.InvalidDataException;
import br.com.vortx.vxtel.models.Tariff;
import br.com.vortx.vxtel.repositories.TariffRepository;

@Service
public class CalculateTariffService {

	@Autowired
	private TariffRepository repository;

	public ResponseDTO calculateTariffs(RequestDTO request) {

		Optional<Tariff> tariff = getFixedTariff(request.getOrigin(), request.getDestiny());
		tariff.orElseThrow(() -> new InvalidDataException(GenericConstants.DDD_NOT_FOUND_ERROR));

		Double minutes = Math.ceil(request.getMinutes());
		
		if(!isPlanValid(request.getPlan())) {
			throw new InvalidDataException(GenericConstants.INVALID_PLAN_ERROR); 
		}

		BigDecimal valueWithPlan = calculateValueTariffWithTalkMore(tariff.get().getValue(), minutes,
				request.getPlan());

		BigDecimal valueWithoutPlan = calculateValueTariffWithoutTalkMore(tariff.get().getValue(), minutes);

		return new ResponseDTO(valueWithPlan, valueWithoutPlan);
	}

	private BigDecimal calculateValueTariffWithTalkMore(BigDecimal value, Double minutes, Integer plan) {

		Double extraMinutes = minutes - plan.doubleValue();

		if (extraMinutes.compareTo(Double.valueOf(0)) < 0) {
			extraMinutes = 0D;
		}

		BigDecimal total = value.add(value.multiply(BigDecimal.valueOf(0.1))).multiply(BigDecimal.valueOf(extraMinutes))
				.setScale(2, RoundingMode.HALF_UP);

		return total;
	}

	private BigDecimal calculateValueTariffWithoutTalkMore(BigDecimal value, Double minutes) {
		BigDecimal total = value.multiply(BigDecimal.valueOf(minutes)).setScale(2, RoundingMode.HALF_UP);

		return total;
	}

	private Optional<Tariff> getFixedTariff(Integer origin, Integer destiny) {
		return repository.findByOriginAndDestiny(origin, destiny);
	}

	private boolean isPlanValid(Integer plan) {

		if (plan.equals(PlanEnum.TALK_MORE_30.getValue()) || plan.equals(PlanEnum.TALK_MORE_60.getValue())
				|| plan.equals(PlanEnum.TALK_MORE_120.getValue())) {
			return true;
		}

		return false;
	}

}
