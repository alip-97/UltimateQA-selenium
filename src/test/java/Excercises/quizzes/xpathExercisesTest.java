package Excercises.quizzes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathExercisesTest {
    WebDriver driver;
    String exercisesUrl = "https://ultimateqa.com/simple-html-elements-for-automation/";

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get(exercisesUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void exerciseOne() {
        WebElement SDETSalary = driver.findElement(By.xpath("//*[text()='HTML Table with no id']" +
                "/..//td[text()='$150,000+']"));
        Assert.assertTrue(SDETSalary.isDisplayed());
    }

    @Test
    public void exerciseTwo() {
        WebElement ATASalary = driver.findElement(By.xpath("//*[@id='htmlTableId']//td[text()='" +
                "Automation Testing Architect']//following-sibling::td[2]"));
        Assert.assertEquals("$120,000+", ATASalary.getText());
    }

    @Test
    public void exerciseThree() {
        String textToContain = "Feel free to practice your test automation on these elements.";
        WebElement textBeforeButtons = driver.findElement(By.xpath("//*[(@id='button1') and (text()='Click" +
                " Me!')]/../preceding-sibling::h3"));
        // Also: "//buttons[text()='Click Me!']/ancestor::form/preceding-sibling::h3" - should work fine
        Assert.assertTrue(textBeforeButtons.getText().contains(textToContain));
    }

    @Test
    public void exerciseFour() {
        String jobTitle = "Quality Assurance Engineer";
        WebElement lastTableRowJobName = driver.findElement(By
                .xpath("//*[@id='htmlTableId']//tr[last()]/td[1]"));
        Assert.assertEquals(lastTableRowJobName.getText(), jobTitle);
    }
}
