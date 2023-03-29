package ru.itmo.func;

public class Ln {
    public static Double of(Double x){

        assert x > 0;

        int numTerms = 1000;
        double sum = 0;
        for (int i = 1; i <= numTerms; i++) {
            double term = (i % 2 == 0) ? -1.0/i : 1.0/i;
            sum += term * Math.pow((x-1), i);
        }

       return sum;
    }
}
