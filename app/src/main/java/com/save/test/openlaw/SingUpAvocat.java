package com.save.test.openlaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SingUpAvocat extends AppCompatActivity {

    EditText nom;
    EditText prenom;
    EditText email;
    EditText pass;
    EditText confPass;
    EditText age;
    Button inscrire;
    Spinner domaine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_avocat);

        nom = findViewById(R.id.up_nom_avocat);
        prenom = findViewById(R.id.up_prenom_avocat);
        email = findViewById(R.id.up_email_avocat);
        pass = findViewById(R.id.up_pass_avocat);
        confPass = findViewById(R.id.up_conf_pass_avocat);
        age = findViewById(R.id.up_age_avocat);
        inscrire = findViewById(R.id.button_inscrire_avocat);

        domaine = findViewById(R.id.spinner_domaines);
    }
}
