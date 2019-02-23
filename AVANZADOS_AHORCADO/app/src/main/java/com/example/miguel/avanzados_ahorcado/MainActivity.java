package com.example.miguel.avanzados_ahorcado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> palabras = new ArrayList<>();

    //VARIABLES
    private String palabraActual, letra;
    private int position;
    private StringBuilder aux;
    private int intentos;

    //COMPONENTES
    private TextView txtPalabra, txtIntentos;
    private Button btnOK, btnNew;
    private EditText etxtLetra;
    private RadioButton rdDif, rdMed, rdFac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        txtPalabra = findViewById(R.id.txtPalabra);
        txtIntentos = findViewById(R.id.txtIntentos);
        btnOK = findViewById(R.id.btnOK);
        btnNew = findViewById(R.id.btnNew);
        etxtLetra = findViewById(R.id.etxtLetra);
        rdDif = findViewById(R.id.rdDif);
        rdMed = findViewById(R.id.rdMed);
        rdFac = findViewById(R.id.rdFac);

        palabras = getAllWords();

        position = (int)(Math.random() * 10);
        palabraActual = palabras.get(position);

        if(rdDif.isChecked()){
            intentos = 2;
        }else if(rdMed.isChecked()){
            intentos = 4;
        }else if(rdFac.isChecked()){
            intentos = 6;
        }

        txtIntentos.setText("Intentos restantes: " + (intentos));

        switch (palabraActual){
            case "a p l i c a c i o n":
                txtPalabra.setText("a _ _ _ _ _ _ _ _ _");
                break;
            case "m o v i l e s":
                txtPalabra.setText("m _ _ _ _ _ _");
                break;
            case "l a y o u t":
                txtPalabra.setText("l _ _ _ _ _");
                break;
            case "c o n t e x t":
                txtPalabra.setText("c _ _ _ _ _ _");
                break;
            case "i n t e n t":
                txtPalabra.setText("i _ _ _ _ _");
                break;
            case "t o a s t":
                txtPalabra.setText("t _ _ _ _");
                break;
            case "a l e r t":
                txtPalabra.setText("a _ _ _ _");
                break;
            case "a c t i v i t y":
                txtPalabra.setText("a _ _ _ _ _ _ _");
                break;
            case "l i s t":
                txtPalabra.setText("l _ _ _");
                break;
            case "a d a p t e r":
                txtPalabra.setText("a _ _ _  _ _ _");
                break;
        }

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStart();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letra = etxtLetra.getText().toString();
                if(letra.length() ==  0){
                    Toast.makeText(MainActivity.this, "Ingrese una letra/palabra", Toast.LENGTH_SHORT).show();
                }else if(letra.length() == 1){
                    for (int i=0; i<palabraActual.length(); i++){
                        if(letra.equals(palabraActual.charAt(i)+"")){
                            aux = new StringBuilder(txtPalabra.getText());
                            aux = aux.replace(i,i+1,letra);
                            txtPalabra.setText(aux);
                        }
                    }
                }else if(letra.length() > 1){

                }
            }
        });

    }

    private List<String> getAllWords(){
        palabras.add("a p l i c a c i o n");
        palabras.add("m o v i l e s");
        palabras.add("l a y o u t");
        palabras.add("c o n t e x t");
        palabras.add("i n t e n t");
        palabras.add("t o a s t");
        palabras.add("a l e r t");
        palabras.add("a c t i v i t y");
        palabras.add("l i s t");
        palabras.add("a d a p t e r");
        palabras.add("l i s t e n e r");
        return palabras;
    }
}
