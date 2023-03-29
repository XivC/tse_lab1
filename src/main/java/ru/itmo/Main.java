package ru.itmo;


import ru.itmo.func.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;


public class Main {
    private static final String CSV_FILE_NAME = "out.csv";
    private static final String SEPARATOR = "   ";

    private static void column(PrintWriter pw, Object value) {
        String s = value.toString();
        pw.print(s);
        for (int i = 0; i < 10 - s.length(); i++) {
            pw.print(" ");
        }
        pw.print(SEPARATOR);
    }
    public static void main(String[] args) {
        final Class[] units = new Class[] {
                Cos.class, Sin.class, Tg.class, Ctg.class,
                Ln.class, Ln2.class, Ln3.class, Sec.class, Csc.class,
                Fn.class
        };
        double step = 0.1;
        File csvOutputFile = new File(CSV_FILE_NAME);

        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            column(pw, "X");
            for (Class unit: units) {
                column(pw, unit.getSimpleName() +"(X)");
            }
            pw.print("\n");

            for (double x = -1.0; x < 1.0; x += step) {
                column(pw, String.format("%.2f" + SEPARATOR, x));
                for (Class unit: units) {
                    double y = (double) unit.getDeclaredMethod("of", Double.class).invoke(null, x);
                    column(pw, String.format("%.2f(X)", y));
                }
                pw.print("\n");
            }
        } catch (FileNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}