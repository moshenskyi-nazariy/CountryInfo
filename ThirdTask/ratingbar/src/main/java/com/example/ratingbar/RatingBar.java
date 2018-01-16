package com.example.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class RatingBar extends View {
    private static final int LEVEL_COUNT = 4;
    private static final float ANGLE = 180F;
    private static final int DIVIDERS_STOKE_WIDTH = 2;
    private static final int POINTER_STROKE_WIDTH = 20;

    private int radius;
    private int middleX;
    private int middleY;
    private int width;
    private int height;
    private float angle;

    private Paint paint;
    private Paint lines;
    private RectF rect;
    private int level;

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
        lines = new Paint(Paint.ANTI_ALIAS_FLAG);
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
        drawArc(canvas);
        drawSections(canvas);
        drawPointer(canvas);
    }

    private void drawPointer(Canvas canvas) {
        lines.setStrokeWidth(POINTER_STROKE_WIDTH);

        float sectionMiddle = angle * level - angle / 2;
        float length = getLength(sectionMiddle, 1);
        float height = getHeight(length);

        canvas.drawCircle(middleX, middleY, this.height / 20, lines);
        canvas.drawLine(middleX, middleY, middleX - length, middleY - height, lines);
    }

    private void drawArc(Canvas canvas) {
        paint.setShader(new LinearGradient(0, 0, getWidth(), 0, Color.GREEN, Color.RED, Shader.TileMode.MIRROR));
        canvas.drawArc(rect, ANGLE, ANGLE, true, paint);
    }

    private void drawSections(Canvas canvas) {
        angle = ANGLE / (LEVEL_COUNT);

        lines.setStrokeWidth(DIVIDERS_STOKE_WIDTH);
        lines.setColor(Color.WHITE);

        float length, height;

        for (int section = 1; section < LEVEL_COUNT; section++) {
            length = getLength(angle, section);
            height = getHeight(length);
            canvas.drawLine(middleX, middleY, middleX + length, middleY - height, lines);
        }
    }

    private float getLength(float angle, int section) {
        return (float) (Math.cos(Math.toRadians(angle * (section))) * middleX);
    }

    private float getHeight(float length) {
        float hypotenuse = middleX * middleX;
        float xCathetus = length * length;
        float yCathetus = hypotenuse - xCathetus;

        return (float) Math.sqrt(Math.abs(yCathetus));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int heightSize = getHeight();
        int widthSize = getWidth();

        if (widthSize > heightSize) {
            width = height = heightSize;
        } else {
            height = width = widthSize;
        }

        middleX = width / 2;
        middleY = height / 2;

        radius = middleX / 2;

        rect.set(0, 0, width, height);
    }

    public void setLevel(int level) {
        this.level = level;
        invalidate();
    }
}
