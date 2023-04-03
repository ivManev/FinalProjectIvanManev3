package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    public static final String TEST_RESOURCES_DIR = "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    public static final String DOWNLOAD_DIR = TEST_RESOURCES_DIR.concat("download" + File.separator);
    public static final String SCREENSHOT_DIR = TEST_RESOURCES_DIR.concat("screenshots" + File.separator);
    public static final String REPORT_DIR = TEST_RESOURCES_DIR.concat("reports" + File.separator);


    @BeforeSuite
    public void setupSuite() throws IOException {
        cleanDirectory(REPORT_DIR);
        cleanDirectory(DOWNLOAD_DIR);
        cleanDirectory(SCREENSHOT_DIR);
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir").concat(File.separator).concat(DOWNLOAD_DIR));
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        SoftAssert softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        takeScreenShot(testResult);
        if (driver != null) {
            driver.close();
        }
    }

    private void cleanDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        FileUtils.cleanDirectory(directory);
        String[] fileList = directory.list();
        if (fileList != null && fileList.length == 0) {
            System.out.printf("All files are deleted in Directory: %s%n", directoryPath);
        } else {
            System.out.printf("Unable to delete the files in Directory:%s%n", directoryPath);
        }
    }


    protected boolean isFileDownlaoded(File file, int timeoutSec) throws InterruptedException {
        for (int i = 0; i < timeoutSec; i++) {
            if(file.exists()) {
                return true;
            }
            Thread.sleep(1000);
        }
        return false;
    }

    private void takeScreenShot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testName = testResult.getName();
            try {
                FileUtils.copyFile(screenshot, new File(SCREENSHOT_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
