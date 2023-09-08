package com.example.demo.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	
	// Static Filtering
	@GetMapping("/staticfiltering")
	public SomeBean dynamicFiltering() {
		return new SomeBean("first","second","third");
	}
	
	@GetMapping("/static-filtering-list")
	public List<SomeBean> staticFilteringList() {
		
	    return  Arrays.asList(new SomeBean("first","second","third"),
	    					  new SomeBean("Hundred","two hundred","300"));
		
	}
	// End Of Static Filtering
	
	
	// Start Dynamic Filtering
	SimpleBeanPropertyFilter filt = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3"); 
	FilterProvider filterss = new SimpleFilterProvider().addFilter("someBeanFilter", filt);
	
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("first","second","third");
		MappingJacksonValue mappingValue= new MappingJacksonValue(someBean);
		mappingValue.setFilters(filterss);
		return mappingValue;
	}
	
	
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		
		List<SomeBean> blist = new ArrayList<>();
		blist.add(new SomeBean("first","second","third"));
		blist.add(new SomeBean("Hundred","two hundred","300"));
		
		MappingJacksonValue mapval = new MappingJacksonValue(blist);
		mapval.setFilters(filterss);
		
		return mapval;
	}
	
}
