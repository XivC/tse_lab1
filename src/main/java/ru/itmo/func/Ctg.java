package ru.itmo.func;

public class Ctg {

    public static double of(Double x) {
        return Cos.of(x) / Sin.of(x);
    }
}
