
import java.awt.Toolkit;
import java.sql.*;
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
public class InstructorPortal extends javax.swing.JFrame {
    PreparedStatement createQuery;
    ResultSet sqlQuery;
    int userID;
    String isCourse;
    String isSemester;
    String isLevel;
    String isName;
    String isPhone;
    String isAddress;
    String isEmail;
    
    /**
     * Creates new form StudentPortal
     */
    public InstructorPortal(int id) {
        super();
        initComponents();
        this.userID = id;
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon/herald_icon.png")));
        setHeadLabel(id);
        displayCourses();
    }
    
    public Connection checkConnection() {
        db startDB = new db();
        Connection confirmConn = startDB.checkConnection();
        return confirmConn;
    }
    
    public void setHeadLabel(int id) {
        try {
            Connection dbConnection = checkConnection();
            int userID = id;
            createQuery = dbConnection.prepareStatement("select * from instructors where id = ?");
            createQuery.setInt(1, userID);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
            profileName.setText("Hello, " + sqlQuery.getString("fullname"));
            this.isName = sqlQuery.getString("fullname");
            this.isPhone = sqlQuery.getString("phone");
            this.isAddress = sqlQuery.getString("address");
            this.isEmail = sqlQuery.getString("email");
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public void displayCourses() {
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_instructors where instructors = ?");
            createQuery.setString(1, isName);
            sqlQuery = createQuery.executeQuery();
            
            DefaultTableModel cTableModel = (DefaultTableModel)coursesTable.getModel();
            cTableModel.setRowCount(0); // clearing table data.
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String module = sqlQuery.getString("module");
                String semester = sqlQuery.getString("semester");
                String level = sqlQuery.getString("level");
                
                String tableData[] = {id, module, semester, level};
                cTableModel.addRow(tableData);
                coursesTable.setEnabled(false);
                dbConnection.close();
                return;
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public void displayInstructors() {
        try {
            Connection dbConnection = checkConnection();
            
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_instructors");
            sqlQuery = createQuery.executeQuery();
            
            DefaultTableModel instTableModel = (DefaultTableModel)instructorsTable.getModel();
            instTableModel.setRowCount(0); // clearing table data.
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String moduleData = sqlQuery.getString("module");
                String nameData = sqlQuery.getString("instructors");
                String emailData = sqlQuery.getString("email");
                
                String tableData[] = {id, moduleData, nameData, emailData};
                instTableModel.addRow(tableData);
                instructorsTable.setEnabled(false);
                dbConnection.close();
                return;
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public void displayStudents() {
        String storeteachersModule;
        try {
            Connection dbConnection = checkConnection();
            
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_instructors where instructors = ?");
            createQuery.setString(1, isName);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong!");
                return;
            }
            storeteachersModule = sqlQuery.getString("module");
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_students where (module1 = ? or module2 = ? or module3 = ? or module4 = ? or module5 = ? or module6 = ?)");
            createQuery.setString(1, storeteachersModule);
            createQuery.setString(2, storeteachersModule);
            createQuery.setString(3, storeteachersModule);
            createQuery.setString(4, storeteachersModule);
            createQuery.setString(5, storeteachersModule);
            createQuery.setString(6, storeteachersModule);
            sqlQuery = createQuery.executeQuery();
            
            DefaultTableModel studentTableModel = (DefaultTableModel)studentTable.getModel();
            studentTableModel.setRowCount(0); // clearing table data.
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String studentName = sqlQuery.getString("student");
                String studentEmail = sqlQuery.getString("email");
                String module = storeteachersModule;
                
                String tableData[] = {id, studentName, studentEmail, module};
                studentTableModel.addRow(tableData);
                studentTable.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        navBar = new javax.swing.JPanel();
        profileName = new javax.swing.JLabel();
        headerText = new javax.swing.JLabel();
        navMenuPanel = new javax.swing.JPanel();
        logoutBTN = new javax.swing.JButton();
        coursesBTN = new javax.swing.JButton();
        profileBTN = new javax.swing.JButton();
        InstructorsBTN = new javax.swing.JButton();
        viewResultBTN = new javax.swing.JButton();
        mainBody = new javax.swing.JPanel();
        coursesContent = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        profileContent = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        genderInput = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        savePassBTN = new javax.swing.JButton();
        emailLabel2 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneInput = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        profileSeperator = new javax.swing.JSeparator();
        HorizontalSeperator = new javax.swing.JSeparator();
        mainProfileSeperator = new javax.swing.JSeparator();
        personalDetailsSeperator = new javax.swing.JSeparator();
        yourProfileLabel1 = new javax.swing.JLabel();
        oldpassLabel = new javax.swing.JLabel();
        privacyLine = new javax.swing.JSeparator();
        privacyLabel = new javax.swing.JLabel();
        newPassLabel = new javax.swing.JLabel();
        confirmNewPassLabel = new javax.swing.JLabel();
        confirmPassInput = new javax.swing.JPasswordField();
        oldPassInput = new javax.swing.JPasswordField();
        newPassInput = new javax.swing.JPasswordField();
        personalDetailsSeperator1 = new javax.swing.JSeparator();
        sidePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        teachersContent = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        instructorsTable = new javax.swing.JTable();
        studentContent = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        updateResultBTN = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        navBar.setBackground(new java.awt.Color(204, 0, 204));

        profileName.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        profileName.setForeground(new java.awt.Color(255, 255, 255));
        profileName.setText("Welcome, Instructor");

        headerText.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("Teacher Dashboard");

        navMenuPanel.setBackground(new java.awt.Color(204, 255, 204));

        logoutBTN.setBackground(new java.awt.Color(204, 204, 204));
        logoutBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        logoutBTN.setText("Logout");
        logoutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBTNActionPerformed(evt);
            }
        });

        coursesBTN.setBackground(new java.awt.Color(204, 204, 204));
        coursesBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        coursesBTN.setText("Modules");
        coursesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesBTNActionPerformed(evt);
            }
        });

        profileBTN.setBackground(new java.awt.Color(204, 204, 204));
        profileBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        profileBTN.setText("Profile");
        profileBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBTNActionPerformed(evt);
            }
        });

        InstructorsBTN.setBackground(new java.awt.Color(204, 204, 204));
        InstructorsBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        InstructorsBTN.setText("Instructors");
        InstructorsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructorsBTNActionPerformed(evt);
            }
        });

        viewResultBTN.setBackground(new java.awt.Color(204, 204, 204));
        viewResultBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        viewResultBTN.setText("Students");
        viewResultBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navMenuPanelLayout = new javax.swing.GroupLayout(navMenuPanel);
        navMenuPanel.setLayout(navMenuPanelLayout);
        navMenuPanelLayout.setHorizontalGroup(
            navMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coursesBTN)
                .addGap(12, 12, 12)
                .addComponent(InstructorsBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewResultBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileBTN)
                .addGap(12, 12, 12)
                .addComponent(logoutBTN)
                .addGap(308, 308, 308))
        );
        navMenuPanelLayout.setVerticalGroup(
            navMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBTN)
                    .addComponent(coursesBTN)
                    .addComponent(profileBTN)
                    .addComponent(InstructorsBTN)
                    .addComponent(viewResultBTN))
                .addGap(576, 576, 576))
        );

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(navMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileName)
                    .addComponent(headerText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainBody.setLayout(new java.awt.CardLayout());

        coursesContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coursesContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coursesTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Module", "Semester", "Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(coursesTable);

        coursesContent.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1140, 560));

        mainBody.add(coursesContent, "card2");

        profileContent.setBackground(new java.awt.Color(255, 255, 255));
        profileContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        profileContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel.setBackground(new java.awt.Color(0, 0, 0));
        nameLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name");
        profileContent.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 100, 30));

        nameInput.setEditable(false);
        nameInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        nameInput.setForeground(new java.awt.Color(102, 102, 102));
        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });
        profileContent.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 190, 30));

        genderInput.setEditable(false);
        genderInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        genderInput.setForeground(new java.awt.Color(102, 102, 102));
        genderInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderInputActionPerformed(evt);
            }
        });
        profileContent.add(genderInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 190, 30));

        genderLabel.setBackground(new java.awt.Color(0, 0, 0));
        genderLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Gender");
        profileContent.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 100, 30));

        emailInput.setEditable(false);
        emailInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        emailInput.setForeground(new java.awt.Color(102, 102, 102));
        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });
        profileContent.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 190, 30));

        emailLabel.setBackground(new java.awt.Color(0, 0, 0));
        emailLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");
        profileContent.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 100, 30));

        savePassBTN.setBackground(new java.awt.Color(51, 51, 51));
        savePassBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        savePassBTN.setForeground(new java.awt.Color(255, 255, 255));
        savePassBTN.setText("Submit");
        savePassBTN.setToolTipText("");
        savePassBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePassBTNActionPerformed(evt);
            }
        });
        profileContent.add(savePassBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 120, -1));

        emailLabel2.setBackground(new java.awt.Color(0, 0, 0));
        emailLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        emailLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel2.setText("Username");
        profileContent.add(emailLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 100, 30));

        usernameInput.setEditable(false);
        usernameInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        usernameInput.setForeground(new java.awt.Color(102, 102, 102));
        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });
        profileContent.add(usernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 190, 30));

        phoneLabel.setBackground(new java.awt.Color(0, 0, 0));
        phoneLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setText("Phone");
        profileContent.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 100, 30));

        phoneInput.setEditable(false);
        phoneInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        phoneInput.setForeground(new java.awt.Color(102, 102, 102));
        phoneInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneInputActionPerformed(evt);
            }
        });
        profileContent.add(phoneInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 190, 30));

        addressLabel.setBackground(new java.awt.Color(0, 0, 0));
        addressLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressLabel.setText("Address");
        profileContent.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 100, 30));

        addressInput.setEditable(false);
        addressInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        addressInput.setForeground(new java.awt.Color(102, 102, 102));
        addressInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressInputActionPerformed(evt);
            }
        });
        profileContent.add(addressInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 190, 30));
        profileContent.add(profileSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 10));
        profileContent.add(HorizontalSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 630, 10));

        mainProfileSeperator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        profileContent.add(mainProfileSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 10, 520));

        personalDetailsSeperator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        profileContent.add(personalDetailsSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 10, 200));

        yourProfileLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        yourProfileLabel1.setText("Personal Details");
        profileContent.add(yourProfileLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        oldpassLabel.setBackground(new java.awt.Color(0, 0, 0));
        oldpassLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        oldpassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oldpassLabel.setText("Old Password");
        profileContent.add(oldpassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 320, 100, 30));
        profileContent.add(privacyLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 160, 10));

        privacyLabel.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        privacyLabel.setText("Privacy & Security");
        profileContent.add(privacyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        newPassLabel.setBackground(new java.awt.Color(0, 0, 0));
        newPassLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        newPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newPassLabel.setText("New Password");
        profileContent.add(newPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 100, 30));

        confirmNewPassLabel.setBackground(new java.awt.Color(0, 0, 0));
        confirmNewPassLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        confirmNewPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmNewPassLabel.setText("Confirm New password");
        profileContent.add(confirmNewPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 160, 30));

        confirmPassInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        confirmPassInput.setToolTipText("<html>\n        <p>Password must contain at least one digit [0-9].</p><br>\n        <p>Password must contain at least one lowercase Latin character [a-z].</p><br>\n        <p>Password must contain at least one uppercase Latin character [A-Z].</p><br>\n        <p>Password must contain at least one special character like ! @ # & ( ).</p><br>\n        <p>Password must contain a length of at least 8 characters and a maximum of 20 characters.</p>\n</html>");
        confirmPassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassInputActionPerformed(evt);
            }
        });
        profileContent.add(confirmPassInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 200, -1));

        oldPassInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        oldPassInput.setToolTipText("<html>\n        <p>Password must contain at least one digit [0-9].</p><br>\n        <p>Password must contain at least one lowercase Latin character [a-z].</p><br>\n        <p>Password must contain at least one uppercase Latin character [A-Z].</p><br>\n        <p>Password must contain at least one special character like ! @ # & ( ).</p><br>\n        <p>Password must contain a length of at least 8 characters and a maximum of 20 characters.</p>\n</html>");
        oldPassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPassInputActionPerformed(evt);
            }
        });
        profileContent.add(oldPassInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 200, -1));

        newPassInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        newPassInput.setToolTipText("<html>\n        <p>Password must contain at least one digit [0-9].</p><br>\n        <p>Password must contain at least one lowercase Latin character [a-z].</p><br>\n        <p>Password must contain at least one uppercase Latin character [A-Z].</p><br>\n        <p>Password must contain at least one special character like ! @ # & ( ).</p><br>\n        <p>Password must contain a length of at least 8 characters and a maximum of 20 characters.</p>\n</html>");
        newPassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassInputActionPerformed(evt);
            }
        });
        profileContent.add(newPassInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 200, -1));

        personalDetailsSeperator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        profileContent.add(personalDetailsSeperator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 10, 200));

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seriously.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setToolTipText("NERD");
        sidePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 530, 520));

        profileContent.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 490, 510));

        mainBody.add(profileContent, "card2");

        teachersContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        teachersContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructorsTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        instructorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Module", "Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(instructorsTable);

        teachersContent.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1140, 560));

        mainBody.add(teachersContent, "card2");

        studentContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        studentContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Name", "Email", "Module"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(studentTable);

        studentContent.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1140, 510));

        updateResultBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        updateResultBTN.setText("Update Result");
        updateResultBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateResultBTNActionPerformed(evt);
            }
        });
        studentContent.add(updateResultBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, 130, -1));

        mainBody.add(studentContent, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void genderInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderInputActionPerformed

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void savePassBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePassBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from instructors where id = ?");
            createQuery.setInt(1, userID);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong, #3436", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }

            String oldpass = String.valueOf(oldPassInput.getPassword());
            String newpass = String.valueOf(newPassInput.getPassword());
            String confirmpass = String.valueOf(confirmPassInput.getPassword());

            if (!sqlQuery.getString("password").equals(oldpass)) {
                JOptionPane.showMessageDialog(this, "Old password does not match!", "ERROR", JOptionPane.ERROR_MESSAGE);
                oldPassInput.setText("");
                newPassInput.setText("");
                confirmPassInput.setText("");
                dbConnection.close();
                return;
            }

            if (!newpass.equals(confirmpass)) {
                JOptionPane.showMessageDialog(this, "New password does not match!", "ERROR", JOptionPane.ERROR_MESSAGE);
                oldPassInput.setText("");
                newPassInput.setText("");
                confirmPassInput.setText("");
                dbConnection.close();
                return;
            }

            if (oldpass.equals(newpass)) {
                JOptionPane.showMessageDialog(this, "New password cannot be the same as old password!", "ERROR", JOptionPane.ERROR_MESSAGE);
                oldPassInput.setText("");
                newPassInput.setText("");
                confirmPassInput.setText("");
                dbConnection.close();
                return;
            }

            createQuery = dbConnection.prepareStatement("update instructors set password = ? where id = ?");
            createQuery.setString(1, newpass);
            createQuery.setInt(2, userID);
            createQuery.executeUpdate();
            JOptionPane.showMessageDialog(this, "Password changed successfully!", "INFO", JOptionPane.INFORMATION_MESSAGE);
            String Description = sqlQuery.getString("username") + " has updated their password!";
            String Type = "instructors";
            createQuery = dbConnection.prepareStatement("insert into logs (description, type) values (?, ?)");
            createQuery.setString(1, Description);
            createQuery.setString(2, Type);
            createQuery.executeUpdate();
            oldPassInput.setText("");
            newPassInput.setText("");
            confirmPassInput.setText("");
            dbConnection.close();
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_savePassBTNActionPerformed

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameInputActionPerformed

    private void phoneInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneInputActionPerformed

    private void addressInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressInputActionPerformed

    private void confirmPassInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassInputActionPerformed

    private void oldPassInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPassInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPassInputActionPerformed

    private void newPassInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassInputActionPerformed

    private void profileBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(profileContent);
        mainBody.repaint();
        mainBody.revalidate();
        
        nameInput.setText("");
        genderInput.setText("");
        usernameInput.setText("");
        phoneInput.setText("");
        addressInput.setText("");
        emailInput.setText("");
        
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select fullname, gender, username, phone, address, email from instructors where id = ?");
            createQuery.setInt(1, userID);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong, #3436", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
            
            nameInput.setText(sqlQuery.getString("fullname"));
            genderInput.setText(sqlQuery.getString("gender"));
            usernameInput.setText(sqlQuery.getString("username"));
            phoneInput.setText(sqlQuery.getString("phone"));
            addressInput.setText(sqlQuery.getString("address"));
            emailInput.setText(sqlQuery.getString("email"));
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_profileBTNActionPerformed

    private void coursesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(coursesContent);
        mainBody.repaint();
        mainBody.revalidate();
        displayCourses();
    }//GEN-LAST:event_coursesBTNActionPerformed

    private void InstructorsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructorsBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(teachersContent);
        mainBody.repaint();
        mainBody.revalidate();
        displayInstructors();
    }//GEN-LAST:event_InstructorsBTNActionPerformed

    private void viewResultBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(studentContent);
        mainBody.repaint();
        mainBody.revalidate();
        displayStudents();
    }//GEN-LAST:event_viewResultBTNActionPerformed

    private void logoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBTNActionPerformed
        dispose();
        Login showPage = new Login();
        showPage.setVisible(true);
    }//GEN-LAST:event_logoutBTNActionPerformed

    private void updateResultBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateResultBTNActionPerformed
        String getTeachersModule = null;
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from enrolled_module_instructors where instructors = ?");
            createQuery.setString(1, isName);
            
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong!");
                return;
            }
            getTeachersModule = sqlQuery.getString("module");
        } catch (SQLException exp) {
            System.out.println(exp);
        }
        
        AddResult showPage = new AddResult(getTeachersModule, isName);
        showPage.setVisible(true);
    }//GEN-LAST:event_updateResultBTNActionPerformed

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
                new InstructorPortal(0).setVisible(true);
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalSeperator;
    private javax.swing.JButton InstructorsBTN;
    private javax.swing.JTextField addressInput;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel confirmNewPassLabel;
    private javax.swing.JPasswordField confirmPassInput;
    private javax.swing.JButton coursesBTN;
    private javax.swing.JPanel coursesContent;
    private javax.swing.JTable coursesTable;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JTextField genderInput;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel headerText;
    private javax.swing.JTable instructorsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JPanel mainBody;
    private javax.swing.JSeparator mainProfileSeperator;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel navMenuPanel;
    private javax.swing.JPasswordField newPassInput;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JPasswordField oldPassInput;
    private javax.swing.JLabel oldpassLabel;
    private javax.swing.JSeparator personalDetailsSeperator;
    private javax.swing.JSeparator personalDetailsSeperator1;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel privacyLabel;
    private javax.swing.JSeparator privacyLine;
    private javax.swing.JButton profileBTN;
    private javax.swing.JPanel profileContent;
    private javax.swing.JLabel profileName;
    private javax.swing.JSeparator profileSeperator;
    private javax.swing.JButton savePassBTN;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel studentContent;
    private javax.swing.JTable studentTable;
    private javax.swing.JPanel teachersContent;
    private javax.swing.JButton updateResultBTN;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JButton viewResultBTN;
    private javax.swing.JLabel yourProfileLabel1;
    // End of variables declaration//GEN-END:variables
}
