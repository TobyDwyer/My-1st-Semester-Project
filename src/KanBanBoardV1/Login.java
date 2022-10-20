//St10019602
package KanBanBoardV1;

import javax.swing.JOptionPane;

public class Login {

    //<editor-fold desc="Ignore">
    //Creates 4 empty arrays for Username, Password, First Name and Surname
    /*  public static ArrayList<String> arrUn = new ArrayList();
    public static ArrayList<String> arrPw = new ArrayList();
    public static ArrayList<String> arrFname = new ArrayList();
    public static ArrayList<String> arrSurnames = new ArrayList();
     */
    //</editor-fold>
    public String inptFn, inptSurname, inptUn, inptPw; //User Inputs
    private String saveUn, SavePw; //Username and password when register correct
    public String unOut, pwOut; //Unout and pwout are used for unit tests later

    public Boolean LoginUser(String un, String pw) {

        boolean flagUn, flagPw;
        flagPw = false;
        flagUn = false;

        /* If statement checks if the inputted username is = to the saved one 
        and then if that is true it checks if the password inputted is = to 
        the saved password and will change the flags related to these 2 checks*/
        if (un.equals(getSaveUn())) {
            flagUn = true;
            if (pw.equals(getSavePw())) {
                flagPw = true;
            } else {
                flagPw = false;
                flagUn = false;
            }
        }

        if (flagPw == true && flagUn == true) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

    public static Boolean checkUserName(String un) {
        //Parameters for username
        final int LENGTH = 5;

        //Vars which will be intialied from input
        boolean Underscore = Boolean.FALSE;
        int unLength;

        unLength = un.length();

        //Checks for Underscore
        if (un.contains("_")) {
            Underscore = Boolean.TRUE;
        }

        //if all the credentials are correct return true.
        if (unLength <= LENGTH && Underscore == Boolean.TRUE) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static Boolean checkPasswordComplexity(String pw) {
        //Password Parameters
        final int UPPCASE = 1;
        final int LENGTH = 8;
        final int DIGITS = 1;
        final int SPECIAL = 1;

        //Declaring varibles which will be checked against parameters
        int numUpper = 0;
        int pswLength = 0;
        int numDigits = 0;
        int numSpecial = 0;

        pswLength = pw.length();

        //Loop through each character of password
        for (int i = 0; i < pswLength; i++) {

            char ch = pw.charAt(i);

            /*if the selected character is one of the parameters the 
            int count increases for that parameter*/
            if (Character.isUpperCase(ch)) {
                numUpper++;
            } else if (Character.isDigit(ch)) {
                numDigits++;
            } else if (Main.containsSpecialCharacter(Character.toString(ch))) {
                numSpecial++;
                //Calls check special character method and then adds to count 
                //if true
            }
        }

        /*Checking if the amount of each parameter in the inputted password
          satisfies the requirements by checking if the count of the vars are 
         higher then the number of the parameters*/
        if (numUpper >= UPPCASE && pswLength >= LENGTH && numDigits >= DIGITS
                && numSpecial >= SPECIAL) {
            return (Boolean.TRUE);

        } else {
            return (Boolean.FALSE);
        }
    }

    public void registerUser() {

        //Checks if the username meets the requiements
        if (checkUserName(getInptUn()) == Boolean.TRUE) {
            unOut = "Username successfully captured";

        } else {
            //if username incorrect it returns:
            unOut = "Username not correctly "
                    + "formatted, please ensure"
                    + " that your username contains an underscore and is no"
                    + "more than 5 Characters in length";

        }
        //Checks if the inputted password is correct by using check password. 
        if (checkPasswordComplexity(getInptPw()) == Boolean.TRUE) {
            pwOut = "Password successfully captured";

        } else {
            pwOut = "Password not correctly formatted please ensure"
                    + "that your password contains at least 8 characters, a "
                    + "capital letter, a number, and a special character.";

        }

    }

    public void displayRegister() {
        registerUser();
        JOptionPane.showMessageDialog(null, unOut);
        JOptionPane.showMessageDialog(null, pwOut);

        if (checkPasswordComplexity(inptPw) == Boolean.TRUE && checkUserName(inptUn)
                == Boolean.TRUE) {
            //if the registration is successful the username and password are 
            //  saved and the correct GUI Window is shown.
            GuiCreator.pnlWindow.setVisible(true);
            GuiCreator.pnlSignUp.setVisible(false);

            setSavePw(getInptPw());
            setSaveUn(getInptUn());
        }
    }

    public void checkLoginStatus() {
        /*The loginuser method is used to check the users inputs and check if
        they have entered the correct username and password and then will change 
        the gui accordingly and display a message*/

        if (LoginUser(getInptUn(), getInptPw()) == Boolean.TRUE) {
            GuiCreator.pnlLogin.setVisible(false);
            GuiCreator.pnlWelcome.setVisible(true);
            JOptionPane.showMessageDialog(null, "Welcome " + getInptFn() + ","
                    + getInptSurname() + " it is great to see u again.");

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password");
        }

    }

    //<editor-fold desc="Getters and setters">
    public String getInptPw() {
        return inptPw;
    }

    public void setInptPw(String inptPw) {
        this.inptPw = inptPw;
    }

    public String getInptUn() {
        return inptUn;
    }

    public void setInptUn(String inptUn) {
        this.inptUn = inptUn;
    }

    public String getInptFn() {
        return inptFn;
    }

    public void setInptFn(String inptFn) {
        this.inptFn = inptFn;
    }

    public String getInptSurname() {
        return inptSurname;
    }

    public void setInptSurname(String inptSurname) {
        this.inptSurname = inptSurname;
    }

    public String getUnOut() {
        return unOut;
    }

    public void setUnOut(String unOut) {
        this.unOut = unOut;
    }

    public String getPwOut() {
        return pwOut;
    }

    public void setPwOut(String pwOut) {
        this.pwOut = pwOut;
    }

    public String getSavePw() {
        return SavePw;
    }

    public void setSavePw(String SavePw) {
        this.SavePw = SavePw;
    }

    public String getSaveUn() {
        return saveUn;
    }

    public void setSaveUn(String saveUn) {
        this.saveUn = saveUn;
    }
    // </editor-fold>

}
