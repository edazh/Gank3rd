package com.edazh.gank3rd.util;

import android.os.SystemClock;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:决定我们是否应该获取一些数据的实用程序类。
 */
public class RateLimiter<K> {
    public static final String TAG = "RateLimiter";
    private final ArrayMap<K, Long> timestamps;
    private final Long timeout;

    public RateLimiter(long timeout, @NonNull TimeUnit timeUnit) {
        timestamps = new ArrayMap<>();
        this.timeout = timeUnit.toMillis(timeout);
        Log.d(TAG, "RateLimiter: " + this.timeout);
    }

    /**
     * 是否应该获取数据
     *
     * @param key 存入的相应的key
     * @return true 应该获取，否则不获取
     */
    public boolean shouldFetch(K key) {
        Long lastFetched = timestamps.get(key);
        Log.d(TAG, "shouldFetch: " + lastFetched);
        Long now = now();
        if (lastFetched == null) {
            timestamps.put(key, now);
            return true;
        }
        if (now - lastFetched > timeout) {
            timestamps.put(key, now);
            return true;
        }
        return false;
    }


    /**
     * 重置时间
     *
     * @param key 相应的key
     */
    public void reset(K key) {
        timestamps.remove(key);
    }

    /**
     * 获取枪弹的时间戳
     *
     * @return 当前时间戳
     */
    private Long now() {
        return SystemClock.uptimeMillis();
    }
}
