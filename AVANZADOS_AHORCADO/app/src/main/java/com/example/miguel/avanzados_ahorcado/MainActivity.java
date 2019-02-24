package com.example.miguel.avanzados_ahorcado;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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
    private boolean bExtreme = false;

    //COMPONENTES
    private TextView txtPalabra, txtIntentos, txtCant;
    private Button btnOK, btnNew;
    private EditText etxtLetra;
    private RadioButton rdDif, rdMed, rdFac;
    private CheckBox cbxEX;

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
        txtCant = findViewById(R.id.txtCant);
        cbxEX = findViewById(R.id.cbxEX);

        palabras = getAllWords();


        etxtLetra.setText("");
        position = (int)(Math.random() * 10);
        palabraActual = palabras.get(position);

        txtCant.setText("Cantidad de letras: " + palabraActual.replace(" ","").length());

        if (cbxEX.isChecked()){
            bExtreme = true;
        }

        if(rdDif.isChecked()){
            intentos = 2;
        }else if(rdMed.isChecked()){
            intentos = 4;
        }else if(rdFac.isChecked()){
            intentos = 6;
        }

        txtIntentos.setText("Intentos restantes: " + (intentos));

        switch (palabraActual){
            case "h o r m i g a":
                txtPalabra.setText("h _ _ _ _ _ _");
                break;
            case "m o v i l e s":
                txtPalabra.setText("m _ _ _ _ _ _");
                break;
            case "l a y o u t":
                txtPalabra.setText("l _ _ _ _ _");
                break;
            case "p a r t i d o":
                txtPalabra.setText("p _ _ _ _ _ _");
                break;
            case "m u n d o":
                txtPalabra.setText("m _ _ _ _");
                break;
            case "t o a s t":
                txtPalabra.setText("t _ _ _ _");
                break;
            case "a l e r t":
                txtPalabra.setText("a _ _ _ _");
                break;
            case "F u e g o":
                txtPalabra.setText("f _ _ _ _");
                break;
            case "l i s t":
                txtPalabra.setText("l _ _ _");
                break;
            case "m u s i c a":
                txtPalabra.setText("m _ _ _ _ _");
                break;
        }

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStart();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            final Dialog dlgMiDialog = new Dialog(MainActivity.this);
            @Override
            public void onClick(View v) {
                letra = etxtLetra.getText().toString();
                if(letra.length() ==  0){
                    Toast.makeText(MainActivity.this, "Ingrese una letra/palabra", Toast.LENGTH_SHORT).show();
                }else if(letra.length() == 1){
                    if(bExtreme){
                        if(letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u")){
                            txtIntentos.setText("Intentos restantes: " + (--intentos));
                        }
                    }
                    for (int i=0; i<palabraActual.length(); i++){
                        if(letra.equals(palabraActual.charAt(i)+"")){
                            aux = new StringBuilder(txtPalabra.getText());
                            aux = aux.replace(i,i+1,letra);
                            txtPalabra.setText(aux);
                            if(txtPalabra.getText().equals(palabraActual)){
                                txtPalabra.setText(palabraActual);
                                dlgMiDialog.setContentView(R.layout.alert_ganador);

                                Button btnAlert;
                                btnAlert = dlgMiDialog.findViewById(R.id.btnAlert);

                                btnAlert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dlgMiDialog.dismiss();
                                        onStart();
                                    }
                                });
                                dlgMiDialog.show();
                            }else{
                                break;
                            }
                        }else if(i == palabraActual.length()-1){
                            if(!letra.equals(palabraActual.charAt(i)+"")){
                                Toast.makeText(MainActivity.this, "Incorrecta!", Toast.LENGTH_SHORT).show();
                                txtIntentos.setText("Intentos restantes: " + (--intentos));
                                if(intentos == 0){
                                    dlgMiDialog.setContentView(R.layout.alert_perdedor);

                                    Button btnAlert;
                                    btnAlert = dlgMiDialog.findViewById(R.id.btnAlert);

                                    btnAlert.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dlgMiDialog.dismiss();
                                            onStart();
                                        }
                                    });
                                    dlgMiDialog.show();
                                }
                            }
                        }
                    }
                }else if(letra.length() > 1){
                    if(letra.equals(palabraActual.replace(" ",""))){
                        txtPalabra.setText(palabraActual);
                        dlgMiDialog.setContentView(R.layout.alert_ganador);

                        Button btnAlert;
                        btnAlert = dlgMiDialog.findViewById(R.id.btnAlert);

                        btnAlert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dlgMiDialog.dismiss();
                                onStart();
                            }
                        });
                        dlgMiDialog.show();
                    }else{
                        dlgMiDialog.setContentView(R.layout.alert_perdedor);

                        Button btnAlert;
                        btnAlert = dlgMiDialog.findViewById(R.id.btnAlert);

                        btnAlert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dlgMiDialog.dismiss();
                                onStart();
                            }
                        });
                        dlgMiDialog.show();
                    }
                }
                etxtLetra.setText("");
            }
        });
    }

    private List<String> getAllWords(){
        palabras.add("h o r m i g a");
        palabras.add("m o v i l e s");
        palabras.add("l a y o u t");
        palabras.add("p a r t i d o");
        palabras.add("m u n d o");
        palabras.add("t o a s t");
        palabras.add("a l e r t");
        palabras.add("f u e g o");
        palabras.add("l i s t");
        palabras.add("m u s i c a");
        return palabras;
    }
}
