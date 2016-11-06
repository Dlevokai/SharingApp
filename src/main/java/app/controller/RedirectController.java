package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedirectController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "index.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String plaidAuthentication(@RequestParam String public_token) {
		return public_token;
	}
	

	@ResponseBody
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public String getTest(@RequestParam String public_token) {
		return "get Request";
	}
}
