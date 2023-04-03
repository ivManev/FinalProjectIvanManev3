package pages;

import org.openqa.selenium.WebDriver;

public class PageNotFoundPage extends BasePage {

    private final String pageNotFoundUrl = "http://training.skillo-bg.com:4200/not-found";
    public PageNotFoundPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageNotFoundUrl() {
        verifyUrl(pageNotFoundUrl);
    }
}
