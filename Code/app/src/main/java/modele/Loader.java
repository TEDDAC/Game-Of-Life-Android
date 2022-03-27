package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader implements ILoader{
    @Override
    public void load(Dieu dieu,String filename){
        dieu.clearGrid();
        Monde monde = dieu.getMonde();
        File fichier = new File(filename);
        try {
            Scanner reader = new Scanner(fichier);
            while(reader.hasNext()){
                String data = reader.nextLine();
                int x = Integer.parseInt(data.split(":")[0]);
                int y = Integer.parseInt(data.split(":")[1]);
                if(x >= 0 && x < monde.getTailleX()) {
                    if(y >= 0 && y < monde.getTailleY()) {
                        monde.getGrille()[x][y].setAlive(true);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
