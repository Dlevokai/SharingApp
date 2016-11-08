package app.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Greeting;

@RestController
public class HelloController {

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
	
	//@RequestMapping("/testGetBOFAData")
	//public BOFA getBofaData()
}