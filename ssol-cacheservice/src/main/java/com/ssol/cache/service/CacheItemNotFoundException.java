package com.ssol.cache.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author trigubovich_o
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cached item not found")
public class CacheItemNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 3933934870294506891L;

}
