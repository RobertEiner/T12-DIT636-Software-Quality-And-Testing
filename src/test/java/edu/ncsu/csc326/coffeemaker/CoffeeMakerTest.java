package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private CoffeeMaker barista;
    private RecipeBook recipeBook;
    private Inventory inventory;
    private Recipe recipe1;
    private Recipe recipe1Duplicate;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipe5;

    @Before
    public void setup() throws Exception {
        // initialize coffee maker
        barista = new CoffeeMaker();

        // initialize recipe book
        recipeBook = new RecipeBook();

        // Initialize inventory
        inventory = new Inventory();

        // First recipe
        recipe1 = new Recipe();
        recipe1.setName("Americano");
        recipe1.setAmtCoffee("2");
        recipe1.setPrice("35");
        recipe1.setAmtMilk("3");
        recipe1.setAmtChocolate("0");
        recipe1.setAmtSugar("0");

        // Second recipe
        recipe2 = new Recipe();
        recipe2.setName("Cappuccino");
        recipe2.setAmtCoffee("2");
        recipe2.setPrice("40");
        recipe2.setAmtMilk("3");
        recipe2.setAmtChocolate("0");
        recipe2.setAmtSugar("0");

        // Third recipe
        recipe3 = new Recipe();
        recipe3.setName("Latte Machiato");
        recipe3.setAmtCoffee("1");
        recipe3.setPrice("45");
        recipe3.setAmtMilk("5");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtSugar("0");

    }

    @Test
    public void testAddRecipe_Normal() {
        boolean recipeAdded = barista.addRecipe(recipe1);
        assertTrue(recipeAdded);
    }

    @Test
    public void testDeleteRecipe_normal() {
        barista.addRecipe(recipe1);
        String nameOfRemoved = barista.deleteRecipe(0);
        assertEquals(recipe1.getName(), nameOfRemoved);
    }


    @Test
    public void testEditRecipe_normal() {
        barista.addRecipe(recipe1);
        String expected = "Latte";
        try {
            recipe1.setName("Latte");
            recipe1.setAmtCoffee("3");
            recipe1.setPrice("2");
            recipe1.setAmtMilk("4");
            recipe1.setAmtChocolate("0");
            recipe1.setAmtSugar("0");
            String nameOfEdited = barista.editRecipe(0, recipe1);
            assertEquals(expected, nameOfEdited);
        } catch (RecipeException e) {
            fail("Shouldn't fail");
        }
    }

    // Inspired by example test
    @Test
    public void testAddInventory_Normal() {
        try {
            barista.addInventory("1", "1", "0", "1");
            String expectedInventory =  "Coffee: 16\nMilk: 16\nSugar: 15\nChocolate: 16\n";
            String actualInventory = barista.checkInventory();
            assertEquals(expectedInventory, actualInventory);
        } catch (InventoryException e) {
            fail("This shouldn't fail");
        }
    }

    // Inspired by example test
    @Test
    public void testAddInventory_ThrowsException() {
        Throwable inventoryExc = assertThrows(InventoryException.class,
                () -> { barista.addInventory("*", "4", "0", "0");
                });
    }

    @Test
    public void testMakeCoffee_normal() {
        int expectedChange = 5;
        barista.addRecipe(recipe1);
        int actualChange = barista.makeCoffee(0, 40);
        assertEquals(expectedChange, actualChange);
    }

    @Test
    public void testMakeCoffee_NoRecipes() {
        int expectedChange = 35;
        int actualChange = barista.makeCoffee(0, 35);
        assertEquals(expectedChange, actualChange);
    }

    @Test
    public void testMakeCoffee_InsufficientFunds() {
        int expectedChange = 27;
        barista.addRecipe(recipe2);
        int actualChange = barista.makeCoffee(0, 27);
        assertEquals(expectedChange, actualChange);
    }

    @Test
    public void testMakeCoffee_InsufficientIngredients() {
        barista.addRecipe(recipe1);
        inventory.setCoffee(0);
        int expectedChange = 35;
        int actualChange = barista.makeCoffee(0, 35);
        assertEquals(expectedChange, actualChange);
    }

    @Test
    public void testGetRecipes_Normal() {
        String expectedRecipes = "Americano\nCappuccino\nLatte Machiato\n";
        String actualRecipes = "";
        barista.addRecipe(recipe1);
        barista.addRecipe(recipe2);
        barista.addRecipe(recipe3);
        Recipe [] recipeArray = barista.getRecipes();
        for(int i = 0; i < 3; i++) {
            actualRecipes += recipeArray[i].toString() + "\n";
        }
        assertEquals(expectedRecipes, actualRecipes);
    }
}
