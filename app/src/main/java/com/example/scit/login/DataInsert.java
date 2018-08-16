package com.example.scit.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataInsert extends AppCompatActivity {
    Database database;
    EditText mId,mName,mPhone;
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);
        database = new Database(this);

        mId = (EditText)findViewById(R.id.et_insert_id);
        mName = (EditText)findViewById(R.id.et_insert_name);
        mPhone = (EditText)findViewById(R.id.et_insert_phone);
        mButton = (Button)findViewById(R.id.btn_insert_data);
        dataInsert();

    }
    public void dataInsert(){
        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = database.insertData(mId.getText().toString(),
                                mName.getText().toString(),
                                Integer.parseInt(mPhone.getText().toString()));
                        if (isInserted == true){
                            Toast.makeText(DataInsert.this,"Successfully Inserted",Toast.LENGTH_SHORT).show();

                        }else
                            Toast.makeText(DataInsert.this,"Insertion Failed",Toast.LENGTH_LONG).show();


                    }
                }
        );
    }




}
