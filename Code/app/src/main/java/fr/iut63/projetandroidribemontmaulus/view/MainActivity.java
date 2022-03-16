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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ------------------

        setContentView(R.layout.mainwindow);

        //instantiation de tous le modèle
        Monde monde = new Monde(21,38);
        //initialisation du tableau de proprieté au démarrage (règle de naissances)
        boolean[] born = new boolean[9];
        born[3] = true;
        //initialisation du tableau de proprieté au démarrage (règle de survie)
        boolean[] survive = new boolean[9];
        survive[2] = true;
        survive[3] = true;


        //Appel de la méthode createModelGrille
        monde = createModelGrille(1,monde);


        Rules rules = new Rules(born,survive);
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


    // Créateur de monde

    public Monde createModelGrille(int number,Monde monde){
        switch (number){
            case(1):
                monde.getGrille()[0][2].setAlive(true);
                monde.getGrille()[1][2].setAlive(true);
                monde.getGrille()[2][2].setAlive(true);
                monde.getGrille()[2][1].setAlive(true);
                monde.getGrille()[1][0].setAlive(true);
                break;

            case(2):
                monde.getGrille()[0][3].setAlive(true);
                monde.getGrille()[2][2].setAlive(true);
                monde.getGrille()[0][0].setAlive(true);
                monde.getGrille()[1][1].setAlive(true);
                monde.getGrille()[4][2].setAlive(true);
                break;
        }
        return monde;


    }

}