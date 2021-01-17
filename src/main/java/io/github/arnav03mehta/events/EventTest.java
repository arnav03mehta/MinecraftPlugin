package io.github.arnav03mehta.events;

import io.github.arnav03mehta.Commands.TestCommands;
import io.github.arnav03mehta.inventories.TestInventory;
// import io.github.arnav03mehta.items.ImageItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
//import org.bukkit.event.server.MapInitializeEvent;
//import org.bukkit.map.MapCanvas;
//import org.bukkit.map.MapRenderer;
//import org.bukkit.map.MapView;
// import java.awt.image.BufferedImage;

public class EventTest implements Listener {

    // private static BufferedImage image;

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server noob (" + player.getDisplayName() + ")");
        // image = ImageItem.images.get("devNull");
    }

    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event) {
        if (!(TestCommands.enabled)) { return; }

        Player player = event.getPlayer();
        Material block = player.getWorld().getBlockAt(
                player.getLocation().getBlockX(),
                player.getLocation().getBlockY() - 1 ,
                player.getLocation().getBlockZ()
        ).getType();
        if (block == Material.STONE) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Your are standing on stone");
        }
    }

//    @EventHandler
//    public static void onMapInitialize(MapInitializeEvent event) {
//        MapView view = event.getMap();
//        view.setScale(MapView.Scale.FARTHEST);
//        view.getRenderers().clear();
//        view.addRenderer(new MapRenderer() {
//            @Override
//            public void render(MapView map, MapCanvas canvas, Player player) {
//                canvas.drawImage(0, 0, image);
//            }
//        });
//    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) {return;}
        if (!(event.getClickedInventory().getHolder() instanceof TestInventory)) { return; }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() == null) { return; }
        if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
            player.closeInventory();
            player.sendMessage(ChatColor.GREEN + "You accepted");
        } else if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
            player.closeInventory();
            player.sendMessage(ChatColor.RED + "You declined");
        }
    }
}
