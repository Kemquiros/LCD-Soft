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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import lcd.soft.controller.PersonalReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PersonalReaderTest {
    PersonalReader pr;

    @Test
    public void builder()  {
        pr= new PersonalReader();
        assertEquals("PersonalReader.size",0,pr.getSize());
        assertTrue("PersonalReader.pattern",pr.getPattern().isEmpty());
        assertEquals("PersonalReader.errorCode",0, pr.getErrorCode());        
    }
    @Test 
    public void read() throws IOException{
       pr= new PersonalReader();
       assertEquals("Error code", 1,pr.read("2, 12345"));
       assertEquals("Error code", 1,pr.read(" 3 , 678 "));
       assertEquals("Error code", 0,pr.read("0,45"));
       assertEquals("Error code", 0,pr.read("11,6"));
       assertEquals("Error code", 0,pr.read("6"));
       assertEquals("Error code", 0,pr.read("4,01234567890123"));
       assertEquals("Error code", 0,pr.read("xxxz"));
       assertEquals("Error code", 0,pr.read("5, xxxz"));
       assertEquals("Error code", 0,pr.read("1,-2"));
       assertEquals("Error code", 2,pr.read("0,0"));
    }
    @Test 
    public void readFromFile() throws IOException{       
       pr= new PersonalReader();

       File f = new File("test/InputText.txt");
       if(!f.exists()){
           System.err.println("File doesn't exist");
       }else if (!f.canRead()){
           System.err.println("We can't read file");            
       }else{
           pr = new PersonalReader(new FileReader(f));
       }
       
       assertEquals("Error code", 1,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 1,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 0,pr.read(pr.getBr().readLine()));
       assertEquals("Error code", 2,pr.read(pr.getBr().readLine()));
    }    
}
