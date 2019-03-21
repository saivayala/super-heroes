package com.sai8.superheros.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sai8.superheros.Adapter.HeroAdapter;
import com.sai8.superheros.BuildConfig;
import com.sai8.superheros.R;
import com.sai8.superheros.database.HeroModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sai8.superheros.networkutils.Network.alert;
import static com.sai8.superheros.networkutils.Network.isConnectedToInternet;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static String activity;
    static int start = 1, end = 18;
    static int count = 0;
    static List<HeroModel> heroModelList;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.backarrow)
    ImageView prev;
    @BindView(R.id.nextarrow)
    ImageView next;
    TextView email;
    MainActivity context;
    private AdView mAdView;

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
        setContentView(R.layout.activity_main);
        context = this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupWindowAnimation();

        ButterKnife.bind(this);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        activity = "main";

        // progressBar = findViewById(R.id.progressBar);
        Sprite doublebounce = new WanderingCubes() {
        };
        progressBar.setIndeterminateDrawable(doublebounce);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int test = start - 18;
                if (test < 1) {
                    Toast.makeText(context, R.string.no_more_preview, Toast.LENGTH_SHORT).show();
                } else {
                    count = 0;
                    start = start - 18;
                    end = end - 18;
                    getDataAsync();

                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                start = start + 18;
                end = end + 18;
                getDataAsync();

            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        email = headerView.findViewById(R.id.txtemail);
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String mail = sharedPreferences.getString("usermail", "");
        email.setText(mail);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        } else {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        }
        if (savedInstanceState != null) {
            recyclerView.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            recyclerView.setAdapter(new HeroAdapter(MainActivity.this, heroModelList));
            final int[] pos = savedInstanceState.getIntArray("ScrollPosition");
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.scrollTo(pos[0], pos[1]);
                }
            });
        } else {
            heroModelList = new ArrayList<>();
            if (isConnectedToInternet(MainActivity.this)) {
                getDataAsync();
            } else {
                alert(MainActivity.this);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("ScrollPosition", new int[]{scrollView.getScrollX(), scrollView.getScrollY()});
    }

    private void setupWindowAnimation() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setExitTransition(slide);
    }

    private void getDataAsync() {

        heroModelList.clear();
        recyclerView.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        prev.setVisibility(View.GONE);
        for (int i = start; i <= end; i++) {
            String url = getString(R.string.base_url) + BuildConfig.api_key + getString(R.string.add_slash) + i;
            new HeroTask().execute(url);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {

            Intent intent = new Intent(MainActivity.this, HeroSearch.class);
            startActivity(intent);

        } else if (id == R.id.nav_famous) {
            Intent intent = new Intent(MainActivity.this, FamousHeros.class);
            startActivity(intent);

        } else if (id == R.id.nav_favorites) {
            Intent intent = new Intent(MainActivity.this, HeroFavorites.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class HeroTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                Scanner s = new Scanner(inputStream);
                s.useDelimiter("\\A");
                if (s.hasNext()) {
                    return s.next();
                } else {
                    return null;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {


                JSONObject main = new JSONObject(s);
                String response = main.optString("response");
                if (response.matches("success")) {
                    String name = main.optString("name");
                    String id = main.optString("id");
                    JSONObject powerstat = main.optJSONObject("powerstats");
                    String intellligence = powerstat.optString("intelligence");
                    String strenth = powerstat.optString("strength");
                    String speed = powerstat.optString("speed");
                    String durability = powerstat.optString("durability");
                    String power = powerstat.optString("power");
                    String combat = powerstat.optString("combat");

                    JSONObject biography = main.optJSONObject("biography");
                    String realname = biography.optString("full-name");
                    String place = biography.optString("place-of-birth");
                    String publisher = biography.optString("publisher");
                    String firstappearence = biography.optString("first-appearance");


                    JSONObject appearance = main.optJSONObject("appearance");
                    JSONArray heightarray = appearance.optJSONArray("height");
                    String height = heightarray.optString(1);

                    JSONArray weightarray = appearance.optJSONArray("weight");
                    String weight = weightarray.getString(1);

                    JSONObject image = main.optJSONObject("image");
                    String imageurl = image.optString("url");

                    HeroModel heroModel = new HeroModel();
                    heroModel.setId(id);
                    heroModel.setName(name);
                    heroModel.setCombat(combat);
                    heroModel.setDurability(durability);
                    heroModel.setFirstappear(firstappearence);
                    heroModel.setHeight(height);
                    heroModel.setImageurl(imageurl);
                    heroModel.setIntelligence(intellligence);
                    heroModel.setPlace(place);
                    heroModel.setPower(power);
                    heroModel.setPublisher(publisher);
                    heroModel.setRealname(realname);
                    heroModel.setSpeed(speed);
                    heroModel.setStrength(strenth);
                    heroModel.setWeight(weight);
                    heroModelList.add(heroModel);
                    count = count + 1;


                } else {
                    Toast.makeText(MainActivity.this, R.string.no_data_available, Toast.LENGTH_SHORT).show();
                }
                if (count == 18) {
                    recyclerView.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    prev.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setAdapter(new HeroAdapter(MainActivity.this, heroModelList));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }


}

