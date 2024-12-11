package com.coderscampus_A3;

import java.util.Scanner;

public class UserApplication {

	public static void main(String[] args) {
		import java.util.Scanner;
//		// Path to the HTML file containing the user data
//		String csvFilePath = "/Users/sarahcox/eclipse-workspace/Assignment3redovs2/data.txt";

		// Initialize UserService to handle user operations
		UserService userService = new UserService();

		// Set up a counter for login attempts
		int maxAttempts = 5;
		int attempts = 0;

		// Get user input for authentication
		Scanner scanner = new Scanner(System.in);

		while (attempts < maxAttempts) {
			System.out.println("Enter username:");
			String inputUsername = scanner.nextLine().trim().toLowerCase(); // Trim and convert to lower case

			System.out.println("Enter password:");
			String inputPassword = scanner.nextLine().trim(); // Trim input

			// Authenticate user by checking the credentials
			User authenticatedUser = userService.authenticate(inputUsername, inputPassword);

			if (authenticatedUser != null) {
				// If authentication is successful
				System.out.println("Authentication successful! Welcome, " + authenticatedUser.getName() + ".");
				return; // Exit the program after successful login
			} else {
				// If authentication fails, increment the attempt counter
				attempts++;
				System.out.println("Invalid login, please try again.");

				// If max attempts are reached, lock the user out and terminate
				if (attempts == maxAttempts) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					return; // Exit the program
				}
			}
		}
		scanner.close();
	}
}


	}

}
