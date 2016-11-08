package app.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RedirectController {
	
	private static String exchUrl = "https://tartan.plaid.com/exchange_token";
	private final String clientId = "/?=581de9c046eb1241b342ce2b";
	private final String secret = "/?=e579d40556f67c830b6e2375f02cdd";
	private final String publicToken = "";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "index.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String plaidAuthentication(@RequestParam String public_token) {
		getAccessToken(clientId, secret, "/?=" + public_token);
		return public_token;
	}
	
	@ResponseBody
	@RequestMapping(value = "/exchange_token", method = RequestMethod.POST)
	public String plaidAuthenticationGetAccessKey(@RequestParam String public_token) {
		return public_token;
	}
	
/*
	@ResponseBody
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public String getTest(@RequestParam String public_token) {
		return "get Request";
	}*/
	
	private void getAccessToken(String clientId, String secret, String publicToken)
	{
		String url = exchUrl + clientId + secret + publicToken;
	    RestTemplate restTemplate = new RestTemplate();
	    HttpEntity<String> entity =  restTemplate.getForEntity(url, String.class);
	    String body = entity.getBody();
	    System.out.println(body);
	}
}
