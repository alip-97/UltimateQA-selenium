package Excercises.webDriverMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class ActionQuizTest {

    /* 1
     * Go here "https://the-internet.herokuapp.com/dropdown"
     * Select option 1 from the dropdown
     * Assert that option 1 is selected
     * Assert taht option 2 is NOT selected
     * */

    /* 2
     * Go to "https://the-internet.herokuapp.com/hovers"
     * Hover over the first image
     * Assert that on hover there is text that is displayed below "name: user1"
     * */

    /* 3
     * https://the-internet.herokuapp.com/context_menu
     * Right click
     * close alert
     * driver.switchTo().alert().accept();
     * */

    /* 4
     * go to "https://the-internet.herokuapp.com/key_presses"
     * send right arrow key to the input box
     * assert that you got this text back "You entered: RIGHT"
     */

    /* 5
     * go to https://ultimateqa.com/simple-html-elements-for-automation/
     * find element with text "Clickable Icon"
     * Assert href attribute =  https://ultimateqa.com/link-success/
     * Get CSS value: "background-origin"
     * Assert that it equals "padding-box"
     */

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void exerciseOne(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.xpath("//*[@id='dropdown']"));
        WebElement option1 = element.findElement(By.xpath("//option[text()='Option 1']"));
        WebElement option2 = element.findElement(By.xpath("//option[text()='Option 2']"));
        element.click();
        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
    }

    @Test
    public void exerciseTwo(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstImage = driver.findElement(By.xpath("//img[@alt='User Avatar'][1]"));
        WebElement firstImageText = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Actions action = new Actions(driver);
        action.moveToElement(firstImage).perform();
        assertTrue(firstImageText.isDisplayed());
    }

    @Test
    public void exerciseThree(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void exerciseFour() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.xpath("//*[@id='target']"));
        element.sendKeys(Keys.ARROW_RIGHT);
        assertTrue(driver.findElement(By.xpath("//*[text()='You entered: RIGHT']")).isDisplayed());
    }

    @Test
    public void exerciseFive(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.xpath("//*[text()='Clickable Icon']"));
        assertEquals("https://ultimateqa.com/link-success/", element.getAttribute("href"));
        assertEquals("padding-box", element.getCssValue("background-origin"));
    }
}
