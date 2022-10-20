/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package KanBanBoardV1;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Toby
 */
public class SearchTest {

    Main objMain = new Main();
    Search objSearch = new Search();

    public SearchTest() {
    }

    public void populateArrays() {
        String[] devnames = {"Mike Smith", "Edward Harrison", "Samantha Paulson",
            "Glenda Oberholzer"};
        Integer[] duration = {5, 8, 2, 11};
        String[] Status = {"To Do", "Doing", "Done", "To Do"};
        String[] TaskName = {"Create Login", "Create Add Features",
            "Create Reports", "Add Arrays"};
        String[] TaskID = {"Cr:0:ith", "Cr:1:son", "Cr:2:son", "Ad:3:zer"};

        objMain.arrDev.addAll(Arrays.asList(devnames));
        objMain.arrDuration.addAll(Arrays.asList(duration));
        objMain.arrStatus.addAll(Arrays.asList(Status));
        objMain.arrTaskName.addAll(Arrays.asList(TaskName));
        objMain.arrTaskID.addAll(Arrays.asList(TaskID));
    }

    public void clearArrays() {
        Main.arrDev.clear();
        Main.arrDuration.clear();
        Main.arrStatus.clear();
        Main.arrTaskID.clear();
        Main.arrTaskName.clear();

    }

    @Test
    public void testDevArray() {
        clearArrays();
        populateArrays();
        boolean success;

        if (objMain.arrDev.get(0).equals("Mike Smith")
                && objMain.arrDev.get(1).equals("Edward Harrison")
                && objMain.arrDev.get(2).equals("Samantha Paulson")
                && objMain.arrDev.get(3).equals("Glenda Oberholzer")) {
            success = true;
        } else {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void testLongest() {
        clearArrays();
        populateArrays();
        String returned = objSearch.longestTask();

        String expected = "Developer: " + "Glenda Oberholzer" + "\r\n"
                + "Hours: " + "11";

        assertEquals(expected, returned);
    }

    @Test
    public void testSearch() {
        clearArrays();
        populateArrays();
        String returned = objSearch.searchTask("Create Login");

        String expected = "Task Name: " + "Create Login" + "\r\n"
                + "Developer: " + "Mike Smith" + "\r\n"
                + "Status: " + "To Do" + "\r\n";

        assertEquals(expected, returned);
    }

    @Test
    public void testDevSearch() {
        clearArrays();
        populateArrays();
        String returned = objSearch.searchDev("Samantha Paulson");

        String expected = "Task Name: " + "Create Reports" + "\r\n" + "Status: "
                + "Done";

        assertEquals(expected, returned);
    }

    @Test
    public void testDeleteTask() {
        clearArrays();
        populateArrays();
        String returned = objSearch.deleteTask("Create Reports");
        System.out.println(returned);

        String expected = "Entry " + "Create Reports" + " has been deleted.";

        assertEquals(expected, returned);
    }

    @Test
    public void testDisplayReport() {
        clearArrays();
        populateArrays();

        String returned = objSearch.createReport();

        String expected = "\r\nTask ID: " + "Cr:0:ith" + "\r\n"
                + "Task Name: " + "Create Login" + "\r\n"
                + "Duration: " + "5" + "\r\n"
                + "Developer: " + "Mike Smith" + "\r\n"
                + "Status: " + "To Do" + "\r\n" 
                + "\r\nTask ID: " + "Cr:0:ith" 
                + "\r\n"
                + "Task Name: " + "Create Add Features" + "\r\n"
                + "Duration: " + "8" + "\r\n"
                + "Developer: " + "Edward Harrison" + "\r\n"
                + "Status: " + "Doing" + "\r\n" 
                + "\r\nTask ID: " + "Cr:1:son" 
                + "\r\n"
                + "Task Name: " + "Create Reports" + "\r\n"
                + "Duration: " + "2" + "\r\n"
                + "Developer: " + "Samantha Paulson" + "\r\n"
                + "Status: " + "Done" + "\r\n" 
                + "\r\nTask ID: " + "Cr:2:son" 
                + "\r\n"
                + "Task Name: " + "Add Arrays" + "\r\n"
                + "Duration: " + "11" + "\r\n"
                + "Developer: " + "Glenda Oberholzer" + "\r\n"
                + "Status: " + "To Do" + "\r\n" ;

    }
}

