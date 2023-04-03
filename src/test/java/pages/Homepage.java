package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    private final String homepageUrl = "http://training.skillo-bg.com:4200/posts/all";

    @FindBy(css = "div.post-feed-img img")
    WebElement randomPost;

    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomepage() {
        driver.get(homepageUrl);
    }

    public void verifyHomepageUrl() {
        verifyUrl(homepageUrl);
    }

    public void clickRandomPost() {
        clickElement(randomPost);
    }
}
