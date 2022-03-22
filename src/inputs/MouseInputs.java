/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputs;

import PlatformGame.Game;
import PlatformGame.GameState;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author anton
 */
public class MouseInputs implements MouseListener, MouseMotionListener {

    Game game;

    public MouseInputs(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (GameState.gameState) {

            case MENU:

                game.getMenu().mouseClicked(e.getX(), e.getY());

                break;
            case PLAYING:

                break;
            case SETTINGS:

                break;
            case MAPBULDER:
                game.getMapBuilder().mouseClicked(e.getX(), e.getY());
                
                break;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (GameState.gameState) {

            case MENU:
                

                break;
            case PLAYING:

                break;
            case SETTINGS:

                break;
            case MAPBULDER:
                game.getMapBuilder().mouseDragged(e.getX(), e.getY());
                break;

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameState.gameState) {

            case MENU:
                
                game.getMenu().mouseMoved(e.getX(), e.getY());

                break;
            case PLAYING:

                break;
            case SETTINGS:

                break;
            case MAPBULDER:
                game.getMapBuilder().mouseMoved(e.getX(), e.getY());
                break;

        }
    }

        
    }
