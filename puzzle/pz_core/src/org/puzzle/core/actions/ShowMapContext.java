/*
 *    Puzzle GIS - Desktop GIS Platform
 *    http://puzzle-gis.codehaus.org
 *
 *    (C) 2007-2009, Johann Sorel
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 3 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.puzzle.core.actions;

import java.util.Collection;
import javax.swing.SwingUtilities;

import org.geotoolkit.map.MapContext;

import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.actions.CookieAction;

import org.puzzle.core.project.filetype.GISContextDataObject;
import org.puzzle.core.resources.CoreResource;
import org.puzzle.core.view.RendererChooser;
import org.puzzle.core.view.RenderingService;

/**
 * An action allowing the user to display a context in a map.
 * 
 * @author  Johann Sorel (Puzzle-GIS)
 * @author  Thomas Bonavia (comments)
 * 
 * @see     org.openide.util.actions.CookieAction
 */
public final class ShowMapContext extends CookieAction {

    /**
     * Method called when this action is clicked.<br>
     * This method displays the first activated context node in a map.
     * @param   activatedNodes  The currently activated nodes.
     */
    @Override
    protected void performAction(final Node[] activatedNodes) {
        if(activatedNodes.length == 0 ) return ;
        
        final GISContextDataObject dataObject = activatedNodes[0].getLookup().lookup(GISContextDataObject.class);

        if(dataObject == null) return;

        new Thread(){
            @Override
            public void run(){
                final MapContext context = dataObject.getContext();

                final ProgressHandle handle = ProgressHandleFactory.createHandle(
                        CoreResource.getString("createView") +" : " + context.getDescription().getTitle().toString());
                handle.start(100);
                handle.setInitialDelay(1);
                handle.switchToIndeterminate();

                try{
                    if(context != null){
                        final Collection<? extends RenderingService> services = Lookup.getDefault().lookupAll(RenderingService.class);

                        if(services.isEmpty()){
                            return;
                        }else if(services.size() == 1){
                            //only one service, dont show the renderer chooser
                            SwingUtilities.invokeLater(new Runnable() {

                                @Override
                                public void run() {
                                    dataObject.createView(services.iterator().next());
                                }
                            });

                        }else{

                            SwingUtilities.invokeLater(new Runnable() {

                                @Override
                                public void run() {
                                    final RendererChooser rc = new RendererChooser();
                                    rc.showChooserDialog();
                                    dataObject.createView(rc.getSelectedService());
                                }
                            });

                        }

                    }
                }finally{
                    handle.finish();
                }

            }
        }.start();

    }


    /**
     * Specify the enable mode of the action.<br>
     * This one is enable when only one node is selected.
     * @return  An {@code int} containing the mode.
     */
    @Override
    protected int mode() {
        return CookieAction.MODE_EXACTLY_ONE;
    }

    /**
     * Get the name of the action.
     * @return  A {@code String} containing the Action's name.
     */
    @Override
    public String getName() {
        return CoreResource.getString("showMap");
    }

    /**
     * Defines the cookies needed for the action to be enable. The activated
     * node must contain a {@code GISContextDataObject} to be enabled.
     * @return  A set of {@code Class}es.
     */
    @Override
    protected Class[] cookieClasses() {
        return new Class[]{GISContextDataObject.class};
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String iconResource() {
        return "org/puzzle/core/actions/showMap.png";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected boolean asynchronous() {
        return false;
    }
}

