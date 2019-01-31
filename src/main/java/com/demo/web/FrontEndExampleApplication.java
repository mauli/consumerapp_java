package com.demo.web;

import java.security.Principal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FrontEndExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontEndExampleApplication.class, args);
	}

	//@GetMapping("/welcome")
	public String echoTheUsersEmailAddress(Principal principal) {
		return "Hey there! Your email address is: " + principal;
	}

	@PostMapping(value = "/save")
	public String postCustomer(@RequestBody String token) {
		WelcomeController restfulClient = new WelcomeController();
		try {
			JSONArray jsonObj = new JSONArray(token);
			JSONObject jsonObj1 = (JSONObject) jsonObj.get(0);
			System.out.println("Access Token==" + jsonObj1.getString("accessToken"));

			restfulClient.postEntity(jsonObj1.getString("accessToken"));
			restfulClient.getEntity(jsonObj1.getString("accessToken"));
			restfulClient.putEntity(jsonObj1.getString("accessToken"));
			restfulClient.deleteEntity(jsonObj1.getString("accessToken"));


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Post Successfully!";
	}

}