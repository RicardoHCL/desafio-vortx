package br.com.vortx.vxtel.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.vortx.vxtel.constants.GenericConstants;
import br.com.vortx.vxtel.dtos.RequestDTO;
import br.com.vortx.vxtel.dtos.ResponseDTO;
import br.com.vortx.vxtel.exceptions.ExceptionResponse;
import br.com.vortx.vxtel.exceptions.InvalidDataException;
import br.com.vortx.vxtel.models.Tariff;
import br.com.vortx.vxtel.repositories.TariffRepository;
import br.com.vortx.vxtel.services.CalculateTariffService;
import br.com.vortx.vxtel.utils.Utils;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateTariffControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalculateTariffService service;

	@MockBean
	private TariffRepository repository;

	@Test
	public void postTariffWithStatusCode200Test() throws Exception {

		Optional<Tariff> mockedTariff = Optional.of(new Tariff(11, 16, BigDecimal.valueOf(1.90)));

		Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class), Mockito.any(Integer.class)))
				.thenReturn(mockedTariff);

		ResponseDTO expectedResponse = new ResponseDTO(BigDecimal.valueOf(0.00), BigDecimal.valueOf(38.00));

		Mockito.when(service.calculateTariffs(Mockito.any(RequestDTO.class))).thenReturn(expectedResponse);

		RequestDTO request = new RequestDTO(11, 16, 20D, 30);

		mockMvc.perform(post(GenericConstants.TARIFF_URL).content(Utils.asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(Utils.asJsonString(expectedResponse)));
	}

	@Test
	public void postTariffWithStatusCode400Test_01() throws Exception {

		Mockito.when(service.calculateTariffs(Mockito.any(RequestDTO.class)))
				.thenThrow(new InvalidDataException(GenericConstants.INVALID_PLAN_ERROR));

		ExceptionResponse expectedResponse = new ExceptionResponse(Utils.getStringWithLocalDateTimeNow(),
				"Plano inválido.", "uri=/tariffs");

		RequestDTO request = new RequestDTO(11, 16, 20D, 50);

		mockMvc.perform(post(GenericConstants.TARIFF_URL).content(Utils.asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
				.andExpect(content().json(Utils.asJsonString(expectedResponse)));
	}

	@Test
	public void postTariffWithStatusCode400Test_02() throws Exception {

		Mockito.when(service.calculateTariffs(Mockito.any(RequestDTO.class)))
				.thenThrow(new InvalidDataException(GenericConstants.DDD_NOT_FOUND_ERROR));

		ExceptionResponse expectedResponse = new ExceptionResponse(Utils.getStringWithLocalDateTimeNow(),
				"DDDs de Origem e Destino não encontrados.", "uri=/tariffs");

		RequestDTO request = new RequestDTO(11, 16, 20D, 50);

		mockMvc.perform(post(GenericConstants.TARIFF_URL).content(Utils.asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
				.andExpect(content().json(Utils.asJsonString(expectedResponse)));
	}

}
