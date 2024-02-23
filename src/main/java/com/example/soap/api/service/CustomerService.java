package com.example.soap.api.service;

import com.example.soap.api.customersearch.AddCustomerRequest;
import com.example.soap.api.customersearch.AddCustomerResponse;
import com.example.soap.api.customersearch.DeleteCustomerRequest;
import com.example.soap.api.customersearch.DeleteCustomerResponse;
import com.example.soap.api.customersearch.GetCustomerRequest;
import com.example.soap.api.customersearch.GetCustomerResponse;
import com.example.soap.api.customersearch.UpdateCustomerRequest;
import com.example.soap.api.customersearch.UpdateCustomerResponse;

public interface CustomerService {
	
	public AddCustomerResponse addCustomer(AddCustomerRequest request);
	
	public GetCustomerResponse getCustomer(GetCustomerRequest request);
	
	public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);
	
	public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request);

}
