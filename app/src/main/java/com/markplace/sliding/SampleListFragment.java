package com.markplace.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.markplace.fragment.BusquedaFragment;
import com.markplace.fragment.ConfigFragment;
import com.markplace.fragment.EmpresasFragment;
import com.markplace.fragment.MarkasFragment;
import com.markplace.fragment.RankingFragment;
import com.markplace.markplace.ContentActivity;
import com.markplace.markplace.R;

/**
 * Created by Deybee on 17/12/2015.
 */
public class SampleListFragment extends ListFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sliding_menu, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        //for (int i = 0; i < 20; i++) {
        adapter.add(new SampleItem("Mis Markas", android.R.drawable.ic_menu_agenda));
        adapter.add(new SampleItem("Ranking de usuarios", android.R.drawable.ic_menu_today));
        adapter.add(new SampleItem("Mis Empresas", android.R.drawable.ic_menu_myplaces));
        adapter.add(new SampleItem("Configuracion", android.R.drawable.ic_menu_preferences));
        //}
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Fragment fragment = null;
        String titulo = "Busca tu empresa o equipo";
        switch (position) {
            case 0:
                fragment = new MarkasFragment();
                titulo = "Tus últimas marcaciones";
                break;
            case 1:
                fragment = new RankingFragment();
                titulo = "Ranking mensual";
                break;
            case 2:
                fragment = new EmpresasFragment();
                titulo = "Tus empresas registradas";
                break;
            case 3:
                fragment = new ConfigFragment();
                titulo = "Configuración";
                break;
        }
        if (fragment != null) {
            switchFragment(fragment);
        }
        switchTitle(titulo);
    }

    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof ContentActivity) {
            ContentActivity fca = (ContentActivity) getActivity();
            fca.switchContent(fragment);
        }
    }

    private void switchTitle(String title){
        if (getActivity() == null)
            return;

        if (getActivity() instanceof ContentActivity) {
            ContentActivity fca = (ContentActivity) getActivity();
            fca.switchTitle(title);
        }
    }

    private class SampleItem {
        public String tag;
        public int iconRes;

        public SampleItem(String tag, int iconRes) {
            this.tag = tag;
            this.iconRes = iconRes;
        }
    }

    public class SampleAdapter extends ArrayAdapter<SampleItem> {

        public SampleAdapter(Context context) {
            super(context, 0);
        }

        class ViewHolder {
            ImageView icon;
            TextView title;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_sliding_menu, null);

                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.row_icon);
                viewHolder.title = (TextView) convertView.findViewById(R.id.row_title);
                convertView.setTag(viewHolder);
            }

            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.icon.setImageResource(getItem(position).iconRes);
            viewHolder.title.setText(getItem(position).tag);

            return convertView;
        }
    }
}