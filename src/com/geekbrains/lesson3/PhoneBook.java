package com.geekbrains.lesson3;

import java.util.*;

public class PhoneBook {

    private final Map<String, Set<String>> contacts = new LinkedHashMap<>();

    public void add(String surname, String number) {
        Set<String> numbersOfSurname = contacts.getOrDefault(surname, new HashSet<>());
        numbersOfSurname.add(number);
        contacts.put(surname, numbersOfSurname);
    }

    public Set<String> get(String surname) {
        return contacts.get(surname);
    }

    public Set<String> getAllContacts() {
        return contacts.keySet();
    }
}