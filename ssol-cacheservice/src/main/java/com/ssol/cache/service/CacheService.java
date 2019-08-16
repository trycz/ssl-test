package com.ssol.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ssol.cache.common.CacheItemNotFoundException;
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
    Logger logger = LoggerFactory.getLogger(CacheService.class);
    public static final String ACTUAL_CACHE = "cache1";

    @Cacheable(value = ACTUAL_CACHE, key = "#key")
    public CacheItem findCachedItem(String key) {
        CacheItem res = null;
        res = cacheRep.findById(key).orElseThrow(() -> {
            logger.warn("Cached item '" + key + "' not found");
            return new CacheItemNotFoundException();
        });
        return res;
    }

    @CacheEvict(value = ACTUAL_CACHE, key = "#item?.key")
    public CacheItem put(CacheItem item) {
        CacheItem res = null;
        res = cacheRep.save(item);
        return res;
    }

    @CacheEvict(value = ACTUAL_CACHE, key = "#key")
    public void removeItem(String key) {
        logger.info("Removing cache item by key " + key);
        try {
            cacheRep.deleteById(key);
        } catch (EmptyResultDataAccessException ex) {
            logger.warn("Cached item '" + key + "' not found");
            throw new CacheItemNotFoundException();
        }

    }

}
