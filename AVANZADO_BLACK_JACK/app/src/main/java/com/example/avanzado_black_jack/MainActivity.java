package com.example.avanzado_black_jack;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Puntaje de los jugadores
    int iPuntUsu=0,iPuntCom=0;
    //Variable que indica el número de turno
    int iTurno = 0;
    //Arreglo de las cartas aceptadas y la lista de la misma
    String baraja[] = {"1♥","2♥","3♥","4♥","5♥","6♥","7♥","8♥","9♥","10♥","J♥","Q♥","K♥",
            "1♦","2♦","3♦","4♦","5♦","6♦","7♦","8♦","9♦","10♦","J♦","Q♦","K♦",
            "1♣","2♣","3♣","4♣","5♣","6♣","7♣","8♣","9♣","10♣","J♣","Q♣","K♣",
            "1♠","2♠","3♠","4♠","5♠","6♠","7♠","8♠","9♠","10♠","J♠","Q♠","K♠",};
    List<String> listaBaraja = new ArrayList<String>(Arrays.asList(baraja));

    //Vincular los componentes
    TextView txtVwCarUnoUsu,txtVwCarDosUsu,txtVwCarTresUsu,txtVwCarCuatroUsu,txtVwCarCincoUsu,
            txtVwCarUnoCom,txtVwCarDosCom,txtVwCarTresCom,txtVwCarCuatroCom,txtVwCarCincoCom,txtVwGanador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwCarUnoCom = findViewById(R.id.txtVwCarUnoCom);
        txtVwCarDosCom = findViewById(R.id.txtVwCarDosCom);
        txtVwCarTresCom = findViewById(R.id.txtVwCarTresCom);
        txtVwCarCuatroCom = findViewById(R.id.txtVwCarCuatroCom);
        txtVwCarCincoCom = findViewById(R.id.txtVwCarCincoCom);

        txtVwCarUnoUsu = findViewById(R.id.txtVwCarUnoUsu);
        txtVwCarDosUsu = findViewById(R.id.txtVwCarDosUsu);
        txtVwCarTresUsu = findViewById(R.id.txtVwCarTresUsu);
        txtVwCarCuatroUsu = findViewById(R.id.txtVwCarCuatroUsu);
        txtVwCarCincoUsu = findViewById(R.id.txtVwCarCincoUsu);

        txtVwGanador = findViewById(R.id.txtVwGanador);

        imShuffling();
    }

    public void onClick( View v){
        if(iTurno <5){
            repartir();
            //txtVwGanador.setText("PuntUsu:"+iPuntUsu+" PuntCom:"+iPuntCom);
            iTurno++;
        }else if(iTurno ==5){
            Toast.makeText(getApplicationContext(),"El ganado es:",Toast.LENGTH_SHORT).show();
            iTurno =6;
        }else{
            Toast.makeText(getApplicationContext(),"Juego terminado",Toast.LENGTH_SHORT).show();
        }
        isGameOver(iPuntUsu,iPuntCom,iTurno);
    }

    public void clickReinicio(View v){
        reinicio();
    }

    public void reinicio(){
        iPuntCom = 0;
        iPuntUsu = 0;
        iTurno = 0;
        imShuffling();


        txtVwCarUnoCom.setText("☻");
        txtVwCarDosCom.setText("☻");
        txtVwCarTresCom.setText("☻");
        txtVwCarCuatroCom.setText("☻");
        txtVwCarCincoCom.setText("☻");
        txtVwCarUnoUsu.setText("☻");
        txtVwCarDosUsu.setText("☻");
        txtVwCarTresUsu.setText("☻");
        txtVwCarCuatroUsu.setText("☻");
        txtVwCarCincoUsu.setText("☻");

        txtVwGanador.setText("El ganador es:");
    }

    /**
     * En cada caso se reparte una carta a cada jugador y se realiza la comprobación
     */
    public void repartir(){
        switch (iTurno){
            case 0:
                txtVwCarUnoUsu.setText(listaBaraja.get(0));
                txtVwCarUnoCom.setText(listaBaraja.get(1));
                iPuntUsu+=getValorCarta(listaBaraja.get(0));
                iPuntCom+=getValorCarta(listaBaraja.get(1));
                break;

            case 1:
                txtVwCarDosUsu.setText(listaBaraja.get(2));
                txtVwCarDosCom.setText(listaBaraja.get(3));

                iPuntUsu+=getValorCarta(listaBaraja.get(2));
                iPuntCom+=getValorCarta(listaBaraja.get(3));
                break;

            case 2:
                txtVwCarTresUsu.setText(listaBaraja.get(4));
                txtVwCarTresCom.setText(listaBaraja.get(5));

                iPuntUsu+=getValorCarta(listaBaraja.get(4));
                iPuntCom+=getValorCarta(listaBaraja.get(5));

                break;

            case 3:
                txtVwCarCuatroUsu.setText(listaBaraja.get(6));
                txtVwCarCuatroCom.setText(listaBaraja.get(7));

                iPuntUsu+=getValorCarta(listaBaraja.get(6));
                iPuntCom+=getValorCarta(listaBaraja.get(7));

                break;

            case 4:
                txtVwCarCincoUsu.setText(listaBaraja.get(8));
                txtVwCarCincoCom.setText(listaBaraja.get(9));


                iPuntUsu+=getValorCarta(listaBaraja.get(8));
                iPuntCom+=getValorCarta(listaBaraja.get(9));

                break;
        }


    }

    public void isGameOver(int iPuntajeUsu,int iPuntajeCom,int iTurn){
        String sGan = "";
        boolean isOver = false;
        if(iTurn >= 5){
            if(iPuntajeCom>iPuntajeUsu){
                sGan = "el Humano";
                isOver = true;
            }else{
                sGan = "Los fierros";
                isOver = true;
            }
        }else{
            if(iPuntajeCom>21 && iPuntajeUsu>21){
                if(iPuntajeCom==iPuntajeUsu){
                    sGan = "Un empate:'(";
                    isOver = true;
                }else if(iPuntajeCom>21){
                    sGan = "el Humano";
                    isOver = true;
                }else if(iPuntajeUsu>21){
                    sGan = "Los fierros";
                    isOver = true;
                }

            }else{
                if(iPuntajeUsu == 21 && iPuntajeCom ==21){
                    sGan = "Un empate:'(";
                    isOver = true;
                }else if(iPuntajeCom == 21){
                    sGan = "Los fierros";
                    isOver = true;
                }else if(iPuntajeUsu == 21){
                    sGan = "el Humano";
                    isOver = true;
                }
            }
        }
        if (isOver){ mostrarDialogo("El ganador es:"+sGan+" punCom:"+iPuntajeCom+" punUs:"+iPuntajeUsu);}

    }

    public void mostrarDialogo(String sGan){
        new AlertDialog.Builder(this)
                .setTitle("Se ha acabado esta vaian")
                .setMessage(sGan)
                .setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"Fierro pues",Toast.LENGTH_SHORT).show();
                        reinicio();
                    }
                })

                .setNegativeButton("Nel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Nel krnl",Toast.LENGTH_SHORT).show();
                    }
                })

                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"X krnl",Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }

    /**
     *
     * @param carta Es el string de la carta
     * @return regresa un valor númerico respecetivo
     */
    public int getValorCarta(String carta){
        int iVal=0;
        char cVal = carta.charAt(0);
        if(cVal == 'K'){
            iVal=13;
        }else if(cVal == 'Q'){
            iVal = 12;
        }else if(cVal == 'J'){
            iVal = 11;
        }else if(cVal == '1'){
            if (carta.charAt(1) == '0'){
                iVal = 10;
            }else{
                iVal = 1;
            }
        }else{
            iVal = Character.getNumericValue(cVal);
        }
        return iVal;
    }

    /**
     * Método para reborujar la baraja
     */
    public void imShuffling(){
        Collections.shuffle(listaBaraja);
    }

    /**
     * Método para imprimir la baraja
     */
    public void printBaraja(){
        System.out.println(Arrays.toString(listaBaraja.toArray()));
    }

}
