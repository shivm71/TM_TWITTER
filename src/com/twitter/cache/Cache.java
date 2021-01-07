package com.twitter.cache;

import com.twitter.constants.Constants;
import com.twitter.model.HTags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

// it is a LFUCache to store trending HashTags
public class Cache {

    private static Cache instance;
    private int size;
    private HashMap<String, HTags> hashTags;
    // Here I have used treeSet for LFUCache, Priority Queue also can be used
    private TreeSet<HTags> sortedHashTags;
    private HashSet<String> pastTags;

    private Cache() {
        // according to the question
        this.size = Constants.CACHE_SIZE;
        hashTags = new HashMap<>();
        sortedHashTags = new TreeSet<>();
        pastTags = new HashSet<>();
    }


    public void updateCache(HTags hashTag) {

        if (hashTags.containsKey(hashTag.getName())) {
            sortedHashTags.remove(hashTag);
            hashTag.setFreq(hashTag.getFreq() + 1);
            hashTag.setTime();
            sortedHashTags.add(hashTag);
            return;
        }
        if (sortedHashTags.size() < size) {
            sortedHashTags.add(hashTag);
            hashTags.put(hashTag.getName(), hashTag);
        } else {
            if (pastTags.contains(hashTag.getName())) {
                hashTag.setFreq(hashTag.getFreq() + 1);
                hashTag.setTime();
            }

            if (sortedHashTags.last().getFreq() <= hashTag.getFreq()) {
                hashTags.remove(sortedHashTags.last().getName());
                sortedHashTags.remove(sortedHashTags.last());
                sortedHashTags.add(hashTag);
                hashTags.put(hashTag.getName(), hashTag);
            }
        }
        pastTags.add(hashTag.getName());
    }


    public static Cache getInstance() {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }

    // it is for loose coupling, if something change it should not affect other code
    public ArrayList<HTags> getHashTags() {
        ArrayList<HTags> list = new ArrayList<>(sortedHashTags);
        return list;
    }

}
