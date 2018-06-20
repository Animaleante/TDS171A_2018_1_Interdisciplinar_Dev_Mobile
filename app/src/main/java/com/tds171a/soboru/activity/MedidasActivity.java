package com.tds171a.soboru.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tds171a.soboru.R;
import com.tds171a.soboru.models.medida.Medida;
import com.tds171a.soboru.models.usuario.Usuario;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tds171a.soboru.R;
import com.tds171a.soboru.factory.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MedidasActivity  extends Activity{

    public static TextView mTextView, nome, abre;
    public String vaidarcerto;
    List<String> teste = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medida);
    }

    public  void gerarJSON(View v){
        mTextView = findViewById(R.id.respostaJSONtxt);
        nome = findViewById(R.id.respostaJSONtxt_nome);
        abre = findViewById(R.id.respostaJSONtxt_abre);

        String url = "http://soboruapi.azurewebsites.net/api/Medidas/1";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mTextView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("Erro");
                    }
                });
        MySingleton.getInstance(this).addToRequest(stringRequest);
    }
    public  void gerarJSONFormatado(View v){
            mTextView = findViewById(R.id.respostaJSONtxt);
            nome = findViewById(R.id.respostaJSONtxt_nome);
            abre = findViewById(R.id.respostaJSONtxt_abre);

            String url = "http://soboruapi.azurewebsites.net/api/Medidas/1";

            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray = response.names();
                                for (int i = 0; i < jsonArray.length(); i++){

                                    teste.add((String)jsonArray.getString(i));
                                }
                            } catch (JSONException e) {
                                mTextView.setText("Deu erro");
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mTextView.setText("Deu erroResponse");
                    error.printStackTrace();
                }
            });
            MySingleton.getInstance(getApplicationContext()).addToRequest(objectRequest);
        if (!teste.isEmpty()){
            mTextView.setText("teste preenchido");
            for (int i=0; i<teste.size(); i++){
                vaidarcerto += vaidarcerto + " " + teste.get(i) + " /n";

            }
            mTextView.setText(vaidarcerto);
        }
        }

}
