package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    private Recipe recipe;

    @Before
    public void setUp() {
        inventory = new Inventory();
        recipe = new Recipe();
    }
    @Test
    public void testGetChocolate() {
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testSetChocolateNormal() {
        inventory.setChocolate(10);
        assertEquals(10, inventory.getChocolate());
    }

    @Test
    public void testSetChocolateNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.setChocolate(-5);
                }
        );
        assertEquals(10, inventory.getChocolate());
    }

    @Test
    public void testAddChocolateNormal() {
        inventory.setChocolate(0);
        try {
            inventory.addChocolate("10");
        } catch (InventoryException e) {
            fail("InventoryException shall not be thrown when adding a positive integer");
        }

        assertEquals(10, inventory.getChocolate());
    }

    @Test
    public void testAddChocolateNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addChocolate("-5");
                }
        );
    }

    @Test
    public void testAddChocolateNonInteger() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addChocolate("5.5");
                }
        );
    }

    @Test
    public void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testSetCoffeeNormal() {
        inventory.setCoffee(10);
        assertEquals(10, inventory.getCoffee());
    }

    @Test
    public void testSetCoffeeNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.setCoffee(-5);
                }
        );
        assertEquals(10, inventory.getCoffee());
    }


    @Test
    public void testAddCoffeeNormal() {
        inventory.setCoffee(0);
        try {
            inventory.addCoffee("10");
        } catch (InventoryException e) {
            fail("InventoryException shall not be thrown when adding a positive integer");
        }

        assertEquals(10, inventory.getCoffee());
    }

    @Test
    public void testAddCoffeeNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addCoffee("-5");
                }
        );
    }

    @Test
    public void testAddCoffeeNonInteger() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addCoffee("5.5");
                }
        );
    }

    @Test
    public void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testSetMilkNormal() {
        inventory.setMilk(10);
        assertEquals(10, inventory.getMilk());
    }

    @Test
    public void testSetMilkNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.setMilk(-5);
                }
        );
        assertEquals(10, inventory.getMilk());
    }


    @Test
    public void testAddMilkNormal() {
        inventory.setMilk(0);
        try {
            inventory.addMilk("10");
        } catch (InventoryException e) {
            fail("InventoryException shall not be thrown when adding a positive integer");
        }

        assertEquals(10, inventory.getMilk());
    }

    @Test
    public void testAddMilkNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addMilk("-5");
                }
        );
    }

    @Test
    public void testAddMilkNonInteger() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addMilk("5.5");
                }
        );
    }

    @Test
    public void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testSetSugarNormal() {
        inventory.setSugar(10);
        assertEquals(10, inventory.getSugar());
    }

    @Test
    public void testSetSugarNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.setSugar(-5);
                }
        );
        assertEquals(10, inventory.getSugar());
    }

    @Test
    public void testAddSugarNormal() {
        inventory.setSugar(0);
        try {
            inventory.addSugar("10");
        } catch (InventoryException e) {
            fail("InventoryException shall not be thrown when adding a positive integer");
        }

        assertEquals(10, inventory.getSugar());
    }

    @Test
    public void testAddSugarNegative() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addSugar("-5");
                }
        );
    }

    @Test
    public void testAddSugarNonInteger() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    inventory.addSugar("5.5");
                }
        );
    }

    @Test
    public void testUseIngredientsEnoughIngredients() {
        inventory.setCoffee(1);
        inventory.setMilk(1);
        inventory.setChocolate(1);
        inventory.setSugar(1);

        try {
            recipe.setAmtChocolate("1");
            recipe.setAmtSugar("1");
            recipe.setAmtMilk("1");
            recipe.setAmtCoffee("1");
        } catch (RecipeException e) {
            fail("Setting recipe's parameters to 1 shall not throw exception");
        }

        boolean canUseIngredients = inventory.useIngredients(recipe);

        assertTrue(canUseIngredients);

        int[] expected = {0, 0, 0, 0};
        int[] actual = {inventory.getChocolate(), inventory.getCoffee(), inventory.getMilk(), inventory.getSugar()};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testUseIngredientsNotEnoughIngredients() {
        inventory.setCoffee(1);
        inventory.setMilk(1);
        inventory.setChocolate(1);
        inventory.setSugar(1);

        try {
            recipe.setAmtChocolate("2");
            recipe.setAmtSugar("2");
            recipe.setAmtMilk("2");
            recipe.setAmtCoffee("2");
        } catch (RecipeException e) {
            fail("Setting recipe's parameters to 1 shall not throw exception");
        }

        boolean ingredientsWereUsed = inventory.useIngredients(recipe);

        assertFalse(ingredientsWereUsed);

        int[] expected = {1, 1, 1, 1};
        int[] actual = {inventory.getChocolate(), inventory.getCoffee(), inventory.getMilk(), inventory.getSugar()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToString() {

        inventory.setCoffee(1);
        inventory.setMilk(1);
        inventory.setChocolate(1);
        inventory.setSugar(1);

        String expectedString = "Coffee: 1\nMilk: 1\nSugar: 1\nChocolate: 1\n";
        String actualString = inventory.toString();

        assertEquals(expectedString, actualString);
    }
}
