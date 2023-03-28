package ru.itmo.func;

public class Sin {
    static Double of(Double x) {
        Double sum = 0.0;
        Double term = x;

        for (int i = 1; i <= 10; i++) {
            sum += term;
            term *= -1.0 * x * x / ((2 * i) * (2 * i + 1));
        }

        return sum;
    }
}
