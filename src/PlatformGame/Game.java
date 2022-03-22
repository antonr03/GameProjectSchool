//change  
//antoniothegreatempepror
package PlatformGame;

import static PlatformGame.GameState.*;
import Scenes.MapBuilder;
import Scenes.Menu;
import helpz.LoadSave;
import helpz.TheMap;


import inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import ui.Button;


public class Game extends JFrame implements Runnable{
     
     private final double FPS_SET=120.0;
     private final double UPS_SET = 60.0;
     
     //classes
     private GameScreen gameScreen;
     private Menu menu;
     private MapBuilder mapBuilder;
     private TileManager tileManager;

     
     
     Thread thread;



    private Render render;
   
    public Game(){
        setGameState(MENU);
        initClasses();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(gameScreen);
        pack();
        setVisible(true);
        thread.start();
        LoadSave.writeToFile(TheMap.map(),"text");
        
 

        

    }
    

    
    public static void main(String[] args) {
        Game game= new Game();
        String currentDirectory= System.getProperty("user.dir");
        System.out.println(currentDirectory);
    }
    void initClasses(){
        gameScreen=new GameScreen(this);
        render= new Render(this);
        tileManager= new TileManager();
        
        menu= new Menu();
        mapBuilder= new MapBuilder(this);


        thread=new Thread(this){};



        

    }
    public Menu getMenu(){
        return menu;
    }
    public MapBuilder getMapBuilder(){
        return mapBuilder;
    }
    public Render getRender(){
        return render;
    }
    public TileManager getTileManager(){
        return tileManager;
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            now = System.nanoTime();

            // Render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            // Update
            if (now - lastUpdate >= timePerUpdate) {
                
                lastUpdate = now;
                updates++;
            }
            

            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }

    }
    


   }
