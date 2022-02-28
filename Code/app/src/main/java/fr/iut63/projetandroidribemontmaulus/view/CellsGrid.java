package fr.iut63.projetandroidribemontmaulus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class CellsGrid extends View { //custome view
    private Paint paint;
    private int nbCellX = 10;
    private int nbCellY = 20;
    private int sizeCell = 60;
    //private int sizeCellY = 50;
    private int spacing = 100;

    public CellsGrid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xff000000); //ARGB
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Custom View","onDraw");
        for(int x = 0;x<nbCellX;x++){
            for(int y = 0;y<nbCellY;y++) {
                canvas.drawRect(x * spacing, y*spacing, sizeCell + x * spacing, sizeCell+y*spacing, paint);
                Log.d("Custom View","Carré déssiné");
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
