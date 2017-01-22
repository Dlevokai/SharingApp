package app.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Product;
import app.model.Greeting;
import app.repositories.ProductRepository;

@RestController
public class HelloController {
	@Autowired
	private ProductRepository productRepository;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(1, String.format(template, name));
	}

	@RequestMapping("/angularJsCall")
	public Greeting angularTest(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(10, String.format("angular call worked!", name));
	}
	
	@RequestMapping("/getH2Data")
	public Product getDataFromH2(@RequestParam(value = "name", defaultValue = "World") String name) {
		return productRepository.findOne(1);
	}
	
	//@RequestMapping("/testGetBOFAData")
	//public BOFA getBofaData()
}