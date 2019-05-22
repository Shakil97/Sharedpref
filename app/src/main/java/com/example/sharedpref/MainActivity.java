package com.example.sharedpref;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText tnText;
    EditText tnEdit;
    Button btnSubmit;
    public static final String MY_PREF_FILENAME="com.example.sharedpref";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tnText=findViewById(R.id.tnText);
        tnEdit=findViewById(R.id.tnEdit);
        btnSubmit=findViewById(R.id.btnSubmit);


        SharedPreferences prefs=getSharedPreferences(MY_PREF_FILENAME,MODE_PRIVATE);

        String user=prefs.getString("user","");
        tnText.setText("Welcome to my app"+user+"!");




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=tnEdit.getText().toString().trim();
                tnText.setText("Welcome to my app"+name+"!");

                SharedPreferences.Editor editor=getSharedPreferences(MY_PREF_FILENAME,MODE_PRIVATE).edit();
                editor.putString("user",name);
                editor.commit();
            }
        });

    }
}
