package fr.iut63.projetandroidribemontmaulus.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.projetandroidribemontmaulus.R;

public class FenetreDeJeu extends AppCompatActivity {


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
