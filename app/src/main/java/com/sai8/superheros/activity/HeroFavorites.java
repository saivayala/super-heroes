package com.sai8.superheros.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sai8.superheros.Adapter.HeroAdapter;
import com.sai8.superheros.R;
import com.sai8.superheros.database.HeroDatabase;
import com.sai8.superheros.database.HeroViewModel;
import com.sai8.superheros.database.HeroModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroFavorites extends AppCompatActivity {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    private AdView mAdView;


    HeroViewModel viewModel;
    static List<HeroModel> heroModelList;
    Context context;


    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int scalingFactor = 200;
        int noOfColumns = (int) (dpWidth / scalingFactor);
        if (noOfColumns < 2) noOfColumns = 2;
        return noOfColumns;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_favorites);
        ButterKnife.bind(this);
        context = this;
        MainActivity.activity="favorites";
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        heroModelList=new ArrayList<>();

        viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        } else {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        }

        viewModel.getGetAllFav().observe(this, new Observer<List<HeroModel>>() {
            @Override
            public void onChanged(@Nullable List<HeroModel> heroModels) {
                    progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(new HeroAdapter(HeroFavorites.this,heroModels));

            }
        });




    }
}
