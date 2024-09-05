package Excercises.quizzes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorsInCodeTest {
    WebDriver driver;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void typesOfLocators() {
        driver.get("https://saucedemo.com");

//        ID
        driver.findElement(By.id("user-name"));
//        Name
        driver.findElement(By.name("user-name"));
//        Class name
        driver.findElement(By.className("form_group"));
//        Tag name
        driver.findElement(By.tagName("input"));
//        CSS selector
        driver.findElement(By.cssSelector("#user-name"));
//        Xpath
        driver.findElement(By.xpath("//*[@data-test='username']"));

        driver.navigate().to("https://ultimateqa.com/simple-html-elements-for-automation/");

//        link text
        driver.findElement(By.linkText("Click me using this link text!"));
//        partial link text
        driver.findElement(By.partialLinkText("Click me using"));
    }

    @Test
    public void tryMoreClassName() {
        driver.get("https://saucedemo.com");
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.className("login-box"));
        driver.findElement(By.className("login_credentials"));
        driver.findElement(By.className("login_password"));
        driver.findElement(By.className("login_logo"));
    }

    @Test
    public void tryMoreTagName() {
        driver.get("https://saucedemo.com");
        driver.findElement(By.tagName("title"));
        driver.findElement(By.tagName("form"));
        driver.findElement(By.tagName("h4"));
        driver.findElement(By.tagName("br"));
        driver.findElement(By.tagName("input"));
    }
}
