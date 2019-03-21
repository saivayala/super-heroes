package com.sai8.superheros.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class HeroRepository {
    public static MyDao myDao;
    LiveData<List<HeroModel>> getallHeros;
    public static String heroid;

    public HeroRepository(Context context){

    HeroDatabase heroDatabase=HeroDatabase.getInstance(context);
    myDao=heroDatabase.myDao();
    getallHeros=myDao.readfav();
    }

    LiveData<List<HeroModel>> getallHeros(){return  getallHeros;}

    public void addFav(HeroModel heroModel ){
        new InsertTask().execute(heroModel);

    }
    public String readid(String id){
        heroid=myDao.readid(id);
        return  heroid;
    }
    public void removefav(HeroModel heroModel){
        new RemoveTask().execute(heroModel);

    }


    public class InsertTask extends AsyncTask<HeroModel,Void,Void>{

        @Override
        protected Void doInBackground(HeroModel... heroModels) {
            myDao.addfav(heroModels[0]);
            return null;
        }
    }

    public  class RemoveTask extends AsyncTask<HeroModel,Void,Void>{

        @Override
        protected Void doInBackground(HeroModel... heroModels) {
            myDao.removefav(heroModels[0]);
            return null;
        }
    }
}
