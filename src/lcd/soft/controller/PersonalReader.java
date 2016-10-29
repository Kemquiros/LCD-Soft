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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * This class reads from console
 */
public class PersonalReader {
    
    private static int size;
    private static String pattern;
    private static final int maxLenPatt=10;//We can define the max length
    private static int errorCode;
    private static BufferedReader br; 
    private static final PersonalError pe = new PersonalError();
    
    
    public PersonalReader(){
        size=0;
        pattern="";
        errorCode=0;
    }
    public PersonalReader(InputStreamReader ir){
        size=0;
        pattern="";
        errorCode=0;
        br = new BufferedReader(ir);
    }
    public PersonalReader(FileReader fr){
        size=0;
        pattern="";
        errorCode=0;
        br = new BufferedReader(fr);

    }

    
    /*
    Return 0: Error
    Return 1: Ok
    Return 2: Finished
    */
    public int read(String s) throws IOException{
        //Read from console and also omit leading and trailing whitespace
        String temp = s.trim();
        //Separate inputs using regular expresion: comma
        String[] temp1 = temp.split(",");
        
        //------------------------------------------
        //If arguments are different than 2 elements
        errorCode = (temp1.length != 2) ? 1:0;
        pe.manageError(errorCode);
        if (errorCode !=0) return 0;
        //-------------------------------------------
        
        //-------------------------------------------
        //If size is too long
        errorCode = (temp1[1].length()>maxLenPatt) ? 3:0;
        pe.manageError(errorCode);
        if (errorCode !=0) return 0;
        //-------------------------------------------
        
        
        //-------------------------------------------
        //If arguments aren't positive integer numbers
        if(isPositiveInteger(temp1[0]) && isPositiveInteger(temp1[1])){
            size=Integer.parseInt(temp1[0].trim());
            pattern=temp1[1].trim();
        }
        else{
            errorCode = 4;
        }        
        pe.manageError(errorCode);
        if (errorCode !=0) return 0;
        //-------------------------------------------
        
        //-------------------------------------------
        //Finish program       
        if(size==0 && Integer.parseInt(pattern)==0){
            return 2;//Finish the program
        }
        //-------------------------------------------
        
        //-------------------------------------------
        //If size isn't a number between 1 to 10
        errorCode = (size<1 || size>10) ? 2:0;
        pe.manageError(errorCode);
        if (errorCode !=0) return 0;
        //-------------------------------------------
        

        
        return 1;//Everything is fine
        
    }
    
   
    

    
    public boolean isPositiveInteger(String input){
        try{
            return Integer.parseInt(input.trim())>=0;            
        }catch(NumberFormatException ex){
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public  void setSize(int size) {
        PersonalReader.size = size;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        PersonalReader.pattern = pattern;
    }

    public static int getErrorCode() {
        return errorCode;
    }

    public static void setErrorCode(int errorCode) {
        PersonalReader.errorCode = errorCode;
    }

    public static BufferedReader getBr() {
        return br;
    }
    
    
    
    
}
