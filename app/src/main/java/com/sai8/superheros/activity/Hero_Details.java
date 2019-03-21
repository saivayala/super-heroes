package com.sai8.superheros.activity;

import android.appwidget.AppWidgetManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sai8.superheros.R;
import com.sai8.superheros.database.HeroDatabase;
import com.sai8.superheros.database.HeroModel;
import com.sai8.superheros.database.HeroViewModel;
import com.sai8.superheros.widget.SuperHeroWidget;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sai8.superheros.networkutils.Network.alert;
import static com.sai8.superheros.networkutils.Network.isConnectedToInternet;

public class Hero_Details extends AppCompatActivity {

    @BindView(R.id.detailsimageview)
    ImageView image;
    @BindView(R.id.txtname)
    TextView txtname;
    @BindView(R.id.txtStrength)
    TextView txtstrength;
    @BindView(R.id.txtSpeed)
    TextView txtspeed;
    @BindView(R.id.txtDurability)
    TextView txtdurability;
    @BindView(R.id.txtPower)
    TextView txtpower;
    @BindView(R.id.txtCombat)
    TextView txtcombat;
    @BindView(R.id.txtIntelligence)
    TextView txtintelligence;
    @BindView(R.id.txtHeight)
    TextView txtheight;
    @BindView(R.id.txtWeight)
    TextView txtweight;
    @BindView(R.id.txtPlace)
    TextView txtplace;
    @BindView((R.id.txtRealName))
    TextView txtrealname;
    @BindView((R.id.txtPublisher))
    TextView txtpublisher;
    @BindView(R.id.txtAppearence)
    TextView txtappearence;
    @BindView(R.id.favbutton)
    MaterialFavoriteButton materialFavoriteButton;

    private AdView mAdView;
    public static final String name = "superhero";
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    HeroViewModel viewModel;
    HeroDatabase heroDatabase;
    public String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        final String[] data=intent.getStringArrayExtra("data");
        setTitle(data[1]);
        setContentView(R.layout.activity_hero__details);
        ButterKnife.bind(this);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        viewModel= ViewModelProviders.of(this).get(HeroViewModel.class);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        test=viewModel.readid(data[0]);
        if(!isConnectedToInternet(Hero_Details.this) && test==null){
            alert(Hero_Details.this);
        }
        else {


                Picasso.with(this).load(data[13]).placeholder(R.drawable.ic_launcher_foreground).error(android.R.drawable.stat_notify_error).into(image);


                if (test != null) {
                    materialFavoriteButton.setFavorite(true, true);
                } else {
                    materialFavoriteButton.setFavorite(false, true);
                }

                txtname.setText(data[1]);
                if (data[7].matches("null")) {
                    txtcombat.setText(R.string.no_data);

                } else {
                    txtcombat.setText(data[7]);
                }
                if (data[5].matches("null")) {
                    txtdurability.setText(R.string.no_data);

                } else {
                    txtdurability.setText(data[5]);
                }
                if (data[2].matches("null")) {
                    txtintelligence.setText(R.string.no_data);

                } else {
                    txtintelligence.setText(data[2]);
                }
                if (data[6].matches("null")) {
                    txtpower.setText(R.string.no_data);

                } else {
                    txtpower.setText(data[6]);
                }
                if (data[4].matches("null")) {
                    txtspeed.setText(R.string.no_data);

                } else {
                    txtspeed.setText(data[4]);
                }
                if (data[3].matches("null")) {
                    txtstrength.setText(R.string.no_data);

                } else {
                    txtstrength.setText(data[3]);
                }
                if (data[11].matches("null")) {
                    txtheight.setText(R.string.no_data);

                } else {
                    txtheight.setText(data[11]);
                }
                if (data[12].matches("null")) {
                    txtweight.setText(R.string.no_data);

                } else {
                    txtweight.setText(data[12]);
                }
                if (data[9].matches("null")) {
                    txtplace.setText(R.string.no_data);
                } else {
                    txtplace.setText(data[9]);
                }
                if (data[9].matches("null")) {
                    txtrealname.setText(R.string.no_data);
                } else {
                    txtrealname.setText(data[8]);
                }
                if (data[10].matches("null")) {
                    txtpublisher.setText(R.string.no_data);
                } else {
                    txtpublisher.setText(data[10]);
                }
                txtappearence.setText(data[14]);
            }




        materialFavoriteButton.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
            @Override
            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                HeroModel heroModel=new HeroModel();
                if(favorite){
                    try{
                        heroModel.setId(data[0]);
                        heroModel.setName(data[1]);
                        heroModel.setIntelligence(data[2]);
                        heroModel.setStrength(data[3]);
                        heroModel.setSpeed(data[4]);
                        heroModel.setDurability(data[5]);
                        heroModel.setPower(data[6]);
                        heroModel.setCombat(data[7]);
                        heroModel.setRealname(data[8]);
                        heroModel.setPlace(data[9]);
                        heroModel.setPublisher(data[10]);
                        heroModel.setHeight(data[11]);
                        heroModel.setWeight(data[12]);
                        heroModel.setImageurl(data[13]);
                        heroModel.setFirstappear(data[14]);
                        viewModel.addfav(heroModel);
                        Toast.makeText(Hero_Details.this, R.string.added_fav, Toast.LENGTH_SHORT).show();


                    } catch (SQLiteConstraintException e) {

                        Toast.makeText(Hero_Details.this, R.string.already_fav, Toast.LENGTH_SHORT).show();

                    }


                }
                else {
                    heroModel.setId(data[0]);
                    viewModel.removefav(heroModel);
                    Toast.makeText(Hero_Details.this, R.string.remove_fav, Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            if(MainActivity.activity=="main")
                NavUtils.navigateUpTo(this,new Intent(this,MainActivity.class));
            else if(MainActivity.activity=="famous")
                NavUtils.navigateUpTo(this,new Intent(this,FamousHeros.class));
            else if(MainActivity.activity=="favorites")
                NavUtils.navigateUpTo(this,new Intent(this,HeroFavorites.class));
            else if(MainActivity.activity=="search")
                NavUtils.navigateUpTo(this,new Intent(this,HeroSearch.class));
        }
        if(id==R.id.addwidget){
            sp = getSharedPreferences(name, MODE_PRIVATE);
            editor = sp.edit();
            editor.putString("name",txtname.getText().toString());
            editor.putString("realname",txtrealname.getText().toString());
            editor.putString("publisher",txtpublisher.getText().toString());
            editor.putString("firstappearence",txtappearence.getText().toString());
            if(test!=null){
                editor.putString("favorites",getString(R.string.widget_add_fav));
            }
            else{
                editor.putString("favorites",getString(R.string.widget_not_fav));
            }
            editor.apply();
            Toast.makeText(this, R.string.widget_add, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Hero_Details.this, SuperHeroWidget.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

            int[] ids = AppWidgetManager.getInstance(Hero_Details.this).getAppWidgetIds(new ComponentName(getApplication(), SuperHeroWidget.class));

            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
            sendBroadcast(intent);
        }

        return super.onOptionsItemSelected(item);

    }
}
