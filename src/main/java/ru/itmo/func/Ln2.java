package ru.itmo.func;

public class Ln2 {
    public static Double of(Double x){
        return Ln.of(x) / Ln.of(2D);
    }
}
