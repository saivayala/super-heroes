package com.sai8.superheros.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = HeroModel.class,version = 1,exportSchema =true )
public abstract class HeroDatabase extends RoomDatabase {

    public abstract MyDao myDao();

    public static HeroDatabase instance;
    public static HeroDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,HeroDatabase.class,"Favoriteheros")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
