//St10019602
package KanBanBoardV1;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Tasks {

    Main objMain = new Main();

    //<editor-fold desc="Varibles">
    private String taskDescription, TaskStatus, sDevFName, sDevSName,
            sTaskName, TaskID;
    private int hours, length, numTasks, TaskNum;
    private int totHours = 0;
    private final int CHAR_LIMIT = 50;
    int taskCount;
    //</editor-fold>

    public boolean checktaskdescription(String descr) {
        length = descr.length();

        //gets the length of the inputted decription and checks that it is less
        //then the Limit.
        if (length > CHAR_LIMIT) {
            return false;
        } else {
            return true;
        }

    }

    //Takes the hours of a task and adds it to the total hours.
    public void calcTotalHours(int newhour) {
        setTotHours(getTotHours() + newhour);
    }

    public int returnTotHours() {
        return getTotHours();
    }

    public String createTaskID(String taskname, String Fn, String Sn, int num) {

        String task2, dev3, dev;
        //Combines developers first and second name together.
        dev = Fn + Sn;

        //First 2 letters of task
        task2 = taskname.substring(0, 2);

        //Last 3 of dev 
        dev3 = dev.substring(dev.length() - 3);

        String sline = task2 + ':' + num + ':' + dev3;
        setTaskID(sline);
        return sline;
    }

    public String printTaskDetails() {
        String Sline1 = "Status: " + getTaskStatus() + "\r\n";
        String Sline2 = "Developer Details: " + getsDevFName() + " "
                + getsDevSName() + "\r\n";
        String Sline3 = "Task Number: " + getTaskNum() + "\r\n";
        String Sline4 = "Task Name: " + getsTaskName() + "\r\n";
        String Sline5 = "Description: " + getTaskDescription() + "\r\n";
        String Sline6 = "Task ID: "
                + createTaskID(getsTaskName(), getsDevFName(), getsDevSName(),
                        getTaskNum()) + "\r\n";
        String Sline7 = "Duration " + getHours() + "\r\n";
        String SlineFnl = Sline1 + Sline2 + Sline3
                + Sline4 + Sline5 + Sline6 + Sline7;
        return SlineFnl;
    }

    public void createTask() {
        GuiCreator objGui = new GuiCreator();
        /*Checks that the task is less then the total tasks the user wanted to
           enter. Then the program checks that the decription is within the max
           character limit before calling all teh methods to show the task.*/
        if (taskCount < numTasks) {
            if (checktaskdescription(getTaskDescription()) == true) {
                setTaskNum(taskCount);
                calcTotalHours(getHours());
                JOptionPane.showMessageDialog(GuiCreator.Homeframe, printTaskDetails());
                saveTask();
                taskCount = taskCount + 1;
            } else {
                JOptionPane.showMessageDialog(null, "Description over 50 characters in length. Please Renter Task");
            }
        }
        if (taskCount >= numTasks) {
            JOptionPane.showMessageDialog(null, "Total Time of Tasks: "
                    + returnTotHours());
            objGui.pnlWelcome.setVisible(true);
            objGui.pnlTasks.setVisible(false);
        }

    }

    public void saveTask() {
        objMain.arrDev.add(getsDevFName() + " " + getsDevSName());
        objMain.arrStatus.add(getTaskStatus());
        objMain.arrTaskName.add(getsTaskName());
        objMain.arrTaskID.add(getTaskID());
        objMain.arrDuration.add(getHours());
    }

//<editor-fold desc="Getters and setters">
    public void setTaskID(String TaskID) {
        this.TaskID = TaskID;
    }

    public String getTaskID() {
        return TaskID;
    }

    public void setTotHours(int totHours) {
        this.totHours = totHours;
    }

    public int getTotHours() {
        return totHours;
    }

    public int getTaskNum() {
        return TaskNum;
    }

    public void setTaskNum(int TaskNum) {
        this.TaskNum = TaskNum;
    }

    public void setsDevFName(String sDevFName) {
        this.sDevFName = sDevFName;
    }

    public void setsDevSName(String sDevSName) {
        this.sDevSName = sDevSName;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setsTaskName(String sTaskName) {
        this.sTaskName = sTaskName;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskStatus(String TaskStatus) {
        this.TaskStatus = TaskStatus;
    }

    public String getsDevFName() {
        return sDevFName;
    }

    public String getsDevSName() {
        return sDevSName;
    }

    public int getHours() {
        return hours;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskStatus() {
        return TaskStatus;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public String getsTaskName() {
        return sTaskName;
    }

    //</editor-fold>
}
