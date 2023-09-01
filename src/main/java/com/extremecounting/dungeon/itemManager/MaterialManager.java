package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MaterialManager {

    public static ItemStack driftWood;
    public static ItemStack pebble;
    public static ItemStack flint;
    public static ItemStack vine;
    public static ItemStack clay;
    public static ItemStack sand;
    public static ItemStack shell;
    public static ItemStack bone;
    public static ItemStack clothFiber;
    public static ItemStack rawPork;
    public static ItemStack pigHide;

    public static void init() {
        createPebble();
        createDriftWood();
        createFlint();
        createVine();
        createClay();
        createSand();
        createShell();
        createBone();
        createClothFiber();
        createPork();
        createPigHide();
    }

    private static void createDriftWood() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fDriftwood");
        item.setItemMeta(meta);
        driftWood = item;
    }

    private static void createPebble() {
        ItemStack item = new ItemStack(Material.STONE_BUTTON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fPebble");
        item.setItemMeta(meta);
        pebble = item;
    }

    private static void createFlint() {
        ItemStack item = new ItemStack(Material.FLINT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fFlint");
        item.setItemMeta(meta);
        flint = item;
    }

    private static void createVine() {
        ItemStack item = new ItemStack(Material.VINE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fVines");
        item.setItemMeta(meta);
        vine = item;
    }

    private static void createClay() {
        ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fClay");
        item.setItemMeta(meta);
        clay = item;
    }

    private static void createSand() {
        ItemStack item = new ItemStack(Material.SAND, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSand");
        item.setItemMeta(meta);
        sand = item;
    }

    private static void createShell() {
        ItemStack item = new ItemStack(Material.NAUTILUS_SHELL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSeashell");
        item.setItemMeta(meta);
        shell = item;
    }

    private static void createBone() {
        ItemStack item = new ItemStack(Material.BONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fBone");
        item.setItemMeta(meta);
        bone = item;
    }

    private static void createClothFiber() {
        ItemStack item = new ItemStack(Material.STRING, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fCloth Fiber");
        item.setItemMeta(meta);
        clothFiber = item;
    }

    private static void createPork() {
        ItemStack item = new ItemStack(Material.PORKCHOP, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fRaw Porkchop");
        item.setItemMeta(meta);
        rawPork = item;
    }

    private static void createPigHide() {
        ItemStack item = new ItemStack(Material.LEATHER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fRPig Hide");
        item.setItemMeta(meta);
        pigHide = item;
    }
}
