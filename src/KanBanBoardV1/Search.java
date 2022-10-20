package KanBanBoardV1;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Search {

    Main objMain = new Main();
    String L1, L2, L3, L4, L5, Lf;

    public void displaycompletedTask(String Tasks) {

        JOptionPane.showMessageDialog(null, Tasks, "Completed Tasks", 1);

    }

    public String getCompletedTask() {
        int length = objMain.arrTaskName.size();
        Lf = "";
        for (int i = 0; i < length; i++) {
            L1 = "";
            L2 = "";
            L3 = "";
            if (objMain.arrStatus.get(i).equals("Done")) {
                L1 = "\r\nDeveloper: " + objMain.arrDev.get(i) + "\r\n";
                L2 = "Task Name: " + objMain.arrTaskName.get(i) + "\r\n";
                L3 = "Duration: " + objMain.arrDuration.get(i) + "\r\n";
                Lf = Lf + L1 + L2 + L3;
            }
        }
        return Lf;
    }

    public String longestTask() {
        ArrayList<String> arrIDs = new ArrayList<>();

        int Length, size;
        String Longest = "";

        size = objMain.arrTaskName.size();
        Length = objMain.arrDuration.get(0);

        //Searches through the saved tasks to check if any are loger then the 
        // first value and if this is true it will add the new longest to an 
        //array called arrIDs which saves all the Id's of longest tasks.
        for (int i = 0; i < size; i++) {
            if (Length < objMain.arrDuration.get(i)) {
                arrIDs.clear();
                arrIDs.add(objMain.arrTaskID.get(i));
                Length = objMain.arrDuration.get(i);
            } else if (Length == objMain.arrDuration.get(i)) {
                arrIDs.add(objMain.arrTaskID.get(i));
            }
        }

        //Gets all the relevant details from the saved longest ID and returns it
        for (int b = 0; b < arrIDs.size(); b++) {
            L1 = "";
            L2 = "";
            Lf = "";
            for (int i = 0; i < size; i++) {
                if (arrIDs.get(b).equals(objMain.arrTaskID.get(i))) {
                    L1 = "Developer: " + objMain.arrDev.get(i) + "\r\n";
                    L2 = "Hours: " + objMain.arrDuration.get(i) ;
                    Lf = L1 + L2;
                }
            }
        }
        return Lf;
    }

    public void displayLongest(String Longest) {
        JOptionPane.showMessageDialog(null, Longest, "Longest Task", 1);
    }

    public String searchTask(String inptTask) {

        boolean fFound = false;
        L1 = "";
        L2 = "";
        L3 = "";
        Lf = "";
        int size = objMain.arrTaskName.size();

        for (int i = 0; i < size; i++) {
            if (objMain.arrTaskName.get(i).equals(inptTask)) {
                L1 = "Task Name: " + objMain.arrTaskName.get(i) + "\r\n";
                L2 = "Developer: " + objMain.arrDev.get(i) + "\r\n";
                L3 = "Status: " + objMain.arrStatus.get(i) + "\r\n";
                Lf = L1 + L2 + L3;
                fFound = true;
            }
        }
        if (fFound == false) {
            Lf = "Developer not Found";
        }
        return Lf;
    }

    public void displaySearch() {
        String inptTask;
        inptTask = JOptionPane.showInputDialog("Enter Task Name");
        String output = searchTask(inptTask);
        JOptionPane.showMessageDialog(null, output, "Search Task", 1);
    }

    public String searchDev(String inptDev) {
        boolean fFound = false;
        Lf = "";
        int size = objMain.arrDev.size();

        for (int i = 0; i < size; i++) {
            if (objMain.arrDev.get(i).equals(inptDev)) {
                L1 = "";
                L2 = "";
                L1 = "Task Name: " + objMain.arrTaskName.get(i) + "\r\n";
                L2 = "Status: " + objMain.arrStatus.get(i);
                Lf = L1 + L2;
                fFound = true;
            }

        }
        if (fFound == false) {
            Lf = "Developer not Found";
        }
        return Lf;
    }

    public void displayDev() {
        String inptDev;

        inptDev = JOptionPane.showInputDialog("Enter Developer Name");
        String output = searchDev(inptDev);
        JOptionPane.showMessageDialog(null, output,
                "Search Developer", 1);
    }

    public String deleteTask(String inptTask) {

        boolean fDeleted = false;
        L1 = "";
        Lf = "";
        int size = objMain.arrTaskName.size(); //gets size of array

        for (int i = 0; i < size;) { //loops through length of array

            /*checks if searched task to delete = task name in array and then 
            deletes that entry from the array.*/
            if (objMain.arrTaskName.get(i).equals(inptTask)) {
                L1 = objMain.arrTaskName.get(i);
                Lf = "Entry " + L1 + " has been deleted.";
                Main.arrTaskName.remove(i);
                Main.arrDev.remove(i);
                Main.arrDuration.remove(i);
                Main.arrStatus.remove(i);
                Main.arrTaskName.remove(i);
                Main.arrTaskID.remove(i);
                return Lf;
            } else {
                i++;
            }
        }

       return Lf = "Task Not Found";
    }

    public void showDeleted() {
        String inptTask;
        inptTask = JOptionPane.showInputDialog("Enter Task Name");

        String search = deleteTask(inptTask);
        JOptionPane.showMessageDialog(null, search,
                "Delete Task", 1);
    }

    public String createReport() {
        int size = Main.arrTaskName.size();
        Lf = "";

        for (int i = 0; i < size; i++) {
            L1 = "";
            L2 = "";
            L3 = "";
            L4 = "";
            L5 = "";

            L1 = "\r\nTask ID: " + Main.arrTaskID.get(i) + "\r\n";
            L2 = "Task Name: " + Main.arrTaskName.get(i) + "\r\n";
            L3 = "Duration: " + Main.arrDuration.get(i) + "\r\n";
            L4 = "Developer: " + Main.arrDev.get(i) + "\r\n";
            L5 = "Status: " + Main.arrStatus.get(i) + "\r\n";

            Lf = Lf + L1 + L2 + L3 + L4 + L5;
        }
        return Lf;
    }

    public void displayReport() {
        JOptionPane.showMessageDialog(null, createReport(),
                "Display Report", 1);
    }

}
