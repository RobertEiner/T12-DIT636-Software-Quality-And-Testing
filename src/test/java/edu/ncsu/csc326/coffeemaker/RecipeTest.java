package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {


    Recipe recipe;
    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void testGetAmtChocolate() {

        int expected = 0;
        int actual = recipe.getAmtChocolate();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAmtCoffee() {

        int expected = 0;
        int actual = recipe.getAmtCoffee();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAmtMilk() {

        int expected = 0;
        int actual = recipe.getAmtMilk();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAmtSugar() {

        int expected = 0;
        int actual = recipe.getAmtSugar();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetAmtChocolatePositive() {
        try {
            recipe.setAmtChocolate("1");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to a positive integer");
        }

        assertEquals(1, recipe.getAmtChocolate());

    }

    @Test
    public void testSetAmtChocolateZero(){
        try {
            recipe.setAmtChocolate("0");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to 0");
        }

        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolateNegative() {
        try {
            recipe.setAmtChocolate("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate("-2");
                }
        );

        assertEquals(5, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtSugarPositive() {
        try {
            recipe.setAmtSugar("1");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to a positive integer");
        }

        assertEquals(1, recipe.getAmtSugar());

        try {
            recipe.setAmtSugar("0");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to 0");
        }
    }

    @Test
    public void testSetAmtSugarZero(){
        try {
            recipe.setAmtSugar("0");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to 0");
        }

        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtSugarNegative() {

        try {
            recipe.setAmtSugar("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("-2");
                }
        );

        assertEquals(5, recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtCoffeePositive() {
        try {
            recipe.setAmtCoffee("1");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to a positive integer");
        }

        assertEquals(1, recipe.getAmtCoffee());

    }

    @Test
    public void testSetAmtCoffeeZero(){
        try {
            recipe.setAmtCoffee("0");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to 0");
        }

        assertEquals(0, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffeeNegative() {

        try {
            recipe.setAmtCoffee("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("-2");
                }
        );

        assertEquals(5, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtMilkPositive() {
        try {
            recipe.setAmtChocolate("1");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to a positive integer");
        }

        assertEquals(1, recipe.getAmtChocolate());

    }

    @Test
    public void testSetAmtMilkZero(){
        try {
            recipe.setAmtChocolate("0");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown when amtChocolate is set to 0");
        }

        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtMilkNegative() {
        try {
            recipe.setAmtMilk("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("-2");
                }
        );

        assertEquals(5, recipe.getAmtMilk());
    }


    @Test
    public void testSetChocolateNonInteger() {
        try {
            recipe.setAmtChocolate("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtChocolate("2.5");
                }
        );

        assertEquals(5, recipe.getAmtChocolate());
    }

    @Test
    public void testSetCoffeeNonInteger() {
        try {
            recipe.setAmtCoffee("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtCoffee("2.5");
                }
        );

        assertEquals(5, recipe.getAmtCoffee());
    }

    @Test
    public void testSetSugarNonInteger() {
        try {
            recipe.setAmtSugar("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtSugar("2.5");
                }
        );

        assertEquals(5, recipe.getAmtSugar());
    }

    @Test
    public void testSetMilkNonInteger() {
        try {
            recipe.setAmtMilk("5");
        } catch (RecipeException exception) {
            fail("Setting attribute to a positive integer value shouldn't throw an exception");
        }

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    recipe.setAmtMilk("2.5");
                }
        );

        assertEquals(5, recipe.getAmtMilk());
    }



    @Test
    public void testSetNameNormal() {

        String name = "Test Recipe";
        recipe.setName("Test Recipe");

        assertEquals(name, recipe.getName());
    }

    @Test
    public void testSetNameNull() {

        String name = "Test Recipe";
        recipe.setName("Test Recipe");

        recipe.setName(null);

        assertEquals(name, recipe.getName());
    }

    @Test
    public void testSetPricePositiveInteger() {

        try {
            recipe.setPrice("10");
        } catch (RecipeException exception) {
            fail("Setting price to a positive integer value");
        }

        assertEquals(10, recipe.getPrice());
    }


    @Test
    public void testSetPriceNegative() {
        Throwable exception = assertThrows(RecipeException.class, () -> {
            recipe.setPrice("-10");
        });
    }


    @Test
    public void testSetPriceZero() {

        try {
            recipe.setPrice("0");
        } catch (RecipeException exception) {
            fail("Setting price to a positive integer value");
        }

        assertEquals(0, recipe.getPrice());
    }

    @Test
    public void testSetPriceNonInteger() {
        Throwable exception = assertThrows(RecipeException.class, () -> {
            recipe.setPrice("7.5");
        });
    }

    @Test
    public void testToString() {
        String name = "Recipe test";

        recipe.setName(name);

        assertEquals(name, recipe.toString());
    }

    @Test
    public void testHashCode() {
        String nameRecipe = "recipe";

        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipe1.setName(nameRecipe);
        recipe2.setName(nameRecipe);

        try {
            recipe1.setAmtChocolate("1");
            recipe1.setAmtMilk("1");
            recipe1.setAmtCoffee("1");
            recipe1.setAmtSugar("1");
            recipe1.setPrice("1");

            recipe2.setAmtChocolate("2");
            recipe2.setAmtMilk("2");
            recipe2.setAmtCoffee("2");
            recipe2.setAmtSugar("2");
            recipe2.setPrice("2");

        } catch (RecipeException exception) {
            fail();
        }

        assertEquals(recipe1.hashCode(), recipe2.hashCode());
    }

    @Test
    public void testEqualsSameName() {
        String nameRecipe = "recipe";

        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        try {
            recipe1.setAmtChocolate("1");
            recipe1.setAmtMilk("1");
            recipe1.setAmtCoffee("1");
            recipe1.setAmtSugar("1");
            recipe1.setPrice("1");

            recipe2.setAmtChocolate("2");
            recipe2.setAmtMilk("2");
            recipe2.setAmtCoffee("2");
            recipe2.setAmtSugar("2");
            recipe2.setPrice("2");

        } catch (RecipeException exception) {
            fail();
        }


        recipe1.setName(nameRecipe);
        recipe2.setName(nameRecipe);

        boolean areTheSameRecipe = recipe1.equals(recipe2);

        assertTrue(areTheSameRecipe);
    }

    @Test
    public void testEqualsDifferentName() {
        String nameRecipe1 = "recipe1";
        String nameRecipe2 = "recipe2";

        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipe1.setName(nameRecipe1);
        recipe2.setName(nameRecipe2);

        try {
            recipe1.setAmtChocolate("1");
            recipe1.setAmtMilk("1");
            recipe1.setAmtCoffee("1");
            recipe1.setAmtSugar("1");
            recipe1.setPrice("1");

            recipe2.setAmtChocolate("1");
            recipe2.setAmtMilk("1");
            recipe2.setAmtCoffee("1");
            recipe2.setAmtSugar("1");
            recipe2.setPrice("1");

        } catch (RecipeException exception) {
            fail();
        }

        boolean areTheSameRecipe = recipe1.equals(recipe2);

        assertFalse(areTheSameRecipe);
    }

    @Test
    public void testEqualsSameObject() {
        Recipe recipe1 = new Recipe();

        recipe1.setName("test");

        assertTrue(recipe1.equals(recipe1));
    }

    @Test
    public void testEqualsNullObject() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = null;

        recipe1.setName("test");

        assertFalse(recipe1.equals(recipe2));
    }

    @Test
    public void testEqualsDifferentClass() {
        Recipe recipe1 = new Recipe();
        int[] array = {};

        assertFalse(recipe1.equals(array));
    }



}
