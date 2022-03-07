package modele;

public class BoucleDeJeu implements Runnable{
    /**
     * Instance du dieu
     */
    private final Dieu dieu;

    private boolean enable;

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
}
