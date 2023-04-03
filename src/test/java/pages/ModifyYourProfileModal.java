package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModifyYourProfileModal extends BasePage {

    @FindBy(css = "app-edit-profile-modal h4")
    WebElement modifyYourProfileHeader;

    @FindBy(css = "input[formcontrolname='username']")
    WebElement usernameField;
    @FindBy(css = "input[formcontrolname='email']")
    WebElement emailField;
    @FindBy(css = "input[formcontrolname='password']")
    WebElement passwordField;
    @FindBy(css = "input[formcontrolname='confirmPassword']")
    WebElement confirmPasswordField;
    @FindBy(css = "textarea[formcontrolname='publicInfo']")
    WebElement publicInfoField;
    @FindBy(css = "button.btn-primary")
    WebElement saveButton;
    @FindBy(className = "toast-message")
    WebElement toastMsg;
    @FindBy(css = "p")
    WebElement publicInfoContainer;

    public ModifyYourProfileModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getModifyYourProfileText() {
        return getElementText(modifyYourProfileHeader);
    }
    public void clearUsernameField() {
        clearTextField(usernameField);
    }
    public void clearEmailField() {
        clearTextField(emailField);
    }

    public void enterNewUsername(String newUsername) {
        enterText(usernameField, newUsername);
    }
    public void enterNewEmail(String newEmail) {
        enterText(emailField, newEmail);
    }
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }
    public void confirmPassword(String password) {
        enterText(confirmPasswordField, password);
    }
    public void enterPublicInfo(String publicInfo) {
        enterText(publicInfoField, publicInfo);
    }
    public void clickSaveButton() {
        clickElement(saveButton);
    }
    public String getToastMessageText() {
       String toastMsgText = getElementText(toastMsg).trim();
       return toastMsgText;
    }
    public String getPublicInfoText() {
        String publicInfoText = getElementText(publicInfoContainer).trim();
        return  publicInfoText;
    }

}
