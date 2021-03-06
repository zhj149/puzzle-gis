/*
 *  Puzzle-GIS - OpenSource mapping program
 *  http://docs.codehaus.org/display/PUZZLEGIS
 *  Copyright (C) 2007-2008 Puzzle-GIS
 *  
 *  GPLv3 + Classpath exception
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.puzzle.pending.swing.toolbox.widgettool.svg2mif.element.xml;
import java.util.Hashtable;
import java.util.StringTokenizer;
/**
 *
 * @author  Carmen Delessio 
 *          carmen@elementengine.com-
 */
public class Element {
    String tagName = null;
    String elementString = null;
    String value = null;
    int nestLevel = 0;
    Hashtable<String,String> requestedAttributes = new Hashtable<String,String>();
    
        /** Creates a new instance of element */
    public Element() {
    }
    public Element(String name, String elementValue, int nestLevelValue) {
        tagName = name;
        elementString = elementValue;
        nestLevel=nestLevelValue;
    }
    
    public String getTagName() {
        return tagName;
    }

    public int getNestLevel() {
        return nestLevel;
    }
    
    
    public String getValue() {
           if (value != null){
               return value;
           }else{
               int offset = elementString.indexOf(">"); 
               if ( offset > 0) {                 
                   int offset2 = elementString.indexOf("</");                    
                   if (offset2 > 0){
                       return (elementString.substring(offset+1, offset2));
                   }else{
                       value =  (elementString.substring(offset+1));
                   }
               }else{
                   value = elementString;
               }
           }
           return value;
    }

    
    public String getAttribute(String name) {
        if (requestedAttributes.containsKey(name)){
            return requestedAttributes.get(name);
        }

        int i;
        StringTokenizer t = new StringTokenizer(elementString, "\"=", true);
        int numTokens = t.countTokens();        
        String[] tokens = new String[numTokens];
        int numFixed = 0;        
        String[] fixedTokens = new String[numTokens];  // max will be same as numTokens
        // remove any extra white space tokens and leading spaces
        if (numTokens > 0){
            for (i = 0; i < numTokens; i++) {
                  tokens[i] = t.nextToken();
                  tokens[i] = tokens[i].replace('\n', ' ');  //suppress newline
                  tokens[i] = tokens[i].replace('\t', ' ');  // suppress tab
                  if (tokens[i].equals(" ")){                      
                          continue;  // with for loop
                  }
                  while((tokens[i].charAt(0) == ' ') ){   // remove leading space
                      tokens[i] = tokens[i].substring(1);
                      if (tokens[i].equals(" ")){                      
                          break;  // out of while
                   }
                  } // while spaces
                  int len = tokens[i].length();   // remove trailing spaces
                  while(tokens[i].charAt(len-1) == ' '){
                      tokens[i] = tokens[i].substring(0,len-1);
                          len--;
                  }                  
                  if (tokens[i].equals(" ")){
                    //System.out.println("blank token");                      
                  }else{
                      fixedTokens[numFixed] = tokens[i];
                      numFixed++;
                  }
            } // end for
            for (i = 0; i < numFixed; i++) {
                if (fixedTokens[i].equals(name)){
                             if (fixedTokens[i+1].equals("=") &&
                               fixedTokens[i+2].equals("\"") &&                      
                               fixedTokens[i+4].equals("\"")                       
                              ){
                               requestedAttributes.put(name, fixedTokens[i+3]);                              
                               return(fixedTokens[i+3]);
                         }else{
                             return("");
                         }
                      }
                     }  // for i
        } 
        return ("");  
    }// getAttribute
    
    
    public boolean hasAttribute(java.lang.String name) {
        String testValue = getAttribute(name);
        if (testValue != ""){
           requestedAttributes.put(name, testValue);
           return true;
        }else{
            return false;
        }
    }
    
    public String toString() {
        int i;
        String tabs = " ";
        String returnString;
        for (i=0; i < nestLevel; i++){
            tabs = tabs + "\t";
        }
        return tabs + tagName + " " +elementString ;
    }
    
}
