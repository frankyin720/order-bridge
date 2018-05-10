
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
    "customerKey",
    "dimensionWidthFeet",
    "dimensionWidthInch",
    "dimensionHeightFeet",
    "dimensionHeightInch",
    "style",
    "faceOption"
})
public class AddCustomerOrderRequestSchema {

    /**
     * Customer key
     * (Required)
     * 
     */
    @JsonProperty("customerKey")
    @JsonPropertyDescription("Customer key")
    private String customerKey;
    /**
     * Dimension Width Feet
     * (Required)
     * 
     */
    @JsonProperty("dimensionWidthFeet")
    @JsonPropertyDescription("Dimension Width Feet")
    private Integer dimensionWidthFeet;
    /**
     * Dimension Width Inch
     * 
     */
    @JsonProperty("dimensionWidthInch")
    @JsonPropertyDescription("Dimension Width Inch")
    private Integer dimensionWidthInch;
    /**
     * Dimension Height Feet
     * (Required)
     * 
     */
    @JsonProperty("dimensionHeightFeet")
    @JsonPropertyDescription("Dimension Height Feet")
    private Integer dimensionHeightFeet;
    /**
     * Dimension Height Inch
     * 
     */
    @JsonProperty("dimensionHeightInch")
    @JsonPropertyDescription("Dimension Height Inch")
    private Integer dimensionHeightInch;
    /**
     * Style
     * (Required)
     * 
     */
    @JsonProperty("style")
    @JsonPropertyDescription("Style")
    private String style;
    /**
     * Face Option
     * (Required)
     * 
     */
    @JsonProperty("faceOption")
    @JsonPropertyDescription("Face Option")
    private String faceOption;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * Dimension Width Feet
     * (Required)
     * 
     */
    @JsonProperty("dimensionWidthFeet")
    public Integer getDimensionWidthFeet() {
        return dimensionWidthFeet;
    }

    /**
     * Dimension Width Feet
     * (Required)
     * 
     */
    @JsonProperty("dimensionWidthFeet")
    public void setDimensionWidthFeet(Integer dimensionWidthFeet) {
        this.dimensionWidthFeet = dimensionWidthFeet;
    }

    /**
     * Dimension Width Inch
     * 
     */
    @JsonProperty("dimensionWidthInch")
    public Integer getDimensionWidthInch() {
        return dimensionWidthInch;
    }

    /**
     * Dimension Width Inch
     * 
     */
    @JsonProperty("dimensionWidthInch")
    public void setDimensionWidthInch(Integer dimensionWidthInch) {
        this.dimensionWidthInch = dimensionWidthInch;
    }

    /**
     * Dimension Height Feet
     * (Required)
     * 
     */
    @JsonProperty("dimensionHeightFeet")
    public Integer getDimensionHeightFeet() {
        return dimensionHeightFeet;
    }

    /**
     * Dimension Height Feet
     * (Required)
     * 
     */
    @JsonProperty("dimensionHeightFeet")
    public void setDimensionHeightFeet(Integer dimensionHeightFeet) {
        this.dimensionHeightFeet = dimensionHeightFeet;
    }

    /**
     * Dimension Height Inch
     * 
     */
    @JsonProperty("dimensionHeightInch")
    public Integer getDimensionHeightInch() {
        return dimensionHeightInch;
    }

    /**
     * Dimension Height Inch
     * 
     */
    @JsonProperty("dimensionHeightInch")
    public void setDimensionHeightInch(Integer dimensionHeightInch) {
        this.dimensionHeightInch = dimensionHeightInch;
    }

    /**
     * Style
     * (Required)
     * 
     */
    @JsonProperty("style")
    public String getStyle() {
        return style;
    }

    /**
     * Style
     * (Required)
     * 
     */
    @JsonProperty("style")
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Face Option
     * (Required)
     * 
     */
    @JsonProperty("faceOption")
    public String getFaceOption() {
        return faceOption;
    }

    /**
     * Face Option
     * (Required)
     * 
     */
    @JsonProperty("faceOption")
    public void setFaceOption(String faceOption) {
        this.faceOption = faceOption;
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
        return new HashCodeBuilder().append(customerKey).append(dimensionWidthFeet).append(dimensionWidthInch).append(dimensionHeightFeet).append(dimensionHeightInch).append(style).append(faceOption).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddCustomerOrderRequestSchema) == false) {
            return false;
        }
        AddCustomerOrderRequestSchema rhs = ((AddCustomerOrderRequestSchema) other);
        return new EqualsBuilder().append(customerKey, rhs.customerKey).append(dimensionWidthFeet, rhs.dimensionWidthFeet).append(dimensionWidthInch, rhs.dimensionWidthInch).append(dimensionHeightFeet, rhs.dimensionHeightFeet).append(dimensionHeightInch, rhs.dimensionHeightInch).append(style, rhs.style).append(faceOption, rhs.faceOption).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
