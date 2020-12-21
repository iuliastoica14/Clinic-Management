package com.sanitas.clinicapp.mr;

public class Patient {

    private String cnp;
    private String lastname;
    private String firstname;
    private String iban;

    public Patient(String cnp, String lastname, String firstname) {
        this.cnp = cnp;
        this.lastname = lastname;
        this.firstname = firstname;
        this.iban = "";
    }

    public Patient(String cnp, String lastname, String firstname, String iban) {
        this.cnp = cnp;
        this.lastname = lastname;
        this.firstname = firstname;
        this.iban = iban;
    }

    public String getCnp() {
        return cnp;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "cnp='" + cnp + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
