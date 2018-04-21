package com.example.gabriel.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabriel.jogodavelha.model.JogoDaVelha;

public class JogoActivity extends AppCompatActivity {
    JogoDaVelha jogo;
    TextView mensagem;
    byte jogador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        jogador = 1;
        jogo = new JogoDaVelha();
        mensagem = (TextView)findViewById(R.id.mensagem);

        mensagem.setText("Jogador " + jogador);

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
                mensagem.setText("O Jogador " + jogador + " venceu!");
            } else if (jogo.empate()) {
                mensagem.setText("Empate!");
            } else {
                if (jogador == 1) {
                    jogador = 2;
                } else {
                    jogador = 1;
                }
                mensagem.setText("Jogador " + jogador);
            }
        }
    }
}
