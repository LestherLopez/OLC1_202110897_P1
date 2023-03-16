/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1_olc1;

import analizador.Lexico;
import analizador.parser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author 50246
 */

public class Index extends javax.swing.JFrame {
    String current_file = null;
    
    
    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
    }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        saveasButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorTextArea = new javax.swing.JTextArea();
        analizarJbutton = new javax.swing.JButton();
        automatajButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Archivo");

        openButton.setText("Abrir");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Guardar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        saveasButton.setText("Guardar como");
        saveasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveasButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveasButton)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        editorTextArea.setColumns(20);
        editorTextArea.setRows(5);
        jScrollPane1.setViewportView(editorTextArea);

        analizarJbutton.setText("Analizar Texto");
        analizarJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarJbuttonActionPerformed(evt);
            }
        });

        automatajButton.setText("Generar Autómata");
        automatajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automatajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(automatajButton)
                        .addGap(35, 35, 35)
                        .addComponent(analizarJbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(578, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analizarJbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(automatajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.showOpenDialog(fileChooser);
         current_file = fileChooser.getSelectedFile().getAbsolutePath();
         String line;
         String contenido="";
         BufferedReader lector= null;
         try{
             
             lector=new BufferedReader(new FileReader(current_file));
             line = lector.readLine();
             while(line != null){
                 contenido = contenido + line + "\n";
                 line = lector.readLine();
                 System.out.println(contenido);
             }
         
         }catch (Exception e){
            System.out.println(e);
         }
         editorTextArea.setText(contenido);
         
         
         
 /*        try{
             Scanner entrada = new Scanner(new File(ruta));
             while (entrada.hasNextLine()) {
                 line = line + entrada.nextLine()+"\n";
                 System.out.println(line);
                 
             }
             
             entrada.close();
         }catch (Exception e){
            System.out.println(e);
            }
         
          editorTextArea.setText(line);*/
    }//GEN-LAST:event_openButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String file = current_file;
        String text = editorTextArea.getText();
 
        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter bf = new BufferedWriter(osw))
        {
            bf.write(text);
            System.out.println("El archivo se ha guardado exiotosamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void saveasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveasButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
         fileChooser.showOpenDialog(fileChooser);
         
         //System.out.println(current_file);
          current_file = fileChooser.getSelectedFile().getAbsolutePath();
         try {
      
            String contenido = editorTextArea.getText();
            File file = new File(current_file);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
         
         
    }//GEN-LAST:event_saveasButtonActionPerformed

    private void automatajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automatajButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_automatajButtonActionPerformed

    private void analizarJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarJbuttonActionPerformed
        String texto = editorTextArea.getText();
       
        /*
        String er = "a*|abb";
        ArrayList<node> leaves = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();*/
        
        /*er ="..."+ er + "#";
        
        Arbol arbol = new Arbol(er, leaves, table);
        node raiz = arbol.getRoot();
        
        raiz.getNode(); 
        raiz.follow();
        for(int i = 0; i < leaves.size(); i++) {   
            System.out.print(leaves.get(i));
        }  
        
        
        
        System.out.println("==============================TABLA SIGUIENTES==============================");
        tablaSiguientes ft = new tablaSiguientes();
        ft.printTable(table);
        
        tablaTransiciones tran = new tablaTransiciones(raiz, table, leaves); // bug
        System.out.println("=============================TABLA TRANSICIONES=============================");
        tran.impTable();*/
        try {
            Lexico scanner = new Lexico(new java.io.StringReader(texto));
            parser analizador = new parser(scanner);
            analizador.parse();
                   
            System.out.println("Analisis realizado con exito");
        }catch(Exception e){
            System.out.println("Error al realizar el analisis");
        } 
    }//GEN-LAST:event_analizarJbuttonActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarJbutton;
    private javax.swing.JButton automatajButton;
    private javax.swing.JTextArea editorTextArea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveasButton;
    // End of variables declaration//GEN-END:variables
}
