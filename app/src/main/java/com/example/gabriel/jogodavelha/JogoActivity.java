package com.example.gabriel.jogodavelha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabriel.jogodavelha.model.JogoDaVelha;
import com.example.gabriel.jogodavelha.model.idioma.Idioma;
import com.example.gabriel.jogodavelha.model.idioma.Ingles;
import com.example.gabriel.jogodavelha.model.idioma.Portugues;

public class JogoActivity extends AppCompatActivity {
    JogoDaVelha jogo;
    TextView mensagem;
    byte jogador;
    Idioma idioma;
    SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        if (preferencias.getString("idioma", "pt").equals("pt")) {
            idioma = new Portugues();
        } else {
            idioma = new Ingles();
        }

        jogador = 1;
        jogo = new JogoDaVelha();
        mensagem = (TextView)findViewById(R.id.mensagem);

        mensagem.setText(idioma.jogador + " " + jogador);

    }

    public void jogada(View view) {
        boolean jogadaValida;
        // Verifica o espaço escolhido verifica se a jogada é válida
        switch (view.getId()) {
            case R.id.a1:
                jogadaValida = jogo.jogada(jogador, 0, 0);
                break;
            case R.id.a2:
                jogadaValida = jogo.jogada(jogador, 0, 1);
                break;
            case R.id.a3:
                jogadaValida = jogo.jogada(jogador, 0, 2);
                break;
            case R.id.b1:
                jogadaValida = jogo.jogada(jogador, 1, 0);
                break;
            case R.id.b2:
                jogadaValida = jogo.jogada(jogador, 1, 1);
                break;
            case R.id.b3:
                jogadaValida = jogo.jogada(jogador, 1, 2);
                break;
            case R.id.c1:
                jogadaValida = jogo.jogada(jogador, 2, 0);
                break;
            case R.id.c2:
                jogadaValida = jogo.jogada(jogador, 2, 1);
                break;
            case R.id.c3:
                jogadaValida = jogo.jogada(jogador, 2, 2);
                break;
            default:
                jogadaValida = false;
                break;
        }

        // Informa se o jogo cheogu ao final ou se passou para o outro jogador
        if (jogadaValida) {
            Button button = (Button)findViewById(view.getId());
            button.setText(jogador == 1 ? "X" : "0");
            if (jogo.temVencedor()) {
                Intent intent = new Intent(this, FimActivity.class);
                intent.putExtra("mensagem", idioma.jogador + " " + jogador + " " + idioma.venceu);
                intent.putExtra("voltar", idioma.voltar);
                startActivity(intent);
            } else if (jogo.empate()) {
                Intent intent = new Intent(this, FimActivity.class);
                intent.putExtra("mensagem", idioma.empate);
                intent.putExtra("voltar", idioma.voltar);
                startActivity(intent);
            } else {
                if (jogador == 1) {
                    jogador = 2;
                } else {
                    jogador = 1;
                }
                mensagem.setText(idioma.jogador + " " + jogador);
            }
        }
    }
}
