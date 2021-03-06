package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import app.model.Credentials;

@Controller
public class PlaidLoginController {

	@Autowired
	private Credentials credentials;

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

		//credentials.setDynamicAccessToken(accessToken);
		return public_token;
	}

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
		System.out.println(body);
		return body.getAccessToken();
	}
}
