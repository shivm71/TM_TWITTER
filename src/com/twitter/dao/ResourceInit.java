package com.twitter.dao;

import com.twitter.cache.Cache;
import com.twitter.model.HTags;

import java.util.HashMap;

// it is a Singleton class for saving the Resources
public class ResourceInit {

    private Cache cache = Cache.getInstance();
    private static ResourceInit instance;
    private HashMap<String, HTags> hashTags;

    private ResourceInit() {
        hashTags = new HashMap<>();
    }

    // To add the HashTag
    public void addHashTags(String name) {

        if (name.trim().equals("")) {
            //todo : throw custom exception
            return;
        }

        // here we are adding cache first and then Saving in HashMap
        // we can use use other strategies also
        if (hashTags.containsKey(name)) {
            HTags hashTag = hashTags.get(name);
            cache.updateCache(hashTag);
            hashTags.put(name, hashTag);

        } else {
            HTags hashTag = new HTags(name);
            cache.updateCache(hashTag);
            hashTags.put(name, hashTag);
        }
    }


    // for getting instance
    public static ResourceInit getInstance() {
        if (instance == null) {
            synchronized (ResourceInit.class) {
                if (instance == null) {
                    instance = new ResourceInit();
                }
            }
        }
        return instance;
    }

}
