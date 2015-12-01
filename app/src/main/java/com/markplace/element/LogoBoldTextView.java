package com.markplace.element;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by deybee on 27/11/15.
 */
public class LogoBoldTextView extends TextView {

    public LogoBoldTextView(Context context) {
        super(context);
        setType(context);
    }

    public LogoBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public LogoBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setType(context);
    }

    private void setType(Context context){
        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/JonahRegular.otf");
        this.setTypeface(typeface,Typeface.BOLD);
    }
}
