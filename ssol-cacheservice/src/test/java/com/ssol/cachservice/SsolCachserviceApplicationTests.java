package com.ssol.cachservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsolCachserviceApplicationTests {

    @Autowired
    private CacheManager cacheManager;
     
    
	@Test
	public void contextLoads() {

	    Cache cache = cacheManager.getCache("myCache");
	    cache.toString();
	}

}
