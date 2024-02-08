package com.soapwsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soapwsapp.models.UserAttributes;
import com.soapwsapp.models.UserAttributesResponse;
import com.soapwsapp.models.UserAttributesResponse.UserAttributesResult;


@Service
public class UserAttributsService {


	public UserAttributesResponse getUserAttributesResponse_Data(UserAttributes attributs) {
		System.out.println("hh");
		UserAttributesResponse response = new UserAttributesResponse();
		UserAttributesResult data = response.getUserAttributesResult();
		data.getContent();
		response.setUserAttributesResult(data);
		return response;
	}
}
