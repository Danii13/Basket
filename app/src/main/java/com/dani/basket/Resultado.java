package com.dani.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView tvPuntos = findViewById(R.id.tvPuntos);
        TextView tvResultado = findViewById(R.id.tvResultado);



        Bundle extra = getIntent().getExtras();

        String resultado = extra.getString("Ganador");
        String puntuacion = extra.getString("Puntuacion");

        tvPuntos.setText(puntuacion);
        tvResultado.setText(resultado);

    }
}