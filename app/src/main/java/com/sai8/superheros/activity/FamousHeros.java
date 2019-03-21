package com.sai8.superheros.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
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

public class FamousHeros extends AppCompatActivity {

    static List<HeroModel> heroModelList;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    Context context;
    int cout = 0;

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
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_heros);

        ButterKnife.bind(this);
        context = this;
        MainActivity.activity="famous";
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sprite doublebounce = new DoubleBounce() {
        };
        progressBar.setIndeterminateDrawable(doublebounce);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        } else {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        }

        if (savedInstanceState != null) {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            recyclerView.setAdapter(new HeroAdapter(FamousHeros.this, heroModelList));
            scrollView.post(new Runnable() {
                int[] p=savedInstanceState.getIntArray("scrollposition");
                @Override
                public void run() {
                   scrollView.scrollTo(p[0],p[1]);
                }
            });


        } else {
            heroModelList = new ArrayList<>();
            heroModelList.clear();
            for (int i = 0; i < getResources().getStringArray(R.array.famouse).length; i++) {
                String url = getString(R.string.base_url) + BuildConfig.api_key + getString(R.string.add_slash) + getResources().getStringArray(R.array.famouse)[i];
                Log.i("herourl", url);
                if(isConnectedToInternet(FamousHeros.this)) {
                    new HeroTask().execute(url);
                }
                else{
                    alert(FamousHeros.this);
                }
            }
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("scrollposition", new int[]{scrollView.getScrollX(), scrollView.getScrollY()});

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
                    cout = cout + 1;


                } else {
                    Toast.makeText(FamousHeros.this, R.string.no_data_available, Toast.LENGTH_SHORT).show();
                }
                if (cout >= context.getResources().getStringArray(R.array.famouse).length) {
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setAdapter(new HeroAdapter(FamousHeros.this, heroModelList));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

}
