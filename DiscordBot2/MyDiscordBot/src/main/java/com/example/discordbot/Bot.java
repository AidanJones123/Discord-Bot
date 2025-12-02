package com.example.discordbot;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.*;
/**
 * The main class for the bot.
 * This initializes the bot using the JDA and sets up an event listener.
 */
public class Bot {
    /**
     * @param arguments  argument
     * @throws Exception when an error occurs while building the JDA instance
     */
    public static void main (String[] arguments) throws Exception
    {
        String token = "";//Bot token goes here
        JDA api = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).build();// jda into
        api.addEventListener(new MyListener());// Add event listener
    }
}



