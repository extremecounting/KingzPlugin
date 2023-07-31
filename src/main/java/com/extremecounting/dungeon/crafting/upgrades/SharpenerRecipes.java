package com.extremecounting.dungeon.crafting.upgrades;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.itemManager.MaterialManager;
import com.extremecounting.dungeon.itemManager.UpgradeManager;
import com.extremecounting.dungeon.itemManager.WeaponManager;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class SharpenerRecipes {


    public static ShapelessRecipe pSharpener;

    public static void init() {
        pSharpener();
    }

    public static void  pSharpener() {

        NamespacedKey namespacedKey = new NamespacedKey(Dungeon.mainNameSpacedKey.getNamespace(), "psharpener");

        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(namespacedKey, UpgradeManager.pSharpener);

        RecipeChoice flintChoice = new RecipeChoice.ExactChoice(MaterialManager.flint);
        RecipeChoice vineChoice = new RecipeChoice.ExactChoice(MaterialManager.vine);

        shapelessRecipe.addIngredient(flintChoice);
        shapelessRecipe.addIngredient(flintChoice);
        shapelessRecipe.addIngredient(flintChoice);
        shapelessRecipe.addIngredient(flintChoice);

        shapelessRecipe.addIngredient(vineChoice);
        shapelessRecipe.addIngredient(vineChoice);


        pSharpener = shapelessRecipe;

    }

}
