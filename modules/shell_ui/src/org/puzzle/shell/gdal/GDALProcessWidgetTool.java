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
package org.puzzle.shell.gdal;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import org.puzzle.shell.misc.runtime.ProcessObject;
import org.puzzle.shell.misc.runtime.ProcessObjectPanel;
import org.puzzle.shell.misc.runtime.StatusListener;

/**
 *
 * @author johann sorel
 */
public class GDALProcessWidgetTool extends javax.swing.JPanel {

    private final ProcessObjectPanel guiProcessTable = new ProcessObjectPanel();
    private final GDALTool tool;

    /** Creates new form AbstractGDALProcessPanel */
    public GDALProcessWidgetTool(GDALTool tool) {
        this.tool = tool;        
        initComponents();
        es_pan_process.add(BorderLayout.CENTER,guiProcessTable);
        
        guiPanTool.add(BorderLayout.CENTER, this.tool.getComponent());

        guiProcessTable.addStatusListener(new StatusListener() {

            public void statusUpdated(STATUS stat) {
                if (stat.equals(STATUS.WORKING)) {
                    guiErase.setEnabled(false);
                    guiAddProcess.setEnabled(false);
                    guiStart.setEnabled(false);
                } else {
                    guiAddProcess.setEnabled(true);                    
                    guiErase.setEnabled(guiProcessTable.getProcessNumber() > 0);
                    guiStart.setEnabled(guiProcessTable.getProcessNumber() > 0);
                }
            }
            });



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        es_pan_process = new javax.swing.JPanel();
        guiErase = new javax.swing.JButton();
        guiStart = new javax.swing.JButton();
        guiPanTool = new javax.swing.JPanel();
        guiAddProcess = new javax.swing.JButton();

        es_pan_process.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(GDALProcessWidgetTool.class, "processes"))); // NOI18N
        es_pan_process.setPreferredSize(new java.awt.Dimension(100, 200));
        es_pan_process.setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/puzzle/shell/gdal/Bundle"); // NOI18N
        guiErase.setText(bundle.getString("erase")); // NOI18N
        guiErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiEraseesActionEffacer(evt);
            }
        });

        guiStart.setText(org.openide.util.NbBundle.getMessage(GDALProcessWidgetTool.class, "start")); // NOI18N
        guiStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiStartesActionDemarrer(evt);
            }
        });

        guiPanTool.setLayout(new java.awt.BorderLayout());

        guiAddProcess.setText(org.openide.util.NbBundle.getMessage(GDALProcessWidgetTool.class, "add")); // NOI18N
        guiAddProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiAddProcessesActionAjouter(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(es_pan_process, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(guiErase, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(guiStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .add(guiAddProcess)
                .addContainerGap())
            .add(guiPanTool, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        layout.linkSize(new java.awt.Component[] {guiAddProcess, guiErase, guiStart}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(guiPanTool, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(guiAddProcess)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(es_pan_process, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(guiStart)
                    .add(guiErase))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void guiEraseesActionEffacer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiEraseesActionEffacer
        guiProcessTable.empty();
        guiStart.setEnabled(guiProcessTable.getProcessNumber() > 0);
        guiErase.setEnabled(guiProcessTable.getProcessNumber() > 0);
}//GEN-LAST:event_guiEraseesActionEffacer

    private void guiStartesActionDemarrer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiStartesActionDemarrer
        guiProcessTable.start();
}//GEN-LAST:event_guiStartesActionDemarrer

    private void guiAddProcessesActionAjouter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiAddProcessesActionAjouter
        ProcessObject[] pos = tool.createProcesses();

        for (ProcessObject po : pos) {
            guiProcessTable.addProcess(po);
        }

        guiStart.setEnabled(guiProcessTable.getProcessNumber() > 0);
        guiErase.setEnabled(guiProcessTable.getProcessNumber() > 0);
               
}//GEN-LAST:event_guiAddProcessesActionAjouter
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel es_pan_process;
    private javax.swing.JButton guiAddProcess;
    private javax.swing.JButton guiErase;
    private javax.swing.JPanel guiPanTool;
    private javax.swing.JButton guiStart;
    // End of variables declaration//GEN-END:variables

    public JComponent getComponent() {
        return this;
    }
}
