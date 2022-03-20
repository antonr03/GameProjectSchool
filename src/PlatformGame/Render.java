/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlatformGame;

import java.awt.Graphics;

/**
 *
 * @author anton
 */
public class Render {
    
    private Game game;

    Render(Game game) {
        this.game=game;
        
        
    }
    
    public void drawGame(Graphics g){
        
        
        switch (GameState.gameState) {

            case MENU:
                
                game.getMenu().render(g);

                break;
            case PLAYING:
                

                

                break;
            case SETTINGS:



                break;
            case MAPBULDER:
                game.getMapBuilder().render(g);
            break;

        }
    }

}
