package com.example.discordbot;

import net.dv8tion.jda.api.JDA;

import java.util.*;
import java.util.stream.Collectors;
/**
 * A class to maintain and display a leaderboard of users based on their message counts.
 */
public class Leaderboard {
    private final HashMap<String, Integer> userMessages = new HashMap<>();
    /**
     * Increments the message count for a given user.
     *
     * @param userId the ID of the user whose message count should be incremented.
     */
    public void incrementMessages(String userId) {
        userMessages.put(userId, userMessages.getOrDefault(userId, 0) + 1);
    }
    /**
     * Retrieves the top three users with the highest message counts.
     *
     * @param jda the JDA instance to fetch user information by user ID
     * @return a string of the top three users and their message counts
     *         if a user can't be identified their name is displayed as unknown user
     */
    public String getTopUsers(JDA jda) {
        return userMessages.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(3)
                .map(entry -> {
                    String userId = entry.getKey();
                    int messageCount = entry.getValue();
                    String username = jda.getUserById(userId) != null ? jda.getUserById(userId).getName() : "Unknown User";
                    return username + ": " + messageCount + " messages";
                })
                .collect(Collectors.joining("\n"));
    }

}