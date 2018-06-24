package com.tds171a.soboru.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tds171a.soboru.R;
import com.tds171a.soboru.models.medida.Medida;

import java.util.List;

public class MedidaAdapter extends ArrayAdapter<Medida> {

    private int resource;
    private List<Medida> medidalist;

    public MedidaAdapter(@NonNull Context context, int resource, @NonNull List<Medida> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.medidalist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View currentView, @NonNull ViewGroup parent) {

        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(resource,null,false);
        }

        Medida medida = medidalist.get(position);

        TextView edit_list_medida_id = mView.findViewById(R.id.edit_list_medida_id);
        TextView edit_list_medida_nome = mView.findViewById(R.id.edit_list_medida_nome);
        TextView edit_list_medida_Abreviacao = mView.findViewById(R.id.edit_list_medida_Abreviacao);

        if(edit_list_medida_id != null){
            edit_list_medida_id.setText(String.valueOf(medida.getId()));
        }
        if(edit_list_medida_nome != null){
            edit_list_medida_nome.setText(medida.getNome());
        }
        if(edit_list_medida_Abreviacao != null){
            edit_list_medida_Abreviacao.setText(medida.getAbreviacao());
        }
        return mView;
    }
}
