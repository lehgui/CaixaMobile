package com.caixa.arqdsis.usjt.caixamobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    private EditText nome;
    public static final String CHAVE = "com.caixa.arqdsis.usjt.caixamobile.chave";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void buscarHistorico(View view){
        Intent intent = new Intent(this, transacoes.class);


        startActivity(intent);
    }
}