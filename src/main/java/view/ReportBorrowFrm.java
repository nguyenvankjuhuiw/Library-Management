/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.BorrowReturnDAO;
import dao.ExportFile;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BorrowReturn;
import model.User;

/**
 *
 * @author Admin
 */
public class ReportBorrowFrm extends javax.swing.JFrame {

    /**
     * Creates new form ReportBorrowFrm
     */
    private User user;
    DefaultTableModel modelBorrow;
    private List<BorrowReturn> listborrow;
    public ReportBorrowFrm(User user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.user = user;
        modelBorrow = (DefaultTableModel) tableBorrow.getModel();
        try {
            listborrow = new BorrowReturnDAO().getBorrowReturnByDateReturnNull();
            showTableBorrow();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi khi lấy dữ liệu!");
//            Logger.getLogger(ReportFrm1.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableBorrow = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buttonFilterBorrow = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        buttonFilterDueBorrow = new javax.swing.JButton();
        labelQuantityBookBorrow = new javax.swing.JLabel();
        buttonExportBorrow = new javax.swing.JButton();
        buttonResetBorrow = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        dateStartBorrow = new com.toedter.calendar.JDateChooser();
        dateEndBorrow = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Danh sách mượn");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        tableBorrow.setBorder(new javax.swing.border.MatteBorder(null));
        tableBorrow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã quyển sách", "Tên sách", "Bạn đọc", "Ngày mượn", "Hạn trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableBorrow);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText(" Từ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("đến ");

        buttonFilterBorrow.setBackground(new java.awt.Color(0, 102, 0));
        buttonFilterBorrow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonFilterBorrow.setForeground(new java.awt.Color(255, 255, 255));
        buttonFilterBorrow.setText("Lọc");
        buttonFilterBorrow.setBorder(null);
        buttonFilterBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterBorrowActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("Tổng số lượng sách mượn: ");

        buttonFilterDueBorrow.setBackground(new java.awt.Color(0, 102, 0));
        buttonFilterDueBorrow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonFilterDueBorrow.setForeground(new java.awt.Color(255, 255, 255));
        buttonFilterDueBorrow.setText("Lọc quá hạn");
        buttonFilterDueBorrow.setBorder(null);
        buttonFilterDueBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterDueBorrowActionPerformed(evt);
            }
        });

        labelQuantityBookBorrow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelQuantityBookBorrow.setForeground(new java.awt.Color(0, 102, 0));
        labelQuantityBookBorrow.setText("0");

        buttonExportBorrow.setBackground(new java.awt.Color(0, 102, 0));
        buttonExportBorrow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonExportBorrow.setForeground(new java.awt.Color(255, 255, 255));
        buttonExportBorrow.setText("Xuất");
        buttonExportBorrow.setBorder(null);
        buttonExportBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportBorrowActionPerformed(evt);
            }
        });

        buttonResetBorrow.setBackground(new java.awt.Color(0, 102, 0));
        buttonResetBorrow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonResetBorrow.setForeground(new java.awt.Color(255, 255, 255));
        buttonResetBorrow.setText("Về ban đầu");
        buttonResetBorrow.setBorder(null);
        buttonResetBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetBorrowActionPerformed(evt);
            }
        });

        buttonExit.setBackground(new java.awt.Color(0, 102, 0));
        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setText("Thoát");
        buttonExit.setBorder(null);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonResetBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExportBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(labelQuantityBookBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateStartBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateEndBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonFilterBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonFilterDueBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonFilterBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonFilterDueBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateStartBorrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateEndBorrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantityBookBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExportBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonResetBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFilterBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterBorrowActionPerformed
        // TODO add your handling code here:
        Date dateStartutitl = dateStartBorrow.getDate();
        Date dateEndUtil = dateEndBorrow.getDate();
        if(dateStartutitl == null || dateEndUtil == null){
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn đủ ngày!");
        }
        else {
            java.sql.Date dateStartSql = new java.sql.Date(dateStartutitl.getTime());
            java.sql.Date dateEndSql = new java.sql.Date(dateEndUtil.getTime());
            try {
                listborrow = new BorrowReturnDAO().getBorrowReturnByDateReturnNullAndDateBorrow(dateStartSql, dateEndSql);
                showTableBorrow();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Lỗi lấy dữ liệu!");
                //                Logger.getLogger(ReportFrm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonFilterBorrowActionPerformed

    private void buttonFilterDueBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterDueBorrowActionPerformed
        // TODO add your handling code here:
        dateStartBorrow.setDate(null);
        dateEndBorrow.setDate(null);
        java.sql.Date currentDate  =new java.sql.Date(new Date().getTime());
        try {
            listborrow = new BorrowReturnDAO().getBorrowReturnByDateReturnNullAndDateDue(currentDate);
            showTableBorrow();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi lấy dữ liệu!");
            //            Logger.getLogger(ReportFrm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonFilterDueBorrowActionPerformed

    private void buttonExportBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportBorrowActionPerformed
        try {
            // TODO add your handling code here:
            new ExportFile().exportReportBorrow(listborrow);
            JOptionPane.showMessageDialog(rootPane, "Đã xuất file thành công");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi máy chủ");
            Logger.getLogger(ReportBorrowFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonExportBorrowActionPerformed

    private void buttonResetBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetBorrowActionPerformed
        try {
            // TODO add your handling code here:
            dateStartBorrow.setDate(null);
            dateEndBorrow.setDate(null);
            listborrow = new BorrowReturnDAO().getBorrowReturnByDateReturnNull();
            showTableBorrow();
        } catch (SQLException ex) {
            Logger.getLogger(ReportBorrowFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonResetBorrowActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        ReportFrm frm = new ReportFrm(user);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonExitActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ReportBorrowFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReportBorrowFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReportBorrowFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReportBorrowFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReportBorrowFrm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonExportBorrow;
    private javax.swing.JButton buttonFilterBorrow;
    private javax.swing.JButton buttonFilterDueBorrow;
    private javax.swing.JButton buttonResetBorrow;
    private com.toedter.calendar.JDateChooser dateEndBorrow;
    private com.toedter.calendar.JDateChooser dateStartBorrow;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelQuantityBookBorrow;
    private javax.swing.JTable tableBorrow;
    // End of variables declaration//GEN-END:variables

    private void showTableBorrow() {
        labelQuantityBookBorrow.setText(String.valueOf(listborrow.size()));
        modelBorrow.setRowCount(0);
        int index = 1;
        for(BorrowReturn br : listborrow){
            modelBorrow.addRow(new Object[]{
                index++, br.getAbook().getAbookid(), br.getAbook().getBook().getName(), br.getReader().getFullname(), br.getBorrowdate(), br.getDuedate()
            });
        }
    }
}
