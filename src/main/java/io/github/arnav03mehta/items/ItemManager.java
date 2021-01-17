package io.github.arnav03mehta.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemManager {

    public static ItemStack acceptPane;
    public static ItemStack declinePane;
    public static ItemStack centerItem;

    public static ItemStack sword;
    public static ItemStack silky;
    public static ItemStack fortunePick;
    public static ItemStack hat;
    public static ItemStack chest;
    public static ItemStack pants;
    public static ItemStack socks;
    public static ItemStack gapples = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 64);

    public static void init() {
        createSilkPick();
        createFortunePick();
        createSword();
        createBoots();
        createHat();
        createShirt();
        createPants();
        ImageItem.init();
        declinePane = createItem(Material.RED_STAINED_GLASS_PANE,
                ChatColor.RED + "Decline",
                Collections.singletonList(ChatColor.GRAY+"Declines the request"));
        acceptPane = createItem(Material.LIME_STAINED_GLASS_PANE,
                ChatColor.GREEN + "Accept",
                Collections.singletonList(ChatColor.GRAY+"Accepts the request"));
        List<String> lore = new ArrayList<>();
        lore.add("Select either the accept or");
        lore.add("Decline button to make a selection");
        centerItem = createItem(Material.BOOK, "Make a selection", lore);
    }

    private static void createSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Sword");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 40, true);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        item.setItemMeta(itemMeta);
        sword = item;
    }

    private static void createSilkPick() {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Silky Pickaxe");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 40, true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        item.setItemMeta(itemMeta);
        silky = item;
    }

    private static void createFortunePick() {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Fortune Pickaxe");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 40, true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
        item.setItemMeta(itemMeta);
        fortunePick = item;
    }

    private static void createShirt() {
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Shirt");
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 40, true);
        item.setItemMeta(itemMeta);
        chest = item;
    }

    private static void createHat() {
        ItemStack item = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Hat");
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 40, true);
        itemMeta.addEnchant(Enchantment.OXYGEN, 40, true);
        item.setItemMeta(itemMeta);
        hat = item;
    }

    private static void createPants() {
        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Pants");
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 40, true);
        item.setItemMeta(itemMeta);
        pants = item;
    }

    private static void createBoots() {
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "OP Socks");
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.MENDING, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 40, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 40, true);
        itemMeta.addEnchant(Enchantment.SOUL_SPEED, 3, false);
        itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 5, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 40, true);
        item.setItemMeta(itemMeta);
        socks = item;
    }

    public static ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
