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
package lcd.soft.controller;

import java.io.IOException;
import lcd.soft.model.*;
import lcd.soft.view.*;

/**
 *
 * This class manages the program behavior
 * 
 */
public class LCDSoft {

    static PersonalReader pr;
    static PersonalNumbers n;
    static Display disp;
    
    
    public static void main(String[] args) throws IOException {
        pr =new PersonalReader();
        n= new PersonalNumbers();
        int code;
        /*
        pr.read() returns
        0: Error
        1: Ok
        2: Program finished
        */
        do{
            code=pr.read();
        
            if(code== 1){//Program displays number if there's no error
               disp = new Display(pr.getSize(), pr.getPattern().length());
               //For each number in pattern
               int numberId=1;
                for(char c :pr.getPattern().toCharArray()){
                    if (Character.isDigit(c)) {
                       for(int bit=0;bit<=6;bit++){
                            if(n.getBit(Character.getNumericValue(c), bit)){
                                disp.draw(numberId, bit);
                            }
                        }
                    } 
                    numberId++;
                }
                disp.printScreen();
            }
           
        }while( code != 2);

    }
    
}
