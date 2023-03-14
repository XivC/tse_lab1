package ru.itmo.domain;

public class InformerPerson extends Person {

    String errorMessage;

    public InformerPerson(String errorMessage, Location startLocation) {
        super("Informer", startLocation, 0xFF0000, 0);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
