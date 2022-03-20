/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import PlatformGame.Game;
import PlatformGame.TileManager;
import helpz.LoadSave;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author anton
 */
public class BottomBar {


    private Game game;
    public Button grassButton;
    public Button waterButton;
    public Button rockButton;
    public BottomBar(Game game){
            

    this.game = game;
    initButtons();


}

    
    public void drawBottom(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0, 640, 640,100);
        grassButton.drawImgButton(g);
        waterButton.drawImgButton(g);
        rockButton.drawImgButton(g);
    }
    private void initButtons(){
        int x,y,width,height;
        x=35;
        y=650;
        width=50;
        height=50;
        grassButton= new Button(x,y,width,height,"WATER",game.getTileManager().getSprite(0));
        waterButton= new Button(x+2*x,y,width,height,"ROCK",game.getTileManager().getSprite(1));
        rockButton= new Button(x+4*x,y,width,height,"GRASS",game.getTileManager().getSprite(2));
        
    }

    
}
