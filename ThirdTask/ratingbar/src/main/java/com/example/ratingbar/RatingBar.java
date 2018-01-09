package com.example.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class RatingBar extends View {
    private static final int LEVEL_COUNT = 5;

    private int radius = 100;
    private int startX = 50;
    private int startY = 50;
    private int endY = radius + startY;
    private float center = (float) (startX + radius);

    private Paint paint;
    private RectF rect;
    private int level;
    private int width;
    private int height;

    public RatingBar(Context context) {
        super(context);
        init(null);
    }

    public RatingBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
        rect = new RectF();

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingBar);
            level = typedArray.getInt(R.styleable.RatingBar_danger_level, 0);
            typedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, 180F, 180F, true, paint);
        drawSections(canvas);
    }

    private void drawSections(Canvas canvas) {
        float angle = 180 / (LEVEL_COUNT);
        Paint lines = new Paint(Paint.ANTI_ALIAS_FLAG);
        lines.setColor(Color.RED);
        float length, height;

       for (int i = 1; i < LEVEL_COUNT; i++) {
            length = (float) (Math.cos(Math.toRadians(angle * (i))) * radius);
            float gipot = radius * radius;
            float catet = length * length;
            float xcatet = gipot - catet;
            height = (float) Math.sqrt(xcatet);
            canvas.drawLine(center, endY, center + length, endY - height, lines);
       }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //width = MeasureSpec.getSize(widthMeasureSpec);
        //height = MeasureSpec.getSize(heightMeasureSpec);

        rect.set(startX, startY, startX + 2 * radius, startY + 2 * radius);
    }
}
