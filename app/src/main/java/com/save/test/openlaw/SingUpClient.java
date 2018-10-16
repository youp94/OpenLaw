package com.save.test.openlaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SingUpClient extends AppCompatActivity {

    EditText nom;
    EditText prenom;
    EditText email;
    EditText pass;
    EditText confPass;
    EditText age;
    Button inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_client);

        nom = findViewById(R.id.up_nom_client);
        prenom = findViewById(R.id.up_prenom_client);
        email = findViewById(R.id.up_email_client);
        pass = findViewById(R.id.up_pass_client);
        confPass = findViewById(R.id.up_conf_pass_client);
        age = findViewById(R.id.up_age_avocat);
        inscrire = findViewById(R.id.button_inscrire_client);
    }
}
