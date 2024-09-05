package Excercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaBasicExercise3Test {
    @Test
    //print all the operators
    public void exerciseOne() {
        double first = 8;
        double second = 3;
        System.out.println("Result of the addition: " + (first - second));
        System.out.println("Result of the subtraction: " + (first + second));
        System.out.println("Result of the multiplication: " + (first * second));
        System.out.println("Result of the division: " + (first / second));
    }

    @Test
    //compare two values
    public void exerciseTwo() {
        double num1 = 10;
        double num2 = 5.5;
        assertTrue("The second number is higher than first.", num1 > num2);
    }

    @Test
    //validates BMI range
    public void exerciseThree() {
        double heightInMeters = 1.73;
        double weightInKg = 74;
        double BMIValue = weightInKg / (heightInMeters * heightInMeters);
        assertTrue("Your BMI isn't in healthy range. The value is " + (BMIValue), 18.5 <= BMIValue && BMIValue <= 24.9);
    }

    @Test
    //validate that two words are equal
    public void exerciseFourth() {
        String firstString = "hello there, ahh master Windu";
        String secondString = "Hello there, ahh Master Windu ";
        assertEquals(firstString.toLowerCase().trim(), secondString.toLowerCase().trim());
    }

    @Test
    //validate that string is part of other string
    public void excerciseFifth() {
        String fullString = "Uuuu ajajaj ajajaj jedni kończą inni zaczynają bal, Kalifornia";
        String partialString = "inni zaczynają bal";
        assertTrue("Full message does not contain partial message", fullString.contains(partialString));
    }
}
