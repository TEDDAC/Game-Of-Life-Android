package fr.iut63.projetandroidribemontmaulus.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.projetandroidribemontmaulus.R;
import fr.iut63.projetandroidribemontmaulus.view.FenetreDeJeu;
import modele.Dieu;
import modele.Monde;
import modele.Rules;
import modele.Stub;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ------------------

        setContentView(R.layout.mainwindow);

        //instantiation de tous le modèle
        Monde monde = new Monde(0,0);

        Rules rules = Stub.configRules().get("Default");
        Dieu dieu = new Dieu(monde, rules);
        Log.d("Fenetre de jeu","Dieu créé");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LogAppVie","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LogAppVie","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LogAppVie","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LogAppVie","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LogAppVie","onDestroy");
    }

    public void clickButton(View view) {
        // Test a supprimer
        Intent monIntent = new Intent(this, FenetreDeJeu.class);
        startActivity(monIntent);
    }
}