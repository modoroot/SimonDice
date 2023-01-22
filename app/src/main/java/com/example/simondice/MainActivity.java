package com.example.simondice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonIniciarJuego;

    TextView tv1;
    MediaPlayer mp1;
    //String que guarda los números elegidos aleatoriamente
    String numeroRecordar;
    //String que guarda los números que ha seleccionado el jugador
    String numeroJugador;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Infla el menú y lo coloca en el main
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.modo_facil) {
            recreate();
            return true;
        }
        if (id == R.id.modo_dificil) {
            // Handle the about action
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencias a los botones,TextView, etc
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
        buttonIniciarJuego = findViewById(R.id.buttonInit);
        tv1 = findViewById(R.id.tv1);
        //Reinicia los componentes y textos del juego y rota 360º el botón de Iniciar juego
        buttonIniciarJuego.setOnClickListener(view -> {
            desactivarBotones();
            numeroRecordar = "";
            addNum();
            tv1.setText("Cifras recordadas: " + numeroRecordar.length());
            numeroJugador = "";
            sonido(0);
            // Crea una animación de rotación de 360 grados
            ObjectAnimator animator = ObjectAnimator.ofFloat(buttonIniciarJuego,
                    "rotation", 0f, 360f);
            animator.setDuration(500); // duración de 0.5 segundo
            animator.start();
        });

        //Variables para la animación asignada al TextField
        // Crea un nuevo objeto de Handler
        Handler handler = new Handler();
        // Establece el retraso en milisegundos entre cada parpadeo
        final int delay = 1000; //1 s
        Random random = new Random();
        // Programa una tarea para ejecutar después del retraso establecido
        handler.postDelayed(new Runnable() {
            public void run() {
                // Comprueba si el TextView está visible
                if (tv1.getVisibility() == View.VISIBLE) {
                    //Lo oculta
                    tv1.setVisibility(View.INVISIBLE);
                } else {
                    //Cambia el color de forma aleatoria según el tiempo asignado de retraso
                    tv1.setTextColor(Color.argb(255, random.nextInt(256),
                            random.nextInt(256), random.nextInt(256)));
                    //Lo muestra
                    tv1.setVisibility(View.VISIBLE);

                }
                // Vuelve a programar la misma tarea para que se
                // ejecute después del retraso establecido
                handler.postDelayed(this, delay);
            }
        }, delay);


        //Aumenta de tamaño el botón si lo dejas pulsado y lo vuelve a disminuir cuando
        //dejas de pulsarlo
        button0.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button1.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button2.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button3.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button4.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button5.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button6.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button7.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button8.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });
        button9.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Aumenta el tamaño del botón
                view.animate().scaleX(1.2f).scaleY(1.2f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                // Volver al tamaño original
                view.animate().scaleX(1f).scaleY(1f);
            }
            return false;
        });


        desactivarBotones();
    }

    /**
     * Desactiva los botones
     */
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

    /**
     * Activa los botones
     */
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

    /**
     * Controla el sonido a reproducir y la cantidad de ellos a reproducir.
     * Crea las referencias de los sonidos a cada botón
     *
     * @param numSonido sonido a reproducir
     */
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
        assert mp1 != null;
        //comienza el sonido
        mp1.start();
        mp1.setOnCompletionListener(mp -> {
            if (numSonido < numeroRecordar.length() - 1) {
                sonido(numSonido + 1);
            } else {
                activarBotones();
            }
        });

    }

    /**
     * Añade un número aleatorio para reproducirlo como sonido en el juego
     */
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

    /**
     * Cada uno de estos métodos comprueba si el número es correcto y
     * lo asigna a la cadena del jugador
     *
     * @param v view
     */
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

    /**
     * Controla si el número es correcto o incorrecto, reproduce los sonidos, añade el siguiente número
     * y actualiza el TextView
     */
    @SuppressLint("SetTextI18n")
    private void isNumeroCorrecto() {
        if (numeroJugador.charAt(numeroJugador.length() - 1) != numeroRecordar.charAt(numeroJugador.length() - 1)) {
            Toast.makeText(this, "Has perdido", Toast.LENGTH_LONG).show();
            desactivarBotones();
        } else {
            if (numeroJugador.length() == numeroRecordar.length()) {
                desactivarBotones();
                numeroJugador = "";
                addNum();
                sonido(0);
                tv1.setText("Cifras recordadas: " + numeroRecordar.length());
            }
        }
    }

    /**
     * Controla la clase MediaPlayer
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (mp1 != null) {
            mp1.release();
            mp1 = null;
        }
    }
}