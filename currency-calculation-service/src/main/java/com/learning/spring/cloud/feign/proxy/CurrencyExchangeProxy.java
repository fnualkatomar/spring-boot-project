package com.learning.spring.cloud.feign.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.spring.cloud.model.CurrencyCalculatedModel;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//Blocking the below line so as to route the Feign client through Zuul Api Gateway rather calling directly
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//Blocking the above line so as to route the Feign client through Zuul Api Gateway rather calling directly. 
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyCalculatedModel retrieveExchangeValue(@PathVariable String from,@PathVariable String to);

}
