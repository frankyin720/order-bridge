package com.rw.orderbridge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rw.orderbridge.dao.GenericDAO;
import com.rw.orderbridge.model.Customer;

@Component
public class CustomerController {
    private final Logger Logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    @Qualifier("customerDao")
    private GenericDAO<Customer> customerDao;

    @Transactional(rollbackFor = Exception.class)
    public Customer addCustomer(Customer customer) {
        this.Logger.debug(this.getClass().getName() + ".createCustomer is invoked.");
        this.customerDao.create(customer);
        this.Logger.debug("Customer " + customer.getId() + " is created.");
        return customer;
    }

    @Transactional(rollbackFor = Exception.class)
    public Customer findCustomerByKey(String customerKey) {
        this.Logger.debug(this.getClass().getName() + ".createCustomer is invoked.");
        Customer customer = new Customer();
        customer.setCustomerKey(customerKey);
        customer = this.customerDao.findByExample(customer);
        this.Logger.debug("Customer " + customer.getId() + " is created.");
        return customer;
    }
}
