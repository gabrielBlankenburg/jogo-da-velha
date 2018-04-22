package com.example.gabriel.jogodavelha.model.idioma;

/**
 * Created by gabriel on 22/04/18.
 */

public class Ingles extends Idioma{
    public Ingles() {
        this.jogar = "play";
        this.empate = "Draw";
        this.jogador = "Player";
        this.jogoDaVelha = "Tic Tac Toe";
        this.venceu = "Wins";
        this.idioma = "settings";
        this.salvo = "Saved";
        this.portugues = "Portuguese";
        this.ingles = "English";
        this.escolhaIdioma = "Choose a language";
    }

    public String getCurrent() {
        return "en";
    }
}
