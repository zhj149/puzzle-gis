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
package org.puzzle.pending.swing.toolbox.widgettool.svg2mif.element;

import java.io.PrintStream;

import javax.swing.JOptionPane;

public class MessageErreur extends PrintStream {
	
	   public String MessageErreur;
	    
	    public MessageErreur(PrintStream ps) {
			super (ps);
	    }
				
		public void write(byte buf[], int off, int len) {
			try {
				if (len != 0) {
					MessageErreur += new String(buf);
				} else {
					JOptionPane.showMessageDialog(null, MessageErreur);
				}			
			} catch (Exception e) {
				e.printStackTrace();
				setError();
			}
			super.write(buf, off, len);
		}

}
