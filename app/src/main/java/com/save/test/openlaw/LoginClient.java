package com.save.test.openlaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginClient extends AppCompatActivity {

    EditText email;
    EditText pass;
    Button login;
    TextView inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);

        email = findViewById(R.id.in_email_client);
        pass = findViewById(R.id.in_pass_client);
        login = findViewById(R.id.in_inscrire_client);
        inscrire = findViewById(R.id.inscrire_client);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingUpClient.class);
                startActivity(intent);
            }
        });
    }
}
