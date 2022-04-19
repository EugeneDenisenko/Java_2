package com.geekbrains.lesson3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {

    private static final String[] WORDS = {"one", "two", "three", "four", "one", "two", "five", "six", "one", "seven", "six"};

    public static void main(String[] args) {
        Map<String, Integer> words = new LinkedHashMap<>();

        for (String word : WORDS) {
            Integer count = words.getOrDefault(word, 0);
            count++;
            words.put(word, count);
        }

        for (String word : words.keySet()) {
            System.out.printf("Слово \"%s\" повторяется %d раз(а).\n", word, words.get(word));
        }
    }
}
