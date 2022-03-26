package modele;

import java.util.LinkedList;
import java.util.List;

import fr.iut63.projetandroidribemontmaulus.view.CellsGrid;

public class BoucleDeJeu implements Runnable{

    /**
     * Instance du dieu
     */
    private final Dieu dieu;

    private LinkedList<Notifiable> listener;

    private boolean enable;
    public boolean isEnable(){ return enable; }
    public void setEnable(boolean value){ this.enable = value; }

    /**
     * Indique à la pause si elle est lancé ou non
     */
    public static boolean played = false;
    public static boolean getPlayed(){ return played; }
    public static void setPlayed(boolean valeur){ played = valeur;}

    /**
     * Période entre chaque répétition de la boucle
     */
    private int time;

    /**
     * Constructeur de la boucle de jeu
     * @param dieu Le dieu qui sera modifié par la boucle de jeu.
     */
    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
        setTime(500);
        this.enable = true;
        this.listener = new LinkedList<>();
    }

    /**
     * Algorithme de la boucle de jeu
     */
    @Override
    public void run() {
        while(enable){
            if(BoucleDeJeu.getPlayed()){

                dieu.evolution();
                dieu.updateCells();
                for (Notifiable notifiable : this.listener){
                    notifiable.notifier();
                }
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(getTime());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return this.time;
    }

    public void stop(){
        this.enable = false;
    }

    public void addNotifiableListener(Notifiable element){
        this.listener.add(element);
    }

    public void remosteNotifiableListener(Notifiable element){
        this.listener.remove(element);
    }
}
