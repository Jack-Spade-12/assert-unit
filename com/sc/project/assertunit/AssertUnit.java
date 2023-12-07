/**
 * History
 * 		
 * 		December 2, 2023 - S. Cortel - Created
 *      December 8, 2023 - S. Cortel - Moved to a different project;
 *                                     Changed to a public static class instead
 *                                     of public;
 *                                     Added assertEquals() for List<String>;
 * 
 * Purpose
 * 		
 * 		Custom class used for testing. Acts as the class
 *      to `assert` without using the java assert. Allows
 *      `assert`-ion even before compilation.
 *      
 */
package com.sc.project.assertunit;
import java.util.List;

public static class AssertUnit {

    /**
     * This method checks if the values are equal
     * 
     * @param expectedResult to check in <code>boolean</code> form
     * @param actualResult to check in <code>boolean</code> form
     * @param definition of the method to test
     */
    static void assertEquals (boolean expectedResult, boolean actualResult, String definition) {
        if (expectedResult != actualResult) {
            throwFailed(expectedResult, actualResult, definition);
        }
    }

    /**
     * This method checks if the values are equal
     * 
     * @param expectedResult to check in <code>String</code> form
     * @param actualResult to check in <code>String</code> form
     * @param definition of the method to test
     */
    public static void assertEquals (String expectedResult, String actualResult, String definition) {
        try {
            if (expectedResult.compareTo(actualResult) != 0) {
                throwFailed(expectedResult, actualResult, definition);
            }
        }
        catch (NullPointerException e) {
            throwFailed(expectedResult, actualResult, definition);
        }
    }

    /**
     * This method checks if the values are equal
     * 
     * @param expectedResult to check in <code>int</code> form
     * @param actualResult to check in <code>int</code> form
     * @param definition of the method to test
     */
    public static void assertEquals (int expectedResult, int actualResult, String definition) {
        if (expectedResult != actualResult) {
            throwFailed(expectedResult, actualResult, definition);
        }
    }

    /**
     * This method checks if the values are equal
     * 
     * @param expectedResult to check in <code>int</code> form
     * @param actualResult to check in <code>int</code> form
     * @param definition of the method to test
     */
    public static void assertEquals (double expectedResult, double actualResult, String definition) {
        if (expectedResult != actualResult) {
            throwFailed(expectedResult, actualResult, definition);
        }
    }

    /**
     * This method checks if the values are equal
     * 
     * @param expectedResult to check in <code>String[]</code> form
     * @param actualResult to check in <code>String[]</code> form
     * @param definition of the method to test
     */
    public static void assertEquals (String[] expectedResult, String[] actualResult, String definition) {
        // Loop for each string array
        int i;
        int expectedResultLenth = expectedResult.length;
        int actualResultLength = actualResult.length;

        System.out.println();
        for (i = 0; i < expectedResultLenth && i < actualResultLength; i++ ) {
            System.out.println("\n\t" + i + " - Actual Result   : " + actualResult[i]);
            System.out.println("\n\t" + i + " - Expected Result : " + expectedResult[i]);
            assertEquals(expectedResult[i], actualResult[i], definition + " " + i);
        }

        // Loop through the rest of expected result
        if (expectedResultLenth > i) {
            for (int j = i; j < expectedResultLenth; j++) {
                System.out.println("\n\t" + j + " - Actual Result   : null");
                System.out.println("\n\t" + j + " - Expected Result : " + expectedResult[j]);
                assertEquals(expectedResult[j], null, definition + " " + j);
            }
        }

        // Loop through the rest of actual result
        if (actualResultLength > i) {
            for (int j = i; j < actualResultLength; j++) {
                System.out.println("\n\t" + j + " - Actual Result   : " + actualResult[j]);
                System.out.println("\n\t" + j + " - Expected Result : null");
                assertEquals(actualResult[j], null, definition + " " + j);
            }
        }
    }

    /**
     * This method checks if the values are equal
     * 
     * @param expectedResult to check in <code>List<String></code> form
     * @param actualResult to check in <code>List<String></code> form
     * @param definition of the method to test
     */
    private void assertEquals(List<String> expectedResult, List<String> actualResult, String definition) {
        assertEquals(expectedResult.toArray(new String[expectedResult.size()]), 
            actualResult.toArray(new String[actualResult.size()]), definition);
    }

    /**
     * This method prints out the failed assert message
     * 
     * @param expectedResult in <code>String</code> form
     * @param actualResult in <code>String</code> form
     * @param definition of the method tested
     */
    private static void throwFailed(String expectedResult, String actualResult, String definition) {
        System.out.println("\n\t" + definition + " failed");
        System.out.println("\tExpected Result : " + expectedResult);
        System.out.println("\tActual Result   : " + actualResult);
    }

    /**
     * This method prints out the failed assert message, overload
     * method of the original throwFailed() to accomodate
     * <code>int</code> values
     * 
     * @param expectedResult in <code>int</code> form
     * @param actualResult in <code>int</code> form
     * @param definition of the method tested
     */
    private static void throwFailed(int expectedResult, int actualResult, String definition) {
        throwFailed(String.valueOf(expectedResult), String.valueOf(actualResult), definition);
    }

    /**
     * This method prints out the failed assert message, overload
     * method of the original throwFailed() to accomodate
     * <code>double</code> values
     * 
     * @param expectedResult in <code>double</code> form
     * @param actualResult in <code>double</code> form
     * @param definition of the method tested
     */
    private static void throwFailed(double expectedResult, double actualResult, String definition) {
        throwFailed(String.valueOf(expectedResult), String.valueOf(actualResult), definition);
    }

    /**
     * This method prints out the failed assert message, overload
     * method of the original throwFailed() to accomodate
     * <code>boolean</code> values
     * 
     * @param expectedResult in <code>boolean</code> form
     * @param actualResult in <code>boolean</code> form
     * @param definition of the method tested
     */
    private static void throwFailed(boolean expectedResult, boolean actualResult, String definition) {
        throwFailed(String.valueOf(expectedResult), String.valueOf(actualResult), definition);
    }
 }
