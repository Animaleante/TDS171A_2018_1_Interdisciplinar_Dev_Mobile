package com.tds171a.soboru.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tds171a.soboru.DAO.usuario.Usuario;
import com.tds171a.soboru.R;

public class MainActivity extends Activity {

    public static Usuario usuarioLogado;
    public static TextView nomeUsuario;
    public static Button btn_Logoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (usuarioLogado == null){
            nomeUsuario = findViewById(R.id.app_Name);
            btn_Logoff  = findViewById(R.id.btn_logoff);
            nomeUsuario.setText(R.string.app_name);
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

}
