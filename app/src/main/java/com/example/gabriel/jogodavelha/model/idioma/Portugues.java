package com.example.gabriel.jogodavelha.model.idioma;

/**
 * Created by gabriel on 22/04/18.
 */

public class Portugues extends Idioma{
    public Portugues() {
        this.jogar = "jogar";
        this.empate = "Emptate";
        this.jogador = "Jogador";
        this.jogoDaVelha = "Jogo Da Velha";
        this.venceu = "Venceu";
        this.idioma = "configurações";
        this.salvo = "Salvo";
        this.portugues = "Português";
        this.ingles = "Inglês";
        this.escolhaIdioma = "Escolha um idioma";
    }

    public String getCurrent() {
        return "br";
    }
}
