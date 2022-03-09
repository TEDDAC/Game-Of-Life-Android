package fr.iut63.projetandroidribemontmaulus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Cellule;
import modele.Dieu;
import modele.Monde;

public class CellsGrid extends View { //custome view
    private Paint paint;
    private int nbCellX = 10;
    private int nbCellY = 20;
    private int sizeCell = 60;
    //private int sizeCellY = 50;
    private int spacing = 20;
    private Canvas canvas;

    public CellsGrid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        Log.d("Custom View","onDraw");

        Monde monde = Dieu.getDieu().getMonde();
//        Log.d("Dessin de la grille","TailleX: "+monde.getTailleX() + "  TailleY: "+monde.getTailleY());
//        Log.d("Dessin de la grille",monde.getGrille().toString());
        for(int x=0;x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
//                Log.d("Dessin de la grille",x+" : "+y+"  Alive: "+monde.getGrille()[x][y].isAlive());
                drawCells(x,y,monde.getGrille()[x][y].isAlive());
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

    // ne pas utiliser manuellement, uniquement dans le ondraw
    public void drawCells(int x, int y, boolean alive){
        int left = (this.sizeCell + this.spacing)*x;
        int top = (this.sizeCell + this.spacing)*y;
        int right = left + this.sizeCell;
        int bottom = top + this.sizeCell;
        if(alive){
            this.paint.setColor(0xff000000);
        } else this.paint.setColor(0xffffffff);
        //Log.d("CellsGrid drawCells","Draw: "+x+" "+y);
        this.canvas.drawRect(left, top, right, bottom, this.paint);
    }
}
