package com.markplace.element;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.markplace.markplace.R;

/**
 * Created by deybee on 27/11/15.
 */
public class LogoTextView extends TextView {

    public LogoTextView(Context context) {
        super(context);
        setType(context);
    }

    public LogoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public LogoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setType(context);
    }

    private void setType(Context context){
        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/JonahRegular.otf");
        this.setTypeface(typeface);
    }
}
