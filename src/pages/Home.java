package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;

    By buttonTakeTour = By.xpath("//div[@class='welcomesection']/div/button");
    By closePopUp = By.xpath("//*[@class='trademark-strip']//*[@class='icon-cancel']");
    By buttonSkipTour = By.xpath("//div[@class='contentholder active']/div[@class='letsskip']/button");
    By currencyDropdown = By.className("sel_state");
    By loginPanel = By.xpath("//*[@class='loginPanel']//button");
    By buttonRegister = By.xpath("//*[@class='loginDropdown']//*[contains(text(),'Register')]");
    By doneCurrency = By.className("doneButton");
    By userLoggedIn = By.xpath("//*[@class='userPanel']//strong");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToHomePage(String url) {
        driver.get(url);
    }

    public void TakeAndSkipTour() {
        driver.findElement(buttonTakeTour).click();
        driver.findElement(buttonSkipTour).click();
    }

    public void SelectCurrency(String currency) {
        driver.findElement(currencyDropdown).click();
        driver.findElement(By.xpath("//*[@class='currencyName'][text()='" + currency + "']")).click();
    }

    public void GoToRegister() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(loginPanel)).click();
        driver.findElement(buttonRegister).click();
    }


    public void ValidateRegister(String username) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(doneCurrency)).click();
        WebElement userDropdown = driver.findElement(userLoggedIn);
        assert userDropdown.getText().equals(username) : "Registered user " + username + " is not the same as in home page: " + userDropdown.getText();
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "Url of home page does not match";
    }
}
