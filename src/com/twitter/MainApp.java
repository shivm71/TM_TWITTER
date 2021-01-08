package com.twitter;


import com.twitter.service.ConsoleService;
import com.twitter.service.OutputResourceService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("---- TECHMOJO ASSIGNMENT (1) ----");

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("Please Choose Valid option");
                System.out.println("1 to Insert Tweets.");
                System.out.println("2 to get Trending Hashtags till now.");
                System.out.println("3 for Exit.");

                int input = Integer.parseInt(br.readLine().trim());
                if (input == 1) {
                    System.out.println("Please give the tweet : ");
                    String tweet = br.readLine().trim();
                    ConsoleService.readTweets(tweet);
                } else if (input == 2) {
                    OutputResourceService.printCacheValue();
                }
                else if (input == 3) {
                    System.out.println("Shutting down...");
                    System.exit(0);
                }
                else {
                    throw new Exception("");
                }

            } catch (Exception e) {
                System.out.println("Please give valid input");
            }

        }


    }

}
