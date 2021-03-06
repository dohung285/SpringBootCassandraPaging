package com.sexton.cassandra.pagination.example.util;

import com.sexton.cassandra.pagination.example.models.User;

import java.util.List;
import java.util.function.Supplier;

/**
 * Responsible for supplying random user objects.
 */
public class RandomUserSupplier implements Supplier<User> {
    private final List<String> firstNames;
    private final List<String> lastNames;

    /**
     * Allocates a new UserSupplier with the give first and last names.
     *
     * @param firstNames The strings that will be used to make up newly created user first names.
     * @param lastNames The strings that will be used to make up newly created user last names.
     */
    public RandomUserSupplier(final List<String> firstNames, final List<String> lastNames) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
    }

    @Override
    public User get() {
        final String firstName = getRandomName(firstNames);
        final String lastName = getRandomName(lastNames);

        return new User(firstName, lastName);
    }

    private String getRandomName(final List<String> names) {
        return names.get(RandomUtil.nextInt(names.size() - 1));
    }
}
