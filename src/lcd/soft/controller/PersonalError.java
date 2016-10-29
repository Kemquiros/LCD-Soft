/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcd.soft.controller;

/**
 *
 * This class implements Error codes
 */
public class PersonalError implements IError{

    @Override
    public void manageError(int error) {
        /*
        Code 0: There's no error
        Code 1: There's more or less than 2 arguments
        Code 2: Size is different to range 1 to 10
        Code 3: Number is too big
        Code 4: Size and Number variables should be positive integer numbers
        */
        switch(error){
            case 0:
                break;
            case 1:
                printMessage("Correct usage:\n>>N1,N2\nNo more or less than two arguments separated by comma");
                break;
            case 2:
                printMessage("Correct usage:\n>>N1,N2\nWhere N1 is a number between 1 to 10, corresponding to size display"); 
                break;
            case 3:
                //We can evade overflows
                printMessage("Correct usage:\n>>N1,N2\nN2 is too long");
                break;
            case 4:
                printMessage("Correct usage:\n>>N1,N2\nWhere N1 and N2 should be positive integer numbers");
                break;
        }
        
    }
    private void printMessage(String s){
        System.err.println("----------------------------------------");
        System.err.println(s);
        System.err.println("----------------------------------------");
        
    
    }
    
}
