package com.qkikakiood.loginscreen;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText editPass;
    EditText editUser;
    EditText editConfPass;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final SharedPreferences sp = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();


        editConfPass = (EditText) findViewById(R.id.edit_reg_conf_password);
        editPass = (EditText) findViewById(R.id.edit_reg_password);
        editUser = (EditText) findViewById(R.id.edit_reg_username);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(editPass.getText()).equals(String.valueOf(editConfPass.getText()))) {
                    editor.putString(String.valueOf(editUser.getText()), String.valueOf(editUser.getText()));
                    editor.putString(String.valueOf(editPass.getText()), String.valueOf(editPass.getText()));
                    editor.commit();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                }
            }
        });

    }
}