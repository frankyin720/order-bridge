package com.rw.orderbridge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity<Customer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private Integer customerId;
    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;
    @Column(name = "CUSTOMER_KEY", nullable = false)
    private String customerKey;
    @OneToMany
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonManagedReference
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

    @Override
    public Integer getId() {
        return this.customerId;
    }

    @Override
    public void setId(Integer id) {
        this.customerId = id;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

}
