//St10019602
package KanBanBoardV1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Toby
 */
public class LoginTest {

    Login login = new Login();
    Main objmain = new Main();

    public LoginTest() {

    }

    @Test
    public void incorrectRegisterUser() {
        login.inptUn = "kyl!!!!!";
        login.inptPw = "Dwyert22@";

        String expectedString = "Username not correctly "
                + "formatted, please ensure"
                + " that your username contains an underscore and is no"
                + "more than 5 Characters in length";

        login.registerUser();
        String actual = login.unOut;

        assertEquals(expectedString, actual);

    }

    @Test
    public void correctRegisterUser() {
        login.inptUn = "kyl_1";
        login.inptPw = "Dwyert22@";

        String expectedString = "Username successfully captured";
        
        
        login.registerUser();
        String actual = login.unOut;

        assertEquals(expectedString, actual);

    }

    @Test
    public void correctPassword() {
        login.inptUn = "kyl_1";
        login.inptPw = "Ch&&sec@ke99!";

        String expectedString = "Password successfully captured";

        login.registerUser();
        String actual = login.pwOut;

        assertEquals(expectedString, actual);

    }

    @Test
    public void incorrectPassword() {
        login.inptUn = "kyl_1";
        login.inptPw = "password";

        String expectedString = "Password not correctly formatted please ensure"
                + "that your password contains at least 8 characters, a "
                + "capital letter, a number, and a special character.";

        login.registerUser();
        String actual = login.pwOut;

        assertEquals(expectedString, actual);

    }

    @Test
    public void usernameIncorrectlyFormatted() {

        boolean output = login.checkUserName("Kyl!!!!!!!");

        assertFalse(output);

    }

    @Test
    public void usernameCorrectlyFormatted() {

        boolean output = login.checkUserName("Kyl_1");

        assertTrue(output);

    }

    @Test
    public void passwordIncorrectlyFormatted() {

        boolean output = login.checkPasswordComplexity("password");

        assertFalse(output);

    }

    @Test
    public void passwordCorrectlyFormatted() {


        boolean output = login.checkPasswordComplexity("Ch&&sec@ke99!");

        assertTrue(output);

    }

    @Test
    public void loginSuccessful() {

        //Sets a username and password
        login.setSaveUn("kyl_1");
        login.setSavePw("Ch&&sec@ke99!");

        //Inputs correct username and psssword 
        boolean output = login.LoginUser("kyl_1", "Ch&&sec@ke99!");

        assertTrue(output);

    }

    @Test
    public void loginUnsuccessful() {

        //sets username and password
        login.setSaveUn("kyl_1");
        login.setSavePw("Ch&&sec@ke99!");

        //Inputs incorrect username and password
        boolean output = login.LoginUser("kyl_2", "BA&&sec!ke33!");

        assertFalse(output);

    }

}
