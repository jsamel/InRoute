package com.TeamCEOS.inroute;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View{

	Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        //paint.setTextSize(30);
    }

    @Override
    public void onDraw(Canvas canvas) {
            canvas.drawLine(0, 0, 300, 300, paint);
            canvas.drawLine(300, 0, 0, 300, paint);
            canvas.drawCircle(200, 200, 200, paint);
    }

}
