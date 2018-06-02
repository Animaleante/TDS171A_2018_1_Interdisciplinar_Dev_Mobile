package com.tds171a.soboru.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.tds171a.soboru.models.receita.Receita;

public class ReceitaAdapter extends ArrayAdapter<Receita> {
    public ReceitaAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
