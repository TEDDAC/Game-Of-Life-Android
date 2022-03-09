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
import modele.BoucleDeJeu;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

public class FenetreDeJeu extends AppCompatActivity {
//    Manager manager = new Manager();
    public CellsGrid cellsGrid;
    public static BoucleDeJeu boucleDeJeu;
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
                FenetreDeJeu.boucleDeJeu.setTime(500 - 490*progress/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Dieu dieu = Dieu.getDieu();
        cellsGrid = (CellsGrid) findViewById(R.id.cellsGrid);
        final Button playButton = (Button)findViewById(R.id.startButton);

        boucleDeJeu = new BoucleDeJeu(dieu);
        boucleDeJeu.setCellsGrid(cellsGrid);
        Thread thread = new Thread(boucleDeJeu);
        thread.start();
        playButton.setOnClickListener(view -> {
            Log.d("PlayButton OnClick","Clicked");
            if(!FenetreDeJeu.boucleDeJeu.getPlayed()){ //stopped
                FenetreDeJeu.boucleDeJeu.setPlayed(true);
                playButton.setText(R.string.Stop);
            }else{ //Played
                FenetreDeJeu.boucleDeJeu.setPlayed(false);
                playButton.setText(R.string.Play);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LogAppVie", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LogAppVie", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        FenetreDeJeu.boucleDeJeu.setPlayed(false);
        Log.d("LogAppVie", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LogAppVie", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LogAppVie", "onDestroy");
        FenetreDeJeu.boucleDeJeu.setEnable(false);
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
