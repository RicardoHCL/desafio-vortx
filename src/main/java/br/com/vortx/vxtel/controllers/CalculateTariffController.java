package br.com.vortx.vxtel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vortx.vxtel.constants.GenericConstants;
import br.com.vortx.vxtel.dtos.RequestDTO;
import br.com.vortx.vxtel.dtos.ResponseDTO;
import br.com.vortx.vxtel.services.CalculateTariffService;

@CrossOrigin
@RestController
@RequestMapping(GenericConstants.TARIFF_URL)
public class CalculateTariffController {
	
	@Autowired
	private CalculateTariffService service;
	
	@PostMapping
	public ResponseDTO calculateTariffs(@RequestBody RequestDTO request) {		
		
		return service.calculateTariffs(request);
	}

}
