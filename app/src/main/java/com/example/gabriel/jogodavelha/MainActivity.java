package com.example.gabriel.jogodavelha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabriel.jogodavelha.model.idioma.Idioma;
import com.example.gabriel.jogodavelha.model.idioma.Ingles;
import com.example.gabriel.jogodavelha.model.idioma.Portugues;


public class MainActivity extends AppCompatActivity {
    Button jogar;
    TextView jogoDaVelha;
    Button config;
    Idioma idioma;
    SharedPreferences preferencias;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        if (preferencias.getString("idioma", "pt").equals("pt")) {
            idioma = new Portugues();
        } else {
            idioma = new Ingles();
        }

        jogar = (Button)findViewById(R.id.jogar);
        jogar.setText(idioma.jogar);

        config = (Button)findViewById(R.id.config);
        config.setText(idioma.idioma);

        jogoDaVelha = (TextView)findViewById(R.id.jogoDaVelha);
        jogoDaVelha.setText(idioma.jogoDaVelha);

    }

    public void jogar(View view) {
        Intent intent = new Intent(this, JogoActivity.class);

        startActivity(intent);
    }

    public void config(View view) {
        Intent intent = new Intent(this, ConfigActivity.class);

        startActivity(intent);
    }
}
