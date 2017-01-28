package app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import app.model.PlayerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Player;
import app.domain.Product;
import app.model.Greeting;
import app.repositories.PlayerRepository;
import app.repositories.ProductRepository;

@RestController
public class HelloController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
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
	
	@RequestMapping("/getPlayerList")
	public PlayerList getPlayerList() {
		Iterable<Player> playersIterator = playerRepository.findAll();
		List<Player> tempPlayersList = new ArrayList<Player>();
		for (Player player : playersIterator){
			tempPlayersList.add(player);
		}
		PlayerList jsonPlayerList = new PlayerList();
		jsonPlayerList.setPlayerList(tempPlayersList);
		return jsonPlayerList;
	}
	
	//@RequestMapping("/testGetBOFAData")
	//public BOFA getBofaData()
}