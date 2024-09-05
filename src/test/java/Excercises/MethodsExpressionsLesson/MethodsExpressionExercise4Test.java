package Excercises.MethodsExpressionsLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MethodsExpressionExercise4Test {
//    Driver variable must be initialized here if we want to have access to this field everywhere in our class
    WebDriver driver;

//    It's worse than setUp method
//    WebDriver driver = new ChromeDriver();


    @Before
    public void setUp() {
//        It's better to make setUp method, because we have new instance of the driver per class which guarantee us
//        fresh driver (prevent from side effect, and guarantee clean up driver).
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
//        We dont need to call quit() method in each test method because we now have tearDown with quit after each test.
        driver.quit();
    }

    @Test
    public void exerciseIf() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        String inventoryElementLocator = "//*[@class='inventory_item']";
        int countOfItems = driver.findElements(By.xpath(inventoryElementLocator)).size();

        if (countOfItems == 10) {
            System.out.println("countOfItems = " + countOfItems);
        } else if (countOfItems == 9) {
            System.out.println("countOfItems = " + countOfItems);
        } else {
            System.out.println("countOfItems = " + countOfItems);
        }
    }

    @Test
    public void exerciseSeleniumListOfElements() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        String inventoryElementLocator = "//*[@class='inventory_item']";
        List<WebElement> elements = driver.findElements(By.xpath(inventoryElementLocator));
        WebElement element = driver.findElement(By.xpath(inventoryElementLocator));
//        System.out.println(elements);
        assertEquals(6, elements.size());
        assertTrue(element.isDisplayed());
    }

    @Test
    public void exerciseMethodChallenge() {
//        1. Create a method that take 2 parameters, name and position in high score table.
//           It should display message with player name and score position.
//        2. Create method that calculate player score position.

        PlayerExercise4 player1 = new PlayerExercise4("Poziomka", 1500);
        PlayerExercise4 player2 = new PlayerExercise4("David", 900);
        PlayerExercise4 player3 = new PlayerExercise4("Luck", 400);
        PlayerExercise4 player4 = new PlayerExercise4("Dyzio", 50);

        displayHighScorePosition(player1.playerName, player1.playerScore);
        displayHighScorePosition(player2.playerName, player2.playerScore);
        displayHighScorePosition(player3.playerName, player3.playerScore);
        displayHighScorePosition(player4.playerName, player4.playerScore);
    }

    private void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(playerName + " managed to get into position "
                + calculateHighScorePosition(highScorePosition) + " on the high score table");
    }

    private int calculateHighScorePosition(int playerScore) {
        if(playerScore >= 1000) {
            return 1;
        } else if(playerScore >= 500) {
            return 2;
        } else if(playerScore >= 100) {
            return 3;
        } else {
            return 4;
        }
    }

    @Test
    public void excercise1() {
//        I'm too lazy to make rectangle class for this exercise
        calculatePerimeter(10, 20);
        calculatePerimeter(5, 5);
        calculatePerimeter(2, 9);
    }

    private void calculatePerimeter(int width, int length) {
        double perimeterOfRectangle = ((width + length)*2);
        if(width == length) {
            System.out.println("Perimeter of rectangle equals "+ perimeterOfRectangle + " and it's a square");
        } else {
            System.out.println("Perimeter of rectangle equals "+ perimeterOfRectangle);
        }
    }

    @Test
    public void exercise2() {
        printTheInterestFrom(2000);
        printTheInterestFrom(500);
        printTheInterestFrom(50);
    }

    private void printTheInterestFrom(double balance) {
        double calculatedInterest = interestCalculator(balance);
        System.out.println("The interest equals " + calculatedInterest + " from the balance of " + balance);
    }

    private double interestCalculator(double balance) {
        if(balance >= 1000.01) {
            return balance * 0.07;
        } else if(balance >= 100.01) {
            return balance * 0.05;
        } else if(balance >= 0) {
            return balance * 0.03;
        } else {
            return 0;
        }
    }

    @Test
    public void exercise3() {
        int a = 15, b = 33, c = 21;
        printHighestOfThreeNumbers(a, b, c);
    }

    private void printHighestOfThreeNumbers(int a, int b, int c) {
        if (a > b) {
            if(a > c) {
                System.out.println(a + " is the highest number");
            }
        } else if(b > c) {
            System.out.println(b + " is the highest number");
        } else {
            System.out.println(c + " is the highest number");
        }
    }
}