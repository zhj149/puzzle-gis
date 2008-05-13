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

package org.puzzle.shell.gdal.vector.onefile;

import java.io.File;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.geotools.gui.swing.misc.filter.FileFilterFactory;
import org.geotools.gui.swing.misc.filter.FileFilterFactory.FORMAT;
import org.puzzle.shell.gdal.ENV;
import org.puzzle.shell.gdal.GDALTool;
import org.puzzle.shell.misc.runtime.ProcessObject;

/**
 * panneau de convertion de vecteur par fichier
 * @author Romain govaere
 * @author johann sorel
 */
public class OneFileVectorConvertTool extends JPanel implements GDALTool{

    private ResourceBundle bundle = ResourceBundle.getBundle("org/puzzle/shell/gdal/vector/onefile/Bundle");
    

    /** Creates new form ConvUnFichier */
    public OneFileVectorConvertTool() {
        initComponents();
    }


    private void testName() {

        String nom_sortie = jtf_sortie.getText();
        String nom_entree = jtf_entree.getText();
        String extension_fichier = "";
        String extension_liste = "";
        String nouveaunom = "";
        int index = -1;

        //recuperation de l'extension dans la liste
        int num = format.getSelectedIndex();
        switch (num) {
            case 0:
                extension_liste = ".dgn";
                break;
            case 1:
                extension_liste = ".gml";
                break;
            case 2:
                extension_liste = ".kml";
                break;
            case 3:
                extension_liste = ".mif";
                break;
            case 4:
                extension_liste = ".shp";
                break;
            case 5:
                extension_liste = ".tab";
                break;
        }

        //si le texte en sortie est vide on le complete avec celui d'entree
        if (nom_sortie.length() == 0) {
            nom_sortie = nom_entree;
        }

        //recuperation de l'extension du fichier en sortie
        index = nom_sortie.lastIndexOf(".");
        if (index != -1) {
            extension_fichier = nom_sortie.substring(index, nom_sortie.length());
        }


        // on corrige l'extension
        if (!nom_sortie.endsWith(extension_liste)) {

            if (nom_sortie.endsWith(File.separator)) {
                nom_sortie += "out";
            }

            if (!nom_sortie.equals("")) {
                if (index == -1) {

                    nouveaunom = nom_sortie + extension_liste;
                } else {
                    nouveaunom = nom_sortie.substring(0, index) + extension_liste;
                }
            }
        } else {
            nouveaunom = nom_sortie;
        }

        jtf_sortie.setText(nouveaunom);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_entree = new javax.swing.JTextField();
        but_chercher_entree = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        format = new javax.swing.JComboBox();
        jtf_sortie = new javax.swing.JTextField();
        but_chercher_sortie = new javax.swing.JButton();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OneFileVectorConvertTool.class, "files"))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(OneFileVectorConvertTool.class, "input")); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/puzzle/shell/gdal/vector/onefile/Bundle"); // NOI18N
        but_chercher_entree.setText(bundle.getString("...")); // NOI18N
        but_chercher_entree.setPreferredSize(new java.awt.Dimension(45, 20));
        but_chercher_entree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherEntree(evt);
            }
        });

        jLabel2.setText(bundle.getString("output")); // NOI18N

        format.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MicroStation (.dgn)", "Geography Markup Language (.gml)", "Google Earth / Map  (.kml)", "MapInfo Exchange (.mif)", "ESRI Shape (.shp)", "MapInfo  (.tab)" }));
        format.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatChanged(evt);
            }
        });

        jtf_sortie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortieAction(evt);
            }
        });
        jtf_sortie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sortieLost(evt);
            }
        });

        but_chercher_sortie.setText(bundle.getString("...")); // NOI18N
        but_chercher_sortie.setPreferredSize(new java.awt.Dimension(45, 20));
        but_chercher_sortie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherSortie(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jtf_entree, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(but_chercher_entree, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 138, Short.MAX_VALUE)
                        .add(format, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jtf_sortie, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(but_chercher_sortie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(but_chercher_entree, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtf_entree, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(format, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(but_chercher_sortie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtf_sortie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jXTitledSeparator1.setTitle(org.openide.util.NbBundle.getMessage(OneFileVectorConvertTool.class, "title")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jXTitledSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jXTitledSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sortieLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sortieLost
        testName();
    }//GEN-LAST:event_sortieLost

    private void sortieAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortieAction
        testName();
    }//GEN-LAST:event_sortieAction

    private void chercherSortie(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherSortie
        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.MICROSTATION_DGN));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.AUTOCAD_DWG));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.GEOGRAPHY_MARKUP_LANGUAGE));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.KEYHOLE_MARKUP_LANGUAGE));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.MAPINFO_EXCHANGE));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.MAPINFO_TAB));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.ESRI_SHAPEFILE));

        jfc.setFileFilter(jfc.getChoosableFileFilters()[0]);

        jfc.setCurrentDirectory(ENV.getPath());

        int val = jfc.showSaveDialog(this);

        if (val == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            jtf_sortie.setText(f.getPath());
            testName();
            ENV.updatePath(f.getAbsoluteFile());
        }
    }//GEN-LAST:event_chercherSortie

    private void chercherEntree(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherEntree

        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.MICROSTATION_DGN));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.AUTOCAD_DWG));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.GEOGRAPHY_MARKUP_LANGUAGE));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.KEYHOLE_MARKUP_LANGUAGE));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.MAPINFO_EXCHANGE));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.MAPINFO_TAB));
        jfc.addChoosableFileFilter(FileFilterFactory.createFileFilter(FORMAT.ESRI_SHAPEFILE));

        jfc.setFileFilter(jfc.getChoosableFileFilters()[1]);

        jfc.setCurrentDirectory(ENV.getPath());

        int val = jfc.showOpenDialog(this);

        if (val == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            jtf_entree.setText(f.getPath());
            testName();
            ENV.updatePath(f.getAbsoluteFile());
        }
    }//GEN-LAST:event_chercherEntree

    private void formatChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatChanged
        testName();
    }//GEN-LAST:event_formatChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_chercher_entree;
    private javax.swing.JButton but_chercher_sortie;
    private javax.swing.JComboBox format;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private javax.swing.JTextField jtf_entree;
    private javax.swing.JTextField jtf_sortie;
    // End of variables declaration//GEN-END:variables
   
    
    public JComponent getComponent() {
        return this;
    }

    public ProcessObject[] createProcesses() {
        
        ProcessObject po = null;
        
        if ( jtf_entree.getText().equals("") || jtf_sortie.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, bundle.getString("please_fill_all"), bundle.getString("missing_data"), JOptionPane.ERROR_MESSAGE);
        } else {

            String format_sortie = "";
            
            switch (format.getSelectedIndex()) {
                case 0:
                    format_sortie = "DGN";
                    break;
                case 1:
                    format_sortie = "GML";
                    break;
                case 2:
                    format_sortie = "KML";
                    break;
                case 3:
                    format_sortie = "MapInfo File";
                    break;
                case 4:
                    format_sortie = "ESRI Shapefile";
                    break;
                case 5:
                    format_sortie = "MapInfo File";
                    break;
            }



            String[] parametres = new String[5];
            parametres[0] = ENV.getOGR2OGRPath();
            parametres[1] = "-f";
            parametres[2] = format_sortie;
            parametres[3] = jtf_sortie.getText();
            parametres[4] = jtf_entree.getText();
            String separateur = File.separator;
            int i = jtf_sortie.getText().lastIndexOf(separateur);

            String nom = jtf_sortie.getText().substring(i + 1, jtf_sortie.getText().length());

            po = new ProcessObject(parametres, nom);

        }
        
        if(po != null){
            return new ProcessObject[]{po};
        }else{
            return EMPTY_PROCESS_OBJECT_ARRAY;
        }
        
    }
}