//St10019602
package KanBanBoardV1;

import java.awt.*;
import javax.swing.*;

public class GuiCreator {
 
    //<editor-fold desc="Vars">
    public static JFrame Homeframe = new JFrame("KanBan Board");
    public static JPanel pnlWindow = new JPanel();
    public static JPanel pnlBckgrd = new JPanel();
    public static JPanel pnlLogin = new JPanel();
    public static JPanel pnlWelcome = new JPanel();
    public static JPanel pnlSignUp = new JPanel();
    public static JPanel pnlTasks = new JPanel();
    public static JPanel pnlReport = new JPanel();

    //Used for setup to ensure panel is centred.
    public static int winWidth, winHeight, panelx, panely,
            panelWidth, panelHeight;
    
    //</editor-fold>

    //Creates an object so that methods can be called
    Login objlogin = new Login();
    Tasks objTasks = new Tasks();
    Search objSearch = new Search();

    public void GetPanelLocation() {

        /*Math which finds the top left corner for 2nd panel to be centre 
        Subtracts the width of the panel and then finds the middle of the 
        remaining space for an equal gap either side.
         */
        panelx = (winWidth - panelWidth) / 2;
        panely = (winHeight - panelHeight) / 2;
    }

    public static void GUICreater() {

        //<editor-fold desc="Home Frame initialization">
        winWidth = 1000;
        winHeight = 700;
        Homeframe.setSize(winWidth, winHeight);
        Homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Homeframe.setLocationRelativeTo(null);

        Homeframe.add(pnlWindow);
        Homeframe.add(pnlLogin);
        Homeframe.add(pnlSignUp);
        Homeframe.add(pnlWelcome);
        Homeframe.add(pnlTasks);
        Homeframe.add(pnlReport);
        Homeframe.add(pnlBckgrd);

        pnlBckgrd.setLayout(null);
        Homeframe.setResizable(false);

        //Adding background image to image icon to be displayed onto a panel.
        ImageIcon myImg = new ImageIcon("GriddedBackground.jpg");
        myImg.setImage(myImg.getImage()
                .getScaledInstance(winWidth, winHeight, Image.SCALE_DEFAULT));

        JLabel bckImg = new JLabel(myImg);
        bckImg.setBounds(1, 1, winWidth, winHeight);
        /* Color c = new Color(0f, .5f, 1f, .85f);

        pnlLogin.setBackground(c);
        pnlWindow.setBackground(c);
        pnlSignUp.setBackground(c);*/

        pnlBckgrd.add(bckImg);
        pnlReport.setVisible(false);
        pnlLogin.setVisible(false);
        pnlSignUp.setVisible(false);
        pnlWindow.setVisible(false);
        pnlTasks.setVisible(false);
        pnlWelcome.setVisible(false);

        //</editor-fold>
    }

    public void GUIHomeScreen() {

        /*objlogin.setSavePw("Dwyert22@");
        objlogin.setSaveUn("kyl_");
        objlogin.setInptFn("Blue");
        objlogin.setInptSurname("Black");*/
        //calls Gui creator method
        GUICreater();
        //<editor-fold desc="GUI Creation">
        panelWidth = 250;
        panelHeight = 300;
        GetPanelLocation();
        pnlWindow.setLayout(null);
        pnlWindow.setBounds(panelx, panely, panelWidth, panelHeight);

        JLabel lblTitle = new JLabel("Please Select an Option:");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
        lblTitle.setBounds(30, 50, 220, 25);

        JButton btnLogin = new JButton("Log In");
        btnLogin.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBounds(40, 150, 180, 25);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Sans Serif", Font.BOLD, 16));
        btnSignUp.setBackground(Color.WHITE);
        btnSignUp.setBounds(40, 180, 180, 25);

        //</editor-fold>
        /*These 2 buttons call the gui builders for either Login or signup 
        depending on what button is clicked and hides the home panel
         */
        btnLogin.addActionListener((e) -> {
            GUILogIn();
            pnlWindow.setVisible(false);
        });

        btnSignUp.addActionListener((e) -> {
            pnlWindow.setVisible(false);
            GUIBuildSignup();

        });

        //Adds components to panel to be displayed
        pnlWindow.add(lblTitle);
        pnlWindow.add(btnLogin);
        pnlWindow.add(btnSignUp);

        pnlWindow.setVisible(true);
        Homeframe.setVisible(true);

    }

    public void GUILogIn() {

        //<editor-fold desc="GuiCreation">
        panelWidth = 375;
        panelHeight = 250;
        GetPanelLocation();
        pnlLogin.setBounds(panelx, panely, panelWidth, panelHeight);

        pnlLogin.setLayout(null);

        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("Sans", Font.BOLD, 16));
        lblUser.setBounds(((panelWidth - 80) / 2), 20, 80, 25);
        pnlLogin.add(lblUser);

        JTextField txtUser = new JTextField(20);
        txtUser.setBounds(100, 45, 165, 25);
        pnlLogin.add(txtUser);
        txtUser.setText("");

        JLabel lblPWord = new JLabel("Password");
        lblPWord.setFont(new Font("Sans", Font.BOLD, 16));
        lblPWord.setBounds(((panelWidth - 80) / 2), 70, 80, 25);
        pnlLogin.add(lblPWord);

        JPasswordField txtPWord = new JPasswordField();
        txtPWord.setBounds(100, 95, 165, 25);
        txtPWord.setEchoChar('*');
        pnlLogin.add(txtPWord);
        txtPWord.setText("");

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(((panelWidth - 80) / 2), 130, 80, 25);
        btnLogin.setBackground(Color.WHITE);
        pnlLogin.add(btnLogin);

        JButton btnBack = new JButton("Home");
        btnBack.setBounds(panelWidth - 100, panelHeight - 50, 75, 25);
        btnBack.setBackground(Color.WHITE);
        pnlLogin.add(btnBack);

        JCheckBox btnShowPw = new JCheckBox("SHOW");
        btnShowPw.setBounds(270, 95, 75, 25);
        btnShowPw.setBackground(Color.WHITE);
        pnlLogin.add(btnShowPw);

        pnlLogin.setVisible(true);

        //</editor-fold>
        /*Users a check box to set the echoed char of the password field to 
        either show or hide the password. */
        btnShowPw.addChangeListener((e) -> {
            if (btnShowPw.isSelected() == true) {
                //shows password when box is checked.
                txtPWord.setEchoChar((char) 0);
            } else if (btnShowPw.isSelected() == false) {
                //sets all the chars of the password to * when box unchecked.
                txtPWord.setEchoChar('*');
            }

        });

        btnLogin.addActionListener((e) -> {
            //Sets the varibles from the gui.
            GUIWelcome();

            objlogin.setInptUn(txtUser.getText());
            objlogin.setInptPw(txtPWord.getText());

            //Calls method to check login.
            objlogin.checkLoginStatus();
            txtPWord.setText("");
            txtUser.setText("");
        });

        //Returns to the home screen.
        btnBack.addActionListener((e) -> {
            pnlLogin.setVisible(false);
            pnlWindow.setVisible(true);
            txtPWord.setText("");
            txtUser.setText("");

        });

    }

    public void GUIBuildSignup() {

        //<editor-fold desc="GuiCreation">
        panelWidth = 375;
        panelHeight = 250;
        GetPanelLocation();
        pnlSignUp.setBounds(panelx, panely, 375, 250);

        pnlSignUp.setLayout(null);

        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(10, 20, 165, 25);
        pnlSignUp.add(lblUser);

        JTextField txtUser = new JTextField(5);
        txtUser.setBounds(100, 20, 165, 25);
        pnlSignUp.add(txtUser);
        txtUser.setText("");

        JLabel lblPWord = new JLabel("Password");
        lblPWord.setBounds(10, 50, 80, 25);
        pnlSignUp.add(lblPWord);

        JPasswordField txtPword = new JPasswordField();
        txtPword.setText("");
        txtPword.setBounds(100, 50, 165, 25);
        txtPword.setEchoChar('*');
        pnlSignUp.add(txtPword);

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(10, 80, 80, 25);
        pnlSignUp.add(lblFirstName);

        JTextField txtFname = new JTextField(20);
        txtFname.setBounds(100, 80, 165, 25);
        pnlSignUp.add(txtFname);

        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setBounds(10, 110, 80, 25);
        pnlSignUp.add(lblSurname);

        JTextField txtSurname = new JTextField(20);
        txtSurname.setBounds(100, 110, 165, 25);
        pnlSignUp.add(txtSurname);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(30, 140, 80, 25);
        btnSignUp.setBackground(Color.WHITE);
        pnlSignUp.add(btnSignUp);

        JCheckBox btnShowPw = new JCheckBox("SHOW");
        btnShowPw.setBounds(270, 50, 75, 25);
        btnShowPw.setBackground(Color.WHITE);
        pnlSignUp.add(btnShowPw);

        JButton btnHome = new JButton("Home");
        btnHome.setBounds(270, 180, 75, 25);
        pnlSignUp.add(btnHome);

        //</editor-fold>
        btnShowPw.addChangeListener((e) -> {

            if (btnShowPw.isSelected() == true) {
                txtPword.setEchoChar((char) 0);
            } else if (btnShowPw.isSelected() == false) {
                txtPword.setEchoChar('*');
            }

        });

        btnSignUp.addActionListener((var e) -> {
            //Saves the details of the user
            objlogin.setInptPw(txtPword.getText());
            objlogin.setInptUn(txtUser.getText());
            objlogin.setInptFn(txtFname.getText());
            objlogin.setInptSurname(txtSurname.getText());

            //calls method to verify the registration
            objlogin.displayRegister();
            //clears the fields
            txtFname.setText("");
            txtPword.setText("");
            txtSurname.setText("");
            txtUser.setText("");
        });

        btnHome.addActionListener((e) -> {
            pnlSignUp.setVisible(false);
            pnlWindow.setVisible(true);
            txtFname.setText("");
            txtPword.setText("");
            txtSurname.setText("");
            txtUser.setText("");
        });

        pnlSignUp.setVisible(true);
    }

    public void GUIWelcome() {

        //<editor-fold desc="GuiCreation">
        GuiCreateTask();
        GuiReport();
        panelWidth = 400;
        panelHeight = 300;
        GetPanelLocation();
        pnlWelcome.setBounds(panelx, panely, panelWidth, panelHeight);

        pnlWelcome.setLayout(null);

        JLabel lblwelcome = new JLabel("Welcome to Easy KanBan:");
        lblwelcome.setFont(new Font("Sans", Font.BOLD, 22));
        lblwelcome.setBounds(((panelWidth - 300) / 2), 20, 300, 25);
        pnlWelcome.add(lblwelcome);

        JButton btnAddTask = new JButton("Add Task");
        btnAddTask.setBounds((panelWidth - 110) / 2, 70, 110, 25);
        btnAddTask.setBackground(Color.WHITE);
        pnlWelcome.add(btnAddTask);

        JButton btnShowReport = new JButton("Show Report");
        btnShowReport.setBounds((panelWidth - 110) / 2, 100, 110, 25);
        btnShowReport.setBackground(Color.WHITE);
        pnlWelcome.add(btnShowReport);

        JButton btnQuit = new JButton("Quit");
        btnQuit.setBounds((panelWidth - 110) / 2, 130, 110, 25);
        btnQuit.setBackground(Color.WHITE);
        pnlWelcome.add(btnQuit);

        pnlWelcome.setVisible(false);

        //</editor-fold>
        btnAddTask.addActionListener(((e) -> {
            pnlWelcome.setVisible(false);
            pnlTasks.setVisible(true);
            objTasks.setNumTasks(Integer.parseInt(JOptionPane.showInputDialog(
                    null, "How Many Tasks would you like to enter")));

        }));

        btnShowReport.addActionListener((e) -> {
            pnlWelcome.setVisible(false);
            pnlReport.setVisible(true);
        });

        btnQuit.addActionListener((e) -> {
            pnlWelcome.setVisible(false);
            pnlWindow.setVisible(true);
        });

    }

    public void GuiCreateTask() {

        //<editor-fold desc="Gui Creation">
        panelWidth = 400;
        panelHeight = 350;
        GetPanelLocation();
        pnlTasks.setBounds(panelx, panely, panelWidth, panelHeight);

        pnlTasks.setLayout(null);

        JLabel lblTitle = new JLabel("Create Task:");
        lblTitle.setFont(new Font("Sans", Font.BOLD, 22));
        lblTitle.setBounds(((panelWidth - 150) / 2), 20, 150, 25);
        pnlTasks.add(lblTitle);

        JLabel lblTaskName = new JLabel("Task Name:");
        lblTaskName.setFont(new Font("Sans", Font.BOLD, 16));
        lblTaskName.setBounds(((panelWidth - 150) / 5), 60, 150, 25);
        pnlTasks.add(lblTaskName);

        JTextField txtTaskname = new JTextField();
        txtTaskname.setBounds(((panelWidth - 200)), 60, 150, 25);
        pnlTasks.add(txtTaskname);
        txtTaskname.setText("");

        JLabel lblTaskDescription = new JLabel("Task Description:");
        lblTaskDescription.setFont(new Font("Sans", Font.BOLD, 16));
        lblTaskDescription.setBounds(((panelWidth - 150) / 5), 90, 150, 25);
        pnlTasks.add(lblTaskDescription);

        JTextArea txtDescription = new JTextArea(10, 1);
        txtDescription.setBounds(((panelWidth - 200)), 90, 150, 75);
        txtDescription.setFont(new Font("Sans", Font.PLAIN, 14));
        txtDescription.setLineWrap(true);
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlTasks.add(txtDescription);
        txtDescription.setText("");

        JLabel lblTaskFDev = new JLabel("Devs First Name:");
        lblTaskFDev.setFont(new Font("Sans", Font.BOLD, 16));
        lblTaskFDev.setBounds(((panelWidth - 150) / 5), 170, 150, 25);
        pnlTasks.add(lblTaskFDev);

        JTextField txtTaskFDev = new JTextField();
        txtTaskFDev.setBounds(((panelWidth - 200)), 170, 150, 25);
        pnlTasks.add(txtTaskFDev);
        txtTaskFDev.setText("");

        JLabel lblTaskSDev = new JLabel("Devs Surname:");
        lblTaskSDev.setFont(new Font("Sans", Font.BOLD, 16));
        lblTaskSDev.setBounds(((panelWidth - 150) / 5), 200, 150, 25);
        pnlTasks.add(lblTaskSDev);

        JTextField txtTaskSDev = new JTextField();
        txtTaskSDev.setBounds(((panelWidth - 200)), 200, 150, 25);
        pnlTasks.add(txtTaskSDev);
        txtTaskSDev.setText("");

        JLabel lblTaskDuration = new JLabel("Task Duration:");
        lblTaskDuration.setFont(new Font("Sans", Font.BOLD, 16));
        lblTaskDuration.setBounds(((panelWidth - 150) / 5), 230, 150, 25);
        pnlTasks.add(lblTaskDuration);

        JTextField txtTaskDuration = new JTextField();
        txtTaskDuration.setBounds(((panelWidth - 200)), 230, 150, 25);
        pnlTasks.add(txtTaskDuration);
        txtTaskDuration.setText("");

        JLabel lblTaskStatus = new JLabel("Task Satus:");
        lblTaskStatus.setFont(new Font("Sans", Font.BOLD, 16));
        lblTaskStatus.setBounds(((panelWidth - 150) / 5), 260, 150, 25);
        pnlTasks.add(lblTaskStatus);

        JCheckBox chkToDo = new JCheckBox("To Do");
        chkToDo.setBounds(((panelWidth - 200)), 260, 70, 25);
        pnlTasks.add(chkToDo);

        JCheckBox chkDoing = new JCheckBox("Doing");
        chkDoing.setBounds(((panelWidth - 130)), 260, 70, 25);
        pnlTasks.add(chkDoing);

        JCheckBox chkDone = new JCheckBox("Done");
        chkDone.setBounds(((panelWidth - 60)), 260, 70, 25);
        pnlTasks.add(chkDone);

        JButton btnCreate = new JButton("Create Task");
        btnCreate.setBounds(((panelWidth - 130) / 2), 300, 130, 30);
        btnCreate.setBackground(Color.WHITE);
        pnlTasks.add(btnCreate);

        pnlTasks.setVisible(false);
        objTasks.taskCount = 0;
        //</editor-fold>

        //check boxes set the status of the task and uncheck the other to ensure
        // that only one is checked.
        chkToDo.addActionListener((e) -> {
            if (chkToDo.isSelected() == true) {
                chkDoing.setSelected(false);
                chkDone.setSelected(false);
                objTasks.setTaskStatus("To Do");
            }
        });

        chkDoing.addActionListener((e) -> {
            if (chkDoing.isSelected() == true) {
                chkDone.setSelected(false);
                chkToDo.setSelected(false);
                objTasks.setTaskStatus("Doing");
            }
        });

        chkDone.addActionListener((e) -> {
            if (chkDone.isSelected() == true) {
                chkDoing.setSelected(false);
                chkToDo.setSelected(false);
                objTasks.setTaskStatus("Done");
            }
        });

        //initializes the varibles and then calls the create task method before
        // clearing the fields for thwe next input.
        btnCreate.addActionListener((e) -> {

            objTasks.setsTaskName(txtTaskname.getText());
            objTasks.setTaskDescription(txtDescription.getText());
            objTasks.setsDevFName(txtTaskFDev.getText());
            objTasks.setsDevSName(txtTaskSDev.getText());
            objTasks.setHours(Integer.valueOf(txtTaskDuration.getText()));
            objTasks.createTask();
            txtDescription.setText("");
            txtTaskDuration.setText("");
            txtTaskFDev.setText("");
            txtTaskSDev.setText("");
            txtTaskname.setText("");

            //System.out.println(objTasks.createTaskID());
        });

    }

    public void GuiReport() {

        //<editor-fold desc="GuiCreation">
        panelWidth = 400;
        panelHeight = 250;
        GetPanelLocation();
        pnlReport.setBounds(panelx, panely, panelWidth, panelHeight);
        int centerX = (panelWidth-130)/2;

        JButton btnHome = new JButton("Back");
        btnHome.setBounds(270, 210, 75, 25);
        btnHome.setBackground(Color.WHITE);
        pnlReport.add(btnHome);

        JButton btnDone = new JButton("Display Done");
        btnDone.setBounds(centerX, 40, 130, 25);
        btnDone.setBackground(Color.WHITE);
        pnlReport.add(btnDone);

        JButton btnLongest = new JButton("Display Longest");
        btnLongest.setBounds(centerX, 70, 130, 25);
        btnLongest.setBackground(Color.WHITE);
        pnlReport.add(btnLongest);

        JButton btnSearchTask = new JButton("Search Task");
        btnSearchTask.setBounds(centerX, 100, 130, 25);
        btnSearchTask.setBackground(Color.WHITE);
        pnlReport.add(btnSearchTask);

        JButton btnSearchDev = new JButton("Search Dev");
        btnSearchDev.setBounds(centerX, 130, 130, 25);
        btnSearchDev.setBackground(Color.WHITE);
        pnlReport.add(btnSearchDev);

        JButton btndelete = new JButton("Delete Task");
        btndelete.setBounds(centerX, 160, 130, 25);
        btndelete.setBackground(Color.WHITE);
        pnlReport.add(btndelete);

        JButton btnReport = new JButton("Display Report");
        btnReport.setBounds(centerX, 190, 130, 25);
        btnReport.setBackground(Color.WHITE);
        pnlReport.add(btnReport);

        pnlReport.setLayout(null);
        pnlReport.setVisible(false);
        //</editor-fold>

        btnDone.addActionListener((e) -> {
            objSearch.displaycompletedTask(objSearch.getCompletedTask());
        });

        btnLongest.addActionListener((e) -> {
            objSearch.displayLongest(objSearch.longestTask());
        });
        
        btndelete.addActionListener((e) -> {
            objSearch.showDeleted();
        });
        
        btnReport.addActionListener((e) -> {
            objSearch.displayReport();
        });

        btnSearchTask.addActionListener((e) -> {
            objSearch.displaySearch();
        });

        btnSearchDev.addActionListener((e) -> {
            objSearch.displayDev();
        });
        
        btnHome.addActionListener((e) -> {
            pnlReport.setVisible(false);
            pnlWelcome.setVisible(true);
        });
    }
}
