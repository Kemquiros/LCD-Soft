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

/**
 *
 * This class manages the program behavior
 * 
 */
public class LCDSoft {

    static PersonalReader pr;
    static Number n;
    public static void main(String[] args) {
        pr =new PersonalReader();
        /*
        pr.read() returns
        0: Error
        1: Ok
        2: Program finished
        */
    }
    
}
