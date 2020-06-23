package com.daus.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JavaDeveloperZone on 30-04-2018.
 */

//for rest response

@RestController     
public class CacheController {
   
	// autowire cache manager
	
	@Autowired
    private CacheManager cacheManager;      
    
	// clear all cache using cache manager
    
	@RequestMapping(value = "clearCache")
    public void clearCache(){
        for(String name:cacheManager.getCacheNames()){
        	// clear cache by name
            cacheManager.getCache(name).clear();            
        }
    }
	
}