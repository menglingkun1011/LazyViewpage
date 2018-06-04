package com.example.idmin.loadpdfdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity{

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView) findViewById( R.id.pdfView );

//        OkHttpClient client = new OkHttpClient().newBuilder().hostnameVerifier(new HostnameVerifier() {
//
//            @Override
//            public boolean verify(String hostname, SSLSession session) {
//                //强行返回true 即验证成功
//                return true;
//            }
//        }).build();

        OkHttpUtils.get()
                .url("https://oss-dev.ebanma.com:20011/oss/download/assets/7b3e4e85b4d9403096b89231372afc35.pdf")
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), System.currentTimeMillis()+".pdf") {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(File response, int id) {
                        try {
                            InputStream is = new FileInputStream(response);
                            pdfView.fromStream(is)
                                    .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                                    .enableSwipe(true) // allows to block changing pages using swipe
                                    .swipeHorizontal(false)
                                    .enableDoubletap(true)
                                    .defaultPage(0)
                                    .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                                    .password(null)
                                    .scrollHandle(null)
                                    .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                                    .load();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                    }
                });
        pdfView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
