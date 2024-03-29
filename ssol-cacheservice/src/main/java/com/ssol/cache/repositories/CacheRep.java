package com.ssol.cache.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssol.cache.model.CacheItem;

/**
 * @author trigubovich_o
 *
 */
@Repository
@Transactional
public interface CacheRep extends CrudRepository<CacheItem, String> {

}
