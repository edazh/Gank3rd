package com.edazh.gank3rd.db;

import android.content.Context;

import com.edazh.gank3rd.db.dao.GankDao;
import com.edazh.gank3rd.util.Constant;
import com.edazh.gank3rd.vo.Gank;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/12 0012
 * project : Gank3rd
 * description:
 */
@Database(entities = {Gank.class}, version = 1, exportSchema = false)
public abstract class GankDatabase extends RoomDatabase {
    private static GankDatabase sInstance;

    public abstract GankDao gankDao();

    public static GankDatabase getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (GankDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), GankDatabase.class, Constant.Database.DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }

}
