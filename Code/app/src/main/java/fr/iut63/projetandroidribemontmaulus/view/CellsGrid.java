package fr.iut63.projetandroidribemontmaulus.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Cellule;
import modele.Dieu;
import modele.Monde;
import modele.Notifiable;

public class CellsGrid extends View implements Notifiable { //custom view
    private Paint paint;
    private int sizeCell = 50;
    private int spacing = 2;
    private Canvas canvas;

    float viewWidth;
    float viewHeight;

    public CellsGrid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

//        Log.d("CellsGrid","Construction");
    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
//        Log.d("CellsGrid","onDraw");

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

        this.viewWidth = this.getMeasuredWidth();
        this.viewHeight = this.getMeasuredHeight();
        Log.d("CellsGrid",this.viewWidth + ":" + this.viewHeight);

        int nbCellsX = (int)(this.viewWidth/(this.sizeCell+this.spacing));
        int nbCellsY = (int)(this.viewHeight/(this.sizeCell+this.spacing));

        Log.d("CellsGrid",nbCellsX + ":" + nbCellsY);

        Dieu.getDieu().setMonde(new Monde(nbCellsX,nbCellsY));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    // ne pas utiliser manuellement, uniquement dans le ondraw
    @SuppressLint("ResourceAsColor")
    public void drawCells(int x, int y, boolean alive){
        int left = (this.sizeCell + this.spacing)*x;
        int top = (this.sizeCell + this.spacing)*y;
        int right = left + this.sizeCell;
        int bottom = top + this.sizeCell;
        if(alive){
            this.paint.setColor(getResources().getColor(R.color.gridForeground));
        } else this.paint.setColor(getResources().getColor(R.color.gridBackground));
        //Log.d("CellsGrid drawCells","Draw: "+x+" "+y);
        this.canvas.drawRect(left, top, right, bottom, this.paint);

        //quadrillage
        this.paint.setColor(getResources().getColor(R.color.gridForeground));
        //ligne à droite de la cellule
        this.canvas.drawRect(right, top, right+2, bottom+1, this.paint);
        //ligne en dessous
        this.canvas.drawRect(left, bottom, right+1, bottom+2, this.paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float viewWidth = this.getMeasuredWidth();
        float viewHeight = this.getMeasuredHeight();
//        Log.d("Custom View","onDraw with size> x = " + viewWidth + " y = " + viewHeight);
        float x = event.getX();
        float y = event.getY();
        Monde monde = Dieu.getDieu().getMonde();
        int cellX = (int)(monde.getTailleX()*x/((this.sizeCell+this.spacing)*monde.getTailleX()));
        int cellY = (int)(monde.getTailleY()*y/((this.sizeCell+this.spacing)*monde.getTailleY()));

        Cellule cell = monde.getGrille()[cellX][cellY];
        if(cell.isAlive()){
            cell.setAlive(false);
        } else cell.setAlive(true);

        this.postInvalidate();

        Log.d("CellsGrid","Click> x = " + cellX + " y = " + cellY);
        return super.onTouchEvent(event);
    }

    @Override
    public void notifier() {
        this.postInvalidate();
    }
}
