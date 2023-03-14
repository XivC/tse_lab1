package ru.itmo.domain;

public class Planet {
    boolean isInhabited;
    boolean isDestroyed;

    public Planet(boolean isInhabited) {
        this.isInhabited = isInhabited;
        this.isDestroyed = false;
    }
}
