
import java.awt.Toolkit;
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
import javax.swing.JTextField;
public class AdminPortal extends javax.swing.JFrame {
    PreparedStatement createQuery;
    ResultSet sqlQuery;
    int userID;
    
    public AdminPortal(int id) {
        super();
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        this.userID = id;
        setHeadLabel(id);
    }
    
    public void viewAllInstructors() {
        DefaultTableModel instructorsModel = (DefaultTableModel)instructorsTable.getModel();
        instructorsModel.setRowCount(0); // clearing table data.
            
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from instructors");
            sqlQuery = createQuery.executeQuery();
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String fullname = sqlQuery.getString("fullname");
                String phone = sqlQuery.getString("phone");
                String address = sqlQuery.getString("address");
                String email = sqlQuery.getString("email");
                
                String tableData[] = {id, fullname, phone, address, email};
                instructorsModel.addRow(tableData);
                instructorsTable.setEnabled(false);
                dbConnection.close();
                return;
            }
            
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public void viewAllStudents() {
        DefaultTableModel studentsModel = (DefaultTableModel)studentsTable.getModel();
        studentsModel.setRowCount(0); // clearing table data.
            
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from students");
            sqlQuery = createQuery.executeQuery();
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String fullname = sqlQuery.getString("fullname");
                String phone = sqlQuery.getString("phone");
                String address = sqlQuery.getString("address");
                String email = sqlQuery.getString("email");
                
                String tableData[] = {id, fullname, phone, address, email};
                studentsModel.addRow(tableData);
                studentsTable.setEnabled(false);
                dbConnection.close();
                return;
            }
            
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    
    public void viewCoursesData() {
        DefaultTableModel tableModel = (DefaultTableModel)listOfCoursesTable.getModel();
        tableModel.setRowCount(0); // clearing table data.
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from courses");
            sqlQuery = createQuery.executeQuery();
            
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String name = sqlQuery.getString("name");
                int isActive = sqlQuery.getInt("isActive");
                String activeLabel = null;
                if (isActive == 1) {
                    activeLabel = "Available";
                } else if (isActive == 0) {
                    activeLabel = "Unavailable";
                } else {
                    activeLabel = "Error";
                }
                String tableData[] = {id, name, activeLabel};
                tableModel.addRow(tableData);
                listOfCoursesTable.setEnabled(false);
            }
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public void viewModulesData() {
        DefaultTableModel tableModel = (DefaultTableModel)listOfModulesTable.getModel();
        tableModel.setRowCount(0); // clearing table data.
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from modules");
            sqlQuery = createQuery.executeQuery();
            
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String course = sqlQuery.getString("course");
                String semester = sqlQuery.getString("semester");
                String level = sqlQuery.getString("level");
                String module1 = sqlQuery.getString("module1");
                String module2 = sqlQuery.getString("module2");
                String module3 = sqlQuery.getString("module3");
                String module4 = sqlQuery.getString("module4");
                String module5 = sqlQuery.getString("module5");
                String module6 = sqlQuery.getString("module6");
                String tableData[] = {id, course, semester, level, module1, module2, module3, module4, module5, module6};
                tableModel.addRow(tableData);
                listOfModulesLabel.setEnabled(false);
            }
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
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
            createQuery = dbConnection.prepareStatement("select fullname from admins where id = ?");
            createQuery.setInt(1, userID);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong, #3436", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
            profileName.setText("Hello, " + sqlQuery.getString("fullname"));
            return;
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

        navBar = new javax.swing.JPanel();
        profileName = new javax.swing.JLabel();
        headerText = new javax.swing.JLabel();
        navMenuPanel = new javax.swing.JPanel();
        logoutBTN = new javax.swing.JButton();
        homeBTN = new javax.swing.JButton();
        coursesBTN = new javax.swing.JButton();
        profileBTN = new javax.swing.JButton();
        instructorsBTN = new javax.swing.JButton();
        studentsBTN = new javax.swing.JButton();
        mainBody = new javax.swing.JPanel();
        homeContent = new javax.swing.JPanel();
        profileContent = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        genderInput = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        joinedLabel = new javax.swing.JLabel();
        joinedInput = new javax.swing.JTextField();
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
        coursesContent = new javax.swing.JPanel();
        viewModulesBTN = new javax.swing.JButton();
        viewCoursesBTN = new javax.swing.JButton();
        coursesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOfCoursesTable = new javax.swing.JTable();
        listOfCoursesLabel = new javax.swing.JLabel();
        courseDeleteBTN = new javax.swing.JButton();
        courseAddBTN = new javax.swing.JButton();
        courseEditBTN = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        modulesPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOfModulesTable = new javax.swing.JTable();
        listOfModulesLabel = new javax.swing.JLabel();
        moduleAddBTN = new javax.swing.JButton();
        moduleEditBTN = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        teachersContent = new javax.swing.JPanel();
        coursesPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        instructorsTable = new javax.swing.JTable();
        listOfCoursesLabel1 = new javax.swing.JLabel();
        addInstructorBTN = new javax.swing.JButton();
        modulesPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listOfModulesTable1 = new javax.swing.JTable();
        listOfModulesLabel1 = new javax.swing.JLabel();
        moduleAddBTN1 = new javax.swing.JButton();
        moduleEditBTN1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        studentContent = new javax.swing.JPanel();
        coursesPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        listOfCoursesLabel2 = new javax.swing.JLabel();
        moduleSubmitBTN = new javax.swing.JButton();
        modulesPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listOfModulesTable2 = new javax.swing.JTable();
        listOfModulesLabel2 = new javax.swing.JLabel();
        moduleAddBTN2 = new javax.swing.JButton();
        moduleEditBTN2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        navBar.setBackground(new java.awt.Color(153, 0, 153));

        profileName.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        profileName.setForeground(new java.awt.Color(255, 255, 255));
        profileName.setText("Welcome, Admin");

        headerText.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("Admin Dashboard");

        navMenuPanel.setBackground(new java.awt.Color(204, 255, 204));

        logoutBTN.setBackground(new java.awt.Color(204, 204, 204));
        logoutBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        logoutBTN.setText("Logout");
        logoutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBTNActionPerformed(evt);
            }
        });

        homeBTN.setBackground(new java.awt.Color(204, 204, 204));
        homeBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        homeBTN.setText("Home");
        homeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBTNActionPerformed(evt);
            }
        });

        coursesBTN.setBackground(new java.awt.Color(204, 204, 204));
        coursesBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        coursesBTN.setText("Courses");
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

        instructorsBTN.setBackground(new java.awt.Color(204, 204, 204));
        instructorsBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        instructorsBTN.setText("Instructors");
        instructorsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorsBTNActionPerformed(evt);
            }
        });

        studentsBTN.setBackground(new java.awt.Color(204, 204, 204));
        studentsBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        studentsBTN.setText("Students");
        studentsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navMenuPanelLayout = new javax.swing.GroupLayout(navMenuPanel);
        navMenuPanel.setLayout(navMenuPanelLayout);
        navMenuPanelLayout.setHorizontalGroup(
            navMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBTN)
                .addGap(18, 18, 18)
                .addComponent(coursesBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructorsBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentsBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutBTN)
                .addGap(265, 265, 265))
        );
        navMenuPanelLayout.setVerticalGroup(
            navMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBTN)
                    .addComponent(logoutBTN)
                    .addComponent(coursesBTN)
                    .addComponent(profileBTN)
                    .addComponent(instructorsBTN)
                    .addComponent(studentsBTN))
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
                .addComponent(profileName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

        homeContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        homeContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mainBody.add(homeContent, "card2");

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

        joinedLabel.setBackground(new java.awt.Color(0, 0, 0));
        joinedLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        joinedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joinedLabel.setText("Joined At");
        profileContent.add(joinedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 100, 30));

        joinedInput.setEditable(false);
        joinedInput.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        joinedInput.setForeground(new java.awt.Color(102, 102, 102));
        joinedInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinedInputActionPerformed(evt);
            }
        });
        profileContent.add(joinedInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 190, 30));

        savePassBTN.setBackground(new java.awt.Color(102, 204, 0));
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

        mainBody.add(profileContent, "card2");

        coursesContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coursesContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewModulesBTN.setBackground(new java.awt.Color(102, 204, 0));
        viewModulesBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        viewModulesBTN.setText("View Modules");
        viewModulesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewModulesBTNActionPerformed(evt);
            }
        });
        coursesContent.add(viewModulesBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 130, -1));

        viewCoursesBTN.setBackground(new java.awt.Color(102, 204, 0));
        viewCoursesBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        viewCoursesBTN.setText("View  Courses");
        viewCoursesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCoursesBTNActionPerformed(evt);
            }
        });
        coursesContent.add(viewCoursesBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        listOfCoursesTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        listOfCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Course", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listOfCoursesTable);

        listOfCoursesLabel.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        listOfCoursesLabel.setText("List of Courses");
        listOfCoursesLabel.setToolTipText("");

        courseDeleteBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        courseDeleteBTN.setText("Delete");
        courseDeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseDeleteBTNActionPerformed(evt);
            }
        });

        courseAddBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        courseAddBTN.setText("Add");
        courseAddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseAddBTNActionPerformed(evt);
            }
        });

        courseEditBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        courseEditBTN.setText("Edit");
        courseEditBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseEditBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursesPanelLayout = new javax.swing.GroupLayout(coursesPanel);
        coursesPanel.setLayout(coursesPanelLayout);
        coursesPanelLayout.setHorizontalGroup(
            coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanelLayout.createSequentialGroup()
                        .addComponent(listOfCoursesLabel)
                        .addGap(313, 313, 313)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 405, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(courseAddBTN)
                        .addGap(18, 18, 18)
                        .addComponent(courseEditBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseDeleteBTN)))
                .addContainerGap())
        );
        coursesPanelLayout.setVerticalGroup(
            coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanelLayout.createSequentialGroup()
                .addGroup(coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listOfCoursesLabel))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseDeleteBTN)
                    .addComponent(courseAddBTN)
                    .addComponent(courseEditBTN))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        coursesContent.add(coursesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 530));

        listOfModulesTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        listOfModulesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Course", "Semester", "Level", "Module 1", "Module 2", "Module 3", "Module 4", "Module 5", "Module 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(listOfModulesTable);

        listOfModulesLabel.setBackground(new java.awt.Color(0, 0, 0));
        listOfModulesLabel.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        listOfModulesLabel.setText("List Of Modules");
        listOfModulesLabel.setToolTipText("");

        moduleAddBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleAddBTN.setText("Add");
        moduleAddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleAddBTNActionPerformed(evt);
            }
        });

        moduleEditBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleEditBTN.setText("Edit");
        moduleEditBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleEditBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modulesPanelLayout = new javax.swing.GroupLayout(modulesPanel);
        modulesPanel.setLayout(modulesPanelLayout);
        modulesPanelLayout.setHorizontalGroup(
            modulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulesPanelLayout.createSequentialGroup()
                        .addComponent(listOfModulesLabel)
                        .addGap(313, 313, 313)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 401, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modulesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(moduleAddBTN)
                        .addGap(18, 18, 18)
                        .addComponent(moduleEditBTN)))
                .addContainerGap())
        );
        modulesPanelLayout.setVerticalGroup(
            modulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulesPanelLayout.createSequentialGroup()
                .addGroup(modulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listOfModulesLabel))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduleAddBTN)
                    .addComponent(moduleEditBTN))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        coursesContent.add(modulesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 530));

        mainBody.add(coursesContent, "card2");

        teachersContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        teachersContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructorsTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        instructorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Name", "Phone", "Address", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(instructorsTable);

        listOfCoursesLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        listOfCoursesLabel1.setText("List of Instructors");
        listOfCoursesLabel1.setToolTipText("");

        addInstructorBTN.setBackground(new java.awt.Color(102, 204, 0));
        addInstructorBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        addInstructorBTN.setText("Assign Module");
        addInstructorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstructorBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursesPanel1Layout = new javax.swing.GroupLayout(coursesPanel1);
        coursesPanel1.setLayout(coursesPanel1Layout);
        coursesPanel1Layout.setHorizontalGroup(
            coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanel1Layout.createSequentialGroup()
                        .addComponent(listOfCoursesLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursesPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addInstructorBTN)))
                .addContainerGap())
        );
        coursesPanel1Layout.setVerticalGroup(
            coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listOfCoursesLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addInstructorBTN)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        teachersContent.add(coursesPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 530));

        listOfModulesTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        listOfModulesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Course", "Semester", "Level", "Module 1", "Module 2", "Module 3", "Module 4", "Module 5", "Module 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(listOfModulesTable1);

        listOfModulesLabel1.setBackground(new java.awt.Color(0, 0, 0));
        listOfModulesLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        listOfModulesLabel1.setText("List Of Modules");
        listOfModulesLabel1.setToolTipText("");

        moduleAddBTN1.setBackground(new java.awt.Color(51, 204, 0));
        moduleAddBTN1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleAddBTN1.setText("Add");
        moduleAddBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleAddBTN1ActionPerformed(evt);
            }
        });

        moduleEditBTN1.setBackground(new java.awt.Color(102, 204, 0));
        moduleEditBTN1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleEditBTN1.setText("Edit");
        moduleEditBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleEditBTN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modulesPanel1Layout = new javax.swing.GroupLayout(modulesPanel1);
        modulesPanel1.setLayout(modulesPanel1Layout);
        modulesPanel1Layout.setHorizontalGroup(
            modulesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modulesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulesPanel1Layout.createSequentialGroup()
                        .addComponent(listOfModulesLabel1)
                        .addGap(313, 313, 313)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 401, Short.MAX_VALUE))
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modulesPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(moduleAddBTN1)
                        .addGap(18, 18, 18)
                        .addComponent(moduleEditBTN1)))
                .addContainerGap())
        );
        modulesPanel1Layout.setVerticalGroup(
            modulesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulesPanel1Layout.createSequentialGroup()
                .addGroup(modulesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulesPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listOfModulesLabel1))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modulesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduleAddBTN1)
                    .addComponent(moduleEditBTN1))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        teachersContent.add(modulesPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 530));

        mainBody.add(teachersContent, "card2");

        studentContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        studentContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentsTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Name", "Phone", "Address", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(studentsTable);

        listOfCoursesLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        listOfCoursesLabel2.setText("List of Students");
        listOfCoursesLabel2.setToolTipText("");

        moduleSubmitBTN.setBackground(new java.awt.Color(102, 204, 0));
        moduleSubmitBTN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleSubmitBTN.setText("View Result");
        moduleSubmitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleSubmitBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursesPanel2Layout = new javax.swing.GroupLayout(coursesPanel2);
        coursesPanel2.setLayout(coursesPanel2Layout);
        coursesPanel2Layout.setHorizontalGroup(
            coursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanel2Layout.createSequentialGroup()
                        .addComponent(listOfCoursesLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursesPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(moduleSubmitBTN)))
                .addContainerGap())
        );
        coursesPanel2Layout.setVerticalGroup(
            coursesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listOfCoursesLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moduleSubmitBTN)
                .addContainerGap())
        );

        studentContent.add(coursesPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 530));

        listOfModulesTable2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        listOfModulesTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Course", "Semester", "Level", "Module 1", "Module 2", "Module 3", "Module 4", "Module 5", "Module 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(listOfModulesTable2);

        listOfModulesLabel2.setBackground(new java.awt.Color(0, 0, 0));
        listOfModulesLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        listOfModulesLabel2.setText("List Of Modules");
        listOfModulesLabel2.setToolTipText("");

        moduleAddBTN2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleAddBTN2.setText("Add");
        moduleAddBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleAddBTN2ActionPerformed(evt);
            }
        });

        moduleEditBTN2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        moduleEditBTN2.setText("Edit");
        moduleEditBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleEditBTN2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modulesPanel2Layout = new javax.swing.GroupLayout(modulesPanel2);
        modulesPanel2.setLayout(modulesPanel2Layout);
        modulesPanel2Layout.setHorizontalGroup(
            modulesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulesPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modulesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulesPanel2Layout.createSequentialGroup()
                        .addComponent(listOfModulesLabel2)
                        .addGap(313, 313, 313)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 401, Short.MAX_VALUE))
                    .addComponent(jScrollPane7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modulesPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(moduleAddBTN2)
                        .addGap(18, 18, 18)
                        .addComponent(moduleEditBTN2)))
                .addContainerGap())
        );
        modulesPanel2Layout.setVerticalGroup(
            modulesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulesPanel2Layout.createSequentialGroup()
                .addGroup(modulesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulesPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listOfModulesLabel2))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modulesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduleAddBTN2)
                    .addComponent(moduleEditBTN2))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        studentContent.add(modulesPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 530));

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
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select username from admins where id = ?");
            createQuery.setInt(1, userID);
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                System.out.println("Something went wrong with the userid");
                return;
            }
            String Description = sqlQuery.getString("username") + " has logged out!";
            String Type = "admin";
            createQuery = dbConnection.prepareStatement("insert into logs (description, type) values (?, ?)");
            createQuery.setString(1, Description);
            createQuery.setString(2, Type);
            createQuery.executeUpdate();
            dispose();
            Login showPage = new Login();
            showPage.setVisible(true);
        } catch (Exception exp) {
            System.out.println(exp);
            return;
        }
    }//GEN-LAST:event_logoutBTNActionPerformed

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
            createQuery = dbConnection.prepareStatement("select fullname, gender, username, phone, address, email from admins where id = ?");
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

    private void homeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBTNActionPerformed
       mainBody.removeAll();
       mainBody.add(homeContent);
       mainBody.repaint();
       mainBody.revalidate();
    }//GEN-LAST:event_homeBTNActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void genderInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderInputActionPerformed

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void joinedInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinedInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joinedInputActionPerformed

    private void savePassBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePassBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from admins where id = ?");
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
         
            createQuery = dbConnection.prepareStatement("update admins set password = ? where id = ?");
            createQuery.setString(1, newpass);
            createQuery.setInt(2, userID);
            createQuery.executeUpdate();
            JOptionPane.showMessageDialog(this, "Password changed successfully!", "INFO", JOptionPane.INFORMATION_MESSAGE);
            String Description = sqlQuery.getString("username") + " has updated their password!";
            String Type = "admin";
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

    private void coursesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(coursesContent);
        mainBody.repaint();
        mainBody.revalidate();
        DefaultTableModel tableModel = (DefaultTableModel)listOfCoursesTable.getModel();
        tableModel.setRowCount(0); // clearing table data.
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from courses");
            sqlQuery = createQuery.executeQuery();
            
            while (sqlQuery.next()) {
                String id = String.valueOf(sqlQuery.getInt("id"));
                String name = sqlQuery.getString("name");
                int isActive = sqlQuery.getInt("isActive");
                String activeLabel = null;
                if (isActive == 1) {
                    activeLabel = "Available";
                } else if (isActive == 0) {
                    activeLabel = "Unavailable";
                } else {
                    activeLabel = "Error";
                }
                String tableData[] = {id, name, activeLabel};
                tableModel.addRow(tableData);
                listOfCoursesTable.setEnabled(false);
            }
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_coursesBTNActionPerformed

    private void courseDeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseDeleteBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            
            createQuery = dbConnection.prepareStatement("select count(*) from courses");
            sqlQuery = createQuery.executeQuery();
            int countRows = 0;
            
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            countRows = sqlQuery.getInt(1);
            if (countRows < 1) {
                JOptionPane.showMessageDialog(this, "Data is empty!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            String deleteCourse = (String) JOptionPane.showInputDialog(this, "Course ID", "Delete Course", JOptionPane.INFORMATION_MESSAGE);
            if (deleteCourse == null) {
                return;
            }
            
            if (deleteCourse.isEmpty()) {
                JOptionPane.showMessageDialog(this, "The field is empty", "INFO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            createQuery = dbConnection.prepareStatement("select * from courses where id = '"+deleteCourse+"'");
            sqlQuery = createQuery.executeQuery();
            if (!sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "Something went wrong");
                return;
            }
            
            String coursename = sqlQuery.getString("name");
            
            createQuery = dbConnection.prepareStatement("delete from courses where id = '"+deleteCourse+"'");
            int checkResult = createQuery.executeUpdate();
            
            if (checkResult != 1) {
                JOptionPane.showMessageDialog(this, "Someting went wrong while deleting the selected course!");
                return;
            }
            
            createQuery = dbConnection.prepareStatement("delete from modules where course = '"+coursename+"'");
            createQuery.executeUpdate(); 
            JOptionPane.showMessageDialog(this, "Successfully deleted the course");
            viewCoursesData();
            dbConnection.close();
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_courseDeleteBTNActionPerformed

    private void courseEditBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseEditBTNActionPerformed
        try {
            Connection dbConnection = checkConnection();
            JTextField courseid = new JTextField();
            JTextField course = new JTextField();
      
            Object [] fields = {
                "Enter course id", courseid,
                "Enter course name", course,
            };

            int checkDialog = JOptionPane.showConfirmDialog(null,fields,"Edit Course",JOptionPane.OK_CANCEL_OPTION);
            if (checkDialog != JOptionPane.OK_OPTION) {
                return;
            }

            int getCourseID = Integer.parseInt(courseid.getText());
            String getCourseName = course.getText();

            String[] confirmObj = { "yes", "no" }; 
            String addAvailability = (String) JOptionPane.showInputDialog(this, "Course Availability", "Add Course", JOptionPane.INFORMATION_MESSAGE, null, confirmObj, confirmObj[0]);
            if (addAvailability == null) {
                return;
            }

            int isActiveValue = 0;

            if (addAvailability == "yes") {
                isActiveValue = 1;
            } else if (addAvailability == "no") {
                isActiveValue = 0;
            } else {
                isActiveValue = 0;
            }

            createQuery = dbConnection.prepareStatement("update courses set name = ?, isActive = ? where id = ?");
            createQuery.setString(1, getCourseName);
            createQuery.setInt(2, isActiveValue);
            createQuery.setInt(3, getCourseID);
            int row = createQuery.executeUpdate();
            if (row != 1) {
                dbConnection.close();
                JOptionPane.showMessageDialog(this, "Something went wrong while update course details.", "INFO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Successfully updated course details", "INFO", JOptionPane.INFORMATION_MESSAGE);
            viewCoursesData();
            dbConnection.close();
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
        
    }//GEN-LAST:event_courseEditBTNActionPerformed

    private void moduleEditBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleEditBTNActionPerformed
        EditModule editModulePage = new EditModule();
        editModulePage.setVisible(true);
    }//GEN-LAST:event_moduleEditBTNActionPerformed

    private void viewModulesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewModulesBTNActionPerformed
        modulesPanel.setVisible(true);
        coursesPanel.setVisible(false);
        viewModulesData();
    }//GEN-LAST:event_viewModulesBTNActionPerformed

    private void viewCoursesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCoursesBTNActionPerformed
        modulesPanel.setVisible(false);
        coursesPanel.setVisible(true);
        viewCoursesData();
    }//GEN-LAST:event_viewCoursesBTNActionPerformed

    private void courseAddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseAddBTNActionPerformed
        String addResult = JOptionPane.showInputDialog(this, "Enter course name", "Add Course", JOptionPane.QUESTION_MESSAGE);
        
        if (addResult == null) {
            return;
        }
        
        if (addResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The message box is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String capResult = addResult.toUpperCase();
        
        try {
            Connection dbConnection = checkConnection();
            createQuery = dbConnection.prepareStatement("select * from courses where name = ?");
            createQuery.setString(1, capResult);
            sqlQuery = createQuery.executeQuery();
            if (sqlQuery.next()) {
                JOptionPane.showMessageDialog(this, "The course you have entered is already exists on our system!", "ERROR", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
            
            String[] confirmObj = { "yes", "no" }; 
            String addAvailability = (String) JOptionPane.showInputDialog(this, "Course Availability", "Add Course", JOptionPane.INFORMATION_MESSAGE, null, confirmObj, confirmObj[0]);
            if (addAvailability == null) {
                return;
            }
            
            int isActiveValue = 0;
            
            if (addAvailability == "yes") {
                isActiveValue = 1;
            } else if (addAvailability == "no") {
                isActiveValue = 0;
            } else {
                isActiveValue = 0;
            }
            
            createQuery = dbConnection.prepareStatement("insert into courses(name, isActive) values(?, ?)");
            createQuery.setString(1, capResult);
            createQuery.setInt(2, isActiveValue);
            int checkQuery = createQuery.executeUpdate();
            if (checkQuery != 1) {
                JOptionPane.showMessageDialog(this, "Someting went wrong while adding new courses. Please try again!", "INFO", JOptionPane.ERROR_MESSAGE);
                dbConnection.close();
                return;
            }
            
            JOptionPane.showMessageDialog(this, "Sucessfully added new courses into the system", "INFO", JOptionPane.INFORMATION_MESSAGE);
            viewCoursesData();
            dbConnection.close();
            return;
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }//GEN-LAST:event_courseAddBTNActionPerformed

    private void moduleAddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleAddBTNActionPerformed
        AddModule moduleBox = new AddModule();
        moduleBox.setVisible(true);
    }//GEN-LAST:event_moduleAddBTNActionPerformed

    private void addInstructorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInstructorBTNActionPerformed
        AssignModule showAssignPanel = new AssignModule();
        showAssignPanel.setVisible(true);
    }//GEN-LAST:event_addInstructorBTNActionPerformed

    private void moduleAddBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleAddBTN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moduleAddBTN1ActionPerformed

    private void moduleEditBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleEditBTN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moduleEditBTN1ActionPerformed

    private void instructorsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorsBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(teachersContent);
        mainBody.repaint();
        mainBody.revalidate();
        viewAllInstructors();
    }//GEN-LAST:event_instructorsBTNActionPerformed

    private void studentsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsBTNActionPerformed
        mainBody.removeAll();
        mainBody.add(studentContent);
        mainBody.repaint();
        mainBody.revalidate();
        viewAllStudents();
    }//GEN-LAST:event_studentsBTNActionPerformed

    private void moduleAddBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleAddBTN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moduleAddBTN2ActionPerformed

    private void moduleEditBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleEditBTN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moduleEditBTN2ActionPerformed

    private void moduleSubmitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleSubmitBTNActionPerformed
        
    }//GEN-LAST:event_moduleSubmitBTNActionPerformed

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
                new AdminPortal(0).setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalSeperator;
    private javax.swing.JButton addInstructorBTN;
    private javax.swing.JTextField addressInput;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel confirmNewPassLabel;
    private javax.swing.JPasswordField confirmPassInput;
    private javax.swing.JButton courseAddBTN;
    private javax.swing.JButton courseDeleteBTN;
    private javax.swing.JButton courseEditBTN;
    private javax.swing.JButton coursesBTN;
    private javax.swing.JPanel coursesContent;
    private javax.swing.JPanel coursesPanel;
    private javax.swing.JPanel coursesPanel1;
    private javax.swing.JPanel coursesPanel2;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JTextField genderInput;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel headerText;
    private javax.swing.JButton homeBTN;
    private javax.swing.JPanel homeContent;
    private javax.swing.JButton instructorsBTN;
    private javax.swing.JTable instructorsTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField joinedInput;
    private javax.swing.JLabel joinedLabel;
    private javax.swing.JLabel listOfCoursesLabel;
    private javax.swing.JLabel listOfCoursesLabel1;
    private javax.swing.JLabel listOfCoursesLabel2;
    private javax.swing.JTable listOfCoursesTable;
    private javax.swing.JLabel listOfModulesLabel;
    private javax.swing.JLabel listOfModulesLabel1;
    private javax.swing.JLabel listOfModulesLabel2;
    private javax.swing.JTable listOfModulesTable;
    private javax.swing.JTable listOfModulesTable1;
    private javax.swing.JTable listOfModulesTable2;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JPanel mainBody;
    private javax.swing.JSeparator mainProfileSeperator;
    private javax.swing.JButton moduleAddBTN;
    private javax.swing.JButton moduleAddBTN1;
    private javax.swing.JButton moduleAddBTN2;
    private javax.swing.JButton moduleEditBTN;
    private javax.swing.JButton moduleEditBTN1;
    private javax.swing.JButton moduleEditBTN2;
    private javax.swing.JButton moduleSubmitBTN;
    private javax.swing.JPanel modulesPanel;
    private javax.swing.JPanel modulesPanel1;
    private javax.swing.JPanel modulesPanel2;
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
    private javax.swing.JPanel studentContent;
    private javax.swing.JButton studentsBTN;
    private javax.swing.JTable studentsTable;
    private javax.swing.JPanel teachersContent;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JButton viewCoursesBTN;
    private javax.swing.JButton viewModulesBTN;
    private javax.swing.JLabel yourProfileLabel1;
    // End of variables declaration//GEN-END:variables
}
