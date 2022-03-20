/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlatformGame;

import inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import ui.Button;

/**
 *
 * @author ant

/**
 *
 * @author anton
 */
class GameScreen extends JPanel{
    Dimension size;
    Game game;
    MouseInputs mouseInputs;

    

    public GameScreen(Game game){
        setPanelSize();
        initInputs(game);
        
    }
    public void setPanelSize() {
        size = new Dimension(640, 740);

        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        game.getRender().drawGame(g);
        
                


    }
    private void initInputs(Game game){
        this.game=game;
        mouseInputs=new MouseInputs(game);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    
}


