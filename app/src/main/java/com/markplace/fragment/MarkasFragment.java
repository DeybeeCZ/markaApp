package com.markplace.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.markplace.adapter.ListaAdapter;
import com.markplace.markplace.R;
import com.markplace.model.Marka;

import java.util.ArrayList;

/**
 * Created by Deybee on 17/12/2015.
 */
public class MarkasFragment extends Fragment {

    private ListView lvLista;
    private ListaAdapter adapter;
    private ArrayList<Marka> lista = new ArrayList<Marka>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_markas, container, false);
        lvLista = (ListView)root.findViewById(R.id.fmarkas_lv_marka);
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.conejo));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.conejo));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.tortuga));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.conejo));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.tortuga));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.userdefault));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.userdefault));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.userdefault));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.userdefault));
        lista.add(new Marka("XRuppGLm7Q","09:00","10 de Diciembre de 2015",R.drawable.userdefault));

        //Inicializamos nuestro adapter
        adapter = new ListaAdapter(getActivity(), lista);
        //Cambiamos el adapter de nuestra lista
        lvLista.setAdapter(adapter);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
