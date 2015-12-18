package com.markplace.markplace;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.markplace.fragment.BusquedaFragment;
import com.markplace.sliding.BaseActivity;
import com.markplace.sliding.SampleListFragment;

/**
 * Created by Deybee on 17/12/2015.
 */
public class ContentActivity extends BaseActivity {

    private Fragment mContent;
    private ImageView icoMenu;
    private TextView titulo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        if (mContent == null)
            mContent = new BusquedaFragment();

        // set the Above View
        setContentView(R.layout.activity_content);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mContent)
                .commit();

        // set the Behind View
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, new SampleListFragment())
                .commit();

        // customize the SlidingMenu
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        titulo = (TextView)findViewById(R.id.content_titulo);
        icoMenu = (ImageView)findViewById(R.id.content_iv_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        icoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        getSlidingMenu().showContent();
    }

    public void switchTitle(String title){
        titulo.setText(title);
    }
}
