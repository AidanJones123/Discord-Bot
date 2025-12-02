package com.example.discordbot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.*;
/**
 * A listener class that handles Discord bot events
 * This class processes commands, maintains command history, updates a leaderboard,
 * and manages roles for users.
 */
public class MyListener extends ListenerAdapter {

    private final com.example.discordbot.RoleManager roleManager = new com.example.discordbot.RoleManager(); // Instance of RoleManager
    private final CommandHistory commandHistory = new CommandHistory(); // Command history instance
    private final Leaderboard leaderboard = new Leaderboard(); // Leaderboard instance
    /**
     * Handles the event triggered when a message is received in a channel.
     *
     * @param event the event object containing information about the message
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());

        if (event.getAuthor().isBot()) return; // Ignore bot messages

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();

        // Increment message count for the leaderboard
        leaderboard.incrementMessages(event.getAuthor().getId());

        if (content.startsWith("!")) { // Check for commands
            commandHistory.addCommand(content); // Log every command
            handleCommands(event, content, channel, message); // Pass event to handleCommands
        }
    }
    /**
     * Processes bot commands based on the message content.
     *
     * @param event   the event object containing details about the message
     * @param content the content of the received message
     * @param channel the channel where the message was received
     * @param message the message object representing the received message
     */
    private void handleCommands(MessageReceivedEvent event, String content, MessageChannel channel, Message message) {
        if (content.equalsIgnoreCase("!Hello")) {
            channel.sendMessage("World!").queue();
        } else if (content.equalsIgnoreCase("!Shrimp")) {
            channel.sendMessage("https://tenor.com/view/shrimp-incredible-krill-crab-gif-4661271430329690317").queue();
        } else if (content.startsWith("!addRole")) {
            String[] parts = content.split(" ", 3);
            if (parts.length == 3) {
                roleManager.addRole(parts[1], parts[2]);
                channel.sendMessage("Added role " + parts[2] + " to " + parts[1]).queue();
            } else {
                channel.sendMessage("Usage: !addRole @User RoleName").queue();
            }
        } else if (content.startsWith("!removeRole")) {
            String[] parts = content.split(" ", 3);
            if (parts.length == 3) {
                roleManager.removeRole(parts[1], parts[2]);
                channel.sendMessage("Removed role " + parts[2] + " from " + parts[1]).queue();
            } else {
                channel.sendMessage("Usage: !removeRole @User RoleName").queue();
            }
        } else if (content.startsWith("!getRoles")) {
            String[] parts = content.split(" ", 2);
            if (parts.length == 2) {
                String userId = parts[1];
                channel.sendMessage("Roles for " + userId + ": " + roleManager.getRoles(userId)).queue();
            } else {
                channel.sendMessage("Usage: !getRoles @User").queue();
            }
        } else if (content.equalsIgnoreCase("!history")) { // Show command history
            channel.sendMessage("Command history: " + commandHistory.getHistory()).queue();
        } else if (content.equalsIgnoreCase("!leaderboard")) { // Show leaderboard
            channel.sendMessage("Top users:\n" + leaderboard.getTopUsers(event.getJDA())).queue();
        } else if (content.equalsIgnoreCase("!commands")) { // Show available commands
            listCommands(channel);
        } else {
            channel.sendMessage("Unknown command!").queue(); // Default response for unknown commands
        }
    }
    /**
     * Recursively generates a list of commands as a string.
     *
     * @param commands the array of available commands
     * @param index    the current index in the array being processed
     * @return a formatted string listing all commands
     */
    // Recursive method to list commands
    private String listCommandsRecursively(String[] commands, int index) {
        if (index >= commands.length) {
            return ""; // Base case
        }
        // Recursive case
        return commands[index] + "\n" + listCommandsRecursively(commands, index + 1);
    }

    // Helper method
    private void listCommands(MessageChannel channel) {
        String[] commands = {
                "!Hello",
                "!Shrimp",
                "!addRole @User RoleName",
                "!removeRole @User RoleName",
                "!getRoles @User",
                "!history",
                "!leaderboard",
                "!commands"
        };
        String allCommands = listCommandsRecursively(commands, 0); // Start recursion
        channel.sendMessage("Available commands:\n" + allCommands).queue(); // Send the commands list
    }
}
