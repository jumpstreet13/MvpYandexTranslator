package com.smedialink.abakarmagomedov.mvpyandextranslator.custom_views;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by abakarmagomedov on 11/06/17.
 */

public class StateButton extends AppCompatButton {

    private boolean state;

    public StateButton(Context context) {
        super(context);
        init();
    }

    public StateButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StateButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.setBackgroundColor(Color.parseColor("#FF0DFF00"));
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
        if(state){
            this.setBackgroundColor(Color.parseColor("#FF0DFF00"));
        }else{
            this.setBackgroundColor(Color.parseColor("#FFFF0000"));
        }
    }
}
