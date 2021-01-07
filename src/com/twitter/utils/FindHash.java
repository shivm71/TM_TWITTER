package com.twitter.utils;

import java.util.ArrayList;
import java.util.List;

public class FindHash {

    // filter HashTags (if the first char is # means that word is Hashtag)
    public static ArrayList<String> findTags(List<String> tweets) {
        ArrayList<String> tags = new ArrayList<>();
        tweets.forEach((s1) -> {
            if (s1.charAt(0) == '#') {
                tags.add(s1.substring(1, s1.length()));
            }
        });

        return tags;
    }
}
