package com.example.gabriel.jogodavelha.model.idioma;

/**
 * Created by gabriel on 22/04/18.
 */

public abstract class Idioma {
    public String jogoDaVelha;
    public String jogar;
    public String jogador;
    public String venceu;
    public String empate;
    public String idioma;
    public String salvo;
    public String portugues;
    public String ingles;
    public String escolhaIdioma;

    public abstract String getCurrent();
}
