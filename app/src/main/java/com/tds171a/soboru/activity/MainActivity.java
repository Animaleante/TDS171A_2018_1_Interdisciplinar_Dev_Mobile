package com.tds171a.soboru.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tds171a.soboru.R;
import com.tds171a.soboru.models.usuario.Usuario;

public class MainActivity extends Activity {

    public static Usuario usuarioLogado;

    public static TextView nomeUsuario;
    public static Button btn_Logoff;
    public static Button btn_Login;
    public static Button btn_Fav;
    public static Button btn_main_Medidas;
    public static EditText edt_main_pesquisar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (usuarioLogado == null){
            nomeUsuario = findViewById(R.id.app_Name);
            edt_main_pesquisar = findViewById(R.id.edt_main_pesquisar);
            nomeUsuario.setText(R.string.app_name);
            btn_Fav = findViewById(R.id.btn_main_fav);
            btn_Login  = findViewById(R.id.btn_login_login);
            btn_Logoff  = findViewById(R.id.btn_main_logoff);
            btn_Logoff.setVisibility(View.GONE);
            btn_main_Medidas = findViewById(R.id.btn_main_Medidas);
        }else{
            nomeUsuario = findViewById(R.id.app_Name);
            nomeUsuario.setText(R.string.app_name + " " + usuarioLogado.getNome());
            nomeUsuario.setText(R.string.app_name);
            btn_Fav = findViewById(R.id.btn_main_fav);
            btn_Login  = findViewById(R.id.btn_login_login);
            btn_Login.setVisibility(View.GONE);
            btn_Logoff  = findViewById(R.id.btn_main_logoff);
            btn_Logoff.setVisibility(View.VISIBLE);
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
            case R.id.btn_main_receitas:
                carregarIntent(RegistroActivity.class);
                break;
            case R.id.btn_main_fav:
                carregarIntent(FavoritoActivity.class);
                break;
            case R.id.btn_main_logoff:
                efetuarLogoff();
                break;
            case R.id.btn_main_Medidas:
                carregarIntent(MedidasActivity.class);
                break;
        }
    }


    public void listaReceita(String pesquisa, int parametro){
        Intent intent = new Intent(MainActivity.this, PesquisaActivity.class);
        startActivity(intent);
       // Bundle bundle = new Bundle();
        //bundle.putString("corpoPesquisa", pesquisa);
        //bundle.putInt("tipoLista", parametro);
        //bundle.putInt("cliente", usuarioLogado.getId());
        //intent.putExtras(bundle);
    }

    public void carregarIntent(Class classe){
        Intent intent = new Intent(MainActivity.this, classe);
        startActivity(intent);
        //Bundle bundle = new Bundle();
        //bundle.putInt("cliente", usuarioLogado.getId());
        //intent.putExtras(bundle);
    }

    public void efetuarLogoff(){
        usuarioLogado = null;
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }




}
