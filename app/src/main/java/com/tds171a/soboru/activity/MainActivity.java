package com.tds171a.soboru.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tds171a.soboru.R;
import com.tds171a.soboru.models.usuario.Usuario;

public class MainActivity extends Activity {

    public static Usuario usuarioLogado;
    public static TextView nomeUsuario;
    public static Button btn_Logoff;
    public static Button btn_Teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (usuarioLogado == null){
            nomeUsuario = findViewById(R.id.app_Name);
            btn_Logoff  = findViewById(R.id.btn_logoff);
            nomeUsuario.setText(R.string.app_name);
            btn_Teste = findViewById(R.id.btn_teste);
            //TODO: Criar regra para deixar botão logoff invisível.
        }else{
            nomeUsuario = (TextView) findViewById(R.id.app_Name);
            nomeUsuario.setText(R.string.app_name + " - " + usuarioLogado.getNome());
        }


    }

    public void carregaItemMenu(View v){
        switch (v.getId()){
            case R.id.btn_main_login:
                carregarIntent(LoginActivity.class);
                break;
            case R.id.btn_main_pesquisa:
                carregarIntent(PesquisaActivity.class);
                break;
            case R.id.btn_main_fav:
                carregarIntent(FavoritoActivity.class);
                break;
        }
    }

    public void carregarIntent(Class classe){
        Intent intent = new Intent(MainActivity.this, classe);
        startActivity(intent);
    }

    public void efetuarLogoff(View v){
        usuarioLogado = null;
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void carregarAPI(View v){

        final TextView mTextView = (TextView) findViewById(R.id.txtJSON);
        // Instantiate the RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }


}
