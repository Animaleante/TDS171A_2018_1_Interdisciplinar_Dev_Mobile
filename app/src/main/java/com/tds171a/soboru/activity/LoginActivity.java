package com.tds171a.soboru.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.tds171a.soboru.models.usuario.UsuarioDAO;
import com.tds171a.soboru.R;
import com.tds171a.soboru.util.Util;

public class LoginActivity extends Activity {

    private EditText editEmail;
    private EditText editSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = findViewById(R.id.edit_login_email);
        editSenha = findViewById(R.id.edit_login_senha);
        Stetho.initializeWithDefaults(this);
    }

    public void logarUsuario(View v){
        String login = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        UsuarioDAO usuarioDAO = new UsuarioDAO(this);
        long idUsuario = usuarioDAO.validaUsuario(login, Util.toMD5(senha));
        if (idUsuario > 0){
            Toast.makeText(this,"Usuário Logado!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("ID_USUARIO", idUsuario);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,"Usuário não cadastrado!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastrarUsuário(View v){
        Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

}
