package com.example.gabriel.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FimActivity extends AppCompatActivity {
    TextView mensagem;
    Button voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);

        Bundle extras = getIntent().getExtras();

        mensagem = (TextView)findViewById(R.id.mensagem);
        mensagem.setText(extras.getString("mensagem"));

        voltar = (Button)findViewById(R.id.voltar);
        voltar.setText(extras.getString("voltar"));
    }

    public void voltar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
