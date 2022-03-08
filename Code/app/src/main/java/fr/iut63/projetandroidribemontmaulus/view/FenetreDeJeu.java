package fr.iut63.projetandroidribemontmaulus.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

public class FenetreDeJeu extends AppCompatActivity {
//    Manager manager = new Manager();
    public CellsGrid cellsGrid;
    private Thread thread;
    boolean play = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);


        //Instantiation de la seekBar
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        //Instantiation du texte pour afficher la vitesse
        final TextView seekBarValue = (TextView)findViewById(R.id.textViewVitesse);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        //instantiation de tous le modèle
        Monde monde = new Monde(30,30);
        //initialisation du tableau de proprieté au démarrage (règle de naissances)
        boolean[] born = new boolean[9];
        born[3] = true;
        //initialisation du tableau de proprieté au démarrage (règle de survie)
        boolean[] survive = new boolean[9];
        survive[2] = true;
        survive[3] = true;

        Rules rules = new Rules(born,survive);
        Dieu dieu = new Dieu(monde, rules);

        cellsGrid = (CellsGrid) findViewById(R.id.cellsGrid);
        final Button playButton = (Button)findViewById(R.id.startButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CellsGrid cellsGrid = (CellsGrid)findViewById(R.id.cellsGrid);
                cellsGrid.invalidate(); //force la view à ce redraw
                Log.d("PlayButton OnClick","Clicked");
                if(!play){
                    play=true;
                }else{
                    play=false;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LogAppVie", "onStart2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LogAppVie", "onResume2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LogAppVie", "onPause2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LogAppVie", "onStop2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LogAppVie", "onDestroy2");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void clickButtonSetting(View view) {
        Intent monIntent = new Intent(this, PageSetting.class);
        startActivity(monIntent);
    }


    public int getValueSeekBar(View view){
        SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
        int seekValue = seek.getProgress();
        return seekValue;
    }

}
