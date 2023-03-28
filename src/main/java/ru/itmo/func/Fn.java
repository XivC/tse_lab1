package ru.itmo.func;

public class Fn {
    public static Double of(Double x){
        if (x <= 0){
            double term1 = (Csc.of(x) * Sin.of(x) - Ctg.of(x))/(Ctg.of(x) - Sec.of(x));
            double term2 = Csc.of(x)/(Cos.of(x) * Ctg.of(x));
            return term1 * term1 * term1 * (term2 + Cos.of(x));
        }
        double term1 = Ln.of(x) + Log2.of(x);
        double term2 = term1 * term1 * term1 / (Ln.of(x) - Log3.of(x));
        return term2 * term2 * term2 + Log3.of(x);
    }
}
