/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Console.java
 *
 * Created on 13.03.2011, 13:33:26
 */
package installdb.dialogs;

import installdb.conf.AppConstants;
import installdb.db.pg_tools.PGTools.PrintlnListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.application.Action;

/**
 *
 * @author tt
 */
public final class Console extends javax.swing.JFrame implements PrintlnListener {

    /** Creates new form Console */
    public Console() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(installdb.InstallDBApp.class).getContext().getResourceMap(Console.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        consoleTextArea.setColumns(20);
        consoleTextArea.setEditable(false);
        consoleTextArea.setRows(5);
        consoleTextArea.setAutoscrolls(true);
        consoleTextArea.setName("consoleTextArea"); // NOI18N
        consoleTextArea.setOpaque(true);
        jScrollPane1.setViewportView(consoleTextArea);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(installdb.InstallDBApp.class).getContext().getActionMap(Console.class, this);
        saveButton.setAction(actionMap.get("save")); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("installdb/dialogs/resources/Console"); // NOI18N
        saveButton.setText(bundle.getString("save.Action.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N

        closeButton.setAction(actionMap.get("close")); // NOI18N
        closeButton.setText(bundle.getString("close.Action.text")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Console().setVisible(true);
            }
        });
    }

    @Action
    public void save() {
        JFileChooser c = new JFileChooser();
        c.setDialogTitle("Выбрать фаил, в котором будут сохранены данные");
        c.setDialogType(JFileChooser.SAVE_DIALOG);
        c.setSelectedFile(new File("Installdb"+ "-" + AppConstants.df.format(new Date()) + ".log"));
        c.setFileFilter(new FileNameExtensionFilter("Log file", "log"));

        int rVal = c.showSaveDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            try {
                Writer w = new FileWriter(c.getSelectedFile());
                w.write(consoleTextArea.getText());
                w.close();
            } catch (IOException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * Закрыть диалог
     */
    @Action
    public void close() {
        setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        update(getGraphics());
    }
    // End of variables declaration




    public void println(String message) {
        System.out.print(message);
        consoleTextArea.append(message);
        consoleTextArea.setCaretPosition(
                    consoleTextArea.getDocument().getLength());



    }
}
