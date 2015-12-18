package com.markplace.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.markplace.markplace.R;
import com.markplace.model.Marka;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Deybee on 18/12/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Marka> lista;

    public ListaAdapter(Context context, ArrayList<Marka> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        TextView lblFecha,lblEntrada,lblSalida;
        CircleImageView icono;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_markas, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblFecha = (TextView) convertView.findViewById(R.id.item_marka_fecha);
            viewHolder.lblEntrada = (TextView) convertView.findViewById(R.id.item_marka_entrada);
            viewHolder.lblSalida = (TextView) convertView.findViewById(R.id.item_marka_salida);
            viewHolder.icono = (CircleImageView) convertView.findViewById(R.id.item_marka_image);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Marka item = (Marka) getItem(position);

        viewHolder.lblFecha.setText(item.getFecha());
        viewHolder.lblEntrada.setText(item.getEntrada());
        viewHolder.lblSalida.setText(item.getSalida());
        //viewHolder.icono.setBackgroundResource(item.getIcono());
        viewHolder.icono.setImageResource(item.getIcono());


        return convertView;
    }
}
