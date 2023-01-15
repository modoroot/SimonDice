package com.example.simondice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9;
    TextView tv1;
    MediaPlayer mp1;
    //String que guarda los números elegidos aleatoriamente
    String numeroRecordar;
    //String que guarda los números que ha seleccionado el jugador
    String numeroJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        tv1 = findViewById(R.id.tv1);
        desactivarBotones();
    }

    private void desactivarBotones() {
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }

    private void activarBotones() {
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
    }

    @SuppressLint("SetTextI18n")
    public void iniciarJuego(View v) {
        desactivarBotones();
        numeroRecordar = "";
        addNum();
        tv1.setText("Cifras recordadas: " + numeroRecordar.length());
        numeroJugador = "";
        sonido(0);
    }

    private void sonido(int numSonido) {
        if (mp1 != null)
            //libera los recursos
            mp1.release();
        //asigna cada sonido a cada posible número
        if (numeroRecordar.charAt(numSonido) == '0')
            mp1 = MediaPlayer.create(this, R.raw.cero);
        if (numeroRecordar.charAt(numSonido) == '1')
            mp1 = MediaPlayer.create(this, R.raw.uno);
        if (numeroRecordar.charAt(numSonido) == '2')
            mp1 = MediaPlayer.create(this, R.raw.dos);
        if (numeroRecordar.charAt(numSonido) == '3')
            mp1 = MediaPlayer.create(this, R.raw.tres);
        if (numeroRecordar.charAt(numSonido) == '4')
            mp1 = MediaPlayer.create(this, R.raw.cuatro);
        if (numeroRecordar.charAt(numSonido) == '5')
            mp1 = MediaPlayer.create(this, R.raw.cinco);
        if (numeroRecordar.charAt(numSonido) == '6')
            mp1 = MediaPlayer.create(this, R.raw.seis);
        if (numeroRecordar.charAt(numSonido) == '7')
            mp1 = MediaPlayer.create(this, R.raw.siete);
        if (numeroRecordar.charAt(numSonido) == '8')
            mp1 = MediaPlayer.create(this, R.raw.ocho);
        if (numeroRecordar.charAt(numSonido) == '9')
            mp1 = MediaPlayer.create(this, R.raw.nueve);
        mp1.start();
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (numSonido < numeroRecordar.length() - 1) {
                    sonido(numSonido + 1);
                } else {
                    activarBotones();
                }
            }
        });

    }

    private void addNum() {
        //0-9
        int num = (int) (Math.random() * 9);
        switch (num) {
            case 0:
                numeroRecordar = numeroRecordar + "0";
                break;
            case 1:
                numeroRecordar = numeroRecordar + "1";
                break;
            case 2:
                numeroRecordar = numeroRecordar + "2";
                break;
            case 3:
                numeroRecordar = numeroRecordar + "3";
                break;
            case 4:
                numeroRecordar = numeroRecordar + "4";
                break;
            case 5:
                numeroRecordar = numeroRecordar + "5";
                break;
            case 6:
                numeroRecordar = numeroRecordar + "6";
                break;
            case 7:
                numeroRecordar = numeroRecordar + "7";
                break;
            case 8:
                numeroRecordar = numeroRecordar + "8";
                break;
            case 9:
                numeroRecordar = numeroRecordar + "9";
                break;
        }
    }

    public void clickBoton0(View v) {
        numeroJugador = numeroJugador + "0";
        isNumeroCorrecto();
    }

    public void clickBoton1(View v) {
        numeroJugador = numeroJugador + "1";
        isNumeroCorrecto();
    }

    public void clickBoton2(View v) {
        numeroJugador = numeroJugador + "2";
        isNumeroCorrecto();
    }

    public void clickBoton3(View v) {
        numeroJugador = numeroJugador + "3";
        isNumeroCorrecto();
    }

    public void clickBoton4(View v) {
        numeroJugador = numeroJugador + "4";
        isNumeroCorrecto();
    }

    public void clickBoton5(View v) {
        numeroJugador = numeroJugador + "5";
        isNumeroCorrecto();
    }

    public void clickBoton6(View v) {
        numeroJugador = numeroJugador + "6";
        isNumeroCorrecto();
    }

    public void clickBoton7(View v) {
        numeroJugador = numeroJugador + "7";
        isNumeroCorrecto();
    }

    public void clickBoton8(View v) {
        numeroJugador = numeroJugador + "8";
        isNumeroCorrecto();
    }

    public void clickBoton9(View v) {
        numeroJugador = numeroJugador + "9";
        isNumeroCorrecto();
    }

    @SuppressLint("SetTextI18n")
    private void isNumeroCorrecto() {
        if (numeroJugador.charAt(numeroJugador.length() - 1) != numeroRecordar.charAt(numeroJugador.length() - 1)) {
            Toast.makeText(this, "Has perdido",Toast.LENGTH_LONG).show();
            desactivarBotones();
        }
        else {
            if (numeroJugador.length()==numeroRecordar.length()){
                desactivarBotones();
                numeroJugador="";
                addNum();
                sonido(0);
                tv1.setText("Cifras recordadas: "+numeroRecordar.length());
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mp1!=null){
            mp1.release();
            mp1 = null;
        }
    }
}