/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.puzzle.puzzlecore.gui.views;

import java.awt.BorderLayout;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import org.geotools.gui.swing.map.map2d.JDefaultEditableMap2D;
import org.geotools.map.MapContext;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.Utilities;
import org.puzzle.puzzlecore.gtextend.widget.viewtree.JViewTree;
import org.puzzle.puzzlecore.struct.CORE;
import org.puzzle.puzzlecore.struct.MapGroup;
import org.puzzle.puzzlecore.struct.MapView;

/**
 * Top component which displays something.
 */
final class ViewTreeTopComponent extends TopComponent {

        
    
    private static ViewTreeTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";

    private static final String PREFERRED_ID = "ViewTreeTopComponent";

    private ViewTreeTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ViewTreeTopComponent.class, "CTL_ViewTreeTopComponent"));
        setToolTipText(NbBundle.getMessage(ViewTreeTopComponent.class, "HINT_ViewTreeTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));
        
        
        add(BorderLayout.CENTER,new JScrollPane(new JViewTree()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        guiNewGroup = new javax.swing.JButton();
        guiNewView = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        guiNewGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/puzzlecore/gtextend/widget/iconset/group_add.png"))); // NOI18N
        guiNewGroup.setFocusable(false);
        guiNewGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guiNewGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guiNewGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiNewGroupActionPerformed(evt);
            }
        });
        jToolBar1.add(guiNewGroup);

        guiNewView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/puzzlecore/actions/views/view_add.png"))); // NOI18N
        guiNewView.setFocusable(false);
        guiNewView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guiNewView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guiNewView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiNewViewActionPerformed(evt);
            }
        });
        jToolBar1.add(guiNewView);

        add(jToolBar1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void guiNewViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiNewViewActionPerformed
        MapView view = new MapView(new JDefaultEditableMap2D());
        view.setName("2D view");

        MapContext context = CORE.getContextManager().getActiveContext();
        view.getMap().getRenderingStrategy().setContext(context);

        CORE.getViewManager().addView(view);

        view.open();
        view.requestActive();
    }//GEN-LAST:event_guiNewViewActionPerformed

    private void guiNewGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiNewGroupActionPerformed
        MapGroup group = new MapGroup();
        group.setTitle("2D view");

        CORE.getViewManager().addGroup(group);

    }//GEN-LAST:event_guiNewGroupActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guiNewGroup;
    private javax.swing.JButton guiNewView;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized ViewTreeTopComponent getDefault() {
        if (instance == null) {
            instance = new ViewTreeTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the ViewTreeTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ViewTreeTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(ViewTreeTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ViewTreeTopComponent) {
            return (ViewTreeTopComponent) win;
        }
        Logger.getLogger(ViewTreeTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
    // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
    // TODO add custom code on component closing
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return ViewTreeTopComponent.getDefault();
        }
    }
}
