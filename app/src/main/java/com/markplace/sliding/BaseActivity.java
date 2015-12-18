package com.markplace.sliding;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.markplace.markplace.R;

/**
 * Created by Deybee on 17/12/2015.
 */
public class BaseActivity extends SlidingFragmentActivity {

    protected ListFragment mFrag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBehindContentView(R.layout.menu_frame);
        if (savedInstanceState == null) {
            FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
            mFrag = new SampleListFragment();
            t.replace(R.id.menu_frame, mFrag);
            t.commit();
        } else {
            mFrag = (ListFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowDrawable(R.drawable.shadow);
        //sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setBehindWidthRes(R.dimen.slidingmenu_with_res);
        sm.setFadeDegree(0.35f);
        sm.setSlidingEnabled(false);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }
}
