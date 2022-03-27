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

    public boolean[] getBornRules(){
        return this.bornRules;
    }

    public boolean[] getSurviveRules(){
        return this.surviveRules;
    }
}
