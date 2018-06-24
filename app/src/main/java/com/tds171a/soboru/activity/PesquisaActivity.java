package com.tds171a.soboru.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tds171a.soboru.R;
import com.tds171a.soboru.adapter.ReceitaAdapter;
import com.tds171a.soboru.factory.MySingleton;

import org.json.JSONObject;

public class PesquisaActivity extends Activity {

    private EditText edit_id;
    private TextView respostaJSONtxt;
    private Button btnPesquisar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        btnPesquisar = findViewById(R.id.btnPesquisarid);
        respostaJSONtxt = findViewById(R.id.respostaJSONtxtlista);
        edit_id = findViewById(R.id.edit_id_receita);
    }

    public void pesquiarPorID(View v){

        try {
            String url;
            if(edit_id.getText().length() <= 0){
                url = "http://soboruapi.azurewebsites.net/api/Receitas/";
            }else{
                url = "http://soboruapi.azurewebsites.net/api/Receitas/" + edit_id.getText().toString();
        }

            respostaJSONtxt.setText(edit_id.getText().toString());
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
