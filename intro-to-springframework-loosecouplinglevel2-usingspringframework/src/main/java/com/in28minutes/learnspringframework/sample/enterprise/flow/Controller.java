/**
 * 
 */
package com.in28minutes.learnspringframework.sample.enterprise.flow;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author esliv
 *
 */

@RestController
public class Controller {
	@Autowired
	private BusinessService business;
	
	@GetMapping("/sum")
	public long displaySum() {
		return business.sumOfIntergers();
	}

}


@Component
class BusinessService {
	
	@Autowired
	private DataService data;
	public long sumOfIntergers() {
		 //Optional<Integer> reduce = data.getNumbers().stream().reduce((i,j) -> i+j);
		 Optional<Integer> reduce = data.getNumbers().stream().reduce(Integer::sum);
		 return reduce.get();
	}
}


@Component
class DataService {
	
	public List<Integer> getNumbers() {
		//Use this for java10 and above
		List<Integer> of = List.of(1,2,3,4,5,6);
		
		//Use this for java8 and below
		//List<Integer> asList = Arrays.asList(1,2,3,4,5,6);
		
		return of;
	}
}
