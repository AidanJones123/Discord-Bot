package com.example.discordbot;
import java.util.*;

/**
 * A class to manage the history of commands executed by the Discord bot.
 * Uses a Stack to store and retrieve the history of commands in a Lifo order.
 */
public class CommandHistory {
    private final Stack<String> history = new Stack<>();
    /**
     * adds command to the command history
     *
     * @param command The command to add to the history
     */
    public void addCommand(String command) {
        history.push(command);
    }
    /**
     * Retrieves the history of commands as a string.
     *
     * @return a string of the command history
     */
    public String getHistory() {
        return history.toString();
    }
}