package com.edazh.gank3rd.db.dao;

import com.edazh.gank3rd.vo.Gank;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
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
    DataSource.Factory<Integer,Gank> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Gank> ganks);

    @Query("DELETE FROM gank")
    void removeAll();
}
