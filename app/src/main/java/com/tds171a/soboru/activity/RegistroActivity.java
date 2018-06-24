package com.tds171a.soboru.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.tds171a.soboru.R;
import com.tds171a.soboru.factory.MySingleton;
import com.tds171a.soboru.models.usuario.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroActivity extends Activity{

    private EditText    email;
    private EditText    senha;
    private EditText    confirmSenha;
    private EditText    nome;
    private EditText    nasc;
    private RadioButton masc;
    private RadioButton fem;
    private CheckBox    notificacao_email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        email             = findViewById(R.id.edit_registro_login);
        senha             = findViewById(R.id.edit_registro_senha);
        confirmSenha      = findViewById(R.id.edit_registro_confirm_senha);
        nome              = findViewById(R.id.edit_registro_nome);
        nasc              = findViewById(R.id.edit_registro_nasc);
        masc              = findViewById(R.id.rd_registro_masc);
        fem               = findViewById(R.id.rd_registro_fem);
        notificacao_email = findViewById(R.id.cb_registro_notificacao_email);

    }

    public void registrarUsuario() throws ParseException {
        if (senha == confirmSenha){
            int sexo;
            if(masc.isChecked()){
                sexo = 1;
            }else
                sexo = 0;

            boolean notificacaoEmail = true;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = date = format.parse(nasc.getText().toString());
            Usuario usuario = new
                Usuario(nome.getText().toString(), email.getText().toString(),
                    senha.getText().toString(),new Date(),
                     sexo, true );

            final String jsonSend = "{'Email': '" +  this.email + " ','Nasc': '" + this.nasc + "','Sexo': '" + sexo + "','NotificacaoEmail': ' " + notificacaoEmail + "', 'RoleId': '" + 1 + "', 'Nome': '" + this.nome + "','Senha' : '" + this.senha +"'}";


            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://soboruapi.azurewebsites.net/api/usuarios", new Response.Listener<String>() {
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
                        return jsonSend == null ? null : jsonSend.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", jsonSend, "utf-8");
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
}
