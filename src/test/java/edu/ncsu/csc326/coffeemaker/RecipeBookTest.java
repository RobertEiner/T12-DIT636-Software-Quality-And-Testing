package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecipeBookTest {
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipe5;


    private RecipeBook testRecipeBook;

    private final String recipeExceptionMessage = "Recipe Book Exception should not be thrown";

    @Before
    public void Initialize() {
        testRecipeBook = new RecipeBook();
        try {
            recipe1 = new Recipe();
            recipe1.setName("Recipe 1");
            recipe1.setPrice("25");
            recipe1.setAmtCoffee("4");
            recipe1.setAmtMilk("1");
            recipe1.setAmtSugar("10");
            recipe1.setAmtChocolate("5");


        } catch (RecipeException e) {
            fail(recipeExceptionMessage);
        }
    }

    @Test
    public void testAddRecipe_Normal(){
        assertTrue(testRecipeBook.addRecipe(recipe1));
        testRecipeBook.getRecipes()[0] = recipe1;
    }

    @Test
    public void testAddRecipe_DuplicateRecipe(){
        testRecipeBook.addRecipe(recipe1);
        assertFalse(testRecipeBook.addRecipe(recipe1));
        testRecipeBook.getRecipes()[0] = recipe1;
    }

    @Test
    public void testAddRecipe_MaxAmtOfRecipes(){
        try{
            recipe1 = new Recipe();
            recipe1.setName("Recipe 1");
            recipe1.setPrice("25");
            recipe1.setAmtCoffee("4");
            recipe1.setAmtMilk("1");
            recipe1.setAmtSugar("10");
            recipe1.setAmtChocolate("5");

            recipe2 = new Recipe();
            recipe2.setName("Recipe 2");
            recipe2.setPrice("25");
            recipe2.setAmtCoffee("4");
            recipe2.setAmtMilk("1");
            recipe2.setAmtSugar("10");
            recipe2.setAmtChocolate("5");

            recipe3 = new Recipe();
            recipe3.setName("Recipe 3");
            recipe3.setPrice("25");
            recipe3.setAmtCoffee("4");
            recipe3.setAmtMilk("1");
            recipe3.setAmtSugar("10");
            recipe3.setAmtChocolate("5");

            recipe4 = new Recipe();
            recipe4.setName("Recipe 4");
            recipe4.setPrice("25");
            recipe4.setAmtCoffee("4");
            recipe4.setAmtMilk("1");
            recipe4.setAmtSugar("10");
            recipe4.setAmtChocolate("5");

            recipe5 = new Recipe();
            recipe5.setName("Recipe 5");
            recipe5.setPrice("25");
            recipe5.setAmtCoffee("4");
            recipe5.setAmtMilk("1");
            recipe5.setAmtSugar("10");
            recipe5.setAmtChocolate("5");
        } catch (RecipeException e) {
            fail(recipeExceptionMessage);
        }
        assertTrue(testRecipeBook.addRecipe(recipe1));
        assertTrue(testRecipeBook.addRecipe(recipe2));
        assertTrue(testRecipeBook.addRecipe(recipe3));
        assertTrue(testRecipeBook.addRecipe(recipe4));
        assertFalse(testRecipeBook.addRecipe(recipe5));

    }

    @Test
    public void testDeleteRecipe_Normal(){
        testRecipeBook.addRecipe(recipe1);
        assertEquals(recipe1.getName(), testRecipeBook.deleteRecipe(0));
    }

    @Test
    public void testDeleteRecipe_WrongIndex(){
        testRecipeBook.addRecipe(recipe1);
        assertNull(recipe1.getName(), testRecipeBook.deleteRecipe(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteRecipe_IndexOutOfBounds(){
        testRecipeBook.addRecipe(recipe1);
        assertEquals(recipe1.getName(), testRecipeBook.deleteRecipe(5));
    }

    @Test
    public void testEditRecipe_Empty() {
        assertNull(recipe1.getName(), testRecipeBook.editRecipe(1, recipe1));
    }
    @Test
    public void testEditRecipe_Normal() {
        testRecipeBook.addRecipe(recipe1);
        try{
            recipe1 = new Recipe();
            recipe1.setName("New Recipe 1");
            recipe1.setPrice("30");
            recipe1.setAmtCoffee("2");
            recipe1.setAmtMilk("2");
            recipe1.setAmtSugar("20");
            recipe1.setAmtChocolate("10");
            testRecipeBook.editRecipe(0, recipe1);
        } catch (RecipeException e) {
            fail(recipeExceptionMessage);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testEditRecipe_WrongIndex() {
        testRecipeBook.addRecipe(recipe1);
        try{
            recipe1 = new Recipe();
            recipe1.setName("New Recipe 1");
            recipe1.setPrice("30");
            recipe1.setAmtCoffee("2");
            recipe1.setAmtMilk("2");
            recipe1.setAmtSugar("20");
            recipe1.setAmtChocolate("10");
            assertNull(recipe2.getName(), testRecipeBook.editRecipe(1, recipe2));
        } catch (RecipeException e) {
            fail(recipeExceptionMessage);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEditRecipe_IndexOutOfBounds() {
        testRecipeBook.addRecipe(recipe1);
        try{
            recipe1 = new Recipe();
            recipe1.setName("New Recipe 1");
            recipe1.setPrice("30");
            recipe1.setAmtCoffee("2");
            recipe1.setAmtMilk("2");
            recipe1.setAmtSugar("20");
            recipe1.setAmtChocolate("10");
            assertEquals(recipe1.getName(), testRecipeBook.editRecipe(5, recipe1));
        } catch (RecipeException e) {
            fail(recipeExceptionMessage);
        }
    }

    // in order for this test to work, line 77 from RecipeBook.java needs to be removed
    @Test
    public void testEditRecipe_CheckCorrectName() {
        testRecipeBook.addRecipe(recipe1);
        String expected = "Latte";
        try {
            recipe1.setName("Latte");
            recipe1.setPrice("2");
            recipe1.setAmtCoffee("3");
            recipe1.setAmtMilk("4");
            recipe1.setAmtSugar("0");
            recipe1.setAmtChocolate("0");
            testRecipeBook.editRecipe(0, recipe1);
            String nameOfEdited = recipe1.getName();
            assertEquals(expected, nameOfEdited);
        } catch (RecipeException e) {
            fail("Shouldn't fail");
        }
    }


}
