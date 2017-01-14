package app.model;

import org.springframework.stereotype.Component;

@Component
public class Credentials {
	
	public static final String client_id = "581de9c046eb1241b342ce2b";
	public static final String secret = "e579d40556f67c830b6e2375f02cdd";
	public static final String access_token = "61eb76299d72c360dd17cfaef5e6c35b0b3a68cd0db4e50438616b59c9e1a0ab6dfe4f73da5c2eaf6f09e719a5a4ae244f8c8e2ae46916af0303447b910ed3e7c690f8db98ba01374a9207f53f45e82a";

	public String dynamicClientId;
	public String dynamicSecret;
	public String dynamicAccessToken;
	
	public static String getClientId() {
		return client_id;
	}
	public static String getSecret() {
		return secret;
	}
	public static String getAccessToken() {
		return access_token;
	}
	public String getDynamicClientId() {
		return dynamicClientId;
	}
	public void setDynamicClientId(String dynamicClientId) {
		this.dynamicClientId = dynamicClientId;
	}
	public String getDynamicSecret() {
		return dynamicSecret;
	}
	public void setDynamicSecret(String dynamicSecret) {
		this.dynamicSecret = dynamicSecret;
	}
	public String getDynamicAccessToken() {
		return dynamicAccessToken;
	}
	public void setDynamicAccessToken(String dynamicAccessToken) {
		this.dynamicAccessToken = dynamicAccessToken;
	}
}
