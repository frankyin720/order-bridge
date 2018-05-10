package com.rw.orderbridge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rw.orderbridge.dao.GenericDAO;
import com.rw.orderbridge.model.CustomerOrder;

@Component
public class CustomerOrderController {
    private final Logger Logger = LoggerFactory.getLogger(CustomerOrderController.class);

    @Autowired
    @Qualifier("customerOrderDao")
    private GenericDAO<CustomerOrder> customerOrderDao;

    @Transactional(rollbackFor = Exception.class)
    public CustomerOrder addCustomerOrder(CustomerOrder order) {
        this.Logger.debug(this.getClass().getName() + ".addCustomerOrder is invoked.");
        this.customerOrderDao.create(order);
        this.Logger.debug("Customer Order " + order.getId() + " is created.");
        return order;
    }

}
