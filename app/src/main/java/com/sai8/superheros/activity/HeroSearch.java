package com.sai8.superheros.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sai8.superheros.Adapter.HeroAdapter;
import com.sai8.superheros.BuildConfig;
import com.sai8.superheros.R;
import com.sai8.superheros.database.HeroModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sai8.superheros.networkutils.Network.alert;
import static com.sai8.superheros.networkutils.Network.isConnectedToInternet;

public class HeroSearch extends AppCompatActivity {

    public static List<HeroModel> heroModelList;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.rvsearch)
    RecyclerView recyclerView;
    @BindView(R.id.etsearchkey)
    EditText searchname;
    @BindView(R.id.btnsearch)
    Button btnSearch;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    HeroSearch context;
    String url;
    RequestQueue queue;

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
        setContentView(R.layout.activity_hero_search);
        ButterKnife.bind(this);

        context = this;

        MainActivity.activity="search";
        queue = Volley.newRequestQueue(this);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        } else {
            int count = calculateNoOfColumns(context);
            recyclerView.setLayoutManager(new GridLayoutManager(this, count));
        }
        if (savedInstanceState != null) {
            if(heroModelList!=null) {
                recyclerView.setAdapter(new HeroAdapter(HeroSearch.this, heroModelList));
            }
            progressBar.setVisibility(View.GONE);
            final int[] pos = savedInstanceState.getIntArray("ScrollPosition");
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.scrollTo(pos[0], pos[1]);
                }
            });
        }


        url = getString(R.string.base_url) + BuildConfig.api_key + getString(R.string.search_url);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String searchkey = searchname.getText().toString();
                url = url + searchkey;
                HeroSearch.heroModelList = new ArrayList<>();
                if(isConnectedToInternet(HeroSearch.this)) {
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            dataParsing(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, getString(R.string.something_wrong) + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                    queue.add(stringRequest);
                }
                else {
                    alert(HeroSearch.this);
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("ScrollPosition", new int[]{scrollView.getScrollX(), scrollView.getScrollY()});
    }

    public void dataParsing(String s) {
        progressBar.setVisibility(View.GONE);
        if (s != null) {
            try {


                JSONObject root = new JSONObject(s);
                String response = root.optString("response");
                if (response.matches("success")) {
                    JSONArray resultarray = root.optJSONArray("results");
                    for (int i = 0; i < resultarray.length(); i++) {
                        JSONObject main = resultarray.optJSONObject(i);

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
                        String weight = weightarray.optString(1);

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
                        HeroSearch.heroModelList.add(heroModel);


                    }

                    recyclerView.setAdapter(new HeroAdapter(HeroSearch.this, HeroSearch.heroModelList));
                }
                else {
                    Toast.makeText(context, R.string.try_again, Toast.LENGTH_SHORT).show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } else {
            Toast.makeText(context, R.string.try_again, Toast.LENGTH_SHORT).show();


        }

    }
}
