package com.example.idmin.loadpdfdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.github.barteksc.pdfviewer.PDFView;

/**
 * 作者：idmin on 2018/5/26 13:14
 */
public class MyPdfView extends PDFView {
    /**
     * Construct the initial view
     *
     * @param context
     * @param set
     */
    public MyPdfView(Context context, AttributeSet set) {
        super(context, set);
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }
        });
    }

   private GestureDetector gestureDetector;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
