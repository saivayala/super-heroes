package com.sai8.superheros.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sai8.superheros.activity.Hero_Details;
import com.sai8.superheros.R;
import com.sai8.superheros.database.HeroModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {
    Context context;
    List<HeroModel> heroModelsadapter;


    public HeroAdapter(Context context, List<HeroModel> heroModels) {
        this.context = context;
        this.heroModelsadapter = heroModels;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.rowdesign,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        Picasso.with(context).load(heroModelsadapter.get(i).getImageurl())
                .placeholder(R.drawable.ic_launcher_foreground).error(android.R.drawable.stat_notify_error)
                .into(myViewHolder.imageView);
        myViewHolder.numbers.setText(heroModelsadapter.get(i).getId());

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] herodetails=new String[15];
                herodetails[0]=heroModelsadapter.get(i).getId();
                herodetails[1]=heroModelsadapter.get(i).getName();
                herodetails[2]=heroModelsadapter.get(i).getIntelligence();
                herodetails[3]=heroModelsadapter.get(i).getStrength();
                herodetails[4]=heroModelsadapter.get(i).getSpeed();
                herodetails[5]=heroModelsadapter.get(i).getDurability();
                herodetails[6]=heroModelsadapter.get(i).getPower();
                herodetails[7]=heroModelsadapter.get(i).getCombat();
                herodetails[8]=heroModelsadapter.get(i).getRealname();
                herodetails[9]=heroModelsadapter.get(i).getPlace();
                herodetails[10]=heroModelsadapter.get(i).getPublisher();
                herodetails[11]=heroModelsadapter.get(i).getHeight();
                herodetails[12]=heroModelsadapter.get(i).getWeight();
                herodetails[13]=heroModelsadapter.get(i).getImageurl();
                herodetails[14]=heroModelsadapter.get(i).getFirstappear();

                Intent intent=new Intent(context, Hero_Details.class);
                intent.putExtra("data",herodetails);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return heroModelsadapter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.designimages)
        ImageView imageView;
        @BindView(R.id.number)
        TextView numbers;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }
    }
}
