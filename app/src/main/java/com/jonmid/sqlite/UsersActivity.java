package com.jonmid.sqlite;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jonmid.sqlite.Data.DataUser;
import com.jonmid.sqlite.Models.User;

public class UsersActivity extends AppCompatActivity {


    TextInputEditText name, email;
    Button register;
    DataUser dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        name = (TextInputEditText) findViewById(R.id.name);
        email = (TextInputEditText) findViewById(R.id.email);
        register = (Button) findViewById(R.id.guardar);
        dataUser = new DataUser(this);
        dataUser.open();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createData();
                goUsers();
            }
        });

    }

    private void createData(){

        User user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        dataUser.create(user);
    }

    public void goUsers() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
