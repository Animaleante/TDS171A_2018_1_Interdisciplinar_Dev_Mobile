package com.tds171a.soboru.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.tds171a.soboru.R;
import com.tds171a.soboru.adapter.ReceitaAdapter;

public class PesquisaActivity extends Activity {

    private ListView listaReceitas;
    private ReceitaAdapter receitaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

    }
}
