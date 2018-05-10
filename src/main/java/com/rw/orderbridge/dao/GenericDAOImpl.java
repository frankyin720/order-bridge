package com.rw.orderbridge.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.rw.orderbridge.exception.MultipleRecordFoundException;
import com.rw.orderbridge.exception.NoRecordFoundException;

@SuppressWarnings("unchecked")
public class GenericDAOImpl<T extends Serializable> extends HibernateDaoSupport implements GenericDAO<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericDAOImpl.class);

    private Class<T> t;

    public GenericDAOImpl(Class<T> t) {
        this.t = t;
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#create(com.td.bbwp.model.base.BaseModel)
     */
    @Override
    public Integer create(T t) {
        Integer result = (Integer) this.getHibernateTemplate().save(t);
        return result;
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#save(com.td.bbwp.model.base.BaseModel)
     */
    @Override
    public void save(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#remove(com.td.bbwp.model.base.BaseModel)
     */
    @Override
    public void remove(T t) {
        if (t != null) {
            this.getHibernateTemplate().delete(t);
        }
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#find(java.lang.Integer)
     */
    @Override
    public T find(Integer id) throws NoRecordFoundException {
        T result = (T) this.getHibernateTemplate().load(t, id);
        return result;
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#findByExample(java.lang.String, java.lang.Object)
     */
    public T findByExample(T t) throws NoRecordFoundException, MultipleRecordFoundException {
        List<T> result = this.listByExample(t);
        if (result.size() > 1) {
            LOGGER.error("[findByExample]: Multiple records found");
            throw new MultipleRecordFoundException("Multiple records found");
        } else if (result.size() == 0) {
            LOGGER.error("[findByExample]: No record found");
            throw new NoRecordFoundException("No record found");
        }
        return result.get(0);
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#listByExample(com.td.bbwp.model.base.BaseModel)
     */
    @Override
    public List<T> listByExample(T t) {
        if (t == null) {
            return new ArrayList<T>();
        }
        List<T> result = this.getHibernateTemplate().findByExample(t);
        return result;
    }

    /**
     * @see com.td.bbwp.dao.GenericDAO#listAll(com.td.bbwp.model.base.BaseModel)
     */
    @Override
    public List<T> listAll(T t) {
        if (t == null) {
            return new ArrayList<T>();
        }
        return (List<T>) this.getHibernateTemplate().loadAll(t.getClass());
    }
}
