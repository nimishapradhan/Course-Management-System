
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
 * @author manoj
 */
public class AddResult extends javax.swing.JFrame {
    PreparedStatement createQuery;
    ResultSet sqlQuery;
    String isCourse;
    String isTeacher;
    
    public AddResult(String isCourse, String isTeacher) {
        super();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon/herald_icon.png")));
        this.isCourse = isCourse;
        this.isTeacher = isTeacher;
        moduleBox.addItem(isCourse);
        fetchstudentData();
    }
    
    public Connection checkConnection() {
        db startDB = new db();
        Connection confirmConn = startDB.checkConnection();
        return confirmConn;
    }
    
    public void fetchstudentData() {
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_students where (module1 = ? or module2 = ? or module3 = ? or module4 = ? or module5 = ? or module6 = ?)");
            createQuery.setString(1, isCourse);
            createQuery.setString(2, isCourse);
            createQuery.setString(3, isCourse);
            createQuery.setString(4, isCourse);
            createQuery.setString(5, isCourse);
            createQuery.setString(6, isCourse);
            sqlQuery = createQuery.executeQuery();
            
            while (sqlQuery.next()) {
                String getStudentID = sqlQuery.getString("id");
                studentBox.addItem(getStudentID);
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
        studentLabel = new javax.swing.JLabel();
        moduleBox = new javax.swing.JComboBox<>();
        semesterLabel = new javax.swing.JLabel();
        semesterBox = new javax.swing.JComboBox<>();
        levelLabel = new javax.swing.JLabel();
        levelBox = new javax.swing.JComboBox<>();
        moduleLabel = new javax.swing.JLabel();
        marksLabel = new javax.swing.JLabel();
        marksInput = new javax.swing.JTextField();
        moduleCancelBTN = new javax.swing.JButton();
        studentBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Result");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moduleSubmitBTN.setBackground(new java.awt.Color(153, 255, 0));
        moduleSubmitBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleSubmitBTN.setText("Submit");
        moduleSubmitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleSubmitBTNActionPerformed(evt);
            }
        });
        getContentPane().add(moduleSubmitBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 90, -1));

        studentLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        studentLabel.setText("Select Student ID");
        getContentPane().add(studentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        moduleBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        moduleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleBoxActionPerformed(evt);
            }
        });
        getContentPane().add(moduleBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 327, 39));

        semesterLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        semesterLabel.setText("Select Semester");
        getContentPane().add(semesterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        semesterBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        semesterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semester 1", "Semester 2", "Semester 3", "Semester 4" }));
        semesterBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterBoxActionPerformed(evt);
            }
        });
        getContentPane().add(semesterBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 327, 39));

        levelLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        levelLabel.setText("Select Level");
        getContentPane().add(levelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        levelBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        levelBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 4", "Level 5", "Level 6" }));
        levelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelBoxActionPerformed(evt);
            }
        });
        getContentPane().add(levelBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 327, 39));

        moduleLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleLabel.setText("Select Module");
        getContentPane().add(moduleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        marksLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        marksLabel.setText("Enter Marks");
        getContentPane().add(marksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 30));

        marksInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        marksInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marksInputActionPerformed(evt);
            }
        });
        getContentPane().add(marksInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 327, 39));

        moduleCancelBTN.setBackground(new java.awt.Color(153, 255, 51));
        moduleCancelBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleCancelBTN.setText("Cancel");
        moduleCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleCancelBTNActionPerformed(evt);
            }
        });
        getContentPane().add(moduleCancelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 90, -1));

        studentBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        studentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentBoxActionPerformed(evt);
            }
        });
        getContentPane().add(studentBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 327, 39));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moduleSubmitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleSubmitBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            String getStudent = studentBox.getSelectedItem().toString();
            String getTeacher = isTeacher;
            String getSemester = semesterBox.getSelectedItem().toString();
            String getLevel = levelBox.getSelectedItem().toString();
            String getModule = moduleBox.getSelectedItem().toString();
            String getMarks = marksInput.getText();
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_students where id = ?");
            createQuery.setString(1, getStudent);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong while fetching student data");
                return;
            }
            
            
            String finalStudentName = sqlQuery.getString("student");
            String finalStudentEmail = sqlQuery.getString("email");
            createQuery = dbConnection.prepareStatement("select * from result where email = ?");
            createQuery.setString(1, finalStudentEmail);
            sqlQuery = createQuery.executeQuery();
            if (sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "You have already mark for this student!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            createQuery = dbConnection.prepareStatement("insert into result (student, email, instructor, module, semester, level, marks) values (?, ?, ?, ?, ?, ?, ?)");
            createQuery.setString(1, finalStudentName);
            createQuery.setString(2, finalStudentEmail);
            createQuery.setString(3, getTeacher);
            createQuery.setString(4, getModule);
            createQuery.setString(5, getSemester);
            createQuery.setString(6, getLevel);
            createQuery.setString(7, getMarks);
            int checkResult = createQuery.executeUpdate();
            
            if (checkResult != 1) {
                JOptionPane.showMessageDialog(this, "Something went wrong while adding result", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Mark added successfully", "INFO", JOptionPane.INFORMATION_MESSAGE);
            dbConnection.close();
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
        
        
    }//GEN-LAST:event_moduleSubmitBTNActionPerformed

    private void moduleBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moduleBoxActionPerformed

    private void semesterBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterBoxActionPerformed
      
    }//GEN-LAST:event_semesterBoxActionPerformed

    private void levelBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelBoxActionPerformed
        
    }//GEN-LAST:event_levelBoxActionPerformed

    private void marksInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marksInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marksInputActionPerformed

    private void moduleCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleCancelBTNActionPerformed
        dispose();
    }//GEN-LAST:event_moduleCancelBTNActionPerformed

    private void studentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentBoxActionPerformed
        
    }//GEN-LAST:event_studentBoxActionPerformed

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
                new AddResult("null", "null").setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> levelBox;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextField marksInput;
    private javax.swing.JLabel marksLabel;
    private javax.swing.JComboBox<String> moduleBox;
    private javax.swing.JButton moduleCancelBTN;
    private javax.swing.JLabel moduleLabel;
    private javax.swing.JButton moduleSubmitBTN;
    private javax.swing.JComboBox<String> semesterBox;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JComboBox<String> studentBox;
    private javax.swing.JLabel studentLabel;
    // End of variables declaration//GEN-END:variables
}
