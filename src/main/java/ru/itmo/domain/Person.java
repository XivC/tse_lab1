package ru.itmo.domain;

public class Person extends Throwable {
    String name;
    Location location;
    int mood;
    int colorHex;

    public Person(
            String name,
            Location startLocation,
            int colorHex
    ) {
        this.name = name;
        this.location = startLocation;
        this.colorHex = colorHex;
    }

    void move() {
        location.coordinate += 1;
    }

    void destroy(Planet planet) throws InformerPerson {
        planet.isDestroyed = true;
        if (planet.isInhabited) {
            this.mood = -1;
        } else {
            throw new InformerPerson("Error: planet is not inhabited", location);
        }
    }

    void shout(Person target) {
        target.mood -= 1;
        this.mood += 1;
    }

    Sound sit(Chair chair) {
        int power = Math.min(0, -this.mood);
        if (chair.resistance <= 0) {
            return null;
        }
        if (chair.resistance - power <= 0) {
            chair.resistance = 0;
            return Sound.CRASH;
        } else {
            return Sound.PITY_CREAK;
        }
    }
}

