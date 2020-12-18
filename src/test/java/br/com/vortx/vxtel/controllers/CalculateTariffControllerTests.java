package br.com.vortx.vxtel.controllers;
//package br.com.vortx.vxtel.controllers;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import br.com.vortx.vxtel.constants.GenericConstants;
//import br.com.vortx.vxtel.dtos.RequestDTO;
//import br.com.vortx.vxtel.dtos.ResponseDTO;
//import br.com.vortx.vxtel.services.CalculateTariffService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = CalculateTariffController.class)
//public class CalculateTariffController {
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private CalculateTariffService service;	
//
//	@Test
//	public void postTariffsTest() throws Exception {
//
//		ResponseDTO expectedResponse = new ResponseDTO(BigDecimal.valueOf(17.00), BigDecimal.valueOf(68.00));
//
//		Mockito.when(service.calculateTariffs(Mockito.any(RequestDTO.class))).thenReturn(expectedResponse);
//
//		RequestDTO request = new RequestDTO(11, 17, 80D, 60);
//		
//
//		mockMvc.perform(MockMvcRequestBuilders.post(GenericConstants.TARIFF_URL, request))
//				.andExpect(MockMvcResultMatchers.status().isOk());
//				
//	}
//
//}
