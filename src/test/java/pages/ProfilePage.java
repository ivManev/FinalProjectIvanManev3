package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ProfilePage extends BasePage {
    private final String BASE_URL = "http://training.skillo-bg.com:4200/users/";

    @FindBy(css = ".profile-user-settings > h2")
    WebElement usernameHeader;

    @FindBy(css = "app-post")
    List<WebElement> existingPosts;

    @FindBy(css = "i.fa-user-edit")
    WebElement ModifyYourProfileButton;

    @FindBy(css = "p")
    WebElement userDescription;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUsernameHeaderText() {
        return getElementText(usernameHeader);
    }

    public void verifyProfilePageUrl() {
        verifyUrlContains(BASE_URL);
    }

    public void clickToModifyYourProfileButton() {
        clickElement(ModifyYourProfileButton);
    }

}
