/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.puzzle.puzzlecore.project.action;

import javax.swing.JOptionPane;
import org.geotools.map.MapContext;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;
import org.puzzle.puzzlecore.context.ContextService;
import org.puzzle.puzzlecore.project.filetype.GISContextDataObject;
import org.puzzle.puzzlecore.view.MapView;
import org.puzzle.puzzlecore.view.RenderingService;
import org.puzzle.puzzlecore.view.ViewService;

public final class ShowMapContextAction extends CookieAction {

    protected void performAction(Node[] activatedNodes) {
        GISContextDataObject dataObject = activatedNodes[0].getLookup().lookup(GISContextDataObject.class);
    
        MapContext context = dataObject.getContext();        
        ContextService contextService = Lookup.getDefault().lookup(ContextService.class);
        contextService.addContext(context);
        
        RenderingService renderingService = Lookup.getDefault().lookup(RenderingService.class);
        MapView view = renderingService.createView(context);
        
        ViewService viewService = Lookup.getDefault().lookup(ViewService.class);
        viewService.add(view);
        
        
//        JOptionPane.showMessageDialog(null, "hahaha");
        
    }

    
    
    
    protected int mode() {
        return CookieAction.MODE_EXACTLY_ONE;
    }

    public String getName() {
        return NbBundle.getMessage(ShowMapContextAction.class, "CTL_ShowMapContextAction");
    }

    protected Class[] cookieClasses() {
        return new Class[]{GISContextDataObject.class};
    }

    @Override
    protected String iconResource() {
        return "org/puzzle/puzzlecore/project/action/demo.png";
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
}
