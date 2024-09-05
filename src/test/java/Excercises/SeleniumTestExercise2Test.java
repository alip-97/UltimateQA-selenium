package Excercises;

import org.junit.Test;

public class SeleniumTestExercise2Test {
    int valueInPounds = 15;
    final double POUND_TO_KG_CONVERSION = 0.45359237;
    double valueInKilograms;
    @Test
    public void poundToKgConverter() {
        valueInKilograms = valueInPounds * POUND_TO_KG_CONVERSION;
        System.out.println(valueInPounds +" pounds equals " + valueInKilograms +"kg");
    }
}
