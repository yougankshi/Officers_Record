/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author welcome
 */
public class DELETE extends javax.swing.JPanel {

    /**
     * Creates new form DELETE
     */
    public DELETE() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("DELETE RECORD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 180, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ENTER OFFICER ID");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 170, 40));

        ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ID.setOpaque(false);
        add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 170, 40));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "OFFICER_ID", "NAME", "GENDER", "PHONE_NUMBER", "EMAIL", "RANK"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 1020, 190));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 620, 160, 50));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SHOW RECORDS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, 160, 50));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1270, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\welcome\\Desktop\\AIRCRAFT2.jpg")); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 740));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Officers_Record ");
            String id = ID.getText();
            Statement smt = con.createStatement();
            if (id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter officer id .");}
            else {
            String query = "delete from OFFICER_RECORD where OFFICER_ID="+id+"";
            smt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "OFFICER RECORD DELETES SUCESSFULLY !");
            ID.setText("");}
         }
         catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount() == 1){
         tb1Model.removeRow(jTable1.getSelectedRow());   
        }else{
            if(jTable1.getRowCount() ==0){
                JOptionPane.showMessageDialog(this,"Table is Empty.");
            }else{
                 JOptionPane.showMessageDialog(this,"Please select single record for Delete.");
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Officers_Record ");
            Statement smt = con.createStatement();
            String query = "select * from OFFICER_RECORD";
            ResultSet rs = smt.executeQuery(query);
            
            while (rs.next()){
                String id = String.valueOf(rs.getInt("OFFICER_ID"));
                String name = rs.getString("NAME");
                String gender = rs.getString("GENDER");
                String phno = rs.getString("PHONE_NUMBER");
                String eadd = rs.getString("EMAIL_ADDRESS");
                String rank = rs.getString("RANK");

                String tbData[] = {id, name, gender, phno, eadd, rank};
                 DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
                tb1Model.addRow(tbData);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());}
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
