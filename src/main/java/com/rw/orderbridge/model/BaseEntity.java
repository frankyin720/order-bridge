package com.rw.orderbridge.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@MappedSuperclass
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public abstract class BaseEntity<T> implements Serializable {
    /**
     * Returns instance id.
     * 
     * @return String
     */
    public abstract Integer getId();

    /**
     * Set instance id.
     * 
     * @param id
     */
    public abstract void setId(Integer id);

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    protected Date createdTime;
    @Column(name = "CREATED_USER")
    protected String createdUser;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME")
    protected Date updatedTime;
    @Column(name = "UPDATED_USER")
    protected String updatedUser;

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseEntity) {
            @SuppressWarnings("unchecked")
            BaseEntity<T> domain = (BaseEntity<T>) obj;
            if (this.getId() == null || domain.getId() == null) {
                return false;
            }
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(this.getId(), domain.getId());
            return builder.isEquals();
        }
        return false;
    }

    /*
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        if (this.getId() == null) {
            return super.hashCode();
        }
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.getClass().getName());
        builder.append(this.getId());
        return builder.toHashCode();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

}
