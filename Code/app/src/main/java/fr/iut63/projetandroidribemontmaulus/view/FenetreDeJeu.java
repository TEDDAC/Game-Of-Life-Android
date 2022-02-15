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

    //j'ai pas compris ce que t'as cherché à faire. Pour dessiner une grille, on doit créer un Custom View: https://developer.android.com/guide/topics/ui/custom-components
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

}
