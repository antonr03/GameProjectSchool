/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenes;


import PlatformGame.GameState;
import static PlatformGame.GameState.setGameState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import ui.Button;

/**
 *
 * @author anton
 */
public class Menu implements ScneneMethods{

    public Button playButton;
    public Button settingsButton;
    public Button quitButton;
    public Button buildMapButton;
    
    
    public Menu(){
        int w=150;
        int h=40;
        int x =640/2-w/2;
        int y=640/5-h/2;
        
        playButton=new Button(x,y*2,w,h,"Play");
        
        buildMapButton=new Button(x,y*3,w,h,"Buildmap");

        
        
        
        
    }
    
   

    @Override
    public void render(Graphics g) {
        if(buildMapButton.isMouseOver())g.setColor(Color.gray);
        
        else g.setColor(Color.white);
        buildMapButton.drawButton(g);
    }
    

    

    @Override
    public void mouseDragged(int x, int y) {
 
    }
    

    @Override
    public void mouseMoved(int x, int y) {
        System.out.println("Scenes.Menu.mouseMoved()");
        buildMapButton.setMouseOver(false);
		

		if (buildMapButton.bounds.contains(x, y)) {
			buildMapButton.setMouseOver(true);
                        System.out.println("Scenes.Menu.mouseMoved()");
		} 


    }

    @Override
    public void mouseClicked(int x, int y) {
        if(buildMapButton.bounds.contains(x,y)){
            setGameState(GameState.MAPBULDER);
        }
       
    }

    @Override
    public void mousePressed(int x, int y) {
       
    }

    @Override
    public void mouseReleased(int x, int y) {
        
    }
    
    
}
