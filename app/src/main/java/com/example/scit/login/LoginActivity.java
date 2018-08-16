package com.example.scit.login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {


    private EditText mName;
    private EditText mPassword;
    private Button mLogin;
    private int loginCounter = 5;
    private TextView mCounter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mName = (EditText) findViewById(R.id.et_name);
        mPassword = (EditText) findViewById(R.id.et_password);
        mLogin = (Button) findViewById(R.id.btn_login);
        mCounter = (TextView)findViewById(R.id.tv_counter);

        mCounter.setText("You have "+String.valueOf(loginCounter)+ " Attempts ");

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin(mName.getText().toString(), mPassword.getText().toString());
            }
        });


    }


    private void admin(String userName, String password) {
        if ((userName.equals("admin")) && (password.equals("admin"))) {
            Intent intent = new Intent(LoginActivity.this, UserActivity.class);
            startActivity(intent);
            Toast.makeText(this, " Login Success.! ",Toast.LENGTH_SHORT).show();
        }else{
            loginCounter --;
            mCounter.setText("Remaining Attempts : "+String.valueOf(loginCounter));
            Toast.makeText(this, "Wrong Username or Password.!\n You have " + loginCounter + " Attempts",Toast.LENGTH_SHORT).show();
            if (loginCounter == 0){
                mCounter.setText("Login Disabled");
                Toast.makeText(this, " Login Disabled ",Toast.LENGTH_SHORT).show();
                mLogin.setEnabled(false);
            }

        }
    }
}
