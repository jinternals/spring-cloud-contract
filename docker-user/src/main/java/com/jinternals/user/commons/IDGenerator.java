package com.jinternals.user.commons;

import java.util.UUID;

public class IDGenerator {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

}
