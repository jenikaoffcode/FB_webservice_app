package com.soapwsapp.controller;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soapwsapp.models.UserAttributes;
import com.soapwsapp.models.UserAttributesResponse;
import com.soapwsapp.service.UserAttributsService;

@Endpoint
public class WsApiController {

    private static final String NAMESPACE_URI = "http://www.soapwsapp.com/models";

	@Autowired
	private UserAttributsService service;
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "userAttributes")
	@ResponsePayload
	public UserAttributesResponse getuserSttus(@RequestPayload UserAttributes request) {
	    return service.getUserAttributesResponse_Data(request);
	}

//	
//	  
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "userAttributesResponse")
//	@ResponsePayload
//	public UserAttributesResponse handleUserAttributesResponse(@RequestPayload UserAttributesResponse request) {
//	    // Your logic to handle the response
//	    return request;
//	}
//
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "user")
//	@ResponsePayload
//	public UserAttributes getLoanStatus_String(@RequestPayload String username,String password) {
//		UserAttributes user=new UserAttributes();
//		return user;
//	}

}










//private static final String NAMESPACE_URI = "http://com.soapwsapp.generated";
//
//@PayloadRoot(namespace = NAMESPACE_URI, localPart = "userAttributes")
//@ResponsePayload
//public UserAttributesResponse getUserAttributes(@RequestPayload UserAttributesResult userAttributes) {
//	System.out.println(userAttributes);
//	UserAttributesResponse response = new UserAttributesResponse();
//	 response.setUserAttributesResult(userAttributes);
//	return response;
//}

