package be.razerstorm.randomcrafts.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Util {

    private static final Random random = new Random();

    public static ItemStack getRandomItem() {
        Material[] materials = Material.values();
        int randomIndex = random.nextInt(materials.length);
        return new ItemStack(materials[randomIndex]);
    }
}
