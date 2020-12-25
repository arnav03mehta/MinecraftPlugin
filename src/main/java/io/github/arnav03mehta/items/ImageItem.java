package io.github.arnav03mehta.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ImageItem {

    public static final Map<String,BufferedImage> images = new HashMap<>();
    private static final String[] urls = {
            "https://www.dropbox.com/s/qs6rbz5z93wt3qi/kushaan.jpg?dl=1",
            "https://www.dropbox.com/s/crjj5qe6nc9g282/main.jpg?dl=1"
    };
    private static final String[] names = {
            "kushaan",
            "devNull"
    };
    public static Map<String, ItemStack> maps = new HashMap<>();

    public static void init() {

        for (int i = 0; i < urls.length; i++) {
            try {
                images.put(names[i], resizeImage(ImageIO.read(new URL(urls[i]))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String image: images.keySet()){
            maps.put(image, makeMap(images.get(image), image));
        }
    }

    public static BufferedImage resizeImage(Image srcImage) {
        BufferedImage resizedImage = new BufferedImage(128, 128, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(srcImage, 0,0, 128,128, null );
        graphics.dispose();
        return resizedImage;
    }

    private static ItemStack makeMap(BufferedImage image, String name) {
        ItemStack mapItem = new ItemStack(Material.FILLED_MAP, 1);
        MapMeta mapMeta = (MapMeta) mapItem.getItemMeta();
        mapMeta.setDisplayName(ChatColor.AQUA + name);
        MapView mapView = Bukkit.createMap(Bukkit.getWorlds().get(0));
        mapView.setScale(MapView.Scale.FARTHEST);
        mapView.addRenderer(new MapRenderer() {
            @Override
            public void render(MapView map, MapCanvas canvas, Player player) {
                canvas.drawImage(0, 0, resizeImage(image));
            }
        });
        mapMeta.setMapView(mapView);
        mapItem.setItemMeta(mapMeta);
        return mapItem;
    }
}
