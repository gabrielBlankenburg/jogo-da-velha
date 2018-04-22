package com.example.gabriel.jogodavelha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriel.jogodavelha.model.idioma.Idioma;
import com.example.gabriel.jogodavelha.model.idioma.Ingles;
import com.example.gabriel.jogodavelha.model.idioma.Portugues;

import org.w3c.dom.Text;

public class ConfigActivity extends AppCompatActivity {
    Button pt;
    TextView escolha;
    Button en;
    SharedPreferences preferencias;
    Idioma idioma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        if (preferencias.getString("idioma", "pt").equals("pt")) {
            idioma = new Portugues();
        } else {
            idioma = new Ingles();
        }

        pt = (Button)findViewById(R.id.pt);
        pt.setText(idioma.portugues);

        en = (Button)findViewById(R.id.en);
        en.setText(idioma.ingles);

        escolha = (TextView) findViewById(R.id.escolhaIdioma);
        escolha.setText(idioma.escolhaIdioma);



    }

    public void escolheIdioma(View view) {
        SharedPreferences.Editor editor = preferencias.edit();
        String idiomaEscolhido;

        switch (view.getId()){
            case R.id.pt:
                idiomaEscolhido = "pt";
                break;
            case R.id.en:
                idiomaEscolhido = "en";
                break;
            default:
                idiomaEscolhido = idioma.getCurrent();
                break;
        }

        editor.putString("idioma", idiomaEscolhido);
        editor.apply();

        preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        if (preferencias.getString("idioma", "pt").equals("pt")) {
            idioma = new Portugues();
        } else {
            idioma = new Ingles();
        }

        Toast.makeText(this, idioma.salvo, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
