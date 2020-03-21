package com.example.ekathapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class unitmembers extends AppCompatActivity {

    Spinner s1,s2;
    Button seemem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitmembers);

        s1=(Spinner)findViewById(R.id.mward2);
        s2=(Spinner)findViewById(R.id.munit2);

        seemem=(Button)findViewById(R.id.seemembers);

        seemem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),unitmembers.class);
                startActivity(intent);

            }
        });
    }
}
