package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.FlightStatusPage;

public class Base {
    public WebDriver driver;

    protected FlightStatusPage flightStatusPage;

    @BeforeMethod
    public void setUp(String url) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
        flightStatusPage = new FlightStatusPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
