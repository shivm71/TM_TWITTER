package com.twitter.service;

import com.twitter.dao.ResourceInit;
import com.twitter.utils.FindHash;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleService {

    private static ResourceInit ri = ResourceInit.getInstance();

    public static void readTweets(String tweet) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(tweet.trim().split(" ")));
        ArrayList<String> hashTags = FindHash.findTags(words);
        hashTags.forEach(ri::addHashTags);

    }

}
