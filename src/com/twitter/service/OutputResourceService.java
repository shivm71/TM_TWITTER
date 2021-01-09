package com.twitter.service;

import com.twitter.cache.Cache;

public class OutputResourceService {
    private static Cache cache = Cache.getInstance();

    // To print all the values
    public static void printCacheValue() {

        System.out.println("------ Top 10 trending HashTags ------");

        cache.getHashTags().forEach((hashTag) -> {
//            System.out.println(hashTag.getName() + " : " + hashTag.getFreq());
            System.out.println("#"+hashTag.getName());
        });

        System.out.println("------ END ------");
    }

}
