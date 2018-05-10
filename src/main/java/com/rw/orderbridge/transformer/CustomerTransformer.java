package com.rw.orderbridge.transformer;

import java.util.Date;

import com.rw.orderbridge.jsonschema.AddCustomerOrderRequestSchema;
import com.rw.orderbridge.jsonschema.AddCustomerRequestSchema;
import com.rw.orderbridge.model.Customer;
import com.rw.orderbridge.model.CustomerOrder;

public class CustomerTransformer {
    private static final String SYSTEM_USER = "system";

    private CustomerTransformer() {/* Do not construct */
    }

    public static Customer addCustomerRequest(AddCustomerRequestSchema request) {
        Customer customer = new Customer();
        customer.setCustomerName(request.getCustomerName());
        customer.setCustomerKey(request.getCustomerKey());
        customer.setCreatedTime(new Date());
        customer.setCreatedUser(SYSTEM_USER);
        return customer;
    }

    public static CustomerOrder addCustomerOrderRequest(AddCustomerOrderRequestSchema request) {
        CustomerOrder order = new CustomerOrder();
        order.setDimensionWidthFeet(request.getDimensionWidthFeet());
        order.setDimensionWidthInch(request.getDimensionWidthInch());
        order.setDimensionHeightFeet(request.getDimensionHeightFeet());
        order.setDimensionHeightInch(request.getDimensionHeightInch());
        order.setStyle(request.getStyle());
        order.setFaceOption(request.getFaceOption());
        order.setCreatedTime(new Date());
        order.setCreatedUser(SYSTEM_USER);
        return order;
    }
}