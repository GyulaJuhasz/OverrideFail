package com.gyulajuhasz.example.overridefail;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

/**
 * Switch that supports using custom fonts.
 */
public class CustomSwitch extends SwitchCompat {

    public CustomSwitch(Context context) {
        this(context, null);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.switchStyle);
    }

    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSwitch, defStyleAttr, 0);
        if (typedArray.hasValue(R.styleable.CustomSwitch_fontAssetPath)) {
            final String fontAssetPath = typedArray.getString(R.styleable.CustomSwitch_fontAssetPath);
            final Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontAssetPath);
            setTypeface(typeface);
        }

        typedArray.recycle();
    }

}
