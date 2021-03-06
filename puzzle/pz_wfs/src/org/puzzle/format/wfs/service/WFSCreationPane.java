/*
 *    Puzzle GIS - Desktop GIS Platform
 *    http://puzzle-gis.codehaus.org
 *
 *    (C) 2010, Johann Sorel
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
package org.puzzle.format.wfs.service;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.geotoolkit.data.DataStore;
import org.geotoolkit.data.wfs.WFSDataStore;

import org.openide.util.Exceptions;

import org.puzzle.core.project.source.GISSourceInfo;
import org.puzzle.format.AbstractDataStoreCreationPane;
import org.puzzle.format.wfs.resources.WFSResource;

/**
 * WFS Chooser.
 * 
 * @author Johann Sorel (Puzzle-GIS)
 */
public class WFSCreationPane extends AbstractDataStoreCreationPane {

    public WFSCreationPane() {
        Component comp = getComponent(0);
        initComponents();
        add(BorderLayout.CENTER,comp);

        jtf_url.setText("http://...");
        jtf_version.setText("1.1.0");
        jtf_name.setText("server name");
    }

    @Override
    public Map<String,GISSourceInfo> createSources() {
        final Map<String,Serializable> params = new HashMap<String,Serializable>();
        params.put(WFSSourceService.URL_PROP, jtf_url.getText());
        final GISSourceInfo info = new GISSourceInfo(-1, WFSSourceService.SERVICE_ID, params);
        final Map<String,GISSourceInfo> sources = new HashMap<String, GISSourceInfo>();

        String name = jtf_name.getText();
        if(name.trim().isEmpty()){
            name = "noname";
        }

        sources.put(name, info);
        return sources;
    }

    @Override
    protected JComponent createConfigurationPane() {
        return guiConfigPane;
    }

    @Override
    protected DataStore createDataStore() {
        try {
            URL url = new URL(jtf_url.getText());
            return new WFSDataStore(url.toURI());
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {




        guiConfigPane = new JPanel();
        jtf_version = new JTextField();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jtf_url = new JTextField();
        jLabel3 = new JLabel();
        jtf_name = new JTextField();

        jLabel2.setText(WFSResource.getString("version")); // NOI18N
        jLabel1.setText(WFSResource.getString("url")); // NOI18N
        jLabel3.setText(WFSResource.getString("name")); // NOI18N
        GroupLayout guiConfigPaneLayout = new GroupLayout(guiConfigPane);
        guiConfigPane.setLayout(guiConfigPaneLayout);
        guiConfigPaneLayout.setHorizontalGroup(
            guiConfigPaneLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(guiConfigPaneLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(guiConfigPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(guiConfigPaneLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(guiConfigPaneLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(jtf_url, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                        .addGroup(guiConfigPaneLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(jtf_version, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                        .addGroup(guiConfigPaneLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(jtf_name, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        guiConfigPaneLayout.setVerticalGroup(
            guiConfigPaneLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(guiConfigPaneLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(guiConfigPaneLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(guiConfigPaneLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jtf_url, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(guiConfigPaneLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtf_version, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(guiConfigPaneLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jtf_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        setLayout(new BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel guiConfigPane;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jtf_name;
    private JTextField jtf_url;
    private JTextField jtf_version;
    // End of variables declaration//GEN-END:variables
    
}
