package com.extremecounting.dungeon.crafting.weapons;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.itemManager.MaterialManager;
import com.extremecounting.dungeon.itemManager.WeaponManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class SpearRecipes {

    public static ShapedRecipe pSpear;

    public static void init() {
        pSpear();
    }

    public static void  pSpear() {

        NamespacedKey namespacedKey = new NamespacedKey(Dungeon.mainNameSpacedKey.getNamespace(), "pspear");

        ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, WeaponManager.pSpear);

        RecipeChoice flintChoice = new RecipeChoice.ExactChoice(MaterialManager.flint);
        RecipeChoice vineChoice = new RecipeChoice.ExactChoice(MaterialManager.vine);
        RecipeChoice driftWoodChoice = new RecipeChoice.ExactChoice(MaterialManager.driftWood);

        shapedRecipe.shape(" B ", " C ", " D ");
        shapedRecipe.setIngredient('B', flintChoice);
        shapedRecipe.setIngredient('C', vineChoice);
        shapedRecipe.setIngredient('D', driftWoodChoice);

        pSpear = shapedRecipe;
    }
}
