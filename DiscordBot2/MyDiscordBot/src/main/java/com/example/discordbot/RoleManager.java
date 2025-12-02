package com.example.discordbot;

import java.util.*;
/**
 * A class for managing user roles. Allows adding, removing, and retrieving roles
 * for users using a map structure.
 */
public class RoleManager {

    private final Map<String, Set<String>> userRoles; // Map to store user roles
    /**
     * Constructs a new RoleManager instance.
     */
    public RoleManager() {
        this.userRoles = new HashMap<>(); // Initialize the map
    }
    /**
     * Adds a role to a user.
     *
     * @param userId the ID of the user
     * @param role   the role to add to the user
     */
    // Method to add a role to a user
    public void addRole(String userId, String role) {
        userRoles.computeIfAbsent(userId, k -> new HashSet<>()).add(role); // Add the role to the user's set
    }
    /**
     * Removes a role from a user.
     *
     * @param userId the ID of the user
     * @param role   the role to remove from the user
     */
    // Method to remove a role from a user
    public void removeRole(String userId, String role) {
        Set<String> roles = userRoles.get(userId); // Get the roles for the user
        if (roles != null) {
            roles.remove(role); // Remove the role
            if (roles.isEmpty()) {
                userRoles.remove(userId); // Clean up empty entries
            }
        }
    }
    /**
     * Retrieves all roles assigned to a user as a string.
     * If the user has no roles a default message is returned.
     *
     * @param userId the ID of the user.
     * @return a string listing all roles assigned to the user
     *         or a message saying no roles are assigned
     */
    // Method to get all roles for a user
    public String getRoles(String userId) {
        Set<String> roles = userRoles.get(userId); // Get the roles for the user
        return roles == null || roles.isEmpty() ? "No roles assigned" : String.join(", ", roles); // Format roles
    }
}