package ru.itmo.func;

public class Ln3 {
    public static Double of(Double x){
        return Ln.of(x) / Ln.of(3D);
    }
}
