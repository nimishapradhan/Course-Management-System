
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Nimisha
 */
public class EnrollModule extends javax.swing.JFrame {
    PreparedStatement createQuery;
    ResultSet sqlQuery;
    String isCourse;
    String isSemester;
    String isLevel;
    String name;
    String address;
    String phone;
    String email;
    
    public EnrollModule(String isCourse, String isLevel, String isSemester, String name, String address, String phone, String email) {
        super();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon/herald_icon.png")));
        this.isCourse = isCourse;
        this.isLevel = isLevel;
        this.isSemester = isSemester;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        fetchCoursesData();
        disableOptionalModule();
        fetchOldModuleData();
        disableInputField();
    }
    
    public Connection checkConnection() {
        db startDB = new db();
        Connection confirmConn = startDB.checkConnection();
        return confirmConn;
    }
    
    public void disableOptionalModule() {
        module5label.setVisible(false);
        module6label.setVisible(false);
        module5input.setVisible(false);
        module6input.setVisible(false);
    }
    
    public void disableInputField() {
        module1input.setEditable(false);
        module2input.setEditable(false);
        module3input.setEditable(false);
        module4input.setEditable(false);
    }
    
    public void fetchOldModuleData() {
        module1input.setText("");
        module2input.setText("");
        module3input.setText("");
        module4input.setText("");
        module5input.setText("");
        module6input.setText("");
        
        try {
            Connection dbConnection = checkConnection();
            courseBox.addItem(isCourse);
            createQuery = dbConnection.prepareStatement("select * from modules where course = ? and semester = ? and level = ?");
            createQuery.setString(1, isCourse);
            createQuery.setString(2, isSemester);
            createQuery.setString(3, isLevel);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Failed to display modules");
                return;
            }
            if (isLevel != "Level 6") {
                module1input.setText(sqlQuery.getString("module1"));
                module2input.setText(sqlQuery.getString("module2"));
                module3input.setText(sqlQuery.getString("module3"));
                module4input.setText(sqlQuery.getString("module4"));
                module5input.setText(sqlQuery.getString("module5"));
                module6input.setText(sqlQuery.getString("module6"));
            } else {
                module1input.setText(sqlQuery.getString("module1"));
                module2input.setText(sqlQuery.getString("module2"));
                module3input.setText(sqlQuery.getString("module3"));
                module4input.setText(sqlQuery.getString("module4"));
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
        return;
    }
    
    public void fetchCoursesData() {
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select name, isActive from courses");
            sqlQuery = createQuery.executeQuery();
            while (sqlQuery.next()) {
                String getCoursesName = sqlQuery.getString("name");
                int getAvailability = sqlQuery.getInt("isActive");
                if (getAvailability == 1) {
                    courseBox.addItem(getCoursesName);
                }
            }
            
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moduleSubmitBTN = new javax.swing.JButton();
        courseLabel = new javax.swing.JLabel();
        courseBox = new javax.swing.JComboBox<>();
        module1input = new javax.swing.JTextField();
        module1label = new javax.swing.JLabel();
        module2label = new javax.swing.JLabel();
        module2input = new javax.swing.JTextField();
        module3label = new javax.swing.JLabel();
        module3input = new javax.swing.JTextField();
        module4Label = new javax.swing.JLabel();
        module4input = new javax.swing.JTextField();
        module5label = new javax.swing.JLabel();
        module5input = new javax.swing.JTextField();
        module6label = new javax.swing.JLabel();
        module6input = new javax.swing.JTextField();
        moduleCancelBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moduleSubmitBTN.setBackground(new java.awt.Color(102, 255, 0));
        moduleSubmitBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleSubmitBTN.setText("Submit");
        moduleSubmitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleSubmitBTNActionPerformed(evt);
            }
        });
        getContentPane().add(moduleSubmitBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 90, -1));

        courseLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        courseLabel.setText("Select Course");
        getContentPane().add(courseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        courseBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        courseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseBoxActionPerformed(evt);
            }
        });
        getContentPane().add(courseBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 327, 39));

        module1input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        module1input.setForeground(new java.awt.Color(102, 102, 102));
        module1input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                module1inputActionPerformed(evt);
            }
        });
        getContentPane().add(module1input, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 327, 39));

        module1label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        module1label.setText("Module 1");
        getContentPane().add(module1label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        module2label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        module2label.setText("Module 2");
        getContentPane().add(module2label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 30));

        module2input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        module2input.setForeground(new java.awt.Color(102, 102, 102));
        module2input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                module2inputActionPerformed(evt);
            }
        });
        getContentPane().add(module2input, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 327, 39));

        module3label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        module3label.setText("Module 3");
        getContentPane().add(module3label, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, 30));

        module3input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        module3input.setForeground(new java.awt.Color(102, 102, 102));
        module3input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                module3inputActionPerformed(evt);
            }
        });
        getContentPane().add(module3input, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 327, 39));

        module4Label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        module4Label.setText("Module 4");
        getContentPane().add(module4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        module4input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        module4input.setForeground(new java.awt.Color(102, 102, 102));
        module4input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                module4inputActionPerformed(evt);
            }
        });
        getContentPane().add(module4input, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 327, 39));

        module5label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        module5label.setText("Module 5 (Optional)");
        getContentPane().add(module5label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        module5input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        module5input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                module5inputActionPerformed(evt);
            }
        });
        getContentPane().add(module5input, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 327, 39));

        module6label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        module6label.setText("Module 6 (Optional)");
        getContentPane().add(module6label, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, -1, -1));

        module6input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        module6input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                module6inputActionPerformed(evt);
            }
        });
        getContentPane().add(module6input, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 327, 39));

        moduleCancelBTN.setBackground(new java.awt.Color(102, 255, 0));
        moduleCancelBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleCancelBTN.setText("Cancel");
        moduleCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleCancelBTNActionPerformed(evt);
            }
        });
        getContentPane().add(moduleCancelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moduleSubmitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleSubmitBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            if (courseBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "You have not selected any course.");
                return;
            }
            String getcourse = courseBox.getSelectedItem().toString();
            String getSemester = isSemester;
            String getLevel = isLevel;
            String getName = name;
            String getAddress = address;
            String getPhone = phone;
            String getEmail = email;
            String firstModule = module1input.getText();
            String secondModule = module2input.getText();
            String thirdModule = module3input.getText();
            String fourthModule = module4input.getText();
            String fifthModule = module5input.getText();
            String sixthModule = module6input.getText();
            
            if (getLevel != "Level 6") {
                createQuery = dbConnection.prepareStatement("insert into enrolled_module_students(student, phone, address, email, semester, level, module1, module2, module3, module4, module5, module6, course) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                createQuery.setString(1, name);
                createQuery.setString(2, phone);
                createQuery.setString(3, address);
                createQuery.setString(4, email);
                createQuery.setString(5, getSemester);
                createQuery.setString(6, getLevel);
                createQuery.setString(7, firstModule);
                createQuery.setString(8, secondModule);
                createQuery.setString(9, thirdModule);
                createQuery.setString(10, fourthModule);
                createQuery.setString(11, "none");
                createQuery.setString(12, "none");
                createQuery.setString(13, getcourse);
            } else {
                createQuery = dbConnection.prepareStatement("insert into enrolled_module_students(student, phone, address, email, semester, level, module1, module2, module3, module4, module5, module6, course) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                createQuery.setString(1, name);
                createQuery.setString(2, phone);
                createQuery.setString(3, address);
                createQuery.setString(4, email);
                createQuery.setString(5, getSemester);
                createQuery.setString(6, getLevel);
                createQuery.setString(7, firstModule);
                createQuery.setString(8, secondModule);
                createQuery.setString(9, thirdModule);
                createQuery.setString(10, fourthModule);
                createQuery.setString(11, fifthModule);
                createQuery.setString(12, sixthModule);
                createQuery.setString(13, getcourse);
            }
            
            int checkResult = createQuery.executeUpdate();
            if (checkResult != 1) {
                JOptionPane.showMessageDialog(this, "Something went wrong while updating new modules", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
            JOptionPane.showMessageDialog(this, "Successfully updated new modules", "INFO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            dbConnection.close();
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_moduleSubmitBTNActionPerformed

    private void courseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseBoxActionPerformed
        
    }//GEN-LAST:event_courseBoxActionPerformed

    private void module1inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_module1inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_module1inputActionPerformed

    private void module2inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_module2inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_module2inputActionPerformed

    private void module3inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_module3inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_module3inputActionPerformed

    private void module4inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_module4inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_module4inputActionPerformed

    private void module5inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_module5inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_module5inputActionPerformed

    private void module6inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_module6inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_module6inputActionPerformed

    private void moduleCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleCancelBTNActionPerformed
        dispose();
    }//GEN-LAST:event_moduleCancelBTNActionPerformed

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
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnrollModule("null", "null", "null", "null", "null", "null", "null").setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> courseBox;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JTextField module1input;
    private javax.swing.JLabel module1label;
    private javax.swing.JTextField module2input;
    private javax.swing.JLabel module2label;
    private javax.swing.JTextField module3input;
    private javax.swing.JLabel module3label;
    private javax.swing.JLabel module4Label;
    private javax.swing.JTextField module4input;
    private javax.swing.JTextField module5input;
    private javax.swing.JLabel module5label;
    private javax.swing.JTextField module6input;
    private javax.swing.JLabel module6label;
    private javax.swing.JButton moduleCancelBTN;
    private javax.swing.JButton moduleSubmitBTN;
    // End of variables declaration//GEN-END:variables
}
