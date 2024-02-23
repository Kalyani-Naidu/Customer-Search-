package com.example.soap.api.serviceImpl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soap.api.customersearch.AddCustomerRequest;
import com.example.soap.api.customersearch.AddCustomerResponse;
import com.example.soap.api.customersearch.CustomerDetails;
import com.example.soap.api.customersearch.DeleteCustomerRequest;
import com.example.soap.api.customersearch.DeleteCustomerResponse;
import com.example.soap.api.customersearch.GetCustomerRequest;
import com.example.soap.api.customersearch.GetCustomerResponse;
import com.example.soap.api.customersearch.Status;
import com.example.soap.api.customersearch.UpdateCustomerRequest;
import com.example.soap.api.customersearch.UpdateCustomerResponse;
import com.example.soap.api.entities.CustomerData;
import com.example.soap.api.repository.CustomerRepository;
import com.example.soap.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public AddCustomerResponse addCustomer(AddCustomerRequest request) {
		CustomerData data = new CustomerData();
		BeanUtils.copyProperties(request.getCustomerDetails(), data, "cif");
		data.setCif(request.getCustomerDetails().getCif());
		AddCustomerResponse response = new AddCustomerResponse();
		Status status = new Status();
		try {
			repo.save(data);
			status.setStatusCode("R");
			status.setStatusDesc("AddCustomerRequest successful");
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatusCode("F");
			status.setStatusDesc("AddCustomerRequest failed");
		}
		response.setStatus(status);
		return response;
	}

	@Override
	public GetCustomerResponse getCustomer(GetCustomerRequest request) {
		GetCustomerResponse response = new GetCustomerResponse();
		Status status = new Status();
		try {
			Optional<CustomerData> customerOptional = repo.findById(request.getCif());
			if (customerOptional.isPresent()) {
				CustomerData customerData  = customerOptional.get();
				CustomerDetails customer = new CustomerDetails();
			  BeanUtils.copyProperties(customerData,customer);
			  response.setCustomerDetails(customer);
			    // Process customerData
			} else {
			    // Handle the case where the customer data is not found
			    throw new NoSuchElementException("Customer not found");
			}
			status.setStatusCode("R");
			status.setStatusDesc("GetCustomerRequest successful");
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatusCode("F");
			status.setStatusDesc("GetCustomerRequest failed");
		}
		response.setStatus(status);
		System.out.println("response: "+response);
		return response;
	}

	@Override
	public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
		CustomerData data = new CustomerData();
		BeanUtils.copyProperties(request.getCustomerDetails(), data);
		UpdateCustomerResponse response = new UpdateCustomerResponse();
		Status status = new Status();
		try {
			if(repo.existsById(data.getCif())) {
				Optional<CustomerData> custData = repo.findById(data.getCif());
				CustomerData customer = custData.get();
				customer.setCivilId(data.getCivilId());
				customer.setCustomerName(data.getCustomerName());
				customer.setEmail(data.getEmail());
				customer.setNationality(data.getNationality());
				repo.save(customer);
			}
			status.setStatusCode("R");
			status.setStatusDesc("UpdateCustomerRequest successful");
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatusCode("F");
			status.setStatusDesc("UpdateCustomerRequest failed");
		}
		response.setStatus(status);
		return response;
	}

	@Override
	public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request) {
		CustomerData data = new CustomerData();
		data.setCif(request.getCif());
		DeleteCustomerResponse response = new DeleteCustomerResponse();
		Status status = new Status();
		try {
				repo.deleteById(data.getCif());
			status.setStatusCode("R");
			status.setStatusDesc("DeleteCustomerRequest successful");
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatusCode("F");
			status.setStatusDesc("DeleteCustomerRequest failed");
		}
		response.setStatus(status);
		return response;
	}
	
	

}
