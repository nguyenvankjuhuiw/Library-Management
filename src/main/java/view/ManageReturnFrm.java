/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.BorrowReturnDAO;
import dao.ExportFile;
import dao.ReaderDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BorrowReturn;
import model.Reader;
import model.User;

/**
 *
 * @author Admin
 */
public class ManageReturnFrm extends javax.swing.JFrame {

    /**
     * Creates new form ManageReturnFrm
     */
    private User user;
    private Reader reader;
    DefaultTableModel modelBorrow;
    DefaultTableModel modelReturn;
    private List<BorrowReturn> listborrow;
    private List<BorrowReturn> listreturn;
    private int selectIndexBorrow;
    public ManageReturnFrm(User user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.user = user;
        labelNameReader.setText("");
        labelReaderId.setText("");
        modelBorrow = (DefaultTableModel) tabelBorrow.getModel();
        modelReturn = (DefaultTableModel) tabelReturn.getModel();
        listreturn = new ArrayList<>();
        buttonReturn.setVisible(false);
        buttonAdd.setVisible(false);
        buttonExport.setVisible(false);
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
        textSearch = new javax.swing.JTextField();
        buttonExit = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBorrow = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelReturn = new javax.swing.JTable();
        buttonExport = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        labelNameReader = new javax.swing.JLabel();
        labelReaderId = new javax.swing.JLabel();
        buttonReturn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });

        buttonExit.setBackground(new java.awt.Color(0, 102, 0));
        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setText("Thoát");
        buttonExit.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonSearch.setBackground(new java.awt.Color(0, 102, 0));
        buttonSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(255, 255, 255));
        buttonSearch.setText("Tìm kiếm");
        buttonSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        buttonAdd.setBackground(new java.awt.Color(0, 102, 0));
        buttonAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(255, 255, 255));
        buttonAdd.setText("Thêm vi phạm");
        buttonAdd.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Mã độc giả");

        tabelBorrow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Ngày mượn", "Hạn trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelBorrow);
        if (tabelBorrow.getColumnModel().getColumnCount() > 0) {
            tabelBorrow.getColumnModel().getColumn(0).setMinWidth(35);
            tabelBorrow.getColumnModel().getColumn(0).setMaxWidth(50);
            tabelBorrow.getColumnModel().getColumn(1).setMinWidth(75);
            tabelBorrow.getColumnModel().getColumn(1).setMaxWidth(75);
            tabelBorrow.getColumnModel().getColumn(3).setMinWidth(150);
            tabelBorrow.getColumnModel().getColumn(3).setMaxWidth(150);
            tabelBorrow.getColumnModel().getColumn(4).setMinWidth(150);
            tabelBorrow.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("Tên độc giả");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setText("DANH SÁCH MƯỢN");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 0));
        jLabel16.setText("DANH SÁCH TRẢ");

        tabelReturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Ngày mượn", "Hạn trả", "Ngày trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane3.setViewportView(tabelReturn);
        if (tabelReturn.getColumnModel().getColumnCount() > 0) {
            tabelReturn.getColumnModel().getColumn(0).setMinWidth(50);
            tabelReturn.getColumnModel().getColumn(0).setMaxWidth(50);
            tabelReturn.getColumnModel().getColumn(1).setMinWidth(75);
            tabelReturn.getColumnModel().getColumn(1).setMaxWidth(75);
            tabelReturn.getColumnModel().getColumn(3).setMinWidth(120);
            tabelReturn.getColumnModel().getColumn(3).setMaxWidth(120);
            tabelReturn.getColumnModel().getColumn(4).setMinWidth(120);
            tabelReturn.getColumnModel().getColumn(4).setMaxWidth(120);
            tabelReturn.getColumnModel().getColumn(5).setMinWidth(120);
            tabelReturn.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        buttonExport.setBackground(new java.awt.Color(0, 102, 0));
        buttonExport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonExport.setForeground(new java.awt.Color(255, 255, 255));
        buttonExport.setText("Xuất phiếu trả");
        buttonExport.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        buttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 0));
        jLabel11.setText("Mã độc giả");

        labelNameReader.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelNameReader.setText("jLabel2");

        labelReaderId.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelReaderId.setText("jLabel3");

        buttonReturn.setBackground(new java.awt.Color(0, 102, 0));
        buttonReturn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        buttonReturn.setForeground(new java.awt.Color(255, 255, 255));
        buttonReturn.setText("Trả sách");
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonReturn, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelNameReader, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(labelReaderId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel16)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelNameReader)
                    .addComponent(jLabel11)
                    .addComponent(labelReaderId))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý trả sách");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        if(listreturn.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Không có sách trả!");
        }
        else {
            ViolationReturnFrm frm = new ViolationReturnFrm(user, reader, listreturn);
            this.setVisible(false);
            frm.setVisible(true);
        }
        
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportActionPerformed
        // TODO add your handling code here:
        if(listreturn.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Không có sách trả!");
        }
        else {
            new ExportFile().exportReturn(reader, listreturn);
            JOptionPane.showMessageDialog(rootPane, "Đã xuất phiếu trả!");
        }
        
    }//GEN-LAST:event_buttonExportActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        HomeFrm frm = new HomeFrm(user);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
        String keyString = textSearch.getText();
        if(keyString.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mã độc giả!");
        }
        else {
            try {
                Reader r = new ReaderDAO().getReaderByReaderId(keyString);
                if(r == null){
                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy bạn đọc!");
                }
                else {
                    this.reader = r;
                    labelNameReader.setText(r.getFullname());
                    labelReaderId.setText(r.getReaderid());
                    showTableBorrow();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageBorrowFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
        selectIndexBorrow = tabelBorrow.getSelectedRow();
        if(selectIndexBorrow == -1){
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một hàng trong bảng!");
        }
        else {
            BorrowReturn br = listborrow.get(selectIndexBorrow);
            Date currentDate = new Date(new java.util.Date().getTime());
            try {
                new BorrowReturnDAO().updateBorrowReturnDateReturn(currentDate, br.getId());
                BorrowReturn br2 = new BorrowReturnDAO().getBorrowReturnById(br.getId());
                listreturn.add(br2);
                showTableReturn();
                showTableBorrow();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Lỗi khi cập nhật dữ liệu!");
                Logger.getLogger(ManageReturnFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonReturnActionPerformed

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
//            java.util.logging.Logger.getLogger(ManageReturnFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageReturnFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageReturnFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageReturnFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageReturnFrm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonExport;
    private javax.swing.JButton buttonReturn;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNameReader;
    private javax.swing.JLabel labelReaderId;
    private javax.swing.JTable tabelBorrow;
    private javax.swing.JTable tabelReturn;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    private void showTableBorrow() {
        try {
            buttonReturn.setVisible(true);
            modelBorrow.setRowCount(0);
            listborrow = new BorrowReturnDAO().getBorrowReturnNotReturnByReaderId(reader.getId());
            int index = 1;
            for(BorrowReturn br : listborrow){
                modelBorrow.addRow(new Object[]{
                    index++, br.getAbook().getAbookid(), br.getAbook().getBook().getName(), br.getBorrowdate(), br.getDuedate()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageReturnFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showTableReturn() {
        buttonAdd.setVisible(true);
        buttonExport.setVisible(true);
        modelReturn.setRowCount(0);
        int index = 1;
        for(BorrowReturn br : listreturn){
            modelReturn.addRow(new Object[]{
                index++, br.getAbook().getAbookid(), br.getAbook().getBook().getName(), br.getBorrowdate(), br.getDuedate(), br.getReturndate()
            });
        }
    }
}
