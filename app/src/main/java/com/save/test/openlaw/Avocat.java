package com.save.test.openlaw;

public class Avocat {

    String nom;
    String prenom;
    String email;
    String age;
    String domaine;

    public Avocat() {
    }

    public Avocat(String nom, String prenom, String email, String age, String domaine) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
        this.domaine = domaine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
}
