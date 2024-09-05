package Excercises.quizzes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class locatorExamTest {
    @Test
    public void examFlowE2E() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@data-test='shopping-cart-link']")).click();
        driver.findElement(By.xpath("//*[@data-test='checkout']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Arek");
        driver.findElement(By.id("last-name")).sendKeys("Lip");
        driver.findElement(By.id("postal-code")).sendKeys("44-238");
        driver.findElement(By.xpath("//*[@data-test='continue']")).click();
        driver.findElement(By.xpath("//*[text()='Finish']")).click();
        WebElement thankYouForOrder = driver.findElement(By.xpath("//*[@data-test='complete-header']"));
        Assert.assertTrue(thankYouForOrder.isDisplayed());
        driver.quit();
    }
}
