package com.edazh.gank3rd.db.dao;

import com.edazh.gank3rd.vo.Gank;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/12 0012
 * project : Gank3rd
 * description:
 */
@Dao
public interface GankDao {

    @Query("SELECT * FROM gank")
    LiveData<List<Gank>> loadAll();
}
