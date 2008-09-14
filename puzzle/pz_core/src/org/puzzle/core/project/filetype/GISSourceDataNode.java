/*
 *  Puzzle-GIS - OpenSource mapping program
 *  http://docs.codehaus.org/display/PUZZLEGIS
 *  Copyright (C) 2007 Puzzle-GIS
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
package org.puzzle.core.project.filetype;

import java.awt.Image;
import java.io.IOException;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.nodes.Children;
import org.openide.util.Lookup;

/**
 * This classe provides a {@code org.openide.loaders.DataNode} for the
 * {@link GISSourceDataObject}.
 * 
 * @author  Johann Sorel
 * @author  Thomas Bonavia (comments)
 * 
 * @see     org.openide.loaders.DataNode
 */
public class GISSourceDataNode extends DataNode {

    private static final String IMAGE_ICON_BASE = "org/puzzle/core/project/filetype/signal-1.png";
    
    /**
     * Constructor.<br>
     * Creates the node from the {@code GISContextDataObject}.
     * @param obj   The {@code GISContextDataObject} used.
     */
    public GISSourceDataNode(GISSourceDataObject obj) {
        super(obj, Children.LEAF);
        setIconBaseWithExtension(IMAGE_ICON_BASE);
        
    }
    
    @Override
    public String getHtmlDisplayName() {
        String str = super.getHtmlDisplayName();
        if(str != null) str = str.replaceAll(".xml", "");
        return str;
    }

    @Override
    public Image getIcon(int arg0) {
        Image img = null;
        if(getDataObject() != null && getDataObject() instanceof GISSourceDataObject){
            GISSourceDataObject data = getDataObject();
            if(data.getSource() != null){
                img = data.getSource().getIcon(arg0);
            }
        }
        if(img != null) return img;
        return super.getIcon(arg0);
    }

    @Override
    public GISSourceDataObject getDataObject() {
        return (GISSourceDataObject) super.getDataObject();
    }

    
    
    @Override
    public void destroy() throws IOException {
        getDataObject().dispose();
        super.destroy();
    }

    
    
    @Override
    public String getDisplayName() {
        String str = super.getDisplayName();
        if(str != null) str = str.replaceAll(".xml", "");
        return str;
    }
    
    GISSourceDataNode(GISSourceDataObject obj, Lookup lookup) {
        super(obj, Children.LEAF, lookup);
        setIconBaseWithExtension(IMAGE_ICON_BASE);
    }
    
//    /** Creates a property sheet. */
//    @Override
//    protected Sheet createSheet() {
//        Sheet s = super.createSheet();
//        Sheet.Set ss = s.get(Sheet.PROPERTIES);
//        if (ss == null) {
//            ss = Sheet.createPropertiesSet();
//            s.put(ss);
//        }
//        // TODO add some relevant properties: ss.put(...)
//        return s;
//    }
}