package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class ModifyYourProfileTest extends BaseTest {

    @Parameters({"username", "password", "publicInfo"})
    @Test
    public void modifyYourProfileTest(String username, String password, String publicInfo) {

        System.out.println("0. Login");
        Homepage homepage = new Homepage(driver);
        homepage.navigateToHomepage();

        Header header = new Header(driver);
        header.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("1. Navigate to Profile page");
        header.goToProfile();

        System.out.println("2. Click on the Modify your page icon");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickToModifyYourProfileButton();

        System.out.println("3. Validate that the Modify your page text is visible");
        ModifyYourProfileModal modifyYourProfileModal = new ModifyYourProfileModal(driver);
        String headerText = modifyYourProfileModal.getModifyYourProfileText();
        Assert.assertEquals(headerText, "Modify Your Profile", "Incorrect Modify Your Profile header text");

        System.out.println("4. Enter password");
        modifyYourProfileModal.enterPassword(password);

        System.out.println("5. Confirm password");
        modifyYourProfileModal.confirmPassword(password);

        System.out.println("6. Enter public info");
        modifyYourProfileModal.enterPublicInfo(publicInfo);

        System.out.println("7. Click Save button");
        modifyYourProfileModal.clickSaveButton();

        System.out.println("8. Validate that a pop-up appears indicating a successful profile update");
        String toastMsgText = modifyYourProfileModal.getToastMessageText();
        Assert.assertEquals(toastMsgText, "Successful login!", "Unsuccessful profile update!");

    }
}
