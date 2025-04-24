package com.ifsc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {

    List<Paint> paintList;
    List<Path> pathList;
    float x0, y0;
    Path currentPath;
    Paint currentPaint;
    ColorDrawable currentColor;

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
        paintList = new ArrayList<Paint>();
        pathList = new ArrayList<Path>();
        initLayer();
        currentColor = new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        currentPaint.setColor(currentColor.getColor());


    }
    public void initLayer(){
        currentPaint = new Paint();
        currentPath = new Path();

        currentPaint.setStrokeWidth(10);
        currentPaint.setStyle(Paint.Style.STROKE);
    }

    protected  void onDraw(@NonNull Canvas canvas){
        super.onDraw(canvas);
        for(int i=0; i<paintList.size(); i++){
            canvas.drawPath(pathList.get(i),paintList.get(i));
        }
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
            case MotionEvent.ACTION_UP:
                currentPath.lineTo(event.getRawX() ,event.getY());
                paintList.add(currentPaint);
                pathList.add(currentPath);
                initLayer();
                return true;
        }

        return true;
    }

    public void clearDraw(){
        currentPath.reset();
        invalidate();
    }

    public void changeColor(int color){
        currentColor.setColor(color);
        currentPaint.setColor(color);
    }
}
