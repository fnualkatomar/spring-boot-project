package com.learning.spring.cloud.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.spring.cloud.feign.proxy.CurrencyExchangeProxy;
import com.learning.spring.cloud.model.CurrencyCalculatedModel;

@RestController
public class CurrencyCalculatorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-calculation/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCalculatedModel calculateCurrencyQuantity(@PathVariable String from,
				@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyCalculatedModel> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyCalculatedModel.class, uriVariables );
		CurrencyCalculatedModel currencyCalculatedModel = response.getBody();
		return new CurrencyCalculatedModel(currencyCalculatedModel.getId(),currencyCalculatedModel.getFrm(), currencyCalculatedModel.getTo(), currencyCalculatedModel.getConversionMultiple(), currencyCalculatedModel.getPort(), quantity, quantity.multiply(currencyCalculatedModel.getConversionMultiple()));
	}
	
	
	@GetMapping("/currency-calculation-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCalculatedModel calculateCurrencyQuantityFeign(@PathVariable String from,
				@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyCalculatedModel currencyCalculatedModel = proxy.retrieveExchangeValue(from, to);
		
		CurrencyCalculatedModel returnObj = new CurrencyCalculatedModel(currencyCalculatedModel.getId(),currencyCalculatedModel.getFrm(), currencyCalculatedModel.getTo(), currencyCalculatedModel.getConversionMultiple(), currencyCalculatedModel.getPort(), quantity, quantity.multiply(currencyCalculatedModel.getConversionMultiple()));
		logger.info("CurrencyCalculatedModel {}", returnObj);
		return returnObj;
	}
	
}
