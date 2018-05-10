package com.rw.orderbridge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Query implements Serializable {
    private Map<String, Object> likes = new HashMap<String, Object>();
    private Map<String, Object> equals = new HashMap<String, Object>();
    private Map<String, Object[]> betweens = new HashMap<String, Object[]>();
    private Map<String, Object> greats = new HashMap<String, Object>();
    private Map<String, Object> greatEquals = new HashMap<String, Object>();
    private Map<String, Object> lesses = new HashMap<String, Object>();
    private Map<String, Object> lessEquals = new HashMap<String, Object>();
    private Map<String, Object[]> ins = new HashMap<String, Object[]>();
    private List<String> nulls = new ArrayList<String>();
    private List<String> notNulls = new ArrayList<String>();
    private List<String> projections = new ArrayList<String>();
    private List<String> counts = new ArrayList<String>();
    private Map<String, Query> nestedCondition = new HashMap<String, Query>();
    private Query ors;

    private Map<String, String> aliases = new HashMap<String, String>();

    /**
     * Gets nested condition.
     * 
     * @return Map<String, Query>
     */
    public Map<String, Query> getNestedCondition() {
        return nestedCondition;
    }

    /**
     * Sets nested condition.
     * 
     * @param nestedCondition
     */
    public void setNestedCondition(Map<String, Query> nestedCondition) {
        this.nestedCondition = nestedCondition;
    }

    /**
     * Gets "or" constraint.
     * 
     * @return Query
     */
    public Query getOrs() {
        return ors;
    }

    /**
     * Sets "or" constraint.
     * 
     * @param ors
     */
    public void setOrs(Query ors) {
        this.ors = ors;
    }

    /**
     * Gets "likes" constraint.
     * 
     * @return
     */
    public Map<String, Object> getLikes() {
        return likes;
    }

    /**
     * Sets "likes" constraint.
     * 
     * @param likes
     */
    public void setLikes(Map<String, Object> likes) {
        this.likes = likes;
    }

    /**
     * Gets "equals" constraint.
     * 
     * @return Map<String, Object>
     */
    public Map<String, Object> getEquals() {
        return equals;
    }

    /**
     * Sets a "equals" constraint.
     * 
     * @param equals
     */
    public void setEquals(Map<String, Object> equals) {
        this.equals = equals;
    }

    /**
     * Gets a "between" constraint.
     * 
     * @return
     */
    public Map<String, Object[]> getBetweens() {
        return betweens;
    }

    /**
     * Sets a "between" constraint...
     * 
     * @param betweens
     */
    public void setBetweens(Map<String, Object[]> betweens) {
        this.betweens = betweens;
    }

    /**
     * Gets "great than" constraint.
     * 
     * @return
     */
    public Map<String, Object> getGreats() {
        return greats;
    }

    /**
     * Sets "great than" constraint.
     * 
     * @param greats
     */
    public void setGreats(Map<String, Object> greats) {
        this.greats = greats;
    }

    /**
     * Gets great equal criteria from a map.
     * 
     * @return
     */
    public Map<String, Object> getGreatEquals() {
        return greatEquals;
    }

    /**
     * Sets great equal criteria.
     * 
     * @param greatEquals
     */
    public void setGreatEquals(Map<String, Object> greatEquals) {
        this.greatEquals = greatEquals;
    }

    /**
     * Gets "less than" constraint.
     * 
     * @return Map<String, Object>
     */
    public Map<String, Object> getLesses() {
        return lesses;
    }

    /**
     * Sets "less than" constraint.
     * 
     * @param lesses
     */
    public void setLesses(Map<String, Object> lesses) {
        this.lesses = lesses;
    }

    /**
     * Apply a "less than or equal" constraint to the named property.
     * 
     * @return
     */
    public Map<String, Object> getLessEquals() {
        return lessEquals;
    }

    /**
     * Sets a "less than or equal" constraint.
     * 
     * @param lessEquals
     */
    public void setLessEquals(Map<String, Object> lessEquals) {
        this.lessEquals = lessEquals;
    }

    /**
     * Apply an "in" constraint to the named property.
     * 
     * @return
     */
    public Map<String, Object[]> getIns() {
        return ins;
    }

    /**
     * Sets "in" constraints.
     * 
     * @param ins
     */
    public void setIns(Map<String, Object[]> ins) {
        this.ins = ins;
    }

    /**
     * Apply an "is null" constraint to the named property in the list.
     * 
     * @return
     */
    public List<String> getNulls() {
        return nulls;
    }

    /**
     * Set "null" constraint.
     * 
     * @param nulls
     */
    public void setNulls(List<String> nulls) {
        this.nulls = nulls;
    }

    /**
     * Gets "not null" constraint.
     * 
     * @return List<String>
     */
    public List<String> getNotNulls() {
        return notNulls;
    }

    /**
     * Sets "not null" constrains.
     * 
     * @param notNulls
     */
    public void setNotNulls(List<String> notNulls) {
        this.notNulls = notNulls;
    }

    /**
     * Return the name of the projected columns
     * 
     * @return projections
     */
    public List<String> getProjections() {
        return projections;
    }

    /**
     * Set the name of the projected columns
     * 
     * @param projections
     */
    public void setProjections(List<String> projections) {
        this.projections = projections;
    }

    /**
     * Return the count fields
     * 
     * @return counts
     */
    public List<String> getCounts() {
        return counts;
    }

    /**
     * Set the count fields
     * 
     * @param counts
     */
    public void setCounts(List<String> counts) {
        this.counts = counts;
    }

    public Map<String, String> getAliases() {
        return aliases;
    }

    public void setAliases(Map<String, String> aliases) {
        this.aliases = aliases;
    }

}
