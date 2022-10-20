//St10019602
package KanBanBoardV1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    //<editor-fold desc="Arrays">
    public static ArrayList<String> arrDev = new ArrayList<>();
    public  static ArrayList<String> arrTaskName = new ArrayList<>();
    public  static ArrayList<String> arrTaskID = new ArrayList<>();
    public  static  ArrayList<String> arrStatus = new ArrayList<>();
    public static  ArrayList<Integer> arrDuration = new ArrayList<>();
    //</editor-fold>

    public static void main(String[] args) {

        //Calls method to create home screen Gui on program run
        GuiCreator objGui = new GuiCreator();
        objGui.GUIHomeScreen();

    }

    public static boolean containsSpecialCharacter(String s) {

        /*Creates a pattern which Searches if a letter is not(^) 
        one of the digits specified. Pattern is used to make a template of 
        characters which we are not looking for. Then matcher checks if the char
        's' is not in those specified chars and if it isn't it will return true*/
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher match = pattern.matcher(s);

        return match.find();

    }

}
