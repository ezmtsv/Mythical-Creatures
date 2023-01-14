package ru.myth.ez_android.myth;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import java.util.List;

/**
 * Created by EZ on 24.07.2015.
 */
public class SamplesPagerAdapter extends PagerAdapter {

    List<View> pages = null;

    int i;
    static final String TAG = "myLogs_adapter";

    public SamplesPagerAdapter(List<View> pages){
        this.pages = pages;
    }

    @Override
    public Object instantiateItem(View collection, int position){
        View v = pages.get(position);
        ((ViewPager) collection).addView(v, 0);

        i = position;
        Log.d(TAG, "instal i = " + Integer.toString(i));
        if(i == 1 || i == 3) {
//        Main.textView.setText("ИМЕНА");
            Log.d(TAG, " основной экран!");

        }
/*
        Animation anim = null;
        Animation anim_back = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
        anim_back = AnimationUtils.loadAnimation(this, R.anim.rotate_back); //null;
        Main.WomenName.startAnimation(anim_back);
        Main.ManName.startAnimation(anim);
*/
        return v;
    }

    @Override
    public void destroyItem(View collection, int position, Object view){
        ((ViewPager) collection).removeView((View) view);
        Log.d(TAG, "destroy");
    }

    @Override
    public int getCount(){

//        Log.d(TAG, "count");
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view.equals(object);
    }

    @Override
    public void finishUpdate(View arg0){
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1){
    }

    @Override
    public Parcelable saveState(){
        return null;
    }

    @Override
    public void startUpdate(View arg0){
    }
 //   i = SamplesPagerAdapter.POSITION_UNCHANGED;

}