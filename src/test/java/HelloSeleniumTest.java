import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloSeleniumTest {
    //kodu pod spodem nie trzeba wołać przez W3C protocol który autmatycznie robi setup drivera
//    @BeforeAll
//    public static void setupClass() {
//        WebDriverManager.safaridriver().setup();
//    }

    private WebDriver driver;

    @After
    public void tearDown() {
        if (driver == null){
        } else {
            driver.quit();
        }
    }

    @Test
    public void firstTest() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
//        driver.quit();
    }

    @Test
    public void firefoxTest() {
//        WebDriver driver = new FirefoxDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
//        driver.quit();
    }

    @Test
    public void convert() {
        double weightInPounds = 160;
        final double CONVERSION_RATIO = 0.45359237;
        double weightInKg = weightInPounds * CONVERSION_RATIO;
        System.out.println("Weight in kg " + weightInKg);
    }

    @Test
    public void operators() {
        //assignment
        int result = 10 - 5;
        //plus
        result = 5 + 5;
        assertEquals(10, result);
        //minus
        result = 15 - 5;
        assertEquals(10, result);
        //multiplication
        result = 2 * 5;
        assertEquals(10, result);
        //division
        result = 30 / 3;
        assertEquals(10, result);
        //reminder or modulus
        result = 4 % 3;
        assertEquals(1, result);
    }

    @Test
    public void exercise1() {
        int firstVar = 5;
        double secondVar = 12;
        System.out.println("addition result = " + (firstVar + secondVar));
        System.out.println("sbustraction result = " + (firstVar - secondVar));
        System.out.println("multiplication result = " + (firstVar * secondVar));
        System.out.println("division result = " + (firstVar / secondVar));
    }

    @Test
    public void exercise2() {
        int firstVar = 10;
        double secondVar = 5.5;
        assertTrue("Second number is higher than first.", firstVar > secondVar);
    }

    @Test
    public void exercise3() {
        double weightInKg = 73;
        double heightInM = 1.73;
        double bmi;

        bmi = weightInKg / (heightInM * heightInM);

        System.out.println("Your currnet BMI is " + bmi);
        assertTrue("You are not in your healthy BMI range!", 18.5 <= bmi && bmi <= 24.9);
    }

    @Test
    public void excercise4() {
        String word1 = "something like this";
        String word2 = "SomeThing like this ";

        assertEquals(word1.toLowerCase().trim(), word2.toLowerCase().trim());
    }

    @Test
    public void exercise5() {
        String firstWord = "So this is the last exercise, and it will be lets say the finall boss of this part";
        String secondWord = " lets say the finall boss ";

        assertTrue(firstWord.contains(secondWord));
    }

    @Test
    public void exerciseIf() {
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        String inventoryElementLocator = "//*[@class='inventory_item']";
//      metodę poniżej zastąpiłem nową prywatną metodą findElements, to samo do metod printowania
//        int countOfItems = driver.findElements(By.xpath(inventoryElementLocator)).size();
        int countOfItems = findElements(driver, inventoryElementLocator).size();
        if (countOfItems == 10) {
//            System.out.println("countOfItems = " + countOfItems);
            print("countOfItems = " + countOfItems);
        } else if (countOfItems == 9) {
//            System.out.println("countOfItems = " + countOfItems);
            print("countOfItems = " + countOfItems);
        } else {
//            System.out.println("countOfItems = " + countOfItems);
            print("countOfItems = " + countOfItems);
        }

//        driver.quit();
    }

    private List<WebElement> findElements(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    private void print(String whatToPrint) {
        System.out.println(whatToPrint);
    }

    @Test
    public void funWithSelenium() {
        String inventoryItemLocator = "//*[@class='inventory_item']";
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        List<WebElement> elements = findElements(driver, inventoryItemLocator);
        WebElement element = driver.findElement(By.xpath(inventoryItemLocator));

        assertEquals(6, elements.size());
        assertTrue(element.isDisplayed());

//        driver.quit();
    }

    // https://www.saucedemo.com/v1/inventory.html
}