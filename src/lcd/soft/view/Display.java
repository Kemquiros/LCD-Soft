/*
    October 28th, 2016
    Author: John Tapias
    This file is part of LCD-Soft.

    LCD-Soft is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 3 as published by
    the Free Software Foundation.

    LCD-Soft is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with LCD-Soft.  If not, see <http://www.gnu.org/licenses/>.
 */
package lcd.soft.view;

import java.util.Arrays;

/**
 *
 * This class shows numbers in console
 * You can program another view, for example JPanel or HTML
 */
public class Display {
    int row,col,size;
    String[][] screen;
    
    /*Builder
    size: Display size
    numbers: How many numbers in pattern
    */
    public Display(int size,int numbers){
        this.size =size;
        row =(size*2)+3;
        col = size+2;//This is for a single number
        col *=numbers;//Reply grid
        col +=numbers-1;//Add blank spaces between numbers
        
        screen = new String[row][col];
        
        for(int i=0;i<row;i++){
            Arrays.fill(screen[i], " ");//Initializing
        }
    }
    
    //For example: pattern="15873"
    //numberId is the number position in pattern
    //Number 7 has 4th position in pattern
    public void draw(int numberId,int ledId){
        int initCol=(size+2);//Single number width;
        initCol+=1;//Blank space
        initCol*=numberId-1;//Replay grid
        
        if(ledId==0 || ledId==3 || ledId == 6){
            /*
            tempRow: For example if we have size=2 and ledId=3
            tempRow=3
            */
            int tempRow = (size*(ledId/3)) + (ledId/3) ;
            
            for(int i=0;i<size;i++){                
                screen[tempRow][i+1+initCol]="-";
            }                
        }else{
            switch(ledId){ 
                case 1:
                    for(int i=0;i<size;i++){
                        screen[i+1][initCol]="|";
                    }
                    break;
                case 2:
                    for(int i=0;i<size;i++){
                        screen[i+1][initCol+size]="|";
                    }
                    break;
                case 4:
                    for(int i=0;i<size;i++){
                        screen[i+size+2][initCol]="|";
                    }                    
                    break;
                case 5:
                    for(int i=0;i<size;i++){
                        screen[i+size+2][initCol+size]="|";
                    }
                    break;
                default:
                    break;
            }
        }
  
    }
            
    public void printScreen(){        
        for(int i=0;i<row;i++){
            System.out.print("\n");//New line
            for(int j=0;j<col;j++){
                System.out.print(screen[i][j]);
            }
        }
        System.out.println("");
    }
    
}
