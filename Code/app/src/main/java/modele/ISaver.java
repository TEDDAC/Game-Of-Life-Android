package modele;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface ISaver {

    /**
     * Sauvegarde une grille de cellule dans un fichier
     * @param monde Monde dont on souhaite sauvegarder la grille de cellule
     * @param fichier Fichier dans lequel on souhaite sauvegarder la grille
     */
    void save(Monde monde, File fichier);
}
