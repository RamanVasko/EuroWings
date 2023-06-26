package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightStatusPage {
    private WebDriver driver;

    private final By iUnderstandButton = By.xpath("//div[@class='button__contianer']//button[3]");
    private final By checkYourFlightStatusSection = By.xpath("//h2[text()=\" Check your flight status \"]");
    private final By flightRouteRadioButton = By.xpath("(//div[@class=\"m-form-radiobutton__input\"])[1]");
    private final By departureAirportField = By.xpath("//span[text()=\"Departure airport\"]");
    private final By departureAirportInputField = By.xpath("//input[@aria-label=\"Departure airport\"]");
    private final By destinationAirportField = By.xpath("//span[text()=\"Destination airport\"]");
    private final By destinationAirportInputField = By.xpath("//input[@aria-label=\"Destination airport\"]");
    private final By departureDateField = By.xpath("(//div[@class=\"a-input-text\"])[2]");
    private final By forthWeekDay = By.xpath("//tr[@class=\"calendar-table__row\"][4]//child::td[4]");
    private final By showFlightStatusButton = By.xpath("(//button[@data-component-name=\"cta\"])[1]");
    private final By flightStatusTableHeader = By.xpath("//h5[@data-component-name=\"headline\"]");
    private final By activeDay = By.xpath("(//div[@class=\"o-search-flight-status__date-navigation__date-day\"])[3]");
    private final By flightsList = By.xpath("//div[@class=\"o-search-flight-status__card\"]");

    public FlightStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptPrivacySettings() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(iUnderstandButton)));
            driver.findElement(iUnderstandButton).click();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to click on [I understand] button" + e.getMessage());
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void fillDepartureAirportField(String departureAirport) {
        scrollToWebElementJS(driver.findElement(checkYourFlightStatusSection));
        driver.findElement(flightRouteRadioButton).click();
        try {
            if (driver.findElement(departureAirportField).isDisplayed()) {
                driver.findElement(departureAirportField).click();
                driver.findElement(departureAirportInputField).sendKeys(departureAirport);
                driver.findElement(departureAirportInputField).sendKeys(Keys.ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to fill Departure airport" + e.getMessage());
        }
    }

    public void fillDestinationAirportField(String destinationAirport) {
        try {
            if (driver.findElement(destinationAirportField).isDisplayed()) {
                driver.findElement(destinationAirportField).click();
                driver.findElement(destinationAirportInputField).sendKeys(destinationAirport);
                driver.findElement(destinationAirportInputField).sendKeys(Keys.ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to fill Destination airport" + e.getMessage());
        }
    }

    //Refactor is needed. The date should be selected in more flexible way
    public void fillDepartureDateField() {
        scrollToWebElementJS(driver.findElement(departureDateField));
        try {
            if (driver.findElement(departureDateField).isDisplayed()) {
                driver.findElement(departureDateField).click();
                driver.findElement(forthWeekDay).click();
                driver.findElement(showFlightStatusButton).sendKeys(Keys.ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to fill Departure date" + e.getMessage());
        }
    }

    public String getFlightStatusTableHeader() {
        scrollToWebElementJS(driver.findElement(flightStatusTableHeader));
        return driver.findElement(flightStatusTableHeader).getText();
    }

    public String getActiveDay() {
        return driver.findElement(activeDay).getText();
    }

    public boolean isFlightExist() {
        return driver.findElements(flightsList).isEmpty();
    }

    public WebElement scrollToWebElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}
