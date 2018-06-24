package com.tds171a.soboru.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MedidasActivity  extends Activity{

    public static TextView respostaJSONtxt, txt_id_medida, txt_nome_medida, txt_abre_medida;
    public static EditText edit_id, edit_nome, edit_abre;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medida);
        txt_id_medida = findViewById(R.id.txt_id_medida);
        txt_nome_medida = findViewById(R.id.txt_nome_medida);
        txt_abre_medida = findViewById(R.id.txt_abre_medida);


    }

    /*public  void gerarJSON(View v){

        respostaJSONtxt = findViewById(R.id.respostaJSONtxt);
        edit_id = findViewById(R.id.edit_id);

        String url = "http://soboruapi.azurewebsites.net/api/Medidas/" + edit_id.getText();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        respostaJSONtxt.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        respostaJSONtxt.setText("Erro");
                    }
                });
        MySingleton.getInstance(this).addToRequest(stringRequest);
    }*/

    public  void gerarJSON(View v){
        Gson gson = new Gson();
        String resposta = "{\"Id\": 1,\"nome\": \"sample string 2\",\"abreviacao\": \"sample string 3\"}";
        Medida medida = gson.fromJson(resposta, Medida.class);
        txt_id_medida.setText(medida.getId());
        txt_nome_medida.setText(medida.getNome());
        txt_abre_medida.setText(medida.getAbreviacao());
    }



    public void inserirMedida(View v){

        String url = "http://soboruapi.azurewebsites.net/api/Medidas/";
        respostaJSONtxt = findViewById(R.id.respostaJSONtxt);
        edit_nome = findViewById(R.id.edit_nome);
        edit_abre = findViewById(R.id.edit_abre);


        final String stringBody = "{  \"Nome\": \" " + edit_nome.getText() +"\",  \"Abreviacao\": \""+ edit_abre.getText() +"\",  \"CreatedAt\": \"2018-06-20\",  \"UpdatedAt\": \"2018-06-20\" }";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return stringBody == null ? null : stringBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", stringBody, "utf-8");
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String responseString = "";
                if (response != null) {
                    responseString = String.valueOf(response.statusCode);
                    // can get more details such as response.headers
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        MySingleton.getInstance(this).addToRequest(stringRequest);

    }
}

