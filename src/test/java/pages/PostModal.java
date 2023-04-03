package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostModal extends BasePage {

    @FindBy(css = ".container-flud .post-profile-img .post-user")
    WebElement usernameLink;

    @FindBy(tagName = "app-post-modal")
    WebElement modalDialog;

    @FindBy(css = "i.like")
    WebElement likeBtn;

    @FindBy(css = "i.ml-4")
    WebElement dislikeBtn;

    @FindBy(css = "input[formcontrolname='content']")
    WebElement commentField;

    @FindBy(className = "toast-message")
    WebElement toastMsg;

    public PostModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForDialogToAppear() {
        smallWait.until(ExpectedConditions.visibilityOf(modalDialog));
    }

    public void clickLikeBtn() {
        clickElement(likeBtn);
    }

    public void clickDislikeBtn() {
        clickElement(dislikeBtn);
    }

    public void enterComment(String comment) {
        enterText(commentField, comment);
    }

    public void confirmComment() {
        commentField.sendKeys(Keys.ENTER);
    }
    public String getToastMessageText() {
        String toastMsgText = getElementText(toastMsg).trim();
        return toastMsgText;
    }

    public void clickUsernameLink() {
        clickElement(usernameLink);
    }

}
