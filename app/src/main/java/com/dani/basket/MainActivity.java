package com.dani.basket;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int pntsLocal = 0;
    public  int pntsVisit = 0;
    public String Pnt1 = null;
    public String Pnt2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMasUnoLocal = findViewById(R.id.btnMasUnoLocal);
        Button btnMasDosLocal = findViewById(R.id.btnMasDosLocal);
        Button btnLessLocal = findViewById(R.id.btnLessLocal);

        Button btnMasUnoVisit = findViewById(R.id.btnMasUnoVisit);
        Button btnMasDosVisit = findViewById(R.id.btnMasDosVisit);
        Button btnLessVisit = findViewById(R.id.btnLessVisit);

        Button btnContinue = findViewById(R.id.btnContinue);
        Button btnReset = findViewById(R.id.btnReset);

        TextView tvLocalPoints = findViewById(R.id.tvLocalPnts);
        TextView tvVisitPoints = findViewById(R.id.tvVisitantePnts);

        tvLocalPoints.setText("0");
        tvVisitPoints.setText("0");




        btnMasUnoLocal.setOnClickListener(view -> {
            pntsLocal = pntsLocal + 1;
            Pnt1 = pntsLocal+"";
            tvLocalPoints.setText(Pnt1);
        });
        btnMasDosLocal.setOnClickListener(view -> {
            pntsLocal = pntsLocal + 2;
            Pnt1 = pntsLocal+"";
            tvLocalPoints.setText(Pnt1);
        });
        btnLessLocal.setOnClickListener(view -> {

            if (pntsLocal > 0){

            pntsLocal = pntsLocal - 1;
            Pnt1 = pntsLocal+"";
            tvLocalPoints.setText(Pnt1);}

            else {
                Toast.makeText(this, "La puntuación no puede ser menor que 0", Toast.LENGTH_SHORT).show();
            }
        });

        btnMasUnoVisit.setOnClickListener(view -> {
            pntsVisit = pntsVisit + 1;
            Pnt2 = pntsVisit+"";
            tvVisitPoints.setText(Pnt2);
        });
        btnMasDosVisit.setOnClickListener(view -> {
            pntsVisit = pntsVisit + 2;
            Pnt2 = pntsVisit+"";
            tvVisitPoints.setText(Pnt2);
        });
        btnLessVisit.setOnClickListener(view -> {
            if (pntsVisit > 0){

                pntsVisit = pntsVisit - 1;
                Pnt2 = pntsVisit+"";
                tvVisitPoints.setText(Pnt2);}

            else {
                Toast.makeText(this, "La puntuación no puede ser menor que 0", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(view -> {
            pntsVisit = 0;
            pntsLocal = 0;

            Pnt1 = pntsLocal+"";
            Pnt2 = pntsVisit+"";

            tvVisitPoints.setText(Pnt2);
            tvLocalPoints.setText(Pnt1);
        });

        btnContinue.setOnClickListener(view -> {
            Intent intent = new Intent(this, Resultado.class);
            String Ganador = null;
            String puntuacion = pntsLocal + " - " + pntsVisit;
            if(pntsLocal > pntsVisit){
                Ganador = getString(R.string.lclGanador);
            } else if(pntsVisit > pntsLocal){
                Ganador = getString(R.string.vstGanador);
            } else{
                Ganador = getString(R.string.empate);
            }

            intent.putExtra("Ganador", Ganador);
            intent.putExtra("Puntuacion", puntuacion);
            startActivity(intent);
        });




    }
}