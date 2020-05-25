package com.learning.rest.webservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learning.rest.webservices.bean.SomeDynaFilteringBean;

@RestController
public class FilteringControllerDyananic {
	//field1,field2 will be returned
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveBean() {
		
		SomeDynaFilteringBean dynamicBean = new SomeDynaFilteringBean("Value1","Value2","Value3");
		
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBean", filter );
		mappingJacksonValue.setFilters(filters );
		
		return mappingJacksonValue;
	}
	//field2,field3 will be returned
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveBeansList() {
		 List<SomeDynaFilteringBean> someDynaFilteringBeanList = Arrays.asList(
				new SomeDynaFilteringBean("Value1","Value2","Value3"),
				new SomeDynaFilteringBean("Value1","Value2","Value3"));
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		 FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBean", filter );
		 
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someDynaFilteringBeanList);
		mappingJacksonValue.setFilters(filters );
		 
		 return mappingJacksonValue;
	}

}
