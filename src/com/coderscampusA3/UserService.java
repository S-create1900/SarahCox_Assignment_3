package com.coderscampusA3;

public class UserService {
	// Method to create a User - access modifier
	public UserPOJO createUser(String[] stringInput) {
		// Check if the input array has exactly 3 strings
		if (stringInput == null || stringInput.length != 3) {
			throw new IllegalArgumentException(
					"Input array must contain exactly 3 elements: username, password, and name.");
		}

		// Extract the values from the input array
		String username = stringInput[0];
		String password = stringInput[1];
		String name = stringInput[2];

		// Create a new User object
		return new UserPOJO(username, password, name); 
	}
}
