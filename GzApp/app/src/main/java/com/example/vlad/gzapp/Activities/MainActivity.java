package com.example.vlad.gzapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.vlad.gzapp.R;

public class MainActivity extends Activity {
    EditText editText;
    ImageButton imageButton;
    String city;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText = (EditText)findViewById(R.id.input);
        imageButton = (ImageButton)findViewById(R.id.imageButton);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),WeatherAllInformation.class);
                intent.putExtra("CITY",editText.getText().toString());
                startActivity(intent);
                Log.e("MAIN ","Intent " +intent);

            }
        });

    }
}
