package com.sai8.superheros.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class HeroViewModel extends AndroidViewModel {
    public HeroRepository heroRepository;
    public LiveData<List<HeroModel>> getAllFav;
    public String heroid;

    public HeroViewModel(@NonNull Application application) {
        super(application);
        heroRepository=new HeroRepository(application);
        getAllFav=heroRepository.getallHeros();
    }

    public void addfav(HeroModel heroModel){
        heroRepository.addFav(heroModel);
    }
    public LiveData<List<HeroModel>> getGetAllFav(){ return getAllFav;}
    public String readid(String id){

        heroid=heroRepository.readid(id);
        return  heroid;
    }
    public void removefav(HeroModel heroModel){
        heroRepository.removefav(heroModel);
    }
}
