package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Header;
import pages.Homepage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest extends BaseTest {
    @Parameters({"usernameOrEmail", "password", "username"})
    @Test
    public void loginTest(String usernameOrEmail, String password, String username) {
        System.out.println("1. Navigate to home page");
        Homepage homepage = new Homepage(driver);
        homepage.navigateToHomepage();

        System.out.println("2. Navigate to Login");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3. Check that the login page URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();

        System.out.println("4. Check that Sign in header is displayed");
        String headerText = loginPage.getSignInHeaderText();
        Assert.assertEquals(headerText, "Sign in", "Incorrect Sign in header text.");

        System.out.println("5. Enter username");
        loginPage.enterUsername(usernameOrEmail);

        System.out.println("6. Enter password");
        loginPage.enterPassword(password);

        System.out.println("7. Click Sign in button");
        loginPage.clickSignIn();

        System.out.println("8. Check that the homepage URL is opened");
        homepage.verifyHomepageUrl();

        System.out.println("9. Navigate to Profile page");
        header.goToProfile();

        System.out.println("10. Check that the profile page URL is opened");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyProfilePageUrl();

        System.out.println("11. Check that the username is displayed correctly");
        String usernameHeaderText = profilePage.getUsernameHeaderText();
        Assert.assertEquals(usernameHeaderText, username, "Incorrect username header!");
    }
}
