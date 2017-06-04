package com.smedialink.abakarmagomedov.mvpyandextranslator.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goodiebag.horizontalpicker.HorizontalPicker;
import com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity.Language;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by abakarmagomedov on 04/06/17.
 */

public class MyHorizontalPicker extends LinearLayout implements View.OnTouchListener {
    private final float DENSITY;
    @DrawableRes
    private int backgroundSelector;
    @ColorRes
    private int colorSelector;
    private int textSize;
    private int selectedIndex;
    private int itemHeight;
    private int itemWidth;
    private int itemMargin;
    private List<PickerItem> items;
    OnSelectionChangeListener changeListener;

    public OnSelectionChangeListener getChangeListener() {
        return this.changeListener;
    }

    public void setChangeListener(OnSelectionChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public MyHorizontalPicker(Context context) {
        this(context, (AttributeSet)null);
    }

    public MyHorizontalPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyHorizontalPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.DENSITY = this.getContext().getResources().getDisplayMetrics().density;
        this.backgroundSelector = com.goodiebag.horizontalpicker.R.drawable.selector_background;
        this.colorSelector = com.goodiebag.horizontalpicker.R.color.selector_tv;
        this.textSize = 12;
        this.selectedIndex = -1;
        this.itemHeight = -2;
        this.itemWidth = -2;
        this.itemMargin = 20;
        this.items = new ArrayList();
        this.initAttributes(context, attrs, defStyleAttr);
        this.setGravity(17);
    }

    private void initAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        this.textSize = (int)((float)this.textSize * this.DENSITY);
        this.itemMargin = (int)((float)this.itemMargin * this.DENSITY);
        this.selectedIndex = -1;
        if(attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker, defStyleAttr, 0);
            this.backgroundSelector = array.getResourceId(com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker_backgroundSelector, this.backgroundSelector);
            this.colorSelector = array.getResourceId(com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker_textColorSelector, this.colorSelector);
            this.textSize = array.getDimensionPixelSize(com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker_textSize, this.textSize);
            this.itemHeight = array.getDimensionPixelSize(com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker_itemHeight, this.itemHeight);
            this.itemWidth = array.getDimensionPixelSize(com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker_itemWidth, this.itemWidth);
            this.itemMargin = array.getDimensionPixelSize(com.goodiebag.horizontalpicker.R.styleable.HorizontalPicker_itemMargin, this.itemMargin);
            array.recycle();
        }

    }

    private void initViews() {
        this.removeAllViews();
        this.setOrientation(HORIZONTAL);
        this.setOnTouchListener(this);
        new LayoutParams(this.itemWidth, this.itemHeight);
        Iterator var4 = this.items.iterator();

        while(var4.hasNext()) {
            PickerItem pickerItem = (PickerItem)var4.next();
            TextView textView = new TextView(this.getContext());
            textView.setGravity(17);
            textView.setText(pickerItem.getItem().getDescription());
            this.initStyle(textView);
            this.addView(textView);
        }
    }

    private void initStyle(View view) {
        LayoutParams params = new LayoutParams(this.itemWidth, this.itemHeight);
        view.setLayoutParams(params);
        view.setBackgroundResource(this.backgroundSelector);
        if(view instanceof TextView) {
            ((TextView)view).setTextSize(0, (float)this.textSize);
            ((TextView)view).setTextColor(this.getResources().getColorStateList(this.colorSelector));
        }

    }

    private void initStyles() {
        for(int i = 0; i < this.getChildCount(); ++i) {
            this.initStyle(this.getChildAt(i));
        }

    }

    public void setItems(List<PickerItem> items) {
        this.items = items;
        this.initViews();
        this.selectChild(-1);
    }

    public void setItems(List<PickerItem> items, int selectedIndex) {
        this.setItems(items);
        this.selectChild(selectedIndex);
    }

    public List<PickerItem> getItems() {
        return this.items;
    }

    private void selectChild(int index) {
        if(this.selectedIndex != index) {
            this.selectedIndex = -1;

            for(int i = 0; i < this.getChildCount(); ++i) {
                this.getChildAt(i).setSelected(i == index);
                if(i == index) {
                    this.selectedIndex = index;
                }
            }

            if(this.changeListener != null) {
                this.changeListener.onItemSelect(this, this.selectedIndex);
            }
        }

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch(motionEvent.getAction()) {
            case 0:
            case 2:
                int x = (int)motionEvent.getX();
                int y = (int)motionEvent.getY();
                Rect hitRect = new Rect();

                for(int i = 0; i < this.getChildCount(); ++i) {
                    View v = this.getChildAt(i);
                    v.getHitRect(hitRect);
                    if(hitRect.contains(x, y)) {
                        this.selectChild(i);
                        break;
                    }
                }
            default:
                return true;
        }
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectChild(selectedIndex);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public PickerItem getSelectedItem() {
        return (PickerItem)this.items.get(this.selectedIndex);
    }

    @DrawableRes
    public int getBackgroundSelector() {
        return this.backgroundSelector;
    }

    public void setBackgroundSelector(@DrawableRes int backgroundSelector) {
        this.backgroundSelector = backgroundSelector;
        this.initStyles();
    }

    @ColorRes
    public int getColorSelector() {
        return this.colorSelector;
    }

    public void setColorSelector(@ColorRes int colorSelector) {
        this.colorSelector = colorSelector;
        this.initStyles();
    }

    public int getTextSize() {
        return this.textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        this.initStyles();
    }

    public int getItemWidth() {
        return this.itemWidth;
    }

    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
        this.initStyles();
    }

    public int getItemMargin() {
        return this.itemMargin;
    }

    public void setItemMargin(int itemMargin) {
        this.itemMargin = itemMargin;
        this.initStyles();
    }

    public int getItemHeight() {
        return this.itemHeight;
    }

    public void setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
        this.initStyles();
    }

    public interface OnSelectionChangeListener {
        void onItemSelect(MyHorizontalPicker var1, int var2);
    }


    public static class LanguageItem implements PickerItem{

        private Language language;

        public LanguageItem(Language language) {
            this.language = language;
        }

        @Override
        public Language getItem() {
            return this.language;
        }
    }

    public interface PickerItem {
        Language getItem();   // TODO: 04/06/17 Make this with generic
    }
}
