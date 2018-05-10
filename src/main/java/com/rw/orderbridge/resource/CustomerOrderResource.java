package com.rw.orderbridge.resource;

import javax.ws.rs.Consumes;
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
import com.rw.orderbridge.controller.CustomerOrderController;
import com.rw.orderbridge.exception.ApplicationException;
import com.rw.orderbridge.jsonschema.AddCustomerOrderRequestSchema;
import com.rw.orderbridge.model.Customer;
import com.rw.orderbridge.model.CustomerOrder;
import com.rw.orderbridge.transformer.CustomerTransformer;
import com.rw.orderbridge.transformer.ResponseBuilder;
import com.rw.orderbridge.util.JSONValidator;

@Component
@Path("/order")
public class CustomerOrderResource {
    private Logger logger = LoggerFactory.getLogger(CustomerOrderResource.class);

    @Autowired
    @Qualifier("jsonValidator")
    private JSONValidator jsonValidator;

    @Autowired
    @Qualifier("customerController")
    private CustomerController customerController;
    
    @Autowired
    @Qualifier("customerOrderController")
    private CustomerOrderController customerOrderController;

    @Autowired
    @Qualifier("addCustomerOrderRequestSchema")
    private String addCustomerOrderRequestSchema;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomerOrder(AddCustomerOrderRequestSchema request) throws Exception {
        this.logger.debug(this.getClass().getName() + ".addCustomerOrder is invoked");
        this.jsonValidator.validateJson(addCustomerOrderRequestSchema, request);
        Customer customer = this.customerController.findCustomerByKey(request.getCustomerKey());
        if (customer == null) {
            throw new ApplicationException("Customer " + request.getCustomerKey() + " does not exist");
        }
        CustomerOrder order = CustomerTransformer.addCustomerOrderRequest(request);
        order.setCustomer(customer);
        order = this.customerOrderController.addCustomerOrder(order);
        this.logger.debug("Customer order " + order.getId() + " is created");
        return ResponseBuilder.buildResponse(order.getId());
    }
}
