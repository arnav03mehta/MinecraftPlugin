package io.github.arnav03mehta.events;

import io.github.arnav03mehta.Commands.TestCommands;
import io.github.arnav03mehta.items.ImageItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class EventTest implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server noob (" + player.getDisplayName() + ")");
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
    /*
    @EventHandler
    public static void onMapInitialize(MapInitializeEvent event) {
        MapView view = event.getMap();
        view.setScale(MapView.Scale.FARTHEST);
        view.getRenderers().clear();
        view.addRenderer(new MapRenderer() {
            @Override
            public void render(MapView map, MapCanvas canvas, Player player) {
                canvas.drawImage(0, 0, ImageItem.images.get("devNull"));
            }
        });
    }
    */
}
