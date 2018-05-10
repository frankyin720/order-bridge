package com.rw.orderbridge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrder extends BaseEntity<CustomerOrder> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true, nullable = false)
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonBackReference
    private Customer customer;
    @Column(name = "DIMENSION_WIDTH_FEET", nullable = false)
    private Integer dimensionWidthFeet;
    @Column(name = "DIMENSION_WIDTH_INCH")
    private Integer dimensionWidthInch;
    @Column(name = "DIMENSION_HEIGHT_FEET", nullable = false)
    private Integer dimensionHeightFeet;
    @Column(name = "DIMENSION_HEIGHT_INCH")
    private Integer dimensionHeightInch;
    @Column(name = "STYLE", nullable = false)
    private String style;
    @Column(name = "FACE_OPTION", nullable = false)
    private String faceOption;

    @Override
    public Integer getId() {
        return this.orderId;
    }

    @Override
    public void setId(Integer id) {
        this.orderId = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getDimensionWidthFeet() {
        return dimensionWidthFeet;
    }

    public void setDimensionWidthFeet(Integer dimensionWidthFeet) {
        this.dimensionWidthFeet = dimensionWidthFeet;
    }

    public Integer getDimensionWidthInch() {
        return dimensionWidthInch;
    }

    public void setDimensionWidthInch(Integer dimensionWidthInch) {
        this.dimensionWidthInch = dimensionWidthInch;
    }

    public Integer getDimensionHeightFeet() {
        return dimensionHeightFeet;
    }

    public void setDimensionHeightFeet(Integer dimensionHeightFeet) {
        this.dimensionHeightFeet = dimensionHeightFeet;
    }

    public Integer getDimensionHeightInch() {
        return dimensionHeightInch;
    }

    public void setDimensionHeightInch(Integer dimensionHeightInch) {
        this.dimensionHeightInch = dimensionHeightInch;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getFaceOption() {
        return faceOption;
    }

    public void setFaceOption(String faceOption) {
        this.faceOption = faceOption;
    }

}
