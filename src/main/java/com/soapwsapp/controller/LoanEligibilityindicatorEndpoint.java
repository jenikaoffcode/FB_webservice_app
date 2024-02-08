package com.soapwsapp.controller;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.MessageEndpoint;
import org.springframework.ws.server.endpoint.PayloadEndpoint;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.soapwsapp.model_loan.Acknowledgement;
import com.soapwsapp.model_loan.CustomerRequest;
import com.soapwsapp.model_loan.ObjectFactory;
import com.soapwsapp.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityindicatorEndpoint implements PayloadEndpoint{

    private static final String NAMESPACE = "http://www.soapwsapp.com/model_loan";

    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public JAXBElement<Acknowledgement> getLoanStatus(@RequestPayload JAXBElement<CustomerRequest> myRequest) {
        CustomerRequest request = myRequest.getValue();
        Acknowledgement acknowledgement = service.checkLoanEligibility(request);

        // Wrap the response in JAXBElement
        ObjectFactory objectFactory = new ObjectFactory();
        //JAXBElement<Acknowledgement> responseElement = objectFactory.createAcknowledgement(acknowledgement);

        return null;
    }
    
 
  
	@Override
	public Source invoke(Source request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

