package io.github.arnav03mehta;

import io.github.arnav03mehta.Commands.TestCommands;
import io.github.arnav03mehta.events.EventTest;
import io.github.arnav03mehta.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();
        TestCommands commands = new TestCommands();
        getServer().getPluginManager().registerEvents(new EventTest(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("openinv").setExecutor(commands);
//        getCommand("hello").setExecutor(commands);
        getCommand("becomeop").setExecutor(commands);
//        getCommand("stonewalk").setExecutor(commands);
//        getCommand("maps").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin Disabled");
    }
}
