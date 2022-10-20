//St10019602
package KanBanBoardV1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Toby
 */
public class TasksTest {

    Tasks task = new Tasks();

    public TasksTest() {
    }

    @Test
    public void correctDescription() {
        task.setTaskDescription("This is Correct");
        boolean output = task.checktaskdescription(task.getTaskDescription());

        assertTrue(output);
    }

    @Test
    public void incorrectDescription() {
        task.setTaskDescription("This is too long and will return a false value"
                + " as i have written too much inside of thsi textbox");
        boolean output = task.checktaskdescription(task.getTaskDescription());

        assertFalse(output);
    }

    @Test
    public void TotalHoursTask1() {
        int[] arrHrsTask1 = {8, 10};
        task.setNumTasks(2);

        for (int i = 0; i < task.getNumTasks(); i++) {
            task.calcTotalHours(arrHrsTask1[i]);
        }
        int expected = 18;
        int actual = task.returnTotHours();
        assertEquals(expected, actual);
    }

    @Test
    public void TotalHoursTask2() {
        int[] arrHrsTask2 = {10, 12, 55, 11, 1};

        task.setNumTasks(5);

        for (int i = 0; i < task.getNumTasks(); i++) {
            task.calcTotalHours(arrHrsTask2[i]);
        }
        
        int expected = 89;
        int actual = task.returnTotHours();
        assertEquals(expected, actual);
    }

}
