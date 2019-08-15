package com.ssol.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssol.cache.model.CacheItem;
import com.ssol.cache.service.CacheService;

/**
 * @author trigubovich_o
 *
 */
@RestController
public class CacheController {
    
    @Autowired
    private CacheService cacheService;

    @GetMapping("/{key}")
    public CacheItem getCached(@PathVariable String key) {
        return cacheService.fiandCachedItem(key);
    }

    @PostMapping
    public CacheItem save(@RequestBody CacheItem cacheItm) {
        return cacheService.put(cacheItm);
    }

    @DeleteMapping
    public void deleteFromCache(@RequestParam(value = "key") String key) {
        cacheService.removeItem(key);
    }
}
