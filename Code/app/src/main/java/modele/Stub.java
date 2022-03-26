package modele;

import modele.Cellule;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stub {
    public Stub() {
    }

    public static HashMap<String,Rules> configRules(){
        HashMap<String,Rules> config= new HashMap<String, Rules>();

        //default
        boolean[] born = new boolean[9];
        born[3] = true;

        boolean[] survive = new boolean[9];
        survive[2] = true;
        survive[3] = true;

        config.put("Default",new Rules(born,survive));



        //water: live 0-9, born 3,5-8
        born = new boolean[9];

        born[3] = true;
        born[5] = true;
        born[6] = true;
        born[7] = true;
        born[8] = true;

        survive = new boolean[9];
        Arrays.fill(survive,true);

        config.put("Water",new Rules(born,survive));


        //blob: live 0-9, born 3,6-8
        born = new boolean[9];
        born[3] = true;
        born[6] = true;
        born[7] = true;
        born[8] = true;

        survive = new boolean[9];
        Arrays.fill(survive,true);

        config.put("Blob",new Rules(born,survive));


        //maze: live 1-5, born 3
        born = new boolean[9];
        born[3] = true;

        survive = new boolean[9];
        Arrays.fill(survive,true);
        survive[0] = false;
        survive[6] = false;
        survive[7] = false;
        survive[8] = false;

        config.put("Maze",new Rules(born,survive));
        return config;
    }

//    public Dieu Base(){
//        Monde monde = new Monde(30,30);
//
//        //initialisation du tableau de proprieté au démarrage (règle de naissances)
//        boolean[] born = new boolean[9];
//        for(int i=0;i<9;i++){
//            born[i] = new boolean();
//            born[i].set(false);
//        }
//        born[3].set(true);
//
//        //initialisation du tableau de proprieté au démarrage (règle de survie)
//        boolean[] survive = new boolean[9];
//        for(int i=0;i<9;i++){
//            survive[i] = new boolean();
//            survive[i].set(false);
//        }
//        survive[2].set(true);
//        survive[3].set(true);
//
//        Rules rules = new Rules(born,survive);
//        Dieu dieu = new Dieu(monde, rules);
//        return  dieu;
//    }
//
//    public Cellule[][] createGrid(){
//        Cellule[][] grille = new Cellule[Dieu.monde.getTailleX()][Dieu.monde.getTailleY()];
//        for(int x=0;x<Dieu.monde.getTailleX();x++){
//            for(int y=0;y<Dieu.monde.getTailleY();y++){
//                grille[x][y] = new Cellule(x,y);
//            }
//        }
//
//        return grille;
//    }
}
