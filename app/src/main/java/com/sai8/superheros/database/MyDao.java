package com.sai8.superheros.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void  addfav(HeroModel heroModel);

    @Delete
    void removefav(HeroModel heroModel);

    @Query("SELECT * FROM favoriteheros")
    LiveData<List<HeroModel>> readfav();

    @Query("SELECT hero_id FROM favoriteheros WHERE hero_id= :heroid")
    String readid(String heroid);
}
