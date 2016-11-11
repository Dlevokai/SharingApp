package app.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import app.model.AccessKey;

@Controller
public class LoginController {

	private static String exchUrl = "https://tartan.plaid.com/exchange_token";
	private final String clientId = "581de9c046eb1241b342ce2b";
	private final String secret = "e579d40556f67c830b6e2375f02cdd";
	private final String publicToken = "";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "index.html";
	}

	@ResponseBody
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String plaidAuthentication(@RequestParam String public_token) {
		getAccessToken(clientId, secret, public_token);
		return public_token;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/exchange_token", method = RequestMethod.POST)
	 * public String plaidAuthenticationGetAccessKey(@RequestParam String
	 * public_token) { return public_token; }
	 */
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	 * public String getTest(@RequestParam String public_token) { return
	 * "get Request"; }
	 */

	public String getAccessToken(String clientId, String secret, String publicToken) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", clientId);
		map.add("secret", secret);
		map.add("public_token", publicToken);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<AccessKey> response = restTemplate.postForEntity(exchUrl, request, AccessKey.class);

		AccessKey body = response.getBody();
		System.out.println(body.getAccessToken());
		return body.getAccessToken();
	}
}
