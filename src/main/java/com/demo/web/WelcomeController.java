package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.demo.web.bean.Weather;

@Controller
public class WelcomeController {

	private String httpURL = "http://localhost:8002/api/v1/weather/";


	/**
	 * post entity
	 */
	public void postEntity(String accessToken) {
		System.out.println("Begin /POST request!");
		String postUrl = httpURL;

		Weather weather = new Weather("5", "2", "34", "34", "2019-01-30T09:23:17.501+0000");

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity<Object>(weather, getHeaderWithToken(accessToken));
		ResponseEntity<Weather> getResponse = restTemplate.exchange(postUrl, HttpMethod.POST, entity, Weather.class);

		if (getResponse.getBody() != null) {
			System.out.println("Response for post Request: " + getResponse.getBody().toString());
		} else {
			System.out.println("Response for post Request: NULL");
		}
	}

	/**
	 * get entity
	 */
	public String getEntity(String accessToken) {
		System.out.println("Begin /GET request!");
		String getUrl = "http://localhost:8002/api/v1/weather24/4";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(getHeaderWithToken(accessToken));
		ResponseEntity<String> getResponse = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
	
		if (getResponse.getBody() != null) {
			System.out.println("Response for Get Request: " + getResponse.getBody().toString());
		} else {
			System.out.println("Response for Get Request: NULL");
		}
		return "index";
	}

	/**
	 * put entity
	 */
	public void putEntity(String accessToken) {
		System.out.println("Begin /PUT request!");

		String putUrl = httpURL + 2;
		Weather weather = new Weather("10", "2 yee", "34", "34", "2019-01-30T09:23:17.501+0000");

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity<Object>(weather, getHeaderWithToken(accessToken));
		ResponseEntity<Weather> getResponse = restTemplate.exchange(putUrl, HttpMethod.PUT, entity, Weather.class);

		if (getResponse.getBody() != null) {
			System.out.println("Response for put Request: " + getResponse.getBody().toString());
		} else {
			System.out.println("Response for put Request: NULL");
		}

	}
	/**
	 * delete entity
	 */
	public void deleteEntity(String accessToken) {

		RestTemplate restTemplate = new RestTemplate();
		String deleteUrl = httpURL + 3;
		HttpEntity<?> entity = new HttpEntity<Object>(getHeaderWithToken(accessToken));
		ResponseEntity<String> getResponse = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, entity, String.class);

		if (getResponse.getBody() != null) {
			System.out.println("Response for delete Request: " + getResponse.getBody().toString());
		} else {
			System.out.println("Response for delete Request: NULL");
		}
	}
	/**
	 * patch entity
	 * 
	 * @throws JSONException
	 */

	public void patchEntity() throws JSONException {
		System.out.println("Begin /patch request.....................!");

//		RestTemplate restTemplate = new RestTemplate();
//
//		String putUrl = httpURL + 48;
//		Answer answer = new Answer();
//		answer.setAnswertext("A");
//
//		List<Answer> answerList = new ArrayList<>();
//		answerList.add(answer);
//
//		JSONObject updateBody = new JSONObject();
//		updateBody.put("questiontext", "Ryan");
//		Question question = new Question();
//		question.setQuestiontext("updated through patch");
//
//		HttpClient httpClient = HttpClientBuilder.create().build();
//		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
//
//		restTemplate.exchange(putUrl, HttpMethod.PATCH, getPostRequestHeaders(updateBody.toString()), Question.class);

	}

	public HttpEntity getPostRequestHeaders(String jsonPostBody) {
		List<MediaType> acceptTypes = new ArrayList<MediaType>();
		acceptTypes.add(MediaType.APPLICATION_JSON_UTF8);

		HttpHeaders reqHeaders = new HttpHeaders();
		reqHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		reqHeaders.setAccept(acceptTypes);

		return new HttpEntity<String>(jsonPostBody, reqHeaders);
	}

	
	public HttpHeaders getHeaderWithToken(String accessToken) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		return headers;
		
	}

}
