package com.ssol.cache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

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
