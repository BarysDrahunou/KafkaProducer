package org.example;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CustomerGenerator {
    private static int count = 0;

    private static List<String> names = List.of("Aleh", "Barys", "Cyril", "Dom", "Ella");

    public static Customer generateCustomer() {
        return new Customer(names.get(count++), count);
    }
}
