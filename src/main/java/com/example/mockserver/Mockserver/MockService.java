package com.example.mockserver.Mockserver;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class MockService {

	// comments
	@PostMapping(value = "/getMockResponse")
	public ResponseEntity<?> getMockResponse(@RequestBody JSONObject request) {
		String response = getResponse();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getMockResponseV2")
	public ResponseEntity<TestPojo> getMockResponseV2(@RequestBody JSONObject request) {
		TestPojo response = new TestPojo();
		response.setfName("first");
		response.setlName("last");
		Address address = new Address();
		Contact contact = new Contact();
		contact.setEmail("test@gmail.com");
		contact.setPhn("29847835");
		
		address.setAddress("Hyd");
		address.setContact(contact);
		response.setAddress(address);
		return new ResponseEntity<TestPojo>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getMockResponseV1")
	public ResponseEntity<?> getMockResponseV1(@RequestBody JSONObject request) {
		String response = "test";
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getMockResponseV3")
	public ResponseEntity<?> getMockResponseV3(@RequestBody JSONObject request) {
		String response = "test";
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/getMockResponseV4")
	public ResponseEntity<Object> getMockResponseV4(@RequestBody JSONObject request) {
		TestPojo response = new TestPojo();
		response.setfName("first");
		response.setlName("last");
		Address address = new Address();
		Contact contact = new Contact();
		contact.setEmail("test@gmail.com");
		contact.setPhn("29847835");
		
		address.setAddress("Hyd");
		address.setContact(contact);
		response.setAddress(address);
		
		String res = response.toString();
		
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getMockResponseV5")
	public ResponseEntity<Object> getMockResponseV5(@RequestBody JSONObject request) {
		String res = "{\"fName\":\"first\",\"lName\":\"last\",\"address\":{\"contact\":{\"email\":\"test@gmail.com\",\"phn\":\"29847835\"},\"address\":\"Hyd\"}}";
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	public String getResponse() {
		String json = null;
		File fileObj = new File("src/main/resources/response2.json");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			Object re = objectMapper.readValue(fileObj, Object.class);
			Gson gson = new Gson();
			json = gson.toJson(re);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}
