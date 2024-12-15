package com.coderscampus_A3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		String csvFilePath = "src/data.txt";

		UserService userService = new UserService();

		int maxAttempts = 5;
		int attempts = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			while (attempts < maxAttempts) {
				System.out.println("Enter username:");
				String inputUsername = scanner.nextLine().trim().toLowerCase();

				System.out.println("Enter password:");
				String inputPassword = scanner.nextLine().trim();

				// Authenticate user by checking the credentials
				UserPOJO authenticatedUser = userService.authenticate(inputUsername, inputPassword);

				if (authenticatedUser != null) {

					System.out.println("Authentication successful! Welcome, " + authenticatedUser.getName() + ".");
					return; // Exit the program
				} else {

					attempts++;
					System.out.println("Invalid login, please try again.");
					System.out.println(); // adding a space between log-in tries. I like this esthetic better.

					if (attempts == maxAttempts) {
						System.out.println("Too many failed login attempts, you are now locked out.");
						return;
					}
				}
			}
			scanner.close();
		}

	}

}
