package com.rw.orderbridge.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable> {
    /**
     * Persist the given transient instance.
     * 
     * @param t
     * @return
     */
    Integer create(T t);

    /**
     * Save or update the given persistent instance, according to its id.
     * 
     * @param t
     */
    void save(T t);

    /**
     * Delete the given persistent instance.
     * 
     * @param t
     */
    void remove(T t);

    /**
     * Find by instance id
     * 
     * @param id
     * @return
     */
    T find(Integer id);

    /**
     * Find by example
     * 
     * @param t
     * @return
     */
    T findByExample(T t);

    /**
     * Execute a query based on the given example entity object
     * 
     * @param t
     * @return
     */
    List<T> listByExample(T t);

    /**
     * Return all persistent instances of the given entity class.
     * 
     * @param t
     * @return
     */
    List<T> listAll(T t);

}
