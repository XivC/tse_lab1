package ru.itmo.func;

public class Ln{
    public static Double of(Double x){
        double result = 0;
        double term = (x - 1) / x;
        double numerator = term;

        for (int i = 1; i <= 1000; i++) {
            result += numerator / i;
            numerator *= -term;
        }

        return result;
    }
}
