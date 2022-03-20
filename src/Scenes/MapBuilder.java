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

    public MapBuilder(Game game) {
        this.game = game;
        bottomBar = new BottomBar(game);
        selectedTile = new Tile(null, null, -1, -1);
        map=TheMap.map();
        c= new Random();
        d= new Random();
                

    }

    @Override
    public void render(Graphics g) {
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                g.drawImage(game.getTileManager().getSprite(map[x][y]),x*32, y*32, null);

            }
        }

        bottomBar.drawBottom(g);
        drawSelectedsTile(g);

    }

    private void drawSelectedsTile(Graphics g) {
        g.drawImage(selectedTile.sprite, selectedTile.x, selectedTile.y, null);
    }
    

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {

        bottomBar.grassButton.setMouseOver(false);
        bottomBar.waterButton.setMouseOver(false);
        bottomBar.rockButton.setMouseOver(false);

        if (bottomBar.grassButton.bounds.contains(x, y)) {
            bottomBar.grassButton.setMouseOver(true);
        }
        if (bottomBar.waterButton.bounds.contains(x, y)) {
            bottomBar.waterButton.setMouseOver(true);
        }
        if (bottomBar.rockButton.bounds.contains(x, y)) {
            bottomBar.rockButton.setMouseOver(true);
        }
        if (y < 640) {
            selectedTile.y = y;
            selectedTile.x = x;
        }

    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bottomBar.grassButton.bounds.contains(x, y)) {
            selectedTile.name = "GRASS";
            selectedTile.sprite = game.getTileManager().getSprite(2);

        }
        if (bottomBar.waterButton.bounds.contains(x, y)) {
            selectedTile.name = "WATER";
            selectedTile.sprite = game.getTileManager().getSprite(0);

        }
        if (bottomBar.rockButton.bounds.contains(x, y)) {
            selectedTile.name = "ROCK";
            selectedTile.sprite = game.getTileManager().getSprite(1);

        }
        if(y<640){
            map[(int)x/32][(int)y/32]=selectedTile.id;
            System.out.println("Scenes.MapBuilder.mouseClicked()");
        }
        
        


        
        

        

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
