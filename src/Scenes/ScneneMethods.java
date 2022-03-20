/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenes;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author anton
 */
public interface ScneneMethods {
    public void render(Graphics g);
    
    public void mouseDragged(int x, int y);
        

    

   
    public void mouseMoved(int x, int y);

    
    public void mouseClicked(int x, int y) ;

    
    public void mousePressed(int x, int y);

    
    public void mouseReleased(int x, int y);
}
