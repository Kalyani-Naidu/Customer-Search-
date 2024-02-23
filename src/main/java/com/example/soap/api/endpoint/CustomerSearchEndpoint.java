package com.example.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soap.api.customersearch.AddCustomerRequest;
import com.example.soap.api.customersearch.AddCustomerResponse;
import com.example.soap.api.customersearch.DeleteCustomerRequest;
import com.example.soap.api.customersearch.DeleteCustomerResponse;
import com.example.soap.api.customersearch.GetCustomerRequest;
import com.example.soap.api.customersearch.GetCustomerResponse;
import com.example.soap.api.customersearch.UpdateCustomerRequest;
import com.example.soap.api.customersearch.UpdateCustomerResponse;
import com.example.soap.api.service.CustomerService;

@Endpoint
public class CustomerSearchEndpoint {
	
	@Autowired
	private CustomerService customerService;
	
	private static final String NAMESPACE = "http://www.example.com/soap/api/customerSearch";
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "addCustomerRequest")
	@ResponsePayload
	public AddCustomerResponse addCustomer(@RequestPayload AddCustomerRequest request) {
		AddCustomerResponse response = customerService.addCustomer(request);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "getCustomerRequest")
	@ResponsePayload
	public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
		GetCustomerResponse response = customerService.getCustomer(request);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "updateCustomerRequest")
	@ResponsePayload
	public UpdateCustomerResponse updateCustomer(@RequestPayload UpdateCustomerRequest request) {
		UpdateCustomerResponse response = customerService.updateCustomer(request);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "deleteCustomerRequest")
	@ResponsePayload
	public DeleteCustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request) {
		DeleteCustomerResponse response = customerService.deleteCustomer(request);
		return response;
	}
	
}
