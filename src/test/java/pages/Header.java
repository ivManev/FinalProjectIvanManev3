package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {

    @FindBy(id = "nav-link-home")
    WebElement homeLink;

    @FindBy(id = "nav-link-login")
    WebElement loginLink;

    @FindBy(id = "nav-link-profile")
    WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLogin() {
        clickElement(loginLink);
    }

    public void goToProfile() {
        clickElement(profileLink);
    }

    public void goToNewPost() {
        clickElement(newPostLink);
    }

    public void checkLoginButtonVisibility() {
        smallWait.until(ExpectedConditions.visibilityOf(loginLink));
    }
}
