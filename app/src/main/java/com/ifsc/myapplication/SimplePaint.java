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
    private String shapeType = "linha";

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
        float x = event.getRawX();
        float y = event.getRawY();

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                x0 = x;
                y0 = y;

                if (shapeType.equals("linha")) {
                    currentPath.moveTo(x0, y0);
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                if(shapeType.equals("linha")) {
                    currentPath.lineTo(x, y);
                }
                this.invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                Paint paint = new Paint(currentPaint);
                Path path = new Path();

                if(shapeType.equals("linha")) {
                    path.set(currentPath);
                    pathList.add(path);
                    paintList.add(paint);

                } else if (shapeType.equals("retangulo")) {
                    path.addRect(x0,y0,x,y,Path.Direction.CW);
                    pathList.add(path);
                    paintList.add(paint);
                } else if (shapeType.equals("circle")) {
                    float raio = (float) Math.hypot(x-x0,y-y0);
                    path.addCircle(x0,y0, raio, Path.Direction.CW);
                    pathList.add(path);
                    paintList.add(paint);
                }
                invalidate();
                initLayer();
                return true;
        }

        return true;
    }

    public  void desfazer(){
        pathList.remove(pathList.size()-1);
        paintList.remove(paintList.size()-1);
        invalidate();
    }

    public void escolheForma(String forma){
        this.shapeType= forma;

    }


    public void clearDraw(){
        pathList.clear();
        paintList.clear();
        currentPath.reset();
        invalidate();
    }

    public void changeColor(int color){
        currentColor.setColor(color);
        currentPaint.setColor(color);
    }
}
