package io.github.arnav03mehta.inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import io.github.arnav03mehta.items.ItemManager;


public class TestInventory implements InventoryHolder {

    private final Inventory inv;

    public TestInventory(){
        inv = Bukkit.createInventory(this, 9, "Selection Screen");
        init();
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            inv.setItem(i, ItemManager.acceptPane);
            inv.setItem(8-i, ItemManager.declinePane);
        }
        inv.setItem(4, ItemManager.centerItem);
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
