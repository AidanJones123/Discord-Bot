# Discord-Bot
Project Description: This project sa a Discord bot in java utilizing the JDA (Java Discord Api) libraries available for free on github. The bot is capable of some different commands, each being tailored towards fufilling the skill mastery requirements.

Dependency and Installation Instructions: This project is expected to be used with Discord and uses gradle through intellij to handle the proccess of managing the projects dependencies. Discord can be installed via the official Discord website. It will require the making of a Discord account and you will need to go through the procces of downloading the installer and then getting the aplication on your computer. Intelij is also very simple to install and is free with its community addition similar to Discord. The installation proccess is simple just go here: https://www.jetbrains.com/idea/ to download it be sure to pick the one that is correct for your computer or operating system.

Project Configuration: My project has been uploaded in the form of a Intellij project. If Intellij is installed on your workstation you will be able to open my project within it. This is where you will be able to interact with and actually launch the program as well as potentially modify it depending on your needs. Some amount of configuration for the bot will be neccesary for you to actually utilize it. You will need to enter a browser and enter "Discord Developer Portal".
![image](https://github.com/user-attachments/assets/e6a74b11-52c6-4300-a905-a83c0c7a34e6)
After you have found this page you will need to create a new application and give it a name.(The name doesn't matter) Once you have created an application navigate to the bot page on the left side of the screen and enable the 3 privileged Gateway Intents.
![image](https://github.com/user-attachments/assets/9408d372-1890-4a58-b2d6-ab94041f1392)
We enable these three gateway intents so that we don't run into permissions issues when testing the bot. You will also need to observe your bot token, as well as copy and past it into a text document so that you can save it for later use within the project. Next navigate to the OAuth2 tab on the left side of the screen just above the Bot tab. Here you will actually be able to have your application join a server. Select the Bot option in scope and then select the Administrator permissions for the bot simply so as to avoid having to give it rolls in your server for this test.
![image](https://github.com/user-attachments/assets/bb39f54a-c05f-4a4a-ad07-ef7c10b6591f)
Once you have done this at the bottom of the page you will see a url appear that you will need to copy and then paste into the search bar of your browser.
![image](https://github.com/user-attachments/assets/1d9a4471-489c-47e0-b910-077809092db8)
Once you have done this you will be promted with the ability to add your bot to a server that you have permissions over. It is likely best to create a discord serve simply to test this bot.
![image](https://github.com/user-attachments/assets/e90e3750-6357-4768-ab23-a7644d393d18)
Once you have added your discord bot to the server you intend to test it in all that is left is to imput the bot token into the bot class of the intellj project.
![image](https://github.com/user-attachments/assets/b1e2124b-f301-4e36-9f68-b8db30d8dbbb)
Marked by blue arrows you will see a string that needs to hold the bot token. Currently mine will be there, simply replace it with your own. The bot token is an important part of utilizing a bot and under normal circumstances it is a security risk to have it available, however for testing the functionality of the bot it won't matter. 

Class Design: 

Bot.java:
Uses JDA to initialize the bot, connect to Discord, and register event listeners for handling messages.

MyListener.java: 
Listens for incoming messages and processes commands by delegating tasks to helper methods and other classes.

CommandHistory.java
Maintains a stack to store and retrieve the history of commands in the order they were issued.

Leaderboard.java
Uses a hashmap to track and sort users' message counts, retrieving the top contributors via a stream based ranking system.

RoleManager.java
Manages user roles with a hashmap where each user ID maps to a set of assigned roles.


Commands and Output:

1. !Hello
Description: Responds with "World!" as a simple demonstration command.

![image](https://github.com/user-attachments/assets/b06914a7-b109-4ae2-8a93-d510f74b0cbe)

2. !addRole @User RoleName
Description: Assigns a specified role to a mentioned user.

![image](https://github.com/user-attachments/assets/6aaa8eaf-181f-4bb3-b28c-7f6cac37c5a0)

3. !removeRole @User RoleName
Description: Removes a specified role from a mentioned user.

![image](https://github.com/user-attachments/assets/e1129779-3ba3-4172-a48c-fea9c139359c)


4. !getRoles @User
Description: Retrieves a list of roles assigned to a mentioned user.

![image](https://github.com/user-attachments/assets/426e93ef-9271-49ce-b10d-83f43724e111)

5. !history
Description: Displays the history of all commands issued during the bot's runtime.

![image](https://github.com/user-attachments/assets/3fa8ea57-fc08-4428-a73c-8af854bbff6b)

6. !leaderboard
Description: Shows the top three users who have sent the most messages since the bot was started.

![image](https://github.com/user-attachments/assets/08a34369-cb3f-4886-bdb1-8c00e5f88891)

7. !commands
Description: Lists all available commands that the bot can execute.

![image](https://github.com/user-attachments/assets/5061e5d4-37f0-49c3-b3fb-d0263ef2b13c)

Utilizing Commands: To begin utilizing the commands provided, simply start the program in Intellij by using the play button at the top right of the window while observing the bot class where main is located. This will start the program and now all you must do is type the desired command into the sever that the bot is in.

Junit Test Class:
The Junit test class have been given outside of the project in github becasue I was having issues with junit properly working within intellij. 

Citations: 

Used for JDA: 
https://jda.wiki/introduction/jda/

https://github.com/discord-jda/JDA-Website
