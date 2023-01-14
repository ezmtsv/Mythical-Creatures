package ru.myth.ez_android.myth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.devsmart.android.ui.HorizontalListView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
//import com.purplebrain.adbuddiz.sdk.AdBuddiz;

import java.lang.reflect.Array;

public class LIST_ACT extends Activity  {
    String razdel, tmp_str = "";
    String name[];
    String name_en[];
    ListView lst;
    String inf_val = " "; // для хранения имени чудища
    Integer inf_razd;     // номер выбранного раздела
    public static int inf_pos_lst = 0;  // номер позиции в листе
    public static int inf_razdel; // номер выбранного раздела
    public static int pos_gorsp = 0;  // номер позиции в гор. списке
    Integer id_razd;      // ID раздела
    Integer id_chud = 0;      // ID чудища
    Integer getId_chud[];
    HorizontalListView hListView;
    static final String TAG = "myLogs";
    boolean flag_back = false;

//    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        AdBuddiz.setPublisherKey("680ee097-7f7c-4fe0-88c3-e8cf76caf940");
//        AdBuddiz.cacheAds(this);
////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6360390634130380~2123250756");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6360390634130380/6843285158");
        requestNewInterstitial();

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        */
////////////////////////////////////////////////////////////////////////////////////////////////
        setContentView(R.layout.activity_list__act);
        Intent intent = getIntent();
        lst = (ListView) findViewById(R.id.listrazd);
        TextView txt = (TextView) findViewById(R.id.textView);
        LinearLayout background_L = (LinearLayout) findViewById(R.id.second_l);
        /*
        File f = new File(getRealPathFromURI(path));
    Drawable d = Drawable.createFromPath(f.getAbsolutePath());
myalyout.setBackground(d);
         */
        razdel = intent.getStringExtra("btn");
        switch (razdel){
            case "button1":
                name = getResources().getStringArray(R.array.Drev_mif_such_list);
                name_en = getResources().getStringArray(R.array.Drev_mif_such_list_en);
                //inf_razd = "Drev_mif_such_list";
                inf_razd = 1;
//                id_razd = getResources().getIdentifier("Drev_mif_such_list", "Array", getPackageName());
//                for(int i = 0; i < name.length; i++){ getId_chud[i] = getResources().getIdentifier(getResources().getStringArray(R.array.Drev_mif_such_list)[i], "Array", getPackageName());}
                txt.setText("      Древние"+"\n"+"мифологические"+"\n"+"    существа");
//                txt.setTextColor(0xFFFFFFFF);
                background_L.setBackgroundResource(R.drawable.drevnie_mif_sush_fon);
                break;
            case "button2":
                name = getResources().getStringArray(R.array.Mif_narod_mir_list);
                name_en = getResources().getStringArray(R.array.Mif_narod_mir_list_en);
                //inf_razd ="Mif_narod_mir_list";
                inf_razd = 2;
                txt.setText("Мифология" + "\n" + "   народов" + "\n" + "     Мира"); //getResources().getText(R.string.Mif_narod_mir)
                background_L.setBackgroundResource(R.drawable.mifologiya_narodov_mira_fon);

                break;
            case "button3":
                name = getResources().getStringArray(R.array.Dragon_list);
                name_en = getResources().getStringArray(R.array.Dragon_list_en);
                //inf_razd ="Dragon_list";
                inf_razd = 3;
                txt.setText("Драконы");
                background_L.setBackgroundResource(R.drawable.dracon_fon);
                break;
            case "button4":
                name = getResources().getStringArray(R.array.Vedmi_i_demon_such_list);
                name_en = getResources().getStringArray(R.array.Vedmi_i_demon_such_list_en);
                //inf_razd ="Russ_mif_list";
                inf_razd = 4;
                txt.setText("  Ведьмы и " + "\n"+" демонические"+"\n"+ "  существа");
                background_L.setBackgroundResource(R.drawable.vedmi_i_demon_sush_fon);
                break;
            case "button5":
                name = getResources().getStringArray(R.array.Edinorog_list);
                name_en = getResources().getStringArray(R.array.Edinorog_list_en);
                //inf_razd ="Edinorog_list";
                inf_razd = 5;
                txt.setText("Единороги");
                background_L.setBackgroundResource(R.drawable.edinorogi_fon);
                break;
            case "button6":
                name = getResources().getStringArray(R.array.Oborotni_vamp_list);
                name_en = getResources().getStringArray(R.array.Oborotni_vamp_list_en);
                //inf_razd ="Oborotni_vamp_list";
                inf_razd = 6;
                txt.setText(" Оборотни"+"\n"+"и вампиры");
                background_L.setBackgroundResource(R.drawable.oborotni_i_vamp_fon);
                break;
            case "button7":
                name = getResources().getStringArray(R.array.Chudisha_sovr_mir_list);
                name_en = getResources().getStringArray(R.array.Chudisha_sovr_mir_list_en);
                //inf_razd ="Chudisha_sovr_mir_list";
                inf_razd = 7;
                txt.setText("    Чудища"+"\n"+"современного"+"\n"+"       мира");
                background_L.setBackgroundResource(R.drawable.chudish_sovrem_mir_fon);
                break;
            case "button8":
                name = getResources().getStringArray(R.array.Chudisha_mir_kino_list);
                name_en = getResources().getStringArray(R.array.Chudisha_mir_kino_list_en);
                //inf_razd ="Chudisha_mir_kino_list";
                inf_razd = 8;
                txt.setText("Чудовища"+"\n"+"    мира"+"\n"+"   кино и"+"\n"+"литературы");
                background_L.setBackgroundResource(R.drawable.chudish_mir_kino_litr_fon);
                break;
            case "button9":
                name = getResources().getStringArray(R.array.Russ_mif_list);
                name_en = getResources().getStringArray(R.array.Russ_mif_list_en);
                //inf_razd ="Russ_mif_list";
                inf_razd = 9;
                txt.setText("  Русская"+"\n"+"мифология"+"\n");
                background_L.setBackgroundResource(R.drawable.russ_mif_fon);
                break;
            case "button10":
                name = getResources().getStringArray(R.array.all_entities);
                name_en = getResources().getStringArray(R.array.all_entities_en);
                //inf_razd ="Russ_mif_list";
                inf_razd = 10;
                txt.setText("  Алфавитный "+"\n"+"      указатель"+"\n");
 //               background_L.setBackgroundResource(R.drawable.ukazatel_fon);
                background_L.setBackgroundResource(R.drawable.ukaz_1);
                break;

        }

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,
                R.layout.my_list, name);
        //       hListView.setAdapter(adap);
        lst.setAdapter(adap);
        if(inf_razdel == inf_razd){lst.setSelection(inf_pos_lst);}
        else{inf_pos_lst = 0; pos_gorsp = 0;}
//        Log.d(TAG, "nomer v spiske " + inf_pos_lst);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "
//                +id);
                inf_pos_lst = position;
                inf_val = name_en[position];
//                name[6] = getResources().getStringArray(R.array.Oborotni_vamp_list)[6];// получение названия из элемента массива строк
//                name[4] = getString(R.string.Chudisha_mir_kino); // получение названия из строки ресурсов по имени строки
//                name_en[position] = getString(id_razd);
//                id_chud = getResources().getIdentifier("Russ_mif", "string", getPackageName());
//                id_chud = getResources().getIdentifier(inf_val, "string", getPackageName());
//                tmp_str = getString(id_chud);

//                    Log.d(TAG, "nomer v spiske_KN " + inf_pos_lst);
                try {
                    start_info();
                }catch(Exception e){;}
            }
            //                intent.putExtra("btn", "button4");

        });
        final String alf[] = getResources().getStringArray(R.array.alfavit);
        if(inf_razd == 10){
            hListView = (HorizontalListView) findViewById(R.id.hlistview);

            ArrayAdapter<CharSequence> adapteralfgor = ArrayAdapter.createFromResource(
                    this, R.array.alfavit, R.layout.my_list_gor);
            hListView.setAdapter(adapteralfgor);
            hListView.setSelection(pos_gorsp);
//////////////////////////////////////////////////////////////////
            hListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    ////////////////////////// переход к нужной позиции списка  //////////////////////////
                    Integer first_eq = 0;
                    boolean flag_firsr = false;
                    for (int r = 0; r < name.length; r++) {

                        String str = name[r];        // получаем имя из массива name в переменную  str
                        Character ss = str.charAt(0); // получаем первый символ переменной str
                        if (alf[position].equals(Character.toString(ss))) {
                            //                       name[r] = "совпало!";
                            //    Log.d(TAG, "позиция " + r + " совпала");
                            //    Log.d(TAG, alf[position] + " 1 символ имени " + Character.toString(ss));
                            if (!flag_firsr) {
                                first_eq = r;
                                flag_firsr = true;
                                continue;
                            }
                        }
//                    if (alf[position].equals("Ё") && Character.toString(ss).equals("E")){ first_eq = r; }
                    }
                    lst.setSelection(first_eq);
                    pos_gorsp = position;
//                    id_chud = first_eq;
//                    Log.d(TAG, "nomer v spiske_GOR " + id_chud);
                }

            });
//////////////////////////////////////////////////////////////////
        }
//////////////////////////////////////////////////////////////////


                        //       lst.setOnClickListener(this);
                        Log.d(TAG, "Filter ON!");
    }
/*
    ////////////////////////////////////////////////////////////////admob InterstitialAd object
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
    ////////////////////////////////////////////////////////////////
*/
                    public void start_info() {
                        //       Log.d(TAG, "выбран пункт "+ tmp_str);
                        flag_back = true;
                        Intent intent_info = new Intent(this, Info.class);
                        intent_info.putExtra("info", inf_val);
                        intent_info.putExtra("info_lst", inf_pos_lst);
                        intent_info.putExtra("info_nomer_razd", inf_razd);
                        startActivity(intent_info);
                    }

                    @Override
                    public boolean onCreateOptionsMenu(Menu menu) {
                        // Inflate the menu; this adds items to the action bar if it is present.
                        getMenuInflater().inflate(R.menu.menu_list__act, menu);
                        return true;
                    }

                    @Override
                    public boolean onOptionsItemSelected(MenuItem item) {
                        // Handle action bar item clicks here. The action bar will
                        // automatically handle clicks on the Home/Up button, so long
                        // as you specify a parent activity in AndroidManifest.xml.
                        int id = item.getItemId();

                        //noinspection SimplifiableIfStatement
                        if (id == R.id.action_settings) {
                            return true;
                        }

                        return super.onOptionsItemSelected(item);
                    }

                    @Override
                    protected void onStop() {
                        super.onStop();
                        //       MainActivity.super.onDestroy();
                        Log.d(TAG, "MainActivity: onStop()"+"flag_back "+flag_back);
                        if(flag_back) finish();  // уничтожение активити в стеке при выходе из него
//                        finish();
                    }

                    @Override
                    public void onBackPressed() {               // при нажатии кнопки назад переходит на главное активити
//                        AdBuddiz.showAd(this);
                        finish();
                        Intent intent_act = new Intent(this, MainActivity.class);
//                        intent_act.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        flag_back = true;

                        startActivity(intent_act);
                    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        inf_razdel = inf_razd;
        outState.putInt("nomer_spiska", inf_pos_lst);
        outState.putInt("nomer_razdela", inf_razdel);
        outState.putInt("nomer_v_gor", pos_gorsp);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        inf_pos_lst = savedInstanceState.getInt("nomer_spiska");
        inf_razdel = savedInstanceState.getInt("nomer_razdela");
        pos_gorsp = savedInstanceState.getInt("nomer_v_gor");
    }
 }