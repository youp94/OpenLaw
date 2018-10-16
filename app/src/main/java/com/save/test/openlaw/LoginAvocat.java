package com.save.test.openlaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginAvocat extends AppCompatActivity {

    EditText email;
    EditText pass;
    Button login;
    TextView inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_avocat);

        email = findViewById(R.id.in_email_avocat);
        pass = findViewById(R.id.in_pass_avocat);
        login = findViewById(R.id.in_inscrire_avocat);
        inscrire = findViewById(R.id.inscrire_avocat);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingUpAvocat.class);
                startActivity(intent);
            }
        });
    }
}
