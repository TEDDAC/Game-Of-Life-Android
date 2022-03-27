package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Interface de chargement des fichier de motif
 */
public interface ILoader {
    public void load(Dieu dieu,String filename);
}
