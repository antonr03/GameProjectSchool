package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class LoadSave {

	public static BufferedImage getSpriteAtlas() {

		BufferedImage img = null;
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("spriteatlas.png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return img;
	}

    public static void createFile(File file){

        try {
            file.createNewFile();
            
        } catch (Exception e) {
        }
        

    }
    public static void writeToFile(int [][] map, String name){

        
        File txtFile= new File("src/" + name + ".txt");
        if(!txtFile.exists()){
            createFile(txtFile);
        }
        
            try {
                PrintWriter printWriter= new PrintWriter(txtFile);
                for(int i:utilz.convert2DTo1D(map)){
                    printWriter.println(i);
                }
                printWriter.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LoadSave.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void readFromFile() {
        int i=0;
        int [] oneDArray= new int[TheMap.map().length*TheMap.map()[0].length];
        
        File txtFile= new File("src/text.txt");
        if(!txtFile.exists()){
            createFile(txtFile);
        }
        
        try {
            Scanner scanner = new Scanner(txtFile);
            while(scanner.hasNextLine()){
                
            oneDArray[i]= scanner.nextInt();
            i++;
            }
            scanner.close();
            
        } catch (Exception e) {
        }
        utilz.oneDto2D(oneDArray);
        
        
    }

}
