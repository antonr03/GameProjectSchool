/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlatformGame;

/**
 *
 * @author anton
 */
public enum GameState {
    
    MENU,SETTINGS,PLAYING,MAPBULDER;
    public static GameState gameState = MENU;
    public static void setGameState(GameState state){
        gameState=state;
    }
   

    
}
