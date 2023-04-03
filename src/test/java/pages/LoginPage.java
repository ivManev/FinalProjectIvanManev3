package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final String loginPageUrl = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(css = "form .h4")
    WebElement signInHeader;

    @FindBy(css = "input[formcontrolname = 'usernameOrEmail']")
    WebElement usernameField;

    @FindBy(css = "input[formcontrolname = 'password']")
    WebElement passwordField;

    @FindBy(id = "sign-in-button")
    WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginUrl() {
        verifyUrl(loginPageUrl);
    }

    public String getSignInHeaderText() {
        return getElementText(signInHeader);
    }

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickSignIn() {
        clickElement(signInButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }
}
