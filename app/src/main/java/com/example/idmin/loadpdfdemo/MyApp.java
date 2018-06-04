package com.example.idmin.loadpdfdemo;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 作者：idmin on 2018/5/30 17:13
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        initNetWork();
    }

    private void initNetWork() {
        InputStream[] inputStream = new InputStream[0];
        try {
            inputStream = new InputStream[]{getAssets().open("cert.cer")};
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(inputStream, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("爆米花HttpRequest"))
//                .addInterceptor(new LastHistoryInterceptor())
                .connectTimeout(30000L, TimeUnit.MILLISECONDS)
                .readTimeout(30000L, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory,sslParams.trustManager)
//                .sslSocketFactory(HttpsUtils.getSslSocketFactory(null,null,""),HttpsUtils.MyTrustManager)
//                .cookieJar(getCookieJar(application))
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
//        initHead(application);
    }

}
