/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.puzzle.puzzlecore.project.filetype;

import org.openide.loaders.DataNode;
import org.openide.nodes.Children;
import org.openide.util.Lookup;

public class GISContextDataNode extends DataNode {

    private static final String IMAGE_ICON_BASE = "org/puzzle/puzzlecore/project/filetype/locale.png";

    public GISContextDataNode(GISContextDataObject obj) {
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
    public String getDisplayName() {
        String str = super.getDisplayName();
        if(str != null) str = str.replaceAll(".xml", "");
        return str;
    }
    
    
    
    
    GISContextDataNode(GISContextDataObject obj, Lookup lookup) {
        super(obj, Children.LEAF, lookup);
        setIconBaseWithExtension(IMAGE_ICON_BASE);
    }//    /** Creates a property sheet. */
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
