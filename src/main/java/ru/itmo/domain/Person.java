package ru.itmo.domain;

public class Person extends Exception {
    String name;
    Location location;
    int mood;
    int colorHex;

    public Person(
            String name,
            Location startLocation,
            int colorHex,
            int mood
    ) {
        this.name = name;
        this.location = startLocation;
        this.colorHex = colorHex;
        this.mood = mood;
    }

    public void move() {
        location.coordinate += 1;
    }

    public void destroy(Planet planet) throws InformerPerson {
        planet.isDestroyed = true;
        if (planet.isInhabited) {
            this.mood = -1;
        } else {
            throw new InformerPerson("Error: planet is not inhabited", location);
        }
    }

    public void shout(Person target) {
        target.mood -= 1;
        this.mood += 1;
    }

    public Sound sit(Chair chair) {
        int power = -this.mood;
        if (chair.resistance - power <= 0) {
            return Sound.CRASH;
        } else {
            return Sound.PITY_CREAK;
        }
    }


    public Location getLocation() {
        return location;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getMood() {
        return mood;
    }
}

