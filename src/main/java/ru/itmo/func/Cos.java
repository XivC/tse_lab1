package ru.itmo.func;

public class Cos {

    public static Double of(Double x) {
        x = Math.abs(x) % (2 * Math.PI);
        double y = Math.sqrt(1 -  Sin.of(x) * Sin.of(x));
        y = (x < Math.PI / 2) || (x > 3 * Math.PI / 2) ? y : -y;
        return Math.min(1, Math.max(-1, y));
    }
}
