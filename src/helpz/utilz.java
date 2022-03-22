/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpz;

import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class utilz {
    
    public static int[] convert2DTo1D(int[][] twoD){
        int[] oneDArray;
        oneDArray= new int[TheMap.map().length*TheMap.map()[0].length];
        for(int x=0;x<twoD.length;x++){
            for(int j=0;j<twoD[0].length; j++){
                oneDArray[x*TheMap.map()[0].length+j]=twoD[x][j];
            }
        }
        return oneDArray;
        
    }
    public static int [][] oneDto2D(int[] oneDArray){
        int [][] twoD= new int[20][20];
        int index;
        for(int i=0; i<TheMap.map().length;i++){
            for( int j=0; j<TheMap.map()[0].length; j++){
                index=i*TheMap.map()[0].length+j;
                TheMap.map()[i][j]=oneDArray[index];
                
            }
        }
        return twoD;
        
    }
    

}
