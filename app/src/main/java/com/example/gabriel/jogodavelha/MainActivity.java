package com.example.gabriel.jogodavelha;

import android.annotation.SuppressLint;
import android.content.Intent;
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
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Idioma idioma = new Ingles();

        jogar = (Button)findViewById(R.id.jogar);
        jogar.setText(idioma.jogar);

        jogoDaVelha = (TextView)findViewById(R.id.jogoDaVelha);
        jogoDaVelha.setText(idioma.jogoDaVelha);

    }

    public void jogar(View view) {
        Intent intent = new Intent(this, JogoActivity.class);

        startActivity(intent);
    }
}
