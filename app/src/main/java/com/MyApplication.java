package com;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


import com.lzy.okhttputils.OkHttpUtils;

import static android.R.attr.x;

/**
 * Created by admin on 2016/5/13.
 */
public class MyApplication extends Application {
    // 上下文
    private static Context mContext;
    // 全局的handler
    private static Handler mHandler;
    // 主线程id
    private static int mMainThreadId;
    // 主线程
    private static Thread mMainthread;

    // 当应用一启动的时候就会被调用，Application是运行在主线程中
    @Override
    public void onCreate() {
        super.onCreate();

//        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this);//极光推送的初始化
        mContext = getApplicationContext();
        mHandler = new Handler();
        // 获取当前线程id
        mMainThreadId = android.os.Process.myTid();
        // 获取当前线程
        mMainthread = Thread.currentThread();

        OkHttpUtils.init(this);
        //初始化toast， 为静态单例
//        ToastUtil.init(mContext);
//        initCacheRoot();
//        x.Ext.init(this); // 初始化xUtils
//        x.Ext.setDebug(AppConfig.IS_DEBUG);

//        DisplayImageOptions defaultOptions = new DisplayImageOptions
//                .Builder()
//                .showImageForEmptyUri(R.drawable.empty_photo)
//                .showImageOnFail(R.drawable.empty_photo)
//                .cacheInMemory(true)
//                .cacheOnDisc(true)
//                .build();
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration
//                .Builder(getApplicationContext())
//                .defaultDisplayImageOptions(defaultOptions)
//                .discCacheSize(50 * 1024 * 1024)//
//                .discCacheFileCount(100)//缓存一百张图片
//                .writeDebugLogs()
//                .build();
//        ImageLoader.getInstance().init(config);
    }

    /**
     * 初始化程序缓存目录
     */
//    private void initCacheRoot() {
//
//        try {
//            File file = new File(Util.getCachePath());
//            if (file.exists() == false) {
//                file.mkdirs();
//            }
//            file = new File(Util.getLibraryPath());
//            if (file.exists() == false) {
//                file.mkdirs();
//            }
//        } catch (Exception e) {
//            Util.logcatByCQH("initCacheRoot:" + e.toString());
//        }
//
//    }


    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainthread() {
        return mMainthread;
    }

}
