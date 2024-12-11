package com.coderscampus_A3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.coderscampus.A3.User;

public class UserService {
	private User[] users; // Array to store users
	private int userCount; // Keep track of the number of users
	private String csvFilePath = "/Users/sarahcox/eclipse-workspace/Assignment3redovs2/data.txt";// Path to the CSV file
																									// containing the
																									// user data

	// Constructor to initialize the UserService and load users from the CSV file
	public UserService() {
		users = new User[10]; // Initialize the array with a default size
		userCount = 0; // Initialize user count
		loadUsersFromCsv(); // Load users from the CSV file
	}

	// Method to authenticate a user
	public User authenticate(String username, String password) {
		for (int i = 0; i < userCount; i++) {
			User user = users[i];
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user; // Return the authenticated user
			}
		}
		return null; // Return null if authentication fails
	}

	// Method to parse the CSV file and load the user data into UserService
	private void loadUsersFromCsv() {
		String line;
		String csvSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			while ((line = br.readLine()) != null) {
				// Split the line by the comma delimiter
				String[] data = line.split(csvSplitBy);
				// Create a new User object and add it to the users array
				if (data.length >= 3) { // Ensure there are enough fields
					String email = data[0].trim();
					String password = data[1].trim();
					String name = data[2].trim();
					addUser(new User(email, password, name)); // Add user to the array
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to add a user to the array
	public void addUser(User user) {
		// Check if we need to resize the array
		if (userCount >= users.length) {
			// Create a new array with double the size
			User[] newArray = new User[users.length * 2];
			// Copy the existing users to the new array
			System.arraycopy(users, 0, newArray, 0, users.length);
			users = newArray; // Update the reference to the new array
		}
		users[userCount++] = user; // Add the new user and increment the count
	}

}
