package com.markplace.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.markplace.markplace.R;

/**
 * Created by Deybee on 17/12/2015.
 */
public class RankingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ranking, container, false);
        return root;

    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
