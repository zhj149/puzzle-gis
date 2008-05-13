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

package org.puzzle.shell.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.explorer.propertysheet.PropertySheet;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.puzzle.puzzlecore.tool.ToolDescriptor;
import org.puzzle.shell.misc.runtime.JRuntimePanel;
import org.puzzle.shell.misc.runtime.ProcessEventListener;
import org.puzzle.shell.misc.runtime.ProcessObject;


/**
 *
 * @author johann sorel
 */
public class ShellToolPane extends javax.swing.JPanel implements PropertyChangeListener,ToolDescriptor{

    private final PropertySheet propertySheet = new PropertySheet();
    private ShellBean bean;
    
    /** Creates new form DefaultShellToolPane */
    public ShellToolPane() {
        initComponents();
        
        panBean.setLayout(new BorderLayout());
        panBean.add(BorderLayout.CENTER,propertySheet);
        
        panDOS.setLayout(new BorderLayout());        
    }

    public void setBean(ShellBean bean){
        
        if(this.bean != null){
            this.bean.removePropertyChangeListener(ShellBean.PROP_COMMAND,this);
        }
        
        this.bean = bean;
        
        if(this.bean != null){
            this.bean.addPropertyChangeListener(ShellBean.PROP_COMMAND,this);
        }
        
        
        
        Node node = null;
        try {
            node = new BeanNode<ShellBean>(bean);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        if(node != null){
            propertySheet.setNodes(new Node[]{node});
//            try {
//                propertySheet.setSortingMode(propertySheet.SORTED_BY_NAMES);
//            } catch (PropertyVetoException ex) {
//                Exceptions.printStackTrace(ex);
//            }
        }else{
            propertySheet.setNodes(new Node[]{});
        }
        
        
    }
    
    public ShellBean getBean(){
        return bean;
    }
    
    public void propertyChange(PropertyChangeEvent evt) {        
        String command =  (String) ((evt.getNewValue() == null) ? "" : evt.getNewValue());
        guiCommand.setText(command);
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        guiExec = new javax.swing.JButton();
        panBean = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        guiCommand = new javax.swing.JTextArea();
        panDOS = new javax.swing.JPanel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setDividerSize(8);

        jPanel1.setLayout(new java.awt.BorderLayout());

        guiExec.setFont(guiExec.getFont().deriveFont(guiExec.getFont().getStyle() | java.awt.Font.BOLD));
        guiExec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/shell/gui/runprog.png"))); // NOI18N
        guiExec.setText(org.openide.util.NbBundle.getMessage(ShellToolPane.class, "exec")); // NOI18N
        guiExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiExecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(guiExec)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guiExec)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout panBeanLayout = new javax.swing.GroupLayout(panBean);
        panBean.setLayout(panBeanLayout);
        panBeanLayout.setHorizontalGroup(
            panBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panBeanLayout.setVerticalGroup(
            panBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        jPanel1.add(panBean, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/shell/gui/fileexport.png"))); // NOI18N
        jButton1.setText(org.openide.util.NbBundle.getMessage(ShellToolPane.class, "ShellToolPane.jButton1.text")); // NOI18N
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/shell/gui/fileopen.png"))); // NOI18N
        jButton2.setText(org.openide.util.NbBundle.getMessage(ShellToolPane.class, "ShellToolPane.jButton2.text")); // NOI18N
        jButton2.setEnabled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jSplitPane1.setLeftComponent(jPanel1);

        jSplitPane2.setBorder(null);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane1.setBorder(null);

        guiCommand.setBackground(new java.awt.Color(0, 0, 0));
        guiCommand.setColumns(20);
        guiCommand.setEditable(false);
        guiCommand.setForeground(new java.awt.Color(255, 255, 255));
        guiCommand.setLineWrap(true);
        guiCommand.setRows(3);
        guiCommand.setBorder(null);
        jScrollPane1.setViewportView(guiCommand);

        jSplitPane2.setTopComponent(jScrollPane1);

        panDOS.setBackground(new java.awt.Color(0, 0, 0));
        panDOS.setLayout(new java.awt.GridLayout(1, 1));
        jSplitPane2.setBottomComponent(panDOS);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void guiExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiExecActionPerformed
    
    if(bean != null){
        ProcessObject process = bean.createProcess();    
        JRuntimePanel runtime = new JRuntimePanel(process, JRuntimePanel.TYPE.LISTEN_BOTH);
        guiExec.setEnabled(false);
        
        panDOS.removeAll();
        panDOS.add(BorderLayout.CENTER,runtime);     
        panDOS.revalidate();
        panDOS.repaint();
        process.start();
        
        process.addProcessEventListener(new ProcessEventListener() {

                public void processStarted(ProcessObject obj) {
                }

                public void processStateUpdated(ProcessObject obj, String in, String out) {
                }

                public void processStopped(ProcessObject obj) {
                    
                    guiExec.setEnabled(true);
                }
            });
    }
    
}//GEN-LAST:event_guiExecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea guiCommand;
    private javax.swing.JButton guiExec;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panBean;
    private javax.swing.JPanel panDOS;
    // End of variables declaration//GEN-END:variables

    public String getTitle() {
        return bean.getTitle();
    }

    public String getDescription() {
        return bean.getDescription();
    }

    public String[] getPath() {
        return bean.getPath();
    }

    public String[] getKeyWords() {
        return bean.getKeyWords();
    }

    public String[] getCategories() {
        return bean.getCategories();
    }

    public Component getComponent() {
        return this;
    }

    public Image getIcon(int arg0) {
        return bean.getIcon(arg0);
    }



}
