package com.edazh.gank3rd.util;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:常量
 *     查看详细报错信息
 *     gradlew compileDebug --stacktrace
 *     gradlew compileDebug --info
 *
 *     gradlew compileDebugAndroidTestAidl
 *     compileDebugAidl
 *     gradlew tasks --stacktrace
 */
public final class Constant {
    /**
     * 数据库相关
     */
    public static final class Database {
        /**
         * 数据库名
         */
        public static final String DATABASE_NAME = "gank-db";
    }

    /**
     * 网络相关
     */
    public static final class Network {
        /**
         * API地址
         */
        public static final String BASE_URL = "http://gank.io/api/";
    }
}
