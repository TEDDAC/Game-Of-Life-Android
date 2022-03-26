package modele;

import java.util.LinkedList;

public class Rules {
    /**
     * Règle de naissance des cellules.
     */
    private boolean[] bornRules;

    /**
     * Règle de survie des cellules.
     */
    private boolean[] surviveRules;

    /**
     * Constructeur de Rules
     * @param bornRules Règles de naissances
     * @param surviveRules  Règles de survie
     */
    public Rules(boolean[] bornRules, boolean[] surviveRules){
        this.bornRules = bornRules;
        this.surviveRules = surviveRules;
    }

    /**
     * Permet de changer les règles du jeu, sans regénérer une nouvelle instance et devoir refaire le binding de la vue.
     * @param newRules Nouvelles règles à appliquer
     */
    public void switchRulesTo(Rules newRules){
        this.bornRules = newRules.getBornRules();
        this.surviveRules = newRules.getSurviveRules();
    }

    public boolean[] getBornRules(){
        return this.bornRules;
    }

    public boolean[] getSurviveRules(){
        return this.surviveRules;
    }
}
