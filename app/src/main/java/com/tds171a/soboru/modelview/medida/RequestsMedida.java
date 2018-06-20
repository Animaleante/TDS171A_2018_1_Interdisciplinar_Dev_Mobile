package com.tds171a.soboru.modelview.medida;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tds171a.soboru.R;
import com.tds171a.soboru.activity.MainActivity;
import com.tds171a.soboru.factory.MySingleton;
import com.tds171a.soboru.models.medida.Medida;

import org.json.JSONObject;

public class RequestsMedida {

    //private JSONObject = new JSONObject()
    private String responseString;
    private Context context;
    private String resposta2;
    public JSONObject jsonObject;


    public RequestsMedida(Context context) {
        this.context = context;
    }

    public String metodoGet() {

        String url = "http://soboruapi.azurewebsites.net/api/Medidas";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseString = response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseString = "Erro";
                    }
                });
        resposta2 = responseString;

        MySingleton.getInstance(context).addToRequest(stringRequest);

        if(responseString == null){
        return resposta2;
        }else
        return responseString;
    }
}