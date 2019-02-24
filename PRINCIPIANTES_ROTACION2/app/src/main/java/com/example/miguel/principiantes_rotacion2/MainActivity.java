package com.example.miguel.principiantes_rotacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDesc = findViewById(R.id.txtDesc);

        txtDesc.setText("The Space Shuttle was a partially reusable low Earth orbital spacecraft system operated by " +
                "the U.S. National Aeronautics and Space Administration (NASA) as part of the Space Shuttle program. " +
                "Its official program name was Space Transportation System (STS), taken from a 1969 plan for a system " +
                "of reusable spacecraft of which it was the only item funded for development.");
    }
}
