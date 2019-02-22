package com.example.miguel.avanzados_ahorcado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> palabras = new ArrayList<>();
    private int position;

    private TextView txtPalabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palabras = getAllWords();

        position = (int)(Math.random() * 10);

        txtPalabra = findViewById(R.id.txtPalabra);

        txtPalabra.setText(palabras.get(position)+"");

    }

    private List<String> getAllWords(){
        palabras.add("aplicacion");
        palabras.add("moviles");
        palabras.add("layout");
        palabras.add("context");
        palabras.add("intent");
        palabras.add("toast");
        palabras.add("alert");
        palabras.add("activity");
        palabras.add("list");
        palabras.add("adapter");
        palabras.add("listener");
        return palabras;
    }

    private String convertir(String palabra){
        for(int i = 0; i<palabra.length(); i++){
            ;
        }
    }
}
