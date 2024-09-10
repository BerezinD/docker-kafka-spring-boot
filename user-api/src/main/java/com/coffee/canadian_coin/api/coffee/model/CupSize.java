package com.coffee.canadian_coin.api.coffee.model;

public enum CupSize {
    SMALL, MEDIUM, LARGE, EXTRA_LARGE;

    public static CupSize fromString(String size) {
        return switch (size) {
            case "SMALL" -> SMALL;
            case "MEDIUM" -> MEDIUM;
            case "LARGE" -> LARGE;
            case "EXTRA_LARGE" -> EXTRA_LARGE;
            default -> throw new IllegalArgumentException("Invalid cup size: " + size);
        };
    }
}
