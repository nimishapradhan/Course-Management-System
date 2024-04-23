/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Nimisha
 */
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {
    public static int getID;
    public static String getRole;
    PreparedStatement createQuery;
    ResultSet sqlQuery;
    
    
    /**
     * Creates new form Login
    */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon/herald_icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerLogo = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        uEmailInput = new javax.swing.JTextField();
        email_username_label = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        loginGroupLabel = new javax.swing.JLabel();
        loginGroup = new javax.swing.JComboBox<>();
        loginBTN = new javax.swing.JButton();
        passwordLabel1 = new javax.swing.JLabel();
        signupBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CMS | Login");
        setBackground(java.awt.Color.white);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        headerLogo.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        headerLogo.setText("Login");
        headerLogo.setToolTipText("");

        passwordLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        passwordLabel.setText("Password");

        uEmailInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        uEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uEmailInputActionPerformed(evt);
            }
        });

        email_username_label.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        email_username_label.setText("Username / Email");

        passwordInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });

        loginGroupLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loginGroupLabel.setText("Who are you?");

        loginGroup.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        loginGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Instructor", "Admin" }));
        loginGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginGroupActionPerformed(evt);
            }
        });

        loginBTN.setBackground(new java.awt.Color(102, 204, 0));
        loginBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loginBTN.setForeground(new java.awt.Color(255, 255, 255));
        loginBTN.setText("Login");
        loginBTN.setToolTipText("");
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });

        passwordLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        passwordLabel1.setText("Don't have an account?");

        signupBTN.setBackground(new java.awt.Color(153, 255, 0));
        signupBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        signupBTN.setText("Signup");
        signupBTN.setToolTipText("");
        signupBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(headerLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginGroupLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(loginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginGroup, javax.swing.GroupLayout.Alignment.LEADING, 0, 327, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(passwordLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(signupBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(email_username_label, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(uEmailInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                        .addComponent(passwordInput, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(headerLogo)
                .addGap(64, 64, 64)
                .addComponent(email_username_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginGroupLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBTN)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel1)
                    .addComponent(signupBTN))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void uEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uEmailInputActionPerformed

    public Connection checkConnection() {
        db startDB = new db();
        Connection confirmConn = startDB.checkConnection();
        return confirmConn;
    }
    
    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            String loginUEmail = uEmailInput.getText();
            String loginPassword = String.valueOf(passwordInput.getPassword());
            String role = loginGroup.getSelectedItem().toString();
            if (role == "Student") {
                createQuery = dbConnection.prepareStatement("select id, username, email, password, course from students where (username = ? or email = ?) and password = ?");
                createQuery.setString(1, loginUEmail);
                createQuery.setString(2, loginUEmail);
                createQuery.setString(3, loginPassword);
                sqlQuery = createQuery.executeQuery();
                if (!sqlQuery.next()) {
                    JOptionPane.showMessageDialog(this, "Invalid username or password, Please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    uEmailInput.setText("");
                    passwordInput.setText("");
                    dbConnection.close();
                    return;
                }
                
                String Description = sqlQuery.getString("username") + " has logged in!";
                String Type = role.toLowerCase();
                createQuery = dbConnection.prepareStatement("insert into logs (description, type) values (?, ?)");
                createQuery.setString(1, Description);
                createQuery.setString(2, Type);
                createQuery.executeUpdate();
                
                getID = sqlQuery.getInt("id");
                
                dispose();
                StudentPortal showPage = new StudentPortal(getID);
                showPage.setVisible(true);
                dbConnection.close();
                return;
            } else if (role == "Instructor") {
                createQuery = dbConnection.prepareStatement("select id, username, email, password from instructors where (username = ? or email = ?) and password = ?");
                createQuery.setString(1, loginUEmail);
                createQuery.setString(2, loginUEmail);
                createQuery.setString(3, loginPassword);
                sqlQuery = createQuery.executeQuery();
                if (!sqlQuery.next()) {
                    JOptionPane.showMessageDialog(this, "Invalid username or password, Please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    uEmailInput.setText("");
                    passwordInput.setText("");
                    dbConnection.close();
                    return;
                }
                
                String Description = sqlQuery.getString("username") + " has logged in!";
                String Type = role.toLowerCase();
                createQuery = dbConnection.prepareStatement("insert into logs (description, type) values (?, ?)");
                createQuery.setString(1, Description);
                createQuery.setString(2, Type);
                createQuery.executeUpdate();
                getID = sqlQuery.getInt("id");
                dispose();
                InstructorPortal showPage = new InstructorPortal(getID);
                showPage.setVisible(true);
                dbConnection.close();
                return;
            } else if (role == "Admin") {
                createQuery = dbConnection.prepareStatement("select id, username, email, password from admins where (username = ? or email = ?) and password = ?");
                createQuery.setString(1, loginUEmail);
                createQuery.setString(2, loginUEmail);
                createQuery.setString(3, loginPassword);
                sqlQuery = createQuery.executeQuery();
                if (!sqlQuery.next()) {
                    JOptionPane.showMessageDialog(this, "Invalid username/email or password, Please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    uEmailInput.setText("");
                    passwordInput.setText("");
                    dbConnection.close();
                    return;
                }
                
                String Description = sqlQuery.getString("username") + " has logged in!";
                String Type = role.toLowerCase();
                createQuery = dbConnection.prepareStatement("insert into logs (description, type) values (?, ?)");
                createQuery.setString(1, Description);
                createQuery.setString(2, Type);
                createQuery.executeUpdate();
                
                getID = sqlQuery.getInt("id");
                
                dispose();
                AdminPortal showPage = new AdminPortal(getID);
                showPage.setVisible(true);
                dbConnection.close();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Something went wrong!", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_loginBTNActionPerformed

    private void signupBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBTNActionPerformed
        dispose();
        Signup showSignup = new Signup();
        showSignup.setVisible(true);
    }//GEN-LAST:event_signupBTNActionPerformed

    private void loginGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginGroupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email_username_label;
    private javax.swing.JLabel headerLogo;
    private javax.swing.JButton loginBTN;
    private javax.swing.JComboBox<String> loginGroup;
    private javax.swing.JLabel loginGroupLabel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JButton signupBTN;
    private javax.swing.JTextField uEmailInput;
    // End of variables declaration//GEN-END:variables
}