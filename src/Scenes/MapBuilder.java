/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenes;

import PlatformGame.Game;
import helpz.LoadSave;
import helpz.TheMap;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import objects.Tile;
import ui.BottomBar;

/**
 *
 * @author anton
 */
public class MapBuilder implements ScneneMethods {
    int[][] map;

    private Game game;
    private BottomBar bottomBar;
    private Tile selectedTile;
    private Random c;
    private Random d;
    private int k;
    boolean outsideBounds;
    public MapBuilder(Game game) {
        this.game = game;
        bottomBar = new BottomBar(game);
        selectedTile = new Tile(null, null, -1, -1);
        map=TheMap.map();
        c= new Random();
        d= new Random();
        k=0;
                

    }

    @Override
    public void render(Graphics g) {
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                g.drawImage(game.getTileManager().getSprite(map[x][y]),x*32, y*32, null);
                

            }
            
        }

        bottomBar.drawBottom(g);
        if(outsideBounds==true){
            drawSelectedsTile(g);
        }
        //LoadSave.createFile();
        
        

    }

    private void drawSelectedsTile(Graphics g) {
        g.drawImage(selectedTile.sprite, selectedTile.x, selectedTile.y, null);
    }
    

    @Override
    public void mouseDragged(int x, int y) {
        if(checkForBounds(x, y)){
            
            map[x/32][y/32]=selectedTile.id;

        }

    }

    @Override
    public void mouseMoved(int x, int y) {
        bottomBar.saveButton.setMouseOver(false);
		

		if (bottomBar.saveButton.bounds.contains(x, y)) {
			bottomBar.saveButton.setMouseOver(true);
                        
		} 

        
        if (checkForBounds(x, y)) {
            selectedTile.y = (y/32)*32;
            selectedTile.x = (x/32)*32;
        }

    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bottomBar.grassButton.bounds.contains(x, y)) {
            selectedTile.name = "GRASS";
            selectedTile.sprite = game.getTileManager().getSprite(2);
            selectedTile.id=2;

        }
        if (bottomBar.waterButton.bounds.contains(x, y)) {
            selectedTile.name = "WATER";
            selectedTile.sprite = game.getTileManager().getSprite(0);
            selectedTile.id=0;

        }
        if (bottomBar.rockButton.bounds.contains(x, y)) {
            selectedTile.name = "ROCK";
            selectedTile.sprite = game.getTileManager().getSprite(1);
            selectedTile.id=1;

        }
        
        if(checkForBounds(x, y)){
            
            map[x/32][y/32]=selectedTile.id;
            

        }
       
		

		if (bottomBar.saveButton.bounds.contains(x, y)) {
                    
			bottomBar.saveButton.setColor(Color.yellow);
                        LoadSave.writeToFile(map, "text");
                        LoadSave.readFromFile();
                        
		} 
        

    }
    boolean checkForBounds(int x, int y){
        if(x<640&&x>=0&&y<640&&y>0)return outsideBounds=true;
        else return outsideBounds= false;
        
        }
    @Override
    public void mousePressed(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mouseReleased(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    }

    



