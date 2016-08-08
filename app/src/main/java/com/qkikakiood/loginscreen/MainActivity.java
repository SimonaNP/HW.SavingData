package com.qkikakiood.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editUsername;
    EditText editPass;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = (EditText) findViewById(R.id.edit_username);
        btnLogin = (Button) findViewById(R.id.btn_signin);
        btnRegister = (Button) findViewById(R.id.btn_signup);
        editPass = (EditText) findViewById(R.id.edit_password);
        final SharedPreferences sp = getPreferences(MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            String username = String.valueOf(editUsername.getText());
            String password = String.valueOf(editPass.getText());

            @Override
            public void onClick(View view) {
                if (sp.getString(username, username + " ").equals(username)
                        && sp.getString(password, password + " ").equals(password)) {
                    startActivity(new Intent(MainActivity.this, SignedInActivity.class));
                }
            }
        });
    }

}