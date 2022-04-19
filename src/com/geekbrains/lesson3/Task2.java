package com.geekbrains.lesson3;

public class Task2 {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Denisenko", "80296404689");
        phoneBook.add("Andros", "80291055525");
        phoneBook.add("Messi", "80294567854");
        phoneBook.add("Denisenko", "80445012334");
        phoneBook.add("Messi", "80446547459");

        for (String surname : phoneBook.getAllContacts()) {
            System.out.printf("%s: " + phoneBook.get(surname) + "\n", surname);
        }
    }
}

