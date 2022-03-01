package fr.iut63.projetandroidribemontmaulus.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.projetandroidribemontmaulus.R;

public class FenetreDeJeu extends AppCompatActivity {
    Manager manager = new Manager();
    boolean play = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ------------------

        setContentView(R.layout.fenetredejeu);

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

    public void clickButtonSetting(View view) {
        Intent monIntent = new Intent(this, PageSetting.class);
        startActivity(monIntent);
        manager.stopThread();
    }

    public void playButton(View view){
        if(!play){
            play=true;
            manager.launchThread();
            ((Button)findViewById(R.id.playButton)).setText("STOP");
        }else{
            play=false;
            manager.stopThread();
            ((Button)findViewById(R.id.playButton)).setText("PLAY");

        }
    }

}
