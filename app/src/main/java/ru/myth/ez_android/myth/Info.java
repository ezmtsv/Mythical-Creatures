package ru.myth.ez_android.myth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

//import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class Info extends AppCompatActivity {
    Integer count = 1;
    static final String TAG = "myLogs";
    String txt_cntr;
    String nmm[];
    String chudishe = "chude";
    Integer pos;
    Integer nomer_razd;
    Integer id_txt;
    Integer id_img;
    Boolean start_activ = false;
    String butt;
    boolean flag_back = false;

    Timer timer;
    TimerTask mTimerTask;
    final String saved_show_help = "show_help";
    SharedPreferences sPref;

    int wight;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
//        AdBuddiz.setPublisherKey("680ee097-7f7c-4fe0-88c3-e8cf76caf940");
//        AdBuddiz.cacheAds(this);
/*
        String appKey = "b5e4660f63064aeec4d1aaef3d62dd27d70ed972f70f551a";
        try {
            Appodeal.initialize(this, appKey, Appodeal.BANNER);
        }
        catch(Exception e){;}
*/
//       MobileAds.initialize(getApplicationContext(), "ca-app-pub-6360390634130380/9506916754");
//        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        Appodeal.show(this, adTypes);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6360390634130380~2123250756");  // mif - ca-app-pub-6360390634130380~2123250756, free-ca-app-pub-3940256099942544~3347511713
/////////////////////////////////////////////////////////////////////////////
        Intent intent_info = getIntent();
        chudishe = intent_info.getStringExtra("info");
        nomer_razd = intent_info.getIntExtra("info_nomer_razd",0);
        pos = intent_info.getIntExtra("info_lst", 0);
//        Log.d(TAG, "info_razd  = "+ chudishe +"  pos = "+ pos);
        screen_size();     // вычисляем параметры дисплея устройства
        timer = new Timer();
        mTimerTask = new MyTimerTask();
        if(!return_data()){try{timer.schedule(mTimerTask, 2000);}catch(Exception c){;} } // одноразовый запуск таймера через 2сек
////////////////////////////////////////////////////////

        switch(nomer_razd){
            case 1:
                nmm = getResources().getStringArray(R.array.Drev_mif_such_list);
                butt = "button1";
                break;
            case 2:
                nmm = getResources().getStringArray(R.array.Mif_narod_mir_list);
                butt = "button2";
                break;
            case 3:
                nmm =  getResources().getStringArray(R.array.Dragon_list);
                butt = "button3";
                break;
            case 4:
                nmm =  getResources().getStringArray(R.array.Vedmi_i_demon_such_list);
                butt = "button4";
                break;
            case 5:
                nmm =  getResources().getStringArray(R.array.Edinorog_list);
                butt = "button5";
                break;
            case 6:
                nmm =  getResources().getStringArray(R.array.Oborotni_vamp_list);
                butt = "button6";
                break;
            case 7:
                nmm =  getResources().getStringArray(R.array.Chudisha_sovr_mir_list);
                butt = "button7";
                break;
            case 8:
                nmm =  getResources().getStringArray(R.array.Chudisha_mir_kino_list);
                butt = "button8";
                break;
            case 9:
                nmm =  getResources().getStringArray(R.array.Russ_mif_list);
                butt = "button9";
                break;
            case 10:
                nmm =  getResources().getStringArray(R.array.all_entities);
                butt = "button10";
                break;
        }

////////////////////////////////////////////////////////
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<View>();
/////////////////////////////////////////////////////////

        // вывод левой страницы
        //////////////////////////////////////////////////////
        //////////////////////////////////////////////////////
        View page = inflater.inflate(R.layout.info_l, null);
        final ImageView image_l = (ImageView) page.findViewById(R.id.imageView);
        final TextView text_left = (TextView) page.findViewById(R.id.txt_left);
        final TextView text_left_ = (TextView) page.findViewById(R.id.txt_left_);
        try {

            final AdView mAdView = (AdView) page.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        } catch(Exception e){;}
        /////////////////////////////
        try {
            id_img = getResources().getIdentifier(chudishe + "1", "drawable", getPackageName()); // Получение имени ресурса изображения в виде "R.drawable.n_garpiya"
//            image_l.setImageResource(id_img);

            image_l.setImageBitmap(decodeSampledBitmapFromResource(getResources(), id_img, wight, height));

            // Вывод изображения по полученному имени
            id_txt = getResources().getIdentifier(chudishe + "_t_" + "left1", "string", getPackageName());//получение ID текста по выбранному чудищу
            txt_cntr = getString(id_txt); // сохранение текста по выбранному чудищу в txt_cntr
            text_left.setText(txt_cntr);

            id_txt = getResources().getIdentifier(chudishe + "_t_" + "left2", "string", getPackageName());//получение ID текста по выбранному чудищу
            txt_cntr = getString(id_txt); // сохранение текста по выбранному чудищу в txt_cntr
            text_left_.setText(txt_cntr);
 /*
            ////////////////реклама AdMob
            final AdView mAdView = (AdView) findViewById(R.id.adView);
            final AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
 */
            /////////////////////////////////
        }
        catch(Exception e){;}
        pages.add(page);

        // вывод центральной страницы
        //////////////////////////////////////////////////////
        //////////////////////////////////////////////////////
        page = inflater.inflate(R.layout.info_c, null);
        final ImageView image_centr = (ImageView) page.findViewById(R.id.image_center);
        final TextView text_center = (TextView) page.findViewById(R.id.text_center);
        final TextView text_center_down = (TextView)page.findViewById(R.id.text_center_down);
        ////////////////реклама AdMob
        try {

            final AdView mAdView = (AdView) page.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        } catch(Exception e){;}
        /////////////////////////////
        try {
            id_img = getResources().getIdentifier(chudishe, "drawable", getPackageName()); // Получение имени ресурса изображения в виде "R.drawable.n_garpiya"
//            image_centr.setImageResource(id_img);

            bitmap_size(id_img);
            image_centr.setImageBitmap(decodeSampledBitmapFromResource(getResources(), id_img, wight, height));


    //       image_centr.setImageResource(R.drawable.n_garpiya);

//        text_center.setText("Гарпия");
//////////////////////////////////////////////////
            final String fontPath1 = "fonts/Park_of_Victory.ttf";
            Typeface typeface1 = Typeface.createFromAsset(getAssets(), fontPath1);
            text_center.setTextSize(50);
            text_center.setTypeface(typeface1);
///////////////////////////////////////////////////
            text_center.setText(nmm[pos]);
//        txt_cntr = getResources().getString(R.string.n_garpiya_t);
            id_txt = getResources().getIdentifier(chudishe + "_t", "string", getPackageName());//получение ID текста по выбранному чудищу
            txt_cntr = getString(id_txt); // сохранение текста по выбранному чудищу в txt_cntr

            text_center_down.setText(txt_cntr);
/*
            ////////////////реклама AdMob
            final AdView mAdView = (AdView) findViewById(R.id.adView);
            final AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            /////////////////////////////
*/
        }
        catch(Exception e){;}
        pages.add(page);

        // вывод правой страницы
        //////////////////////////////////////////////////////
        //////////////////////////////////////////////////////
        page = inflater.inflate(R.layout.info_r, null);
//////////////////////////////////////////////////////

        final TextView txt1 = (TextView) page.findViewById(R.id.main_screen);
        final TextView txt2 = (TextView) page.findViewById(R.id.select_razd);
//        final TextView txt3 = (TextView) page.findViewById(R.id.buy_full);        //закрыто до появления полной версии
        final TextView txt4 = (TextView) page.findViewById(R.id.value_mif);
        final TextView txt5 = (TextView) page.findViewById(R.id.review_mif);
        final TextView txt7 = (TextView) page.findViewById(R.id.help_mif);
        final TextView txt6 = (TextView) page.findViewById(R.id.about_mif);
        /*///////////////реклама AdMob
        try {

            final AdView mAdView = (AdView) page.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        } catch(Exception e){;}
        ////////////////////////////*/
/*
        final String fontPath2 = "fonts/Park_of_Victory.ttf";
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), fontPath2);
        txt1.setTextSize(40);
        txt1.setTypeface(typeface2);
        txt2.setTextSize(40);
        txt2.setTypeface(typeface2);
        txt3.setTextSize(40);
        txt3.setTypeface(typeface2);
        txt4.setTextSize(40);
        txt4.setTypeface(typeface2);
        txt5.setTextSize(40);
        txt5.setTypeface(typeface2);
        txt6.setTextSize(40);
        txt6.setTypeface(typeface2);
 */
        final View.OnClickListener click_menu = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()){
                    case R.id.main_screen:
                        start_activ = false;
//                        AdBuddiz.showAd(Info.this);
                        start_activ();
                        break;
                    case R.id.select_razd:
                        start_activ = true;
//                        AdBuddiz.showAd(Info.this);
                        start_activ();
                        break;
///////////////  закрыто до появления полной версии
/*
                    case R.id.buy_full:

                        break;
*/
                    case R.id.value_mif:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.myth.ez_android.myth"));
                        startActivity(intent);
                        break;
                    case R.id.help_mif:
                        showDialog(2);
                        break;

                    case R.id.review_mif:
                        String[] TO = {"evan77@ro.ru"};
                        //              String[] CC = {"evan77@bk.ru"};

                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setData(Uri.parse("mailto:"));
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_EMAIL, TO);
                        //              intent.putExtra(Intent.EXTRA_CC, CC);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Мифические Существа, отзыв");
                        intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=ru.myth.ez_android.myth");
                        try {
                            startActivity(Intent.createChooser(intent, "Отправка письма..."));
//                            finish();
                            Log.d(TAG, "Finished sending email...");
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(Info.this,
                                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.about_mif:
                        showDialog(1);
                        break;

                }
            }
        };
        txt1.setOnClickListener(click_menu);
        txt2.setOnClickListener(click_menu);
//        txt3.setOnClickListener(click_menu); //////  закрыто до появления полной версии
        txt4.setOnClickListener(click_menu);
        txt5.setOnClickListener(click_menu);
        txt7.setOnClickListener(click_menu);
        txt6.setOnClickListener(click_menu);
/*
////////////////реклама AdMob
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//////////////////////////////////////////////////////
*/
        pages.add(page);

        SamplesPagerAdapter pagerAdapter = new SamplesPagerAdapter(pages);
        ViewPager viewPager = new ViewPager(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(count); //viewPager.setCurrentItem(0);
        setContentView(viewPager);
 /*
        try {
 //           Appodeal.cache(this, Appodeal.NATIVE, 3);
            Appodeal.show(this, Appodeal.BANNER_BOTTOM);
//            Appodeal.disableNetwork(this, "cheetah");
        }catch(Exception e){;}
//        mAdView.loadAd(adRequest);
*/
    }
    public void start_activ(){
        //       Log.d(TAG, "выбран пункт "+ tmp_str);
        flag_back = true;
        try {

            if (start_activ == false) {
                Intent intent_act = new Intent(this, MainActivity.class);
                startActivity(intent_act);
            } else {
                Intent intent_act = new Intent(this, LIST_ACT.class);
                intent_act.putExtra("btn", butt);
                startActivity(intent_act);
            }
        }catch(Exception e){;}
    }

 ///////////////////////////////////////////////
///////////////////////////////////////////////   работа с битмапом
    void bitmap_size(int id_img){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), id_img, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
        Log.d(TAG,"Height "+imageHeight+" Wight "+imageWidth);
    }
    void screen_size(){             ////////////определение параметров дисплея
        double h_tmp, w_tmp;
        WindowManager w = getWindowManager();
        Display d = w.getDefaultDisplay();
        wight = d.getWidth();
        height = d.getHeight();
//    h_tmp = (double)height * 0.;
        w_tmp = (double)wight * 0.9;
        wight = (int)w_tmp;
//    height = (int)h_tmp;
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
            Log.d(TAG,"Height_new "+halfHeight+" Wight_new "+halfWidth);
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    //////////////////////////////////////////////
//////////////////////////////////////////////
//////////////////////////////////////////////
class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd:MMMM:yyyy HH:mm:ss a", Locale.getDefault());
        final String strDate = simpleDateFormat.format(calendar.getTime());

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
//                mCounterTextView.setText(strDate);
                showDialog(2);
            }
        });
    }
}
//////////////////////////////////////////////

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == 1) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            //  view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog, null);
            // устанавливаем ее, как содержимое тела диалога
            //    adb.setView(view);
            LinearLayout view1;

            view1 = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog, null);
            adb.setView(view1);

            // заголовок
//            adb.setTitle(R.string.exit);
            // сообщение
//        adb.setMessage(R.string.save_data1);

            // иконка
            //              adb.setIcon(android.R.drawable.ic_dialog_info);
            return adb.create();
        }
        if(id == 2) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            RelativeLayout view;
            view = (RelativeLayout) getLayoutInflater().inflate(R.layout.rules, null);
            // устанавливаем ее, как содержимое тела диалога
            adb.setView(view);
//            adb.setPositiveButton(R.string.no_help, my_help_ClickListener);
            // кнопка отрицательного ответа
            adb.setNegativeButton(R.string.yes_help, my_help_ClickListener);
            return adb.create();
        }
        return super.onCreateDialog(id);
//    return adb.create();
    }
    DialogInterface.OnClickListener my_help_ClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                /*
                // положительная кнопка
                case Dialog.BUTTON_POSITIVE:
                    saved_show_help(saved_show_help, 0);
                    break;
                    */
                // негаитвная кнопка
                case Dialog.BUTTON_NEGATIVE:
                    saved_show_help(saved_show_help, 1);
                    break;
            }
        }
    };
    void saved_show_help(String str, int par){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(str, par);
        ed.commit();
    }
    boolean return_data(){
        boolean bit_show = false;
        int tmp_read = 0;
        sPref = getPreferences(MODE_PRIVATE);
        tmp_read = sPref.getInt(saved_show_help, 0);
        if(tmp_read == 1){bit_show = true;}
        return bit_show;
    }
    //////////////////////////////////////////////////////
    @Override
    protected void onStop() {
        super.onStop();
        //       MainActivity.super.onDestroy();
               Log.d(TAG, "MainActivity: onStop()" + "flag_back " + flag_back);
        if(flag_back) finish();// уничтожение активити в стеке при выходе из него

//        Appodeal.setSmartBanners(false);
//        Appodeal.onResume(this, 1);
//        finish();
    }

    @Override
    public void onBackPressed() {               // при нажатии кнопки назад переходит на главное активити
//        Intent intent_act = new Intent(this, MainActivity.class);
//        startActivity(intent_act);//
//        Appodeal.setSmartBanners(false);
//        Appodeal.onResume(this, 1);
        finish();
        flag_back = true;
        Intent intent_act = new Intent(this, LIST_ACT.class);
        intent_act.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent_act.putExtra("btn", butt);
        startActivity(intent_act);
    }
}
