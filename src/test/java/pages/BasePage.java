package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected WebDriverWait smallWait;
    protected WebDriverWait mediumWait;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }

    protected void verifyUrl(String url) {
        mediumWait.until(ExpectedConditions.urlToBe(url));
    }

    protected void verifyUrlContains(String url) {
        mediumWait.until(ExpectedConditions.urlContains(url));
    }

    protected void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected String getElementText(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void clearTextField(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }
    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

}
