package com.example.gabriel.jogodavelha.model;

/**
 * Created by gabriel on 21/04/18.
 */

public class JogoDaVelha {
    private byte jogo[][];

    public JogoDaVelha() {
        this.jogo = new byte[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.jogo[i][j] = 0;
            }
        }
    }

    // Retorna verdadeiro se a jogada for válida e falso se a jogada for inválida
    public boolean jogada(byte jogador, int x, int y) {
        if (jogador != 1 && jogador != 2){
            return false;
        } else if (x > 2 || y > 2) {
            return false;
        } else {
            if (this.jogo[x][y] == 0) {
                this.jogo[x][y] = jogador;
                return true;
            } else {
                return false;
            }
        }
    }

    // Verifica todos os casos de vitória, e caso haja algum retorna verdadeiro, senão falso
    public boolean temVencedor() {
        if (this.jogo[0][0] == this.jogo[0][1] && this.jogo[0][1] == this.jogo[0][2]) {
            if (this.jogo[0][0] != 0) {
                return true;
            }
        }
        if (this.jogo[1][0] == this.jogo[1][1] && this.jogo[1][1] == this.jogo[1][2]){
            if (this.jogo[1][0] != 0) {
                return true;
            }
        }
        if (this.jogo[2][0] == this.jogo[2][1] && this.jogo[2][1] == this.jogo[2][2]){
            if (this.jogo[2][0] != 0) {
                return true;
            }
        }
        if (this.jogo[0][0] == this.jogo[1][0] && this.jogo[1][0] == this.jogo[2][0]){
            if (this.jogo[0][0] != 0) {
                return true;
            }
        }
        if (this.jogo[0][1] == this.jogo[1][1] && this.jogo[1][1] == this.jogo[2][1]){
            if (this.jogo[0][1] != 0) {
                return true;
            }
        }
        if (this.jogo[0][2] == this.jogo[1][2] && this.jogo[1][2] == this.jogo[2][2]){
            if (this.jogo[0][2] != 0) {
                return true;
            }
        }
        if (this.jogo[0][0] == this.jogo[1][1] && this.jogo[1][1] == this.jogo[2][2]){
            if (this.jogo[0][0] != 0) {
                return true;
            }
        }
        if (this.jogo[0][2] == this.jogo[1][1] && this.jogo[1][1] == this.jogo[2][0]){
            if (this.jogo[0][2] != 0) {
                return true;
            }
        }

        return false;

    }

    // Retorna verdadeiro em caso de empate e falso caso não haja empate
    public boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (jogo[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
