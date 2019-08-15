package com.ssol.cache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author trigubovich_o
 *
 */
@Entity
@Table(name = "cache_item")
public class CacheItem {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
