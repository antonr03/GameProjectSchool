/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author anton
 */
public class Button{
    private int x,y,width,height;
    private String name;
    public Rectangle bounds;
    Color color=Color.white;
    
    private boolean mouseOver;
    private BufferedImage img;
    public Button(int x, int y,int width,int height,String name){
        
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.name= name;
        bounds= new Rectangle(x,y,width,height);
    }
    public Button(int x, int y,int width,int height,String name, BufferedImage img){
        
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.name= name;
        this.img=img;
        bounds= new Rectangle(x,y,width,height);
    }
    

    public void drawButton(Graphics g ){
        
        
        
        drawBody(g);
        drawEdges(g);
        
        drawText(g);
    }
    public void drawImgButton(Graphics g){
        drawEdges(g);

        g.drawImage(img, x,y,width,height,null);


        
        
    }
    private void drawEdges(Graphics g){
        
        g.setColor(Color.black);
        if(mouseOver){
            g.drawRect(x-1, y-1, width+2, height+2);
        }
        
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        
    }
    private void drawBody(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);

    }
    private void drawText(Graphics g){
        int w = g.getFontMetrics().stringWidth(name);
        int h = g.getFontMetrics().getHeight();
        g.drawString(name, x+width/2-w/2, y+h/2+height/2);
        
    }
    
    public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}
    public boolean isMouseOver(){
            if(mouseOver)return true;
            else return false;
        }
    public void resetBooleans() {
		this.mouseOver = false;

	}
    public void setColor(Color color){
        this.color= color;

    }
    
}
