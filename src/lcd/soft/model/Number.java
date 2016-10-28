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
package lcd.soft.model;
import java.util.Arrays;

/**
 *
 * This class stores the canonical numbers
 * 
 */
public class Number {
    //We have 10 numbers (0 to 9)
    //Each number has seven positions on LCD displays (0 to 6)
    /*
    (p0)
    _ __ __
    |      |
    (p1)|      |(p2)
    | (p3) |  
    __ __ __
    |      |
    (p4)|      | (p5)
    |      |
    __ __ __
    (p6)
     */
    /*--------------------------
    |Position| 6 5 4 3 2 1 0  |
    ---------------------------
    |Number  |                |
    |   0    | 1 1 1 0 1 1 1  |
    |   1    | 0 1 0 0 1 0 0  |
    |   2    | 1 0 1 1 1 0 1  |
    |   3    | 1 1 0 1 1 0 1  |
    |   4    | 0 1 0 1 1 1 0  |
    |   5    | 1 1 0 1 0 1 1  |
    |   6    | 1 1 1 1 0 1 1  |
    |   7    | 0 1 0 0 1 0 1  |
    |   8    | 1 1 1 1 1 1 1  |
    |   9    | 0 1 0 1 1 1 1  |
    --------------------------
    As we can see every number has a lcd position representation
    Every lcd position representation is a binary sequence
    And binary sequence has a decimal representation
    ------------------------------------
    |Position| 6 5 4 3 2 1 0  | Decimal |
    ------------------------------------
    |Number  |                |         |
    |   0    | 1 1 1 0 1 1 1  |  119    |  
    |   1    | 0 1 0 0 1 0 0  |   36    |
    |   2    | 1 0 1 1 1 0 1  |   93    |
    |   3    | 1 1 0 1 1 0 1  |  109    |
    |   4    | 0 1 0 1 1 1 0  |   46    |
    |   5    | 1 1 0 1 0 1 1  |  107    |
    |   6    | 1 1 1 1 0 1 1  |  123    |
    |   7    | 0 1 0 0 1 0 1  |   37    |
    |   8    | 1 1 1 1 1 1 1  |  127    |
    |   9    | 0 1 0 1 1 1 1  |   47    |
    ------------------------------------
     */
    //----------------------
    //     Variables zone
    //----------------------
    //We don't use integer because Integer data type occupy 32 bits in memory
    //In another hand Byte data type occupy 8 bits in memory
    //We'll save memory :D
    //-------------------
    
    //We won't modify it anymore
    private final byte[] n;
    
    //Constructor
    public Number(){
        //We have 10 numbers
        this.n = new byte[10];
        //Initializing in 0
        Arrays.fill(n, (byte)0);
        
        n[0] = (byte)119;
        n[1] = (byte)36;
        n[2] = (byte)93;
        n[3] = (byte)109;
        n[4] = (byte)46;
        n[5] = (byte)107;
        n[6] = (byte)123;
        n[7] = (byte)37;
        n[8] = (byte)127;
        n[9] = (byte)47;        
    }
    
    //Getters and setters

    public byte[] getList() {
        return n;
    }
    
    public byte getNumber(int index){
        return n[index];
    }
    public boolean getBit(int index,int bit){
        //We make AND operator between right shift and 1
         return ((n[index]>>bit & 1)==1);
    }
    
}
