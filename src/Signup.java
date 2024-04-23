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
import javax.swing.*;
import java.util.regex.Pattern;
public class Signup extends javax.swing.JFrame {
    Statement prepareQuery;
    ResultSet sqlQuery;
    /**
     * Creates new form Login
     */
    public Signup() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon/herald_icon.png")));
        fetchCoursesData();
    }
    
    public void fetchCoursesData() {
        try {
            Connection dbConnection = checkConnection();
            prepareQuery = dbConnection.createStatement();
            sqlQuery = prepareQuery.executeQuery("select name, isActive from courses where isActive = 1");
            while (sqlQuery.next()) {
                String getCoursesName = sqlQuery.getString("name");
                courseInput.addItem(getCoursesName);
            }
            
        } catch (Exception exp) {
            System.out.println(exp);
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

        headerLogo = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passInput = new javax.swing.JPasswordField();
        email_username_label1 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        email_username_label2 = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        email_username_label3 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JLabel();
        confirmpassInput = new javax.swing.JPasswordField();
        signupBTN = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();
        loginBTN = new javax.swing.JButton();
        loginGroupLabel = new javax.swing.JLabel();
        roleGroup = new javax.swing.JComboBox<>();
        courseLabel = new javax.swing.JLabel();
        courseInput = new javax.swing.JComboBox<>();
        username = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        phoneInput = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        sexLabel = new javax.swing.JLabel();
        sexGroup = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CMS | Signup");
        setBackground(java.awt.Color.white);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        headerLogo.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        headerLogo.setText("Signup");
        headerLogo.setToolTipText("");

        emailInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        email.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        email.setText("Email");

        passwordLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        passwordLabel.setText("Password");

        passInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        passInput.setToolTipText("<html>\n        <p>Password must contain at least one digit [0-9].</p><br>\n        <p>Password must contain at least one lowercase Latin character [a-z].</p><br>\n        <p>Password must contain at least one uppercase Latin character [A-Z].</p><br>\n        <p>Password must contain at least one special character like ! @ # & ( ).</p><br>\n        <p>Password must contain a length of at least 8 characters and a maximum of 20 characters.</p>\n</html>");
        passInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passInputActionPerformed(evt);
            }
        });

        email_username_label1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        email_username_label1.setText("Fiirstname");

        firstname.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        email_username_label2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        email_username_label2.setText("Middlename");

        middlename.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        email_username_label3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        email_username_label3.setText("Lastname");

        lastname.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        passwordLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        passwordLabel1.setText("Confirm Password");

        confirmpassInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        confirmpassInput.setToolTipText("<html>         <p>Password must contain at least one digit [0-9].</p><br>         <p>Password must contain at least one lowercase Latin character [a-z].</p><br>         <p>Password must contain at least one uppercase Latin character [A-Z].</p><br>         <p>Password must contain at least one special character like ! @ # & ( ).</p><br>         <p>Password must contain a length of at least 8 characters and a maximum of 20 characters.</p> </html>");
        confirmpassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpassInputActionPerformed(evt);
            }
        });

        signupBTN.setBackground(new java.awt.Color(102, 204, 0));
        signupBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        signupBTN.setForeground(new java.awt.Color(255, 255, 255));
        signupBTN.setText("Signup");
        signupBTN.setToolTipText("");
        signupBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBTNActionPerformed(evt);
            }
        });

        loginLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loginLabel.setText("Already have an account?");

        loginBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loginBTN.setText("Login");
        loginBTN.setToolTipText("");
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });

        loginGroupLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loginGroupLabel.setText("Who are you?");

        roleGroup.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        roleGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Instructor", "Admin" }));
        roleGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleGroupActionPerformed(evt);
            }
        });

        courseLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        courseLabel.setText("Select Course");

        courseInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        courseInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseInputActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        username.setText("Username");

        usernameInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        phoneInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        phoneLabel.setText("Phone number");

        addressLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        addressLabel.setText("Address");

        addressInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        sexLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        sexLabel.setText("Sex");

        sexGroup.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        sexGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Prefer not say" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email_username_label1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(email_username_label2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(middlename))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email_username_label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(confirmpassInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email)
                            .addComponent(passwordLabel)
                            .addComponent(passwordLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneInput)
                            .addComponent(usernameInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneLabel)
                                    .addComponent(username))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sexGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sexLabel)
                                    .addComponent(addressLabel))
                                .addGap(208, 208, 208))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginGroupLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(roleGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signupBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(loginLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(headerLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(headerLogo)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(email_username_label1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(email_username_label2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email_username_label3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username)
                    .addComponent(sexLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phoneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmpassInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginGroupLabel)
                            .addComponent(courseLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roleGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(courseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(signupBTN)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginBTN))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passInputActionPerformed

    private void confirmpassInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpassInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassInputActionPerformed

    public Connection checkConnection() {
        db startDB = new db();
        Connection confirmConn = startDB.checkConnection();
        return confirmConn;
    }
    private void signupBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            String getFirstname = firstname.getText();
            String getMiddlename = middlename.getText();
            String getLastname = lastname.getText();
            String getUsername = usernameInput.getText();
            String getEmail = emailInput.getText();
            String availRegex = "^[\\S]+@(heraldcollege\\.edu\\.np|heraldcollegekathmandu\\.com)$";
            String getGender = sexGroup.getSelectedItem().toString();
            String getPhone = phoneInput.getText();
            String phoneRegex = "([0-9]).{9}$";
            String getAddress = addressInput.getText();
            String role = roleGroup.getSelectedItem().toString();
            String getCourse = courseInput.getSelectedItem().toString();
            String password = String.valueOf(passInput.getPassword());
            String passRegex = "^(?!.*\\\\s)(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
            String confirmpassword = String.valueOf(confirmpassInput.getPassword());
            prepareQuery = dbConnection.createStatement();
            
            if (getFirstname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your first name!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (getLastname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your last name!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (getUsername.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your username!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (getPhone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your phone number!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (getAddress.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your address!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (getEmail.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your email!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your password!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (confirmpassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please confirm your password!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!Pattern.matches(availRegex, getEmail)) {
                JOptionPane.showMessageDialog(this, "Please use the email provided by the college!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!Pattern.matches(passRegex, password)) {
                JOptionPane.showMessageDialog(this, "Pasword is not strong!");
                return;
            }
            
            if (!Pattern.matches(phoneRegex, getPhone)) {
                JOptionPane.showMessageDialog(this, "Phone number must be 10 digits!");
                return;
            }
            
            if (password.equals(confirmpassword)) {
                if ("Student".equals(role)) {
                    sqlQuery = prepareQuery.executeQuery("select username, phone, email from students");
                    if (sqlQuery.next()) {
                        if (sqlQuery.getString("username").equals(getUsername)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this username is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                        if (sqlQuery.getString("email").equals(getEmail)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this email is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                        if (sqlQuery.getString("phone").equals(getPhone)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this phone number is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                    }
                    
                    if (!getMiddlename.isEmpty()) {
                        String fullname = getFirstname + " " + getMiddlename + " " + getLastname;
                        prepareQuery.executeUpdate("insert into students (fullname, gender, username, phone, address, email, course, password) values ('"+ fullname +"', '" + getGender +"', '" + getUsername + "', '" + getPhone +"', '" + getAddress +"', '" + getEmail +"', '" + getCourse +"','" + password + "')");
                    } else {
                        String fullname = getFirstname + " " + getLastname;
                        prepareQuery.executeUpdate("insert into students (fullname, gender, username, phone, address, email, course, password) values ('"+ fullname +"', '" + getGender +"', '" + getUsername + "', '" + getPhone +"', '" + getAddress +"', '" + getEmail +"', '" + getCourse +"','" + password + "')");
                    }
                } else if ("Instructor".equals(role)) {
                    sqlQuery = prepareQuery.executeQuery("select username, phone, email from instructors");
                    if (sqlQuery.next()) {
                        if (sqlQuery.getString("username").equals(getUsername)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this username is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                        if (sqlQuery.getString("email").equals(getEmail)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this email is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                        if (sqlQuery.getString("phone").equals(getPhone)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this phone number is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                    }
                    if (!getMiddlename.isEmpty()) {
                        String fullname = getFirstname + " " + getMiddlename + " " + getLastname;
                        prepareQuery.executeUpdate("insert into instructors (fullname, gender, username, phone, address, email, password) values ('"+ fullname +"', '" + getGender +"', '" + getUsername + "', '" + getPhone +"', '" + getAddress +"', '" + getEmail +"','" + password + "')");
                    } else {
                        String fullname = getFirstname + " " + getLastname;
                        prepareQuery.executeUpdate("insert into instructors (fullname, gender, username, phone, address, email, password) values ('"+ fullname +"', '" + getGender +"', '" + getUsername + "', '" + getPhone +"', '" + getAddress +"', '" + getEmail +"','" + password + "')");
                    }
                } else if ("Admin".equals(role)) {
                    sqlQuery = prepareQuery.executeQuery("select username, phone, email from admins");
                    if (sqlQuery.next()) {
                        if (sqlQuery.getString("username").equals(getUsername)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this username is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                        if (sqlQuery.getString("email").equals(getEmail)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this email is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                        if (sqlQuery.getString("phone").equals(getPhone)) {
                            JOptionPane.showMessageDialog(this, "Sorry, this phone number is already in use!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            dbConnection.close();
                            return;
                        }
                    }
                    if (!getMiddlename.isEmpty()) {
                        String fullname = getFirstname + " " + getMiddlename + " " + getLastname;
                        prepareQuery.executeUpdate("insert into admins (fullname, gender, username, phone, address, email, password) values ('"+ fullname +"', '" + getGender +"', '" + getUsername + "', '" + getPhone +"', '" + getAddress +"', '" + getEmail +"', '" + password + "')");
                    } else {
                        String fullname = getFirstname + " " + getLastname;
                        prepareQuery.executeUpdate("insert into admins (fullname, gender, username, phone, address, email, password) values ('"+ fullname +"', '" + getGender +"', '" + getUsername + "', '" + getPhone +"', '" + getAddress +"', '" + getEmail +"', '" + password + "')");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong! Error Code: #3435", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(this, "You have successfully registered, you may login now!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                Login showPage = new Login();
                showPage.setVisible(true);
                dbConnection.close();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "The password does not match!", "ERROR", JOptionPane.ERROR_MESSAGE);
                firstname.setText("");
                middlename.setText("");
                lastname.setText("");
                usernameInput.setText("");
                emailInput.setText("");
                passInput.setText("");
                confirmpassInput.setText("");
                dbConnection.close();
                return;
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_signupBTNActionPerformed

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        dispose();
        Login showLogin = new Login();
        showLogin.setVisible(true);
    }//GEN-LAST:event_loginBTNActionPerformed

    private void roleGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleGroupActionPerformed
        String role = roleGroup.getSelectedItem().toString();
        if (role != "Student") {
            courseLabel.setVisible(false);
            courseInput.setVisible(false);
            return;
        }
        courseLabel.setVisible(true);
        courseInput.setVisible(true);
        return;
    }//GEN-LAST:event_roleGroupActionPerformed

    private void courseInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseInputActionPerformed

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
                new Signup().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressInput;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JPasswordField confirmpassInput;
    private javax.swing.JComboBox<String> courseInput;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel email_username_label1;
    private javax.swing.JLabel email_username_label2;
    private javax.swing.JLabel email_username_label3;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel headerLogo;
    private javax.swing.JTextField lastname;
    private javax.swing.JButton loginBTN;
    private javax.swing.JLabel loginGroupLabel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField middlename;
    private javax.swing.JPasswordField passInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JComboBox<String> roleGroup;
    private javax.swing.JComboBox<String> sexGroup;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JButton signupBTN;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}