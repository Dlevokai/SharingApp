package app.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import app.model.BankData;
import app.model.Credentials;

@RestController
public class DataController {

	public static final String BalanceUrl = "https://tartan.plaid.com/balance";
	
	@RequestMapping("/getBankData")
	public BankData getBankData(){
		//Credentials.getsecret,getkey
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", Credentials.getClientId());
		map.add("secret", Credentials.getSecret());
		map.add("access_token", Credentials.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<BankData> response = restTemplate.postForEntity(BalanceUrl, request, BankData.class);

		BankData bankData = response.getBody();
		
		return bankData;
	}
}
