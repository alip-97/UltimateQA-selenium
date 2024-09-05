package Excercises;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolsSetupExercise1Test {

    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.cypress.io/");
        driver.quit();
    }

    @Test
    public void secondTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        driver.quit();
    }

    @Test
    public void thirdTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }

}
