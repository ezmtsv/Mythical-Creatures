package ru.myth.ez_android.myth;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.devsmart.android.ui.HorizontalListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class MainActivity extends Activity implements View.OnClickListener {
    public  Integer main_activity_count = 0;
    boolean flag_back = false;

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdBuddiz.setPublisherKey("680ee097-7f7c-4fe0-88c3-e8cf76caf940");
        AdBuddiz.cacheAds(this);


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6360390634130380~2123250756");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6360390634130380/6843285158");
        requestNewInterstitial();

//        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6360390634130380/9506916754");
//        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
/*
        ///................. наполнение горизонтального списка
        HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
        ArrayAdapter<CharSequence> adapteralfgor = ArrayAdapter.createFromResource(
                this, R.array.alfavit, R.layout.my_list_gor);
        hListView.setAdapter(adapteralfgor);
*/
        TextView btn1 = (TextView) findViewById(R.id.button);
        TextView btn2 = (TextView) findViewById(R.id.button2);
        TextView btn3 = (TextView) findViewById(R.id.button3);
        TextView btn4 = (TextView) findViewById(R.id.button4);
        TextView btn5 = (TextView) findViewById(R.id.button5);
        TextView btn6 = (TextView) findViewById(R.id.button6);
        TextView btn7 = (TextView) findViewById(R.id.button7);
/*        /// разделы временно закрыты///

*/
        TextView btn8 = (TextView) findViewById(R.id.button8);
        TextView btn9 = (TextView) findViewById(R.id.button9);

        TextView btn10 = (TextView) findViewById(R.id.button10);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
/*        /// разделы временно закрыты/// файлы activity_main.xml, MainActivity.java, strings.xml(изменен только списки "all_entities" и "all_entities_en")
*/
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btn10.setOnClickListener(this);
/////////////////////////////////////////
        //Задаем путь к нашим шрифтам:
        String fontPath1 = "fonts/bosanovash.ttf";
        String fontPath2 = "fonts/Park_of_Victory.ttf";
        String fontPath3 = "fonts/DS_Nova_Black.ttf";
        //Объявляем объекты типа TextView и привязываем их к наших элементам:
//        TextView textView1 = (TextView) findViewById(R.id.txt);
//        TextView textView2 = (TextView) findViewById(R.id.txt);
        //Объявляем сами шрифты:
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), fontPath1);
//        Typeface typeface2 = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), fontPath3);

        // Применяем шрифты к соответствующим текстовым элементам:
//        textView2.setTextSize(35);
//        textView2.setTypeface(typeface2);
/*
        textView1.setTypeface(typeface1);
        btn1.setTypeface(typeface1);
        btn2.setTypeface(typeface1);
        btn3.setTypeface(typeface1);
        btn4.setTypeface(typeface1);
        btn5.setTypeface(typeface1);
        btn6.setTypeface(typeface1);
        btn7.setTypeface(typeface1);
        btn8.setTypeface(typeface1);
*/
        Animation anim_scale1 = AnimationUtils.loadAnimation(this, R.anim.myscale);
        Animation anim_scale2 = AnimationUtils.loadAnimation(this, R.anim.scale2);
        Animation anim_scale3 = AnimationUtils.loadAnimation(this, R.anim.scale3);
        Animation anim_scale4 = AnimationUtils.loadAnimation(this, R.anim.scale4);
        Animation anim_scale5 = AnimationUtils.loadAnimation(this, R.anim.scale5);
        Animation anim_scale6 = AnimationUtils.loadAnimation(this, R.anim.scale6);
        Animation anim_scale7 = AnimationUtils.loadAnimation(this, R.anim.scale7);
        Animation anim_scale8 = AnimationUtils.loadAnimation(this, R.anim.scale8);

//        Animation anim_scale_back = AnimationUtils.loadAnimation(this, R.anim.scale_back);
        btn1.startAnimation(anim_scale1);
        btn2.startAnimation(anim_scale2);
        btn3.startAnimation(anim_scale3);
        btn4.startAnimation(anim_scale4);
        btn5.startAnimation(anim_scale5);
        btn6.startAnimation(anim_scale6);
        btn7.startAnimation(anim_scale7);
/*        /// разделы временно закрыты///

*/
        btn8.startAnimation(anim_scale8);
        btn9.startAnimation(anim_scale5);

        btn10.startAnimation(anim_scale7);
 //       btn1.startAnimation(anim_scale_back);
//////////////////////////////////////////
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        try {
            switch (v.getId()) {
                case R.id.button:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button1");
                    startActivity(intent);
                    break;
                case R.id.button2:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button2");
                    startActivity(intent);
                    break;
                case R.id.button3:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button3");
                    startActivity(intent);
                    break;
                case R.id.button4:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button4");
                    startActivity(intent);
                    break;
                case R.id.button5:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button5");
                    startActivity(intent);
                    break;
                case R.id.button6:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button6");
                    startActivity(intent);
                    break;

            case R.id.button7:
                intent = new Intent(this, LIST_ACT.class);
                intent.putExtra("btn", "button7");
                startActivity(intent);
                break;
/*        /// разделы временно закрыты///

*/
            case R.id.button8:
                intent = new Intent(this, LIST_ACT.class);
                intent.putExtra("btn", "button8");
                startActivity(intent);
                break;
            case R.id.button9:
                intent = new Intent(this, LIST_ACT.class);
                intent.putExtra("btn", "button9");
                startActivity(intent);
                break;

                case R.id.button10:
                    intent = new Intent(this, LIST_ACT.class);
                    intent.putExtra("btn", "button10");
                    startActivity(intent);
                    break;


            }
            flag_back = true;
 //           AdBuddiz.showAd(this);
////////////////////////////////////////////////////////////////
//            ca-app-pub-6360390634130380/6843285158
//            requestNewInterstitial();
            ///////////////////////////////////////////////////////////////////
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
///////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////
        }catch(Exception e){;}
    }

    ////////////////////////////////////////////////////////////////admob InterstitialAd object
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
    ////////////////////////////////////////////////////////////////

    @Override
    protected void onStop() {
        super.onStop();
        //       MainActivity.super.onDestroy();
        //       Log.d(TAG, "MainActivity: onStop()");
//        main_activity_count++;
//        if(main_activity_count>1) {
        if(flag_back) finish();// уничтожение активити в стеке при выходе из него
//        finish();
    }
/*
    @Override
    public void onDestroy() {
        moveTaskToBack(true);

        super.onDestroy();

        System.runFinalizersOnExit(true);
        System.exit(0);
    }
*/
    @Override
    public void onBackPressed() {
        flag_back = true;
 ////////////////////////////////////////////////
        AdBuddiz.showAd(this);
/*
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
*/
 ////////////////////////////////////////////////
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
///////////////////////////////////////////////

///////////////////////////////////////////////
//                        finish();
                    }
                 }).create().show();
    }
}
