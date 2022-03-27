package modele;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Dieu implements Notifiable{
    private static Dieu dieuInstance;

    /**
     * Contient la grille de cellule et ses dimensions
     */
    private Monde monde;
    /**
     * Contient les règles de naissance et de survie de cellules
     */
    private Rules rules;

    private LinkedList<Notifiable> onRulesChangeListener;

    /**
     * Constructeur de dieu
     * @param monde un dieu possède un monde
     * @param rules un dieu connait aussi les règles
     */
    public Dieu(Monde monde,Rules rules){
        this.monde = monde;
        this.rules = rules;
        this.dieuInstance = this;
        this.onRulesChangeListener = new LinkedList<>();
    }

    public static Dieu getDieu(){
        if(dieuInstance != null){
            return dieuInstance;
        } else {
            Log.d("getDieu","Nouveau dieu créé");
            dieuInstance = new Dieu(null, null);
            return dieuInstance;
        }
    }

    /**
     * Parcours le tableau pour determiner le prochain état des cellules
     */
    public void evolution(){
        for(int x=0; x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
                Cellule current = monde.getGrille()[x][y];
                evolveCell(current);
            }
        }
    }

    /**
     * Cette fonction détermine le prochain état d'une cellule en fonction du nombre de cellules voisines et des règles
     * @param cell La cellule dont ont souhaite déterminer le prochain état
     */
    public void evolveCell(Cellule cell){
        int nbVoisinesVivante = getNbvoisinesVivanteDe(cell.getX(),cell.getY());
        cell.setNextTimeStatus(0);
        if(cell.isAlive()) {
            if (!rules.getSurviveRules()[nbVoisinesVivante]){
                cell.setNextTimeStatus(-1);
            }
        }
        else { //morte
            if (rules.getBornRules()[nbVoisinesVivante]){
                cell.setNextTimeStatus(1);
            }
        }
    }

    /**
     * Determine le nombre de cellules voisines vivantes pour les coordonnées données.
     * @param i Coordonnées x
     * @param j Coordonnées y
     * @return Nombre de cellules voisines vivantes
     */
    public int getNbvoisinesVivanteDe(int i,int j){
        int cpt=0;
        for(int x=i-1;x<=i+1;x++){
            for(int y=j-1;y<=j+1;y++){
                if(x >= 0 && x < monde.getTailleX() && y >= 0 && y < monde.getTailleY()) {
                    Cellule current = monde.getGrille()[x][y];
                    if(x!=i || y!=j){
                        if (current.isAlive()) {
                            cpt = cpt + 1;
                        }
                    }
                }
            }
        }
        return cpt;
    }

    /**
     * Mais toutes les cellules traitées à jour.
     */
    public void updateCells() {
        for(int x=0; x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
                Cellule current = monde.getGrille()[x][y];
                current.update();
            }
        }
    }

    public void clearGrid(){
        for(int x=0;x<monde.getTailleX();x++){
            for(int y=0;y<monde.getTailleY();y++){
                monde.getGrille()[x][y].setAlive(false);
            }
        }
    }

    /**
     * Getter
     * @return
     */
    public Rules getRules() {
        return rules;
    }

    /**
     * Setter
     * @param rules
     */
    public void setRules(Rules rules) {
        this.rules = rules;
        notifyOnRuleChange();
    }

    /**
     * Getter
     * @return
     */
    public Monde getMonde() {
        return monde;
    }

    /**
     * Setter
     * @param monde
     */
    public void setMonde(Monde monde) {
        this.monde = monde;
    }

    public void addOnRuleChangeListener(Notifiable notifiable){
        onRulesChangeListener.add(notifiable);
    }

    public void removeOnRuleChangeListener(Notifiable notifiable){
        onRulesChangeListener.remove(notifiable);
    }

    public void notifyOnRuleChange(){
        for(Notifiable notifiable : onRulesChangeListener){
            notifiable.notifier();
        }
    }

    @Override
    public void notifier() {
        getDieu().evolution();
        getDieu().updateCells();
    }
}
