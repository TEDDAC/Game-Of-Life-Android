package modele;

public class Monde{

    /**
     * Taille X de la grille de cellule. Bind sur un spinner dans la vue. //A CHANGER pour android studio => CustomView
     */
    private int tailleX;

    /**
     * Taille Y de la grille de cellule. Bind sur un spinner dans la vue.
     * Taille Y de la grille de cellule. Bind sur un spinner dans la vue.
     */
    private int tailleY;

    /**
     * Grille de cellule.
     */
    private Cellule[][] grille;


    /**
     * Constructeur du monde
     * @param tailleX Taille X du monde
     * @param tailleY Taille Y du monde
     */
    public Monde(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        setTailleY(tailleY);
        grille = GrilleCellFactory.createCellGrid(tailleX,tailleY);
    }

    /**
     * Getter
     * @return
     */
    public Cellule[][] getGrille() {
        return grille;
    }

    /**
     * Setter
     * @param grille
     */
    public void setGrille(Cellule[][] grille) {
        this.grille = grille;
    }

    public void setTailleX(int tailleX){
        this.tailleX = tailleX;
    }

    public int getTailleX(){
        return this.tailleX;
    }

    public void setTailleY(int tailleY){
        this.tailleY = tailleY;
    }

    public int getTailleY(){
        return this.tailleY;
    }
}
