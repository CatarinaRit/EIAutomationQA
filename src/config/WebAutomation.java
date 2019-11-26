package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.Home;
import pages.Register;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class WebAutomation {

    public static WebDriver driver;

    public static void main(String[] args) {
        driver = GetDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Home home = new Home(driver);
        String url = "https://staging.engineer.ai/home";
        home.GoToHomePage(url);
        home.TakeAndSkipTour();
        home.SelectCurrency("US Dollars");
        home.GoToRegister();

        Register register = new Register(driver);
        //Generating random user credentials:
        String email = WebAutomation.RandomValue(15) + "@qatesting.com";
        String username = RandomValue(6);
        String password = RandomValue(9);
        //Proceed to register
        register.SignUpAndRegister(email, username, "+351967754192", password);
        home.ValidateRegister(username);

        //Closing the browser
        driver.close();
    }


    public static String RandomValue(int count) {
        final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final SecureRandom RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
        }
        return sb.toString();
    }

    private static WebDriver GetDriver() {
        WebDriver driver;
                System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
              // driver = new ChromeDriver(chromeOptions);
                System.out.printf("Browser not found, using Chrome as default");
                driver = new ChromeDriver();
        return driver;
    }
}