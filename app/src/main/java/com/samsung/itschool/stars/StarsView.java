package com.samsung.itschool.stars;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class StarsView extends View {
    // экземпляр класса с координатами "звезд"
    Stars stars = new Stars(200, 30, 10, 20);
    float STAR_RADIUS = 10; // радиус круга, изображающего звезду
    public StarsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        stars.step();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.rgb(0, 0, 50));
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        // смещение начала координат в центр экрана
        float offset_x = canvas.getWidth() / 2;
        float offset_y = canvas.getHeight() / 2;
        for (int i = 0; i < stars.radii.length; i++) {
            float r = stars.radii[i];
            float phi = stars.angles[i];
            float x = offset_x + (float) Math.cos(phi) * r;
            float y = offset_y + (float) Math.sin(phi) * r;
            canvas.drawCircle(x,y,STAR_RADIUS,p);

        }
    }
}
