package io.github.arnav03mehta.Commands;

import io.github.arnav03mehta.items.ImageItem;
import io.github.arnav03mehta.items.ItemManager;
import io.github.arnav03mehta.inventories.TestInventory;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestCommands implements CommandExecutor {

    public static Boolean enabled = false;
    public static Set<String> allCommands = new HashSet<>();

    public static void init() {
        allCommands.add("hello");
        allCommands.add("heal");
        allCommands.add("stonewalk");
        allCommands.add("becomeop");
        allCommands.add("maps");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player only command");
            return true;
        }
        Player player = (Player) sender;

        switch (label) {
            case ("hello") -> {
                player.sendMessage(ChatColor.DARK_AQUA + "What bitch?");
                return true;
            }
            case ("heal") -> {
                double maxHealth =  Objects.requireNonNull(
                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH)
                ).getDefaultValue();
                player.setHealth(maxHealth);
                player.sendMessage(ChatColor.GREEN + "Healed you to max health");
                return true;
            }
            case ("stonewalk") -> {
                if (args.length >= 1) {
                    if (args[0].equalsIgnoreCase("true")) {
                        enabled = true;
                        player.sendMessage(ChatColor.GREEN + "Function Enabled");
                    } else if (args[0].equalsIgnoreCase("false")) {
                        enabled = false;
                        player.sendMessage(ChatColor.RED + "Function Disabled");
                    }
                } else {
                    player.sendMessage("stoneWalk :" + enabled.toString());
                }
                return true;
            }
            case ("becomeop") -> {
                PlayerInventory inventory = player.getInventory();
                inventory.addItem(ItemManager.gapples);
                inventory.addItem(ItemManager.silky);
                inventory.addItem(ItemManager.sword);
                inventory.addItem(ItemManager.fortunePick);
                inventory.setArmorContents(new ItemStack[] {
                        ItemManager.socks,
                        ItemManager.pants,
                        ItemManager.chest,
                        ItemManager.hat,
                });
                player.sendMessage(ChatColor.GREEN + "Gave the stuff");

                return true;
            }

            case ("maps") -> {
                ItemStack map;
                if (args.length >= 1) {
                    map = ImageItem.maps.get(args[0]);
                } else {
                    map = ImageItem.maps.get("devNull");
                    player.sendMessage(ChatColor.GREEN+"All Maps: " +
                            ChatColor.WHITE + ImageItem.maps.keySet().toString());
                }
                try {
                    player.getInventory().addItem(map);
                } catch (IllegalArgumentException exception) {
                    player.sendMessage(ChatColor.RED + "Invalid Map key");
                }
                return true;
            }
            case("openinv") -> {
                TestInventory gui = new TestInventory();
                player.openInventory(gui.getInventory());
                return true;
            }
            default -> { return false; }
        }
    }
}
