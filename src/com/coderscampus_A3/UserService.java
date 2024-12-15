package com.coderscampus_A3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<UserPOJO> users;
	private int userCount;
	private String csvFilePath;

	public UserService() {
		this.csvFilePath = "src/data.txt";
		this.users = new ArrayList<>();
		this.userCount = 0;
		loadUsersFromCsv();
	}

	public UserPOJO authenticate(String username, String password) {
		for (UserPOJO user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	private void loadUsersFromCsv() {
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length >= 3) {
					String email = data[0].trim();
					String password = data[1].trim();
					String name = data[2].trim();
					addUser(new UserPOJO(email, password, name));
				}
			}
		} catch (IOException e) {
			System.err.println("Error loading users from CSV file: " + e.getMessage());
		}
	}

	public void addUser(UserPOJO user) {
		users.add(user);
		userCount++;
	}
}