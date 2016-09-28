package com.caixa.arqdsis.usjt.caixamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class transacoes extends AppCompatActivity {
    public static final String NOME = "com.caixa.arqdsis.usjt.caixamobile.chave";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacoes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = gerarHistorico();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheClienteActivity.class);
                intent.putExtra(NOME, lista.get(position));
                startActivity(intent);
            }
        });*/
    }

    public ArrayList<String> buscaClientes(String chave){
        ArrayList<String> lista = gerarHistorico();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }
    public ArrayList<String> gerarHistorico(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Pizzaria Bonna e Bella: -R$ 29,00");
        lista.add("News Kings: -R$ 6,50");
        lista.add("Saque: -R$ 250,00");
        lista.add("Depósito: +R$ 700,00");
        lista.add("Extra: -R$ 10,00");

        return lista;
    }
}