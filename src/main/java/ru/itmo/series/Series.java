package ru.itmo.series;

import java.lang.Math;

public class Series {
    public static final double PI = 3.14159265;
    public static long factorial(long x){
        long res = 1;
        for (long i = 1; i <= x; i++){
            res *= i;
        }
        return res;
    }
    public static double cos(double x){
        double res = 0;
        for (long k = 0; k < 8; k++){
            res += (Math.pow(-1, k) * Math.pow(x, 2*k))/(Series.factorial(2*k));
        }
        return res;
    }
}
