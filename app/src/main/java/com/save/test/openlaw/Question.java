package com.save.test.openlaw;

import java.util.ArrayList;

public class Question {

    String titre;
    String corps;
    String domaine;
    ArrayList<Reponse> reponses;

    public Question() {
    }

    public Question(String titre, String corps) {
        this.titre = titre;
        this.corps = corps;
    }

    public Question(String titre, String corps, String domaine) {
        this.titre = titre;
        this.corps = corps;
        this.domaine = domaine;
    }

    public Question(String titre, String corps, String domaine, ArrayList<Reponse> reponses) {
        this.titre = titre;
        this.corps = corps;
        this.domaine = domaine;
        this.reponses = reponses;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public ArrayList<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(ArrayList<Reponse> reponses) {
        this.reponses = reponses;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
}
