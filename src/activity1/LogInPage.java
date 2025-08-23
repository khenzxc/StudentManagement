package activity1;

import java.util.ArrayList;
import java.io.*;

public class LogInPage {
    private ArrayList<Account> accounts = new ArrayList<>();
    private static final String FILE_NAME = "accounts.txt";

    public LogInPage() {
        loadAccounts();
    }

    public void register(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }
        accounts.add(new Account(username, password));
        saveAccounts();
        System.out.println("Registration successful!");
    }

    public boolean logIn(String username, String password) {
        for (Account acc : accounts) {
            if (acc.validate(username, password)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAccounts() {
        return !accounts.isEmpty();
    }

    private void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts) {
                writer.write(acc.getUsername() + "," + acc.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    private void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    accounts.add(new Account(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}