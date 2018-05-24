package com.tds171a.soboru.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.tds171a.soboru.R;

class RegistroActivity extends Activity{

    private EditText    login;
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

        login             = findViewById(R.id.edit_registro_login);
        senha             = findViewById(R.id.edit_registro_senha);
        confirmSenha      = findViewById(R.id.edit_registro_confirm_senha);
        nome              = findViewById(R.id.edit_registro_nome);
        nasc              = findViewById(R.id.edit_registro_nasc);
        masc              = findViewById(R.id.rd_registro_masc);
        fem               = findViewById(R.id.rd_registro_fem);
        notificacao_email = findViewById(R.id.cb_registro_notificacao_email);

    }
}
