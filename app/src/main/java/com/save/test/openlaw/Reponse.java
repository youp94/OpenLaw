package com.save.test.openlaw;

import java.io.Serializable;

public class Reponse implements Serializable {

    String auteur;
    String corps;

    public Reponse() {
    }

    public Reponse(String auteur, String corps) {
        this.auteur = auteur;
        this.corps = corps;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }
}
