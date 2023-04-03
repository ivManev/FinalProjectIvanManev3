package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.Homepage;
import pages.LoginPage;
import pages.PostModal;

public class LikePostWithoutLoginTest extends BaseTest {


    @Test
    public void likeWithoutLoginTest() {

        System.out.println("1. Navigate to home page");
        Homepage homepage = new Homepage(driver);
        homepage.navigateToHomepage();

        System.out.println("2. Verify that there is a Login button");
        Header header = new Header(driver);
        header.checkLoginButtonVisibility();

        System.out.println("3. Click on a random image");
        homepage.clickRandomPost();
        PostModal postModal = new PostModal(driver);
        postModal.waitForDialogToAppear();

        System.out.println("4. Click the Like button");
        postModal.clickLikeBtn();

        System.out.println("5. Verify that a toast message appears saying that you must login first");
        String toastMsgText = postModal.getToastMessageText();
        Assert.assertEquals(toastMsgText, "You must login", "Incorrect toast message!");

        System.out.println("6. Verify that you have been redirected to Login page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
    }
}
