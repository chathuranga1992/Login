package com.example.scit.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    //Instance for database
    Database database;

    //
    private Button mButton;
    private Button mViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        database = new Database(this);
        mButton = (Button) findViewById(R.id.btn_db_creation);
        mViewButton = (Button) findViewById(R.id.btn_data_view);

        //Calling to data inserting from create button
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, DataInsert.class);
                startActivity(intent);
            }
        });
        viewData();
    }

    //View data from Database
    public void viewData() {

        //set click listener for view button
        mViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = database.getData();
                if (result.getCount() == 0) {
                    Toast.makeText(UserActivity.this, "", Toast.LENGTH_SHORT).show();

                    //Displaying message from showMessage function
                    showMesaage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()) {
                    buffer.append("id :" + result.getString(0) + "\n");
                    buffer.append("Name :" + result.getString(1) + "\n");
                    buffer.append("Phone :" + result.getInt(2) + "\n\n");
                }
                showMesaage("DATA", buffer.toString());

            }
        });
    }

    //function for build message structure
    public void showMesaage(String title, String mesage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(mesage);
        builder.show();
    }
}
