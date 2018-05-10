package com.rw.orderbridge.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rw.orderbridge.controller.CustomerController;
import com.rw.orderbridge.jsonschema.AddCustomerRequestSchema;
import com.rw.orderbridge.model.Customer;
import com.rw.orderbridge.transformer.CustomerTransformer;
import com.rw.orderbridge.transformer.ResponseBuilder;
import com.rw.orderbridge.util.JSONValidator;

@Component
@Path("/customer")
public class CustomerResource {
    private Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    @Qualifier("jsonValidator")
    private JSONValidator jsonValidator;
    
    @Autowired
    @Qualifier("customerController")
    private CustomerController customerController;
    
    @Autowired
    @Qualifier("addCustomerRequestSchema")
    private String addCustomerRequestSchema;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(AddCustomerRequestSchema request) throws Exception {
        this.logger.debug(this.getClass().getName() + ".addCustomer is invoked");
        this.jsonValidator.validateJson(addCustomerRequestSchema, request);
        Customer customer = CustomerTransformer.addCustomerRequest(request);
        customer = this.customerController.addCustomer(customer);
        this.logger.debug("Customer " + customer.getId() + " is created");
        return ResponseBuilder.buildResponse(customer.getId());
    }
}
