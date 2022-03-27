package modele;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver implements ISaver{
    public void save(Monde monde, File fichier) {
        int sizex = monde.getTailleX();
        int sizey = monde.getTailleY();
        String nom = fichier.getPath();
        try {
            FileWriter writer = new FileWriter(nom);
            for(int x=0;x<sizex;x++){
                for(int y=0;y<sizey;y++){
                    if(monde.getGrille()[x][y].isAlive()) {
                        writer.write(x + ":" + y + "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
