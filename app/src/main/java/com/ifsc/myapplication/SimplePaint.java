package com.ifsc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimplePaint extends View {
    float x0, y0;
    Path currentPath;
    Paint currentPaint;

    public SimplePaint(Context context) {
        super(context);
        init();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        currentPaint = new Paint();
        currentPath = new Path();
        currentPaint.setColor(Color.BLACK);
        currentPaint.setStrokeWidth(10);
        currentPaint.setStyle(Paint.Style.STROKE);
    }

    protected  void onDraw(@NonNull Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(currentPath,currentPaint);
    }
    // cada path terá seu próprio paint

    public boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x0 = event.getRawX();
                y0 = event.getRawY();
                currentPath.moveTo(x0,y0);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(event.getRawX() ,event.getY());
                this.invalidate();
                return true;
        }

        return true;
    }

    public void clearDraw(){
        currentPath.reset();
        invalidate();
    }

    public void changeColor(int color){
        currentPaint.setColor(color);
    }
}
