package com.tds171a.soboru.factory;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tds171a.soboru.models.usuario.Usuario;

import java.io.UnsupportedEncodingException;

public class APIFactory  {

    private final String URL = "https://pokeapi.co/api/v2/";
    //Construtor onde ficaria tudo generico
    public APIFactory(final Context context, int method, String subUrl, Usuario usuario) {

        try{
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        Gson gson = new Gson();
        final String stringJSON = gson.toJson(usuario);

        //Inicio a chamada pra API
        StringRequest stringRequest = new StringRequest(
                method,
                URL + subUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                        Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            public byte[] getBody() throws AuthFailureError {

                try {
                    return stringJSON == null ? null : stringJSON.getBytes("utf-8");
                }catch (UnsupportedEncodingException uee){
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of \"" + stringJSON + "\" using utf-8.");
                    return null;
                }
            }
        };

        requestQueue.add(stringRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
