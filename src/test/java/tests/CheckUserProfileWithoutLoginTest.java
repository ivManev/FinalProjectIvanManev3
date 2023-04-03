package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.Homepage;
import pages.PageNotFoundPage;
import pages.PostModal;

public class CheckUserProfileWithoutLoginTest extends BaseTest {

    @Test
    public void checkUserProfileWithoutLoginTest() {
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

        System.out.println("4. Click on the username in top-right corner in order to see its profile");
        postModal.clickUsernameLink();

        System.out.println("5. Verify that the following toast message appears: You must be logged in in order to see this page");
        String toastMsgText = postModal.getToastMessageText();
        Assert.assertEquals(toastMsgText, "You must be logged in in order to see this page!", "Incorrect toast message!");

        System.out.println("6. Verify that you have been redirected to Page not found page");
        PageNotFoundPage pageNotFoundPage = new PageNotFoundPage(driver);
        pageNotFoundPage.verifyPageNotFoundUrl();
    }
}
