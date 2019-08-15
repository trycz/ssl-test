package com.ssol.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssol.cache.model.CacheItem;
import com.ssol.cache.repositories.CacheRep;

/**
 * @author trigubovich_o
 *
 */
@Service
public class CacheService {

    @Autowired
    private CacheRep cacheRep;

    @Cacheable(value="cache", key = "#key")
    public CacheItem fiandCachedItem(String key) {
        CacheItem res = null;
        res = cacheRep.findById(key).orElseThrow(() -> new CacheItemNotFoundException());
        return res;
    }
    
    @CachePut(value="cache")
    public CacheItem put(CacheItem item) {
        return cacheRep.save(item);
    }
    
    @CacheEvict(value = "cache", key = "#key")
    public void removeItem(String key) {
        cacheRep.deleteById(key);
    }

}
