
package com.rw.orderbridge.jsonschema;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customerName",
    "customerKey"
})
public class AddCustomerRequestSchema {

    /**
     * Customer name
     * (Required)
     * 
     */
    @JsonProperty("customerName")
    @JsonPropertyDescription("Customer name")
    private String customerName;
    /**
     * Customer key
     * (Required)
     * 
     */
    @JsonProperty("customerKey")
    @JsonPropertyDescription("Customer key")
    private String customerKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Customer name
     * (Required)
     * 
     */
    @JsonProperty("customerName")
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Customer name
     * (Required)
     * 
     */
    @JsonProperty("customerName")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Customer key
     * (Required)
     * 
     */
    @JsonProperty("customerKey")
    public String getCustomerKey() {
        return customerKey;
    }

    /**
     * Customer key
     * (Required)
     * 
     */
    @JsonProperty("customerKey")
    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerName).append(customerKey).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddCustomerRequestSchema) == false) {
            return false;
        }
        AddCustomerRequestSchema rhs = ((AddCustomerRequestSchema) other);
        return new EqualsBuilder().append(customerName, rhs.customerName).append(customerKey, rhs.customerKey).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
