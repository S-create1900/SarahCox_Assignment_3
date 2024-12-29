package com.coderscampus_A3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
    
    private UserPOJO[] users; // native array for users
    private int userCount; 
    private String csvFilePath;

    public UserService() {
        this.csvFilePath = "src/data.txt"; 
        this.users = new UserPOJO[4]; 
        this.userCount = 0;
        loadUsersFromCsv(); 
    }

    public UserPOJO authenticate(String username, String password) {
        for (int i = 0; i < userCount; i++) { 
            UserPOJO user = users[i];
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user; 
            }
        }
        return null; 
    }

    private void loadUsersFromCsv() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] lineData = line.split(",");
                if (lineData.length >= 3) { 
                    String username = lineData[0].trim();
                    String password = lineData[1].trim();
                    String name = lineData[2].trim();
                    addUser (new UserPOJO(username, password, name)); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users from CSV file: " + e.getMessage());
        }
    }

    public void addUser (UserPOJO user) {
        if (userCount < users.length) { 
            users[userCount] = user; 
            userCount++; 
        } else {
            System.err.println("User  array is full. Cannot add more users.");
        }
    }
}